package com.tencent.gdtad.basics.motivebrowsing;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.gdtad.util.GdtUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.mvvm.LifeCycleAndViewModelStoreOwner;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;
import com.tencent.mobileqq.mvvm.api.ILifeCycleFragmentInjectApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingFragment;", "Lcom/tencent/mobileqq/webview/swift/WebViewFragment;", "()V", "countDownTime", "", "hasCountDownComplete", "", "isError", "isSuccess", "lifeCycleFragment", "Lcom/tencent/mobileqq/mvvm/LifeCycleAndViewModelStoreOwner;", "mIsReportLoadingFinishEvent", "mModel", "Lcom/tencent/gdtad/basics/motivevideo/data/GdtMotiveVideoModel;", "mQQCustomDialog", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "titleContainer", "Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingTitle;", "viewModel", "Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingViewModel;", "doOnBackEvent", "", "doOnCreate", "savedInstanceState", "Landroid/os/Bundle;", "getWebViewKernelCallBack", "Lcom/tencent/mobileqq/webview/swift/utils/WebViewKernelCallBack;", "handleMotiveBrowsingData", "browsingData", "Lcom/tencent/gdtad/basics/motivebrowsing/MotiveBrowsingData;", "initData", "initTitle", "initViewModel", "onDestroy", "onDialogCancelClick", "onDialogConfirmClick", "sendRewardedCallback", "watchTimeNotCompleteMention", "Companion", "qqad-impl_release"}, k=1, mv={1, 1, 16})
public final class GdtMotiveBrowsingFragment
  extends WebViewFragment
{
  public static final GdtMotiveBrowsingFragment.Companion a;
  private int jdField_a_of_type_Int;
  private GdtMotiveBrowsingTitle jdField_a_of_type_ComTencentGdtadBasicsMotivebrowsingGdtMotiveBrowsingTitle;
  private GdtMotiveBrowsingViewModel jdField_a_of_type_ComTencentGdtadBasicsMotivebrowsingGdtMotiveBrowsingViewModel;
  private GdtMotiveVideoModel jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel;
  private LifeCycleAndViewModelStoreOwner jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  
  static
  {
    jdField_a_of_type_ComTencentGdtadBasicsMotivebrowsingGdtMotiveBrowsingFragment$Companion = new GdtMotiveBrowsingFragment.Companion(null);
  }
  
  private final void a()
  {
    Object localObject = ((ILifeCycleFragmentInjectApi)QRoute.api(ILifeCycleFragmentInjectApi.class)).checkAndAddLifeCycleFragment((Activity)getActivity());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "QRoute.api(ILifeCycleFra…feCycleFragment(activity)");
    this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner = ((LifeCycleAndViewModelStoreOwner)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("lifeCycleFragment");
    }
    localObject = ViewModelProviderHelper.a((ViewModelStoreOwner)localObject).get(GdtMotiveBrowsingViewModel.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ViewModelProviderHelper.…ingViewModel::class.java)");
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivebrowsingGdtMotiveBrowsingViewModel = ((GdtMotiveBrowsingViewModel)localObject);
  }
  
  private final void a(MotiveBrowsingData paramMotiveBrowsingData)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleMotiveBrowsingData browsingData: ");
      ((StringBuilder)localObject).append(paramMotiveBrowsingData);
      QLog.d("GdtMotiveBrowsingFragment", 2, ((StringBuilder)localObject).toString());
    }
    int i = paramMotiveBrowsingData.a();
    Object localObject = paramMotiveBrowsingData.a();
    int j = paramMotiveBrowsingData.b();
    if (i != 0)
    {
      boolean bool = true;
      if (i != 1) {
        return;
      }
      if (j > 0) {
        bool = false;
      }
      this.jdField_a_of_type_Boolean = bool;
      if (((GdtMotiveBrowsingFragment)this).jdField_a_of_type_ComTencentGdtadBasicsMotivebrowsingGdtMotiveBrowsingTitle == null) {
        c();
      }
      paramMotiveBrowsingData = this.jdField_a_of_type_ComTencentGdtadBasicsMotivebrowsingGdtMotiveBrowsingTitle;
      if (paramMotiveBrowsingData == null) {
        Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
      }
      paramMotiveBrowsingData.a(j);
      return;
    }
    this.webView.evaluateJavascript((String)localObject, (ValueCallback)GdtMotiveBrowsingFragment.handleMotiveBrowsingData.1.a);
  }
  
  private final void b()
  {
    Object localObject = this.intent.getSerializableExtra("data");
    if (!(localObject instanceof GdtMotiveVideoPageData))
    {
      getQBaseActivity().finish();
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel = new GdtMotiveVideoModel((GdtMotiveVideoPageData)GdtMotiveVideoPageData.class.cast(localObject));
      GdtADFlyingStreamingReportHelper.a().a(this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel);
      int j = GdtUtil.a(this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel);
      int i = j;
      if (j <= 0) {
        i = 15;
      }
      this.jdField_a_of_type_Int = i;
      localObject = this.jdField_a_of_type_ComTencentGdtadBasicsMotivebrowsingGdtMotiveBrowsingViewModel;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
      }
      ((GdtMotiveBrowsingViewModel)localObject).a(this.jdField_a_of_type_Int);
      localObject = this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("lifeCycleFragment");
      }
      localObject = (LifecycleOwner)localObject;
      GdtMotiveBrowsingViewModel localGdtMotiveBrowsingViewModel = this.jdField_a_of_type_ComTencentGdtadBasicsMotivebrowsingGdtMotiveBrowsingViewModel;
      if (localGdtMotiveBrowsingViewModel == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
      }
      GdtLifeCycleExtKt.a((LifecycleOwner)localObject, (LiveData)localGdtMotiveBrowsingViewModel.a(), (Function1)new GdtMotiveBrowsingFragment.initData.1((GdtMotiveBrowsingFragment)this));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("GdtMotiveBrowsingFragment", 1, localThrowable, new Object[0]);
    }
  }
  
  private final void c()
  {
    Object localObject = getQBaseActivity();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "qBaseActivity");
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivebrowsingGdtMotiveBrowsingTitle = new GdtMotiveBrowsingTitle((Context)localObject);
    localObject = this.jdField_a_of_type_ComTencentGdtadBasicsMotivebrowsingGdtMotiveBrowsingTitle;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
    }
    ((GdtMotiveBrowsingTitle)localObject).setOnCloseClickListener((Function0)new GdtMotiveBrowsingFragment.initTitle.1((GdtMotiveBrowsingFragment)this));
    localObject = (ViewGroup)getUIStyleHandler().d.findViewById(2131381085);
    GdtMotiveBrowsingTitle localGdtMotiveBrowsingTitle = this.jdField_a_of_type_ComTencentGdtadBasicsMotivebrowsingGdtMotiveBrowsingTitle;
    if (localGdtMotiveBrowsingTitle == null) {
      Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
    }
    ((ViewGroup)localObject).addView((View)localGdtMotiveBrowsingTitle);
    int j = ViewUtils.a(63.0F);
    int i = j;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i = j + ImmersiveUtils.getStatusBarHeight((Context)getQBaseActivity());
    }
    this.webView.setPadding(0, i, 0, 0);
    localObject = getSwiftTitleUI().a;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "swiftTitleUI.titleContainer");
    ((ViewGroup)localObject).setVisibility(8);
    localObject = getQBaseActivity();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "qBaseActivity");
    ImmersiveUtils.clearCoverForStatus(((QBaseActivity)localObject).getWindow(), true);
    localObject = getQBaseActivity();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "qBaseActivity");
    ImmersiveUtils.setStatusTextColor(true, ((QBaseActivity)localObject).getWindow());
  }
  
  private final void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localObject != null) {
      ((QQCustomDialog)localObject).dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a((Context)getQBaseActivity(), 0, null, (CharSequence)getResources().getString(2131692847, new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) }), getResources().getString(2131692844), getResources().getString(2131692845), (DialogInterface.OnClickListener)new GdtMotiveBrowsingFragment.watchTimeNotCompleteMention.1(this), (DialogInterface.OnClickListener)new GdtMotiveBrowsingFragment.watchTimeNotCompleteMention.2(this));
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
      localObject = this.jdField_a_of_type_ComTencentGdtadBasicsMotivebrowsingGdtMotiveBrowsingViewModel;
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
  
  private final void e()
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
  
  private final void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GdtMotiveBrowsingFragment", 2, "DialogInterface onClick onCancel");
    }
    g();
    super.doOnBackEvent();
  }
  
  private final void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GdtMotiveBrowsingFragment", 2, "sendRewardedCallback");
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel;
    if (localObject1 != null)
    {
      localObject1 = ((GdtMotiveVideoModel)localObject1).a();
      if (localObject1 != null)
      {
        localObject1 = ((GdtMotiveVideoPageData)localObject1).motiveBrowsingKey;
        if (localObject1 != null)
        {
          Object localObject2 = StringsKt.split$default((CharSequence)localObject1, new String[] { "#" }, false, 0, 6, null);
          if ((((Collection)localObject2).isEmpty() ^ true))
          {
            localObject2 = new Intent((String)((List)localObject2).get(0));
            ((Intent)localObject2).putExtra("duration_time", this.jdField_a_of_type_Int * 1000L);
            ((Intent)localObject2).putExtra("elapsed_time", this.jdField_a_of_type_Int * 1000L);
            ((Intent)localObject2).putExtra("profitable_flag", this.jdField_a_of_type_Boolean);
            ((Intent)localObject2).putExtra("KEY_MOTIVE_BROWSING", (String)localObject1);
            getQBaseActivity().sendBroadcast((Intent)localObject2);
          }
        }
      }
    }
    GdtADFlyingStreamingReportHelper.a().a(1020025L);
  }
  
  public void doOnBackEvent()
  {
    GdtADFlyingStreamingReportHelper.a().a(1020026L);
    if (!this.jdField_a_of_type_Boolean)
    {
      d();
      return;
    }
    g();
    super.doOnBackEvent();
    GdtADFlyingStreamingReportHelper.a().a(1020043L);
  }
  
  protected boolean doOnCreate(@Nullable Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    a();
    b();
    GdtADFlyingStreamingReportHelper.a().a(1020033L);
    GdtADFlyingStreamingReportHelper.a().a(1020006L);
    return bool;
  }
  
  @NotNull
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return (WebViewKernelCallBack)new GdtMotiveBrowsingFragment.getWebViewKernelCallBack.1(this, (WebViewKernelCallBack)this.webViewSurface);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivebrowsing.GdtMotiveBrowsingFragment
 * JD-Core Version:    0.7.0.1
 */