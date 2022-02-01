package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import com.tencent.mobileqq.soload.SoLoadManager;

public class TensorFlowlibManager
{
  private static volatile TensorFlowlibManager jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawTensorFlowlibManager;
  private boolean jdField_a_of_type_Boolean = false;
  
  public static TensorFlowlibManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawTensorFlowlibManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawTensorFlowlibManager == null) {
        jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawTensorFlowlibManager = new TensorFlowlibManager();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawTensorFlowlibManager;
    }
    finally {}
  }
  
  public void a(TensorFlowlibManager.OnInitLibListener paramOnInitLibListener)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (paramOnInitLibListener != null) {
        paramOnInitLibListener.a(true);
      }
      return;
    }
    SoLoadManager.a().a("tensorflowlite_jni", new TensorFlowlibManager.1(this, paramOnInitLibListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.TensorFlowlibManager
 * JD-Core Version:    0.7.0.1
 */