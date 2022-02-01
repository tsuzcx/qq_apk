package com.tencent.mobileqq.app;

import android.content.Context;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_0xd55.RspBody;

public class ForwardMiniAppThirdPartyHelper
{
  public static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      QLog.e("ForwardMiniAppThirdPartyHelper", 1, "Data is null");
      return "";
    }
    Object localObject = new oidb_0xd55.RspBody();
    try
    {
      ((oidb_0xd55.RspBody)localObject).mergeFrom(paramArrayOfByte);
      if (((oidb_0xd55.RspBody)localObject).wording.has())
      {
        paramArrayOfByte = ((oidb_0xd55.RspBody)localObject).wording.get();
        return paramArrayOfByte;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("oidb_0xd55_RspBody merge fail:");
      ((StringBuilder)localObject).append(paramArrayOfByte.getMessage());
      QLog.e("ForwardMiniAppThirdPartyHelper", 1, ((StringBuilder)localObject).toString());
    }
    return "";
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).launchMiniAppById(paramContext, paramString1, paramString2, null, paramString3, null, 1069, null);
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("ForwardMiniAppThirdPartyHelper", 1, paramContext.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ForwardMiniAppThirdPartyHelper
 * JD-Core Version:    0.7.0.1
 */