package com.tencent.mobileqq.ark.API;

import android.text.TextUtils;
import com.tencent.ark.open.ArkAppMgr;

public class ArkSecureUtil
{
  public static void a(String paramString1, String paramString2, String paramString3, ArkAppModuleReg.CheckShareUrlResult paramCheckShareUrlResult)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString3)) && (ArkCommonUtil.a() != null)) {
      ArkAppMgr.getInstance().getAppPathByNameTimeout(3000L, paramString1, paramString2, "0.0.0.1", null, new ArkSecureUtil.1(paramString1, paramString3, paramCheckShareUrlResult));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkSecureUtil
 * JD-Core Version:    0.7.0.1
 */