package com.tencent.ilivesdk.pluginloaderservice;

import com.tencent.ilivesdk.pluginloaderservice.interfaces.PluginInstallListener;

final class PluginManger$1
  implements Runnable
{
  PluginManger$1(String paramString, Plugin paramPlugin, PluginInstallListener paramPluginInstallListener) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 33
    //   2: iconst_1
    //   3: anewarray 4	java/lang/Object
    //   6: dup
    //   7: iconst_0
    //   8: aload_0
    //   9: getfield 16	com/tencent/ilivesdk/pluginloaderservice/PluginManger$1:a	Ljava/lang/String;
    //   12: aastore
    //   13: invokestatic 39	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   16: astore 4
    //   18: aload 4
    //   20: invokestatic 45	com/tencent/ilivesdk/pluginloaderservice/report/DataReport:f	(Ljava/lang/String;)V
    //   23: aload_0
    //   24: getfield 18	com/tencent/ilivesdk/pluginloaderservice/PluginManger$1:b	Lcom/tencent/ilivesdk/pluginloaderservice/Plugin;
    //   27: invokestatic 50	com/tencent/ilivesdk/pluginloaderservice/PluginManger:a	(Lcom/tencent/ilivesdk/pluginloaderservice/Plugin;)Ljava/util/concurrent/Future;
    //   30: astore_1
    //   31: aload_1
    //   32: invokeinterface 56 1 0
    //   37: checkcast 58	com/tencent/ilivesdk/pluginloaderservice/interfaces/IPlugin
    //   40: astore_1
    //   41: aload 4
    //   43: astore_2
    //   44: aload_1
    //   45: astore_3
    //   46: aload_1
    //   47: ifnull +168 -> 215
    //   50: aload 4
    //   52: astore_2
    //   53: aload_1
    //   54: astore_3
    //   55: aload_1
    //   56: invokeinterface 62 1 0
    //   61: ifeq +154 -> 215
    //   64: aload_0
    //   65: getfield 18	com/tencent/ilivesdk/pluginloaderservice/PluginManger$1:b	Lcom/tencent/ilivesdk/pluginloaderservice/Plugin;
    //   68: aload_1
    //   69: invokevirtual 67	com/tencent/ilivesdk/pluginloaderservice/Plugin:a	(Lcom/tencent/ilivesdk/pluginloaderservice/interfaces/IPlugin;)V
    //   72: aload 4
    //   74: astore_2
    //   75: aload_1
    //   76: astore_3
    //   77: goto +138 -> 215
    //   80: astore_2
    //   81: goto +14 -> 95
    //   84: astore_2
    //   85: goto +52 -> 137
    //   88: astore_2
    //   89: goto +90 -> 179
    //   92: astore_2
    //   93: aconst_null
    //   94: astore_1
    //   95: ldc 69
    //   97: iconst_2
    //   98: anewarray 4	java/lang/Object
    //   101: dup
    //   102: iconst_0
    //   103: aload_0
    //   104: getfield 16	com/tencent/ilivesdk/pluginloaderservice/PluginManger$1:a	Ljava/lang/String;
    //   107: aastore
    //   108: dup
    //   109: iconst_1
    //   110: aload_2
    //   111: invokevirtual 73	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   114: aastore
    //   115: invokestatic 39	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   118: astore_2
    //   119: ldc 75
    //   121: aload_2
    //   122: iconst_0
    //   123: anewarray 4	java/lang/Object
    //   126: invokestatic 80	com/tencent/ilivesdk/pluginloaderservice/utils/LogUtil:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   129: aload_1
    //   130: astore_3
    //   131: goto +84 -> 215
    //   134: astore_2
    //   135: aconst_null
    //   136: astore_1
    //   137: ldc 82
    //   139: iconst_2
    //   140: anewarray 4	java/lang/Object
    //   143: dup
    //   144: iconst_0
    //   145: aload_0
    //   146: getfield 16	com/tencent/ilivesdk/pluginloaderservice/PluginManger$1:a	Ljava/lang/String;
    //   149: aastore
    //   150: dup
    //   151: iconst_1
    //   152: aload_2
    //   153: invokevirtual 83	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   156: aastore
    //   157: invokestatic 39	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   160: astore_2
    //   161: ldc 75
    //   163: aload_2
    //   164: iconst_0
    //   165: anewarray 4	java/lang/Object
    //   168: invokestatic 80	com/tencent/ilivesdk/pluginloaderservice/utils/LogUtil:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   171: aload_1
    //   172: astore_3
    //   173: goto +42 -> 215
    //   176: astore_2
    //   177: aconst_null
    //   178: astore_1
    //   179: ldc 85
    //   181: iconst_2
    //   182: anewarray 4	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: aload_0
    //   188: getfield 16	com/tencent/ilivesdk/pluginloaderservice/PluginManger$1:a	Ljava/lang/String;
    //   191: aastore
    //   192: dup
    //   193: iconst_1
    //   194: aload_2
    //   195: invokevirtual 86	java/util/concurrent/ExecutionException:getMessage	()Ljava/lang/String;
    //   198: aastore
    //   199: invokestatic 39	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   202: astore_2
    //   203: ldc 75
    //   205: aload_2
    //   206: iconst_0
    //   207: anewarray 4	java/lang/Object
    //   210: invokestatic 80	com/tencent/ilivesdk/pluginloaderservice/utils/LogUtil:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   213: aload_1
    //   214: astore_3
    //   215: aload_0
    //   216: getfield 18	com/tencent/ilivesdk/pluginloaderservice/PluginManger$1:b	Lcom/tencent/ilivesdk/pluginloaderservice/Plugin;
    //   219: invokevirtual 87	com/tencent/ilivesdk/pluginloaderservice/Plugin:l	()Z
    //   222: ifne +32 -> 254
    //   225: aload_0
    //   226: getfield 16	com/tencent/ilivesdk/pluginloaderservice/PluginManger$1:a	Ljava/lang/String;
    //   229: invokestatic 89	com/tencent/ilivesdk/pluginloaderservice/PluginManger:a	(Ljava/lang/String;)V
    //   232: aload_2
    //   233: invokestatic 90	com/tencent/ilivesdk/pluginloaderservice/report/DataReport:a	(Ljava/lang/String;)V
    //   236: ldc 75
    //   238: ldc 92
    //   240: iconst_1
    //   241: anewarray 4	java/lang/Object
    //   244: dup
    //   245: iconst_0
    //   246: aload_0
    //   247: getfield 16	com/tencent/ilivesdk/pluginloaderservice/PluginManger$1:a	Ljava/lang/String;
    //   250: aastore
    //   251: invokestatic 80	com/tencent/ilivesdk/pluginloaderservice/utils/LogUtil:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   254: ldc 75
    //   256: ldc 94
    //   258: iconst_0
    //   259: anewarray 4	java/lang/Object
    //   262: invokestatic 96	com/tencent/ilivesdk/pluginloaderservice/utils/LogUtil:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   265: aload_0
    //   266: getfield 20	com/tencent/ilivesdk/pluginloaderservice/PluginManger$1:c	Lcom/tencent/ilivesdk/pluginloaderservice/interfaces/PluginInstallListener;
    //   269: astore_1
    //   270: aload_1
    //   271: ifnull +13 -> 284
    //   274: aload_1
    //   275: aload_0
    //   276: getfield 18	com/tencent/ilivesdk/pluginloaderservice/PluginManger$1:b	Lcom/tencent/ilivesdk/pluginloaderservice/Plugin;
    //   279: invokeinterface 99 2 0
    //   284: ldc 94
    //   286: invokestatic 102	com/tencent/ilivesdk/pluginloaderservice/report/DataReport:m	(Ljava/lang/String;)V
    //   289: aload_3
    //   290: invokestatic 103	com/tencent/ilivesdk/pluginloaderservice/PluginManger:a	(Lcom/tencent/ilivesdk/pluginloaderservice/interfaces/IPlugin;)V
    //   293: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	this	1
    //   30	245	1	localObject1	Object
    //   43	32	2	str1	String
    //   80	1	2	localException1	java.lang.Exception
    //   84	1	2	localInterruptedException1	java.lang.InterruptedException
    //   88	1	2	localExecutionException1	java.util.concurrent.ExecutionException
    //   92	19	2	localException2	java.lang.Exception
    //   118	4	2	str2	String
    //   134	19	2	localInterruptedException2	java.lang.InterruptedException
    //   160	4	2	str3	String
    //   176	19	2	localExecutionException2	java.util.concurrent.ExecutionException
    //   202	31	2	str4	String
    //   45	245	3	localObject2	Object
    //   16	57	4	str5	String
    // Exception table:
    //   from	to	target	type
    //   55	72	80	java/lang/Exception
    //   55	72	84	java/lang/InterruptedException
    //   55	72	88	java/util/concurrent/ExecutionException
    //   31	41	92	java/lang/Exception
    //   31	41	134	java/lang/InterruptedException
    //   31	41	176	java/util/concurrent/ExecutionException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.PluginManger.1
 * JD-Core Version:    0.7.0.1
 */