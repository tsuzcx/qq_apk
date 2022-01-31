package com.tencent.mobileqq.ar.ARPromotion;

import alud;
import amtj;
import com.tencent.mobileqq.ar.view.ARScanEntryView;

public class ARTransferDoorLogicManager$8
  implements Runnable
{
  public ARTransferDoorLogicManager$8(amtj paramamtj) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqArViewARScanEntryView == null) {
      return;
    }
    if (this.this$0.jdField_a_of_type_Int == 2)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqArViewARScanEntryView.d(false);
      this.this$0.jdField_a_of_type_ComTencentMobileqqArViewARScanEntryView.b(1);
      return;
    }
    this.this$0.a(true, alud.a(2131701141));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.8
 * JD-Core Version:    0.7.0.1
 */