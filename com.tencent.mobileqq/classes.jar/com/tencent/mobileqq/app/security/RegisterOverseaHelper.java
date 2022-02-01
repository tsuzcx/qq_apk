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
  private static volatile RegisterOverseaHelper b;
  private String a = "CN";
  
  public static RegisterOverseaHelper a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new RegisterOverseaHelper();
        }
      }
      finally {}
    }
    return b;
  }
  
  private void a(String paramString, RegisterNewBaseActivity paramRegisterNewBaseActivity)
  {
    Object localObject = paramString;
    if ((!TextUtils.isEmpty(paramString)) && (paramRegisterNewBaseActivity != null))
    {
      paramString = (String)localObject;
      if (!((String)localObject).startsWith("http://"))
      {
        paramString = (String)localObject;
        if (!((String)localObject).startsWith("https://"))
        {
          paramString = new StringBuilder();
          paramString.append("https://");
          paramString.append((String)localObject);
          paramString = paramString.toString();
        }
      }
      ReportController.a(null, "dc00898", "", "", "0X800B8B1", "0X800B8B1", 0, 0, "", "", "", "");
      localObject = new Intent();
      ((Intent)localObject).putExtra("is_register_uin", true);
      ((Intent)localObject).putExtra("isShowAd", false);
      ((Intent)localObject).putExtra("hide_more_button", true);
      ((Intent)localObject).putExtra("hide_operation_bar", true);
      ((Intent)localObject).putExtra("register_uin_msg", 111);
      ((Intent)localObject).putExtra("keyFrom", paramRegisterNewBaseActivity.getClass().getName());
      ((Intent)localObject).putExtra("url", paramString);
      LoginUtils.a(paramRegisterNewBaseActivity, (Intent)localObject, "/base/browser");
      return;
    }
    QLog.e("RegisterOverseaHelper", 1, "jumpWithCaptchaUrl error: params wrong");
  }
  
  private boolean b(AppRuntime paramAppRuntime, RegisterNewBaseActivity paramRegisterNewBaseActivity, byte[] paramArrayOfByte)
  {
    return (paramAppRuntime == null) || (paramRegisterNewBaseActivity == null) || (paramRegisterNewBaseActivity.handler == null) || (paramArrayOfByte == null);
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
    this.a = paramString;
  }
  
  public void a(AppRuntime paramAppRuntime, RegisterNewBaseActivity paramRegisterNewBaseActivity, byte[] paramArrayOfByte)
  {
    if (b(paramAppRuntime, paramRegisterNewBaseActivity, paramArrayOfByte))
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
      paramRegisterNewBaseActivity.handler.post(new RegisterOverseaHelper.1(this, paramAppRuntime, paramRegisterNewBaseActivity));
      return;
    }
    catch (UnsupportedEncodingException paramAppRuntime)
    {
      paramRegisterNewBaseActivity = new StringBuilder();
      paramRegisterNewBaseActivity.append("handleIframe error: captchaURL encode exception ");
      paramRegisterNewBaseActivity.append(paramAppRuntime);
      QLog.e("RegisterOverseaHelper", 1, paramRegisterNewBaseActivity.toString());
    }
  }
  
  public String b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.security.RegisterOverseaHelper
 * JD-Core Version:    0.7.0.1
 */