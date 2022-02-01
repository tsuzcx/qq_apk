package com.tencent.gdtad.api.motivebrowsing;

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
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.gdtad.api.motivevideo.GdtADFlyingStreamingReportHelper;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoModel;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.weather.webpage.WeatherArkNotify;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter;
import com.tencent.mobileqq.mvvm.ActivityExtKt;
import com.tencent.mobileqq.mvvm.LifeCycleExtKt;
import com.tencent.mobileqq.mvvm.LifeCycleFragment;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gdtad/api/motivebrowsing/GdtMotiveBrowsingFragment;", "Lcom/tencent/mobileqq/webview/swift/WebViewFragment;", "()V", "countDownTime", "", "hasCountDownComplete", "", "isError", "isSuccess", "lifeCycleFragment", "Lcom/tencent/mobileqq/mvvm/LifeCycleFragment;", "mIsReportLoadingFinishEvent", "mModel", "Lcom/tencent/gdtad/api/motivevideo/GdtMotiveVideoModel;", "mQQCustomDialog", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "titleContainer", "Lcom/tencent/gdtad/api/motivebrowsing/GdtMotiveBrowsingTitle;", "viewModel", "Lcom/tencent/gdtad/api/motivebrowsing/GdtMotiveBrowsingViewModel;", "doCreateLoopStep_Final", "extraData", "Landroid/os/Bundle;", "doOnBackEvent", "", "doOnCreate", "savedInstanceState", "handleMotiveBrowsingData", "browsingData", "Lcom/tencent/gdtad/api/motivebrowsing/MotiveBrowsingData;", "initData", "initTitle", "initViewModel", "onDestroy", "onDialogCancelClick", "onDialogConfirmClick", "onPageFinished", "view", "Lcom/tencent/smtt/sdk/WebView;", "url", "", "onReceivedError", "errorCode", "description", "failingUrl", "sendRewardedCallback", "shouldOverrideUrlLoading", "watchTimeNotCompleteMention", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class GdtMotiveBrowsingFragment
  extends WebViewFragment
{
  public static final GdtMotiveBrowsingFragment.Companion a;
  private int jdField_a_of_type_Int;
  private GdtMotiveBrowsingTitle jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingTitle;
  private GdtMotiveBrowsingViewModel jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingViewModel;
  private GdtMotiveVideoModel jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel;
  private LifeCycleFragment jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  
  static
  {
    jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingFragment$Companion = new GdtMotiveBrowsingFragment.Companion(null);
  }
  
  private final void a(MotiveBrowsingData paramMotiveBrowsingData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GdtMotiveBrowsingFragment", 2, "handleMotiveBrowsingData browsingData: " + paramMotiveBrowsingData);
    }
    int i = paramMotiveBrowsingData.a();
    String str = paramMotiveBrowsingData.a();
    int j = paramMotiveBrowsingData.b();
    switch (i)
    {
    default: 
      return;
    case 0: 
      this.webView.evaluateJavascript(str, (ValueCallback)GdtMotiveBrowsingFragment.handleMotiveBrowsingData.1.a);
      return;
    }
    if (j <= 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (((GdtMotiveBrowsingFragment)this).jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingTitle == null) {
        d();
      }
      paramMotiveBrowsingData = this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingTitle;
      if (paramMotiveBrowsingData == null) {
        Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
      }
      paramMotiveBrowsingData.a(j);
      return;
    }
  }
  
  private final void b()
  {
    Object localObject = getActivity();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "activity");
    this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment = ActivityExtKt.a((FragmentActivity)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("lifeCycleFragment");
    }
    localObject = LifeCycleExtKt.a((ViewModelStoreOwner)localObject).get(GdtMotiveBrowsingViewModel.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ofViewModelProvider(life…ingViewModel::class.java)");
    this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingViewModel = ((GdtMotiveBrowsingViewModel)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("lifeCycleFragment");
    }
    ArkAppNotifyCenter.setNotify("com.tencent.weather_v2", new WeakReference(new WeatherArkNotify((LifeCycleFragment)localObject)));
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
        this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel = new GdtMotiveVideoModel((GdtMotiveVideoPageData)GdtMotiveVideoPageData.class.cast(localObject));
        GdtADFlyingStreamingReportHelper.a().a(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel);
        localObject = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel;
        if (localObject == null) {
          break label183;
        }
        localObject = ((GdtMotiveVideoModel)localObject).a();
        if (localObject == null) {
          break label183;
        }
        i = ((GdtMotiveVideoPageData)localObject).getVideoCountDown();
      }
      catch (Throwable localThrowable)
      {
        GdtMotiveBrowsingViewModel localGdtMotiveBrowsingViewModel;
        QLog.d("GdtMotiveBrowsingFragment", 1, localThrowable, new Object[0]);
        return;
      }
      this.jdField_a_of_type_Int = j;
      localObject = this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingViewModel;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
      }
      ((GdtMotiveBrowsingViewModel)localObject).a(this.jdField_a_of_type_Int);
      localObject = this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("lifeCycleFragment");
      }
      localObject = (LifecycleOwner)localObject;
      localGdtMotiveBrowsingViewModel = this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingViewModel;
      if (localGdtMotiveBrowsingViewModel == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
      }
      LifeCycleExtKt.a((LifecycleOwner)localObject, (LiveData)localGdtMotiveBrowsingViewModel.a(), (Function1)new GdtMotiveBrowsingFragment.initData.1((GdtMotiveBrowsingFragment)this));
      return;
      label183:
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
    localObject = (ViewGroup)this.mUIStyleHandler.d.findViewById(2131381873);
    GdtMotiveBrowsingTitle localGdtMotiveBrowsingTitle = this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingTitle;
    if (localGdtMotiveBrowsingTitle == null) {
      Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
    }
    ((ViewGroup)localObject).addView((View)localGdtMotiveBrowsingTitle);
    int i = AIOUtils.a(63.0F, getResources());
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
      ImmersiveUtils.clearCoverForStatus(((FragmentActivity)localObject).getWindow(), true);
      localObject = getActivity();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "activity");
      ImmersiveUtils.setStatusTextColor(true, ((FragmentActivity)localObject).getWindow());
      return;
    }
  }
  
  private final void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localObject != null) {
      ((QQCustomDialog)localObject).dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a((Context)getActivity(), 0, null, (CharSequence)getResources().getString(2131692892), getResources().getString(2131692889), getResources().getString(2131692890), (DialogInterface.OnClickListener)new GdtMotiveBrowsingFragment.watchTimeNotCompleteMention.1(this), (DialogInterface.OnClickListener)new GdtMotiveBrowsingFragment.watchTimeNotCompleteMention.2(this));
    localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localObject != null)
    {
      ((QQCustomDialog)localObject).show();
      localObject = ((QQCustomDialog)localObject).getWindow();
      if (localObject != null)
      {
        localObject = ((Window)localObject).getDecorView();
        if (localObject != null) {
          ((View)localObject).setSystemUiVisibility(7942);
        }
      }
      localObject = this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingViewModel;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
      }
      ((GdtMotiveBrowsingViewModel)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localObject != null) {
      ((QQCustomDialog)localObject).setOnDismissListener((DialogInterface.OnDismissListener)new GdtMotiveBrowsingFragment.watchTimeNotCompleteMention.4(this));
    }
  }
  
  private final void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GdtMotiveBrowsingFragment", 2, "DialogInterface onClick confirm");
    }
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localQQCustomDialog != null) {
      localQQCustomDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = ((QQCustomDialog)null);
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
    Object localObject1 = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((GdtMotiveVideoModel)localObject1).a();
      if (localObject1 != null)
      {
        localObject1 = ((GdtMotiveVideoPageData)localObject1).motiveBrowsingKey;
        if (localObject1 != null)
        {
          localObject2 = StringsKt.split$default((CharSequence)localObject1, new String[] { "#" }, false, 0, 6, null);
          if (((Collection)localObject2).isEmpty()) {
            break label174;
          }
        }
      }
    }
    label174:
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
      GdtADFlyingStreamingReportHelper.a().a(1020025L);
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
    GdtADFlyingStreamingReportHelper.a().a(1020026L);
    if (!this.jdField_a_of_type_Boolean)
    {
      e();
      return;
    }
    h();
    super.doOnBackEvent();
    GdtADFlyingStreamingReportHelper.a().a(1020043L);
  }
  
  public boolean doOnCreate(@Nullable Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    b();
    c();
    GdtADFlyingStreamingReportHelper.a().a(1020033L);
    GdtADFlyingStreamingReportHelper.a().a(1020006L);
    return bool;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localQQCustomDialog != null) {
      localQQCustomDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = ((QQCustomDialog)null);
    GdtADFlyingStreamingReportHelper.a().a();
  }
  
  public void onPageFinished(@Nullable WebView paramWebView, @Nullable String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if (!this.c)
    {
      this.b = true;
      if (!this.d)
      {
        GdtADFlyingStreamingReportHelper.a().a(1020036L);
        this.d = true;
      }
    }
    this.c = false;
  }
  
  public void onReceivedError(@Nullable WebView paramWebView, int paramInt, @Nullable String paramString1, @Nullable String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    this.c = true;
    this.b = false;
    if (!this.d)
    {
      GdtADFlyingStreamingReportHelper.a().a(1020037L);
      this.d = true;
    }
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
    GdtMotiveBrowsingViewModel localGdtMotiveBrowsingViewModel = this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingViewModel;
    if (localGdtMotiveBrowsingViewModel == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    }
    if (!localGdtMotiveBrowsingViewModel.a(paramString, this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel)) {
      return super.shouldOverrideUrlLoading(paramWebView, paramString);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivebrowsing.GdtMotiveBrowsingFragment
 * JD-Core Version:    0.7.0.1
 */