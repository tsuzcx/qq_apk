package com.tencent.av.mediacodec;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import lim;
import lqu;
import lqw;
import lra;

@SuppressLint({"NewApi"})
public class DeviceCheck
  implements Runnable
{
  public static boolean a()
  {
    if (Build.VERSION.SDK_INT < 19) {}
    do
    {
      return false;
      if ((Build.MANUFACTURER.equalsIgnoreCase("OPPO")) && (Build.MODEL.equalsIgnoreCase("N5207")) && (Build.PRODUCT.equalsIgnoreCase("N5207"))) {
        return f();
      }
      if ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.MODEL.equalsIgnoreCase("GT-I9500"))) {
        return f();
      }
      if ((Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) && (Build.MODEL.equalsIgnoreCase("MI NOTE LTE")) && (Build.PRODUCT.equalsIgnoreCase("virgo"))) {
        return f();
      }
      if ((Build.MANUFACTURER.equalsIgnoreCase("asus")) && (Build.MODEL.equalsIgnoreCase("ASUS_Z00ADA")) && (Build.PRODUCT.equalsIgnoreCase("CN_Z00A"))) {
        return f();
      }
    } while ((!Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) || (!Build.MODEL.equalsIgnoreCase("MI 4W")) || (!Build.PRODUCT.equalsIgnoreCase("cancro_wc_lte")));
    return f();
  }
  
  static boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean b()
  {
    boolean bool2 = false;
    boolean bool1;
    if ((Build.MANUFACTURER.equalsIgnoreCase("LGE")) && (Build.MODEL.equalsIgnoreCase("Nexus 4")) && (Build.PRODUCT.equalsIgnoreCase("occam")) && (Build.VERSION.SDK_INT >= 21)) {
      bool1 = e();
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            if ((Build.MANUFACTURER.equalsIgnoreCase("LGE")) && (Build.MODEL.equalsIgnoreCase("Nexus 5")) && (Build.PRODUCT.equalsIgnoreCase("hammerhead"))) {
              return e();
            }
            if ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.MODEL.equalsIgnoreCase("GT-I9500")) && (Build.VERSION.SDK_INT > 18)) {
              return e();
            }
            if ((!Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) || (!Build.MODEL.equalsIgnoreCase("MI 3"))) {
              break;
            }
            bool1 = bool2;
          } while (Build.PRODUCT.equalsIgnoreCase("pisces"));
          if ((Build.MANUFACTURER.equalsIgnoreCase("LGE")) && (Build.MODEL.equalsIgnoreCase("LG-D802"))) {
            return e();
          }
          if ((Build.MANUFACTURER.equalsIgnoreCase("Meizu")) && (Build.MODEL.equalsIgnoreCase("MX4 Pro"))) {
            return e();
          }
          if ((Build.MANUFACTURER.equalsIgnoreCase("Meizu")) && (Build.MODEL.equalsIgnoreCase("M353")) && (Build.PRODUCT.equalsIgnoreCase("meizu_mx3"))) {
            return e();
          }
          if ((Build.MANUFACTURER.equalsIgnoreCase("Meizu")) && (Build.MODEL.equalsIgnoreCase("m1 note")) && (Build.PRODUCT.equalsIgnoreCase("m1 note"))) {
            return e();
          }
          if ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.MODEL.equalsIgnoreCase("SM-N9005")) && (Build.VERSION.SDK_INT > 18)) {
            return true;
          }
          if ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && (Build.MODEL.equalsIgnoreCase("SM-N9006V")) && (Build.VERSION.SDK_INT > 18)) {
            return e();
          }
          if ((Build.MANUFACTURER.equalsIgnoreCase("smartisan")) && (Build.MODEL.equalsIgnoreCase("SM705")) && (Build.PRODUCT.equalsIgnoreCase("msm8974sfo_lte"))) {
            return e();
          }
          if ((Build.MANUFACTURER.equalsIgnoreCase("OPPO")) && (Build.MODEL.equalsIgnoreCase("N5207")) && (Build.PRODUCT.equalsIgnoreCase("N5207"))) {
            return e();
          }
          if ((Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) && (Build.MODEL.equalsIgnoreCase("HM 1SC")) && (Build.PRODUCT.equalsIgnoreCase("armani"))) {
            return e();
          }
          bool1 = bool2;
        } while (!Build.MANUFACTURER.equalsIgnoreCase("Xiaomi"));
        bool1 = bool2;
      } while (!Build.MODEL.equalsIgnoreCase("HM NOTE 1TD"));
      bool1 = bool2;
    } while (!Build.PRODUCT.equalsIgnoreCase("Icsh92_wet_tdd"));
    return false;
  }
  
  static boolean b(int paramInt)
  {
    switch (paramInt)
    {
    case 20: 
    default: 
      return false;
    }
    return true;
  }
  
  @SuppressLint({"NewApi"})
  @TargetApi(16)
  public static boolean c()
  {
    List localList = lqu.a(lqu.b);
    int i = 0;
    for (;;)
    {
      MediaCodecInfo.CodecCapabilities localCodecCapabilities;
      if (i < localList.size())
      {
        localCodecCapabilities = lqu.a((MediaCodecInfo)localList.get(i), lqu.b);
        if ((localCodecCapabilities != null) && (localCodecCapabilities.colorFormats != null)) {}
      }
      else
      {
        return false;
      }
      int j = 0;
      while (j < localCodecCapabilities.colorFormats.length)
      {
        if (a(localCodecCapabilities.colorFormats[j])) {
          return true;
        }
        j += 1;
      }
      i += 1;
    }
  }
  
  @SuppressLint({"NewApi"})
  @TargetApi(16)
  public static boolean d()
  {
    List localList = lqu.b(lqu.b);
    int i = 0;
    for (;;)
    {
      MediaCodecInfo.CodecCapabilities localCodecCapabilities;
      if (i < localList.size())
      {
        localCodecCapabilities = lqu.a((MediaCodecInfo)localList.get(i), lqu.b);
        if (localCodecCapabilities != null) {}
      }
      else
      {
        return false;
      }
      int j = 0;
      while (j < localCodecCapabilities.colorFormats.length)
      {
        if (b(localCodecCapabilities.colorFormats[j])) {
          return true;
        }
        j += 1;
      }
      i += 1;
    }
  }
  
  @SuppressLint({"NewApi"})
  @TargetApi(16)
  public static boolean e()
  {
    boolean bool2 = false;
    List localList = lqu.a(lqu.a);
    int i = 0;
    boolean bool1 = bool2;
    MediaCodecInfo.CodecCapabilities localCodecCapabilities;
    if (i < localList.size())
    {
      localCodecCapabilities = lqu.a((MediaCodecInfo)localList.get(i), lqu.a);
      if ((localCodecCapabilities != null) && (localCodecCapabilities.colorFormats != null)) {}
    }
    for (;;)
    {
      i += 1;
      break;
      int j = 0;
      while (j < localCodecCapabilities.colorFormats.length)
      {
        if (a(localCodecCapabilities.colorFormats[j]))
        {
          bool1 = true;
          return bool1;
        }
        j += 1;
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  @TargetApi(16)
  public static boolean f()
  {
    boolean bool2 = false;
    List localList = lqu.b(lqu.a);
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      MediaCodecInfo.CodecCapabilities localCodecCapabilities;
      int j;
      if (i < localList.size())
      {
        localCodecCapabilities = lqu.a((MediaCodecInfo)localList.get(i), lqu.a);
        if (localCodecCapabilities != null) {
          j = 0;
        }
      }
      else
      {
        while (j < localCodecCapabilities.colorFormats.length)
        {
          if (b(localCodecCapabilities.colorFormats[j]))
          {
            bool1 = true;
            return bool1;
          }
          j += 1;
        }
      }
      i += 1;
    }
  }
  
  public static boolean g()
  {
    if (h()) {}
    lra locallra;
    lqw locallqw1;
    lqw locallqw2;
    do
    {
      do
      {
        return false;
      } while (Build.VERSION.SDK_INT < 21);
      locallra = new lra(lim.a(BaseApplicationImpl.getContext()));
      locallqw1 = locallra.d();
      locallqw2 = locallra.c();
    } while ((locallqw1 == null) || (!locallqw1.a) || (!locallra.a(2)) || (locallqw2 == null) || (!locallqw2.a) || (!locallra.a(1)));
    if (QLog.isColorLevel()) {
      QLog.d("DeviceCheck", 2, "SUPPORT Async API");
    }
    return true;
  }
  
  public static boolean h()
  {
    return false;
  }
  
  public void run() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.mediacodec.DeviceCheck
 * JD-Core Version:    0.7.0.1
 */