package com.tencent.mobileqq.app.security;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.mobileqq.loginregister.LoginUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import mqq.app.AppRuntime;
import tencent.im.wireless_reg.CaptchaVerifyInfo.captchaVerifyInfo;

public class RegisterOverseaHelper
{
  private static volatile RegisterOverseaHelper jdField_a_of_type_ComTencentMobileqqAppSecurityRegisterOverseaHelper;
  private String jdField_a_of_type_JavaLangString = "CN";
  
  public static RegisterOverseaHelper a()
  {
    if (jdField_a_of_type_ComTencentMobileqqAppSecurityRegisterOverseaHelper == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqAppSecurityRegisterOverseaHelper == null) {
        jdField_a_of_type_ComTencentMobileqqAppSecurityRegisterOverseaHelper = new RegisterOverseaHelper();
      }
      return jdField_a_of_type_ComTencentMobileqqAppSecurityRegisterOverseaHelper;
    }
    finally {}
  }
  
  private void a(String paramString, RegisterNewBaseActivity paramRegisterNewBaseActivity)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramRegisterNewBaseActivity == null))
    {
      QLog.e("RegisterOverseaHelper", 1, "jumpWithCaptchaUrl error: params wrong");
      return;
    }
    String str = paramString;
    if (!paramString.startsWith("http://"))
    {
      str = paramString;
      if (!paramString.startsWith("https://")) {
        str = "https://" + paramString;
      }
    }
    ReportController.a(null, "dc00898", "", "", "0X800B8B1", "0X800B8B1", 0, 0, "", "", "", "");
    paramString = new Intent();
    paramString.putExtra("is_register_uin", true);
    paramString.putExtra("isShowAd", false);
    paramString.putExtra("hide_more_button", true);
    paramString.putExtra("hide_operation_bar", true);
    paramString.putExtra("register_uin_msg", 111);
    paramString.putExtra("keyFrom", paramRegisterNewBaseActivity.getClass().getName());
    paramString.putExtra("url", str);
    LoginUtils.a(paramRegisterNewBaseActivity, paramString, "/base/browser");
  }
  
  private boolean a(AppRuntime paramAppRuntime, RegisterNewBaseActivity paramRegisterNewBaseActivity, byte[] paramArrayOfByte)
  {
    return (paramAppRuntime == null) || (paramRegisterNewBaseActivity == null) || (paramRegisterNewBaseActivity.handler == null) || (paramArrayOfByte == null);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public HashMap<String, Object> a(Bundle paramBundle)
  {
    if (paramBundle == null)
    {
      QLog.e("RegisterOverseaHelper", 1, "getRegExtraMap error: data == null");
      return null;
    }
    Object localObject = paramBundle.getString("ticket", "");
    String str = paramBundle.getString("randstr", "");
    paramBundle = new CaptchaVerifyInfo.captchaVerifyInfo();
    paramBundle.bytes_ticket.set(ByteStringMicro.copyFromUtf8((String)localObject));
    paramBundle.str_randstr.set(str);
    paramBundle.setHasFlag(true);
    localObject = new HashMap();
    ((HashMap)localObject).put("captcha_verify_info", paramBundle.toByteArray());
    return localObject;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(AppRuntime paramAppRuntime, RegisterNewBaseActivity paramRegisterNewBaseActivity, byte[] paramArrayOfByte)
  {
    if (a(paramAppRuntime, paramRegisterNewBaseActivity, paramArrayOfByte))
    {
      QLog.e("RegisterOverseaHelper", 1, "handleIframe error: params invalid");
      return;
    }
    try
    {
      paramAppRuntime = new String(paramArrayOfByte, "utf-8");
      if (TextUtils.isEmpty(paramAppRuntime))
      {
        QLog.e("RegisterOverseaHelper", 1, "handleIframe error: captcha url is empty");
        return;
      }
    }
    catch (UnsupportedEncodingException paramAppRuntime)
    {
      QLog.e("RegisterOverseaHelper", 1, "handleIframe error: captchaURL encode exception " + paramAppRuntime);
      return;
    }
    paramRegisterNewBaseActivity.handler.post(new RegisterOverseaHelper.1(this, paramAppRuntime, paramRegisterNewBaseActivity));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.security.RegisterOverseaHelper
 * JD-Core Version:    0.7.0.1
 */