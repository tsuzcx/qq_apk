package com.tencent.ad.tangram.device;

import android.content.Context;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.reflect.Method;

final class i
{
  private static final String HARMONY_OS = "harmony";
  private static final String TAG = "AdHarmonyUtil";
  
  public static String getHarmonyOsVersion()
  {
    Object localObject1 = "";
    try
    {
      Class localClass = Class.forName("ohos.system.version.SystemVersion");
      localObject2 = localObject1;
      if (localClass == null) {
        return localObject2;
      }
      localObject2 = (String)localClass.getMethod("getVersion", new Class[0]).invoke(null, new Object[0]);
      localObject1 = localObject2;
      try
      {
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = "0.0.0";
        }
        return localObject1;
      }
      catch (Throwable localThrowable1)
      {
        localObject1 = localObject2;
      }
      localObject2 = new StringBuilder();
    }
    catch (Throwable localThrowable2) {}
    ((StringBuilder)localObject2).append("getHarmonyOsVersion error: ");
    ((StringBuilder)localObject2).append(localThrowable2.getMessage());
    AdLog.e("AdHarmonyUtil", ((StringBuilder)localObject2).toString());
    Object localObject2 = localObject1;
    return localObject2;
  }
  
  public static int getHarmonyPureMode(Context paramContext)
  {
    if (paramContext == null) {
      return -1;
    }
    try
    {
      int i = Settings.Secure.getInt(paramContext.getContentResolver(), "pure_mode_state", -1);
      return i;
    }
    catch (Throwable paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getHarmonyPureMode error: ");
      localStringBuilder.append(paramContext.getMessage());
      AdLog.e("AdHarmonyUtil", localStringBuilder.toString());
    }
    return -1;
  }
  
  public static boolean isHarmonyOs()
  {
    try
    {
      Class localClass = Class.forName("com.huawei.system.BuildEx");
      boolean bool = "harmony".equals(localClass.getMethod("getOsBrand", new Class[0]).invoke(localClass, new Object[0]));
      return bool;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isHarmonyOs error: ");
      localStringBuilder.append(localThrowable.getMessage());
      AdLog.e("AdHarmonyUtil", localStringBuilder.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.device.i
 * JD-Core Version:    0.7.0.1
 */