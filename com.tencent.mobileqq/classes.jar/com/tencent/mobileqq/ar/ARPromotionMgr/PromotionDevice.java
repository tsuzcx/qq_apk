package com.tencent.mobileqq.ar.ARPromotionMgr;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;

public class PromotionDevice
{
  static int jdField_a_of_type_Int = -1;
  static final String jdField_a_of_type_JavaLangString = PromotionUtil.jdField_a_of_type_JavaLangString;
  static int b = -1;
  
  public static boolean a()
  {
    return (c()) && (d()) && (b());
  }
  
  public static boolean a(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    int i = DeviceInfoUtil.a();
    if (i < paramInt2)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "isSupportOfDevice, error OSversion[" + paramInt2 + "->" + i + "]");
      return false;
    }
    paramInt2 = DeviceInfoUtil.b();
    if (paramInt2 < paramInt1)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "isSupportOfDevice, error cpucount[" + paramInt1 + "->" + paramInt2 + "]");
      return false;
    }
    long l = DeviceInfoUtil.b();
    if (l < paramLong1)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "isSupportOfDevice, error cpuFrequency[" + paramLong1 + "->" + l + "]");
      return false;
    }
    paramLong1 = DeviceInfoUtil.a();
    if (paramLong1 < paramLong2)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "isSupportOfDevice, error memory[" + paramLong2 + "->" + paramLong1 + "]");
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
    if (jdField_a_of_type_Int == -1) {
      if (Build.VERSION.SDK_INT <= 20) {
        break label118;
      }
    }
    label111:
    label116:
    label118:
    for (int i = 1;; i = 0)
    {
      int j;
      if ((a(8, 1367L, 2800000000L, 15)) || (a(4, 2099L, 2800000000L, 15)))
      {
        j = 1;
        if ((j == 0) || (i == 0)) {
          break label111;
        }
      }
      for (i = 1;; i = 0)
      {
        jdField_a_of_type_Int = i;
        QLog.w(jdField_a_of_type_JavaLangString, 1, "isDevicesSupport, DeviceSupportFromLocal[" + jdField_a_of_type_Int + "]");
        if (jdField_a_of_type_Int != 1) {
          break label116;
        }
        return true;
        j = 0;
        break;
      }
      return false;
    }
  }
  
  public static boolean d()
  {
    String str;
    Object localObject;
    int j;
    boolean bool;
    if (b == -1)
    {
      str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.ARCfg.name());
      if (TextUtils.isEmpty(str)) {
        break label170;
      }
      localObject = new String[13];
      j = ((IDPCApi)QRoute.api(IDPCApi.class)).parseComplexParamsBySimpleStringParser(str, (String[])localObject);
      if (localObject.length <= 12) {
        break label183;
      }
      localObject = localObject[12];
      if (TextUtils.equals((CharSequence)localObject, "1")) {
        break label160;
      }
      bool = true;
    }
    for (;;)
    {
      if (bool) {}
      for (int i = 1;; i = 0)
      {
        b = i;
        QLog.w(jdField_a_of_type_JavaLangString, 1, "isEnableInDPC, isEnable[" + bool + "], arCfg[" + str + "], size[" + j + "], params[" + (String)localObject + "]");
        if (b != 1) {
          break label181;
        }
        return true;
        label160:
        bool = false;
        break;
      }
      label170:
      QLog.w(jdField_a_of_type_JavaLangString, 1, "isEnableInDPC, 没拉到dpc配置");
      return true;
      label181:
      return false;
      label183:
      localObject = null;
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.PromotionDevice
 * JD-Core Version:    0.7.0.1
 */