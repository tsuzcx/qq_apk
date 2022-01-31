package com.tencent.aekit.api.standard.ai;

import android.text.TextUtils;
import com.tencent.aekit.plugin.core.AEDetectorType;
import com.tencent.aekit.plugin.core.IDetect;
import com.tencent.aekit.plugin.core.IModule;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.ttpicmodule.AEDependencyManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AIManager
{
  private static Map<String, Class<? extends IDetect>> detectors_installed = new HashMap();
  private static Map<String, Class<? extends IDetect>> detectors_registered = new HashMap();
  
  public static void clear()
  {
    detectors_installed.clear();
  }
  
  public static void destroy()
  {
    detectors_installed.clear();
    detectors_registered.clear();
  }
  
  public static Class<? extends IDetect> getDetectClass(AEDetectorType paramAEDetectorType)
  {
    return (Class)detectors_installed.get(paramAEDetectorType.value);
  }
  
  public static List<Class<? extends IDetect>> getDetectorSet()
  {
    return new ArrayList(detectors_installed.values());
  }
  
  public static boolean installDetector(Class<? extends IDetect> paramClass)
  {
    String str1 = FeatureManager.getSoDir();
    String str2 = FeatureManager.getResourceDir();
    if (!TextUtils.isEmpty(str2)) {
      return installDetector(paramClass, str1, str2);
    }
    return installDetector(paramClass, null, null);
  }
  
  public static boolean installDetector(Class<? extends IDetect> paramClass, String paramString1, String paramString2)
  {
    try
    {
      IModule localIModule = (IModule)paramClass.newInstance();
      detectors_registered.put(localIModule.getModuleType(), paramClass);
      if (localIModule.onModuleInstall(paramString1, paramString2))
      {
        detectors_installed.put(localIModule.getModuleType(), paramClass);
        AEDependencyManager.getInstance().loadDependency(localIModule.getModuleType());
        return true;
      }
    }
    catch (IllegalAccessException paramClass)
    {
      LogUtils.e(paramClass);
      return false;
    }
    catch (InstantiationException paramClass)
    {
      for (;;)
      {
        LogUtils.e(paramClass);
      }
    }
    catch (SecurityException paramClass)
    {
      for (;;)
      {
        LogUtils.e(paramClass);
      }
    }
    catch (UnsatisfiedLinkError paramClass)
    {
      for (;;)
      {
        LogUtils.e(paramClass);
      }
    }
  }
  
  public static boolean isDetectorReady(AEDetectorType paramAEDetectorType)
  {
    return detectors_installed.get(paramAEDetectorType.value) != null;
  }
  
  public static boolean reInstallDetector(Class<? extends IDetect> paramClass)
  {
    try
    {
      IDetect localIDetect = (IDetect)paramClass.newInstance();
      detectors_registered.put(localIDetect.getModuleType(), paramClass);
      if (localIDetect.reInit())
      {
        detectors_installed.put(localIDetect.getModuleType(), paramClass);
        AEDependencyManager.getInstance().loadDependency(localIDetect.getModuleType());
        return true;
      }
    }
    catch (IllegalAccessException paramClass)
    {
      LogUtils.e(paramClass);
      return false;
    }
    catch (InstantiationException paramClass)
    {
      for (;;)
      {
        LogUtils.e(paramClass);
      }
    }
    catch (SecurityException paramClass)
    {
      for (;;)
      {
        LogUtils.e(paramClass);
      }
    }
    catch (UnsatisfiedLinkError paramClass)
    {
      for (;;)
      {
        LogUtils.e(paramClass);
      }
    }
  }
  
  public static boolean reInstallModule(AEDetectorType paramAEDetectorType)
  {
    if ((!detectors_registered.containsKey(paramAEDetectorType.value)) || (detectors_installed.containsKey(paramAEDetectorType.value))) {
      return false;
    }
    return reInstallDetector((Class)detectors_registered.get(paramAEDetectorType.value));
  }
  
  public static boolean registerDetector(Class<? extends IDetect> paramClass)
  {
    try
    {
      IModule localIModule = (IModule)paramClass.newInstance();
      if (!detectors_registered.containsKey(localIModule.getModuleType()))
      {
        detectors_registered.put(localIModule.getModuleType(), paramClass);
        return true;
      }
      return false;
    }
    catch (InstantiationException paramClass)
    {
      paramClass.printStackTrace();
      return false;
    }
    catch (IllegalAccessException paramClass)
    {
      for (;;)
      {
        paramClass.printStackTrace();
      }
    }
    catch (SecurityException paramClass)
    {
      for (;;)
      {
        paramClass.printStackTrace();
      }
    }
    catch (ExceptionInInitializerError paramClass)
    {
      for (;;)
      {
        paramClass.printStackTrace();
      }
    }
  }
  
  public static void uninstallDetector(Class<? extends IDetect> paramClass)
  {
    try
    {
      paramClass = (IModule)paramClass.newInstance();
      paramClass.onModuleUninstall();
      detectors_installed.remove(paramClass.getModuleType());
      detectors_registered.remove(paramClass.getModuleType());
      AEDependencyManager.getInstance().unloadDependency(paramClass.getModuleType());
      return;
    }
    catch (IllegalAccessException paramClass)
    {
      LogUtils.e(paramClass);
      return;
    }
    catch (InstantiationException paramClass)
    {
      LogUtils.e(paramClass);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.aekit.api.standard.ai.AIManager
 * JD-Core Version:    0.7.0.1
 */