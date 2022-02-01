package com.tencent.mobileqq.activity;

import aeiz;
import aeja;
import android.app.Dialog;
import android.content.Intent;
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
import aslh;
import asll;
import awoq;
import awov;
import awow;
import awpq;
import bdla;
import biot;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.GatewayVerifyFailedFragment;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.AuthDevVerifyCodeActivity2;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import qcg;
import tencent.im.login.GatewayVerify.ReqBody;
import tencent.im.login.GatewayVerify.ReqBodySelfPhone;
import tencent.im.login.GatewayVerify.ReqBodySelfPhoneGetUrlV4;
import tencent.im.login.GatewayVerify.RspBody;
import tencent.im.login.GatewayVerify.RspBodySelfPhone;
import tencent.im.login.GatewayVerify.RspBodySelfPhoneGetUrlV4;
import tencent.im.login.GatewayVerify.SelfPhoneUrl;

public class NewAuthDevUgFragment
  extends PublicBaseFragment
  implements View.OnClickListener, awow
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private awoq jdField_a_of_type_Awoq;
  private biot jdField_a_of_type_Biot;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private String jdField_a_of_type_JavaLangString;
  private VerifyDevLockManager.VerifyDevLockObserver jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver;
  private DevlockInfo jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private VerifyDevLockManager.VerifyDevLockObserver jdField_b_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver = new aeiz(this);
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString;
  private TextView e;
  private TextView f;
  
  private MqqHandler a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHandler(LoginActivity.class);
    if (localObject != null) {}
    MqqHandler localMqqHandler;
    do
    {
      return localObject;
      localMqqHandler = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHandler(SubLoginActivity.class);
      localObject = localMqqHandler;
    } while (localMqqHandler != null);
    return this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHandler(AddAccountActivity.class);
  }
  
  private void a(Object paramObject)
  {
    if (paramObject == null)
    {
      QLog.e("NewAuthDevUgFragment", 1, "data is null");
      c();
      return;
    }
    Object localObject;
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
      if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {}
    }
    for (paramObject = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface;; paramObject = null)
    {
      awov.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramObject, 3, this.jdField_a_of_type_JavaLangString);
      return;
      int i = ((List)localObject).size();
      if (i == 0)
      {
        QLog.d("NewAuthDevUgFragment", 1, "getGatewayToken, selfPhoneUrls is empty");
        a("V_GET_GATEWAY_URL_ERROR", -1, "selfPhoneUrls is empty");
        c();
        return;
      }
      paramObject = new awpq(getActivity(), this.jdField_d_of_type_JavaLangString, i, this);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        GatewayVerify.SelfPhoneUrl localSelfPhoneUrl = (GatewayVerify.SelfPhoneUrl)((Iterator)localObject).next();
        if (localSelfPhoneUrl == null)
        {
          a("V_GET_GATEWAY_URL_ERROR", -1, "url bean is null");
          c();
          return;
        }
        this.jdField_a_of_type_Awoq.a(localSelfPhoneUrl, paramObject);
      }
      break;
    }
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface();
    if (localObject == null) {}
    for (localObject = "";; localObject = ((AppInterface)localObject).getAccount())
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("K_RESULT_TYPE", paramString1);
      localHashMap.put("K_RET", String.valueOf(paramInt));
      localHashMap.put("K_UIN", localObject);
      localHashMap.put("K_RESULT_MSG", paramString2);
      if ("V_RET_SUCCESS".equals(paramString1)) {
        localHashMap.put("K_REDIRECT_TIME", String.valueOf(this.jdField_b_of_type_Int));
      }
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance((String)localObject, "TGatewayVerifyResult", "V_RET_SUCCESS".equals(paramString1), 0L, 0L, localHashMap, "");
      return;
    }
  }
  
  private void c()
  {
    if ("com.tencent.mobileqq:openSdk".equals(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getQQProcessName()))
    {
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AuthDevVerifyCodeActivity2.class);
      if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
      {
        ((Intent)localObject).putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
        ((Intent)localObject).putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
        ((Intent)localObject).putExtra("mobile_type", 0);
      }
      ((Intent)localObject).putExtra("from_login", this.jdField_a_of_type_Boolean);
      ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("seq", this.jdField_a_of_type_Int);
      startActivityForResult((Intent)localObject, 1002);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
      if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
        break label197;
      }
    }
    label197:
    for (Object localObject = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface;; localObject = null)
    {
      bdla.a((QQAppInterface)localObject, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800ADDE", "0X800ADDE", 0, 0, "", "", "", "");
      return;
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AuthDevVerifyCodeActivity.class);
      break;
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
    PublicFragmentActivity.a(this, localIntent, GatewayVerifyFailedFragment.class, 1);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
  }
  
  private void e()
  {
    f();
    Object localObject = new GatewayVerify.ReqBody();
    GatewayVerify.ReqBodySelfPhone localReqBodySelfPhone = new GatewayVerify.ReqBodySelfPhone();
    GatewayVerify.ReqBodySelfPhoneGetUrlV4 localReqBodySelfPhoneGetUrlV4 = new GatewayVerify.ReqBodySelfPhoneGetUrlV4();
    localReqBodySelfPhoneGetUrlV4.uint32_get_upload_url.set(1);
    try
    {
      i = DeviceInfoUtil.getNetworkOperatorCode(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      QLog.d("NewAuthDevUgFragment", 1, new Object[] { "carrier ：", Integer.valueOf(i) });
      localReqBodySelfPhoneGetUrlV4.uint32_isp_type.set(i);
      String str = qcg.a();
      if ((!NetworkUtil.isWifiConnected(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)) && (!"0.0.0.0".equals(str)))
      {
        localReqBodySelfPhoneGetUrlV4.str_cell_ip.set(str);
        localReqBodySelfPhone.msg_req_get_url_v4.set(localReqBodySelfPhoneGetUrlV4);
        ((GatewayVerify.ReqBody)localObject).msg_req_self_phone.set(localReqBodySelfPhone);
        localObject = ((GatewayVerify.ReqBody)localObject).toByteArray();
        i = asll.a().a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface(), (byte[])localObject, this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver);
        if (i != 0) {
          break label210;
        }
        this.jdField_a_of_type_Biot.b();
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
      label210:
      QLog.e("NewAuthDevUgFragment", 1, new Object[] { "refreshDevLockSms error , ret : ", Integer.valueOf(i) });
    }
  }
  
  private void f()
  {
    ThreadManager.getUIHandler().post(new NewAuthDevUgFragment.2(this));
  }
  
  private void g()
  {
    ThreadManager.getUIHandler().post(new NewAuthDevUgFragment.3(this));
  }
  
  private void h()
  {
    this.jdField_a_of_type_Biot.a();
    this.f.setText(2131691919);
  }
  
  private void i()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.OtherDevLockVerifyUrl)))
    {
      QLog.e("NewAuthDevUgFragment", 1, "jumpToOtherVerify, mDevlockInfo or OtherDevLockVerifyUrl is null");
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
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
            break label548;
          }
          i = 1;
          label259:
          localObject2 = ((StringBuilder)localObject2).append(i).append("&isFromOpenSdk=");
          if (!"com.tencent.mobileqq:openSdk".equals(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getQQProcessName())) {
            break label553;
          }
          i = 1;
          label294:
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
        break label569;
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
          VasWebviewUtil.openQQBrowserActivity(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, "", 16384L, localIntent, false, -1);
          label484:
          b();
          if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {}
          for (localObject1 = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface;; localObject1 = null)
          {
            bdla.a((QQAppInterface)localObject1, "dc00898", "", "", "0X800A413", "0X800A413", 0, 0, "", "", "", "");
            return;
            ((StringBuilder)localObject1).append("?");
            break;
            label548:
            i = 0;
            break label259;
            label553:
            i = 0;
            break label294;
          }
        }
        catch (SecurityException localSecurityException)
        {
          break label484;
        }
      }
      label569:
      bool = false;
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
    QLog.d("NewAuthDevUgFragment", 1, "beforeOpenBrowser do finish");
  }
  
  public void a(int paramInt, Exception paramException)
  {
    if (a())
    {
      QLog.e("NewAuthDevUgFragment", 1, "GatewayCallback onGetTokenError getActivity is null or activity is finish");
      return;
    }
    g();
    QLog.e("NewAuthDevUgFragment", 1, new Object[] { "GatewayCallback onGetTokenError : ", paramException.getMessage() });
    a("V_GET_TOKEN_ERROR", paramInt, paramException.getMessage());
    c();
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {}
    for (paramException = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface;; paramException = null)
    {
      awov.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramException, 3, this.jdField_a_of_type_JavaLangString);
      return;
    }
  }
  
  public void a(Exception paramException)
  {
    if (a())
    {
      QLog.e("NewAuthDevUgFragment", 1, "GatewayCallback onChangeNetworkError getActivity is null or activity is finish");
      return;
    }
    g();
    QLog.e("NewAuthDevUgFragment", 1, new Object[] { "GatewayCallback onChangeNetworkError : ", paramException.getMessage() });
    a("V_CHANGE_NETWORK_TYPE_ERROR", -1, paramException.getMessage());
    c();
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {}
    for (paramException = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface;; paramException = null)
    {
      awov.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramException, 3, this.jdField_a_of_type_JavaLangString);
      return;
    }
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
      i = asll.a().a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface(), this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver, paramArrayOfByte);
    } while (i == 0);
    QLog.e("NewAuthDevUgFragment", 1, new Object[] { "EquipmentLockImpl.getInstance().submitSms error, ret : ", Integer.valueOf(i) });
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing());
  }
  
  protected void b()
  {
    QLog.d("NewAuthDevUgFragment", 1, "afterOpenBrowser do nothing");
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1001) {
      if (paramInt2 == -1)
      {
        paramIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AuthDevActivity.class);
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null)
        {
          paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
          paramIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
        }
        paramIntent.putExtra("auth_dev_open", true);
        startActivity(paramIntent);
        paramIntent = new Intent();
        paramIntent.putExtra("auth_dev_open", true);
        paramIntent.putExtra("allow_set", true);
        if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
          paramIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(-1, paramIntent);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
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
                    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(paramInt2, paramIntent);
                    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
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
                  paramIntent = getString(2131691976) + ":" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile;
                  this.e.setText(paramIntent);
                  this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131691937));
                  this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
                }
              }
            } while (!bool);
            asll.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), true);
            paramIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AuthDevActivity.class);
            paramIntent.putExtra("phone_num", (String)localObject);
            if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
              paramIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
            }
            paramIntent.putExtra("auth_dev_open", true);
            startActivity(paramIntent);
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, getString(2131691933), 0).a();
            Object localObject = new Intent();
            ((Intent)localObject).putExtra("auth_dev_open", true);
            ((Intent)localObject).putExtra("allow_set", true);
            if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
              ((Intent)localObject).putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(-1, paramIntent);
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
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
          asll.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), null);
        }
      } while (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null);
      this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile = paramIntent;
    } while (TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile));
    paramIntent = getString(2131691976) + ":" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile;
    this.e.setText(paramIntent);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131691937));
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Long > 0L) && (System.currentTimeMillis() - this.jdField_a_of_type_Long > 0L) && (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L)) {}
    QQAppInterface localQQAppInterface;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {}
      for (localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface;; localQQAppInterface = null) {
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131369327: 
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
          bdla.a(localQQAppInterface, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800ADDA", "0X800ADDA", 0, 0, "", "", "", "");
          break;
        }
      }
      bdla.a(localQQAppInterface, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800AA34", "0X800AA34", AuthDevUgActivity.a(), 0, "", "", "", "");
      bdla.a(localQQAppInterface, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800ADDD", "0X800ADDD", 0, 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.sendWirelessMeibaoReq(1);
      if (BaseActivity.mAppForground)
      {
        if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_b_of_type_JavaLangString.equals("subaccount")))
        {
          if (QLog.isColorLevel()) {
            QLog.d("NewAuthDevUgFragment", 2, "subaccount enter webview mUin=" + this.jdField_a_of_type_JavaLangString + " mMainAccount=" + this.jdField_c_of_type_JavaLangString);
          }
          if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (QLog.isColorLevel())) {
            QLog.d("NewAuthDevUgFragment", 2, "mUin is empty.");
          }
          aslh.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, aslh.jdField_a_of_type_Int);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("NewAuthDevUgFragment", 2, "mainaccount enter webview mUin=" + this.jdField_a_of_type_JavaLangString);
          }
          if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (QLog.isColorLevel())) {
            QLog.d("NewAuthDevUgFragment", 2, "mUin is empty.");
          }
          aslh.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString, aslh.jdField_a_of_type_Int);
        }
      }
      else
      {
        aslh.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface, aslh.jdField_a_of_type_Int);
        continue;
        if ((this.jdField_b_of_type_Long <= 0L) || (System.currentTimeMillis() - this.jdField_b_of_type_Long <= 0L) || (System.currentTimeMillis() - this.jdField_b_of_type_Long >= 3000L))
        {
          this.jdField_b_of_type_Long = System.currentTimeMillis();
          bdla.a(localQQAppInterface, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800AA36", "0X800AA36", AuthDevUgActivity.a(), 0, "", "", "", "");
          bdla.a(localQQAppInterface, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800ADDC", "0X800ADDC", 0, 0, "", "", "", "");
          i();
        }
      }
    }
    awov.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, localQQAppInterface, 2, this.jdField_a_of_type_JavaLangString);
    boolean bool3 = this.jdField_a_of_type_Boolean;
    boolean bool1;
    label601:
    boolean bool2;
    if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null)
    {
      bool1 = true;
      if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null) || (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile))) {
        break label775;
      }
      bool2 = true;
      label623:
      QLog.d("NewAuthDevUgFragment", 1, new Object[] { "onCLick Verify btn, from login: ", Boolean.valueOf(bool3), "mDev is null ? ", Boolean.valueOf(bool1), " , mobile is null ? ", Boolean.valueOf(bool2) });
      if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null) || (!this.jdField_a_of_type_Boolean)) {
        break label787;
      }
      bdla.a(localQQAppInterface, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800AA35", "0X800AA35", AuthDevUgActivity.a(), 0, "", "", "", "");
      if (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile)) {
        break label780;
      }
      i();
    }
    for (;;)
    {
      bdla.a(localQQAppInterface, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800ADDB", "0X800ADDB", 0, 0, "", "", "", "");
      break;
      bool1 = false;
      break label601;
      label775:
      bool2 = false;
      break label623;
      label780:
      e();
      continue;
      label787:
      if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile)))
      {
        bdla.b(null, "CliOper", "", "", "My_eq_lock", "My_eq_lock_open", 0, 0, "1", "", "", "");
        Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AuthDevVerifyCodeActivity.class);
        localIntent.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
        localIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
        startActivityForResult(localIntent, 1001);
      }
      else
      {
        aslh.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface, aslh.jdField_a_of_type_Int, 1003, null);
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getActivity();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface();
    if ((!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) && (!ThemeUtil.isGoldenTheme())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ImmersiveUtils.a(true, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow());
      }
      paramViewGroup = paramLayoutInflater.inflate(2131561096, paramViewGroup, false);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131380252));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131380066));
      this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131369327);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131379823));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131380176));
      this.jdField_a_of_type_Biot = new biot();
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131755243);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(2131558413);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131369453));
      this.f = ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131380050));
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_Biot);
      paramViewGroup.findViewById(2131369327).setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      paramLayoutInflater = getArguments();
      if (paramLayoutInflater != null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
      V4FragmentCollector.onV4FragmentViewCreated(this, paramViewGroup);
      return paramViewGroup;
    }
    paramBundle = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramBundle.topMargin = (AIOUtils.dp2px(6.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources()) + ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity));
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramBundle);
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Boolean = paramLayoutInflater.getBoolean("from_login");
        this.jdField_a_of_type_Int = paramLayoutInflater.getInt("seq");
        paramBundle = paramLayoutInflater.get("DevlockInfo");
        if ((paramBundle instanceof DevlockInfo)) {
          this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo = ((DevlockInfo)paramBundle);
        }
        this.jdField_a_of_type_JavaLangString = paramLayoutInflater.getString("uin");
        this.jdField_b_of_type_JavaLangString = paramLayoutInflater.getString("from_where");
        this.jdField_c_of_type_JavaLangString = paramLayoutInflater.getString("mainaccount");
        if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile != null))
        {
          this.e = ((TextView)paramViewGroup.findViewById(2131380072));
          this.e.setText(getString(2131698410, new Object[] { this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile }));
          if (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.VerifyReason)) {
            this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.VerifyReason);
          }
        }
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
        if (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
          break label1142;
        }
        paramLayoutInflater = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface;
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().setFormat(-3);
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setTheme(2131755578);
        }
        if (this.jdField_a_of_type_Boolean)
        {
          paramBundle = a();
          if (paramBundle != null) {
            paramBundle.sendEmptyMessage(20140107);
          }
        }
        this.jdField_a_of_type_Awoq = awoq.a();
        this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver = new aeja(this.jdField_b_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver);
        this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver.setSeq(this.jdField_a_of_type_Int);
        bdla.a(paramLayoutInflater, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800AA33", "0X800AA33", AuthDevUgActivity.a(), 0, "", "", "", "");
        bdla.a(paramLayoutInflater, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800ADD9", "0X800ADD9", 0, 0, "", "", "", "");
        if (AuthDevUgActivity.a() == 1) {
          bdla.a(paramLayoutInflater, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800AC0B", "0X800AC0B", AuthDevUgActivity.a(), 0, "", "", "", "");
        }
        awov.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramLayoutInflater, 1, this.jdField_a_of_type_JavaLangString);
      }
      catch (Exception paramLayoutInflater)
      {
        QLog.e("NewAuthDevUgFragment", 1, new Object[] { "get devInfo error : ", paramLayoutInflater.getMessage() });
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
      }
      break;
      label1142:
      paramLayoutInflater = null;
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.jdField_a_of_type_Awoq.a();
    this.jdField_a_of_type_Biot.c();
    if (this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NewAuthDevUgFragment
 * JD-Core Version:    0.7.0.1
 */