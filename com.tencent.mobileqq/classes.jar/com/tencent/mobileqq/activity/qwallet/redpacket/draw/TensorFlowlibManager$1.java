package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;

class TensorFlowlibManager$1
  implements OnLoadListener
{
  TensorFlowlibManager$1(TensorFlowlibManager paramTensorFlowlibManager, TensorFlowlibManager.OnInitLibListener paramOnInitLibListener) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    if (paramInt == 0)
    {
      TensorFlowlibManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawTensorFlowlibManager, true);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawTensorFlowlibManager$OnInitLibListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawTensorFlowlibManager$OnInitLibListener.a(true);
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawTensorFlowlibManager$OnInitLibListener == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawTensorFlowlibManager$OnInitLibListener.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.TensorFlowlibManager.1
 * JD-Core Version:    0.7.0.1
 */