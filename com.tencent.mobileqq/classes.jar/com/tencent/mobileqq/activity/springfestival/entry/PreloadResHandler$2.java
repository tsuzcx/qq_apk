package com.tencent.mobileqq.activity.springfestival.entry;

class PreloadResHandler$2
  implements Runnable
{
  PreloadResHandler$2(PreloadResHandler paramPreloadResHandler, boolean paramBoolean, String paramString, Object paramObject) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 31	java/util/ArrayList
    //   3: dup
    //   4: aload_0
    //   5: getfield 16	com/tencent/mobileqq/activity/springfestival/entry/PreloadResHandler$2:this$0	Lcom/tencent/mobileqq/activity/springfestival/entry/PreloadResHandler;
    //   8: getfield 36	com/tencent/mobileqq/activity/springfestival/entry/PreloadResHandler:a	Ljava/util/List;
    //   11: invokeinterface 42 1 0
    //   16: iconst_1
    //   17: iadd
    //   18: invokespecial 45	java/util/ArrayList:<init>	(I)V
    //   21: astore_2
    //   22: aload_0
    //   23: getfield 16	com/tencent/mobileqq/activity/springfestival/entry/PreloadResHandler$2:this$0	Lcom/tencent/mobileqq/activity/springfestival/entry/PreloadResHandler;
    //   26: getfield 36	com/tencent/mobileqq/activity/springfestival/entry/PreloadResHandler:a	Ljava/util/List;
    //   29: astore_1
    //   30: aload_1
    //   31: monitorenter
    //   32: aload_2
    //   33: aload_0
    //   34: getfield 16	com/tencent/mobileqq/activity/springfestival/entry/PreloadResHandler$2:this$0	Lcom/tencent/mobileqq/activity/springfestival/entry/PreloadResHandler;
    //   37: getfield 36	com/tencent/mobileqq/activity/springfestival/entry/PreloadResHandler:a	Ljava/util/List;
    //   40: invokeinterface 49 2 0
    //   45: pop
    //   46: aload_1
    //   47: monitorexit
    //   48: aload_2
    //   49: invokeinterface 53 1 0
    //   54: astore_1
    //   55: aload_1
    //   56: invokeinterface 59 1 0
    //   61: ifeq +66 -> 127
    //   64: aload_1
    //   65: invokeinterface 63 1 0
    //   70: checkcast 65	mqq/util/WeakReference
    //   73: invokevirtual 68	mqq/util/WeakReference:get	()Ljava/lang/Object;
    //   76: checkcast 70	com/tencent/mobileqq/activity/springfestival/entry/IPreloadRes$OnDownloadCallback
    //   79: astore_2
    //   80: aload_2
    //   81: ifnull -26 -> 55
    //   84: aload_2
    //   85: aload_0
    //   86: getfield 18	com/tencent/mobileqq/activity/springfestival/entry/PreloadResHandler$2:jdField_a_of_type_Boolean	Z
    //   89: aload_0
    //   90: getfield 20	com/tencent/mobileqq/activity/springfestival/entry/PreloadResHandler$2:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   93: aload_0
    //   94: getfield 22	com/tencent/mobileqq/activity/springfestival/entry/PreloadResHandler$2:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   97: invokeinterface 73 4 0
    //   102: goto -47 -> 55
    //   105: astore_1
    //   106: bipush 110
    //   108: aload_1
    //   109: iconst_0
    //   110: anewarray 75	java/lang/String
    //   113: invokestatic 80	com/tencent/mobileqq/activity/springfestival/report/SpringHbMonitorReporter:a	(ILjava/lang/Throwable;[Ljava/lang/String;)V
    //   116: ldc 82
    //   118: iconst_1
    //   119: aload_1
    //   120: invokevirtual 86	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   123: aload_1
    //   124: invokestatic 92	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   127: return
    //   128: astore_2
    //   129: aload_1
    //   130: monitorexit
    //   131: aload_2
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	2
    //   105	25	1	localException	java.lang.Exception
    //   21	64	2	localObject2	Object
    //   128	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   0	32	105	java/lang/Exception
    //   48	55	105	java/lang/Exception
    //   55	80	105	java/lang/Exception
    //   84	102	105	java/lang/Exception
    //   131	133	105	java/lang/Exception
    //   32	48	128	finally
    //   129	131	128	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.PreloadResHandler.2
 * JD-Core Version:    0.7.0.1
 */