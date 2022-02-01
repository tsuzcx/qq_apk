package com.tencent.mobileqq.activity.weather.webpage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ark.open.ArkView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.weather.WeatherDCReportHelper;
import com.tencent.mobileqq.activity.weather.config.WeatherConfigBean;
import com.tencent.mobileqq.activity.weather.config.WeatherConfigProcessor;
import com.tencent.mobileqq.activity.weather.config.WeatherConfigProcessor.Companion;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter;
import com.tencent.mobileqq.mvvm.ActivityExtKt;
import com.tencent.mobileqq.mvvm.LifeCycleExtKt;
import com.tencent.mobileqq.mvvm.LifeCycleFragment;
import com.tencent.mobileqq.mvvm.ResourcesExtKt;
import com.tencent.mobileqq.mvvm.ViewExtKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.URLUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.vip.perload.VasPreloadService;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppActivity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/weather/webpage/WebViewFragmentWithArk;", "Lcom/tencent/mobileqq/webview/swift/WebViewFragment;", "()V", "adCode", "", "appMeta", "appName", "appVersion", "appView", "arkLoadState", "", "arkViewWrapper", "Lcom/tencent/mobileqq/activity/weather/webpage/WeatherArkViewWrapper;", "curWebPageData", "Lcom/tencent/mobileqq/activity/weather/webpage/WebPageData;", "isFromDrawer", "", "isFromShare", "isPageLoadFinish", "isStartTimeAdded", "isWebLoaded", "lifeCycleFragment", "Lcom/tencent/mobileqq/mvvm/LifeCycleFragment;", "startClickTime", "", "startLoadTime", "viewModel", "Lcom/tencent/mobileqq/activity/weather/webpage/WeatherWebArkViewModel;", "webViewWrapper", "Lcom/tencent/biz/ui/RefreshView;", "kotlin.jvm.PlatformType", "getWebViewWrapper", "()Lcom/tencent/biz/ui/RefreshView;", "webViewWrapper$delegate", "Lkotlin/Lazy;", "changeWhiteTitleStyle", "", "createBgImageIfNeed", "Landroid/widget/ImageView;", "doCreateLoopStep_Final", "extraData", "Landroid/os/Bundle;", "initData", "initTitle", "initView", "initViewModel", "onArkLoadState", "state", "onArkViewTouchEvent", "event", "Landroid/view/MotionEvent;", "onAttach", "activity", "Landroid/app/Activity;", "onCreate", "savedInstanceState", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onJsCall", "data", "onPageDataCall", "onPageFinished", "view", "Lcom/tencent/smtt/sdk/WebView;", "url", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onPause", "onRefreshViewOverScroll", "overScrollDistance", "onResume", "onTipLocationFail", "onWebBgChange", "bgUrl", "setBackButtonWhite", "setHiddenMenuItem", "hiddenList", "", "setRightButton", "isHidden", "callback", "text", "color", "iconID", "cornerID", "onClickListener", "Landroid/view/View$OnClickListener;", "apiCallback", "Lcom/tencent/mobileqq/Doraemon/APICallback;", "setShareButtonWhite", "showActionSheet", "startLoadUrl", "toWeatherOptionActivity", "tryRequestCurrAdCode", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class WebViewFragmentWithArk
  extends WebViewFragment
{
  public static final WebViewFragmentWithArk.Companion a;
  private static VasPreloadService jdField_a_of_type_CooperationVipPerloadVasPreloadService;
  private static final List<String> jdField_a_of_type_JavaUtilList = CollectionsKt.listOf(new String[] { "5061201803333178", "7091208803630139" });
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private WeatherArkViewWrapper jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherArkViewWrapper;
  private WeatherWebArkViewModel jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherWebArkViewModel;
  private WebPageData jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWebPageData;
  private LifeCycleFragment jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment;
  private String jdField_a_of_type_JavaLangString;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private final Lazy jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)new WebViewFragmentWithArk.webViewWrapper.2(this));
  private boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWebViewFragmentWithArk$Companion = new WebViewFragmentWithArk.Companion(null);
  }
  
  private final ImageView a()
  {
    ImageView localImageView = (ImageView)a().findViewById(2131381838);
    if (localImageView != null)
    {
      if (!(localImageView.getParent() instanceof ViewGroup)) {
        break label118;
      }
      ViewParent localViewParent = localImageView.getParent();
      if (localViewParent == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
      }
      ((ViewGroup)localViewParent).removeView((View)localImageView);
    }
    label118:
    for (;;)
    {
      a().addView((View)localImageView, 0);
      return localImageView;
      localImageView = new ImageView((Context)getActivity());
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localImageView.setId(2131381838);
      localImageView.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    }
  }
  
  private final RefreshView a()
  {
    return (RefreshView)this.jdField_a_of_type_KotlinLazy.getValue();
  }
  
  private final void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewFragmentWithArk", 2, "onRefreshViewOverScroll  overScrollDistance: " + paramInt);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherArkViewWrapper;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("arkViewWrapper");
    }
    localObject = ((WeatherArkViewWrapper)localObject).getLayoutParams();
    if ((localObject instanceof FrameLayout.LayoutParams))
    {
      ((FrameLayout.LayoutParams)localObject).topMargin = (-paramInt);
      WeatherArkViewWrapper localWeatherArkViewWrapper = this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherArkViewWrapper;
      if (localWeatherArkViewWrapper == null) {
        Intrinsics.throwUninitializedPropertyAccessException("arkViewWrapper");
      }
      localWeatherArkViewWrapper.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  private final void a(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewFragmentWithArk", 2, "onArkViewTouchEvent  event: " + paramMotionEvent);
    }
    a().dispatchTouchEvent(paramMotionEvent);
  }
  
  private final void a(WebPageData paramWebPageData)
  {
    int i = paramWebPageData.a();
    String str = paramWebPageData.c();
    int j = paramWebPageData.b();
    switch (i)
    {
    default: 
      return;
    case 0: 
      b(paramWebPageData);
      return;
    case 1: 
      a(str);
      return;
    case 2: 
      b(j);
      return;
    }
    f();
  }
  
  private final void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewFragmentWithArk", 2, "onWebBgChange bgUrl: " + paramString);
    }
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      Object localObject1 = getResources();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "resources");
      Object localObject2 = ResourcesExtKt.a((Resources)localObject1, 2130839620);
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
      localObject2 = (ImageView)a().findViewById(2131381838);
      if (localObject2 != null) {
        ((ImageView)localObject2).setImageDrawable((Drawable)URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject1));
      }
    }
  }
  
  private final void a(List<String> paramList)
  {
    if (paramList == null) {}
    do
    {
      return;
      if (!paramList.contains("menuItem:setFont")) {
        paramList.add("menuItem:setFont");
      }
      if (!paramList.contains("menuItem:screenLongShotShare")) {
        paramList.add("menuItem:screenLongShotShare");
      }
    } while (paramList.contains("menuItem:exposeArticle"));
    paramList.add("menuItem:exposeArticle");
  }
  
  private final void b(int paramInt)
  {
    QLog.i("WebViewFragmentWithArk", 1, "onArkLoadState state: " + paramInt);
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int == -1) {
      k();
    }
    g();
  }
  
  private final void b(WebPageData paramWebPageData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewFragmentWithArk", 2, "onJsCall data: " + paramWebPageData);
    }
    String str1 = paramWebPageData.a();
    String str2 = paramWebPageData.b();
    int i = paramWebPageData.c();
    if ((!TextUtils.isEmpty((CharSequence)str1)) && (!TextUtils.isEmpty((CharSequence)str2)))
    {
      if (this.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebViewFragmentWithArk", 2, "onJsCall jsFunction: " + str1 + ", jsParam: " + str2);
        }
        this.webView.callJs(str1, new String[] { str2 });
        paramWebPageData = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWebPageData = paramWebPageData;
    }
    if (i > 0)
    {
      paramWebPageData = this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherArkViewWrapper;
      if (paramWebPageData == null) {
        Intrinsics.throwUninitializedPropertyAccessException("arkViewWrapper");
      }
      paramWebPageData.setArkHeight(AIOUtils.a(i, getResources()));
    }
  }
  
  private final void d()
  {
    Object localObject = getActivity();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "activity");
    this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment = ActivityExtKt.a((FragmentActivity)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("lifeCycleFragment");
    }
    localObject = LifeCycleExtKt.a((ViewModelStoreOwner)localObject).get(WeatherWebArkViewModel.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ofViewModelProvider(life…ArkViewModel::class.java)");
    this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherWebArkViewModel = ((WeatherWebArkViewModel)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("lifeCycleFragment");
    }
    ArkAppNotifyCenter.setNotify("com.tencent.weather_v2", new WeakReference(new WeatherArkNotify((LifeCycleFragment)localObject)));
  }
  
  private final void e()
  {
    String str = getIntent().getStringExtra("appName");
    Intrinsics.checkExpressionValueIsNotNull(str, "getIntent().getStringExtra(KEY_APP_NAME)");
    this.jdField_a_of_type_JavaLangString = str;
    str = getIntent().getStringExtra("appVersion");
    Intrinsics.checkExpressionValueIsNotNull(str, "getIntent().getStringExtra(KEY_APP_VERSION)");
    this.jdField_b_of_type_JavaLangString = str;
    str = getIntent().getStringExtra("appMeta");
    Intrinsics.checkExpressionValueIsNotNull(str, "getIntent().getStringExtra(KEY_APP_META)");
    this.jdField_c_of_type_JavaLangString = str;
    str = getIntent().getStringExtra("appView");
    Intrinsics.checkExpressionValueIsNotNull(str, "getIntent().getStringExtra(KEY_APP_VIEW)");
    this.jdField_d_of_type_JavaLangString = str;
    str = getIntent().getStringExtra("adCode");
    Intrinsics.checkExpressionValueIsNotNull(str, "getIntent().getStringExtra(KEY_AD_CODE)");
    this.jdField_e_of_type_JavaLangString = str;
    this.jdField_b_of_type_Long = getIntent().getLongExtra("start_click_time", 0L);
    boolean bool = getIntent().getBooleanExtra("webProcessExist", false);
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("is_from_share", false);
    this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("is_from_drawer", false);
    long l;
    if (this.jdField_b_of_type_Long > 0L)
    {
      l = System.currentTimeMillis() - this.jdField_b_of_type_Long;
      if (!bool) {
        break label252;
      }
    }
    label252:
    for (str = "new_folder_prestart_open_times";; str = "new_folder_noprestart_open_times")
    {
      WeatherDCReportHelper.a().a(null, str, Long.valueOf(l));
      WeatherPreloadHelperKt.a(3, "startTime = " + l);
      return;
    }
  }
  
  private final void f()
  {
    QLog.i("WebViewFragmentWithArk", 1, "onTipLocationFail");
    QQToast.a((Context)getActivity(), (CharSequence)getString(2131720642), 0).a();
  }
  
  private final void g()
  {
    if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_c_of_type_Boolean) && (this.jdField_d_of_type_Boolean))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherArkViewWrapper;
      if (localObject1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("arkViewWrapper");
      }
      if (((WeatherArkViewWrapper)localObject1).a()) {}
    }
    else
    {
      localObject1 = new StringBuilder().append("requestCurrAdCode fail isFromShare: ").append(this.jdField_b_of_type_Boolean).append(" isFromDrawer: ").append(this.jdField_c_of_type_Boolean).append(" isWebLoaded: ").append(this.jdField_d_of_type_Boolean).append(" isArkLoaded: ");
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherArkViewWrapper;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("arkViewWrapper");
      }
      QLog.i("WebViewFragmentWithArk", 1, ((WeatherArkViewWrapper)localObject2).a() + ')');
      return;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherWebArkViewModel;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    }
    Object localObject2 = (AppActivity)getActivity();
    String str = this.jdField_e_of_type_JavaLangString;
    if (str == null) {
      Intrinsics.throwUninitializedPropertyAccessException("adCode");
    }
    ((WeatherWebArkViewModel)localObject1).a((AppActivity)localObject2, str);
  }
  
  private final void h()
  {
    Object localObject1 = this.mSwiftTitleUI.jdField_a_of_type_AndroidViewViewGroup;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mSwiftTitleUI.titleContainer");
    localObject1 = ((ViewGroup)localObject1).getParent();
    if ((localObject1 instanceof ViewGroup))
    {
      ((ViewGroup)localObject1).removeView((View)this.mSwiftTitleUI.jdField_a_of_type_AndroidViewViewGroup);
      localObject1 = getView();
      if (localObject1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
      }
      ((ViewGroup)localObject1).addView((View)this.mSwiftTitleUI.jdField_a_of_type_AndroidViewViewGroup);
    }
    localObject1 = (ImageView)this.mSwiftTitleUI.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369506);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "secondImage");
    ViewExtKt.a((View)localObject1, null);
    ((ImageView)localObject1).setVisibility(0);
    ((ImageView)localObject1).setImageResource(2130850856);
    ViewExtKt.a((View)localObject1, (Function0)new WebViewFragmentWithArk.initTitle.1((WebViewFragmentWithArk)this));
    ((ImageView)localObject1).setContentDescription((CharSequence)getString(2131691223));
    b();
    Object localObject2 = ((ImageView)localObject1).getLayoutParams();
    if (localObject2 == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }
    localObject2 = (RelativeLayout.LayoutParams)localObject2;
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.a(11.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.a(12.0F, getResources());
    ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetTextView;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mSwiftTitleUI.leftView");
    ((TextView)localObject1).setContentDescription((CharSequence)getString(2131690778));
    localObject1 = getActivity();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "activity");
    ImmersiveUtils.clearCoverForStatus(((FragmentActivity)localObject1).getWindow(), true);
    localObject1 = getActivity();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "activity");
    ((FragmentActivity)localObject1).getIntent().removeExtra("isTransparentTitle");
  }
  
  private final void i()
  {
    WeatherDCReportHelper.a().a(null, "new_topbar_account_click");
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest((Context)getActivity(), "/pubaccount/detail");
    localActivityURIRequest.extra().putString("uin", "2658655094");
    localActivityURIRequest.extra().putString("uinname", "QQ天气");
    localActivityURIRequest.extra().putInt("uintype", 1008);
    localActivityURIRequest.setFlags(67108864);
    QRoute.startUri((URIRequest)localActivityURIRequest, null);
    PublicAccountHandler.a(null, "2658655094", "Pb_account_lifeservice", "mp_msg_sys_2", "detail");
  }
  
  private final void j()
  {
    this.webView.addScrollChangedListener((TouchWebView.OnScrollChangedListener)new WebViewFragmentWithArk.initView.1(this));
    this.webView.setBackgroundColor(0);
    int j = (int)getResources().getDimension(2131299166);
    int i = j;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i = ImmersiveUtils.getStatusBarHeight((Context)getActivity()) + j;
    }
    Object localObject1 = this.webView;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "webView");
    localObject1 = ((TouchWebView)localObject1).getLayoutParams();
    if (localObject1 == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }
    localObject1 = (RelativeLayout.LayoutParams)localObject1;
    ((RelativeLayout.LayoutParams)localObject1).topMargin = i;
    Object localObject2 = this.webView;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "webView");
    ((TouchWebView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = a();
    localObject2 = getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "resources");
    ((ImageView)localObject1).setImageDrawable(ResourcesExtKt.a((Resources)localObject2, 2130839620));
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("lifeCycleFragment");
    }
    localObject1 = (LifecycleOwner)localObject1;
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherWebArkViewModel;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    }
    LifeCycleExtKt.a((LifecycleOwner)localObject1, (LiveData)((WeatherWebArkViewModel)localObject2).a(), (Function1)new WebViewFragmentWithArk.initView.2((WebViewFragmentWithArk)this));
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("lifeCycleFragment");
    }
    localObject1 = (LifecycleOwner)localObject1;
    localObject2 = a().a;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "webViewWrapper.onOverScrolledLiveData");
    LifeCycleExtKt.a((LifecycleOwner)localObject1, (LiveData)localObject2, (Function1)new WebViewFragmentWithArk.initView.3((WebViewFragmentWithArk)this));
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("lifeCycleFragment");
    }
    localObject1 = (LifecycleOwner)localObject1;
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherArkViewWrapper;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("arkViewWrapper");
    }
    LifeCycleExtKt.a((LifecycleOwner)localObject1, (LiveData)((WeatherArkViewWrapper)localObject2).a(), (Function1)new WebViewFragmentWithArk.initView.4((WebViewFragmentWithArk)this));
  }
  
  private final void k()
  {
    Object localObject1 = this.mSwiftTitleUI;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((SwiftIphoneTitleBarUI)localObject1).jdField_a_of_type_AndroidViewViewGroup;
      if (localObject1 != null)
      {
        localObject1 = (ImageView)((ViewGroup)localObject1).findViewById(2131369506);
        if (localObject1 == null) {
          break label283;
        }
        localObject2 = ((ImageView)localObject1).getDrawable();
        label38:
        if (localObject1 != null) {
          ((ImageView)localObject1).setImageResource(0);
        }
        if (localObject1 != null) {
          ((ImageView)localObject1).setImageDrawable(ImageUtil.a((Drawable)localObject2, -16777216));
        }
        localObject1 = this.mSwiftTitleUI;
        if (localObject1 == null) {
          break label288;
        }
        localObject1 = ((SwiftIphoneTitleBarUI)localObject1).jdField_a_of_type_AndroidWidgetImageView;
        if (localObject1 == null) {
          break label288;
        }
      }
    }
    label283:
    label288:
    for (localObject1 = ((ImageView)localObject1).getDrawable();; localObject1 = null)
    {
      localObject2 = this.mSwiftTitleUI;
      if (localObject2 != null)
      {
        localObject2 = ((SwiftIphoneTitleBarUI)localObject2).jdField_a_of_type_AndroidWidgetImageView;
        if (localObject2 != null) {
          ((ImageView)localObject2).setColorFilter(-16777216);
        }
      }
      localObject2 = this.mSwiftTitleUI;
      if (localObject2 != null)
      {
        localObject2 = ((SwiftIphoneTitleBarUI)localObject2).jdField_a_of_type_AndroidWidgetImageView;
        if (localObject2 != null) {
          ((ImageView)localObject2).setImageResource(0);
        }
      }
      localObject2 = this.mSwiftTitleUI;
      if (localObject2 != null)
      {
        localObject2 = ((SwiftIphoneTitleBarUI)localObject2).jdField_a_of_type_AndroidWidgetImageView;
        if (localObject2 != null) {
          ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
        }
      }
      localObject1 = this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetTextView;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "mSwiftTitleUI.leftView");
      localObject1 = ImageUtil.a(((TextView)localObject1).getBackground(), -16777216);
      localObject2 = this.mSwiftTitleUI;
      if (localObject2 != null)
      {
        localObject2 = ((SwiftIphoneTitleBarUI)localObject2).jdField_a_of_type_AndroidWidgetTextView;
        if (localObject2 != null) {
          ViewExtKt.a((View)localObject2, (Drawable)localObject1);
        }
      }
      localObject1 = this.mSwiftTitleUI;
      if (localObject1 != null)
      {
        localObject1 = ((SwiftIphoneTitleBarUI)localObject1).b;
        if (localObject1 != null) {
          ((TextView)localObject1).setTextColor(-16777216);
        }
      }
      localObject1 = this.mSwiftTitleUI;
      if (localObject1 != null)
      {
        localObject1 = ((SwiftIphoneTitleBarUI)localObject1).jdField_a_of_type_AndroidViewViewGroup;
        if (localObject1 != null) {
          ((ViewGroup)localObject1).setBackgroundColor(-1);
        }
      }
      localObject1 = getActivity();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "activity");
      ImmersiveUtils.setStatusTextColor(true, ((FragmentActivity)localObject1).getWindow());
      return;
      localObject1 = null;
      break;
      localObject2 = null;
      break label38;
    }
  }
  
  public final void a()
  {
    Object localObject1 = this.mSwiftTitleUI;
    if (localObject1 != null)
    {
      localObject1 = ((SwiftIphoneTitleBarUI)localObject1).jdField_a_of_type_AndroidWidgetImageView;
      if (localObject1 == null) {}
    }
    for (localObject1 = ((ImageView)localObject1).getDrawable();; localObject1 = null)
    {
      localObject1 = ImageUtil.a((Drawable)localObject1, -1);
      if (localObject1 != null)
      {
        Object localObject2 = this.mSwiftTitleUI;
        if (localObject2 != null)
        {
          localObject2 = ((SwiftIphoneTitleBarUI)localObject2).jdField_a_of_type_AndroidWidgetImageView;
          if (localObject2 != null) {
            ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
          }
        }
        localObject1 = this.mSwiftTitleUI;
        if (localObject1 != null)
        {
          localObject1 = ((SwiftIphoneTitleBarUI)localObject1).jdField_a_of_type_AndroidWidgetImageView;
          if (localObject1 != null) {
            ((ImageView)localObject1).setColorFilter(-1);
          }
        }
      }
      return;
    }
  }
  
  public final void b()
  {
    Object localObject1 = this.mSwiftTitleUI;
    if (localObject1 != null)
    {
      localObject1 = ((SwiftIphoneTitleBarUI)localObject1).jdField_a_of_type_AndroidWidgetTextView;
      if (localObject1 == null) {}
    }
    for (localObject1 = ((TextView)localObject1).getBackground();; localObject1 = null)
    {
      localObject1 = ImageUtil.a((Drawable)localObject1, -1);
      if (localObject1 != null)
      {
        Object localObject2 = this.mSwiftTitleUI;
        if (localObject2 != null)
        {
          localObject2 = ((SwiftIphoneTitleBarUI)localObject2).jdField_a_of_type_AndroidWidgetTextView;
          if (localObject2 != null) {
            ((TextView)localObject2).setBackgroundDrawable((Drawable)localObject1);
          }
        }
      }
      return;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public int doCreateLoopStep_Final(@Nullable Bundle paramBundle)
  {
    int i = super.doCreateLoopStep_Final(paramBundle);
    QLog.i("WebViewFragmentWithArk", 1, "doCreateLoopStep_Final");
    h();
    j();
    return i;
  }
  
  public void onAttach(@Nullable Activity paramActivity)
  {
    super.onAttach(paramActivity);
    WeatherWebPageHelperKt.a();
    if (WeatherConfigProcessor.a.a().a())
    {
      jdField_a_of_type_CooperationVipPerloadVasPreloadService = new VasPreloadService("weather", jdField_a_of_type_JavaUtilList);
      paramActivity = jdField_a_of_type_CooperationVipPerloadVasPreloadService;
      if (paramActivity != null) {
        paramActivity.a();
      }
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    d();
    e();
  }
  
  @NotNull
  public View onCreateView(@Nullable LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = new FrameLayout((Context)getActivity());
    paramLayoutInflater.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    int i;
    if ((WebAccelerateHelper.preloadBrowserView instanceof WebBrowserViewContainer))
    {
      paramViewGroup = WebAccelerateHelper.preloadBrowserView;
      if (paramViewGroup == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.webview.swift.WebBrowserViewContainer");
      }
      this.contentView = ((WebBrowserViewContainer)paramViewGroup);
      WebAccelerateHelper.preloadBrowserView = (View)null;
      this.mStatistics.v = true;
      paramViewGroup = new FrameLayout.LayoutParams(-1, -1);
      paramBundle = this.contentView;
      Intrinsics.checkExpressionValueIsNotNull(paramBundle, "contentView");
      paramBundle.setLayoutParams((ViewGroup.LayoutParams)paramViewGroup);
      paramLayoutInflater.addView((View)this.contentView);
      paramViewGroup = getActivity();
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "activity");
      this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherArkViewWrapper = new WeatherArkViewWrapper((Context)paramViewGroup);
      i = (int)getResources().getDimension(2131299166);
      if (ImmersiveUtils.isSupporImmersive() != 1) {
        break label403;
      }
      i = ImmersiveUtils.getStatusBarHeight((Context)getActivity()) + i;
    }
    label403:
    for (;;)
    {
      paramViewGroup = new FrameLayout.LayoutParams(-1, i + AIOUtils.a(720, getResources()));
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherArkViewWrapper;
      if (paramBundle == null) {
        Intrinsics.throwUninitializedPropertyAccessException("arkViewWrapper");
      }
      paramLayoutInflater.addView((View)paramBundle, (ViewGroup.LayoutParams)paramViewGroup);
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherArkViewWrapper;
      if (paramViewGroup == null) {
        Intrinsics.throwUninitializedPropertyAccessException("arkViewWrapper");
      }
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment;
      if (paramBundle == null) {
        Intrinsics.throwUninitializedPropertyAccessException("lifeCycleFragment");
      }
      paramViewGroup.a((ViewModelStoreOwner)paramBundle);
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherArkViewWrapper;
      if (paramViewGroup == null) {
        Intrinsics.throwUninitializedPropertyAccessException("arkViewWrapper");
      }
      paramBundle = this.jdField_a_of_type_JavaLangString;
      if (paramBundle == null) {
        Intrinsics.throwUninitializedPropertyAccessException("appName");
      }
      String str1 = this.jdField_d_of_type_JavaLangString;
      if (str1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("appView");
      }
      String str2 = this.jdField_b_of_type_JavaLangString;
      if (str2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("appVersion");
      }
      String str3 = this.jdField_c_of_type_JavaLangString;
      if (str3 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("appMeta");
      }
      paramViewGroup.a(paramBundle, str1, str2, str3);
      listenKeyboardShowHide((View)paramLayoutInflater);
      paramLayoutInflater = (View)paramLayoutInflater;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      this.contentView = new WebBrowserViewContainer((Context)super.getActivity());
      break;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ArkAppNotifyCenter.setNotify("com.tencent.weather_v2", null);
    WeatherArkViewWrapper localWeatherArkViewWrapper = this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherArkViewWrapper;
    if (localWeatherArkViewWrapper == null) {
      Intrinsics.throwUninitializedPropertyAccessException("arkViewWrapper");
    }
    localWeatherArkViewWrapper.a().onDestroy();
  }
  
  public void onDetach()
  {
    super.onDetach();
    VasPreloadService localVasPreloadService = jdField_a_of_type_CooperationVipPerloadVasPreloadService;
    if (localVasPreloadService != null) {
      localVasPreloadService.a();
    }
  }
  
  public void onPageFinished(@Nullable WebView paramWebView, @Nullable String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    this.jdField_a_of_type_Boolean = true;
    paramWebView = this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWebPageData;
    if (paramWebView != null) {
      ((WebViewFragmentWithArk)this).b(paramWebView);
    }
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    WeatherDCReportHelper.a().a(null, "new_webview_loading_times", Long.valueOf(l));
    WeatherPreloadHelperKt.a(6, "time = " + l);
    if (!this.jdField_d_of_type_Boolean)
    {
      this.jdField_d_of_type_Boolean = true;
      g();
    }
  }
  
  public void onPageStarted(@Nullable WebView paramWebView, @Nullable String paramString, @Nullable Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    WeatherPreloadHelperKt.a(5, "");
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void onPause()
  {
    super.onPause();
    WeatherArkViewWrapper localWeatherArkViewWrapper = this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherArkViewWrapper;
    if (localWeatherArkViewWrapper == null) {
      Intrinsics.throwUninitializedPropertyAccessException("arkViewWrapper");
    }
    localWeatherArkViewWrapper.a().onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    b();
    WeatherArkViewWrapper localWeatherArkViewWrapper = this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherArkViewWrapper;
    if (localWeatherArkViewWrapper == null) {
      Intrinsics.throwUninitializedPropertyAccessException("arkViewWrapper");
    }
    localWeatherArkViewWrapper.a().onResume();
  }
  
  public void setRightButton(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, @Nullable View.OnClickListener paramOnClickListener, @Nullable APICallback paramAPICallback)
  {
    super.setRightButton(paramString1, paramString2, paramString3, paramBoolean, paramInt1, paramInt2, paramOnClickListener, paramAPICallback);
    a();
  }
  
  public void setRightButton(boolean paramBoolean)
  {
    super.setRightButton(paramBoolean);
    a();
  }
  
  public void showActionSheet()
  {
    QLog.i("WebViewFragmentWithArk", 1, "showActionSheet");
    SwiftBrowserShareMenuHandler localSwiftBrowserShareMenuHandler = (SwiftBrowserShareMenuHandler)this.mComponentsProvider.a(4);
    if (localSwiftBrowserShareMenuHandler != null)
    {
      a((List)localSwiftBrowserShareMenuHandler.a);
      localSwiftBrowserShareMenuHandler.a(ensureShare(), this.mUIStyle.jdField_a_of_type_Long);
    }
    WeatherDCReportHelper.a().a(null, "new_topbar_share_click");
  }
  
  public void startLoadUrl()
  {
    if (!this.jdField_e_of_type_Boolean) {
      this.mUrl = URLUtil.a(this.mUrl, "start_click_time", String.valueOf(this.jdField_b_of_type_Long));
    }
    super.startLoadUrl();
    if (!this.jdField_e_of_type_Boolean) {
      this.mUrl = URLUtil.a(this.mUrl, "start_click_time");
    }
    this.jdField_e_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.webpage.WebViewFragmentWithArk
 * JD-Core Version:    0.7.0.1
 */