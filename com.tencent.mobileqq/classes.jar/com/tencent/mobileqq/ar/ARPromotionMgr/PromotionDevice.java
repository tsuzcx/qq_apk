package com.tencent.mobileqq.ar.ARPromotionMgr;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;

public class PromotionDevice
{
  static final String a = PromotionUtil.a;
  static int b = -1;
  static int c = -1;
  
  public static boolean a()
  {
    return (c()) && (d()) && (b());
  }
  
  public static boolean a(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    int i = DeviceInfoUtil.d();
    String str;
    StringBuilder localStringBuilder;
    if (i < paramInt2)
    {
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSupportOfDevice, error OSversion[");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("->");
      localStringBuilder.append(i);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      return false;
    }
    paramInt2 = DeviceInfoUtil.h();
    if (paramInt2 < paramInt1)
    {
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSupportOfDevice, error cpucount[");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("->");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      return false;
    }
    long l = DeviceInfoUtil.k();
    if (l < paramLong1)
    {
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSupportOfDevice, error cpuFrequency[");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("->");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      return false;
    }
    paramLong1 = DeviceInfoUtil.a();
    if (paramLong1 < paramLong2)
    {
      str = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSupportOfDevice, error memory[");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append("->");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      return false;
    }
    return true;
  }
  
  public static boolean b()
  {
    return (!Build.MODEL.equalsIgnoreCase("ATH-AL00")) && (!Build.MODEL.equalsIgnoreCase("BND-AL10")) && (!Build.MODEL.equalsIgnoreCase("ASK-AL00x")) && (!Build.MODEL.equalsIgnoreCase("vivo X6S A"));
  }
  
  public static boolean c()
  {
    int i = b;
    boolean bool = false;
    if (i == -1)
    {
      if (Build.VERSION.SDK_INT > 20) {
        i = 1;
      } else {
        i = 0;
      }
      int j;
      if ((!a(8, 1367L, 2800000000L, 15)) && (!a(4, 2099L, 2800000000L, 15))) {
        j = 0;
      } else {
        j = 1;
      }
      if ((j != 0) && (i != 0)) {
        i = 1;
      } else {
        i = 0;
      }
      b = i;
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isDevicesSupport, DeviceSupportFromLocal[");
      localStringBuilder.append(b);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
    if (b == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean d()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.PromotionDevice
 * JD-Core Version:    0.7.0.1
 */