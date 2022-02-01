package android.app;

import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.IBinder;
import de.robv.android.xposed.XSharedPreferences;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import java.lang.ref.WeakReference;
import java.util.Map;

public final class AndroidAppHelper
{
  private static final Class<?> CLASS_RESOURCES_KEY;
  private static final boolean HAS_IS_THEMEABLE;
  private static final boolean HAS_THEME_CONFIG_PARAMETER;
  
  static
  {
    boolean bool2 = true;
    Class localClass;
    if (Build.VERSION.SDK_INT < 19)
    {
      localClass = XposedHelpers.findClass("android.app.ActivityThread$ResourcesKey", null);
      CLASS_RESOURCES_KEY = localClass;
      if (XposedHelpers.findFieldIfExists(CLASS_RESOURCES_KEY, "mIsThemeable") == null) {
        break label84;
      }
      bool1 = true;
      label34:
      HAS_IS_THEMEABLE = bool1;
      if ((!HAS_IS_THEMEABLE) || (Build.VERSION.SDK_INT < 21) || (XposedHelpers.findMethodExactIfExists("android.app.ResourcesManager", null, "getThemeConfig", new Object[0]) == null)) {
        break label89;
      }
    }
    label84:
    label89:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      HAS_THEME_CONFIG_PARAMETER = bool1;
      return;
      localClass = XposedHelpers.findClass("android.content.res.ResourcesKey", null);
      break;
      bool1 = false;
      break label34;
    }
  }
  
  public static void addActiveResource(String paramString, float paramFloat, boolean paramBoolean, Resources paramResources)
  {
    addActiveResource(paramString, paramResources);
  }
  
  public static void addActiveResource(String paramString, Resources paramResources)
  {
    ActivityThread localActivityThread = ActivityThread.currentActivityThread();
    if (localActivityThread == null) {}
    for (;;)
    {
      return;
      if (Build.VERSION.SDK_INT >= 24)
      {
        CompatibilityInfo localCompatibilityInfo = (CompatibilityInfo)XposedHelpers.newInstance(CompatibilityInfo.class, new Object[0]);
        XposedHelpers.setFloatField(localCompatibilityInfo, "applicationScale", paramResources.hashCode());
        paramString = createResourcesKey(paramString, null, null, null, 0, null, localCompatibilityInfo);
      }
      while (paramString != null)
      {
        if (Build.VERSION.SDK_INT < 24) {
          break label174;
        }
        paramResources = XposedHelpers.getObjectField(paramResources, "mResourcesImpl");
        getResourcesMap(localActivityThread).put(paramString, new WeakReference(paramResources));
        return;
        if (Build.VERSION.SDK_INT == 23) {
          paramString = createResourcesKey(paramString, 0, null, paramResources.hashCode());
        } else if (Build.VERSION.SDK_INT >= 19) {
          paramString = createResourcesKey(paramString, 0, null, paramResources.hashCode(), null);
        } else if (Build.VERSION.SDK_INT >= 17) {
          paramString = createResourcesKey(paramString, 0, null, paramResources.hashCode());
        } else {
          paramString = createResourcesKey(paramString, paramResources.hashCode());
        }
      }
    }
    label174:
    getResourcesMap(localActivityThread).put(paramString, new WeakReference(paramResources));
  }
  
  private static Object createResourcesKey(String paramString, float paramFloat)
  {
    try
    {
      if (HAS_IS_THEMEABLE) {
        return XposedHelpers.newInstance(CLASS_RESOURCES_KEY, new Object[] { paramString, Float.valueOf(paramFloat), Boolean.valueOf(false) });
      }
      paramString = XposedHelpers.newInstance(CLASS_RESOURCES_KEY, new Object[] { paramString, Float.valueOf(paramFloat) });
      return paramString;
    }
    catch (Throwable paramString)
    {
      XposedBridge.log(paramString);
    }
    return null;
  }
  
  private static Object createResourcesKey(String paramString, int paramInt, Configuration paramConfiguration, float paramFloat)
  {
    try
    {
      if (HAS_THEME_CONFIG_PARAMETER) {
        return XposedHelpers.newInstance(CLASS_RESOURCES_KEY, new Object[] { paramString, Integer.valueOf(paramInt), paramConfiguration, Float.valueOf(paramFloat), Boolean.valueOf(false), null });
      }
      if (HAS_IS_THEMEABLE) {
        return XposedHelpers.newInstance(CLASS_RESOURCES_KEY, new Object[] { paramString, Integer.valueOf(paramInt), paramConfiguration, Float.valueOf(paramFloat), Boolean.valueOf(false) });
      }
      paramString = XposedHelpers.newInstance(CLASS_RESOURCES_KEY, new Object[] { paramString, Integer.valueOf(paramInt), paramConfiguration, Float.valueOf(paramFloat) });
      return paramString;
    }
    catch (Throwable paramString)
    {
      XposedBridge.log(paramString);
    }
    return null;
  }
  
  private static Object createResourcesKey(String paramString, int paramInt, Configuration paramConfiguration, float paramFloat, IBinder paramIBinder)
  {
    try
    {
      if (HAS_THEME_CONFIG_PARAMETER) {
        return XposedHelpers.newInstance(CLASS_RESOURCES_KEY, new Object[] { paramString, Integer.valueOf(paramInt), paramConfiguration, Float.valueOf(paramFloat), Boolean.valueOf(false), null, paramIBinder });
      }
      if (HAS_IS_THEMEABLE) {
        return XposedHelpers.newInstance(CLASS_RESOURCES_KEY, new Object[] { paramString, Integer.valueOf(paramInt), paramConfiguration, Float.valueOf(paramFloat), Boolean.valueOf(false), paramIBinder });
      }
      paramString = XposedHelpers.newInstance(CLASS_RESOURCES_KEY, new Object[] { paramString, Integer.valueOf(paramInt), paramConfiguration, Float.valueOf(paramFloat), paramIBinder });
      return paramString;
    }
    catch (Throwable paramString)
    {
      XposedBridge.log(paramString);
    }
    return null;
  }
  
  private static Object createResourcesKey(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, int paramInt, Configuration paramConfiguration, CompatibilityInfo paramCompatibilityInfo)
  {
    try
    {
      paramString = XposedHelpers.newInstance(CLASS_RESOURCES_KEY, new Object[] { paramString, paramArrayOfString1, paramArrayOfString2, paramArrayOfString3, Integer.valueOf(paramInt), paramConfiguration, paramCompatibilityInfo });
      return paramString;
    }
    catch (Throwable paramString)
    {
      XposedBridge.log(paramString);
    }
    return null;
  }
  
  public static Application currentApplication()
  {
    return ActivityThread.currentApplication();
  }
  
  public static ApplicationInfo currentApplicationInfo()
  {
    Object localObject = ActivityThread.currentActivityThread();
    if (localObject == null) {}
    do
    {
      return null;
      localObject = XposedHelpers.getObjectField(localObject, "mBoundApplication");
    } while (localObject == null);
    return (ApplicationInfo)XposedHelpers.getObjectField(localObject, "appInfo");
  }
  
  public static String currentPackageName()
  {
    ApplicationInfo localApplicationInfo = currentApplicationInfo();
    if (localApplicationInfo != null) {
      return localApplicationInfo.packageName;
    }
    return "android";
  }
  
  public static String currentProcessName()
  {
    String str2 = ActivityThread.currentPackageName();
    String str1 = str2;
    if (str2 == null) {
      str1 = "android";
    }
    return str1;
  }
  
  @Deprecated
  public static SharedPreferences getDefaultSharedPreferencesForPackage(String paramString)
  {
    return new XSharedPreferences(paramString);
  }
  
  private static Map<Object, WeakReference> getResourcesMap(ActivityThread paramActivityThread)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return (Map)XposedHelpers.getObjectField(XposedHelpers.getObjectField(paramActivityThread, "mResourcesManager"), "mResourceImpls");
    }
    if (Build.VERSION.SDK_INT >= 19) {
      return (Map)XposedHelpers.getObjectField(XposedHelpers.getObjectField(paramActivityThread, "mResourcesManager"), "mActiveResources");
    }
    return (Map)XposedHelpers.getObjectField(paramActivityThread, "mActiveResources");
  }
  
  @Deprecated
  public static SharedPreferences getSharedPreferencesForPackage(String paramString1, String paramString2, int paramInt)
  {
    return new XSharedPreferences(paramString1, paramString2);
  }
  
  @Deprecated
  public static void reloadSharedPreferencesIfNeeded(SharedPreferences paramSharedPreferences)
  {
    if ((paramSharedPreferences instanceof XSharedPreferences)) {
      ((XSharedPreferences)paramSharedPreferences).reload();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     android.app.AndroidAppHelper
 * JD-Core Version:    0.7.0.1
 */