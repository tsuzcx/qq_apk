package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.utils.IPUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.GatewayVerifyFailedFragment;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.loginregister.EquipLockProxy;
import com.tencent.mobileqq.loginregister.LoginStaticField;
import com.tencent.mobileqq.loginregister.LoginUtils;
import com.tencent.mobileqq.logintempapi.ILoginApi;
import com.tencent.mobileqq.loginwelcome.GateWayVerifyManager;
import com.tencent.mobileqq.loginwelcome.GatewayUtil;
import com.tencent.mobileqq.loginwelcome.IGatewayEntrance;
import com.tencent.mobileqq.loginwelcome.MultiGatewayCallback;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.GatewayLoadingDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import tencent.im.login.GatewayVerify.ReqBody;
import tencent.im.login.GatewayVerify.ReqBodySelfPhone;
import tencent.im.login.GatewayVerify.ReqBodySelfPhoneGetUrlV4;
import tencent.im.login.GatewayVerify.RspBody;
import tencent.im.login.GatewayVerify.RspBodySelfPhone;
import tencent.im.login.GatewayVerify.RspBodySelfPhoneGetUrlV4;
import tencent.im.login.GatewayVerify.SelfPhoneUrl;

public class NewAuthDevUgFragment
  extends QPublicBaseFragment
  implements View.OnClickListener, IGatewayEntrance
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private EquipLockProxy jdField_a_of_type_ComTencentMobileqqLoginregisterEquipLockProxy;
  private ILoginApi jdField_a_of_type_ComTencentMobileqqLogintempapiILoginApi;
  private GateWayVerifyManager jdField_a_of_type_ComTencentMobileqqLoginwelcomeGateWayVerifyManager;
  private GatewayLoadingDrawable jdField_a_of_type_ComTencentMobileqqWidgetGatewayLoadingDrawable;
  private String jdField_a_of_type_JavaLangString;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private VerifyDevLockManager.VerifyDevLockObserver jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver;
  private DevlockInfo jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private VerifyDevLockManager.VerifyDevLockObserver jdField_b_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver = new NewAuthDevUgFragment.1(this);
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString;
  private TextView e;
  private TextView f;
  
  private void a(Object paramObject)
  {
    if (paramObject == null)
    {
      QLog.e("NewAuthDevUgFragment", 1, "data is null");
      c();
    }
    for (;;)
    {
      return;
      try
      {
        paramObject = (byte[])paramObject;
        localObject = new GatewayVerify.RspBody();
        ((GatewayVerify.RspBody)localObject).mergeFrom(paramObject);
        this.jdField_d_of_type_JavaLangString = ((GatewayVerify.RspBody)localObject).msg_rsp_self_phone.msg_rsp_get_url_v4.str_msg_id.get();
        QLog.d("NewAuthDevUgFragment", 1, new Object[] { "msgid: ", this.jdField_d_of_type_JavaLangString });
        localObject = ((GatewayVerify.RspBody)localObject).msg_rsp_self_phone.msg_rsp_get_url_v4.rpt_self_phone_url.get();
        if (localObject == null)
        {
          QLog.d("NewAuthDevUgFragment", 1, "getGatewayToken, selfPhoneUrls is null");
          a("V_GET_GATEWAY_URL_ERROR", -1, "selfPhoneUrls is null");
          c();
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        QLog.e("NewAuthDevUgFragment", 1, new Object[] { "getGatewayToken, GatewayVerify.RspBody mergeFrom error : ", paramObject.getMessage() });
        a("V_GET_GATEWAY_URL_ERROR", -1, paramObject.getMessage());
        c();
        GatewayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime, 3, this.jdField_a_of_type_JavaLangString);
        return;
      }
      int i = ((List)localObject).size();
      if (i == 0)
      {
        QLog.d("NewAuthDevUgFragment", 1, "getGatewayToken, selfPhoneUrls is empty");
        a("V_GET_GATEWAY_URL_ERROR", -1, "selfPhoneUrls is empty");
        c();
        return;
      }
      paramObject = new MultiGatewayCallback(getActivity(), this.jdField_d_of_type_JavaLangString, i, this);
      Object localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        GatewayVerify.SelfPhoneUrl localSelfPhoneUrl = (GatewayVerify.SelfPhoneUrl)((Iterator)localObject).next();
        if (localSelfPhoneUrl == null)
        {
          a("V_GET_GATEWAY_URL_ERROR", -1, "url bean is null");
          c();
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeGateWayVerifyManager.a(localSelfPhoneUrl, paramObject);
      }
    }
  }
  
  private void a(String paramString)
  {
    this.e.setText(getString(2131698693, new Object[] { paramString }));
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    String str = this.jdField_a_of_type_MqqAppAppRuntime.getAccount();
    HashMap localHashMap = new HashMap();
    localHashMap.put("K_RESULT_TYPE", paramString1);
    localHashMap.put("K_RET", String.valueOf(paramInt));
    localHashMap.put("K_UIN", str);
    localHashMap.put("K_RESULT_MSG", paramString2);
    if ("V_RET_SUCCESS".equals(paramString1)) {
      localHashMap.put("K_REDIRECT_TIME", String.valueOf(this.jdField_b_of_type_Int));
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, "TGatewayVerifyResult", "V_RET_SUCCESS".equals(paramString1), 0L, 0L, localHashMap, "");
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = true;
    int i = 3;
    if ((TextUtils.isEmpty(paramString1)) || (paramString1.length() < 3)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (TextUtils.isEmpty(paramString2));
      if (!"86".equals(paramString2)) {
        break;
      }
      bool1 = bool2;
    } while (paramString1.length() == 11);
    if (("852".equals(paramString2)) || ("853".equals(paramString2)))
    {
      i = 6;
      if (paramString1.length() < i) {
        break label113;
      }
    }
    label113:
    for (boolean bool1 = true;; bool1 = false)
    {
      return bool1;
      if (!"886".equals(paramString2)) {
        break;
      }
      i = 9;
      break;
    }
  }
  
  private void c()
  {
    Intent localIntent = new Intent();
    if ("com.tencent.mobileqq:openSdk".equals(this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getQQProcessName())) {}
    for (String str = "/base/login/authDevVerifyCodeOpenSdk";; str = "/base/login/authDevVerifyCode")
    {
      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
      {
        localIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
        localIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
        localIntent.putExtra("mobile_type", 0);
      }
      localIntent.putExtra("from_login", this.jdField_a_of_type_Boolean);
      localIntent.putExtra("uin", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("seq", this.jdField_a_of_type_Int);
      LoginUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, localIntent, str, 1002);
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
      ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800B661", "0X800B661", this.jdField_c_of_type_Int, 0, "", "", "", "");
      ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800ADDE", "0X800ADDE", 0, 0, "", "", "", "");
      return;
    }
  }
  
  private void d()
  {
    Intent localIntent = new Intent();
    if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
    {
      localIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
      localIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
      localIntent.putExtra("mobile_type", 0);
      localIntent.putExtra("DevlockInfo", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
    }
    localIntent.putExtra("from_login", this.jdField_a_of_type_Boolean);
    localIntent.putExtra("uin", this.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("seq", this.jdField_a_of_type_Int);
    localIntent.putExtra("mainaccount", this.jdField_c_of_type_JavaLangString);
    QPublicFragmentActivity.a(this, localIntent, GatewayVerifyFailedFragment.class, 1);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new NewAuthDevUgFragment.2(this);
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.broadcast.action.authdev.phonechange");
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void k()
  {
    l();
    Object localObject = new GatewayVerify.ReqBody();
    GatewayVerify.ReqBodySelfPhone localReqBodySelfPhone = new GatewayVerify.ReqBodySelfPhone();
    GatewayVerify.ReqBodySelfPhoneGetUrlV4 localReqBodySelfPhoneGetUrlV4 = new GatewayVerify.ReqBodySelfPhoneGetUrlV4();
    localReqBodySelfPhoneGetUrlV4.uint32_get_upload_url.set(1);
    try
    {
      i = DeviceInfoUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
      QLog.d("NewAuthDevUgFragment", 1, new Object[] { "carrier ：", Integer.valueOf(i) });
      localReqBodySelfPhoneGetUrlV4.uint32_isp_type.set(i);
      String str = IPUtils.a();
      if ((!NetworkUtil.h(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity)) && (!"0.0.0.0".equals(str)))
      {
        localReqBodySelfPhoneGetUrlV4.str_cell_ip.set(str);
        localReqBodySelfPhone.msg_req_get_url_v4.set(localReqBodySelfPhoneGetUrlV4);
        ((GatewayVerify.ReqBody)localObject).msg_req_self_phone.set(localReqBodySelfPhone);
        localObject = ((GatewayVerify.ReqBody)localObject).toByteArray();
        i = this.jdField_a_of_type_ComTencentMobileqqLoginregisterEquipLockProxy.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), (byte[])localObject, this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver);
        if (i != 0) {
          break label211;
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetGatewayLoadingDrawable.b();
      }
    }
    catch (Exception localException)
    {
      int i;
      for (;;)
      {
        QLog.e("NewAuthDevUgFragment", 1, new Object[] { "getCarrier error : ", localException.getMessage() });
        i = 0;
        continue;
        QLog.d("NewAuthDevUgFragment", 1, "get ip error");
      }
      label211:
      QLog.e("NewAuthDevUgFragment", 1, new Object[] { "refreshDevLockSms error , ret : ", Integer.valueOf(i) });
    }
  }
  
  private void l()
  {
    ThreadManager.getUIHandler().post(new NewAuthDevUgFragment.3(this));
  }
  
  private void m()
  {
    ThreadManager.getUIHandler().post(new NewAuthDevUgFragment.4(this));
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetGatewayLoadingDrawable.a();
    this.f.setText(2131692047);
  }
  
  private void o()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.OtherDevLockVerifyUrl)))
    {
      QLog.e("NewAuthDevUgFragment", 1, "jumpToOtherVerify, mDevlockInfo or OtherDevLockVerifyUrl is null");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("portraitOnly", true);
    Object localObject1 = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.OtherDevLockVerifyUrl;
    int i;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile))
    {
      localObject1 = new StringBuilder(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.OtherDevLockVerifyUrl);
      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.OtherDevLockVerifyUrl.contains("?"))
      {
        ((StringBuilder)localObject1).append("&");
        Object localObject2 = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile.split("\\*+");
        if (localObject2.length > 1)
        {
          i = this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile.length();
          int j = localObject2[0].length();
          int k = localObject2[1].length();
          localObject2 = ((StringBuilder)localObject1).append("pp=").append(localObject2[0]).append("&tp=").append(localObject2[1]).append("&ccode=").append(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode).append("&vseq=").append(this.jdField_a_of_type_Int).append("&starnum=").append(i - j - k).append("&isFromLogin=");
          if (!this.jdField_a_of_type_Boolean) {
            break label535;
          }
          i = 1;
          label252:
          localObject2 = ((StringBuilder)localObject2).append(i).append("&isFromOpenSdk=");
          if (!"com.tencent.mobileqq:openSdk".equals(this.jdField_a_of_type_MqqAppAppRuntime.getApplication().getQQProcessName())) {
            break label540;
          }
          i = 1;
          ((StringBuilder)localObject2).append(i).append("&mentrance=").append(1);
        }
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    else
    {
      localIntent.putExtra("url", (String)localObject1);
      localIntent.putExtra("subAccountUin", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("hide_more_button", true);
      if ((this.jdField_c_of_type_JavaLangString == null) || (this.jdField_c_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString))) {
        break label550;
      }
    }
    for (;;)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NewAuthDevUgFragment", 2, "other_verify,  mMainAccount =" + this.jdField_c_of_type_JavaLangString + " mUin =" + this.jdField_a_of_type_JavaLangString + " isSubaccount=" + bool);
        }
        localIntent.putExtra("isSubaccount", bool);
        localIntent.putExtra("avoidLoginWeb", bool);
        a();
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqLoginregisterEquipLockProxy.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, "", 16384L, localIntent, false, -1);
          label482:
          b();
          ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800A413", "0X800A413", 0, 0, "", "", "", "");
          return;
          ((StringBuilder)localObject1).append("?");
          break;
          label535:
          i = 0;
          break label252;
          label540:
          i = 0;
        }
        catch (SecurityException localSecurityException)
        {
          break label482;
        }
      }
      label550:
      bool = false;
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
    QLog.d("NewAuthDevUgFragment", 1, "beforeOpenBrowser do finish");
  }
  
  public void a(int paramInt, Exception paramException)
  {
    if (a())
    {
      QLog.e("NewAuthDevUgFragment", 1, "GatewayCallback onGetTokenError getActivity is null or activity is finish");
      return;
    }
    m();
    QLog.e("NewAuthDevUgFragment", 1, new Object[] { "GatewayCallback onGetTokenError : ", paramException.getMessage() });
    a("V_GET_TOKEN_ERROR", paramInt, paramException.getMessage());
    c();
    GatewayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime, 3, this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(Exception paramException)
  {
    if (a())
    {
      QLog.e("NewAuthDevUgFragment", 1, "GatewayCallback onChangeNetworkError getActivity is null or activity is finish");
      return;
    }
    m();
    QLog.e("NewAuthDevUgFragment", 1, new Object[] { "GatewayCallback onChangeNetworkError : ", paramException.getMessage() });
    a("V_CHANGE_NETWORK_TYPE_ERROR", -1, paramException.getMessage());
    c();
    GatewayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime, 3, this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (a()) {
      QLog.e("NewAuthDevUgFragment", 1, "GatewayCallback onTokenCallback getActivity is null or activity is finish");
    }
    int i;
    do
    {
      return;
      i = this.jdField_a_of_type_ComTencentMobileqqLoginregisterEquipLockProxy.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver, paramArrayOfByte);
    } while (i == 0);
    QLog.e("NewAuthDevUgFragment", 1, new Object[] { "mEquipLockProxy.submitSms error, ret : ", Integer.valueOf(i) });
  }
  
  boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isFinishing());
  }
  
  protected void b()
  {
    QLog.d("NewAuthDevUgFragment", 1, "afterOpenBrowser do nothing");
  }
  
  public boolean d_()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1001) {
      if (paramInt2 == -1)
      {
        paramIntent = new Intent();
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
        {
          paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
          paramIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
        }
        paramIntent.putExtra("auth_dev_open", true);
        LoginUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, paramIntent, "/base/safe/authDevActivity");
        paramIntent = new Intent();
        paramIntent.putExtra("auth_dev_open", true);
        paramIntent.putExtra("allow_set", true);
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
          paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.setResult(-1, paramIntent);
        this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            boolean bool;
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return;
                      if (paramInt1 != 1002) {
                        break;
                      }
                    } while (paramInt2 != -1);
                    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.setResult(paramInt2, paramIntent);
                    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
                    return;
                  } while (paramInt1 != 1003);
                  if (paramInt2 != -1) {
                    break;
                  }
                } while ((paramIntent == null) || (paramIntent.getExtras() == null));
                paramInt1 = paramIntent.getExtras().getInt("resultState", 1);
                if (QLog.isColorLevel()) {
                  QLog.d("NewAuthDevUgFragment", 2, "onActivityResult.resultCode= RESULT_OK  resultState =" + paramInt1);
                }
              } while (paramInt1 != 2);
              localObject = paramIntent.getExtras().getString("resultMobileMask");
              bool = paramIntent.getExtras().getBoolean("resultSetMobile");
              if (QLog.isColorLevel()) {
                QLog.d("NewAuthDevUgFragment", 2, "onActivityResult.resultCode= RESULT_OK  resultMobileMask =" + (String)localObject + " openSuccess=" + bool);
              }
              if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
              {
                this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile = ((String)localObject);
                if (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile))
                {
                  a(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
                  this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131692065));
                  this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
                }
              }
            } while (!bool);
            this.jdField_a_of_type_ComTencentMobileqqLoginregisterEquipLockProxy.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin(), true);
            paramIntent = new Intent();
            paramIntent.putExtra("phone_num", (String)localObject);
            if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
              paramIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
            }
            paramIntent.putExtra("auth_dev_open", true);
            LoginUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, paramIntent, "/base/safe/authDevActivity");
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2, getString(2131692061), 0).a();
            Object localObject = new Intent();
            ((Intent)localObject).putExtra("auth_dev_open", true);
            ((Intent)localObject).putExtra("allow_set", true);
            if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
              ((Intent)localObject).putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.setResult(-1, paramIntent);
            this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
            return;
          } while ((paramInt2 != 0) || (paramIntent == null) || (paramIntent.getExtras() == null));
          paramInt1 = paramIntent.getExtras().getInt("resultState", 1);
          if (QLog.isColorLevel()) {
            QLog.d("NewAuthDevUgFragment", 2, "onActivityResult.resultCode= RESULT_CANCELED resultState =" + paramInt1);
          }
        } while (paramInt1 != 2);
        paramIntent = paramIntent.getExtras().getString("resultMobileMask");
        if (QLog.isColorLevel()) {
          QLog.d("NewAuthDevUgFragment", 2, "onActivityResult.resultCode= RESULT_CANCELED resultMobileMask =" + paramIntent);
        }
        if (!TextUtils.isEmpty(paramIntent)) {
          this.jdField_a_of_type_ComTencentMobileqqLoginregisterEquipLockProxy.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin(), null);
        }
      } while (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null);
      this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile = paramIntent;
    } while (TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile));
    a(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131692065));
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Long > 0L) && (System.currentTimeMillis() - this.jdField_a_of_type_Long > 0L) && (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      int i = paramView.getId();
      if (i == 2131380251)
      {
        ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800AA34", "0X800AA34", LoginStaticField.a(), 0, "", "", "", "");
        ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800ADDD", "0X800ADDD", this.jdField_c_of_type_Int, 0, "", "", "", "");
        this.jdField_a_of_type_MqqAppAppRuntime.sendWirelessMeibaoReq(1);
        if (QBaseActivity.mAppForground)
        {
          if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_b_of_type_JavaLangString.equals("subaccount")))
          {
            if (QLog.isColorLevel()) {
              QLog.d("NewAuthDevUgFragment", 2, "subaccount enter webview mUin=" + this.jdField_a_of_type_JavaLangString + " mMainAccount=" + this.jdField_c_of_type_JavaLangString);
            }
            if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (QLog.isColorLevel())) {
              QLog.d("NewAuthDevUgFragment", 2, "mUin is empty.");
            }
            this.jdField_a_of_type_ComTencentMobileqqLoginregisterEquipLockProxy.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, 1);
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("NewAuthDevUgFragment", 2, "mainaccount enter webview mUin=" + this.jdField_a_of_type_JavaLangString);
            }
            if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (QLog.isColorLevel())) {
              QLog.d("NewAuthDevUgFragment", 2, "mUin is empty.");
            }
            this.jdField_a_of_type_ComTencentMobileqqLoginregisterEquipLockProxy.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString, 1);
          }
        }
        else {
          this.jdField_a_of_type_ComTencentMobileqqLoginregisterEquipLockProxy.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime, 1);
        }
      }
      else if (i == 2131380503)
      {
        if ((this.jdField_b_of_type_Long <= 0L) || (System.currentTimeMillis() - this.jdField_b_of_type_Long <= 0L) || (System.currentTimeMillis() - this.jdField_b_of_type_Long >= 3000L))
        {
          this.jdField_b_of_type_Long = System.currentTimeMillis();
          ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800AA36", "0X800AA36", LoginStaticField.a(), 0, "", "", "", "");
          ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800ADDC", "0X800ADDC", this.jdField_c_of_type_Int, 0, "", "", "", "");
          o();
        }
      }
      else
      {
        if (i == 2131380695)
        {
          GatewayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime, 2, this.jdField_a_of_type_JavaLangString);
          boolean bool3 = this.jdField_a_of_type_Boolean;
          boolean bool1;
          label556:
          boolean bool2;
          if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null)
          {
            bool1 = true;
            if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null) || (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile))) {
              break label857;
            }
            bool2 = true;
            label579:
            QLog.d("NewAuthDevUgFragment", 1, new Object[] { "onCLick Verify btn, from login: ", Boolean.valueOf(bool3), "mDev is null ? ", Boolean.valueOf(bool1), " , mobile is null ? ", Boolean.valueOf(bool2) });
            if ((!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile)) && (!this.jdField_b_of_type_Boolean)) {
              break label863;
            }
            ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800BA0C", "0X800BA0C", this.jdField_c_of_type_Int, 0, "", "", "", "");
            if (this.jdField_b_of_type_Boolean) {
              ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800B9E4", "0X800B9E4", 0, 0, "", "", "", "");
            }
            label735:
            if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null) || (!this.jdField_a_of_type_Boolean)) {
              break label913;
            }
            ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800AA35", "0X800AA35", LoginStaticField.a(), 0, "", "", "", "");
            if ((!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile)) && (!this.jdField_b_of_type_Boolean)) {
              break label906;
            }
            o();
          }
          for (;;)
          {
            ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800ADDB", "0X800ADDB", 0, 0, "", "", "", "");
            break;
            bool1 = false;
            break label556;
            label857:
            bool2 = false;
            break label579;
            label863:
            ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800B660", "0X800B660", this.jdField_c_of_type_Int, 0, "", "", "", "");
            break label735;
            label906:
            k();
            continue;
            label913:
            if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile)))
            {
              ReportController.b(null, "CliOper", "", "", "My_eq_lock", "My_eq_lock_open", 0, 0, "1", "", "", "");
              Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, AuthDevVerifyCodeActivity.class);
              localIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
              localIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
              startActivityForResult(localIntent, 1001);
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqLoginregisterEquipLockProxy.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime, 1, 1003, null);
            }
          }
        }
        if (i == 2131369582)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
          ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800ADDA", "0X800ADDA", this.jdField_c_of_type_Int, 0, "", "", "", "");
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = getActivity();
    this.jdField_a_of_type_MqqAppAppRuntime = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime();
    if ((!ThemeUtil.a(this.jdField_a_of_type_MqqAppAppRuntime, false, null)) && (!ThemeUtil.b())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ImmersiveUtils.setStatusTextColor(true, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getWindow());
      }
      paramLayoutInflater = paramLayoutInflater.inflate(2131561184, paramViewGroup, false);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131380695));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131380503));
      this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131369582);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131380251));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131380616));
      this.e = ((TextView)paramLayoutInflater.findViewById(2131380509));
      this.jdField_a_of_type_ComTencentMobileqqWidgetGatewayLoadingDrawable = new GatewayLoadingDrawable();
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131755248);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131558413);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131369712));
      this.f = ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131380487));
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqWidgetGatewayLoadingDrawable);
      paramLayoutInflater.findViewById(2131369582).setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqLogintempapiILoginApi = ((ILoginApi)QRoute.api(ILoginApi.class));
      this.jdField_a_of_type_ComTencentMobileqqLoginregisterEquipLockProxy = new EquipLockProxy();
      paramViewGroup = getArguments();
      if (paramViewGroup != null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
      return paramLayoutInflater;
    }
    paramBundle = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramBundle.topMargin = (Utils.a(6.0F, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources()) + ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity));
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramBundle);
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Boolean = paramViewGroup.getBoolean("from_login");
        this.jdField_a_of_type_Int = paramViewGroup.getInt("seq");
        paramBundle = paramViewGroup.get("DevlockInfo");
        if ((paramBundle instanceof DevlockInfo)) {
          this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = ((DevlockInfo)paramBundle);
        }
        this.jdField_a_of_type_JavaLangString = paramViewGroup.getString("uin");
        this.jdField_b_of_type_JavaLangString = paramViewGroup.getString("from_where");
        this.jdField_c_of_type_JavaLangString = paramViewGroup.getString("mainaccount");
        if (this.jdField_a_of_type_Boolean)
        {
          LoginUtils.b(this.jdField_a_of_type_MqqAppAppRuntime);
          if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideInfo))) {
            this.jdField_a_of_type_ComTencentMobileqqLoginregisterEquipLockProxy.a(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideInfo);
          }
        }
        if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile != null))
        {
          a(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
          if (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.VerifyReason)) {
            this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.VerifyReason);
          }
        }
        this.jdField_b_of_type_Boolean = paramViewGroup.getBoolean("from_phone_num_login");
        if (this.jdField_b_of_type_Boolean)
        {
          this.jdField_c_of_type_Int = 3;
          ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800B9E3", "0X800B9E3", 0, 0, "", "", "", "");
          if (((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null) || (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile))) && (this.jdField_c_of_type_Int != 3)) {
            break label1456;
          }
          this.e.setVisibility(8);
          this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131698691));
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
          ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800BA0B", "0X800BA0B", this.jdField_c_of_type_Int, 0, "", "", "", "");
          if (QLog.isColorLevel())
          {
            QLog.d("NewAuthDevUgFragment", 2, "onCreate mIsFromLogin = " + this.jdField_a_of_type_Boolean + " mVerifySeq=" + this.jdField_a_of_type_Int + " mUin=" + this.jdField_a_of_type_JavaLangString + " mFromWhere=" + this.jdField_b_of_type_JavaLangString + " mMainAccount=" + this.jdField_c_of_type_JavaLangString);
            if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
            {
              QLog.d("NewAuthDevUgFragment", 2, "onCreate DevlockInfo devSetup:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup + " countryCode:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode + " mobile:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile + " MbItemSmsCodeStatus:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbItemSmsCodeStatus + " TimeLimit:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.TimeLimit + " AvailableMsgCount:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AvailableMsgCount + " AllowSet:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet);
              QLog.d("NewAuthDevUgFragment", 2, "DevlockInfo.ProtectIntro:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.ProtectIntro + "  info.MbGuideType:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideType);
              QLog.d("NewAuthDevUgFragment", 2, "DevlockInfo.MbGuideMsg:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideMsg);
              QLog.d("NewAuthDevUgFragment", 2, "DevlockInfo.MbGuideInfoType:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideInfoType);
              QLog.d("NewAuthDevUgFragment", 2, "DevlockInfo.MbGuideInfo:" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.MbGuideInfo);
              QLog.d("NewAuthDevUgFragment", 2, "DevlockInfo.OtherDevLockVerifyUrl" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.OtherDevLockVerifyUrl);
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getWindow().setFormat(-3);
          if (this.jdField_a_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.setTheme(2131755586);
          }
          if (this.jdField_a_of_type_Boolean) {
            LoginUtils.b(this.jdField_a_of_type_MqqAppAppRuntime);
          }
          this.jdField_b_of_type_Boolean = paramViewGroup.getBoolean("from_phone_num_login");
          if (this.jdField_b_of_type_Boolean)
          {
            this.e.setVisibility(8);
            this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
            this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131698691));
            this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
            ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800B9E3", "0X800B9E3", LoginStaticField.a(), 0, "", "", "", "");
          }
          this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeGateWayVerifyManager = GateWayVerifyManager.a();
          this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver = new NewAuthDevUgFragment.VerifyObserverWrapper(this.jdField_b_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver);
          this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver.setSeq(this.jdField_a_of_type_Int);
          j();
          ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800AA33", "0X800AA33", LoginStaticField.a(), 0, "", "", "", "");
          if (LoginStaticField.a() == 1) {
            ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800AC0B", "0X800AC0B", LoginStaticField.a(), 0, "", "", "", "");
          }
          GatewayUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime, 1, this.jdField_a_of_type_JavaLangString);
          return paramLayoutInflater;
        }
      }
      catch (Exception paramViewGroup)
      {
        QLog.e("NewAuthDevUgFragment", 1, new Object[] { "get devInfo error : ", paramViewGroup.getMessage() });
        this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
        return paramLayoutInflater;
      }
      if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup == 1))
      {
        this.jdField_c_of_type_Int = 1;
      }
      else
      {
        this.jdField_c_of_type_Int = 2;
        continue;
        label1456:
        ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800ADD9", "0X800ADD9", this.jdField_c_of_type_Int, 0, "", "", "", "");
      }
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.jdField_a_of_type_ComTencentMobileqqLoginwelcomeGateWayVerifyManager.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetGatewayLoadingDrawable.c();
    if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NewAuthDevUgFragment
 * JD-Core Version:    0.7.0.1
 */