package com.tencent.mobileqq.ar.ARRecord;

import amuu;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class ARVideoRecordViewProxy$1
  implements Runnable
{
  public ARVideoRecordViewProxy$1(amuu paramamuu) {}
  
  public void run()
  {
    if (amuu.a(this.this$0) == null) {}
    do
    {
      return;
      amuu.a(this.this$0).setVisibility(8);
      amuu.a(this.this$0).clearAnimation();
    } while (!QLog.isColorLevel());
    QLog.i("ARVideoRecordViewProxy", 2, "ARButtonTips resetToInnerTipsStatus stop animation");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewProxy.1
 * JD-Core Version:    0.7.0.1
 */