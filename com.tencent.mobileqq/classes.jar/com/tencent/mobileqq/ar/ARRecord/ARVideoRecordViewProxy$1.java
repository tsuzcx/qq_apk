package com.tencent.mobileqq.ar.ARRecord;

import android.view.View;
import aotl;
import com.tencent.qphone.base.util.QLog;

public class ARVideoRecordViewProxy$1
  implements Runnable
{
  public ARVideoRecordViewProxy$1(aotl paramaotl) {}
  
  public void run()
  {
    if (aotl.a(this.this$0) == null) {}
    do
    {
      return;
      aotl.a(this.this$0).setVisibility(8);
      aotl.a(this.this$0).clearAnimation();
    } while (!QLog.isColorLevel());
    QLog.i("ARVideoRecordViewProxy", 2, "ARButtonTips resetToInnerTipsStatus stop animation");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewProxy.1
 * JD-Core Version:    0.7.0.1
 */