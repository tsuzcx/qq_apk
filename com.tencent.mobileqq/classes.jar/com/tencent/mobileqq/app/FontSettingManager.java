package com.tencent.mobileqq.app;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.res.Resources;
import android.os.Process;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.app.utils.PropertiesUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class FontSettingManager
{
  private static final String[] BE_KILLED_PROCESS = { "com.tencent.mobileqq:tool", "com.tencent.mobileqq:picture", "com.tencent.mobileqq:qqreader", "com.tencent.mobileqq:story", "com.tencent.mobileqq:troopmanage", "com.tencent.mobileqq:qzone", "com.tencent.mobileqq:qwallet", "com.tencent.mobileqq:qqwifi", "com.tencent.mobileqq:qqfav", "com.tencent.mobileqq:dingdong", "com.tencent.mobileqq:buscard", "com.tencent.mobileqq:qqhotspot", "com.tencent.mobileqq" };
  private static final String[][] BRAND_AND_MODEL_BLACK_LIST = { { "OPPO", "PHILIPS", "KONKA", "Sony", "Meitu", "GiONEE", "GiONEE", "GiONEE", "GiONEE", "alps", "Xiaomi", "Xiaomi", "Xiaomi", "Huawei", "BBK", "LGE" }, { "R815T", "W6500", "K5", "S39h", "MK150", "GN137", "GN705T", "GN708T", "E3T", "K5", "Mi-4c", "MI 4S", "MI NOTE Pro", "Nexus 6P", "vivo X3S W", "Nexus 5X" } };
  public static final String FONT_LEVEL_KEY = "font_setting_font_level_key";
  public static final String FONT_LEVEL_SP_NAME = "font_level_sp_name";
  public static final String FONT_SWITCHER_CLOSE = "0";
  public static final String FONT_SWITCHER_DEFAULT = "-1";
  public static final String FONT_SWITCHER_OPEN = "1";
  public static final int GET_FONT_LEVEL_ERROR = -1000;
  private static final String[] MODEL_BLACK_LIST = { "vivo Y13", "vivo X3t", "vivo Y11i T", "MI-ONE Plus", "vivoY11iT", "Coolpad 7270", "Coolpad 8122", "Lenovo A708T", "Lenovo S820", "Lenovo S898t", "GT-I9050", "GT-S7568", "DOOV S2y", "TCL J928", "vivo Y22", "ChanghongZ8t", "HUAWEI Y516-T00", "Lenovo A678t", "K-Touch T60", "vivo X710L", "HM MOTE 1TD", "Redmi 3" };
  private static final String[] NONE_FONTSETTING_PROCESS_LIST;
  private static final String QQPROCESSNAME = "com.tencent.mobileqq";
  public static final String TAG = "FontSettingManager";
  public static DisplayMetrics customMetrics;
  private static float sFontLevel;
  public static DisplayMetrics systemMetrics = new DisplayMetrics();
  
  static
  {
    customMetrics = new DisplayMetrics();
    sFontLevel = 16.0F;
    NONE_FONTSETTING_PROCESS_LIST = new String[] { "com.tencent.mobileqq:qqreader", "com.tencent.mobileqq:photoplus", "com.tencent.mobileqq:video", "com.tencent.mobileqq:mini_internal", "com.tencent.mobileqq:mini", "com.tencent.mobileqq:mini1", "com.tencent.mobileqq:mini2", "com.tencent.mobileqq:mini3", "com.tencent.mobileqq:mini4", "com.tencent.mobileqq:mini5", "com.tencent.mobileqq:mini6", "com.tencent.mobileqq:mini7" };
  }
  
  public static float getFontLevel()
  {
    return sFontLevel;
  }
  
  private static float getFontLevelFromProperties(Context paramContext)
  {
    if (paramContext == null) {
      return -1000.0F;
    }
    float f2 = Float.valueOf(PropertiesUtils.b(paramContext, "key_font_level", String.valueOf(16.0F))).floatValue();
    float f1;
    if (f2 >= 13.92F)
    {
      f1 = f2;
      if (f2 <= 18.0F) {}
    }
    else
    {
      f1 = 16.0F;
    }
    sFontLevel = f1;
    return sFontLevel;
  }
  
  public static void initFontSetting(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!needInit(paramContext))
    {
      customMetrics.setTo(paramContext.getResources().getDisplayMetrics());
      return;
    }
    float f;
    if (paramBoolean1) {
      f = sFontLevel;
    } else {
      f = getFontLevelFromProperties(paramContext);
    }
    setCustomDensity(paramContext, f, paramBoolean2);
  }
  
  public static boolean isDisplayMetricNoAnswer()
  {
    String str1 = DeviceInfoUtil.t();
    String str2 = DeviceInfoUtil.f();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("current machine brandName:");
      localStringBuilder.append(str1);
      localStringBuilder.append(", modelName:");
      localStringBuilder.append(str2);
      QLog.d("FontSettingManager", 2, localStringBuilder.toString());
    }
    return ((!str1.equals("Xiaomi")) || (!str2.equals("MI 4S"))) && ((!str1.equals("Huawei")) || (!str2.equals("Nexus 6P"))) && ((!str1.equals("BBK")) || (!str2.equals("vivo X3S W"))) && ((!str1.equals("LGE")) || (!str2.equals("Nexus 5X"))) && (!str2.equals("Redmi 3"));
  }
  
  private static boolean isScaleValueRight(float paramFloat)
  {
    return (paramFloat > 13.82F) && (paramFloat < 18.1F);
  }
  
  public static boolean isSupportDevice()
  {
    Object localObject = DeviceInfoUtil.t();
    String str = DeviceInfoUtil.f();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("current machine brandName:");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(", modelName:");
      localStringBuilder.append(str);
      QLog.d("FontSettingManager", 2, localStringBuilder.toString());
    }
    int i = BRAND_AND_MODEL_BLACK_LIST[0].length - 1;
    while (i >= 0)
    {
      if ((((String)localObject).equals(BRAND_AND_MODEL_BLACK_LIST[0][i])) && (str.equals(BRAND_AND_MODEL_BLACK_LIST[1][i]))) {
        return false;
      }
      i -= 1;
    }
    localObject = MODEL_BLACK_LIST;
    int j = localObject.length;
    i = 0;
    while (i < j)
    {
      if (str.equals(localObject[i])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static void killProcess()
  {
    String[] arrayOfString = BE_KILLED_PROCESS;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      killProcess(MobileQQ.getContext(), str);
      i += 1;
    }
  }
  
  private static boolean killProcess(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      if (paramString == null) {
        return false;
      }
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.processName.equals(paramString))
        {
          Process.killProcess(localRunningAppProcessInfo.pid);
          return true;
        }
      }
    }
    return false;
  }
  
  private static boolean needInit(Context paramContext)
  {
    paramContext = MobileQQ.processName;
    String[] arrayOfString = NONE_FONTSETTING_PROCESS_LIST;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equals(paramContext)) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static void resetFontIfNeeded(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = paramContext.getResources();
    if ((localObject != null) && ((Math.abs(customMetrics.density - ((Resources)localObject).getDisplayMetrics().density) > 0.01F) || (Math.abs(customMetrics.scaledDensity - ((Resources)localObject).getDisplayMetrics().scaledDensity) > 0.01F) || (customMetrics.densityDpi != ((Resources)localObject).getDisplayMetrics().densityDpi)))
    {
      systemMetrics.setTo(((Resources)localObject).getDisplayMetrics());
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("current density: ");
        ((StringBuilder)localObject).append(systemMetrics.density);
        ((StringBuilder)localObject).append(", custom density: ");
        ((StringBuilder)localObject).append(customMetrics.density);
        QLog.i("FontSettingManager", 2, ((StringBuilder)localObject).toString());
      }
      initFontSetting(paramContext, paramBoolean1, paramBoolean2);
    }
  }
  
  public static void revert2SystemDensity(Context paramContext)
  {
    if (paramContext.getResources().getDisplayMetrics().density != systemMetrics.density) {
      setCustomDensity(paramContext, 16.0F, true);
    }
  }
  
  public static void revertToLsatDendisy(Context paramContext)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    paramContext.density = customMetrics.density;
    paramContext.scaledDensity = customMetrics.density;
    paramContext.densityDpi = customMetrics.densityDpi;
  }
  
  public static boolean setCustomDensity(Context paramContext, float paramFloat, boolean paramBoolean)
  {
    if (!isScaleValueRight(paramFloat))
    {
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("wrong scale vale : ");
        paramContext.append(paramFloat);
        QLog.d("FontSettingManager", 2, paramContext.toString());
      }
      return false;
    }
    float f = paramFloat / 16.0F;
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    updateSystemMetrics(localDisplayMetrics);
    localDisplayMetrics.density = (systemMetrics.density * f);
    localDisplayMetrics.scaledDensity = (systemMetrics.density * f);
    localDisplayMetrics.densityDpi = ((int)(systemMetrics.densityDpi * f));
    QLog.d("FontSettingManager", 1, new Object[] { "currentDm: ", Float.valueOf(localDisplayMetrics.density), ", ", Float.valueOf(localDisplayMetrics.scaledDensity), ", ", Integer.valueOf(localDisplayMetrics.densityDpi) });
    if (paramBoolean)
    {
      customMetrics.setTo(localDisplayMetrics);
      if (sFontLevel != paramFloat)
      {
        sFontLevel = paramFloat;
        setFontLevelToProperties(paramContext, paramFloat);
        return true;
      }
    }
    return false;
  }
  
  private static void setFontLevelToProperties(Context paramContext, float paramFloat)
  {
    if (paramContext == null) {
      return;
    }
    PropertiesUtils.a(paramContext, "key_font_level", String.valueOf(paramFloat));
  }
  
  private static void updateSystemMetrics(DisplayMetrics paramDisplayMetrics)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplayMetrics.setTo(paramDisplayMetrics);
    localDisplayMetrics.density = systemMetrics.density;
    localDisplayMetrics.scaledDensity = systemMetrics.scaledDensity;
    localDisplayMetrics.densityDpi = systemMetrics.densityDpi;
    if (QLog.isColorLevel())
    {
      paramDisplayMetrics = new StringBuilder();
      paramDisplayMetrics.append("systemMetrics.density : ");
      paramDisplayMetrics.append(systemMetrics.density);
      QLog.d("FontSettingManager", 2, paramDisplayMetrics.toString());
      paramDisplayMetrics = new StringBuilder();
      paramDisplayMetrics.append("systemMetrics.scaledDensity : ");
      paramDisplayMetrics.append(systemMetrics.scaledDensity);
      QLog.d("FontSettingManager", 2, paramDisplayMetrics.toString());
      paramDisplayMetrics = new StringBuilder();
      paramDisplayMetrics.append("systemMetrics.densityDpi : ");
      paramDisplayMetrics.append(systemMetrics.densityDpi);
      QLog.d("FontSettingManager", 2, paramDisplayMetrics.toString());
    }
    systemMetrics = localDisplayMetrics;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FontSettingManager
 * JD-Core Version:    0.7.0.1
 */