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
    //   11: astore_2
    //   12: aload_2
    //   13: astore_3
    //   14: aload_2
    //   15: invokevirtual 38	java/io/InputStream:read	()I
    //   18: istore_1
    //   19: iload_1
    //   20: iconst_m1
    //   21: if_icmpeq +18 -> 39
    //   24: aload_2
    //   25: astore_3
    //   26: aload_0
    //   27: getfield 20	com/tencent/ilivesdk/giftservice/controller/GiftEffectResourceController$3:val$sb	Ljava/lang/StringBuilder;
    //   30: iload_1
    //   31: i2c
    //   32: invokevirtual 44	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: goto -24 -> 12
    //   39: aload_2
    //   40: astore_3
    //   41: aload_2
    //   42: invokevirtual 47	java/io/InputStream:close	()V
    //   45: aload_2
    //   46: astore_3
    //   47: aload_0
    //   48: getfield 16	com/tencent/ilivesdk/giftservice/controller/GiftEffectResourceController$3:this$0	Lcom/tencent/ilivesdk/giftservice/controller/GiftEffectResourceController;
    //   51: new 49	com/tencent/ilivesdk/giftservice/controller/GiftEffectResourceController$3$1
    //   54: dup
    //   55: aload_0
    //   56: invokespecial 52	com/tencent/ilivesdk/giftservice/controller/GiftEffectResourceController$3$1:<init>	(Lcom/tencent/ilivesdk/giftservice/controller/GiftEffectResourceController$3;)V
    //   59: lconst_0
    //   60: invokestatic 58	com/tencent/falco/utils/ThreadCenter:postDelayedUITask	(Lcom/tencent/falco/utils/ThreadCenter$HandlerKeyable;Ljava/lang/Runnable;J)V
    //   63: aload_2
    //   64: invokestatic 63	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   67: return
    //   68: astore 4
    //   70: goto +13 -> 83
    //   73: astore_2
    //   74: aconst_null
    //   75: astore_3
    //   76: goto +84 -> 160
    //   79: astore 4
    //   81: aconst_null
    //   82: astore_2
    //   83: aload_2
    //   84: astore_3
    //   85: aload_0
    //   86: getfield 16	com/tencent/ilivesdk/giftservice/controller/GiftEffectResourceController$3:this$0	Lcom/tencent/ilivesdk/giftservice/controller/GiftEffectResourceController;
    //   89: invokestatic 69	com/tencent/ilivesdk/giftservice/controller/GiftEffectResourceController:access$000	(Lcom/tencent/ilivesdk/giftservice/controller/GiftEffectResourceController;)Lcom/tencent/ilivesdk/giftservice/GiftService;
    //   92: invokevirtual 75	com/tencent/ilivesdk/giftservice/GiftService:getServiceAdapter	()Lcom/tencent/ilivesdk/giftservice_interface/GiftServiceAdapter;
    //   95: invokeinterface 81 1 0
    //   100: astore 5
    //   102: aload_2
    //   103: astore_3
    //   104: new 40	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   111: astore 6
    //   113: aload_2
    //   114: astore_3
    //   115: aload 6
    //   117: ldc 84
    //   119: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload_2
    //   124: astore_3
    //   125: aload 6
    //   127: aload 4
    //   129: invokevirtual 91	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   132: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload_2
    //   137: astore_3
    //   138: aload 5
    //   140: ldc 93
    //   142: aload 6
    //   144: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: iconst_0
    //   148: anewarray 4	java/lang/Object
    //   151: invokeinterface 102 4 0
    //   156: goto -93 -> 63
    //   159: astore_2
    //   160: aload_3
    //   161: invokestatic 63	com/tencent/falco/utils/IOUtil:close	(Ljava/io/Closeable;)V
    //   164: goto +5 -> 169
    //   167: aload_2
    //   168: athrow
    //   169: goto -2 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	3
    //   18	13	1	i	int
    //   11	53	2	localFileInputStream	java.io.FileInputStream
    //   73	1	2	localObject1	Object
    //   82	55	2	localObject2	Object
    //   159	9	2	localObject3	Object
    //   13	148	3	localObject4	Object
    //   68	1	4	localException1	java.lang.Exception
    //   79	49	4	localException2	java.lang.Exception
    //   100	39	5	localLogInterface	com.tencent.falco.base.libapi.log.LogInterface
    //   111	32	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   14	19	68	java/lang/Exception
    //   26	36	68	java/lang/Exception
    //   41	45	68	java/lang/Exception
    //   47	63	68	java/lang/Exception
    //   0	12	73	finally
    //   0	12	79	java/lang/Exception
    //   14	19	159	finally
    //   26	36	159	finally
    //   41	45	159	finally
    //   47	63	159	finally
    //   85	102	159	finally
    //   104	113	159	finally
    //   115	123	159	finally
    //   125	136	159	finally
    //   138	156	159	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.giftservice.controller.GiftEffectResourceController.3
 * JD-Core Version:    0.7.0.1
 */