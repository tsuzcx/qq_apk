package com.tencent.mobileqq.app.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.identification.FaceConf;
import com.tencent.mobileqq.loginregister.LoginStaticField;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqconnectface.IIdentificationApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.servlet.LoginVerifyServlet;
import com.tencent.qphone.base.util.QLog;
import face.qqlogin.FaceSecureCheck.SecureCheckResponse;
import mqq.app.AppRuntime;
import tencent.im.oidb.oidb_0x5e1.RspBody;
import tencent.im.oidb.oidb_0x5e1.UdcUinData;

public class IdentificationUtils
{
  protected static int a;
  
  protected static void a(Activity paramActivity, FaceSecureCheck.SecureCheckResponse paramSecureCheckResponse)
  {
    Intent localIntent = new Intent();
    FaceConf localFaceConf = new FaceConf();
    localFaceConf.setPlatformAppId(101810106);
    localFaceConf.setAppId(101810106);
    localFaceConf.setOpenId(paramSecureCheckResponse.str_openid.get());
    localFaceConf.setKey(paramSecureCheckResponse.str_tmpkey.get());
    localFaceConf.setMethod("setFaceData");
    localFaceConf.setServiceType(2);
    localIntent.putExtra("faceConf", localFaceConf);
    RouteUtils.a(paramActivity, localIntent, "/base/connectface/legacy", 21);
  }
  
  protected static void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("keyFrom", "f_SetFaceData");
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localIntent.putExtra("phone_num", str);
    RouteUtils.a(paramContext, localIntent, "/base/login/authDevVerifyCode", 11);
  }
  
  public static void a(AppRuntime paramAppRuntime, Activity paramActivity, String paramString1, String paramString2, boolean paramBoolean, oidb_0x5e1.RspBody paramRspBody, FaceSecureCheck.SecureCheckResponse paramSecureCheckResponse, IdentificationUtils.ErrorRunnable paramErrorRunnable)
  {
    if (paramBoolean)
    {
      QLog.e("IdentificationUtils", 1, "entrance click, has unverified phone");
      paramErrorRunnable.a(paramActivity.getString(2131896900));
      a = 7;
      return;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      QLog.e("IdentificationUtils", 1, "entrance click, phoneNum is null");
      paramErrorRunnable.a(paramActivity.getString(2131896899));
      a = 1;
      return;
    }
    if ((paramRspBody != null) && (paramRspBody.rpt_msg_uin_data != null) && (paramRspBody.rpt_msg_uin_data.size() != 0))
    {
      if (((oidb_0x5e1.UdcUinData)paramRspBody.rpt_msg_uin_data.get(0)).user_login_guard_face.get() == 0)
      {
        if ((paramSecureCheckResponse != null) && (paramSecureCheckResponse.bool_sec_pass.get()))
        {
          a(paramActivity, paramSecureCheckResponse);
          a = 5;
          return;
        }
        a(paramAppRuntime, paramActivity, paramString1, paramString2, paramErrorRunnable);
        return;
      }
      QPublicFragmentActivity.startForResult(paramActivity, ((IIdentificationApi)QRoute.api(IIdentificationApi.class)).getDeleteFaceFragment(), 12);
      a = 6;
      return;
    }
    QLog.e("IdentificationUtils", 1, "entrance click, status error");
    paramErrorRunnable.a(paramActivity.getString(2131896895));
    a = 2;
  }
  
  protected static void a(AppRuntime paramAppRuntime, Context paramContext, String paramString1, String paramString2, IdentificationUtils.ErrorRunnable paramErrorRunnable)
  {
    if (System.currentTimeMillis() - LoginStaticField.b >= 60000L)
    {
      LoginVerifyServlet.a(paramAppRuntime, new IdentificationUtils.1(paramString1, paramString2, paramContext, paramErrorRunnable));
      a = 3;
      return;
    }
    a(paramContext, paramString1);
    a = 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.IdentificationUtils
 * JD-Core Version:    0.7.0.1
 */