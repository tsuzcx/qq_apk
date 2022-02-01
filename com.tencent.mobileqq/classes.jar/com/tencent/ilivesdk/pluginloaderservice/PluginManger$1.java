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
    //   0: ldc 31
    //   2: iconst_1
    //   3: anewarray 4	java/lang/Object
    //   6: dup
    //   7: iconst_0
    //   8: aload_0
    //   9: getfield 14	com/tencent/ilivesdk/pluginloaderservice/PluginManger$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   12: aastore
    //   13: invokestatic 37	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   16: astore 4
    //   18: aload 4
    //   20: invokestatic 43	com/tencent/ilivesdk/pluginloaderservice/report/DataReport:f	(Ljava/lang/String;)V
    //   23: aload_0
    //   24: getfield 16	com/tencent/ilivesdk/pluginloaderservice/PluginManger$1:jdField_a_of_type_ComTencentIlivesdkPluginloaderservicePlugin	Lcom/tencent/ilivesdk/pluginloaderservice/Plugin;
    //   27: invokestatic 48	com/tencent/ilivesdk/pluginloaderservice/PluginManger:a	(Lcom/tencent/ilivesdk/pluginloaderservice/Plugin;)Ljava/util/concurrent/Future;
    //   30: astore_1
    //   31: aload_1
    //   32: invokeinterface 54 1 0
    //   37: checkcast 56	com/tencent/ilivesdk/pluginloaderservice/interfaces/IPlugin
    //   40: astore_1
    //   41: aload_1
    //   42: astore_2
    //   43: aload 4
    //   45: astore_3
    //   46: aload_1
    //   47: ifnull +30 -> 77
    //   50: aload_1
    //   51: astore_2
    //   52: aload 4
    //   54: astore_3
    //   55: aload_1
    //   56: invokeinterface 59 1 0
    //   61: ifeq +16 -> 77
    //   64: aload_0
    //   65: getfield 16	com/tencent/ilivesdk/pluginloaderservice/PluginManger$1:jdField_a_of_type_ComTencentIlivesdkPluginloaderservicePlugin	Lcom/tencent/ilivesdk/pluginloaderservice/Plugin;
    //   68: aload_1
    //   69: invokevirtual 64	com/tencent/ilivesdk/pluginloaderservice/Plugin:a	(Lcom/tencent/ilivesdk/pluginloaderservice/interfaces/IPlugin;)V
    //   72: aload 4
    //   74: astore_3
    //   75: aload_1
    //   76: astore_2
    //   77: aload_0
    //   78: getfield 16	com/tencent/ilivesdk/pluginloaderservice/PluginManger$1:jdField_a_of_type_ComTencentIlivesdkPluginloaderservicePlugin	Lcom/tencent/ilivesdk/pluginloaderservice/Plugin;
    //   81: invokevirtual 65	com/tencent/ilivesdk/pluginloaderservice/Plugin:a	()Z
    //   84: ifne +32 -> 116
    //   87: aload_0
    //   88: getfield 14	com/tencent/ilivesdk/pluginloaderservice/PluginManger$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   91: invokestatic 67	com/tencent/ilivesdk/pluginloaderservice/PluginManger:a	(Ljava/lang/String;)V
    //   94: aload_3
    //   95: invokestatic 68	com/tencent/ilivesdk/pluginloaderservice/report/DataReport:a	(Ljava/lang/String;)V
    //   98: ldc 70
    //   100: ldc 72
    //   102: iconst_1
    //   103: anewarray 4	java/lang/Object
    //   106: dup
    //   107: iconst_0
    //   108: aload_0
    //   109: getfield 14	com/tencent/ilivesdk/pluginloaderservice/PluginManger$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   112: aastore
    //   113: invokestatic 78	com/tencent/ilivesdk/pluginloaderservice/utils/LogUtil:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: ldc 70
    //   118: ldc 80
    //   120: iconst_0
    //   121: anewarray 4	java/lang/Object
    //   124: invokestatic 83	com/tencent/ilivesdk/pluginloaderservice/utils/LogUtil:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: aload_0
    //   128: getfield 18	com/tencent/ilivesdk/pluginloaderservice/PluginManger$1:jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesPluginInstallListener	Lcom/tencent/ilivesdk/pluginloaderservice/interfaces/PluginInstallListener;
    //   131: ifnull +16 -> 147
    //   134: aload_0
    //   135: getfield 18	com/tencent/ilivesdk/pluginloaderservice/PluginManger$1:jdField_a_of_type_ComTencentIlivesdkPluginloaderserviceInterfacesPluginInstallListener	Lcom/tencent/ilivesdk/pluginloaderservice/interfaces/PluginInstallListener;
    //   138: aload_0
    //   139: getfield 16	com/tencent/ilivesdk/pluginloaderservice/PluginManger$1:jdField_a_of_type_ComTencentIlivesdkPluginloaderservicePlugin	Lcom/tencent/ilivesdk/pluginloaderservice/Plugin;
    //   142: invokeinterface 86 2 0
    //   147: ldc 80
    //   149: invokestatic 89	com/tencent/ilivesdk/pluginloaderservice/report/DataReport:m	(Ljava/lang/String;)V
    //   152: aload_2
    //   153: invokestatic 90	com/tencent/ilivesdk/pluginloaderservice/PluginManger:a	(Lcom/tencent/ilivesdk/pluginloaderservice/interfaces/IPlugin;)V
    //   156: return
    //   157: astore_2
    //   158: aconst_null
    //   159: astore_1
    //   160: ldc 92
    //   162: iconst_2
    //   163: anewarray 4	java/lang/Object
    //   166: dup
    //   167: iconst_0
    //   168: aload_0
    //   169: getfield 14	com/tencent/ilivesdk/pluginloaderservice/PluginManger$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   172: aastore
    //   173: dup
    //   174: iconst_1
    //   175: aload_2
    //   176: invokevirtual 96	java/util/concurrent/ExecutionException:getMessage	()Ljava/lang/String;
    //   179: aastore
    //   180: invokestatic 37	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   183: astore_3
    //   184: ldc 70
    //   186: aload_3
    //   187: iconst_0
    //   188: anewarray 4	java/lang/Object
    //   191: invokestatic 78	com/tencent/ilivesdk/pluginloaderservice/utils/LogUtil:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   194: aload_1
    //   195: astore_2
    //   196: goto -119 -> 77
    //   199: astore_2
    //   200: aconst_null
    //   201: astore_1
    //   202: ldc 98
    //   204: iconst_2
    //   205: anewarray 4	java/lang/Object
    //   208: dup
    //   209: iconst_0
    //   210: aload_0
    //   211: getfield 14	com/tencent/ilivesdk/pluginloaderservice/PluginManger$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   214: aastore
    //   215: dup
    //   216: iconst_1
    //   217: aload_2
    //   218: invokevirtual 99	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   221: aastore
    //   222: invokestatic 37	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   225: astore_3
    //   226: ldc 70
    //   228: aload_3
    //   229: iconst_0
    //   230: anewarray 4	java/lang/Object
    //   233: invokestatic 78	com/tencent/ilivesdk/pluginloaderservice/utils/LogUtil:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   236: aload_1
    //   237: astore_2
    //   238: goto -161 -> 77
    //   241: astore_2
    //   242: aconst_null
    //   243: astore_1
    //   244: ldc 101
    //   246: iconst_2
    //   247: anewarray 4	java/lang/Object
    //   250: dup
    //   251: iconst_0
    //   252: aload_0
    //   253: getfield 14	com/tencent/ilivesdk/pluginloaderservice/PluginManger$1:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   256: aastore
    //   257: dup
    //   258: iconst_1
    //   259: aload_2
    //   260: invokevirtual 102	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   263: aastore
    //   264: invokestatic 37	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   267: astore_3
    //   268: ldc 70
    //   270: aload_3
    //   271: iconst_0
    //   272: anewarray 4	java/lang/Object
    //   275: invokestatic 78	com/tencent/ilivesdk/pluginloaderservice/utils/LogUtil:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   278: aload_1
    //   279: astore_2
    //   280: goto -203 -> 77
    //   283: astore_2
    //   284: goto -40 -> 244
    //   287: astore_2
    //   288: goto -86 -> 202
    //   291: astore_2
    //   292: goto -132 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	this	1
    //   30	249	1	localObject1	Object
    //   42	111	2	localObject2	Object
    //   157	19	2	localExecutionException1	java.util.concurrent.ExecutionException
    //   195	1	2	localObject3	Object
    //   199	19	2	localInterruptedException1	java.lang.InterruptedException
    //   237	1	2	localObject4	Object
    //   241	19	2	localException1	java.lang.Exception
    //   279	1	2	localObject5	Object
    //   283	1	2	localException2	java.lang.Exception
    //   287	1	2	localInterruptedException2	java.lang.InterruptedException
    //   291	1	2	localExecutionException2	java.util.concurrent.ExecutionException
    //   45	226	3	str1	String
    //   16	57	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   31	41	157	java/util/concurrent/ExecutionException
    //   31	41	199	java/lang/InterruptedException
    //   31	41	241	java/lang/Exception
    //   55	72	283	java/lang/Exception
    //   55	72	287	java/lang/InterruptedException
    //   55	72	291	java/util/concurrent/ExecutionException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.pluginloaderservice.PluginManger.1
 * JD-Core Version:    0.7.0.1
 */