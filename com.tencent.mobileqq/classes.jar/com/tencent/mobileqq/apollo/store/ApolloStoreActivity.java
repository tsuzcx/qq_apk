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
import com.tencent.mobileqq.apollo.listener.OnApolloViewListener;
import com.tencent.mobileqq.apollo.store.openbox.ApolloCardWindow;
import com.tencent.mobileqq.apollo.store.openbox.ApolloCardWindow.OnCloseCardWindowListener;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.web.api.impl.ApolloJsPluginImpl;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloTextureView;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.vip.manager.QZoneVipInfoManager;
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
  private int jdField_a_of_type_Int;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private ApolloViewController jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController;
  private ApolloCardWindow jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow;
  private String jdField_a_of_type_JavaLangString;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
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
      if ((AppInterface)super.getAppRuntime() == null)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(255, 1500L);
        return;
      }
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(255, 500L);
    }
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportStorePageLoadSuccess. url:");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
    QLog.d("[cmshow]ApolloStoreActivity_apollo_store_stability_", 2, ((StringBuilder)localObject).toString());
    localObject = ApolloStoreStabilityReportManager.a();
    if (((ApolloStoreStabilityReportManager)localObject).b(this.jdField_b_of_type_JavaLangString))
    {
      ((ApolloStoreStabilityReportManager)localObject).a(null, this.jdField_b_of_type_JavaLangString, 1001, paramInt);
      return;
    }
    QLog.d("[cmshow]ApolloStoreActivity_apollo_store_stability_", 2, "reportStorePageLoadTimeout. url is not in white list");
  }
  
  private void f()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportStorePageLoadTimeout. url:");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
    QLog.d("[cmshow]ApolloStoreActivity_apollo_store_stability_", 2, ((StringBuilder)localObject).toString());
    localObject = ApolloStoreStabilityReportManager.a();
    if (((ApolloStoreStabilityReportManager)localObject).b(this.jdField_b_of_type_JavaLangString))
    {
      ((ApolloStoreStabilityReportManager)localObject).a(null, this.jdField_b_of_type_JavaLangString, -1000, 0);
      return;
    }
    QLog.d("[cmshow]ApolloStoreActivity_apollo_store_stability_", 2, "reportStorePageLoadTimeout. url is not in white list");
  }
  
  public String a()
  {
    getAppRuntime().getCurrentAccountUin();
    ApolloViewController localApolloViewController = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController;
    if (localApolloViewController != null) {
      return localApolloViewController.a();
    }
    return "{\"result\":1,\"msg\":\"ApolloViewController not init\"}";
  }
  
  public String a(int paramInt, ApolloWebAvatarParam paramApolloWebAvatarParam)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initAvatar hasApolloView: ");
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController != null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject).append(bool);
    QLog.i("[cmshow]ApolloStoreActivity", 1, ((StringBuilder)localObject).toString());
    b("ipc_apollo_query_mine_redinfo");
    if (paramApolloWebAvatarParam == null)
    {
      QLog.e("[cmshow]ApolloStoreActivity", 1, "[initAvatar] no request params");
      return "{\"result\":1, \"msg\": \"缺少请求参数\" }";
    }
    this.i = paramApolloWebAvatarParam.apolloId;
    this.e = paramApolloWebAvatarParam.tab;
    this.g = paramApolloWebAvatarParam.uin;
    this.h = paramApolloWebAvatarParam.nickName;
    this.jdField_a_of_type_Int = paramApolloWebAvatarParam.roleId;
    this.jdField_a_of_type_ArrayOfInt = paramApolloWebAvatarParam.dressIds;
    localObject = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController;
    if (localObject != null) {
      return ((ApolloViewController)localObject).a(paramInt, false, paramApolloWebAvatarParam);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(258);
    return "{\"result\":0, \"msg\": \"\" }";
  }
  
  public String a(ApolloViewController.PlayActionData paramPlayActionData)
  {
    ApolloViewController localApolloViewController = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController;
    if (localApolloViewController != null) {
      return localApolloViewController.a(paramPlayActionData);
    }
    return ApolloViewController.a(HardCodeUtil.a(2131700738));
  }
  
  public String a(String paramString)
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (!TextUtils.isEmpty(paramString)))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow;
      if (localObject == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow = new ApolloCardWindow(this);
        localObject = new RelativeLayout.LayoutParams(-1, -1);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow, (ViewGroup.LayoutParams)localObject);
      }
      else
      {
        ((ApolloCardWindow)localObject).bringToFront();
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, paramString, "store", (AppInterface)getAppRuntime(), this);
      a(false);
      return "{\"result\":0,\"msg\":\"\"}";
    }
    return "{\"result\":1,\"msg\":\"uin是空\"}";
  }
  
  public String a(ArrayList<ApolloWebAvatarParam> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloStoreActivity", 2, new Object[] { "[updateAvatar] avatarParams=", paramArrayList });
    }
    ApolloViewController localApolloViewController = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController;
    if (localApolloViewController != null) {
      return localApolloViewController.a(paramArrayList);
    }
    return "{\"result\":1, \"msg\": \"终端发生错误\" }";
  }
  
  public String a(int[] paramArrayOfInt)
  {
    ApolloViewController localApolloViewController = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController;
    if (localApolloViewController != null) {
      return localApolloViewController.a(paramArrayOfInt);
    }
    return ApolloViewController.a("ApolloViewController not init!");
  }
  
  public void a()
  {
    WebViewFragment localWebViewFragment = getCurrentWebViewFragment();
    if ((localWebViewFragment != null) && (localWebViewFragment.getWebView() != null))
    {
      ApolloViewController localApolloViewController = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController;
      if ((localApolloViewController != null) && (localApolloViewController.a()))
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
    QZoneVipInfoManager.a(this, this.g, "lmx_actview");
  }
  
  public void a(int paramInt, int[] paramArrayOfInt)
  {
    ApolloViewController localApolloViewController = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController;
    if (localApolloViewController != null) {
      localApolloViewController.a(paramInt, paramArrayOfInt);
    }
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      paramActivity = this.f;
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController;
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
    this.jdField_b_of_type_Float = (FontSettingManager.getFontLevel() / 16.0F);
    if (this.jdField_b_of_type_Float != 0.0F) {
      this.jdField_a_of_type_Float = (DeviceInfoUtil.a() / this.jdField_b_of_type_Float);
    }
    if (this.jdField_a_of_type_Float == 0.0F) {
      this.jdField_a_of_type_Float = DeviceInfoUtil.a();
    }
  }
  
  public void a(RelativeLayout paramRelativeLayout)
  {
    if (paramRelativeLayout != null)
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        return;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController != null) {
          return;
        }
        if (ApolloEngine.isEngineReady())
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController = new ApolloViewController(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this);
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.a(this);
        }
        else
        {
          paramRelativeLayout = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
          if (paramRelativeLayout != null) {
            paramRelativeLayout.setHandler(ApolloStoreActivity.class, this.jdField_a_of_type_MqqOsMqqHandler);
          }
          ThreadManager.postImmediately(new ApolloStoreActivity.1(this), null, true);
        }
        d();
      }
    }
  }
  
  public void a(ApolloTextureView paramApolloTextureView)
  {
    paramApolloTextureView = this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow;
    if ((paramApolloTextureView != null) && (paramApolloTextureView.getVisibility() == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow.bringToFront();
    }
  }
  
  public void a(String paramString)
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
  
  public void a(String paramString, Bundle paramBundle)
  {
    Object localObject = getCurrentWebViewFragment();
    if (localObject != null)
    {
      if (((WebViewFragment)localObject).getWebView() == null) {
        return;
      }
      localObject = ((WebViewFragment)localObject).getWebView().getPluginEngine();
      if (localObject == null) {
        return;
      }
      localObject = (ApolloJsPluginImpl)((WebViewPluginEngine)localObject).a("apollo");
      if (localObject != null)
      {
        ((ApolloJsPluginImpl)localObject).mReqBundle.clear();
        if (paramBundle != null) {
          ((ApolloJsPluginImpl)localObject).mReqBundle = paramBundle;
        }
        ((ApolloJsPluginImpl)localObject).sendRemoteReq(DataFactory.a(paramString, "", ((ApolloJsPluginImpl)localObject).getRemoteKey(), ((ApolloJsPluginImpl)localObject).mReqBundle), false, true);
        if (QLog.isColorLevel())
        {
          paramBundle = new StringBuilder();
          paramBundle.append("[doIPCRequest], cmd");
          paramBundle.append(paramString);
          QLog.d("[cmshow]ApolloStoreActivity", 2, paramBundle.toString());
        }
      }
    }
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloStoreActivity", 2, "[destoryAvatar]");
    }
    ApolloViewController localApolloViewController = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController;
    if (localApolloViewController != null) {
      localApolloViewController.a(paramArrayList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ApolloViewController localApolloViewController = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController;
    if (localApolloViewController != null) {
      localApolloViewController.a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    ApolloViewController localApolloViewController = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController;
    if (localApolloViewController != null) {
      localApolloViewController.a(paramBoolean, paramFloat1, paramFloat2);
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
      QLog.e("[cmshow]ApolloStoreActivity", 1, paramString.getMessage());
    }
    return false;
  }
  
  public String b(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController;
    if (localObject == null) {
      return "";
    }
    localObject = ((ApolloViewController)localObject).a();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloStoreActivity", 2, "[saveImage] failed view null");
      }
      return "";
    }
    long l = System.currentTimeMillis();
    ThreadManager.executeOnSubThread(new ApolloStoreActivity.3(this, ((ApolloTextureView)localObject).getBitmap(), l, paramString));
    return "";
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[openAIActivity], from:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("[cmshow]ApolloStoreActivity", 2, ((StringBuilder)localObject).toString());
    if (!ApolloEngine.isEngineReady()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController == null) {
      return;
    }
    if (!"interactive".equals(this.e)) {
      return;
    }
    localObject = getAppRuntime().getCurrentAccountUin();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty(this.g))) {
      ((String)localObject).equals(this.g);
    }
    e();
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
        QLog.d("[cmshow]ApolloStoreActivity", 2, "send broadcast to finish jump activity");
      }
      Intent localIntent = new Intent();
      localIntent.setAction("BroadcastReceiverFinishActivity");
      sendBroadcast(localIntent);
    }
  }
  
  public void c(int paramInt)
  {
    Object localObject = getCurrentWebViewFragment();
    if ((localObject != null) && (((WebViewFragment)localObject).getSwiftTitleUI() != null) && (((WebViewFragment)localObject).getSwiftTitleUI().a != null))
    {
      localObject = ((WebViewFragment)localObject).getSwiftTitleUI().a;
      int j;
      if (paramInt > 0) {
        j = 0;
      } else {
        j = 4;
      }
      ((TextView)localObject).setVisibility(j);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setBackViewVisibility,visibility:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("[cmshow]ApolloStoreActivity", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void d(int paramInt)
  {
    ApolloViewController localApolloViewController = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController;
    if (localApolloViewController != null) {
      localApolloViewController.b(paramInt);
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
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController;
          if (localObject1 != null)
          {
            localObject1 = ((ApolloViewController)localObject1).a();
            if (localObject1 != null) {
              ((ApolloTextureView)localObject1).queueEvent(new ApolloStoreActivity.2(this, paramInt1, paramInt2, paramIntent));
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
      localObject1 = ApolloConstant.o;
    }
    localObject2 = new StringBuilder((String)localObject1);
    this.jdField_c_of_type_Boolean = super.getIntent().getBooleanExtra("extra_key_open_box", false);
    this.jdField_d_of_type_JavaLangString = super.getIntent().getStringExtra("extra_key_box_uin");
    this.jdField_c_of_type_JavaLangString = super.getIntent().getStringExtra("extra_key_box_from");
    this.f = super.getIntent().getStringExtra("extra_key_nickname");
    long l2 = DeviceInfoUtil.j();
    long l3 = DeviceInfoUtil.i();
    int j = (int)(ImmersiveUtils.getStatusBarHeight(this) / this.jdField_a_of_type_Float);
    if (((String)localObject1).indexOf("?") == -1) {
      ((StringBuilder)localObject2).append("?");
    } else {
      ((StringBuilder)localObject2).append("&");
    }
    ((StringBuilder)localObject2).append("screenWidth=");
    ((StringBuilder)localObject2).append((int)((float)l3 / this.jdField_a_of_type_Float));
    ((StringBuilder)localObject2).append("&screenHeight=");
    ((StringBuilder)localObject2).append((int)((float)l2 / this.jdField_a_of_type_Float));
    ((StringBuilder)localObject2).append("&statusBarHeight=");
    ((StringBuilder)localObject2).append(j);
    ((StringBuilder)localObject2).append("&screenDensity=");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_Float);
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
    if (this.jdField_c_of_type_Boolean)
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
    this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
    getIntent().putExtra("url", this.jdField_a_of_type_JavaLangString);
    this.mFragmentClass = ApolloStoreActivity.ApolloWebViewFragment.class;
    super.doOnCreate(paramBundle);
    ApolloCardWindow.b();
    if (!((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).doBindService(super.getApplicationContext());
    }
    this.jdField_b_of_type_Boolean = true;
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
    localObject = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController;
    if (localObject != null) {
      ((ApolloViewController)localObject).d();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow;
    if (localObject != null) {
      ((ApolloCardWindow)localObject).a(true);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    localObject = (AppInterface)getAppRuntime();
    if (localObject != null) {
      ((AppInterface)localObject).removeHandler(ApolloStoreActivity.class);
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
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
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      if (TextUtils.isEmpty(ApolloConstant.z)) {
        localObject2 = ApolloConstant.o;
      } else {
        localObject2 = ApolloConstant.z;
      }
    }
    int j = (int)(ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication()) / this.jdField_a_of_type_Float);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append("&screenWidth=");
    ((StringBuilder)localObject1).append((int)((float)l2 / this.jdField_a_of_type_Float));
    ((StringBuilder)localObject1).append("&screenHeight=");
    ((StringBuilder)localObject1).append((int)((float)l1 / this.jdField_a_of_type_Float));
    ((StringBuilder)localObject1).append("&statusBarHeight=");
    ((StringBuilder)localObject1).append(j);
    ((StringBuilder)localObject1).append("&screenDensity=");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_Float);
    this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject1).toString();
    if (!TextUtils.isEmpty(str)) {
      if (str.startsWith("&"))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject1).append(str);
        this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject1).append("&");
        ((StringBuilder)localObject1).append(str);
        this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject1).toString();
      }
    }
    if (!this.jdField_a_of_type_JavaLangString.contains("tab"))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("&tab=mall");
      this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject1).toString();
    }
    if (this.jdField_a_of_type_JavaLangString.indexOf("&_wv") < 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("&_wv=");
      ((StringBuilder)localObject1).append(16777223L);
      this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject1).toString();
    }
    if (this.jdField_a_of_type_JavaLangString.indexOf("&_wwv") < 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append("&_wwv=");
      ((StringBuilder)localObject1).append(520L);
      this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject1).toString();
    }
    paramIntent.putExtra("url", this.jdField_a_of_type_JavaLangString);
    super.doOnNewIntent(paramIntent);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int j = paramMessage.what;
    JSONObject localJSONObject;
    if (j != 255)
    {
      if (j != 256)
      {
        if (j != 258) {
          return false;
        }
        if (QLog.isColorLevel())
        {
          paramMessage = new StringBuilder();
          paramMessage.append("recv refresh apollo view msf, apolloView is null: ");
          boolean bool;
          if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController == null) {
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
        paramMessage = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
        if ((paramMessage == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController != null)) {
          break label393;
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController = new ApolloViewController(paramMessage, this);
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.a(this);
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
    paramMessage = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (paramMessage == null) {
      return false;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow;
    if (localObject1 == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow = new ApolloCardWindow(paramMessage.getContext());
      paramMessage = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow, paramMessage);
    }
    else
    {
      ((ApolloCardWindow)localObject1).bringToFront();
    }
    if (this.jdField_c_of_type_Boolean)
    {
      paramMessage = (AppInterface)getAppRuntime();
      if (paramMessage != null)
      {
        if (TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
          this.jdField_d_of_type_JavaLangString = paramMessage.getCurrentAccountUin();
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_d_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, paramMessage, this);
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
    this.jdField_a_of_type_Boolean = true;
    d();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onConfigurationChanged orientation:");
    localStringBuilder.append(paramConfiguration.orientation);
    QLog.d("[cmshow]ApolloStoreActivity", 2, localStringBuilder.toString());
  }
  
  public void onNotifyLongTouch(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNotifyLongTouch:");
    localStringBuilder.append(paramString);
    QLog.d("[cmshow]ApolloStoreActivity", 2, localStringBuilder.toString());
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.i))) {
      b(0);
    }
  }
  
  public void onNotifyStatusChanged(int paramInt, String paramString)
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
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    QLog.d("[cmshow]ApolloStoreActivity", 2, "Avatar view is Ready.");
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
      int j = super.getResources().getColor(2131167114);
      this.mSystemBarComp.setStatusColor(j);
      this.mSystemBarComp.setStatusBarColor(j);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloStoreActivity
 * JD-Core Version:    0.7.0.1
 */