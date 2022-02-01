package com.tencent.mobileqq.ark.api.module;

import android.text.TextUtils;
import java.util.HashMap;

class ArkAppQQModule$25
  implements ArkQQAPIIPCModule.LoginHandler.OnLoginEventHandler
{
  ArkAppQQModule$25(ArkAppQQModule paramArkAppQQModule, long paramLong) {}
  
  public void a(String paramString1, long paramLong, String paramString2, String paramString3)
  {
    if ((paramLong > 0L) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      StringBuilder localStringBuilder = new StringBuilder(ArkAppQQModule.p(this.b));
      localStringBuilder.append("_");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString1);
      paramString1 = localStringBuilder.toString();
      ArkAppQQModule.q(this.b).put(paramString1, paramString2);
      ArkAppQQModule.r(this.b).put(paramString1, paramString3);
      ArkAppQQModule.t(this.b).put(ArkAppQQModule.s(this.b), String.valueOf(paramLong));
    }
    ArkAppQQModule.a(this.b, paramString2, paramString3, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppQQModule.25
 * JD-Core Version:    0.7.0.1
 */