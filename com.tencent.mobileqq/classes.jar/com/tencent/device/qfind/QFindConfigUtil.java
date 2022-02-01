package com.tencent.device.qfind;

import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONObject;

public class QFindConfigUtil
{
  public static QFindConfig a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject = null;
    JSONObject localJSONObject = null;
    if (!bool) {}
    for (;;)
    {
      try
      {
        localObject = new QFindConfig();
        try
        {
          paramString = new JSONObject(paramString);
          bool = paramString.has("priority");
          int j = 0;
          if (!bool) {
            break label272;
          }
          i = paramString.getInt("priority");
          ((QFindConfig)localObject).a = i;
          if (!paramString.has("assist_active")) {
            break label277;
          }
          i = paramString.getInt("assist_active");
          ((QFindConfig)localObject).b = i;
          bool = paramString.has("assist_params");
          if (bool)
          {
            localJSONObject = paramString.getJSONObject("assist_params");
            if (!localJSONObject.has("scan_duration")) {
              break label282;
            }
            i = localJSONObject.getInt("scan_duration") * 1000;
            ((QFindConfig)localObject).d = i;
            if (!localJSONObject.has("scan_interval")) {
              break label287;
            }
            i = localJSONObject.getInt("scan_interval") * 1000;
            ((QFindConfig)localObject).c = i;
          }
          if (paramString.has("owner_params"))
          {
            paramString = paramString.getJSONObject("owner_params");
            if (!paramString.has("scan_duration")) {
              break label292;
            }
            i = paramString.getInt("scan_duration") * 1000;
            ((QFindConfig)localObject).f = i;
            i = j;
            if (paramString.has("scan_interval")) {
              i = paramString.getInt("scan_interval") * 1000;
            }
            ((QFindConfig)localObject).e = i;
          }
          return localObject;
        }
        catch (Throwable localThrowable2)
        {
          paramString = (String)localObject;
          localObject = localThrowable2;
        }
        localThrowable1.printStackTrace();
      }
      catch (Throwable localThrowable1)
      {
        paramString = localThrowable2;
      }
      String str = paramString;
      return str;
      label272:
      int i = 0;
      continue;
      label277:
      i = 0;
      continue;
      label282:
      i = 0;
      continue;
      label287:
      i = 0;
      continue;
      label292:
      i = 0;
    }
  }
  
  public static boolean a()
  {
    if (Build.VERSION.SDK_INT >= 18) {
      try
      {
        boolean bool = BaseApplication.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        return bool;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.qfind.QFindConfigUtil
 * JD-Core Version:    0.7.0.1
 */