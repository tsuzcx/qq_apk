package com.tencent.gdtad.api.motivebrowsing;

import acqx;
import acqy;
import acqz;
import acra;
import acrb;
import acrf;
import acrj;
import acsg;
import agej;
import amlr;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import axtu;
import axtv;
import bhlq;
import bhpc;
import binq;
import birg;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter;
import com.tencent.mobileqq.mvvm.LifeCycleFragment;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gdtad/api/motivebrowsing/GdtMotiveBrowsingFragment;", "Lcom/tencent/mobileqq/webview/swift/WebViewFragment;", "()V", "countDownTime", "", "hasCountDownComplete", "", "lifeCycleFragment", "Lcom/tencent/mobileqq/mvvm/LifeCycleFragment;", "mModel", "Lcom/tencent/gdtad/api/motivevideo/GdtMotiveVideoModel;", "mQQCustomDialog", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "titleContainer", "Lcom/tencent/gdtad/api/motivebrowsing/GdtMotiveBrowsingTitle;", "viewModel", "Lcom/tencent/gdtad/api/motivebrowsing/GdtMotiveBrowsingViewModel;", "doCreateLoopStep_Final", "extraData", "Landroid/os/Bundle;", "doOnBackEvent", "", "doOnCreate", "savedInstanceState", "handleMotiveBrowsingData", "browsingData", "Lcom/tencent/gdtad/api/motivebrowsing/MotiveBrowsingData;", "initData", "initTitle", "initViewModel", "onDestroy", "onDialogCancelClick", "onDialogConfirmClick", "sendRewardedCallback", "shouldOverrideUrlLoading", "view", "Lcom/tencent/smtt/sdk/WebView;", "url", "", "watchTimeNotCompleteMention", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class GdtMotiveBrowsingFragment
  extends WebViewFragment
{
  public static final acqx a;
  private int jdField_a_of_type_Int;
  private acrf jdField_a_of_type_Acrf;
  private acsg jdField_a_of_type_Acsg;
  private bhpc jdField_a_of_type_Bhpc;
  private GdtMotiveBrowsingTitle jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingTitle;
  private LifeCycleFragment jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Acqx = new acqx(null);
  }
  
  private final void a(acrj paramacrj)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GdtMotiveBrowsingFragment", 2, "handleMotiveBrowsingData browsingData: " + paramacrj);
    }
    int i = paramacrj.a();
    String str = paramacrj.a();
    int j = paramacrj.b();
    switch (i)
    {
    default: 
      return;
    case 0: 
      this.webView.evaluateJavascript(str, (ValueCallback)acqy.a);
      return;
    }
    if (j <= 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (((GdtMotiveBrowsingFragment)this).jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingTitle == null) {
        d();
      }
      paramacrj = this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingTitle;
      if (paramacrj == null) {
        Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
      }
      paramacrj.a(j);
      return;
    }
  }
  
  private final void b()
  {
    Object localObject = getActivity();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "activity");
    this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment = axtu.a((FragmentActivity)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("lifeCycleFragment");
    }
    localObject = axtv.a((ViewModelStoreOwner)localObject).get(acrf.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ofViewModelProvider(life…ingViewModel::class.java)");
    this.jdField_a_of_type_Acrf = ((acrf)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("lifeCycleFragment");
    }
    ArkAppNotifyCenter.setNotify("com.tencent.weather_v2", new WeakReference(new amlr((LifeCycleFragment)localObject)));
  }
  
  private final void c()
  {
    Object localObject = this.intent.getSerializableExtra("data");
    if (!(localObject instanceof GdtMotiveVideoPageData))
    {
      getActivity().finish();
      return;
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Acsg = new acsg((GdtMotiveVideoPageData)GdtMotiveVideoPageData.class.cast(localObject));
        localObject = this.jdField_a_of_type_Acsg;
        if (localObject == null) {
          break label173;
        }
        localObject = ((acsg)localObject).a();
        if (localObject == null) {
          break label173;
        }
        i = ((GdtMotiveVideoPageData)localObject).getVideoCountDown();
      }
      catch (Throwable localThrowable)
      {
        acrf localacrf;
        QLog.d("GdtMotiveBrowsingFragment", 1, localThrowable, new Object[0]);
        return;
      }
      this.jdField_a_of_type_Int = j;
      localObject = this.jdField_a_of_type_Acrf;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
      }
      ((acrf)localObject).a(this.jdField_a_of_type_Int);
      localObject = this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("lifeCycleFragment");
      }
      localObject = (LifecycleOwner)localObject;
      localacrf = this.jdField_a_of_type_Acrf;
      if (localacrf == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
      }
      axtv.a((LifecycleOwner)localObject, (LiveData)localacrf.a(), (Function1)new GdtMotiveBrowsingFragment.initData.1((GdtMotiveBrowsingFragment)this));
      return;
      label173:
      int i = 0;
      int j = i;
      if (i <= 0) {
        j = 15;
      }
    }
  }
  
  private final void d()
  {
    Object localObject = getActivity();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "activity");
    this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingTitle = new GdtMotiveBrowsingTitle((Context)localObject);
    localObject = this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingTitle;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
    }
    ((GdtMotiveBrowsingTitle)localObject).setOnCloseClickListener((Function0)new GdtMotiveBrowsingFragment.initTitle.1((GdtMotiveBrowsingFragment)this));
    localObject = (ViewGroup)this.mUIStyleHandler.d.findViewById(2131381335);
    GdtMotiveBrowsingTitle localGdtMotiveBrowsingTitle = this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingTitle;
    if (localGdtMotiveBrowsingTitle == null) {
      Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
    }
    ((ViewGroup)localObject).addView((View)localGdtMotiveBrowsingTitle);
    int i = agej.a(63.0F, getResources());
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i = ImmersiveUtils.getStatusBarHeight((Context)getActivity()) + i;
    }
    for (;;)
    {
      this.webView.setPadding(0, i, 0, 0);
      localObject = this.mSwiftTitleUI.a;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "mSwiftTitleUI.titleContainer");
      ((ViewGroup)localObject).setVisibility(8);
      localObject = getActivity();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "activity");
      ImmersiveUtils.a(((FragmentActivity)localObject).getWindow(), true);
      localObject = getActivity();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "activity");
      ImmersiveUtils.a(true, ((FragmentActivity)localObject).getWindow());
      return;
    }
  }
  
  private final void e()
  {
    Object localObject = this.jdField_a_of_type_Bhpc;
    if (localObject != null) {
      ((bhpc)localObject).dismiss();
    }
    this.jdField_a_of_type_Bhpc = bhlq.a((Context)getActivity(), 0, null, (CharSequence)getResources().getString(2131692598), getResources().getString(2131692595), getResources().getString(2131692596), (DialogInterface.OnClickListener)new acqz(this), (DialogInterface.OnClickListener)new acra(this));
    localObject = this.jdField_a_of_type_Bhpc;
    if (localObject != null)
    {
      ((bhpc)localObject).show();
      localObject = ((bhpc)localObject).getWindow();
      if (localObject != null)
      {
        localObject = ((Window)localObject).getDecorView();
        if (localObject != null) {
          ((View)localObject).setSystemUiVisibility(7942);
        }
      }
      localObject = this.jdField_a_of_type_Acrf;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
      }
      ((acrf)localObject).a();
    }
    localObject = this.jdField_a_of_type_Bhpc;
    if (localObject != null) {
      ((bhpc)localObject).setOnDismissListener((DialogInterface.OnDismissListener)new acrb(this));
    }
  }
  
  private final void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GdtMotiveBrowsingFragment", 2, "DialogInterface onClick confirm");
    }
    bhpc localbhpc = this.jdField_a_of_type_Bhpc;
    if (localbhpc != null) {
      localbhpc.dismiss();
    }
    this.jdField_a_of_type_Bhpc = ((bhpc)null);
  }
  
  private final void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GdtMotiveBrowsingFragment", 2, "DialogInterface onClick onCancel");
    }
    h();
    super.doOnBackEvent();
  }
  
  private final void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GdtMotiveBrowsingFragment", 2, "sendRewardedCallback");
    }
    Object localObject1 = this.jdField_a_of_type_Acsg;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((acsg)localObject1).a();
      if (localObject1 != null)
      {
        localObject1 = ((GdtMotiveVideoPageData)localObject1).motiveBrowsingKey;
        if (localObject1 != null)
        {
          localObject2 = StringsKt.split$default((CharSequence)localObject1, new String[] { "#" }, false, 0, 6, null);
          if (((Collection)localObject2).isEmpty()) {
            break label165;
          }
        }
      }
    }
    label165:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject2 = new Intent((String)((List)localObject2).get(0));
        ((Intent)localObject2).putExtra("duration_time", this.jdField_a_of_type_Int * 1000L);
        ((Intent)localObject2).putExtra("elapsed_time", this.jdField_a_of_type_Int * 1000L);
        ((Intent)localObject2).putExtra("profitable_flag", this.jdField_a_of_type_Boolean);
        ((Intent)localObject2).putExtra("KEY_MOTIVE_BROWSING", (String)localObject1);
        getActivity().sendBroadcast((Intent)localObject2);
      }
      return;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public int doCreateLoopStep_Final(@Nullable Bundle paramBundle)
  {
    int i = super.doCreateLoopStep_Final(paramBundle);
    d();
    return i;
  }
  
  public void doOnBackEvent()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      e();
      return;
    }
    h();
    super.doOnBackEvent();
  }
  
  public boolean doOnCreate(@Nullable Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    b();
    c();
    return bool;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    bhpc localbhpc = this.jdField_a_of_type_Bhpc;
    if (localbhpc != null) {
      localbhpc.dismiss();
    }
    this.jdField_a_of_type_Bhpc = ((bhpc)null);
  }
  
  public boolean shouldOverrideUrlLoading(@Nullable WebView paramWebView, @Nullable String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GdtMotiveBrowsingFragment", 2, "shouldOverrideUrlLoading " + paramString);
    }
    if ((this.isDestroyed) || (this.webView == null)) {}
    while (paramString == null) {
      return true;
    }
    acrf localacrf = this.jdField_a_of_type_Acrf;
    if (localacrf == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    }
    if (!localacrf.a(paramString, this.jdField_a_of_type_Acsg)) {
      return super.shouldOverrideUrlLoading(paramWebView, paramString);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.motivebrowsing.GdtMotiveBrowsingFragment
 * JD-Core Version:    0.7.0.1
 */