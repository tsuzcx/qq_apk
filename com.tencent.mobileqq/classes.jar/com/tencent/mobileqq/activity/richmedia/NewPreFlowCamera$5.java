package com.tencent.mobileqq.activity.richmedia;

import com.tencent.qphone.base.util.QLog;

class NewPreFlowCamera$5
  implements Runnable
{
  NewPreFlowCamera$5(NewPreFlowCamera paramNewPreFlowCamera, int paramInt) {}
  
  public void run()
  {
    NewPreFlowCamera.a(this.this$0, this.a);
    if (QLog.isColorLevel()) {
      QLog.d("NewPreFlowCamera", 2, "onDownloadProgress mGestureState=" + NewPreFlowCamera.b(this.this$0) + " mVideoState=" + NewPreFlowCamera.c(this.this$0) + "mFilterSoState=" + NewPreFlowCamera.d(this.this$0));
    }
    NewPreFlowCamera.a(this.this$0, "GestureDownloadProgress");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.NewPreFlowCamera.5
 * JD-Core Version:    0.7.0.1
 */