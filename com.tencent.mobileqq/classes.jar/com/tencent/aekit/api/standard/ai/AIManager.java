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
  private static Map<String, Class<? extends IDetect>> detectors_installing = new HashMap();
  private static Map<String, Class<? extends IDetect>> detectors_registered = new HashMap();
  private static Map<String, String> registeredModelPath = new HashMap();
  private static Map<String, String> registeredSoPath = new HashMap();
  
  public static void clear()
  {
    detectors_installed.clear();
    detectors_installing.clear();
  }
  
  public static void destroy()
  {
    detectors_installed.clear();
    detectors_installing.clear();
    detectors_registered.clear();
    registeredSoPath.clear();
    registeredModelPath.clear();
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
    String str2 = "";
    str3 = str2;
    str4 = str2;
    str5 = str2;
    str6 = str2;
    str1 = str2;
    try
    {
      IModule localIModule = (IModule)paramClass.newInstance();
      str3 = str2;
      str4 = str2;
      str5 = str2;
      str6 = str2;
      str1 = str2;
      str2 = localIModule.getModuleType();
      str3 = str2;
      str4 = str2;
      str5 = str2;
      str6 = str2;
      str1 = str2;
      detectors_registered.put(str2, paramClass);
      str3 = str2;
      str4 = str2;
      str5 = str2;
      str6 = str2;
      str1 = str2;
      detectors_installing.put(str2, paramClass);
      str3 = str2;
      str4 = str2;
      str5 = str2;
      str6 = str2;
      str1 = str2;
      registeredSoPath.put(localIModule.getModuleType(), paramString1);
      str3 = str2;
      str4 = str2;
      str5 = str2;
      str6 = str2;
      str1 = str2;
      registeredModelPath.put(localIModule.getModuleType(), paramString2);
      str3 = str2;
      str4 = str2;
      str5 = str2;
      str6 = str2;
      str1 = str2;
      if (localIModule.onModuleInstall(paramString1, paramString2))
      {
        str3 = str2;
        str4 = str2;
        str5 = str2;
        str6 = str2;
        str1 = str2;
        detectors_installed.put(str2, paramClass);
        str3 = str2;
        str4 = str2;
        str5 = str2;
        str6 = str2;
        str1 = str2;
        AEDependencyManager.getInstance().loadDependency(str2);
        return true;
      }
    }
    catch (IllegalAccessException paramClass)
    {
      for (;;)
      {
        str1 = str3;
        LogUtils.e(paramClass);
        if (str3 != null) {
          detectors_installing.remove(str3);
        }
      }
    }
    catch (InstantiationException paramClass)
    {
      for (;;)
      {
        str1 = str4;
        LogUtils.e(paramClass);
        if (str4 != null) {
          detectors_installing.remove(str4);
        }
      }
    }
    catch (SecurityException paramClass)
    {
      for (;;)
      {
        str1 = str5;
        LogUtils.e(paramClass);
        if (str5 != null) {
          detectors_installing.remove(str5);
        }
      }
    }
    catch (UnsatisfiedLinkError paramClass)
    {
      for (;;)
      {
        str1 = str6;
        LogUtils.e(paramClass);
        if (str6 != null) {
          detectors_installing.remove(str6);
        }
      }
    }
    finally
    {
      if (str1 == null) {
        break label442;
      }
      detectors_installing.remove(str1);
    }
    return false;
  }
  
  public static boolean isDetectorReady(AEDetectorType paramAEDetectorType)
  {
    return detectors_installed.get(paramAEDetectorType.value) != null;
  }
  
  /* Error */
  public static boolean reInstallDetector(Class<? extends IDetect> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 100	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   4: checkcast 138	com/tencent/aekit/plugin/core/IDetect
    //   7: astore_2
    //   8: getstatic 25	com/tencent/aekit/api/standard/ai/AIManager:detectors_registered	Ljava/util/Map;
    //   11: aload_2
    //   12: invokevirtual 139	com/tencent/aekit/plugin/core/IDetect:getModuleType	()Ljava/lang/String;
    //   15: aload_0
    //   16: invokeinterface 109 3 0
    //   21: pop
    //   22: getstatic 27	com/tencent/aekit/api/standard/ai/AIManager:registeredSoPath	Ljava/util/Map;
    //   25: aload_2
    //   26: invokevirtual 139	com/tencent/aekit/plugin/core/IDetect:getModuleType	()Ljava/lang/String;
    //   29: invokeinterface 49 2 0
    //   34: checkcast 141	java/lang/String
    //   37: astore_3
    //   38: getstatic 29	com/tencent/aekit/api/standard/ai/AIManager:registeredModelPath	Ljava/util/Map;
    //   41: aload_2
    //   42: invokevirtual 139	com/tencent/aekit/plugin/core/IDetect:getModuleType	()Ljava/lang/String;
    //   45: invokeinterface 49 2 0
    //   50: checkcast 141	java/lang/String
    //   53: astore 4
    //   55: aload_3
    //   56: invokestatic 82	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   59: ifne +11 -> 70
    //   62: aload 4
    //   64: invokestatic 82	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   67: ifeq +40 -> 107
    //   70: aload_2
    //   71: aconst_null
    //   72: aconst_null
    //   73: invokevirtual 142	com/tencent/aekit/plugin/core/IDetect:onModuleInstall	(Ljava/lang/String;Ljava/lang/String;)Z
    //   76: istore_1
    //   77: iload_1
    //   78: ifeq +45 -> 123
    //   81: getstatic 21	com/tencent/aekit/api/standard/ai/AIManager:detectors_installed	Ljava/util/Map;
    //   84: aload_2
    //   85: invokevirtual 139	com/tencent/aekit/plugin/core/IDetect:getModuleType	()Ljava/lang/String;
    //   88: aload_0
    //   89: invokeinterface 109 3 0
    //   94: pop
    //   95: invokestatic 119	com/tencent/ttpic/openapi/ttpicmodule/AEDependencyManager:getInstance	()Lcom/tencent/ttpic/openapi/ttpicmodule/AEDependencyManager;
    //   98: aload_2
    //   99: invokevirtual 139	com/tencent/aekit/plugin/core/IDetect:getModuleType	()Ljava/lang/String;
    //   102: invokevirtual 123	com/tencent/ttpic/openapi/ttpicmodule/AEDependencyManager:loadDependency	(Ljava/lang/String;)V
    //   105: iconst_1
    //   106: ireturn
    //   107: aload_2
    //   108: aload_3
    //   109: aload 4
    //   111: invokevirtual 142	com/tencent/aekit/plugin/core/IDetect:onModuleInstall	(Ljava/lang/String;Ljava/lang/String;)Z
    //   114: istore_1
    //   115: goto -38 -> 77
    //   118: astore_0
    //   119: aload_0
    //   120: invokestatic 132	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   123: iconst_0
    //   124: ireturn
    //   125: astore_0
    //   126: aload_0
    //   127: invokestatic 132	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   130: goto -7 -> 123
    //   133: astore_0
    //   134: aload_0
    //   135: invokestatic 132	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   138: goto -15 -> 123
    //   141: astore_0
    //   142: aload_0
    //   143: invokestatic 132	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   146: goto -23 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	paramClass	Class<? extends IDetect>
    //   76	39	1	bool	boolean
    //   7	101	2	localIDetect	IDetect
    //   37	72	3	str1	String
    //   53	57	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   0	70	118	java/lang/IllegalAccessException
    //   70	77	118	java/lang/IllegalAccessException
    //   81	105	118	java/lang/IllegalAccessException
    //   107	115	118	java/lang/IllegalAccessException
    //   0	70	125	java/lang/InstantiationException
    //   70	77	125	java/lang/InstantiationException
    //   81	105	125	java/lang/InstantiationException
    //   107	115	125	java/lang/InstantiationException
    //   0	70	133	java/lang/SecurityException
    //   70	77	133	java/lang/SecurityException
    //   81	105	133	java/lang/SecurityException
    //   107	115	133	java/lang/SecurityException
    //   0	70	141	java/lang/UnsatisfiedLinkError
    //   70	77	141	java/lang/UnsatisfiedLinkError
    //   81	105	141	java/lang/UnsatisfiedLinkError
    //   107	115	141	java/lang/UnsatisfiedLinkError
  }
  
  public static boolean reInstallModule(AEDetectorType paramAEDetectorType)
  {
    if ((!detectors_registered.containsKey(paramAEDetectorType.value)) || (detectors_installing.containsKey(paramAEDetectorType.value)) || (detectors_installed.containsKey(paramAEDetectorType.value))) {
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
        registeredSoPath.put(localIModule.getModuleType(), FeatureManager.getSoDir());
        registeredModelPath.put(localIModule.getModuleType(), FeatureManager.getResourceDir());
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
  
  public static boolean registerDetector(Class<? extends IDetect> paramClass, String paramString1, String paramString2)
  {
    try
    {
      IModule localIModule = (IModule)paramClass.newInstance();
      if (!detectors_registered.containsKey(localIModule.getModuleType()))
      {
        detectors_registered.put(localIModule.getModuleType(), paramClass);
        registeredSoPath.put(localIModule.getModuleType(), paramString1);
        registeredModelPath.put(localIModule.getModuleType(), paramString2);
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
      detectors_installing.remove(paramClass.getModuleType());
      detectors_registered.remove(paramClass.getModuleType());
      registeredSoPath.remove(paramClass.getModuleType());
      registeredModelPath.remove(paramClass.getModuleType());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aekit.api.standard.ai.AIManager
 * JD-Core Version:    0.7.0.1
 */