package com.tencent.mobileqq.activity;

import adjo;
import adjp;
import adjq;
import aepi;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqaz;
import aqbd;
import azqs;
import azri;
import bdgk;
import bdin;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.GatewayVerifyFailedFragment;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.AuthDevVerifyCodeActivity2;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import mqq.app.MobileQQ;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import pco;
import tencent.im.login.GatewayVerify.ReqBody;
import tencent.im.login.GatewayVerify.ReqBodySelfPhone;
import tencent.im.login.GatewayVerify.ReqBodySelfPhoneGetUrl;

public class NewAuthDevUgFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  public static final ArrayList<String> a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private adjp jdField_a_of_type_Adjp;
  private View jdField_a_of_type_AndroidViewView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
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
  private VerifyDevLockManager.VerifyDevLockObserver jdField_b_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver = new adjo(this);
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private String jdField_c_of_type_JavaLangString;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private String jdField_d_of_type_JavaLangString;
  private TextView e;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList(Arrays.asList(new String[] { "0X800AA33", "0X800AA34", "0X800AA35", "0X800AA36", "0X800AA37" }));
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
        localHashMap.put("K_REDIRECT_TIME", String.valueOf(this.jdField_c_of_type_Int));
      }
      azri.a(BaseApplicationImpl.getApplication()).a((String)localObject, "TGatewayVerifyResult", "V_RET_SUCCESS".equals(paramString1), 0L, 0L, localHashMap, "");
      return;
    }
  }
  
  private void c()
  {
    this.jdField_b_of_type_Boolean = false;
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
        break label190;
      }
    }
    label190:
    for (Object localObject = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface;; localObject = null)
    {
      azqs.a((QQAppInterface)localObject, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800ADDE", "0X800ADDE", 0, 0, "", "", "", "");
      return;
      localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AuthDevVerifyCodeActivity.class);
      break;
    }
  }
  
  private void d()
  {
    this.jdField_b_of_type_Boolean = false;
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
    Object localObject = new GatewayVerify.ReqBody();
    GatewayVerify.ReqBodySelfPhone localReqBodySelfPhone = new GatewayVerify.ReqBodySelfPhone();
    GatewayVerify.ReqBodySelfPhoneGetUrl localReqBodySelfPhoneGetUrl = new GatewayVerify.ReqBodySelfPhoneGetUrl();
    localReqBodySelfPhoneGetUrl.uint32_get_upload_url.set(1);
    try
    {
      i = bdgk.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      QLog.d("NewAuthDevUgFragment", 1, new Object[] { "carrier ：", Integer.valueOf(i) });
      localReqBodySelfPhoneGetUrl.uint32_isp_type.set(i);
      String str = pco.a();
      if ((!bdin.h(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity)) && (!"0.0.0.0".equals(str)))
      {
        localReqBodySelfPhoneGetUrl.str_cell_ip.set(str);
        localReqBodySelfPhone.msg_req_get_url.set(localReqBodySelfPhoneGetUrl);
        ((GatewayVerify.ReqBody)localObject).msg_req_self_phone.set(localReqBodySelfPhone);
        localObject = ((GatewayVerify.ReqBody)localObject).toByteArray();
        i = aqbd.a().a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppInterface(), (byte[])localObject, this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver);
        if (i != 0) {
          break label220;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699257);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
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
      label220:
      QLog.e("NewAuthDevUgFragment", 1, new Object[] { "refreshDevLockSms error , ret : ", Integer.valueOf(i) });
    }
  }
  
  private void f()
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
            break label538;
          }
          i = 1;
          label260:
          localObject2 = ((StringBuilder)localObject2).append(i).append("&isFromOpenSdk=");
          if (!"com.tencent.mobileqq:openSdk".equals(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().getQQProcessName())) {
            break label543;
          }
          i = 1;
          label294:
          ((StringBuilder)localObject2).append(i);
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
        break label559;
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
          label475:
          b();
          if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {}
          for (localObject1 = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface;; localObject1 = null)
          {
            azqs.a((QQAppInterface)localObject1, "dc00898", "", "", "0X800A413", "0X800A413", 0, 0, "", "", "", "");
            return;
            ((StringBuilder)localObject1).append("?");
            break;
            label538:
            i = 0;
            break label260;
            label543:
            i = 0;
            break label294;
          }
        }
        catch (SecurityException localSecurityException)
        {
          break label475;
        }
      }
      label559:
      bool = false;
    }
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
    QLog.d("NewAuthDevUgFragment", 1, "beforeOpenBrowser do finish");
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
                  localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
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
                  paramIntent = getString(2131692219) + ":" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile;
                  this.e.setText(paramIntent);
                  this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131692167));
                  this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
                }
              }
            } while (!bool);
            aqbd.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), true);
            paramIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AuthDevActivity.class);
            paramIntent.putExtra("phone_num", (String)localObject);
            if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) {
              paramIntent.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
            }
            paramIntent.putExtra("auth_dev_open", true);
            startActivity(paramIntent);
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2, getString(2131692161), 0).a();
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
          aqbd.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), null);
        }
      } while (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null);
      this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile = paramIntent;
    } while (TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile));
    paramIntent = getString(2131692219) + ":" + this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile;
    this.e.setText(paramIntent);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131692167));
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_Long > 0L) && (System.currentTimeMillis() - this.jdField_a_of_type_Long > 0L) && (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L)) {}
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {}
        for (localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface;; localQQAppInterface = null) {
          switch (paramView.getId())
          {
          default: 
            return;
          case 2131368711: 
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
            azqs.a(localQQAppInterface, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800ADDA", "0X800ADDA", 0, 0, "", "", "", "");
            return;
          }
        }
        azqs.a(localQQAppInterface, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800AA34", "0X800AA34", AuthDevUgActivity.a(), 0, "", "", "", "");
        azqs.a(localQQAppInterface, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800ADDD", "0X800ADDD", 0, 0, "", "", "", "");
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
            aqaz.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, aqaz.jdField_a_of_type_Int);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("NewAuthDevUgFragment", 2, "mainaccount enter webview mUin=" + this.jdField_a_of_type_JavaLangString);
          }
          if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (QLog.isColorLevel())) {
            QLog.d("NewAuthDevUgFragment", 2, "mUin is empty.");
          }
          aqaz.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_JavaLangString, aqaz.jdField_a_of_type_Int);
          return;
        }
        aqaz.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface, aqaz.jdField_a_of_type_Int);
        return;
      } while ((this.jdField_b_of_type_Long > 0L) && (System.currentTimeMillis() - this.jdField_b_of_type_Long > 0L) && (System.currentTimeMillis() - this.jdField_b_of_type_Long < 3000L));
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      azqs.a(localQQAppInterface, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800AA36", "0X800AA36", AuthDevUgActivity.a(), 0, "", "", "", "");
      azqs.a(localQQAppInterface, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800ADDC", "0X800ADDC", 0, 0, "", "", "", "");
      f();
      return;
    } while (this.jdField_b_of_type_Boolean);
    boolean bool3 = this.jdField_a_of_type_Boolean;
    boolean bool1;
    boolean bool2;
    if (this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null)
    {
      bool1 = true;
      if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null) || (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile))) {
        break label742;
      }
      bool2 = true;
      label595:
      QLog.d("NewAuthDevUgFragment", 1, new Object[] { "onCLick Verify btn, from login: ", Boolean.valueOf(bool3), "mDev is null ? ", Boolean.valueOf(bool1), " , mobile is null ? ", Boolean.valueOf(bool2) });
      if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null) || (!this.jdField_a_of_type_Boolean)) {
        break label754;
      }
      azqs.a(localQQAppInterface, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800AA35", "0X800AA35", AuthDevUgActivity.a(), 0, "", "", "", "");
      if (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile)) {
        break label747;
      }
      f();
    }
    for (;;)
    {
      azqs.a(localQQAppInterface, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800ADDB", "0X800ADDB", 0, 0, "", "", "", "");
      return;
      bool1 = false;
      break;
      label742:
      bool2 = false;
      break label595;
      label747:
      e();
      continue;
      label754:
      if ((this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile)))
      {
        azqs.b(null, "CliOper", "", "", "My_eq_lock", "My_eq_lock_open", 0, 0, "1", "", "", "");
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, AuthDevVerifyCodeActivity.class);
        paramView.putExtra("phone_num", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
        paramView.putExtra("country_code", this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
        startActivityForResult(paramView, 1001);
      }
      else
      {
        aqaz.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface, aqaz.jdField_a_of_type_Int, 1003, null);
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
      paramViewGroup = paramLayoutInflater.inflate(2131560921, paramViewGroup, false);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131379082));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131378916));
      this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131368711);
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131378696));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131379012));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramViewGroup.findViewById(2131376009));
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131372368));
      paramViewGroup.findViewById(2131368711).setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      paramLayoutInflater = getArguments();
      if (paramLayoutInflater != null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
      return paramViewGroup;
    }
    paramBundle = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramBundle.topMargin = (aepi.a(6.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources()) + ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity));
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
          this.e = ((TextView)paramViewGroup.findViewById(2131378919));
          this.e.setText(getString(2131699255, new Object[] { this.jdField_a_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile }));
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
        if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))
        {
          paramLayoutInflater = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface;
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().setFormat(-3);
          if (this.jdField_a_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setTheme(2131755553);
          }
          if (this.jdField_a_of_type_Boolean)
          {
            paramBundle = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHandler(LoginActivity.class);
            if (paramBundle != null) {
              paramBundle.sendEmptyMessage(20140107);
            }
            paramBundle = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHandler(SubLoginActivity.class);
            if (paramBundle != null) {
              paramBundle.sendEmptyMessage(20140107);
            }
            paramBundle = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHandler(AddAccountActivity.class);
            if (paramBundle != null) {
              paramBundle.sendEmptyMessage(20140107);
            }
          }
          this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver = new adjq(this.jdField_b_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver);
          this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver.setSeq(this.jdField_a_of_type_Int);
          this.jdField_a_of_type_Adjp = new adjp(this);
          azqs.a(paramLayoutInflater, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800AA33", "0X800AA33", AuthDevUgActivity.a(), 0, "", "", "", "");
          azqs.a(paramLayoutInflater, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800ADD9", "0X800ADD9", 0, 0, "", "", "", "");
          if (AuthDevUgActivity.a() == 1) {
            azqs.a(paramLayoutInflater, "dc00898", "", this.jdField_a_of_type_JavaLangString, "0X800AC0B", "0X800AC0B", AuthDevUgActivity.a(), 0, "", "", "", "");
          }
          return paramViewGroup;
        }
      }
      catch (Exception paramLayoutInflater)
      {
        QLog.e("NewAuthDevUgFragment", 1, new Object[] { "get devInfo error : ", paramLayoutInflater.getMessage() });
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
        return paramViewGroup;
      }
      paramLayoutInflater = null;
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.jdField_a_of_type_Adjp != null) {
      adjp.a(this.jdField_a_of_type_Adjp).clear();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131699253));
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NewAuthDevUgFragment
 * JD-Core Version:    0.7.0.1
 */