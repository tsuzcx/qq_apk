package com.tencent.aelight.camera.aeeditor.module.params;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import java.util.List;
import org.light.device.LightDeviceUtils;
import org.light.device.OfflineConfig;

public class ParamsUtil
{
  private static List<String> a = new ArrayList();
  
  static
  {
    a.add("pbem00");
  }
  
  public static int a(double paramDouble)
  {
    double d = Math.floor(paramDouble);
    paramDouble = Math.ceil(paramDouble);
    if (d % 2.0D == 0.0D) {
      return (int)d;
    }
    return (int)paramDouble;
  }
  
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    if (paramString.equals("very_low")) {
      return 1;
    }
    if (paramString.equals("low")) {
      return 2;
    }
    if (paramString.equals("middle")) {
      return 3;
    }
    if (paramString.equals("middle_high")) {
      return 4;
    }
    if (paramString.equals("high")) {
      return 5;
    }
    return 0;
  }
  
  public static <T> T a(T paramT1, T paramT2)
  {
    if (LightDeviceUtils.getTotalRamMemory(BaseApplicationImpl.getContext()) <= 2147483648L) {
      return paramT1;
    }
    return paramT2;
  }
  
  public static <T> T a(T paramT1, T paramT2, T paramT3)
  {
    if (OfflineConfig.getPhonePerfLevel(BaseApplicationImpl.getContext()) <= 2) {
      return paramT1;
    }
    if (((OfflineConfig.getPhonePerfLevel(BaseApplicationImpl.getContext()) > 2) && (OfflineConfig.getPhonePerfLevel(BaseApplicationImpl.getContext()) <= 3)) || (a.contains(Build.MODEL.toLowerCase()))) {
      return paramT2;
    }
    return paramT3;
  }
  
  public static String a()
  {
    return (String)a("低端机", "中端机", "高端机");
  }
  
  public static int b()
  {
    return OfflineConfig.getPhonePerfLevel(BaseApplicationImpl.getContext());
  }
  
  public static <T> T b(T paramT1, T paramT2, T paramT3)
  {
    long l = LightDeviceUtils.getTotalRamMemory(BaseApplicationImpl.getContext());
    if (l <= 2147483648L) {
      return paramT1;
    }
    if (l <= 4294967296L) {
      return paramT2;
    }
    return paramT3;
  }
  
  public static String c()
  {
    return Build.MODEL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.params.ParamsUtil
 * JD-Core Version:    0.7.0.1
 */