package com.tencent.mobileqq.ar.ARPromotion;

import amtj;
import com.tencent.av.avgesture.AVGestureWrapper;
import com.tencent.qphone.base.util.QLog;

public class ARTransferDoorLogicManager$4
  implements Runnable
{
  public ARTransferDoorLogicManager$4(amtj paramamtj) {}
  
  public void run()
  {
    try
    {
      AVGestureWrapper.clearCache();
      this.this$0.i();
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        QLog.i(amtj.a, 2, "AVGestureWrapper.clearCache failed. UnsatisfiedLinkError. err = " + localUnsatisfiedLinkError.getMessage());
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.i(amtj.a, 2, "AVGestureWrapper.clearCache failed. err = " + localException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.4
 * JD-Core Version:    0.7.0.1
 */