package com.tencent.aelight.camera.ae.camera.ui.poi;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicFragmentActivityCallBackInterface;
import com.tencent.mobileqq.activity.PublicFragmentActivityForPeak;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.immersive.SystemBarCompact;
import mqq.os.MqqHandler;

public class AESelectLocationFragment
  extends PublicBaseFragment
  implements TextWatcher, View.OnClickListener, PublicFragmentActivityCallBackInterface
{
  private AESelectionLocationAdapter a;
  private RecyclerView b;
  private View c;
  private EditText d;
  private View e;
  private TextView f;
  private ImageView g;
  private ProgressBar h;
  private String i;
  
  public static void a(Context paramContext, int paramInt)
  {
    PublicFragmentActivity.Launcher.a(paramContext, new Intent(), PublicFragmentActivityForPeak.class, AESelectLocationFragment.class, paramInt);
  }
  
  private void a(View paramView)
  {
    this.b = ((RecyclerView)paramView.findViewById(2063991404));
    this.c = paramView.findViewById(2063990901);
    this.d = ((EditText)paramView.findViewById(2063991412));
    this.f = ((TextView)paramView.findViewById(2063991528));
    this.e = paramView.findViewById(2063991005);
    this.g = ((ImageView)paramView.findViewById(2063990968));
    this.h = ((ProgressBar)paramView.findViewById(2063991052));
    this.g.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.addTextChangedListener(this);
    if (this.b == null)
    {
      AEQLog.a("AESelectLocationFragment", "mRecycleView is null ");
      return;
    }
    paramView = new LinearLayoutManager(getBaseActivity(), 1, false);
    this.b.setLayoutManager(paramView);
    this.a = new AESelectionLocationAdapter(getBaseActivity());
    this.b.setAdapter(this.a);
    this.a.a(new AESelectLocationFragment.2(this));
  }
  
  private void a(String paramString)
  {
    if (!NetworkUtil.isNetworkAvailable(getBaseActivity()))
    {
      AEQLog.b("AESelectLocationFragment", "requestPoiList---no network");
      ThreadManager.getUIHandler().post(new AESelectLocationFragment.3(this));
      return;
    }
    this.b.setVisibility(8);
    this.h.setVisibility(0);
    ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(new AESelectLocationFragment.4(this, "qzone_address_select", false, paramString));
  }
  
  private void b(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setSelectResult");
    ((StringBuilder)localObject).append(paramString);
    AEQLog.a("AESelectLocationFragment", ((StringBuilder)localObject).toString());
    AEBaseDataReporter localAEBaseDataReporter = AEBaseDataReporter.a();
    if (paramString == null) {
      localObject = "none";
    } else {
      localObject = paramString;
    }
    localAEBaseDataReporter.r((String)localObject);
    localObject = new Intent();
    ((Intent)localObject).putExtra("key_select_poi", paramString);
    getBaseActivity().setResult(-1, (Intent)localObject);
    getBaseActivity().finish();
  }
  
  void a()
  {
    BaseActivity localBaseActivity = getBaseActivity();
    if ((localBaseActivity != null) && ((localBaseActivity instanceof PublicFragmentActivity)))
    {
      SystemBarCompact localSystemBarCompact = ((PublicFragmentActivity)localBaseActivity).mSystemBarComp;
      localBaseActivity.mSystemBarComp.setStatusBarColor(-1);
      b();
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onTextChanged :");
    localStringBuilder.append(paramEditable);
    AEQLog.a("AESelectLocationFragment", localStringBuilder.toString());
    this.f.setText(paramEditable);
    this.i = paramEditable.toString();
    if ((this.d.getText() != null) && (!this.d.getText().toString().equals("")))
    {
      this.g.setVisibility(0);
      this.e.setVisibility(0);
    }
    else
    {
      this.e.setVisibility(8);
      this.g.setVisibility(4);
    }
    a(this.i);
  }
  
  @TargetApi(23)
  public void b()
  {
    getBaseActivity().getWindow().getDecorView().setSystemUiVisibility(9216);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onBackPressed()
  {
    getBaseActivity().finish();
  }
  
  public void onClick(View paramView)
  {
    paramView.getId();
    int j = paramView.getId();
    if (j != 2063990901)
    {
      if (j != 2063990968)
      {
        if (j != 2063991005) {
          return;
        }
        b(this.i);
        return;
      }
      this.d.setText("");
      return;
    }
    AEBaseDataReporter.a().aF();
    getBaseActivity().finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT > 23) {
      getBaseActivity().getWindow().setBackgroundDrawable(null);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2064056333, paramViewGroup, false);
    a(paramLayoutInflater);
    ViewCompat.setOnApplyWindowInsetsListener(paramLayoutInflater, new AESelectLocationFragment.1(this));
    ViewCompat.requestApplyInsets(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onPause()
  {
    super.onPause();
    InputMethodUtil.b(this.d);
  }
  
  public void onResume()
  {
    super.onResume();
    AEBaseDataReporter.a().aE();
    a();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    a(paramView);
    a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.poi.AESelectLocationFragment
 * JD-Core Version:    0.7.0.1
 */