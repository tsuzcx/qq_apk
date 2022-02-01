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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingFragment;", "Lcom/tencent/mobileqq/webview/swift/WebViewFragment;", "()V", "countDownTime", "", "hasCountDownComplete", "", "isError", "isSuccess", "lifeCycleFragment", "Lcom/tencent/mobileqq/mvvm/LifeCycleAndViewModelStoreOwner;", "mIsReportLoadingFinishEvent", "mModel", "Lcom/tencent/gdtad/basics/motivevideo/data/GdtMotiveVideoModel;", "mQQCustomDialog", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "titleContainer", "Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingTitle;", "viewModel", "Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingViewModel;", "doOnBackEvent", "", "doOnCreate", "savedInstanceState", "Landroid/os/Bundle;", "getWebViewKernelCallBack", "Lcom/tencent/mobileqq/webview/swift/utils/WebViewKernelCallBack;", "handleMotiveBrowsingData", "browsingData", "Lcom/tencent/gdtad/basics/motivebrowsing/MotiveBrowsingData;", "initData", "initTitle", "initViewModel", "onDestroy", "onDialogCancelClick", "onDialogConfirmClick", "onResume", "sendRewardedCallback", "watchTimeNotCompleteMention", "Companion", "qqad-impl_release"}, k=1, mv={1, 1, 16})
public final class GdtMotiveBrowsingFragment
  extends WebViewFragment
{
  public static final GdtMotiveBrowsingFragment.Companion a = new GdtMotiveBrowsingFragment.Companion(null);
  private boolean b;
  private GdtMotiveBrowsingViewModel c;
  private LifeCycleAndViewModelStoreOwner d;
  private QQCustomDialog e;
  private GdtMotiveVideoModel f;
  private GdtMotiveBrowsingTitle g;
  private int h;
  private boolean i;
  private boolean j;
  private boolean k;
  
  private final void a()
  {
    Object localObject = ((ILifeCycleFragmentInjectApi)QRoute.api(ILifeCycleFragmentInjectApi.class)).checkAndAddLifeCycleFragment((Activity)getActivity());
    Intrinsics.checkExpressionValueIsNotNull(localObject, "QRoute.api(ILifeCycleFra…feCycleFragment(activity)");
    this.d = ((LifeCycleAndViewModelStoreOwner)localObject);
    localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("lifeCycleFragment");
    }
    localObject = ViewModelProviderHelper.a((ViewModelStoreOwner)localObject).get(GdtMotiveBrowsingViewModel.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ViewModelProviderHelper.…ingViewModel::class.java)");
    this.c = ((GdtMotiveBrowsingViewModel)localObject);
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
    int m = paramMotiveBrowsingData.a();
    Object localObject = paramMotiveBrowsingData.b();
    int n = paramMotiveBrowsingData.c();
    if (m != 0)
    {
      boolean bool = true;
      if (m != 1) {
        return;
      }
      if (n > 0) {
        bool = false;
      }
      this.b = bool;
      if (((GdtMotiveBrowsingFragment)this).g == null) {
        c();
      }
      paramMotiveBrowsingData = this.g;
      if (paramMotiveBrowsingData == null) {
        Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
      }
      paramMotiveBrowsingData.a(n);
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
      this.f = new GdtMotiveVideoModel((GdtMotiveVideoPageData)GdtMotiveVideoPageData.class.cast(localObject));
      GdtADFlyingStreamingReportHelper.a().a(this.f);
      int n = GdtUtil.a(this.f);
      int m = n;
      if (n <= 0) {
        m = 15;
      }
      this.h = m;
      localObject = this.c;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
      }
      ((GdtMotiveBrowsingViewModel)localObject).a(this.h);
      localObject = this.d;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("lifeCycleFragment");
      }
      localObject = (LifecycleOwner)localObject;
      GdtMotiveBrowsingViewModel localGdtMotiveBrowsingViewModel = this.c;
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
    this.g = new GdtMotiveBrowsingTitle((Context)localObject);
    localObject = this.g;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
    }
    ((GdtMotiveBrowsingTitle)localObject).setOnCloseClickListener((Function0)new GdtMotiveBrowsingFragment.initTitle.1((GdtMotiveBrowsingFragment)this));
    localObject = (ViewGroup)getUIStyleHandler().x.findViewById(2131450099);
    GdtMotiveBrowsingTitle localGdtMotiveBrowsingTitle = this.g;
    if (localGdtMotiveBrowsingTitle == null) {
      Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
    }
    ((ViewGroup)localObject).addView((View)localGdtMotiveBrowsingTitle);
    int n = ViewUtils.dip2px(63.0F);
    int m = n;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      m = n + ImmersiveUtils.getStatusBarHeight((Context)getQBaseActivity());
    }
    this.webView.setPadding(0, m, 0, 0);
    localObject = getSwiftTitleUI().o;
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
    Object localObject = this.e;
    if (localObject != null) {
      ((QQCustomDialog)localObject).dismiss();
    }
    this.e = DialogUtil.a((Context)getQBaseActivity(), 0, null, (CharSequence)getResources().getString(2131889956, new Object[] { Integer.valueOf(this.h) }), getResources().getString(2131889953), getResources().getString(2131889954), (DialogInterface.OnClickListener)new GdtMotiveBrowsingFragment.watchTimeNotCompleteMention.1(this), (DialogInterface.OnClickListener)new GdtMotiveBrowsingFragment.watchTimeNotCompleteMention.2(this));
    localObject = this.e;
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
      localObject = this.c;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
      }
      ((GdtMotiveBrowsingViewModel)localObject).c();
    }
    localObject = this.e;
    if (localObject != null) {
      ((QQCustomDialog)localObject).setOnDismissListener((DialogInterface.OnDismissListener)new GdtMotiveBrowsingFragment.watchTimeNotCompleteMention.4(this));
    }
  }
  
  private final void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GdtMotiveBrowsingFragment", 2, "DialogInterface onClick confirm");
    }
    QQCustomDialog localQQCustomDialog = this.e;
    if (localQQCustomDialog != null) {
      localQQCustomDialog.dismiss();
    }
    this.e = ((QQCustomDialog)null);
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
    Object localObject1 = this.f;
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
            ((Intent)localObject2).putExtra("duration_time", this.h * 1000L);
            ((Intent)localObject2).putExtra("elapsed_time", this.h * 1000L);
            ((Intent)localObject2).putExtra("profitable_flag", this.b);
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
    if (!this.b)
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
    Object localObject = this.e;
    if (localObject != null) {
      ((QQCustomDialog)localObject).dismiss();
    }
    this.e = ((QQCustomDialog)null);
    GdtADFlyingStreamingReportHelper.a().c();
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    }
    ((GdtMotiveBrowsingViewModel)localObject).b().d();
  }
  
  public void onResume()
  {
    super.onResume();
    QBaseActivity localQBaseActivity = getQBaseActivity();
    if (localQBaseActivity != null) {
      localQBaseActivity.setRequestedOrientation(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivebrowsing.GdtMotiveBrowsingFragment
 * JD-Core Version:    0.7.0.1
 */