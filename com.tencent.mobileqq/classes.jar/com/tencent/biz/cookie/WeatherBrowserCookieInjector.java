package com.tencent.biz.cookie;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.mobileqq.webview.cookie.IBrowserCookieInjector;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class WeatherBrowserCookieInjector
  implements IBrowserCookieInjector
{
  public List<String> a(String paramString)
  {
    if ("https://weather.mp.qq.com/".equals(paramString))
    {
      paramString = ((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).getGdtDeviceInfoBase64();
      if (paramString != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WeatherBrowserCookieInjector", 2, "cookie gdt_device_info for weather 2.0 was added");
        }
        paramString = SwiftBrowserCookieMonster.a("gdt_device_info", paramString, "weather.mp.qq.com", false);
        ArrayList localArrayList = new ArrayList(1);
        localArrayList.add(paramString);
        return localArrayList;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.cookie.WeatherBrowserCookieInjector
 * JD-Core Version:    0.7.0.1
 */