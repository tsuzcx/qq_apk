package com.tencent.mobileqq.apollo.store;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.ipc.ApolloIPCModule;
import com.tencent.mobileqq.apollo.listener.OnApolloViewListener;
import com.tencent.mobileqq.apollo.store.openbox.ApolloCardWindow;
import com.tencent.mobileqq.apollo.store.openbox.ApolloCardWindow.OnCloseCardWindowListener;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.web.ipc.IStoreAvatar2D;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloTextureView;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.vip.manager.QZoneVipInfoManager;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import mqq.util.LogUtil;
import org.json.JSONObject;

@TargetApi(14)
public class ApolloStoreActivity
  extends QQBrowserActivity
  implements Handler.Callback, OnApolloViewListener, IApolloActivityJsCallBack, IApolloViewControllerCallBack, ApolloCardWindow.OnCloseCardWindowListener
{
  MqqHandler a = new MqqHandler(Looper.getMainLooper(), this);
  private int[] b;
  private int c;
  private String d;
  private String e = "";
  private ApolloCardWindow f;
  private RelativeLayout g;
  private boolean h;
  private boolean i;
  private boolean j;
  private String k;
  private String l;
  private String m;
  private float n = 2.0F;
  private float o = 1.0F;
  private String p;
  private String q;
  private String r;
  private String s;
  private ApolloStoreViewController t;
  private boolean u = true;
  
  private void e()
  {
    if ((this.j) && (this.i) && (this.h))
    {
      if ((AppInterface)super.getAppRuntime() == null)
      {
        this.a.sendEmptyMessageDelayed(255, 1500L);
        return;
      }
      this.a.sendEmptyMessageDelayed(255, 500L);
    }
  }
  
  private void e(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportStorePageLoadSuccess. url:");
    ((StringBuilder)localObject).append(this.e);
    QLog.d("[cmshow]ApolloStoreActivity_apollo_store_stability_", 2, ((StringBuilder)localObject).toString());
    localObject = ApolloStoreStabilityReportManager.a();
    if (((ApolloStoreStabilityReportManager)localObject).b(this.e))
    {
      ((ApolloStoreStabilityReportManager)localObject).a(null, this.e, 1001, paramInt);
      return;
    }
    QLog.d("[cmshow]ApolloStoreActivity_apollo_store_stability_", 2, "reportStorePageLoadTimeout. url is not in white list");
  }
  
  private void f()
  {
    Object localObject = this.t.g();
    if (localObject != null)
    {
      ((ApolloTextureView)localObject).getRenderImpl().a(1, this.s, "Bubble");
      ((ApolloTextureView)localObject).getRenderImpl().a(0L);
    }
    localObject = new Intent(this, ApolloGuestsStateActivity.class);
    ((Intent)localObject).putExtra("extra_guest_uin", this.q);
    ((Intent)localObject).putExtra("extra_guest_nick", this.r);
    ((Intent)localObject).putExtra("extra_guest_from", 4);
    super.startActivity((Intent)localObject);
  }
  
  private void g()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportStorePageLoadTimeout. url:");
    ((StringBuilder)localObject).append(this.e);
    QLog.d("[cmshow]ApolloStoreActivity_apollo_store_stability_", 2, ((StringBuilder)localObject).toString());
    localObject = ApolloStoreStabilityReportManager.a();
    if (((ApolloStoreStabilityReportManager)localObject).b(this.e))
    {
      ((ApolloStoreStabilityReportManager)localObject).a(null, this.e, -1000, 0);
      return;
    }
    QLog.d("[cmshow]ApolloStoreActivity_apollo_store_stability_", 2, "reportStorePageLoadTimeout. url is not in white list");
  }
  
  public String a(int paramInt, ApolloWebAvatarParam paramApolloWebAvatarParam)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initAvatar hasApolloView: ");
    boolean bool;
    if (this.t != null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject).append(bool);
    QLog.i("[cmshow]ApolloStoreActivity", 1, ((StringBuilder)localObject).toString());
    ((IStoreAvatar2D)ApolloIPCModule.a(IStoreAvatar2D.class)).a(new ApolloStoreActivity.2(this));
    if (paramApolloWebAvatarParam == null)
    {
      QLog.e("[cmshow]ApolloStoreActivity", 1, "[initAvatar] no request params");
      return "{\"result\":1, \"msg\": \"缺少请求参数\" }";
    }
    this.s = paramApolloWebAvatarParam.apolloId;
    this.m = paramApolloWebAvatarParam.tab;
    this.q = paramApolloWebAvatarParam.uin;
    this.r = paramApolloWebAvatarParam.nickName;
    this.c = paramApolloWebAvatarParam.roleId;
    this.b = paramApolloWebAvatarParam.dressIds;
    localObject = this.t;
    if (localObject != null) {
      return ((ApolloStoreViewController)localObject).a(paramInt, false, paramApolloWebAvatarParam);
    }
    this.a.sendEmptyMessage(258);
    return "{\"result\":0, \"msg\": \"\" }";
  }
  
  public String a(ApolloStoreViewController.PlayActionData paramPlayActionData)
  {
    ApolloStoreViewController localApolloStoreViewController = this.t;
    if (localApolloStoreViewController != null) {
      return localApolloStoreViewController.a(paramPlayActionData);
    }
    return ApolloStoreViewController.b(HardCodeUtil.a(2131898764));
  }
  
  public String a(ArrayList<ApolloWebAvatarParam> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloStoreActivity", 2, new Object[] { "[updateAvatar] avatarParams=", paramArrayList });
    }
    ApolloStoreViewController localApolloStoreViewController = this.t;
    if (localApolloStoreViewController != null) {
      return localApolloStoreViewController.a(paramArrayList);
    }
    return "{\"result\":1, \"msg\": \"终端发生错误\" }";
  }
  
  public String a(int[] paramArrayOfInt)
  {
    ApolloStoreViewController localApolloStoreViewController = this.t;
    if (localApolloStoreViewController != null) {
      return localApolloStoreViewController.a(paramArrayOfInt);
    }
    return ApolloStoreViewController.b("ApolloViewController not init!");
  }
  
  public void a()
  {
    WebViewFragment localWebViewFragment = getCurrentWebViewFragment();
    if ((localWebViewFragment != null) && (localWebViewFragment.getWebView() != null))
    {
      ApolloStoreViewController localApolloStoreViewController = this.t;
      if ((localApolloStoreViewController != null) && (localApolloStoreViewController.c()))
      {
        localWebViewFragment.getWebView().callJs("window.onReturn &&　window.onReturn()");
        if (!QLog.isColorLevel()) {
          break label65;
        }
        QLog.d("[cmshow]ApolloStoreActivity", 2, "onBackEvent");
        break label65;
      }
    }
    super.onBackEvent();
    label65:
    VipUtils.a(null, "cmshow", "Apollo", "0X80065CA", 0, 0, new String[0]);
  }
  
  public void a(int paramInt)
  {
    QZoneVipInfoManager.a(this, this.q, "lmx_actview");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    QLog.d("[cmshow]ApolloStoreActivity", 2, "Avatar view is Ready.");
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.d("[cmshow]ApolloStoreActivity", 2, new Object[] { "[onNotifyStatusChanged] status=", Integer.valueOf(paramInt), ", apolloId=", paramString });
    if (7 == paramInt)
    {
      b(1);
      return;
    }
    WebViewFragment localWebViewFragment = getCurrentWebViewFragment();
    if ((localWebViewFragment != null) && (localWebViewFragment.getWebView() != null)) {
      if (TextUtils.isEmpty(paramString)) {
        localWebViewFragment.getWebView().callJs("window.apollo && window.apollo.controller && window.apollo.controller.hitAvatar && window.apollo.controller.hitAvatar();");
      } else {
        localWebViewFragment.getWebView().callJs(String.format("window.apollo && window.apollo.controller && window.apollo.controller.hitAvatar && window.apollo.controller.hitAvatar('%s');", new Object[] { paramString }));
      }
    }
    QLog.d("[cmshow]ApolloStoreActivity", 2, "apollo.controller.hitAvatar()");
  }
  
  public void a(int paramInt, int[] paramArrayOfInt)
  {
    ApolloStoreViewController localApolloStoreViewController = this.t;
    if (localApolloStoreViewController != null) {
      localApolloStoreViewController.a(paramInt, paramArrayOfInt);
    }
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      paramActivity = this.p;
      paramString2 = this.t;
      if (paramString2 != null) {
        paramString2.a(this, (AppInterface)super.getAppRuntime(), paramString1, paramActivity);
      }
    }
  }
  
  void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    this.o = (FontSettingManager.getFontLevel() / 16.0F);
    if (this.o != 0.0F) {
      this.n = (DeviceInfoUtil.A() / this.o);
    }
    if (this.n == 0.0F) {
      this.n = DeviceInfoUtil.A();
    }
  }
  
  public void a(RelativeLayout paramRelativeLayout)
  {
    if (paramRelativeLayout != null)
    {
      if (this.g != null) {
        return;
      }
      this.g = paramRelativeLayout;
      if (this.g != null)
      {
        if (this.t != null) {
          return;
        }
        if (ApolloEngine.isEngineReady())
        {
          this.t = new ApolloStoreViewController(this.g, this);
          this.t.a(this);
        }
        else
        {
          paramRelativeLayout = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
          if (paramRelativeLayout != null) {
            paramRelativeLayout.setHandler(ApolloStoreActivity.class, this.a);
          }
          ThreadManager.postImmediately(new ApolloStoreActivity.1(this), null, true);
        }
        e();
      }
    }
  }
  
  public void a(ApolloTextureView paramApolloTextureView)
  {
    paramApolloTextureView = this.f;
    if ((paramApolloTextureView != null) && (paramApolloTextureView.getVisibility() == 0)) {
      this.f.bringToFront();
    }
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNotifyLongTouch:");
    localStringBuilder.append(paramString);
    QLog.d("[cmshow]ApolloStoreActivity", 2, localStringBuilder.toString());
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.s))) {
      b(0);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ApolloStoreViewController localApolloStoreViewController = this.t;
    if (localApolloStoreViewController != null) {
      localApolloStoreViewController.a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    ApolloStoreViewController localApolloStoreViewController = this.t;
    if (localApolloStoreViewController != null) {
      localApolloStoreViewController.a(paramBoolean, paramFloat1, paramFloat2);
    }
  }
  
  public String b()
  {
    ApolloStoreViewController localApolloStoreViewController = this.t;
    if (localApolloStoreViewController != null) {
      return localApolloStoreViewController.d();
    }
    return "{\"result\":1,\"msg\":\"ApolloViewController not init\"}";
  }
  
  public void b(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[openAIActivity], from:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("[cmshow]ApolloStoreActivity", 2, ((StringBuilder)localObject).toString());
    if (!ApolloEngine.isEngineReady()) {
      return;
    }
    if (this.t == null) {
      return;
    }
    if (!"interactive".equals(this.m)) {
      return;
    }
    localObject = getAppRuntime().getCurrentAccountUin();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(this.q))) {
      ((String)localObject).equals(this.q);
    }
    f();
  }
  
  public void b(ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloStoreActivity", 2, "[destoryAvatar]");
    }
    ApolloStoreViewController localApolloStoreViewController = this.t;
    if (localApolloStoreViewController != null) {
      localApolloStoreViewController.b(paramArrayList);
    }
  }
  
  public boolean b(String paramString)
  {
    try
    {
      if (this.t != null) {
        this.t.c(true);
      }
      Intent localIntent = new Intent(this, ApolloDiyTextFragment.class);
      localIntent.putExtra("extra_key_last_text", paramString);
      localIntent.putExtra("public_fragment_window_feature", 1);
      PublicTransFragmentActivity.b(this, localIntent, ApolloDiyTextFragment.class, 1);
      return true;
    }
    catch (Exception paramString)
    {
      QLog.e("[cmshow]ApolloStoreActivity", 1, paramString.getMessage());
    }
    return false;
  }
  
  public void c() {}
  
  public void c(int paramInt)
  {
    Object localObject = getCurrentWebViewFragment();
    if ((localObject != null) && (((WebViewFragment)localObject).getSwiftTitleUI() != null) && (((WebViewFragment)localObject).getSwiftTitleUI().d != null))
    {
      localObject = ((WebViewFragment)localObject).getSwiftTitleUI().d;
      int i1;
      if (paramInt > 0) {
        i1 = 0;
      } else {
        i1 = 4;
      }
      ((TextView)localObject).setVisibility(i1);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setBackViewVisibility,visibility:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("[cmshow]ApolloStoreActivity", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public boolean c(String paramString)
  {
    if ((this.g != null) && (!TextUtils.isEmpty(paramString)))
    {
      localObject = this.f;
      if (localObject == null)
      {
        this.f = new ApolloCardWindow(this);
        localObject = new RelativeLayout.LayoutParams(-1, -1);
        this.g.addView(this.f, (ViewGroup.LayoutParams)localObject);
      }
      else
      {
        ((ApolloCardWindow)localObject).bringToFront();
      }
      this.f.a(this.g, paramString, "store", (AppInterface)getAppRuntime(), this);
      a(false);
      return true;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("openBox error : mRootView:");
    ((StringBuilder)localObject).append(this.g);
    ((StringBuilder)localObject).append(" uin:");
    ((StringBuilder)localObject).append(LogUtil.wrapLogUin(paramString));
    QLog.e("[cmshow]ApolloStoreActivity", 1, ((StringBuilder)localObject).toString());
    return false;
  }
  
  public void d()
  {
    if (getIntent().getIntExtra("extra_key_jump_src", 0) == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloStoreActivity", 2, "send broadcast to finish jump activity");
      }
      Intent localIntent = new Intent();
      localIntent.setAction("BroadcastReceiverFinishActivity");
      sendBroadcast(localIntent);
    }
  }
  
  public void d(int paramInt)
  {
    ApolloStoreViewController localApolloStoreViewController = this.t;
    if (localApolloStoreViewController != null) {
      localApolloStoreViewController.b(paramInt);
    }
  }
  
  public void d(String paramString)
  {
    Object localObject = getCurrentWebViewFragment();
    if ((localObject != null) && (((WebViewFragment)localObject).getWebView() != null))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("window && window.apollo && window.apollo.controller && window.apollo.controller.closeBox && window.apollo.controller.closeBox('");
      localStringBuilder.append(paramString);
      localStringBuilder.append("')");
      paramString = localStringBuilder.toString();
      ((WebViewFragment)localObject).getWebView().callJs(paramString);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onCardWindowClose,callBackStr:");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("[cmshow]ApolloStoreActivity", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject1;
    if (paramInt1 != 1)
    {
      if (paramInt1 != 15)
      {
        if ((paramInt1 == 14005) || (paramInt1 == 14006))
        {
          localObject1 = this.t;
          if (localObject1 != null)
          {
            localObject1 = ((ApolloStoreViewController)localObject1).g();
            if (localObject1 != null) {
              ((ApolloTextureView)localObject1).queueEvent(new ApolloStoreActivity.3(this, paramInt1, paramInt2, paramIntent));
            }
          }
        }
      }
      else if (paramInt2 == -1) {
        VipUtils.a(null, "cmshow", "Apollo", "QzoneSuccess", 0, 0, new String[0]);
      }
    }
    else
    {
      Object localObject2 = null;
      if (paramIntent != null) {
        localObject2 = paramIntent.getStringExtra("text");
      }
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = "";
      }
      else
      {
        localObject1 = localObject2;
        if (((String)localObject2).length() > 12) {
          localObject1 = ((String)localObject2).substring(0, 12);
        }
      }
      localObject2 = getCurrentWebViewFragment();
      if ((localObject2 != null) && (((WebViewFragment)localObject2).getWebView() != null))
      {
        StringBuilder localStringBuilder;
        if (paramInt2 == -1)
        {
          localObject2 = ((WebViewFragment)localObject2).getWebView();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("window.apollo && window.apollo.controller && window.apollo.controller.closeEditor && window.apollo.controller.closeEditor(1,'");
          localStringBuilder.append(ApolloUtilImpl.encodeURL((String)localObject1));
          localStringBuilder.append("')");
          ((CustomWebView)localObject2).callJs(localStringBuilder.toString());
        }
        else
        {
          localObject2 = ((WebViewFragment)localObject2).getWebView();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("window.apollo && window.apollo.controller && window.apollo.controller.closeEditor && window.apollo.controller.closeEditor(0,'");
          localStringBuilder.append(ApolloUtilImpl.encodeURL((String)localObject1));
          localStringBuilder.append("')");
          ((CustomWebView)localObject2).callJs(localStringBuilder.toString());
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("doOnActivityResult requestCode:");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(" resultCode:");
      ((StringBuilder)localObject1).append(paramInt2);
      ((StringBuilder)localObject1).append(" data:");
      ((StringBuilder)localObject1).append(paramIntent);
      QLog.d("[cmshow]ApolloStoreActivity", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  @SuppressLint({"NewApi"})
  public boolean doOnCreate(Bundle paramBundle)
  {
    long l1 = System.currentTimeMillis();
    QLog.d("[cmshow]ApolloStoreActivity", 2, "apollo_client ApolloStoreActivity start create!");
    a(super.getIntent());
    Object localObject2 = super.getIntent().getStringExtra("url");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = ApolloConstant.w;
    }
    localObject2 = new StringBuilder((String)localObject1);
    this.j = super.getIntent().getBooleanExtra("extra_key_open_box", false);
    this.l = super.getIntent().getStringExtra("extra_key_box_uin");
    this.k = super.getIntent().getStringExtra("extra_key_box_from");
    this.p = super.getIntent().getStringExtra("extra_key_nickname");
    long l2 = DeviceInfoUtil.E();
    long l3 = DeviceInfoUtil.D();
    int i1 = (int)(ImmersiveUtils.getStatusBarHeight(this) / this.n);
    if (((String)localObject1).indexOf("?") == -1) {
      ((StringBuilder)localObject2).append("?");
    } else {
      ((StringBuilder)localObject2).append("&");
    }
    ((StringBuilder)localObject2).append("screenWidth=");
    ((StringBuilder)localObject2).append((int)((float)l3 / this.n));
    ((StringBuilder)localObject2).append("&screenHeight=");
    ((StringBuilder)localObject2).append((int)((float)l2 / this.n));
    ((StringBuilder)localObject2).append("&statusBarHeight=");
    ((StringBuilder)localObject2).append(i1);
    ((StringBuilder)localObject2).append("&screenDensity=");
    ((StringBuilder)localObject2).append(this.n);
    String str = super.getIntent().getStringExtra("extra_key_url_append");
    if (!TextUtils.isEmpty(str)) {
      if (str.startsWith("&"))
      {
        ((StringBuilder)localObject2).append(str);
      }
      else
      {
        ((StringBuilder)localObject2).append("&");
        ((StringBuilder)localObject2).append(str);
      }
    }
    str = super.getIntent().getStringExtra("extra_key_adtag");
    if (!TextUtils.isEmpty(str))
    {
      ((StringBuilder)localObject2).append("&adtag=");
      ((StringBuilder)localObject2).append(str);
    }
    if (this.j)
    {
      ((StringBuilder)localObject2).append("&openCapsule=1");
      ((StringBuilder)localObject2).append("&openBox=true");
    }
    else
    {
      ((StringBuilder)localObject2).append("&openCapsule=0");
      ((StringBuilder)localObject2).append("&openBox=false");
    }
    if (((String)localObject1).indexOf("&_wv") < 0)
    {
      ((StringBuilder)localObject2).append("&_wv=");
      ((StringBuilder)localObject2).append(16777223L);
    }
    if (((String)localObject1).indexOf("&_wwv") < 0)
    {
      ((StringBuilder)localObject2).append("&_wwv=");
      ((StringBuilder)localObject2).append(520L);
    }
    ((StringBuilder)localObject2).append("&webviewOpenType=1");
    this.d = ((StringBuilder)localObject2).toString();
    getIntent().putExtra("url", this.d);
    this.mFragmentClass = ApolloStoreActivity.ApolloWebViewFragment.class;
    super.doOnCreate(paramBundle);
    ApolloCardWindow.b();
    if (!((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).doBindService(super.getApplicationContext());
    }
    this.i = true;
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("apollo_client ApolloStoreActivity end create! use:");
      paramBundle.append(System.currentTimeMillis() - l1);
      QLog.d("[cmshow]ApolloStoreActivity", 2, paramBundle.toString());
    }
    return false;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 4).edit();
    ((SharedPreferences.Editor)localObject).remove("apollo_store_watch_current_url");
    ((SharedPreferences.Editor)localObject).apply();
    localObject = this.t;
    if (localObject != null) {
      ((ApolloStoreViewController)localObject).f();
    }
    localObject = this.f;
    if (localObject != null) {
      ((ApolloCardWindow)localObject).a(true);
    }
    this.a.removeCallbacksAndMessages(null);
    localObject = (AppInterface)getAppRuntime();
    if (localObject != null) {
      ((AppInterface)localObject).removeHandler(ApolloStoreActivity.class);
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    long l1 = DeviceInfoUtil.E();
    long l2 = DeviceInfoUtil.D();
    Object localObject2 = paramIntent.getStringExtra("url");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = super.getIntent().getStringExtra("url");
    }
    String str = paramIntent.getStringExtra("extra_key_url_append");
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      if (TextUtils.isEmpty(ApolloConstant.H)) {
        localObject2 = ApolloConstant.w;
      } else {
        localObject2 = ApolloConstant.H;
      }
    }
    int i1 = (int)(ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()) / this.n);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append("&screenWidth=");
    ((StringBuilder)localObject1).append((int)((float)l2 / this.n));
    ((StringBuilder)localObject1).append("&screenHeight=");
    ((StringBuilder)localObject1).append((int)((float)l1 / this.n));
    ((StringBuilder)localObject1).append("&statusBarHeight=");
    ((StringBuilder)localObject1).append(i1);
    ((StringBuilder)localObject1).append("&screenDensity=");
    ((StringBuilder)localObject1).append(this.n);
    this.d = ((StringBuilder)localObject1).toString();
    if (!TextUtils.isEmpty(str)) {
      if (str.startsWith("&"))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.d);
        ((StringBuilder)localObject1).append(str);
        this.d = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.d);
        ((StringBuilder)localObject1).append("&");
        ((StringBuilder)localObject1).append(str);
        this.d = ((StringBuilder)localObject1).toString();
      }
    }
    if (!this.d.contains("tab"))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.d);
      ((StringBuilder)localObject1).append("&tab=mall");
      this.d = ((StringBuilder)localObject1).toString();
    }
    if (this.d.indexOf("&_wv") < 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.d);
      ((StringBuilder)localObject1).append("&_wv=");
      ((StringBuilder)localObject1).append(16777223L);
      this.d = ((StringBuilder)localObject1).toString();
    }
    if (this.d.indexOf("&_wwv") < 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.d);
      ((StringBuilder)localObject1).append("&_wwv=");
      ((StringBuilder)localObject1).append(520L);
      this.d = ((StringBuilder)localObject1).toString();
    }
    paramIntent.putExtra("url", this.d);
    super.doOnNewIntent(paramIntent);
  }
  
  public String e(String paramString)
  {
    Object localObject = this.t;
    if (localObject == null) {
      return "";
    }
    localObject = ((ApolloStoreViewController)localObject).g();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloStoreActivity", 2, "[saveImage] failed view null");
      }
      return "";
    }
    long l1 = System.currentTimeMillis();
    ThreadManager.executeOnSubThread(new ApolloStoreActivity.4(this, ((ApolloTextureView)localObject).getBitmap(), l1, paramString));
    return "";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    JSONObject localJSONObject;
    if (i1 != 255)
    {
      if (i1 != 256)
      {
        if (i1 != 258) {
          return false;
        }
        if (QLog.isColorLevel())
        {
          paramMessage = new StringBuilder();
          paramMessage.append("recv refresh apollo view msf, apolloView is null: ");
          boolean bool;
          if (this.t == null) {
            bool = true;
          } else {
            bool = false;
          }
          paramMessage.append(bool);
          QLog.d("[cmshow]ApolloStoreActivity", 2, paramMessage.toString());
        }
        if (!ApolloEngine.isEngineReady()) {
          break label393;
        }
        paramMessage = this.g;
        if ((paramMessage == null) || (this.t != null)) {
          break label393;
        }
        this.t = new ApolloStoreViewController(paramMessage, this);
        this.t.a(this);
        return false;
      }
      localObject2 = getCurrentWebViewFragment();
      if (localObject2 == null) {
        return false;
      }
      if ((((WebViewFragment)localObject2).getWebView() == null) || (!(paramMessage.obj instanceof String))) {
        break label393;
      }
      localObject1 = (String)paramMessage.obj;
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("result", paramMessage.arg1);
    }
    catch (Throwable paramMessage)
    {
      label190:
      break label190;
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloStoreActivity", 2, "[save img] json null");
    }
    paramMessage = ((WebViewFragment)localObject2).getWebView();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("(");
    ((StringBuilder)localObject2).append(localJSONObject.toString());
    ((StringBuilder)localObject2).append(");");
    paramMessage.callJs(((StringBuilder)localObject2).toString());
    return false;
    paramMessage = this.g;
    if (paramMessage == null) {
      return false;
    }
    Object localObject1 = this.f;
    if (localObject1 == null)
    {
      this.f = new ApolloCardWindow(paramMessage.getContext());
      paramMessage = new RelativeLayout.LayoutParams(-1, -1);
      this.g.addView(this.f, paramMessage);
    }
    else
    {
      ((ApolloCardWindow)localObject1).bringToFront();
    }
    if (this.j)
    {
      paramMessage = (AppInterface)getAppRuntime();
      if (paramMessage != null)
      {
        if (TextUtils.isEmpty(this.l)) {
          this.l = paramMessage.getCurrentAccountUin();
        }
        this.f.a(this.g, this.l, this.k, paramMessage, this);
      }
    }
    label393:
    return false;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.h = true;
    e();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onConfigurationChanged orientation:");
    localStringBuilder.append(paramConfiguration.orientation);
    QLog.d("[cmshow]ApolloStoreActivity", 2, localStringBuilder.toString());
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.u))
    {
      this.u = false;
      d();
    }
  }
  
  public boolean showPreview()
  {
    super.showPreview();
    super.setImmersiveStatus();
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.init();
      int i1 = super.getResources().getColor(2131168092);
      this.mSystemBarComp.setStatusColor(i1);
      this.mSystemBarComp.setStatusBarColor(i1);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloStoreActivity
 * JD-Core Version:    0.7.0.1
 */