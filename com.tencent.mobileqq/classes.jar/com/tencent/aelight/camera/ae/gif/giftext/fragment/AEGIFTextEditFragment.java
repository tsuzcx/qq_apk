package com.tencent.aelight.camera.ae.gif.giftext.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.aelight.camera.ae.AEViewModelProviders;
import com.tencent.aelight.camera.ae.config.CameraPeakServiceHandler;
import com.tencent.aelight.camera.ae.gif.AEStoryGIFPreviewActivity;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFOutlineTextView;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextMvp;
import com.tencent.aelight.camera.ae.gif.giftext.adapter.AEGIFTextColorAdapter;
import com.tencent.aelight.camera.ae.gif.giftext.viewmodel.AEGIFTextEditViewModel;
import com.tencent.aelight.camera.ae.gif.video.PngCreateResult.PngResultItem;
import com.tencent.aelight.camera.ae.gif.video.PngsTextDrawer;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.widget.immersive.SystemBarTintManager;

public class AEGIFTextEditFragment
  extends Fragment
{
  AEGIFTextEditViewModel a;
  private AEStoryGIFPreviewActivity b;
  private ViewGroup c;
  private EditText d;
  private ImageView e;
  private RecyclerView f;
  private RelativeLayout g;
  private RelativeLayout h;
  private AEGIFTextColorAdapter i;
  private AEGIFTextMvp j;
  private String k;
  private String l;
  private int m;
  private QQCustomDialog n;
  private Dialog o;
  private AEGIFTextEditFragment.TextValidCallback p;
  private View q;
  private String r = null;
  private boolean s = false;
  private float t = 0.0F;
  private float u = 1.0F;
  private float v = 0.82F;
  private float w = 0.16F;
  
  private int a(char paramChar)
  {
    if ((paramChar != '\n') && (paramChar != '\r'))
    {
      if (paramChar < '') {
        return 1;
      }
      return 2;
    }
    return 0;
  }
  
  public static AEGIFTextEditFragment a(String paramString1, boolean paramBoolean, View paramView, String paramString2)
  {
    paramString1 = a(paramString1, paramBoolean, paramString2);
    paramString1.b(paramView);
    return paramString1;
  }
  
  public static AEGIFTextEditFragment a(String paramString1, boolean paramBoolean, String paramString2)
  {
    AEGIFTextEditFragment localAEGIFTextEditFragment = new AEGIFTextEditFragment();
    Bundle localBundle = new Bundle();
    localBundle.putString("KEY_PNG_DIR_PATH", paramString1);
    localBundle.putBoolean("KEY_IS_MULTIPLE", paramBoolean);
    if (!TextUtils.isEmpty(paramString2)) {
      localBundle.putString("KEY_FONT_ID", paramString2);
    }
    localAEGIFTextEditFragment.setArguments(localBundle);
    return localAEGIFTextEditFragment;
  }
  
  private void a(int paramInt)
  {
    this.h.post(new AEGIFTextEditFragment.13(this, paramInt));
  }
  
  private void a(AEGIFTextEditFragment.TextValidCallback paramTextValidCallback)
  {
    this.p = paramTextValidCallback;
  }
  
  private void a(String paramString1, String paramString2)
  {
    AEBaseReportParam.a().A(paramString1);
    AEBaseReportParam.a().B(paramString2);
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = this.d.getText().toString();
    if (paramBoolean)
    {
      if (((String)localObject).equals(""))
      {
        localObject = this.j;
        if (localObject != null) {
          ((AEGIFTextMvp)localObject).d();
        }
        this.a.d();
        a("none", this.i.a());
        getFragmentManager().popBackStack();
        return;
      }
      e();
      b((String)localObject);
      return;
    }
    getFragmentManager().popBackStack();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        i();
        Object localObject = (PngCreateResult.PngResultItem)this.a.c().getValue();
        if ((localObject != null) && (((PngCreateResult.PngResultItem)localObject).a != null)) {
          FileUtils.deleteDirectory(((PngCreateResult.PngResultItem)localObject).a);
        }
        localObject = new PngsTextDrawer(this.r);
        c();
        String str = this.d.getText().toString();
        ((PngsTextDrawer)localObject).a(str, 55, this.i.a(), this.i.c(), DisplayUtil.a(getActivity(), 4.0F), this.l, this.t, this.v, this.u, this.w);
        ((PngsTextDrawer)localObject).a(new AEGIFTextEditFragment.3(this, str));
        return;
      }
      this.o.dismiss();
      this.b.runOnUiThread(new AEGIFTextEditFragment.4(this));
      return;
    }
    this.o.dismiss();
    f();
  }
  
  private void b()
  {
    ((InputMethodManager)this.b.getSystemService("input_method")).toggleSoftInput(1, 2);
  }
  
  private void b(View paramView)
  {
    this.q = paramView;
  }
  
  private void b(String paramString)
  {
    AppInterface localAppInterface = QQStoryContext.k();
    CameraPeakServiceHandler localCameraPeakServiceHandler = (CameraPeakServiceHandler)localAppInterface.getBusinessHandler(PeakAppInterface.e);
    localAppInterface.addObserver(new AEGIFTextEditFragment.11(this, localAppInterface));
    localCameraPeakServiceHandler.c(paramString);
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.o.dismiss();
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        i();
        getFragmentManager().popBackStack();
        return;
      }
      this.b.runOnUiThread(new AEGIFTextEditFragment.5(this));
      return;
    }
    f();
  }
  
  private void c()
  {
    if (((AEGIFOutlineTextView)this.q.findViewById(2063991291) != null) && (this.d.getText().toString().indexOf('\n') > 0))
    {
      this.v = 0.73F;
      this.w = 0.3F;
    }
  }
  
  private void d()
  {
    ((InputMethodManager)this.b.getSystemService("input_method")).hideSoftInputFromWindow(this.b.getWindow().getDecorView().getRootView().getWindowToken(), 0);
  }
  
  private void e()
  {
    this.o = new Dialog(this.b, 2131953338);
    this.o.setCancelable(false);
    this.o.setCanceledOnTouchOutside(false);
    this.o.setContentView(2064056505);
    this.o.show();
  }
  
  private void f()
  {
    this.n = DialogUtil.a(this.b, 230);
    this.n.setMessage(HardCodeUtil.a(2131898246));
    this.n.setCanceledOnTouchOutside(false);
    this.n.setPositiveButton(HardCodeUtil.a(2131898245), new AEGIFTextEditFragment.6(this));
    this.n.show();
  }
  
  private void g()
  {
    this.a = ((AEGIFTextEditViewModel)AEViewModelProviders.a(this.b).get(AEGIFTextEditViewModel.class));
  }
  
  private void h()
  {
    this.g = ((RelativeLayout)this.c.findViewById(2063991382));
    this.h = ((RelativeLayout)this.c.findViewById(2063991388));
    this.e = ((ImageView)this.c.findViewById(2063990932));
    this.f = ((RecyclerView)this.c.findViewById(2063991402));
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this.b, 0, false);
    this.f.setLayoutManager(localLinearLayoutManager);
    this.i = new AEGIFTextColorAdapter(this.b, this.f);
    this.i.a(this.m);
    this.f.setAdapter(this.i);
    this.c.findViewById(2063991484).setOnClickListener(new AEGIFTextEditFragment.7(this));
    this.c.findViewById(2063991485).setOnClickListener(new AEGIFTextEditFragment.8(this));
    this.e.setOnClickListener(new AEGIFTextEditFragment.9(this));
  }
  
  private void i()
  {
    String str1 = this.d.getText().toString();
    String str2 = this.i.a();
    int i1 = this.i.b();
    String str3 = this.i.c();
    if (this.j != null) {
      this.b.runOnUiThread(new AEGIFTextEditFragment.10(this, str1, str2, str3, i1));
    }
    this.a.a(str1, i1);
    a(str1, str2);
  }
  
  private int j()
  {
    Activity localActivity = getActivity();
    if ((localActivity != null) && (!localActivity.isFinishing()) && (SystemBarTintManager.hasNavBar(localActivity))) {
      return SystemBarTintManager.getNavigationBarHeight(localActivity);
    }
    return 0;
  }
  
  protected int a()
  {
    return 2064056481;
  }
  
  public void a(View paramView)
  {
    paramView.getViewTreeObserver().addOnGlobalLayoutListener(new AEGIFTextEditFragment.12(this, paramView));
  }
  
  public void a(AEGIFTextMvp paramAEGIFTextMvp)
  {
    this.j = paramAEGIFTextMvp;
  }
  
  public void a(String paramString)
  {
    this.d = ((EditText)this.c.findViewById(2063991425));
    this.i.a(this.d);
    this.d.setText(this.k);
    this.d.setTextColor(Color.parseColor(paramString));
    this.d.setSelection(this.k.length());
    if (this.d.length() > 0)
    {
      paramString = this.e;
      if (paramString != null) {
        paramString.setVisibility(0);
      }
    }
    this.d.setFilters(new InputFilter[] { new AEGIFTextEditFragment.LengthInputFilter(this) });
    this.d.addTextChangedListener(new AEGIFTextEditFragment.14(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.r = getArguments().getString("KEY_PNG_DIR_PATH");
    this.s = getArguments().getBoolean("KEY_IS_MULTIPLE", false);
    if (getArguments().containsKey("KEY_FONT_ID")) {
      this.l = getArguments().getString("KEY_FONT_ID");
    }
    this.b = ((AEStoryGIFPreviewActivity)getActivity());
    g();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.c = ((ViewGroup)paramLayoutInflater.inflate(a(), paramViewGroup, false));
    paramLayoutInflater = this.j;
    if (paramLayoutInflater != null)
    {
      this.k = paramLayoutInflater.g();
      this.m = this.j.h();
    }
    else
    {
      this.k = ((String)this.a.b().getValue());
    }
    h();
    a(this.i.a());
    b();
    return this.c;
  }
  
  public void onPause()
  {
    super.onPause();
    d();
  }
  
  public void onResume()
  {
    super.onResume();
    this.d.requestFocus();
    AEBaseDataReporter localAEBaseDataReporter = AEBaseDataReporter.a();
    String str;
    if (this.s) {
      str = "recommend";
    } else {
      str = "edit";
    }
    localAEBaseDataReporter.o(str);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.c.setOnTouchListener(new AEGIFTextEditFragment.1(this));
    a(new AEGIFTextEditFragment.2(this));
    a(this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.fragment.AEGIFTextEditFragment
 * JD-Core Version:    0.7.0.1
 */