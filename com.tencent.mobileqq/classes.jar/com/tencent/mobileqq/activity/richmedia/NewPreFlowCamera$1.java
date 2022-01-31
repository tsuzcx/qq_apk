package com.tencent.mobileqq.activity.richmedia;

import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;

class NewPreFlowCamera$1
  implements Runnable
{
  NewPreFlowCamera$1(NewPreFlowCamera paramNewPreFlowCamera, String paramString) {}
  
  public void run()
  {
    if (NewPreFlowCamera.a(this.this$0))
    {
      this.this$0.a.setProgress((NewPreFlowCamera.a(this.this$0) + NewPreFlowCamera.b(this.this$0)) / 2);
      if (QLog.isColorLevel()) {
        QLog.d("NewPreFlowCamera", 2, "" + this.a + " setProgress=" + (NewPreFlowCamera.a(this.this$0) + NewPreFlowCamera.b(this.this$0)) / 2);
      }
      NewPreFlowCamera.a(this.this$0);
    }
    do
    {
      return;
      this.this$0.a.setProgress(NewPreFlowCamera.a(this.this$0));
    } while (!QLog.isColorLevel());
    QLog.d("NewPreFlowCamera", 2, "" + this.a + " setProgress=" + NewPreFlowCamera.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewPreFlowCamera.1
 * JD-Core Version:    0.7.0.1
 */