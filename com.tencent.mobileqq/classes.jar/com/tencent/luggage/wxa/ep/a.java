package com.tencent.luggage.wxa.ep;

import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import android.text.TextUtils;
import com.tencent.luggage.wxa.hd.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.util.Random;

public class a
{
  public static String a()
  {
    Object localObject2 = c.a(false);
    boolean bool = TextUtils.isEmpty((CharSequence)localObject2);
    Object localObject1 = "A";
    if (!bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("A");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("123456789ABCDEF");
      localObject1 = ((StringBuilder)localObject1).toString().substring(0, 15);
      o.d("Luggage.DeviceId", "generateDeviceId by IMEI return %s", new Object[] { localObject1 });
      return localObject1;
    }
    localObject2 = b();
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      o.d("Luggage.DeviceId", "generateDeviceId by IMEI return %s", new Object[] { localObject2 });
      return localObject2;
    }
    localObject2 = new Random();
    ((Random)localObject2).setSeed(System.currentTimeMillis());
    int i = 0;
    while (i < 15)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append((char)(((Random)localObject2).nextInt(25) + 65));
      localObject1 = localStringBuilder.toString();
      i += 1;
    }
    o.d("Luggage.DeviceId", "generateDeviceId by random return %s", new Object[] { localObject1 });
    return localObject1;
  }
  
  private static String b()
  {
    try
    {
      int i = Build.VERSION.SDK_INT;
      if (i >= 26)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(Settings.Secure.getLong(r.a().getContentResolver(), "android_id"));
        localObject = ((StringBuilder)localObject).toString();
        return localObject;
      }
      return "";
    }
    catch (Settings.SettingNotFoundException localSettingNotFoundException)
    {
      label51:
      break label51;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ep.a
 * JD-Core Version:    0.7.0.1
 */