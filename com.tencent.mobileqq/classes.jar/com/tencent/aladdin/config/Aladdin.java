package com.tencent.aladdin.config;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.util.SparseArrayCompat;
import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.aladdin.config.network.AladdinConfigVersionManager;
import com.tencent.aladdin.config.network.AladdinRequestHandler;
import com.tencent.aladdin.config.network.AsyncTaskExecutor;
import com.tencent.aladdin.config.parse.AladdinConfigParser;
import com.tencent.aladdin.config.parse.SimpleObjectParser;
import com.tencent.aladdin.config.parse.SimpleParser;
import com.tencent.aladdin.config.utils.AladdinLogger;
import com.tencent.aladdin.config.utils.DeviceInfoUtils;
import com.tencent.aladdin.config.utils.Log;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Aladdin
{
  private static final AsyncTaskExecutor DEFAULT_EXECUTOR;
  private static final SimpleConfigHandler DEFAULT_SIMPLE_CONFIG_HANDLER;
  public static final AladdinConfigParser DEFAULT_SIMPLE_OBJECT_PARSER = new SimpleObjectParser(sBeanTypeMap);
  private static final AladdinConfigParser DEFAULT_SIMPLE_PARSER;
  private static String ROOT_DIR;
  private static final String TAG = "Aladdin";
  private static String sAppFlavorId;
  private static Integer sAppId;
  private static String sAppVersion;
  private static final Map<String, Class<?>> sBeanTypeMap;
  private static final SparseArrayCompat<SimpleConfigHandler> sConfigHandlerMap;
  private static final SparseArrayCompat<AladdinConfigParser> sConfigParserMap;
  private static AsyncTaskExecutor sExecutor;
  private static AladdinLogger sLogger;
  private static AladdinRequestHandler sRequestHandler;
  private static final Map<String, AladdinUserConfig> sUserConfigCache = new HashMap();
  private static String sUserId;
  
  static
  {
    DEFAULT_EXECUTOR = new Aladdin.1();
    sConfigParserMap = new SparseArrayCompat();
    DEFAULT_SIMPLE_PARSER = new SimpleParser();
    sConfigHandlerMap = new SparseArrayCompat();
    DEFAULT_SIMPLE_CONFIG_HANDLER = new SimpleConfigHandler();
    sBeanTypeMap = new HashMap();
  }
  
  private static void ensureExecutorNonNull()
  {
    if (sExecutor == null) {
      sExecutor = DEFAULT_EXECUTOR;
    }
  }
  
  @Deprecated
  public static AladdinConfig get(int paramInt)
  {
    return getConfig(paramInt);
  }
  
  public static String getAppFlavorId()
  {
    return sAppFlavorId;
  }
  
  public static Integer getAppId()
  {
    return sAppId;
  }
  
  public static String getAppVersion()
  {
    return sAppVersion;
  }
  
  static String getBasePath()
  {
    return withUserId(sUserId).getBasePath();
  }
  
  public static AladdinConfig getConfig(int paramInt)
  {
    return withUserId(sUserId).get(paramInt);
  }
  
  public static SimpleConfigHandler getConfigHandlerById(int paramInt)
  {
    synchronized (sConfigHandlerMap)
    {
      SimpleConfigHandler localSimpleConfigHandler = (SimpleConfigHandler)sConfigHandlerMap.get(paramInt);
      if (localSimpleConfigHandler == null)
      {
        localSimpleConfigHandler = DEFAULT_SIMPLE_CONFIG_HANDLER;
        return localSimpleConfigHandler;
      }
      return localSimpleConfigHandler;
    }
  }
  
  public static int[] getConfigIdList()
  {
    return withUserId(sUserId).getConfigIdList();
  }
  
  public static String getCurrentUserId()
  {
    return sUserId;
  }
  
  public static AladdinLogger getLogger()
  {
    return sLogger;
  }
  
  static AladdinConfigParser getParserById(int paramInt)
  {
    synchronized (sConfigParserMap)
    {
      AladdinConfigParser localAladdinConfigParser = (AladdinConfigParser)sConfigParserMap.get(paramInt);
      if (localAladdinConfigParser == null)
      {
        localAladdinConfigParser = DEFAULT_SIMPLE_PARSER;
        return localAladdinConfigParser;
      }
      return localAladdinConfigParser;
    }
  }
  
  public static AladdinConfigVersionManager getVersionManager()
  {
    return withUserId(sUserId).getVersionInfo();
  }
  
  public static void initialize(@NonNull Aladdin.InitParams paramInitParams)
  {
    if (!TextUtils.isEmpty(Aladdin.InitParams.access$100(paramInitParams)))
    {
      ROOT_DIR = Aladdin.InitParams.access$100(paramInitParams);
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Aladdin.InitParams.access$200(paramInitParams).getFilesDir().getAbsolutePath());
      localStringBuilder.append(File.separator);
      localStringBuilder.append("aladdin_configs");
      ROOT_DIR = localStringBuilder.toString();
    }
    if (Aladdin.InitParams.access$300(paramInitParams) != null) {
      sExecutor = Aladdin.InitParams.access$300(paramInitParams);
    } else {
      sExecutor = DEFAULT_EXECUTOR;
    }
    if (Aladdin.InitParams.access$400(paramInitParams) != null) {
      sAppId = Aladdin.InitParams.access$400(paramInitParams);
    } else {
      sAppId = Integer.valueOf(0);
    }
    if (Aladdin.InitParams.access$500(paramInitParams) != null) {
      sUserId = Aladdin.InitParams.access$500(paramInitParams);
    } else {
      sUserId = "0";
    }
    if (Aladdin.InitParams.access$600(paramInitParams) != null) {
      sAppFlavorId = Aladdin.InitParams.access$600(paramInitParams);
    } else {
      sAppFlavorId = "0";
    }
    sRequestHandler = Aladdin.InitParams.access$700(paramInitParams);
    sAppVersion = Aladdin.InitParams.access$800(paramInitParams);
    sLogger = Aladdin.InitParams.access$900(paramInitParams);
    Log.i("Aladdin", "initialize: GitHash=a0c9471");
    DeviceInfoUtils.initDisplayParams(Aladdin.InitParams.access$200(paramInitParams));
  }
  
  public static void registerBeanClass(String paramString, Class<?> paramClass)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("registerBeanClass: ");
    ((StringBuilder)???).append(paramString);
    Log.d("Aladdin", ((StringBuilder)???).toString());
    synchronized (sBeanTypeMap)
    {
      sBeanTypeMap.put(paramString, paramClass);
      return;
    }
  }
  
  public static void registerConfigHandler(int paramInt, @NonNull SimpleConfigHandler paramSimpleConfigHandler)
  {
    synchronized (sConfigHandlerMap)
    {
      sConfigHandlerMap.put(paramInt, paramSimpleConfigHandler);
      return;
    }
  }
  
  public static void registerConfigParser(int paramInt, @NonNull AladdinConfigParser paramAladdinConfigParser)
  {
    synchronized (sConfigParserMap)
    {
      sConfigParserMap.put(paramInt, paramAladdinConfigParser);
      return;
    }
  }
  
  public static void requestForUpdate(int[] paramArrayOfInt)
  {
    AladdinRequestHandler localAladdinRequestHandler = sRequestHandler;
    if (localAladdinRequestHandler != null)
    {
      localAladdinRequestHandler.requestForUpdate(paramArrayOfInt);
      return;
    }
    Log.e("Aladdin", "requestForUpdate: ", new IllegalStateException("sRequestHandler is null"));
  }
  
  private static AladdinUserConfig withUserId(String paramString)
  {
    Object localObject = (AladdinUserConfig)sUserConfigCache.get(paramString);
    if (localObject == null)
    {
      if ((ROOT_DIR == null) || (sExecutor == null) || (sRequestHandler == null))
      {
        localObject = new IllegalStateException("Aladdin.initialize() is not called!");
        if (!Log.isDebugVersion())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("ROOT_DIR=");
          localStringBuilder.append(ROOT_DIR);
          localStringBuilder.append(", sExecutor=");
          localStringBuilder.append(sExecutor);
          localStringBuilder.append(", sRequestHandler=");
          localStringBuilder.append(sRequestHandler);
          Log.e("Aladdin", localStringBuilder.toString(), (Throwable)localObject);
          ensureExecutorNonNull();
        }
      }
      else
      {
        localObject = new AladdinUserConfig(ROOT_DIR, paramString, sExecutor);
        sUserConfigCache.put(paramString, localObject);
        return localObject;
      }
      throw ((Throwable)localObject);
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aladdin.config.Aladdin
 * JD-Core Version:    0.7.0.1
 */