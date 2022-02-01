package com.tencent.livesdk.servicefactory.builder.apm;

import android.os.Bundle;
import android.util.Log;
import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.falco.base.libapi.apm.APMConfiguration.Builder;
import com.tencent.falco.base.libapi.apm.APMInterface;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.livesdk.servicefactory.ServiceAccessor;
import com.tencent.livesdk.servicefactory.builder.BaseServiceBuilder;
import java.lang.reflect.Constructor;

public class APMServiceBuilder
  implements BaseServiceBuilder
{
  public ServiceBaseInterface build(ServiceAccessor paramServiceAccessor)
  {
    try
    {
      localObject = (APMInterface)Class.forName("com.tencent.falco.base.apm.APMComponent").getConstructor(new Class[0]).newInstance(new Object[0]);
      Bundle localBundle = new Bundle();
      localBundle.putString("appId", "de14684b-605");
      localBundle.putString("userId", "liveSdkTest");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((AppGeneralInfoService)paramServiceAccessor.getService(AppGeneralInfoService.class)).getVersionName());
      localStringBuilder.append("_livesdktest");
      localBundle.putString("appVersionName", localStringBuilder.toString());
      localBundle.putString("symbolId", "");
      ((APMInterface)localObject).init(new APMConfiguration.Builder().extra(localBundle).build());
      return localObject;
    }
    catch (Exception paramServiceAccessor)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Exception ");
      ((StringBuilder)localObject).append(paramServiceAccessor.toString());
      Log.e("APMServiceBuilder", ((StringBuilder)localObject).toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.apm.APMServiceBuilder
 * JD-Core Version:    0.7.0.1
 */