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
import com.tencent.widget.immersive.SystemBarCompact;
import mqq.os.MqqHandler;

public class AESelectLocationFragment
  extends PublicBaseFragment
  implements TextWatcher, View.OnClickListener, PublicFragmentActivityCallBackInterface
{
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AESelectionLocationAdapter jdField_a_of_type_ComTencentAelightCameraAeCameraUiPoiAESelectionLocationAdapter;
  private String jdField_a_of_type_JavaLangString;
  private View b;
  
  public static void a(Context paramContext, int paramInt)
  {
    PublicFragmentActivity.Launcher.a(paramContext, new Intent(), PublicFragmentActivityForPeak.class, AESelectLocationFragment.class, paramInt);
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2064122587));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2064121971);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramView.findViewById(2064122604));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2064122754));
    this.b = paramView.findViewById(2064122091);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2064122045));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2064122163));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this);
    if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView == null)
    {
      AEQLog.a("AESelectLocationFragment", "mRecycleView is null ");
      return;
    }
    paramView = new LinearLayoutManager(getBaseActivity(), 1, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(paramView);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPoiAESelectionLocationAdapter = new AESelectionLocationAdapter(getBaseActivity());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPoiAESelectionLocationAdapter);
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPoiAESelectionLocationAdapter.a(new AESelectLocationFragment.2(this));
  }
  
  private void a(String paramString)
  {
    if (!NetworkUtil.isNetworkAvailable(getBaseActivity()))
    {
      AEQLog.b("AESelectLocationFragment", "requestPoiList---no network");
      ThreadManager.getUIHandler().post(new AESelectLocationFragment.3(this));
      return;
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
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
    localAEBaseDataReporter.p((String)localObject);
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
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramEditable);
    this.jdField_a_of_type_JavaLangString = paramEditable.toString();
    if ((this.jdField_a_of_type_AndroidWidgetEditText.getText() != null) && (!this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().equals("")))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.b.setVisibility(0);
    }
    else
    {
      this.b.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    a(this.jdField_a_of_type_JavaLangString);
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
    int i = paramView.getId();
    if (i != 2064121971)
    {
      if (i != 2064122045)
      {
        if (i != 2064122091) {
          return;
        }
        b(this.jdField_a_of_type_JavaLangString);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      return;
    }
    AEBaseDataReporter.a().aA();
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
    paramLayoutInflater = paramLayoutInflater.inflate(2064318473, paramViewGroup, false);
    a(paramLayoutInflater);
    ViewCompat.setOnApplyWindowInsetsListener(paramLayoutInflater, new AESelectLocationFragment.1(this));
    ViewCompat.requestApplyInsets(paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onResume()
  {
    super.onResume();
    AEBaseDataReporter.a().az();
    a();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    a(paramView);
    a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.poi.AESelectLocationFragment
 * JD-Core Version:    0.7.0.1
 */