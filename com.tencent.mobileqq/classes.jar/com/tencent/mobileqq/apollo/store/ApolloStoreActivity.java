package com.tencent.mobileqq.apollo.store;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.ApolloRenderDriver;
import com.tencent.mobileqq.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.OnApolloViewListener;
import com.tencent.mobileqq.apollo.ai.ApolloAIActivity;
import com.tencent.mobileqq.apollo.store.openbox.ApolloCardWindow;
import com.tencent.mobileqq.apollo.store.openbox.ApolloCardWindow.OnCloseCardWindowListener;
import com.tencent.mobileqq.apollo.store.webview.ApolloUrlInterceptor;
import com.tencent.mobileqq.apollo.store.webview.ApolloWebStatistics;
import com.tencent.mobileqq.apollo.task.ApolloActionHelper;
import com.tencent.mobileqq.apollo.task.ApolloActionManager;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import ytw;
import ytx;
import yty;
import ytz;
import yua;

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
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private String jdField_a_of_type_JavaLangString;
  public MqqHandler a;
  private boolean jdField_a_of_type_Boolean;
  int[] jdField_a_of_type_ArrayOfInt;
  private float jdField_b_of_type_Float = 1.0F;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private int jdField_f_of_type_Int;
  private String jdField_f_of_type_JavaLangString;
  private int jdField_g_of_type_Int;
  private String jdField_g_of_type_JavaLangString;
  private int jdField_h_of_type_Int;
  private String jdField_h_of_type_JavaLangString;
  private int jdField_i_of_type_Int;
  private String jdField_i_of_type_JavaLangString;
  private int jdField_j_of_type_Int;
  private String jdField_j_of_type_JavaLangString;
  private int k;
  
  public ApolloStoreActivity()
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper(), this);
  }
  
  private void c()
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
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, 230, "温馨提示", "使用特定角色就能体验厘米秀AI功能，快去商城换角色", "取消", "去商城", new ytx(this), new yty(this));
    }
    VipUtils.a(null, "cmshow", "Apollo", "AI_alert", 0, 0, new String[0]);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
  }
  
  private void f(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.a();
    if (localObject != null)
    {
      ((ApolloTextureView)localObject).getRenderImpl().a(1, this.jdField_h_of_type_JavaLangString, "Bubble");
      ((ApolloTextureView)localObject).getRenderImpl().a(0L);
    }
    localObject = new Intent(this, ApolloGuestsStateActivity.class);
    ((Intent)localObject).putExtra("extra_guest_uin", this.jdField_f_of_type_JavaLangString);
    ((Intent)localObject).putExtra("extra_guest_nick", this.jdField_g_of_type_JavaLangString);
    ((Intent)localObject).putExtra("extra_guest_status_ai", paramInt);
    ((Intent)localObject).putExtra("extra_guest_from", 4);
    super.startActivityForResult((Intent)localObject, 2);
  }
  
  private void g(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloStoreActivity", 2, "[openAIActivity], from:" + paramInt + ",mAIWhiteSwitch:" + this.jdField_f_of_type_Int + ",mAIFuncSwitch:" + this.jdField_e_of_type_Int);
    }
    if (!ApolloEngine.a()) {}
    label61:
    do
    {
      do
      {
        do
        {
          break label61;
          do
          {
            return;
          } while ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController == null) || (!"interactive".equals(this.jdField_d_of_type_JavaLangString)) || (this.jdField_f_of_type_Int != 1) || (this.jdField_e_of_type_Int != 1));
          localObject = getCurrentAccountUin();
        } while ((TextUtils.isEmpty((CharSequence)localObject)) || (TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString)));
        if (!((String)localObject).equals(this.jdField_f_of_type_JavaLangString))
        {
          QQToast.a(this, "暂时不支持和好友形象聊天", 0).a();
          return;
        }
        localObject = b();
      } while ((localObject == null) || (((WebViewFragment)localObject).jdField_a_of_type_ComTencentBizUiTouchWebView == null));
      localObject = ((WebViewFragment)localObject).jdField_a_of_type_ComTencentBizUiTouchWebView.a();
    } while (localObject == null);
    Object localObject = (ApolloJsPlugin)((WebViewPluginEngine)localObject).a("apollo");
    if (localObject != null) {
      if (!((ApolloJsPlugin)localObject).mIsAIRole) {
        break label211;
      }
    }
    label211:
    for (int m = 1;; m = 0)
    {
      this.jdField_j_of_type_Int = m;
      if (this.jdField_j_of_type_Int != 0) {
        break;
      }
      e();
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.a();
    if (localObject != null)
    {
      ((ApolloTextureView)localObject).getWorker().a();
      ((ApolloTextureView)localObject).getRenderImpl().a(1, this.jdField_h_of_type_JavaLangString, "Bubble");
      ((ApolloTextureView)localObject).getRenderImpl().a(500L);
      Intent localIntent = new Intent(this, ApolloAIActivity.class);
      localIntent.putExtra("extra_key_apollo_view_left", 0);
      localIntent.putExtra("extra_key_apollo_view_top", 0);
      localIntent.putExtra("extra_key_apollo_scale", this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.a());
      localIntent.putExtra("extra_key_apollo_view_width", ((ApolloTextureView)localObject).getWidth());
      localIntent.putExtra("extra_key_apollo_view_height", ((ApolloTextureView)localObject).getHeight());
      localIntent.putExtra("extra_key_apollo_position_x", this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.a());
      localIntent.putExtra("extra_key_apollo_position_y", this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.b());
      localIntent.putExtra("extra_key_apollo_roleid", this.jdField_a_of_type_Int);
      localIntent.putExtra("extra_key_apollo_dressids", this.jdField_a_of_type_ArrayOfInt);
      localIntent.putExtra("extra_key_apollo_aipush", this.jdField_j_of_type_JavaLangString);
      super.startActivity(localIntent);
      super.overridePendingTransition(2131034165, 2131034167);
    }
    if (TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString)) {}
    for (localObject = "0";; localObject = "1")
    {
      VipUtils.a(null, "cmshow", "Apollo", "enter_AI", paramInt, 0, new String[] { localObject, String.valueOf(this.jdField_g_of_type_Int) });
      this.jdField_j_of_type_JavaLangString = "";
      return;
    }
  }
  
  public ApolloWebStatistics a(boolean paramBoolean)
  {
    Object localObject = b();
    if ((localObject != null) && (((WebViewFragment)localObject).jdField_a_of_type_ComTencentBizUiTouchWebView != null))
    {
      localObject = ((WebViewFragment)localObject).jdField_a_of_type_ComTencentBizUiTouchWebView.a();
      if (localObject != null)
      {
        localObject = ((WebViewPluginEngine)localObject).a("apollo");
        if ((localObject != null) && ((localObject instanceof ApolloJsPlugin)))
        {
          localObject = ((ApolloJsPlugin)localObject).getIntercepter();
          if (localObject != null) {
            if (paramBoolean)
            {
              if (((ApolloUrlInterceptor)localObject).a()) {
                return ((ApolloUrlInterceptor)localObject).a();
              }
            }
            else {
              return ((ApolloUrlInterceptor)localObject).a();
            }
          }
        }
      }
    }
    return null;
  }
  
  public String a()
  {
    int m = 8;
    Object localObject = getCurrentAccountUin();
    ApolloTextureView localApolloTextureView;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController != null)
    {
      localApolloTextureView = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.a();
      if ((localApolloTextureView != null) && ("interactive".equals(this.jdField_d_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) && (!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(this.jdField_f_of_type_JavaLangString)))
      {
        localObject = new ApolloActionData();
        ((ApolloActionData)localObject).actionId = this.jdField_h_of_type_Int;
        if (ApolloUtil.a(ApolloUtil.a((ApolloActionData)localObject, 8))) {
          break label180;
        }
        ((ApolloActionData)localObject).actionId = 5;
      }
    }
    for (;;)
    {
      String[] arrayOfString = ApolloActionHelper.a(m, ((ApolloActionData)localObject).actionId, this.jdField_a_of_type_Int, true);
      localApolloTextureView.getRenderImpl().a(1, this.jdField_h_of_type_JavaLangString, ((ApolloActionData)localObject).actionId, 0, arrayOfString[0], arrayOfString[1]);
      this.jdField_i_of_type_JavaLangString = "";
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.e = false;
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.c = 5;
      return "{\"result\":0, \"msg\": \"\" }";
      return this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.a();
      return "{\"result\":1,\"msg\":\"ApolloViewController not init\"}";
      label180:
      m = 9;
    }
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
    this.jdField_h_of_type_JavaLangString = paramApolloWebAvatarParam.apolloId;
    this.jdField_d_of_type_JavaLangString = paramApolloWebAvatarParam.tab;
    this.jdField_f_of_type_JavaLangString = paramApolloWebAvatarParam.uin;
    this.jdField_g_of_type_JavaLangString = paramApolloWebAvatarParam.nickName;
    this.jdField_a_of_type_Int = paramApolloWebAvatarParam.roleId;
    this.jdField_a_of_type_ArrayOfInt = paramApolloWebAvatarParam.dressIds;
    if ((1 == this.jdField_g_of_type_Int) && (1 == this.jdField_e_of_type_Int) && (1 == this.jdField_g_of_type_Int) && ("interactive".equals(this.jdField_d_of_type_JavaLangString)) && (!this.jdField_d_of_type_Boolean))
    {
      this.jdField_d_of_type_Boolean = true;
      VasExtensionHandler.a(this, super.getAppInterface(), "android.store", 1, "enter_index", null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController != null) {
      return this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.a(paramInt, false, paramApolloWebAvatarParam);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(357);
    return "{\"result\":0, \"msg\": \"\" }";
  }
  
  public String a(ApolloViewController.PlayActionData paramPlayActionData)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController != null) {
      return this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.a(paramPlayActionData);
    }
    return ApolloViewController.a("资源不完整");
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
  
  public String a(ArrayList paramArrayList)
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
    WebViewFragment localWebViewFragment = b();
    if ((localWebViewFragment != null) && (localWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.a()))
    {
      localWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView.c("window.onReturn &&　window.onReturn()");
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
    WebViewFragment localWebViewFragment = b();
    if ((localWebViewFragment != null) && (localWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView != null)) {
      localWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView.c("window.openVipFromAction && window.openVipFromAction(" + paramInt + ")");
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, int paramInt4, int paramInt5)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloStoreActivity", 2, "[setAIData], aiSwitch:" + paramInt3 + ",content:" + paramString2 + ",id:" + paramInt4 + ",type:" + paramInt5 + ",pushData:" + paramString1 + ",funcS:" + paramInt1 + ",whiteS:" + paramInt2);
    }
    this.jdField_e_of_type_Int = paramInt1;
    this.jdField_f_of_type_Int = paramInt2;
    this.jdField_g_of_type_Int = paramInt3;
    if ((1 == this.jdField_g_of_type_Int) && (1 == this.jdField_e_of_type_Int) && (1 == this.jdField_g_of_type_Int))
    {
      this.jdField_j_of_type_JavaLangString = paramString1;
      this.jdField_h_of_type_Int = paramInt4;
      this.jdField_i_of_type_JavaLangString = paramString2;
      this.jdField_i_of_type_Int = paramInt5;
    }
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
      paramActivity = this.jdField_e_of_type_JavaLangString;
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
      this.jdField_b_of_type_Float = (FontSettingManager.a() / 16.0F);
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
      c();
      return;
      label65:
      paramRelativeLayout = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
      if (paramRelativeLayout != null) {
        paramRelativeLayout.setHandler(ApolloStoreActivity.class, this.jdField_a_of_type_MqqOsMqqHandler);
      }
      ThreadManager.postImmediately(new ytw(this), null, true);
    }
  }
  
  public void a(ApolloTextureView paramApolloTextureView)
  {
    AppInterface localAppInterface = super.getAppInterface();
    SharedPreferences localSharedPreferences;
    int m;
    if (("interactive".equals(this.jdField_d_of_type_JavaLangString)) && (paramApolloTextureView != null) && (this.jdField_f_of_type_Int == 1) && (this.jdField_e_of_type_Int == 1) && (this.jdField_f_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString.equals(localAppInterface.getCurrentAccountUin())))
    {
      localSharedPreferences = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
      if ((TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) || (this.jdField_g_of_type_Int != 1)) {
        break label265;
      }
      m = 4;
      if (this.jdField_i_of_type_Int != 0) {
        break label252;
      }
      m = 4;
      ApolloActionManager.a().a.set(m);
      paramApolloTextureView.getRenderImpl().b(m, this.jdField_h_of_type_JavaLangString, 1, this.jdField_a_of_type_Int, this.jdField_i_of_type_JavaLangString, null);
      b("ipc_apollo_clear_ai_push");
      VipUtils.a(null, "cmshow", "Apollo", "show_pro_index", 0, 0, new String[] { String.valueOf(this.jdField_h_of_type_Int) });
      VasExtensionHandler.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), localAppInterface, "android.store", 1, "read_proactive", null);
      localSharedPreferences.edit().putBoolean("apollo_ai_guide_show" + localAppInterface.getCurrentAccountUin(), true).commit();
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow.getVisibility() == 0)) {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow.bringToFront();
      }
      return;
      label252:
      if (this.jdField_i_of_type_Int != 1) {
        break;
      }
      m = 5;
      break;
      label265:
      if (!localSharedPreferences.getBoolean("apollo_ai_guide_show" + localAppInterface.getCurrentAccountUin(), false))
      {
        this.jdField_h_of_type_Int = 116;
        this.jdField_i_of_type_JavaLangString = "我已经获得生命，可以和你自由对话。长按我马上开启~";
        ApolloActionManager.a().a.set(4);
        paramApolloTextureView.getRenderImpl().b(4, this.jdField_h_of_type_JavaLangString, 1, this.jdField_a_of_type_Int, this.jdField_i_of_type_JavaLangString, null);
        localSharedPreferences.edit().putBoolean("apollo_ai_guide_show" + localAppInterface.getCurrentAccountUin(), true).commit();
      }
    }
  }
  
  public void a(String paramString)
  {
    WebViewFragment localWebViewFragment = b();
    if ((localWebViewFragment == null) || (localWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      paramString = "window && window.apollo && window.apollo.controller && window.apollo.controller.closeBox && window.apollo.controller.closeBox('" + paramString + "')";
      localWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView.c(paramString);
    } while (!QLog.isColorLevel());
    QLog.d("ApolloStoreActivity", 2, "onCardWindowClose,callBackStr:" + paramString);
  }
  
  public void a(ArrayList paramArrayList)
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
    ThreadManager.executeOnSubThread(new yua(this, localApolloTextureView.getBitmap(), l, paramString));
    return "";
  }
  
  public void b() {}
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.a(paramInt);
    }
  }
  
  public void b(String paramString)
  {
    Object localObject = b();
    if ((localObject == null) || (((WebViewFragment)localObject).jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {}
    do
    {
      do
      {
        do
        {
          return;
          localObject = ((WebViewFragment)localObject).jdField_a_of_type_ComTencentBizUiTouchWebView.a();
        } while (localObject == null);
        localObject = (ApolloJsPlugin)((WebViewPluginEngine)localObject).a("apollo");
      } while (localObject == null);
      ((ApolloJsPlugin)localObject).mReqBundle.clear();
      ((ApolloJsPlugin)localObject).sendRemoteReq(DataFactory.a(paramString, "", ((ApolloJsPlugin)localObject).getRemoteKey(), ((ApolloJsPlugin)localObject).mReqBundle), false, true);
    } while (!QLog.isColorLevel());
    QLog.d("ApolloStoreActivity", 2, "[doIPCRequest], cmd" + paramString);
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloStoreActivity", 2, "[openAIActivity], from:" + paramInt + ",mAIWhiteSwitch:" + this.jdField_f_of_type_Int + ",mAIFuncSwitch:" + this.jdField_e_of_type_Int);
    }
    if (!ApolloEngine.a()) {}
    while ((this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController == null) || (!"interactive".equals(this.jdField_d_of_type_JavaLangString))) {
      return;
    }
    int n = 0;
    int m = n;
    if (this.jdField_f_of_type_Int == 1)
    {
      if (this.jdField_e_of_type_Int == 1) {
        break label109;
      }
      m = n;
    }
    for (;;)
    {
      f(m);
      return;
      label109:
      String str = getCurrentAccountUin();
      m = n;
      if (!TextUtils.isEmpty(str))
      {
        m = n;
        if (!TextUtils.isEmpty(this.jdField_f_of_type_JavaLangString))
        {
          m = n;
          if (str.equals(this.jdField_f_of_type_JavaLangString))
          {
            this.k = paramInt;
            m = 1;
          }
        }
      }
    }
  }
  
  public void d(int paramInt)
  {
    Object localObject = b();
    if ((localObject != null) && (((WebViewFragment)localObject).jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI != null) && (((WebViewFragment)localObject).jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a != null))
    {
      localObject = ((WebViewFragment)localObject).jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a;
      if (paramInt <= 0) {
        break label78;
      }
    }
    label78:
    for (int m = 0;; m = 4)
    {
      ((TextView)localObject).setVisibility(m);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloStoreActivity", 2, "setBackViewVisibility,visibility:" + paramInt);
      }
      return;
    }
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
        localObject2 = b();
        if ((localObject2 == null) || (((WebViewFragment)localObject2).jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {
          break;
        }
        if (paramInt2 != -1) {
          break label231;
        }
        ((WebViewFragment)localObject2).jdField_a_of_type_ComTencentBizUiTouchWebView.c("window.apollo && window.apollo.controller && window.apollo.controller.closeEditor && window.apollo.controller.closeEditor(1,'" + ApolloUtil.b((String)localObject1) + "')");
        break;
        localObject1 = localObject2;
        if (((String)localObject2).length() > 12) {
          localObject1 = ((String)localObject2).substring(0, 12);
        }
      }
      label231:
      ((WebViewFragment)localObject2).jdField_a_of_type_ComTencentBizUiTouchWebView.c("window.apollo && window.apollo.controller && window.apollo.controller.closeEditor && window.apollo.controller.closeEditor(0,'" + ApolloUtil.b((String)localObject1) + "')");
      continue;
      if (paramInt2 == -1)
      {
        VipUtils.a(null, "cmshow", "Apollo", "QzoneSuccess", 0, 0, new String[0]);
        continue;
        if (paramInt2 == 2)
        {
          g(this.k);
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController != null)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.a();
            if (localObject1 != null) {
              ((ApolloTextureView)localObject1).queueEvent(new ytz(this, paramInt1, paramInt2, paramIntent));
            }
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
      localObject1 = ApolloConstant.M;
    }
    localObject2 = new StringBuilder((String)localObject1);
    String str1 = super.getIntent().getStringExtra("extra_key_url_append");
    this.jdField_c_of_type_Boolean = super.getIntent().getBooleanExtra("extra_key_open_box", false);
    this.jdField_c_of_type_JavaLangString = super.getIntent().getStringExtra("extra_key_box_uin");
    this.jdField_b_of_type_JavaLangString = super.getIntent().getStringExtra("extra_key_box_from");
    this.jdField_e_of_type_JavaLangString = super.getIntent().getStringExtra("extra_key_nickname");
    String str2 = super.getIntent().getStringExtra("extra_key_adtag");
    long l2 = DeviceInfoUtil.k();
    long l3 = DeviceInfoUtil.j();
    int m = (int)(ImmersiveUtils.a(BaseApplicationImpl.getApplication()) / this.jdField_a_of_type_Float);
    if (((String)localObject1).indexOf("?") == -1)
    {
      ((StringBuilder)localObject2).append("?screenWidth=").append((int)((float)l3 / this.jdField_a_of_type_Float)).append("&screenHeight=").append((int)((float)l2 / this.jdField_a_of_type_Float)).append("&statusBarHeight=").append(m).append("&screenDensity=").append(this.jdField_a_of_type_Float);
      if (!TextUtils.isEmpty(str1))
      {
        if (!str1.startsWith("&")) {
          break label551;
        }
        ((StringBuilder)localObject2).append(str1);
      }
      label273:
      if (!TextUtils.isEmpty(str2)) {
        ((StringBuilder)localObject2).append("&adtag=").append(str2);
      }
      if (!this.jdField_c_of_type_Boolean) {
        break label568;
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
        ((StringBuilder)localObject2).append("&_wwv=").append(512L);
      }
      ((StringBuilder)localObject2).append("&webviewOpenType=1");
      this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
      getIntent().putExtra("url", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_JavaLangClass = ApolloStoreActivity.ApolloWebViewFragment.class;
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
      ((StringBuilder)localObject2).append("&screenWidth=").append((int)((float)l3 / this.jdField_a_of_type_Float)).append("&screenHeight=").append((int)((float)l2 / this.jdField_a_of_type_Float)).append("&statusBarHeight=").append(m).append("&screenDensity=").append(this.jdField_a_of_type_Float);
      break;
      label551:
      ((StringBuilder)localObject2).append("&").append(str1);
      break label273;
      label568:
      ((StringBuilder)localObject2).append("&openCapsule=0");
      ((StringBuilder)localObject2).append("&openBox=false");
    }
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow.a(true);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    AppInterface localAppInterface = getAppInterface();
    if (localAppInterface != null) {
      localAppInterface.removeHandler(ApolloStoreActivity.class);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    long l1 = DeviceInfoUtil.k();
    long l2 = DeviceInfoUtil.j();
    Object localObject2 = paramIntent.getStringExtra("url");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = super.getIntent().getStringExtra("url");
    }
    String str = paramIntent.getStringExtra("extra_key_url_append");
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (TextUtils.isEmpty(ApolloConstant.X)) {
        localObject2 = ApolloConstant.M;
      }
    }
    else
    {
      int m = (int)(ImmersiveUtils.a(BaseApplicationImpl.getApplication()) / this.jdField_a_of_type_Float);
      this.jdField_a_of_type_JavaLangString = ((String)localObject2 + "&screenWidth=" + (int)((float)l2 / this.jdField_a_of_type_Float) + "&screenHeight=" + (int)((float)l1 / this.jdField_a_of_type_Float) + "&statusBarHeight=" + m + "&screenDensity=" + this.jdField_a_of_type_Float);
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
        this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "&_wwv=" + 512L);
      }
      paramIntent.putExtra("url", this.jdField_a_of_type_JavaLangString);
      super.doOnNewIntent(paramIntent);
      return;
      localObject2 = ApolloConstant.X;
      break;
    }
  }
  
  public void e(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloViewController.b(paramInt);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
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
          if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
            this.jdField_c_of_type_JavaLangString = paramMessage.getCurrentAccountUin();
          }
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramMessage, this);
          return false;
          this.jdField_a_of_type_ComTencentMobileqqApolloStoreOpenboxApolloCardWindow.bringToFront();
        }
        localWebViewFragment = b();
      } while ((localWebViewFragment == null) || (localWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView == null) || (!(paramMessage.obj instanceof String)));
      String str = (String)paramMessage.obj;
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("result", paramMessage.arg1);
        localWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView.c(str + "(" + localJSONObject.toString() + ");");
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
        break label372;
      }
    }
    label372:
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
    c();
  }
  
  public void onNotifyLongTouch(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloAIActivity", 2, "onNotifyLongTouch:" + paramString);
    }
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.jdField_h_of_type_JavaLangString))) {
      c(0);
    }
  }
  
  public void onNotifyStatusChanged(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloStoreActivity", 2, new Object[] { "[onNotifyStatusChanged] status=", Integer.valueOf(paramInt), ", apolloId=", paramString });
    }
    if (7 == paramInt) {
      c(1);
    }
    for (;;)
    {
      return;
      WebViewFragment localWebViewFragment = b();
      if ((localWebViewFragment != null) && (localWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView != null))
      {
        if (!TextUtils.isEmpty(paramString)) {
          break label100;
        }
        localWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView.c("window.apollo && window.apollo.controller && window.apollo.controller.hitAvatar && window.apollo.controller.hitAvatar();");
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ApolloStoreActivity", 2, "apollo.controller.hitAvatar()");
        return;
        label100:
        localWebViewFragment.jdField_a_of_type_ComTencentBizUiTouchWebView.c(String.format("window.apollo && window.apollo.controller && window.apollo.controller.hitAvatar && window.apollo.controller.hitAvatar('%s');", new Object[] { paramString }));
      }
    }
  }
  
  public void onSurfaceReady(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloStoreActivity", 2, "Avatar view is Ready.");
    }
  }
  
  public boolean showPreview()
  {
    super.showPreview();
    super.setImmersiveStatus();
    if (this.mSystemBarComp != null)
    {
      this.mSystemBarComp.init();
      int m = super.getResources().getColor(2131494254);
      this.mSystemBarComp.setStatusColor(m);
      this.mSystemBarComp.setStatusBarColor(m);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloStoreActivity
 * JD-Core Version:    0.7.0.1
 */