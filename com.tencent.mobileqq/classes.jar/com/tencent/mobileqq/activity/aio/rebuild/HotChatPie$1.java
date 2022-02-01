package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.qphone.base.util.QLog;

class HotChatPie$1
  extends TroopBusinessObserver
{
  HotChatPie$1(HotChatPie paramHotChatPie) {}
  
  public void onBuluoHotChatRedPointComing(boolean paramBoolean, String paramString)
  {
    if ((this.a.q != 2) && (paramBoolean) && (this.a.jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton != null) && (this.a.a != null) && (this.a.a.troopUin.equals(paramString)) && (this.a.a.hasPostRedPoint())) {
      this.a.jdField_b_of_type_ComTencentMobileqqTroopWidgetRedDotRadioButton.a(true);
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_b_of_type_JavaLangString + "Q.hotchat.aio_post_red_point", 2, "onBuluoHotChatRedPointComing, troopUin:" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.1
 * JD-Core Version:    0.7.0.1
 */