package com.tencent.mobileqq.app.utils;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.observer.LoginVerifyObserver;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_0x87a.RspBody;

final class IdentificationUtils$1
  extends LoginVerifyObserver
{
  IdentificationUtils$1(String paramString1, String paramString2, Context paramContext, IdentificationUtils.ErrorRunnable paramErrorRunnable) {}
  
  public void onFailedResponse(String paramString1, int paramInt, String paramString2)
  {
    QLog.e("IdentificationUtils", 1, new Object[] { "cmd : ", paramString1, " code : ", Integer.valueOf(paramInt), " message : ", paramString2 });
    if (paramInt == 89) {
      paramString2 = this.c.getString(2131896899);
    }
    this.d.a(paramString2);
  }
  
  public void sendSmsCodeSuccess(oidb_0x87a.RspBody paramRspBody)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("keyFrom", "f_SetFaceData");
    String str = this.a;
    paramRspBody = str;
    if (str == null) {
      paramRspBody = "";
    }
    localIntent.putExtra("phone_num", paramRspBody);
    str = this.b;
    paramRspBody = str;
    if (str == null) {
      paramRspBody = "";
    }
    localIntent.putExtra("country_code", paramRspBody);
    RouteUtils.a(this.c, localIntent, "/base/login/authDevVerifyCode", 11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.IdentificationUtils.1
 * JD-Core Version:    0.7.0.1
 */