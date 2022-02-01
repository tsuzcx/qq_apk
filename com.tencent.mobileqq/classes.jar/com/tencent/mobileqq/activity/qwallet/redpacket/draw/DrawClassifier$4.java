package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import com.tencent.mobileqq.activity.aio.doodle.DoodleItem;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.qphone.base.util.QLog;

class DrawClassifier$4
  implements Runnable
{
  DrawClassifier$4(DrawClassifier paramDrawClassifier, DrawClassifier.OnRecogListener paramOnRecogListener, DoodleItem paramDoodleItem) {}
  
  public void run()
  {
    try
    {
      if (!DrawClassifier.a(this.this$0))
      {
        if (QLog.isColorLevel()) {
          QLog.e("DrawClassifier", 2, "not init ok or already close to recog");
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawClassifier$OnRecogListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawClassifier$OnRecogListener.a(false);
        }
      }
      long l = System.currentTimeMillis();
      boolean bool = DrawClassifier.a(this.this$0).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleItem, DrawClassifier.c(this.this$0), this.this$0.a, DrawClassifier.a(this.this$0), DrawClassifier.a(this.this$0));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawClassifier$OnRecogListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawClassifier$OnRecogListener.a(bool);
      }
      if (QLog.isColorLevel()) {
        QLog.i("DrawClassifier", 2, "recognize cost:" + (System.currentTimeMillis() - l));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      do
      {
        if (QLog.isColorLevel()) {
          QLog.e("DrawClassifier", 2, "recognition throwable:" + QWalletTools.a(localThrowable));
        }
        localThrowable.printStackTrace();
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawClassifier$OnRecogListener == null);
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawClassifier$OnRecogListener.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawClassifier.4
 * JD-Core Version:    0.7.0.1
 */