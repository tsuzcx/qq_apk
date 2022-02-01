package com.tencent.mobileqq.activity.springfestival.entry;

import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.springfestival.entry.model.BaseActivityData;
import com.tencent.mobileqq.activity.springfestival.entry.model.BreathLightData;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.mini.entry.desktop.DesktopChangeListener;
import com.tencent.mobileqq.portal.ConversationHongBaoV2;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class SpringFestivalTaskCallback$2
  implements DesktopChangeListener
{
  SpringFestivalTaskCallback$2(SpringFestivalTaskCallback paramSpringFestivalTaskCallback) {}
  
  public void onDesktopAccountChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onDesktopAccountChanged");
    }
  }
  
  public void onDesktopClosed()
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onDesktopClosed");
    }
    SpringFestivalTaskCallback.b(this.a, false);
    if (SpringFestivalTaskCallback.a(this.a))
    {
      if ((SpringFestivalTaskCallback.a(this.a) == null) || (SpringFestivalTaskCallback.a(this.a).breathLightData == null)) {
        break label136;
      }
      if (SpringFestivalTaskCallback.a(this.a).breathLightData.type != 1) {
        break label131;
      }
    }
    for (;;)
    {
      SpringFestivalTaskCallback.a(this.a).jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.a(bool);
      if (SpringFestivalTaskCallback.b(this.a))
      {
        ((SpringFestivalEntryManager)SpringFestivalTaskCallback.a(this.a).jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).c();
        SpringFestivalTaskCallback.c(this.a, false);
      }
      return;
      label131:
      bool = false;
      continue;
      label136:
      bool = false;
    }
  }
  
  public void onDesktopDestroy() {}
  
  public void onDesktopOpened()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onDesktopOpened");
    }
    SpringFestivalTaskCallback.a(this.a);
    SpringFestivalTaskCallback.b(this.a, true);
    if (SpringFestivalTaskCallback.a(this.a)) {
      SpringFestivalTaskCallback.a(this.a).jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.a();
    }
    if ((SpringFestivalTaskCallback.a(this.a) != null) && ((SpringFestivalTaskCallback.a(this.a).type == 1) || (SpringFestivalTaskCallback.a(this.a).type == 3)) && (SpringFestivalTaskCallback.a(this.a).jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.e()))
    {
      SpringFestivalTaskCallback.a(this.a).jdField_a_of_type_ComTencentMobileqqPortalConversationHongBaoV2.w();
      SpringFestivalEntryManager localSpringFestivalEntryManager = (SpringFestivalEntryManager)SpringFestivalTaskCallback.a(this.a).jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
      localSpringFestivalEntryManager.a().hasShowedMiniApp = true;
      localSpringFestivalEntryManager.a();
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "[onDesktopOpened]从 " + SpringFestivalTaskCallback.a(this.a).type + " 进入小程序 动态吊坠修改为静态");
      }
    }
  }
  
  public void onDesktopResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onDesktopResume");
    }
  }
  
  public void onStartDesktopOpenAnimation()
  {
    if (QLog.isColorLevel()) {
      QLog.d("2021_UI_SpringFestivalTaskCallback", 2, "onStartDesktopOpenAnimation ");
    }
    SpringFestivalTaskCallback.b(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalTaskCallback.2
 * JD-Core Version:    0.7.0.1
 */