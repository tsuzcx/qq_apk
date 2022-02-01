package com.tencent.mobileqq.activity.ark;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ark.ArkViewImplement.ArkViewInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ArkInputCallback$1
  implements View.OnClickListener
{
  ArkInputCallback$1(ArkInputCallback paramArkInputCallback, int paramInt, ArkViewImplement.ArkViewInterface paramArkViewInterface) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    int j = this.jdField_a_of_type_Int;
    if (j == 2)
    {
      if (i == 0) {
        this.jdField_a_of_type_ComTencentArkArkViewImplement$ArkViewInterface.doInputCommand(5);
      } else if (i == 1) {
        this.jdField_a_of_type_ComTencentArkArkViewImplement$ArkViewInterface.doInputCommand(4);
      } else if (i == 2) {
        this.jdField_a_of_type_ComTencentArkArkViewImplement$ArkViewInterface.doInputCommand(3);
      }
    }
    else if (j == 1)
    {
      if (i == 0) {
        this.jdField_a_of_type_ComTencentArkArkViewImplement$ArkViewInterface.doInputCommand(1);
      } else if (i == 1) {
        this.jdField_a_of_type_ComTencentArkArkViewImplement$ArkViewInterface.doInputCommand(2);
      } else if (i == 2) {
        this.jdField_a_of_type_ComTencentArkArkViewImplement$ArkViewInterface.doInputCommand(3);
      }
    }
    else {
      this.jdField_a_of_type_ComTencentArkArkViewImplement$ArkViewInterface.doInputCommand(3);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ark.ArkInputCallback.1
 * JD-Core Version:    0.7.0.1
 */