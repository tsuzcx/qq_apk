package com.tencent.mobileqq.app;

public class ConfigHandler$10
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
    //   13: getfield 25	com/tencent/mobileqq/app/ConfigHandler$10:this$0	Lallq;
    //   16: getfield 31	allq:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   19: new 33	java/net/URL
    //   22: dup
    //   23: aload_0
    //   24: getfield 35	com/tencent/mobileqq/app/ConfigHandler$10:b	Ljava/lang/String;
    //   27: invokespecial 36	java/net/URL:<init>	(Ljava/lang/String;)V
    //   30: aload_1
    //   31: invokestatic 41	com/tencent/mobileqq/utils/HttpDownloadUtil:a	(Lcom/tencent/common/app/AppInterface;Ljava/net/URL;Ljava/io/File;)Z
    //   34: ifeq +16 -> 50
    //   37: aload_0
    //   38: getfield 25	com/tencent/mobileqq/app/ConfigHandler$10:this$0	Lallq;
    //   41: iconst_3
    //   42: iconst_1
    //   43: aload_0
    //   44: getfield 19	com/tencent/mobileqq/app/ConfigHandler$10:a	Ljava/lang/String;
    //   47: invokevirtual 45	allq:notifyUI	(IZLjava/lang/Object;)V
    //   50: aload_0
    //   51: getfield 25	com/tencent/mobileqq/app/ConfigHandler$10:this$0	Lallq;
    //   54: aload_0
    //   55: getfield 35	com/tencent/mobileqq/app/ConfigHandler$10:b	Ljava/lang/String;
    //   58: invokestatic 48	allq:a	(Lallq;Ljava/lang/String;)V
    //   61: return
    //   62: astore_1
    //   63: aload_0
    //   64: getfield 25	com/tencent/mobileqq/app/ConfigHandler$10:this$0	Lallq;
    //   67: aload_0
    //   68: getfield 35	com/tencent/mobileqq/app/ConfigHandler$10:b	Ljava/lang/String;
    //   71: invokestatic 48	allq:a	(Lallq;Ljava/lang/String;)V
    //   74: return
    //   75: astore_1
    //   76: aload_0
    //   77: getfield 25	com/tencent/mobileqq/app/ConfigHandler$10:this$0	Lallq;
    //   80: aload_0
    //   81: getfield 35	com/tencent/mobileqq/app/ConfigHandler$10:b	Ljava/lang/String;
    //   84: invokestatic 48	allq:a	(Lallq;Ljava/lang/String;)V
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	10
    //   11	20	1	localFile	java.io.File
    //   62	1	1	localException	java.lang.Exception
    //   75	13	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   12	50	62	java/lang/Exception
    //   12	50	75	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.10
 * JD-Core Version:    0.7.0.1
 */