package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import com.tencent.qphone.base.util.QLog;

class DrawClassifier$2
  implements TensorFlowlibManager.OnInitLibListener
{
  DrawClassifier$2(DrawClassifier paramDrawClassifier, DrawClassifier.OnClassifierInitListener paramOnClassifierInitListener) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DrawClassifier", 2, "TensorFlow init:" + paramBoolean);
    }
    if (paramBoolean) {
      DrawClassifier.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawClassifier, DrawClassifier.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawClassifier), this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawClassifier$OnClassifierInitListener, DrawClassifier.b(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawClassifier));
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawClassifier$OnClassifierInitListener == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawClassifier$OnClassifierInitListener.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawClassifier.2
 * JD-Core Version:    0.7.0.1
 */