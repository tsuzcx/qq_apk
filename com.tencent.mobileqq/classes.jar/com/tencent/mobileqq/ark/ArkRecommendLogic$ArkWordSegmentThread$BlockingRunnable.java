package com.tencent.mobileqq.ark;

import android.os.Handler;

final class ArkRecommendLogic$ArkWordSegmentThread$BlockingRunnable
  implements Runnable
{
  private final ArkRecommendLogic.ArkWordSegmentThread jdField_a_of_type_ComTencentMobileqqArkArkRecommendLogic$ArkWordSegmentThread;
  private final Runnable jdField_a_of_type_JavaLangRunnable;
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public ArkRecommendLogic$ArkWordSegmentThread$BlockingRunnable(ArkRecommendLogic.ArkWordSegmentThread paramArkWordSegmentThread, Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
    this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendLogic$ArkWordSegmentThread = paramArkWordSegmentThread;
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendLogic$ArkWordSegmentThread.a().post(this);
      for (;;)
      {
        boolean bool = this.jdField_a_of_type_Boolean;
        if (bool) {
          break;
        }
        try
        {
          wait();
        }
        catch (InterruptedException localInterruptedException) {}
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 19	com/tencent/mobileqq/ark/ArkRecommendLogic$ArkWordSegmentThread$BlockingRunnable:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   4: invokeinterface 41 1 0
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_0
    //   12: iconst_1
    //   13: putfield 17	com/tencent/mobileqq/ark/ArkRecommendLogic$ArkWordSegmentThread$BlockingRunnable:jdField_a_of_type_Boolean	Z
    //   16: aload_0
    //   17: invokevirtual 44	java/lang/Object:notifyAll	()V
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: athrow
    //   28: astore_1
    //   29: aload_0
    //   30: monitorenter
    //   31: aload_0
    //   32: iconst_1
    //   33: putfield 17	com/tencent/mobileqq/ark/ArkRecommendLogic$ArkWordSegmentThread$BlockingRunnable:jdField_a_of_type_Boolean	Z
    //   36: aload_0
    //   37: invokevirtual 44	java/lang/Object:notifyAll	()V
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	BlockingRunnable
    //   23	4	1	localObject1	Object
    //   28	15	1	localObject2	Object
    //   44	4	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   11	22	23	finally
    //   24	26	23	finally
    //   0	9	28	finally
    //   31	42	44	finally
    //   45	47	44	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkRecommendLogic.ArkWordSegmentThread.BlockingRunnable
 * JD-Core Version:    0.7.0.1
 */