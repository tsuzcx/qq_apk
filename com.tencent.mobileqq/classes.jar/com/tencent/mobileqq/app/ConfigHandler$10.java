package com.tencent.mobileqq.app;

class ConfigHandler$10
  implements Runnable
{
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 17	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 19	com/tencent/mobileqq/app/ConfigHandler$10:a	Ljava/lang/String;
    //   8: invokespecial 23	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_1
    //   12: aload_0
    //   13: getfield 25	com/tencent/mobileqq/app/ConfigHandler$10:this$0	Lcom/tencent/mobileqq/app/ConfigHandler;
    //   16: getfield 31	com/tencent/mobileqq/app/ConfigHandler:c	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   19: new 33	java/net/URL
    //   22: dup
    //   23: aload_0
    //   24: getfield 35	com/tencent/mobileqq/app/ConfigHandler$10:b	Ljava/lang/String;
    //   27: invokespecial 36	java/net/URL:<init>	(Ljava/lang/String;)V
    //   30: aload_1
    //   31: invokestatic 42	com/tencent/mobileqq/utils/HttpDownloadUtil:download	(Lmqq/app/AppRuntime;Ljava/net/URL;Ljava/io/File;)Z
    //   34: ifeq +33 -> 67
    //   37: aload_0
    //   38: getfield 25	com/tencent/mobileqq/app/ConfigHandler$10:this$0	Lcom/tencent/mobileqq/app/ConfigHandler;
    //   41: iconst_3
    //   42: iconst_1
    //   43: aload_0
    //   44: getfield 19	com/tencent/mobileqq/app/ConfigHandler$10:a	Ljava/lang/String;
    //   47: invokevirtual 46	com/tencent/mobileqq/app/ConfigHandler:notifyUI	(IZLjava/lang/Object;)V
    //   50: goto +17 -> 67
    //   53: astore_1
    //   54: aload_0
    //   55: getfield 25	com/tencent/mobileqq/app/ConfigHandler$10:this$0	Lcom/tencent/mobileqq/app/ConfigHandler;
    //   58: aload_0
    //   59: getfield 35	com/tencent/mobileqq/app/ConfigHandler$10:b	Ljava/lang/String;
    //   62: invokestatic 49	com/tencent/mobileqq/app/ConfigHandler:a	(Lcom/tencent/mobileqq/app/ConfigHandler;Ljava/lang/String;)V
    //   65: aload_1
    //   66: athrow
    //   67: aload_0
    //   68: getfield 25	com/tencent/mobileqq/app/ConfigHandler$10:this$0	Lcom/tencent/mobileqq/app/ConfigHandler;
    //   71: aload_0
    //   72: getfield 35	com/tencent/mobileqq/app/ConfigHandler$10:b	Ljava/lang/String;
    //   75: invokestatic 49	com/tencent/mobileqq/app/ConfigHandler:a	(Lcom/tencent/mobileqq/app/ConfigHandler;Ljava/lang/String;)V
    //   78: return
    //   79: astore_1
    //   80: goto -13 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	10
    //   11	20	1	localFile	java.io.File
    //   53	13	1	localObject	Object
    //   79	1	1	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   12	50	53	finally
    //   12	50	79	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.10
 * JD-Core Version:    0.7.0.1
 */