package com.tencent.mobileqq.activity.qwallet.emoj;

import com.tencent.qphone.base.util.QLog;

class HandRecognizer$1
  implements Runnable
{
  HandRecognizer$1(HandRecognizer paramHandRecognizer) {}
  
  public void run()
  {
    if (this.this$0.box.confidence < 0.5D)
    {
      int i = this.this$0.doHandDetection(this.this$0.box);
      if (QLog.isColorLevel()) {
        QLog.i(HandRecognizer.TAG, 2, "doHandDetection return " + i + "---" + this.this$0.box.confidence);
      }
    }
    this.this$0.isDetecting = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.HandRecognizer.1
 * JD-Core Version:    0.7.0.1
 */