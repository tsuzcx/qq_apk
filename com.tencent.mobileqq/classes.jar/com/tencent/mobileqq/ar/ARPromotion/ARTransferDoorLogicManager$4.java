package com.tencent.mobileqq.ar.ARPromotion;

import com.tencent.av.avgesture.AVGestureWrapper;
import com.tencent.qphone.base.util.QLog;

class ARTransferDoorLogicManager$4
  implements Runnable
{
  ARTransferDoorLogicManager$4(ARTransferDoorLogicManager paramARTransferDoorLogicManager) {}
  
  public void run()
  {
    try
    {
      
    }
    catch (Exception localException)
    {
      str = ARTransferDoorLogicManager.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("AVGestureWrapper.clearCache failed. err = ");
      localStringBuilder.append(localException.getMessage());
      QLog.i(str, 2, localStringBuilder.toString());
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      String str = ARTransferDoorLogicManager.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AVGestureWrapper.clearCache failed. UnsatisfiedLinkError. err = ");
      localStringBuilder.append(localUnsatisfiedLinkError.getMessage());
      QLog.i(str, 2, localStringBuilder.toString());
    }
    this.this$0.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.4
 * JD-Core Version:    0.7.0.1
 */