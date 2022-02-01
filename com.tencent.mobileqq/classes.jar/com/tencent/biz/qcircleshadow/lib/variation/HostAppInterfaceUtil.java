package com.tencent.biz.qcircleshadow.lib.variation;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.api.IMemoryManagerApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.QQTextToSpeechHelper;
import mqq.app.MobileQQ;

public class HostAppInterfaceUtil
{
  public static float getAvailClassSize()
  {
    return (float)((IMemoryManagerApi)QRoute.api(IMemoryManagerApi.class)).getAvailClassSize();
  }
  
  public static SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return MobileQQ.sMobileQQ.getSharedPreferences(paramString, paramInt);
  }
  
  public static void speak(String paramString)
  {
    QQTextToSpeechHelper.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.variation.HostAppInterfaceUtil
 * JD-Core Version:    0.7.0.1
 */