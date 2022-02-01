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
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.apollo.ApolloStoreStabilityReportManager;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.api.listener.OnApolloViewListener;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.api.web.impl.ApolloJsPluginImpl;
import com.tencent.mobileqq.apollo.store.openbox.ApolloCardWindow;
import com.tencent.mobileqq.apollo.store.openbox.ApolloCardWindow.OnCloseCardWindowListener;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qzone.QZoneVipInfoManager;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

@TargetApi(14)
public class ApolloStoreActivity
  extends QQBrowserActivity
  implements Handler.Callback, OnApolloViewListener, IApolloActivityJsCallBack, IApolloViewControllerCallBack, ApolloCardWindow.OnCloseCardWindowListener
{
  private float jdField_a_of_type_Float = 2.0F;
  int jdField_a_of_type_Int;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private ApolloViewController jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController;
  private ApolloCardWindow jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow;
  private String jdField_a_of_type_JavaLangString;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
  private boolean jdField_a_of_type_Boolean;
  int[] jdField_a_of_type_ArrayOfInt;
  private float jdField_b_of_type_Float = 1.0F;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = true;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  
  private void d()
  {
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean))
    {
      if (super.getAppInterface() == null) {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(255, 1500L);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(255, 500L);
  }
  
  private void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.a();
    if (localObject != null)
    {
      ((ApolloTextureView)localObject).getRenderImpl().a(1, this.i, "Bubble");
      ((ApolloTextureView)localObject).getRenderImpl().a(0L);
    }
    localObject = new Intent(this, ApolloGuestsStateActivity.class);
    ((Intent)localObject).putExtra("extra_guest_uin", this.g);
    ((Intent)localObject).putExtra("extra_guest_nick", this.h);
    ((Intent)localObject).putExtra("extra_guest_from", 4);
    super.startActivity((Intent)localObject);
  }
  
  private void e(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloStoreActivity_apollo_store_stability_", 2, "reportStorePageLoadSuccess. url:" + this.jdField_b_of_type_JavaLangString);
    }
    ApolloStoreStabilityReportManager localApolloStoreStabilityReportManager = ApolloStoreStabilityReportManager.a();
    if (localApolloStoreStabilityReportManager.b(this.jdField_b_of_type_JavaLangString)) {
      localApolloStoreStabilityReportManager.a(null, this.jdField_b_of_type_JavaLangString, 1001, paramInt);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ApolloStoreActivity_apollo_store_stability_", 2, "reportStorePageLoadTimeout. url is not in white list");
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloStoreActivity_apollo_store_stability_", 2, "reportStorePageLoadTimeout. url:" + this.jdField_b_of_type_JavaLangString);
    }
    ApolloStoreStabilityReportManager localApolloStoreStabilityReportManager = ApolloStoreStabilityReportManager.a();
    if (localApolloStoreStabilityReportManager.b(this.jdField_b_of_type_JavaLangString)) {
      localApolloStoreStabilityReportManager.a(null, this.jdField_b_of_type_JavaLangString, -1000, 0);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ApolloStoreActivity_apollo_store_stability_", 2, "reportStorePageLoadTimeout. url is not in white list");
  }
  
  public String a()
  {
    getCurrentAccountUin();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController != null) {
      return this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.a();
    }
    return "{\"result\":1,\"msg\":\"ApolloViewController not init\"}";
  }
  
  public String a(int paramInt, ApolloWebAvatarParam paramApolloWebAvatarParam)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("initAvatar hasApolloView: ");
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.i("ApolloStoreActivity", 1, bool);
      b("ipc_apollo_query_mine_redinfo");
      if (paramApolloWebAvatarParam != null) {
        break;
      }
      QLog.e("ApolloStoreActivity", 1, "[initAvatar] no request params");
      return "{\"result\":1, \"msg\": \"缺少请求参数\" }";
    }
    this.i = paramApolloWebAvatarParam.apolloId;
    this.e = paramApolloWebAvatarParam.tab;
    this.g = paramApolloWebAvatarParam.uin;
    this.h = paramApolloWebAvatarParam.nickName;
    this.jdField_a_of_type_Int = paramApolloWebAvatarParam.roleId;
    this.jdField_a_of_type_ArrayOfInt = paramApolloWebAvatarParam.dressIds;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController != null) {
      return this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.a(paramInt, false, paramApolloWebAvatarParam);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(258);
    return "{\"result\":0, \"msg\": \"\" }";
  }
  
  public String a(ApolloViewController.PlayActionData paramPlayActionData)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController != null) {
      return this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.a(paramPlayActionData);
    }
    return ApolloViewController.a(HardCodeUtil.a(2131700597));
  }
  
  public String a(String paramString)
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (TextUtils.isEmpty(paramString))) {
      return "{\"result\":1,\"msg\":\"uin是空\"}";
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow = new ApolloCardWindow(this);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow, localLayoutParams);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, paramString, "store", getAppInterface(), this);
      a(false);
      return "{\"result\":0,\"msg\":\"\"}";
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow.bringToFront();
    }
  }
  
  public String a(ArrayList<ApolloWebAvatarParam> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloStoreActivity", 2, new Object[] { "[updateAvatar] avatarParams=", paramArrayList });
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController != null) {
      return this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.a(paramArrayList);
    }
    return "{\"result\":1, \"msg\": \"终端发生错误\" }";
  }
  
  public String a(int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController != null) {
      return this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.a(paramArrayOfInt);
    }
    return ApolloViewController.a("ApolloViewController not init!");
  }
  
  public void a()
  {
    WebViewFragment localWebViewFragment = getCurrentWebViewFragment();
    if ((localWebViewFragment != null) && (localWebViewFragment.webView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.a()))
    {
      localWebViewFragment.webView.callJs("window.onReturn &&　window.onReturn()");
      if (QLog.isColorLevel()) {
        QLog.d("ApolloStoreActivity", 2, "onBackEvent");
      }
    }
    for (;;)
    {
      VipUtils.a(null, "cmshow", "Apollo", "0X80065CA", 0, 0, new String[0]);
      return;
      super.onBackEvent();
    }
  }
  
  public void a(int paramInt)
  {
    QZoneVipInfoManager.cmJumpToYellowPlayDialog(this, this.g, "lmx_actview");
  }
  
  public void a(int paramInt, int[] paramArrayOfInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.a(paramInt, paramArrayOfInt);
    }
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      paramActivity = this.f;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.a(this, super.getAppInterface(), paramString1, paramActivity);
      }
    }
  }
  
  void a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      this.jdField_b_of_type_Float = (FontSettingManager.getFontLevel() / 16.0F);
      if (this.jdField_b_of_type_Float != 0.0F) {
        this.jdField_a_of_type_Float = (DeviceInfoUtil.a() / this.jdField_b_of_type_Float);
      }
    } while (this.jdField_a_of_type_Float != 0.0F);
    this.jdField_a_of_type_Float = DeviceInfoUtil.a();
  }
  
  public void a(RelativeLayout paramRelativeLayout)
  {
    if ((paramRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
      if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController == null))
      {
        if (!ApolloEngine.a()) {
          break label65;
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController = new ApolloViewController(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this);
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.a(this);
      }
    }
    for (;;)
    {
      d();
      return;
      label65:
      paramRelativeLayout = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setHandler(ApolloStoreActivity.class, this.jdField_a_of_type_MqqOsMqqHandler);
      }
      ThreadManager.postImmediately(new ApolloStoreActivity.1(this), null, true);
    }
  }
  
  public void a(ApolloTextureView paramApolloTextureView)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow.bringToFront();
    }
  }
  
  public void a(String paramString)
  {
    WebViewFragment localWebViewFragment = getCurrentWebViewFragment();
    if ((localWebViewFragment == null) || (localWebViewFragment.webView == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      paramString = "window && window.apollo && window.apollo.controller && window.apollo.controller.closeBox && window.apollo.controller.closeBox('" + paramString + "')";
      localWebViewFragment.webView.callJs(paramString);
    } while (!QLog.isColorLevel());
    QLog.d("ApolloStoreActivity", 2, "onCardWindowClose,callBackStr:" + paramString);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    Object localObject = getCurrentWebViewFragment();
    if ((localObject == null) || (((WebViewFragment)localObject).webView == null)) {}
    do
    {
      do
      {
        do
        {
          return;
          localObject = ((WebViewFragment)localObject).webView.getPluginEngine();
        } while (localObject == null);
        localObject = (ApolloJsPluginImpl)((WebViewPluginEngine)localObject).a("apollo");
      } while (localObject == null);
      ((ApolloJsPluginImpl)localObject).mReqBundle.clear();
      if (paramBundle != null) {
        ((ApolloJsPluginImpl)localObject).mReqBundle = paramBundle;
      }
      ((ApolloJsPluginImpl)localObject).sendRemoteReq(DataFactory.a(paramString, "", ((ApolloJsPluginImpl)localObject).getRemoteKey(), ((ApolloJsPluginImpl)localObject).mReqBundle), false, true);
    } while (!QLog.isColorLevel());
    QLog.d("ApolloStoreActivity", 2, "[doIPCRequest], cmd" + paramString);
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloStoreActivity", 2, "[destoryAvatar]");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.a(paramArrayList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.a(paramBoolean, paramFloat1, paramFloat2);
    }
  }
  
  public boolean a(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.c(true);
      }
      Intent localIntent = new Intent(this, ApolloDiyTextFragment.class);
      localIntent.putExtra("extra_key_last_text", paramString);
      localIntent.putExtra("public_fragment_window_feature", 1);
      PublicTransFragmentActivity.b(this, localIntent, ApolloDiyTextFragment.class, 1);
      return true;
    }
    catch (Exception paramString)
    {
      QLog.e("ApolloStoreActivity", 1, paramString.getMessage());
    }
    return false;
  }
  
  public String b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController == null) {}
    ApolloTextureView localApolloTextureView;
    do
    {
      return "";
      localApolloTextureView = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.a();
      if (localApolloTextureView != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ApolloStoreActivity", 2, "[saveImage] failed view null");
    return "";
    long l = System.currentTimeMillis();
    ThreadManager.executeOnSubThread(new ApolloStoreActivity.3(this, localApolloTextureView.getBitmap(), l, paramString));
    return "";
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloStoreActivity", 2, "[openAIActivity], from:" + paramInt);
    }
    if (!ApolloEngine.a()) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController == null) || (!"interactive".equals(this.e))) {
      return;
    }
    String str = getCurrentAccountUin();
    if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(this.g))) {}
    for (;;)
    {
      e();
      return;
      if (str.equals(this.g)) {}
    }
  }
  
  public void b(String paramString)
  {
    a(paramString, null);
  }
  
  public void c()
  {
    if (getIntent().getIntExtra("extra_key_jump_src", 0) == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloStoreActivity", 2, "send broadcast to finish jump activity");
      }
      Intent localIntent = new Intent();
      localIntent.setAction("BroadcastReceiverFinishActivity");
      sendBroadcast(localIntent);
    }
  }
  
  public void c(int paramInt)
  {
    Object localObject = getCurrentWebViewFragment();
    if ((localObject != null) && (((WebViewFragment)localObject).mSwiftTitleUI != null) && (((WebViewFragment)localObject).mSwiftTitleUI.a != null))
    {
      localObject = ((WebViewFragment)localObject).mSwiftTitleUI.a;
      if (paramInt <= 0) {
        break label78;
      }
    }
    label78:
    for (int j = 0;; j = 4)
    {
      ((TextView)localObject).setVisibility(j);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloStoreActivity", 2, "setBackViewVisibility,visibility:" + paramInt);
      }
      return;
    }
  }
  
  public void d(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.b(paramInt);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject2 = null;
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloStoreActivity", 2, "doOnActivityResult requestCode:" + paramInt1 + " resultCode:" + paramInt2 + " data:" + paramIntent);
      }
      return;
      if (paramIntent != null) {
        localObject2 = paramIntent.getStringExtra("text");
      }
      Object localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "";
      }
      for (;;)
      {
        localObject2 = getCurrentWebViewFragment();
        if ((localObject2 == null) || (((WebViewFragment)localObject2).webView == null)) {
          break;
        }
        if (paramInt2 != -1) {
          break label222;
        }
        ((WebViewFragment)localObject2).webView.callJs("window.apollo && window.apollo.controller && window.apollo.controller.closeEditor && window.apollo.controller.closeEditor(1,'" + ApolloUtilImpl.encodeURL((String)localObject1) + "')");
        break;
        localObject1 = localObject2;
        if (((String)localObject2).length() > 12) {
          localObject1 = ((String)localObject2).substring(0, 12);
        }
      }
      label222:
      ((WebViewFragment)localObject2).webView.callJs("window.apollo && window.apollo.controller && window.apollo.controller.closeEditor && window.apollo.controller.closeEditor(0,'" + ApolloUtilImpl.encodeURL((String)localObject1) + "')");
      continue;
      if (paramInt2 == -1)
      {
        VipUtils.a(null, "cmshow", "Apollo", "QzoneSuccess", 0, 0, new String[0]);
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController != null)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.a();
          if (localObject1 != null) {
            ((ApolloTextureView)localObject1).queueEvent(new ApolloStoreActivity.2(this, paramInt1, paramInt2, paramIntent));
          }
        }
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  public boolean doOnCreate(Bundle paramBundle)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ApolloStoreActivity", 2, "apollo_client ApolloStoreActivity start create!");
    }
    a(super.getIntent());
    Object localObject2 = super.getIntent().getStringExtra("url");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = ApolloConstant.j;
    }
    localObject2 = new StringBuilder((String)localObject1);
    String str1 = super.getIntent().getStringExtra("extra_key_url_append");
    this.jdField_c_of_type_Boolean = super.getIntent().getBooleanExtra("extra_key_open_box", false);
    this.jdField_d_of_type_JavaLangString = super.getIntent().getStringExtra("extra_key_box_uin");
    this.jdField_c_of_type_JavaLangString = super.getIntent().getStringExtra("extra_key_box_from");
    this.f = super.getIntent().getStringExtra("extra_key_nickname");
    String str2 = super.getIntent().getStringExtra("extra_key_adtag");
    long l2 = DeviceInfoUtil.j();
    long l3 = DeviceInfoUtil.i();
    int j = (int)(ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()) / this.jdField_a_of_type_Float);
    if (((String)localObject1).indexOf("?") == -1)
    {
      ((StringBuilder)localObject2).append("?");
      ((StringBuilder)localObject2).append("screenWidth=").append((int)((float)l3 / this.jdField_a_of_type_Float)).append("&screenHeight=").append((int)((float)l2 / this.jdField_a_of_type_Float)).append("&statusBarHeight=").append(j).append("&screenDensity=").append(this.jdField_a_of_type_Float);
      if (!TextUtils.isEmpty(str1))
      {
        if (!str1.startsWith("&")) {
          break label507;
        }
        ((StringBuilder)localObject2).append(str1);
      }
      label282:
      if (!TextUtils.isEmpty(str2)) {
        ((StringBuilder)localObject2).append("&adtag=").append(str2);
      }
      if (!this.jdField_c_of_type_Boolean) {
        break label524;
      }
      ((StringBuilder)localObject2).append("&openCapsule=1");
      ((StringBuilder)localObject2).append("&openBox=true");
    }
    for (;;)
    {
      if (((String)localObject1).indexOf("&_wv") < 0) {
        ((StringBuilder)localObject2).append("&_wv=").append(16777223L);
      }
      if (((String)localObject1).indexOf("&_wwv") < 0) {
        ((StringBuilder)localObject2).append("&_wwv=").append(520L);
      }
      ((StringBuilder)localObject2).append("&webviewOpenType=1");
      this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
      getIntent().putExtra("url", this.jdField_a_of_type_JavaLangString);
      this.mFragmentClass = ApolloStoreActivity.ApolloWebViewFragment.class;
      super.doOnCreate(paramBundle);
      ApolloCardWindow.b();
      if (!WebIPCOperator.a().a()) {
        WebIPCOperator.a().a().doBindService(super.getApplicationContext());
      }
      this.jdField_b_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloStoreActivity", 2, "apollo_client ApolloStoreActivity end create! use:" + (System.currentTimeMillis() - l1));
      }
      return false;
      ((StringBuilder)localObject2).append("&");
      break;
      label507:
      ((StringBuilder)localObject2).append("&").append(str1);
      break label282;
      label524:
      ((StringBuilder)localObject2).append("&openCapsule=0");
      ((StringBuilder)localObject2).append("&openBox=false");
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 4).edit();
    ((SharedPreferences.Editor)localObject).remove("apollo_store_watch_current_url");
    ((SharedPreferences.Editor)localObject).apply();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow.a(true);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    localObject = getAppInterface();
    if (localObject != null) {
      ((AppInterface)localObject).removeHandler(ApolloStoreActivity.class);
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    long l1 = DeviceInfoUtil.j();
    long l2 = DeviceInfoUtil.i();
    Object localObject2 = paramIntent.getStringExtra("url");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = super.getIntent().getStringExtra("url");
    }
    String str = paramIntent.getStringExtra("extra_key_url_append");
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (TextUtils.isEmpty(ApolloConstant.u)) {
        localObject2 = ApolloConstant.j;
      }
    }
    else
    {
      int j = (int)(ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()) / this.jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaLangString = ((String)localObject2 + "&screenWidth=" + (int)((float)l2 / this.jdField_a_of_type_Float) + "&screenHeight=" + (int)((float)l1 / this.jdField_a_of_type_Float) + "&statusBarHeight=" + j + "&screenDensity=" + this.jdField_a_of_type_Float);
      if (!TextUtils.isEmpty(str)) {
        if (!str.startsWith("&")) {
          break label371;
        }
      }
    }
    label371:
    for (this.jdField_a_of_type_JavaLangString += str;; this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "&" + str))
    {
      if (!this.jdField_a_of_type_JavaLangString.contains("tab")) {
        this.jdField_a_of_type_JavaLangString += "&tab=mall";
      }
      if (this.jdField_a_of_type_JavaLangString.indexOf("&_wv") < 0) {
        this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "&_wv=" + 16777223L);
      }
      if (this.jdField_a_of_type_JavaLangString.indexOf("&_wwv") < 0) {
        this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "&_wwv=" + 520L);
      }
      paramIntent.putExtra("url", this.jdField_a_of_type_JavaLangString);
      super.doOnNewIntent(paramIntent);
      return;
      localObject2 = ApolloConstant.u;
      break;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 257: 
    default: 
    case 255: 
    case 256: 
      WebViewFragment localWebViewFragment;
      do
      {
        do
        {
          return false;
        } while (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null);
        if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow = new ApolloCardWindow(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext());
          paramMessage = new RelativeLayout.LayoutParams(-1, -1);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow, paramMessage);
        }
        while (this.jdField_c_of_type_Boolean)
        {
          paramMessage = getAppInterface();
          if (paramMessage == null) {
            break;
          }
          if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
            this.jdField_d_of_type_JavaLangString = paramMessage.getCurrentAccountUin();
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, paramMessage, this);
          return false;
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow.bringToFront();
        }
        localWebViewFragment = getCurrentWebViewFragment();
      } while ((localWebViewFragment == null) || (localWebViewFragment.webView == null) || (!(paramMessage.obj instanceof String)));
      String str = (String)paramMessage.obj;
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("result", paramMessage.arg1);
        localWebViewFragment.webView.callJs(str + "(" + localJSONObject.toString() + ");");
        return false;
      }
      catch (Throwable paramMessage)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloStoreActivity", 2, "[save img] json null");
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramMessage = new StringBuilder().append("recv refresh apollo view msf, apolloView is null: ");
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController != null) {
        break label368;
      }
    }
    label368:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ApolloStoreActivity", 2, bool);
      if ((!ApolloEngine.a()) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController != null)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController = new ApolloViewController(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this);
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.a(this);
      return false;
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.jdField_a_of_type_Boolean = true;
    d();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloStoreActivity", 2, "onConfigurationChanged orientation:" + paramConfiguration.orientation);
    }
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onNotifyLongTouch(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloStoreActivity", 2, "onNotifyLongTouch:" + paramString);
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.i))) {
      b(0);
    }
  }
  
  public void onNotifyStatusChanged(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloStoreActivity", 2, new Object[] { "[onNotifyStatusChanged] status=", Integer.valueOf(paramInt), ", apolloId=", paramString });
    }
    if (7 == paramInt) {
      b(1);
    }
    for (;;)
    {
      return;
      WebViewFragment localWebViewFragment = getCurrentWebViewFragment();
      if ((localWebViewFragment != null) && (localWebViewFragment.webView != null))
      {
        if (!TextUtils.isEmpty(paramString)) {
          break label100;
        }
        localWebViewFragment.webView.callJs("window.apollo && window.apollo.controller && window.apollo.controller.hitAvatar && window.apollo.controller.hitAvatar();");
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ApolloStoreActivity", 2, "apollo.controller.hitAvatar()");
        return;
        label100:
        localWebViewFragment.webView.callJs(String.format("window.apollo && window.apollo.controller && window.apollo.controller.hitAvatar && window.apollo.controller.hitAvatar('%s');", new Object[] { paramString }));
      }
    }
  }
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloStoreActivity", 2, "Avatar view is Ready.");
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.jdField_d_of_type_Boolean))
    {
      this.jdField_d_of_type_Boolean = false;
      c();
    }
  }
  
  public boolean showPreview()
  {
    super.showPreview();
    super.setImmersiveStatus();
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.init();
      int j = super.getResources().getColor(2131167091);
      this.mSystemBarComp.setStatusColor(j);
      this.mSystemBarComp.setStatusBarColor(j);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloStoreActivity
 * JD-Core Version:    0.7.0.1
 */