package com.tencent.mobileqq.activity.qwallet.preload;

import com.tencent.mobileqq.app.ThreadManager;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class PreloadFlowControlConfig
  implements Serializable
{
  public static final String CONFIG_NAME = "flow_config";
  private static Map<String, PreloadFlowControlConfig> a = new HashMap();
  private static final long serialVersionUID = 1L;
  private String mConfigPath;
  public int mDownloadStatus = -1;
  public long mNextCanReqTime;
  public long mNextRetryReqTime;
  public int mRetryDownloadTimes;
  public int mRetryReqTimes;
  public long mValidDownloadTime;
  
  public PreloadFlowControlConfig(String paramString)
  {
    this.mConfigPath = paramString;
  }
  
  public static String getConfigPath(String paramString, AppRuntime paramAppRuntime)
  {
    return PreloadManager.a(paramAppRuntime) + paramString + "flow_config";
  }
  
  /* Error */
  public static PreloadFlowControlConfig getFlowControlConfig(String paramString, AppRuntime paramAppRuntime)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 47	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   10: aload_0
    //   11: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: aload_1
    //   15: invokevirtual 70	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   18: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: astore_3
    //   25: getstatic 34	com/tencent/mobileqq/activity/qwallet/preload/PreloadFlowControlConfig:a	Ljava/util/Map;
    //   28: aload_3
    //   29: invokeinterface 76 2 0
    //   34: checkcast 2	com/tencent/mobileqq/activity/qwallet/preload/PreloadFlowControlConfig
    //   37: astore_2
    //   38: aload_2
    //   39: ifnull +10 -> 49
    //   42: aload_2
    //   43: astore_1
    //   44: ldc 2
    //   46: monitorexit
    //   47: aload_1
    //   48: areturn
    //   49: aload_0
    //   50: aload_1
    //   51: invokestatic 78	com/tencent/mobileqq/activity/qwallet/preload/PreloadFlowControlConfig:getConfigPath	(Ljava/lang/String;Lmqq/app/AppRuntime;)Ljava/lang/String;
    //   54: astore 4
    //   56: aload 4
    //   58: invokestatic 83	akgd:a	(Ljava/lang/String;)Ljava/lang/Object;
    //   61: checkcast 2	com/tencent/mobileqq/activity/qwallet/preload/PreloadFlowControlConfig
    //   64: astore_0
    //   65: aload_0
    //   66: astore_1
    //   67: aload_0
    //   68: ifnonnull +13 -> 81
    //   71: new 2	com/tencent/mobileqq/activity/qwallet/preload/PreloadFlowControlConfig
    //   74: dup
    //   75: aload 4
    //   77: invokespecial 85	com/tencent/mobileqq/activity/qwallet/preload/PreloadFlowControlConfig:<init>	(Ljava/lang/String;)V
    //   80: astore_1
    //   81: getstatic 34	com/tencent/mobileqq/activity/qwallet/preload/PreloadFlowControlConfig:a	Ljava/util/Map;
    //   84: aload_3
    //   85: aload_1
    //   86: invokeinterface 89 3 0
    //   91: pop
    //   92: goto -48 -> 44
    //   95: astore_0
    //   96: ldc 2
    //   98: monitorexit
    //   99: aload_0
    //   100: athrow
    //   101: astore_0
    //   102: aload_2
    //   103: astore_0
    //   104: goto -39 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	paramString	String
    //   0	107	1	paramAppRuntime	AppRuntime
    //   37	66	2	localPreloadFlowControlConfig	PreloadFlowControlConfig
    //   24	61	3	str1	String
    //   54	22	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   3	38	95	finally
    //   49	56	95	finally
    //   56	65	95	finally
    //   71	81	95	finally
    //   81	92	95	finally
    //   56	65	101	java/lang/Exception
  }
  
  public void saveConfig()
  {
    ThreadManager.getFileThreadHandler().post(new PreloadFlowControlConfig.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadFlowControlConfig
 * JD-Core Version:    0.7.0.1
 */