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
      APMInterface localAPMInterface = (APMInterface)Class.forName("com.tencent.falco.base.apm.APMComponent").getConstructor(new Class[0]).newInstance(new Object[0]);
      Bundle localBundle = new Bundle();
      localBundle.putString("appId", "de14684b-605");
      localBundle.putString("userId", "liveSdkTest");
      localBundle.putString("appVersionName", ((AppGeneralInfoService)paramServiceAccessor.getService(AppGeneralInfoService.class)).getVersionName() + "_livesdktest");
      localBundle.putString("symbolId", "");
      localAPMInterface.init(new APMConfiguration.Builder().extra(localBundle).build());
      return localAPMInterface;
    }
    catch (Exception paramServiceAccessor)
    {
      Log.e("APMServiceBuilder", "Exception " + paramServiceAccessor.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.servicefactory.builder.apm.APMServiceBuilder
 * JD-Core Version:    0.7.0.1
 */