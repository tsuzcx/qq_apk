package com.tencent.TMG.channel;

public class AVChannelManager
{
  public static final int IMChannelTypeIMSDK = 0;
  public static final int IMChannelTypeImplementExternal = 2;
  public static final int IMChannelTypeImplementInternal = 1;
  private static int channelType = 0;
  private static AVAppChannel sAppChannel = null;
  
  /* Error */
  public static AVAppChannel getAppChannel()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 18	com/tencent/TMG/channel/AVChannelManager:sAppChannel	Lcom/tencent/TMG/channel/AVAppChannel;
    //   8: ifnull +12 -> 20
    //   11: getstatic 18	com/tencent/TMG/channel/AVChannelManager:sAppChannel	Lcom/tencent/TMG/channel/AVAppChannel;
    //   14: astore_0
    //   15: ldc 2
    //   17: monitorexit
    //   18: aload_0
    //   19: areturn
    //   20: ldc 34
    //   22: invokestatic 40	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   25: astore_0
    //   26: aload_0
    //   27: ifnonnull +18 -> 45
    //   30: aconst_null
    //   31: astore_0
    //   32: goto -17 -> 15
    //   35: astore_0
    //   36: aload_0
    //   37: invokevirtual 43	java/lang/ClassNotFoundException:printStackTrace	()V
    //   40: aconst_null
    //   41: astore_0
    //   42: goto -16 -> 26
    //   45: aload_0
    //   46: invokevirtual 47	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   49: checkcast 49	com/tencent/TMG/channel/AVAppChannel
    //   52: astore_0
    //   53: aload_0
    //   54: putstatic 18	com/tencent/TMG/channel/AVChannelManager:sAppChannel	Lcom/tencent/TMG/channel/AVAppChannel;
    //   57: getstatic 18	com/tencent/TMG/channel/AVChannelManager:sAppChannel	Lcom/tencent/TMG/channel/AVAppChannel;
    //   60: astore_0
    //   61: goto -46 -> 15
    //   64: astore_0
    //   65: aload_0
    //   66: invokevirtual 50	java/lang/InstantiationException:printStackTrace	()V
    //   69: aload_1
    //   70: astore_0
    //   71: goto -18 -> 53
    //   74: astore_0
    //   75: ldc 2
    //   77: monitorexit
    //   78: aload_0
    //   79: athrow
    //   80: astore_0
    //   81: aload_0
    //   82: invokevirtual 51	java/lang/IllegalAccessException:printStackTrace	()V
    //   85: aload_1
    //   86: astore_0
    //   87: goto -34 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   14	18	0	localObject1	Object
    //   35	2	0	localClassNotFoundException	java.lang.ClassNotFoundException
    //   41	20	0	localAVAppChannel	AVAppChannel
    //   64	2	0	localInstantiationException	java.lang.InstantiationException
    //   70	1	0	localObject2	Object
    //   74	5	0	localObject3	Object
    //   80	2	0	localIllegalAccessException	java.lang.IllegalAccessException
    //   86	1	0	localObject4	Object
    //   1	85	1	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   20	26	35	java/lang/ClassNotFoundException
    //   45	53	64	java/lang/InstantiationException
    //   5	15	74	finally
    //   20	26	74	finally
    //   36	40	74	finally
    //   45	53	74	finally
    //   53	61	74	finally
    //   65	69	74	finally
    //   81	85	74	finally
    //   45	53	80	java/lang/IllegalAccessException
  }
  
  public static int getIMChannelType()
  {
    try
    {
      int i = channelType;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void setAppChannel(AVAppChannel paramAVAppChannel)
  {
    try
    {
      sAppChannel = paramAVAppChannel;
      return;
    }
    finally
    {
      paramAVAppChannel = finally;
      throw paramAVAppChannel;
    }
  }
  
  /* Error */
  public static void setIMChannelType(int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iload_0
    //   4: putstatic 20	com/tencent/TMG/channel/AVChannelManager:channelType	I
    //   7: getstatic 20	com/tencent/TMG/channel/AVChannelManager:channelType	I
    //   10: ifne +13 -> 23
    //   13: iconst_1
    //   14: istore_1
    //   15: iload_1
    //   16: invokestatic 63	com/tencent/TMG/logger/AVLoggerChooser:setUseImsdk	(Z)V
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: iconst_0
    //   24: istore_1
    //   25: goto -10 -> 15
    //   28: astore_2
    //   29: ldc 2
    //   31: monitorexit
    //   32: aload_2
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	paramInt	int
    //   14	11	1	bool	boolean
    //   28	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	13	28	finally
    //   15	19	28	finally
  }
  
  public static void setSsoHost(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.channel.AVChannelManager
 * JD-Core Version:    0.7.0.1
 */