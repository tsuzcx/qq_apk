package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie;
import com.tencent.mobileqq.troop.widget.RobotPanelLayoutBase.GetListDataCallback;

class TroopRobotHelper$2
  implements RobotPanelLayoutBase.GetListDataCallback
{
  TroopRobotHelper$2(TroopRobotHelper paramTroopRobotHelper, String paramString) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_JavaLangString.equals(paramString)))
    {
      ((BaseTroopChatPie)TroopRobotHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperTroopRobotHelper)).R = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperTroopRobotHelper.a(true);
      return;
    }
    ((BaseTroopChatPie)TroopRobotHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperTroopRobotHelper)).R = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperTroopRobotHelper.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopRobotHelper.2
 * JD-Core Version:    0.7.0.1
 */