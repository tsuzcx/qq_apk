package com.tencent.mobileqq.activity.weather.webpage;

import acjr;
import algh;
import algo;
import algs;
import algx;
import alhe;
import alhg;
import alhh;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelStoreOwner;
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
import awhb;
import awhc;
import awhe;
import awhf;
import bfvo;
import bgtw;
import bgvt;
import bgww;
import com.tencent.ark.open.ArkView;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter;
import com.tencent.mobileqq.mvvm.LifeCycleFragment;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppActivity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/weather/webpage/WebViewFragmentWithArk;", "Lcom/tencent/mobileqq/webview/swift/WebViewFragment;", "()V", "adCode", "", "appMeta", "appName", "appVersion", "appView", "arkLoadState", "", "arkViewWrapper", "Lcom/tencent/mobileqq/activity/weather/webpage/WeatherArkViewWrapper;", "curWebPageData", "Lcom/tencent/mobileqq/activity/weather/webpage/WebPageData;", "isFromDrawer", "", "isFromShare", "isPageLoadFinish", "isWebLoaded", "lifeCycleFragment", "Lcom/tencent/mobileqq/mvvm/LifeCycleFragment;", "startLoadTime", "", "viewModel", "Lcom/tencent/mobileqq/activity/weather/webpage/WeatherWebArkViewModel;", "webViewWrapper", "Lcom/tencent/biz/ui/RefreshView;", "kotlin.jvm.PlatformType", "getWebViewWrapper", "()Lcom/tencent/biz/ui/RefreshView;", "webViewWrapper$delegate", "Lkotlin/Lazy;", "changeWhiteTitleStyle", "", "createBgImageIfNeed", "Landroid/widget/ImageView;", "doCreateLoopStep_Final", "extraData", "Landroid/os/Bundle;", "initData", "initTitle", "initView", "initViewModel", "onArkLoadState", "state", "onArkViewTouchEvent", "event", "Landroid/view/MotionEvent;", "onCreate", "savedInstanceState", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onJsCall", "data", "onPageDataCall", "onPageFinished", "view", "Lcom/tencent/smtt/sdk/WebView;", "url", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onPause", "onRefreshViewOverScroll", "overScrollDistance", "onResume", "onTipLocationFail", "onWebBgChange", "bgUrl", "setBackButtonWhite", "setHiddenMenuItem", "hiddenList", "", "setRightButton", "isHidden", "callback", "text", "color", "iconID", "cornerID", "onClickListener", "Landroid/view/View$OnClickListener;", "apiCallback", "Lcom/tencent/mobileqq/Doraemon/APICallback;", "setShareButtonWhite", "showActionSheet", "toWeatherOptionActivity", "tryRequestCurrAdCode", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class WebViewFragmentWithArk
  extends WebViewFragment
{
  public static final alhg a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private algx jdField_a_of_type_Algx;
  private alhe jdField_a_of_type_Alhe;
  private WeatherArkViewWrapper jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherArkViewWrapper;
  private LifeCycleFragment jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment;
  private String jdField_a_of_type_JavaLangString;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private final Lazy jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)new WebViewFragmentWithArk.webViewWrapper.2(this));
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private String e;
  
  static
  {
    jdField_a_of_type_Alhg = new alhg(null);
  }
  
  private final ImageView a()
  {
    ImageView localImageView = (ImageView)a().findViewById(2131381019);
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
      localImageView.setId(2131381019);
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
  
  private final void a(alhe paramalhe)
  {
    int i = paramalhe.a();
    String str = paramalhe.c();
    int j = paramalhe.b();
    switch (i)
    {
    default: 
      return;
    case 0: 
      b(paramalhe);
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
  
  private final void a(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewFragmentWithArk", 2, "onArkViewTouchEvent  event: " + paramMotionEvent);
    }
    a().dispatchTouchEvent(paramMotionEvent);
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
      Object localObject2 = awhe.a((Resources)localObject1, 2130839520);
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
      localObject2 = (ImageView)a().findViewById(2131381019);
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
  
  private final void b(alhe paramalhe)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewFragmentWithArk", 2, "onJsCall data: " + paramalhe);
    }
    String str1 = paramalhe.a();
    String str2 = paramalhe.b();
    int i = paramalhe.c();
    if ((!TextUtils.isEmpty((CharSequence)str1)) && (!TextUtils.isEmpty((CharSequence)str2)))
    {
      if (this.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebViewFragmentWithArk", 2, "onJsCall jsFunction: " + str1 + ", jsParam: " + str2);
        }
        this.webView.callJs(str1, new String[] { str2 });
        paramalhe = null;
      }
      this.jdField_a_of_type_Alhe = paramalhe;
    }
    if (i > 0)
    {
      paramalhe = this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherArkViewWrapper;
      if (paramalhe == null) {
        Intrinsics.throwUninitializedPropertyAccessException("arkViewWrapper");
      }
      paramalhe.setArkHeight(AIOUtils.dp2px(i, getResources()));
    }
  }
  
  private final void d()
  {
    Object localObject = getActivity();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "activity");
    this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment = awhb.a((FragmentActivity)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("lifeCycleFragment");
    }
    localObject = awhc.a((ViewModelStoreOwner)localObject).get(algx.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ofViewModelProvider(life…ArkViewModel::class.java)");
    this.jdField_a_of_type_Algx = ((algx)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("lifeCycleFragment");
    }
    ArkAppNotifyCenter.setNotify("com.tencent.weather_v2", new WeakReference(new algo((LifeCycleFragment)localObject)));
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
    this.e = str;
    long l = getIntent().getLongExtra("startClickTime", 0L);
    boolean bool = getIntent().getBooleanExtra("webProcessExist", false);
    this.jdField_b_of_type_Boolean = getIntent().getBooleanExtra("is_from_share", false);
    this.jdField_c_of_type_Boolean = getIntent().getBooleanExtra("is_from_drawer", false);
    if (l > 0L)
    {
      l = System.currentTimeMillis() - l;
      if (!bool) {
        break label243;
      }
    }
    label243:
    for (str = "new_folder_prestart_open_times";; str = "new_folder_noprestart_open_times")
    {
      algh.a().a(null, str, Long.valueOf(l));
      algs.a(3, "startTime = " + l);
      return;
    }
  }
  
  private final void f()
  {
    QLog.i("WebViewFragmentWithArk", 1, "onTipLocationFail");
    QQToast.a((Context)getActivity(), (CharSequence)getString(2131719613), 0).a();
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
    Object localObject1 = this.jdField_a_of_type_Algx;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    }
    Object localObject2 = (AppActivity)getActivity();
    String str = this.e;
    if (str == null) {
      Intrinsics.throwUninitializedPropertyAccessException("adCode");
    }
    ((algx)localObject1).a((AppActivity)localObject2, str);
  }
  
  private final void h()
  {
    Object localObject1 = this.mSwiftTitleUI.titleContainer;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mSwiftTitleUI.titleContainer");
    localObject1 = ((ViewGroup)localObject1).getParent();
    if ((localObject1 instanceof ViewGroup))
    {
      ((ViewGroup)localObject1).removeView((View)this.mSwiftTitleUI.titleContainer);
      localObject1 = getView();
      if (localObject1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
      }
      ((ViewGroup)localObject1).addView((View)this.mSwiftTitleUI.titleContainer);
    }
    localObject1 = (ImageView)this.mSwiftTitleUI.titleContainer.findViewById(2131369087);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "secondImage");
    awhf.a((View)localObject1, null);
    ((ImageView)localObject1).setVisibility(0);
    ((ImageView)localObject1).setImageResource(2130850347);
    awhf.a((View)localObject1, (Function0)new WebViewFragmentWithArk.initTitle.1((WebViewFragmentWithArk)this));
    ((ImageView)localObject1).setContentDescription((CharSequence)getString(2131691031));
    b();
    Object localObject2 = ((ImageView)localObject1).getLayoutParams();
    if (localObject2 == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }
    localObject2 = (RelativeLayout.LayoutParams)localObject2;
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = AIOUtils.dp2px(11.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = AIOUtils.dp2px(12.0F, getResources());
    ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = this.mSwiftTitleUI.leftView;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mSwiftTitleUI.leftView");
    ((TextView)localObject1).setContentDescription((CharSequence)getString(2131690599));
    localObject1 = getActivity();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "activity");
    ImmersiveUtils.a(((FragmentActivity)localObject1).getWindow(), true);
    localObject1 = getActivity();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "activity");
    ((FragmentActivity)localObject1).getIntent().removeExtra("isTransparentTitle");
  }
  
  private final void i()
  {
    algh.a().a(null, "new_topbar_account_click");
    Intent localIntent = new Intent();
    localIntent.setClassName((Context)getActivity(), AccountDetailActivity.class.getName());
    localIntent.putExtra("uin", "2658655094");
    localIntent.putExtra("uinname", "QQ天气");
    localIntent.putExtra("uintype", 1008);
    localIntent.addFlags(67108864);
    getActivity().startActivity(localIntent);
    PublicAccountHandler.a(null, "2658655094", "Pb_account_lifeservice", "mp_msg_sys_2", "detail");
  }
  
  private final void j()
  {
    this.webView.addScrollChangedListener((TouchWebView.OnScrollChangedListener)new alhh(this));
    this.webView.setBackgroundColor(0);
    int j = (int)getResources().getDimension(2131299076);
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
    ((ImageView)localObject1).setImageDrawable(awhe.a((Resources)localObject2, 2130839520));
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("lifeCycleFragment");
    }
    localObject1 = (LifecycleOwner)localObject1;
    localObject2 = this.jdField_a_of_type_Algx;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    }
    awhc.a((LifecycleOwner)localObject1, (LiveData)((algx)localObject2).a(), (Function1)new WebViewFragmentWithArk.initView.2((WebViewFragmentWithArk)this));
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("lifeCycleFragment");
    }
    localObject1 = (LifecycleOwner)localObject1;
    localObject2 = a().a;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "webViewWrapper.onOverScrolledLiveData");
    awhc.a((LifecycleOwner)localObject1, (LiveData)localObject2, (Function1)new WebViewFragmentWithArk.initView.3((WebViewFragmentWithArk)this));
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("lifeCycleFragment");
    }
    localObject1 = (LifecycleOwner)localObject1;
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherArkViewWrapper;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("arkViewWrapper");
    }
    awhc.a((LifecycleOwner)localObject1, (LiveData)((WeatherArkViewWrapper)localObject2).a(), (Function1)new WebViewFragmentWithArk.initView.4((WebViewFragmentWithArk)this));
  }
  
  private final void k()
  {
    Object localObject1 = this.mSwiftTitleUI;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((bgtw)localObject1).titleContainer;
      if (localObject1 != null)
      {
        localObject1 = (ImageView)((ViewGroup)localObject1).findViewById(2131369087);
        if (localObject1 == null) {
          break label283;
        }
        localObject2 = ((ImageView)localObject1).getDrawable();
        label38:
        if (localObject1 != null) {
          ((ImageView)localObject1).setImageResource(0);
        }
        if (localObject1 != null) {
          ((ImageView)localObject1).setImageDrawable(bfvo.a((Drawable)localObject2, -16777216));
        }
        localObject1 = this.mSwiftTitleUI;
        if (localObject1 == null) {
          break label288;
        }
        localObject1 = ((bgtw)localObject1).rightViewImg;
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
        localObject2 = ((bgtw)localObject2).rightViewImg;
        if (localObject2 != null) {
          ((ImageView)localObject2).setColorFilter(-16777216);
        }
      }
      localObject2 = this.mSwiftTitleUI;
      if (localObject2 != null)
      {
        localObject2 = ((bgtw)localObject2).rightViewImg;
        if (localObject2 != null) {
          ((ImageView)localObject2).setImageResource(0);
        }
      }
      localObject2 = this.mSwiftTitleUI;
      if (localObject2 != null)
      {
        localObject2 = ((bgtw)localObject2).rightViewImg;
        if (localObject2 != null) {
          ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
        }
      }
      localObject1 = this.mSwiftTitleUI.leftView;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "mSwiftTitleUI.leftView");
      localObject1 = bfvo.a(((TextView)localObject1).getBackground(), -16777216);
      localObject2 = this.mSwiftTitleUI;
      if (localObject2 != null)
      {
        localObject2 = ((bgtw)localObject2).leftView;
        if (localObject2 != null) {
          awhf.a((View)localObject2, (Drawable)localObject1);
        }
      }
      localObject1 = this.mSwiftTitleUI;
      if (localObject1 != null)
      {
        localObject1 = ((bgtw)localObject1).centerView;
        if (localObject1 != null) {
          ((TextView)localObject1).setTextColor(-16777216);
        }
      }
      localObject1 = this.mSwiftTitleUI;
      if (localObject1 != null)
      {
        localObject1 = ((bgtw)localObject1).titleContainer;
        if (localObject1 != null) {
          ((ViewGroup)localObject1).setBackgroundColor(-1);
        }
      }
      localObject1 = getActivity();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "activity");
      ImmersiveUtils.a(true, ((FragmentActivity)localObject1).getWindow());
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
      localObject1 = ((bgtw)localObject1).rightViewImg;
      if (localObject1 == null) {}
    }
    for (localObject1 = ((ImageView)localObject1).getDrawable();; localObject1 = null)
    {
      localObject1 = bfvo.a((Drawable)localObject1, -1);
      if (localObject1 != null)
      {
        Object localObject2 = this.mSwiftTitleUI;
        if (localObject2 != null)
        {
          localObject2 = ((bgtw)localObject2).rightViewImg;
          if (localObject2 != null) {
            ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
          }
        }
        localObject1 = this.mSwiftTitleUI;
        if (localObject1 != null)
        {
          localObject1 = ((bgtw)localObject1).rightViewImg;
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
      localObject1 = ((bgtw)localObject1).leftView;
      if (localObject1 == null) {}
    }
    for (localObject1 = ((TextView)localObject1).getBackground();; localObject1 = null)
    {
      localObject1 = bfvo.a((Drawable)localObject1, -1);
      if (localObject1 != null)
      {
        Object localObject2 = this.mSwiftTitleUI;
        if (localObject2 != null)
        {
          localObject2 = ((bgtw)localObject2).leftView;
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
    this.jdField_d_of_type_Boolean = true;
    g();
    return i;
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
      i = (int)getResources().getDimension(2131299076);
      if (ImmersiveUtils.isSupporImmersive() != 1) {
        break label403;
      }
      i = ImmersiveUtils.getStatusBarHeight((Context)getActivity()) + i;
    }
    label403:
    for (;;)
    {
      paramViewGroup = new FrameLayout.LayoutParams(-1, i + AIOUtils.dp2px(720, getResources()));
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
  
  public void onPageFinished(@Nullable WebView paramWebView, @Nullable String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    this.jdField_a_of_type_Boolean = true;
    paramWebView = this.jdField_a_of_type_Alhe;
    if (paramWebView != null) {
      ((WebViewFragmentWithArk)this).b(paramWebView);
    }
    long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
    algh.a().a(null, "new_webview_loading_times", Long.valueOf(l));
    algs.a(6, "time = " + l);
  }
  
  public void onPageStarted(@Nullable WebView paramWebView, @Nullable String paramString, @Nullable Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    algs.a(5, "");
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
  
  public void setRightButton(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, boolean paramBoolean, int paramInt1, int paramInt2, @Nullable View.OnClickListener paramOnClickListener, @Nullable acjr paramacjr)
  {
    super.setRightButton(paramString1, paramString2, paramString3, paramBoolean, paramInt1, paramInt2, paramOnClickListener, paramacjr);
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
    bgww localbgww = (bgww)this.mComponentsProvider.a(4);
    if (localbgww != null)
    {
      a((List)localbgww.a);
      localbgww.a(ensureShare(), this.mUIStyle.mRulesFromUrl);
    }
    algh.a().a(null, "new_topbar_share_click");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.webpage.WebViewFragmentWithArk
 * JD-Core Version:    0.7.0.1
 */