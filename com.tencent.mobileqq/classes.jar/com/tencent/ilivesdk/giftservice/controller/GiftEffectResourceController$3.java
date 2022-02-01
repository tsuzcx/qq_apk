package com.tencent.ilivesdk.giftservice.controller;

import java.io.File;

class GiftEffectResourceController$3
  implements Runnable
{
  GiftEffectResourceController$3(GiftEffectResourceController paramGiftEffectResourceController, File paramFile, StringBuilder paramStringBuilder) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: new 29	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: getfield 18	com/tencent/ilivesdk/giftservice/controller/GiftEffectResourceController$3:val$file	Ljava/io/File;
    //   8: invokespecial 32	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   11: astore_3
    //   12: aload_3
    //   13: astore_2
    //   14: aload_3
    //   15: invokevirtual 38	java/io/InputStream:read	()I
    //   18: istore_1
    //   19: iload_1
    //   20: iconst_m1
    //   21: if_icmpeq +76 -> 97
    //   24: aload_3
    //   25: astore_2
    //   26: aload_0
    //   27: getfield 20	com/tencent/ilivesdk/giftservice/controller/GiftEffectResourceController$3:val$sb	Ljava/lang/StringBuilder;
    //   30: iload_1
    //   31: i2c
    //   32: invokevirtual 44	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: goto -24 -> 12
    //   39: astore 4
    //   41: aload_3
    //   42: astore_2
    //   43: aload_0
    //   44: getfield 16	com/tencent/ilivesdk/giftservice/controller/GiftEffectResourceController$3:this$0	Lcom/tencent/ilivesdk/giftservice/controller/GiftEffectResourceController;
    //   47: invokestatic 50	com/tencent/ilivesdk/giftservice/controller/GiftEffectResourceController:access$000	(Lcom/tencent/ilivesdk/giftservice/controller/GiftEffectResourceController;)Lcom/tencent/ilivesdk/giftservice/GiftService;
    //   50: invokevirtual 56	com/tencent/ilivesdk/giftservice/GiftService:getServiceAdapter	()Lcom/tencent/ilivesdk/giftservice_interface/GiftServiceAdapter;
    //   53: invokeinterface 62 1 0
    //   58: ldc 64
    //   60: new 40	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   67: ldc 67
    //   69: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload 4
    //   74: invokevirtual 74	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   77: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: iconst_0
    //   84: anewarray 4	java/lang/Object
    //   87: invokeinterface 83 4 0
    //   92: aload_3
    //   93: invokestatic 89	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   96: return
    //   97: aload_3
    //   98: astore_2
    //   99: aload_3
    //   100: invokevirtual 91	java/io/InputStream:close	()V
    //   103: aload_3
    //   104: astore_2
    //   105: aload_0
    //   106: getfield 16	com/tencent/ilivesdk/giftservice/controller/GiftEffectResourceController$3:this$0	Lcom/tencent/ilivesdk/giftservice/controller/GiftEffectResourceController;
    //   109: new 93	com/tencent/ilivesdk/giftservice/controller/GiftEffectResourceController$3$1
    //   112: dup
    //   113: aload_0
    //   114: invokespecial 96	com/tencent/ilivesdk/giftservice/controller/GiftEffectResourceController$3$1:<init>	(Lcom/tencent/ilivesdk/giftservice/controller/GiftEffectResourceController$3;)V
    //   117: lconst_0
    //   118: invokestatic 102	com/tencent/falco/utils/ThreadCenter:postDelayedUITask	(Lcom/tencent/falco/utils/ThreadCenter$HandlerKeyable;Ljava/lang/Runnable;J)V
    //   121: aload_3
    //   122: invokestatic 89	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   125: return
    //   126: astore_3
    //   127: aconst_null
    //   128: astore_2
    //   129: aload_2
    //   130: invokestatic 89	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   133: aload_3
    //   134: athrow
    //   135: astore_3
    //   136: goto -7 -> 129
    //   139: astore 4
    //   141: aconst_null
    //   142: astore_3
    //   143: goto -102 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	3
    //   18	13	1	i	int
    //   13	117	2	localFileInputStream1	java.io.FileInputStream
    //   11	111	3	localFileInputStream2	java.io.FileInputStream
    //   126	8	3	localObject1	Object
    //   135	1	3	localObject2	Object
    //   142	1	3	localObject3	Object
    //   39	34	4	localException1	java.lang.Exception
    //   139	1	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   14	19	39	java/lang/Exception
    //   26	36	39	java/lang/Exception
    //   99	103	39	java/lang/Exception
    //   105	121	39	java/lang/Exception
    //   0	12	126	finally
    //   14	19	135	finally
    //   26	36	135	finally
    //   43	92	135	finally
    //   99	103	135	finally
    //   105	121	135	finally
    //   0	12	139	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.giftservice.controller.GiftEffectResourceController.3
 * JD-Core Version:    0.7.0.1
 */