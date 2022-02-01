package com.tencent.mobileqq.activity.aio;

import aghm;

public class CustomizeStrategyFactory$SkinRedPacketStrategy$1
  implements Runnable
{
  public CustomizeStrategyFactory$SkinRedPacketStrategy$1(aghm paramaghm, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 30	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory:a	()Lcom/tencent/mobileqq/activity/aio/CustomizeStrategyFactory;
    //   3: getfield 33	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory:jdField_a_of_type_Boolean	Z
    //   6: ifeq +20 -> 26
    //   9: getstatic 36	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory:jdField_a_of_type_ArrayOfByte	[B
    //   12: astore_1
    //   13: aload_1
    //   14: monitorenter
    //   15: getstatic 36	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory:jdField_a_of_type_ArrayOfByte	[B
    //   18: ldc2_w 37
    //   21: invokevirtual 42	java/lang/Object:wait	(J)V
    //   24: aload_1
    //   25: monitorexit
    //   26: invokestatic 48	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +11 -> 40
    //   32: ldc 50
    //   34: iconst_2
    //   35: ldc 52
    //   37: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: aload_0
    //   41: getfield 14	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$SkinRedPacketStrategy$1:this$0	Laghm;
    //   44: getfield 61	aghm:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadManager;
    //   47: ifnull +13 -> 60
    //   50: aload_0
    //   51: getfield 14	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$SkinRedPacketStrategy$1:this$0	Laghm;
    //   54: getfield 64	aghm:jdField_a_of_type_Alao	Lalao;
    //   57: ifnonnull +27 -> 84
    //   60: invokestatic 30	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory:a	()Lcom/tencent/mobileqq/activity/aio/CustomizeStrategyFactory;
    //   63: aload_0
    //   64: getfield 16	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$SkinRedPacketStrategy$1:a	Lcom/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo;
    //   67: invokevirtual 67	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory:a	(Lcom/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo;)V
    //   70: return
    //   71: astore_2
    //   72: aload_1
    //   73: monitorexit
    //   74: aload_2
    //   75: athrow
    //   76: astore_1
    //   77: aload_1
    //   78: invokevirtual 70	java/lang/InterruptedException:printStackTrace	()V
    //   81: goto -55 -> 26
    //   84: aload_0
    //   85: getfield 14	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$SkinRedPacketStrategy$1:this$0	Laghm;
    //   88: aload_0
    //   89: getfield 14	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$SkinRedPacketStrategy$1:this$0	Laghm;
    //   92: getfield 61	aghm:jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager	Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadManager;
    //   95: aload_0
    //   96: getfield 14	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$SkinRedPacketStrategy$1:this$0	Laghm;
    //   99: getfield 64	aghm:jdField_a_of_type_Alao	Lalao;
    //   102: aload_0
    //   103: getfield 16	com/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$SkinRedPacketStrategy$1:a	Lcom/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo;
    //   106: invokestatic 73	aghm:a	(Laghm;Lcom/tencent/mobileqq/activity/qwallet/preload/PreloadManager;Lalao;Lcom/tencent/mobileqq/activity/aio/CustomizeStrategyFactory$RedPacketInfo;)V
    //   109: return
    //   110: astore_1
    //   111: aload_1
    //   112: invokevirtual 74	java/lang/Throwable:printStackTrace	()V
    //   115: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	1
    //   76	2	1	localInterruptedException	java.lang.InterruptedException
    //   110	2	1	localThrowable	java.lang.Throwable
    //   71	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	26	71	finally
    //   72	74	71	finally
    //   9	15	76	java/lang/InterruptedException
    //   74	76	76	java/lang/InterruptedException
    //   26	40	110	java/lang/Throwable
    //   40	60	110	java/lang/Throwable
    //   60	70	110	java/lang/Throwable
    //   84	109	110	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.SkinRedPacketStrategy.1
 * JD-Core Version:    0.7.0.1
 */