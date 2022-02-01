package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;

class MultiVideoCtrlLayerUI4Discussion$AutoCheckVideoRunnable
  implements Runnable
{
  MultiVideoCtrlLayerUI4Discussion$AutoCheckVideoRunnable(MultiVideoCtrlLayerUI4Discussion paramMultiVideoCtrlLayerUI4Discussion) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.d, 2, "AutoCheckVideoRunnable");
    }
    if (this.this$0.a != null) {
      this.this$0.a.a().ab = true;
    }
    this.this$0.x();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion.AutoCheckVideoRunnable
 * JD-Core Version:    0.7.0.1
 */