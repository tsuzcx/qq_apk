package com.tencent.biz.qqstory.settings;

import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.Switch;

class QQStoryShieldActivity$1
  extends QQStoryObserver
{
  QQStoryShieldActivity$1(QQStoryShieldActivity paramQQStoryShieldActivity) {}
  
  public void a(boolean paramBoolean, QQStoryUserInfo paramQQStoryUserInfo)
  {
    QQStoryShieldActivity.a(this.a);
    if ((paramBoolean) && (paramQQStoryUserInfo != null))
    {
      this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(null);
      this.a.b.setOnCheckedChangeListener(null);
      Switch localSwitch = this.a.jdField_a_of_type_ComTencentWidgetSwitch;
      int i = paramQQStoryUserInfo.isAllowed;
      boolean bool = false;
      if (i == 1) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      localSwitch.setChecked(paramBoolean);
      localSwitch = this.a.b;
      paramBoolean = bool;
      if (paramQQStoryUserInfo.isInterested == 1) {
        paramBoolean = true;
      }
      localSwitch.setChecked(paramBoolean);
      this.a.jdField_a_of_type_ComTencentWidgetSwitch.setOnCheckedChangeListener(this.a);
      this.a.b.setOnCheckedChangeListener(this.a);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressNotifier.b();
    if (paramBoolean1) {
      return;
    }
    QQToast.a(this.a, 2131694712, 0).b(this.a.getTitleBarHeight());
    if (paramBoolean3)
    {
      this.a.jdField_a_of_type_ComTencentWidgetSwitch.setChecked(this.a.jdField_a_of_type_ComTencentWidgetSwitch.isChecked() ^ true);
      return;
    }
    this.a.b.setChecked(this.a.b.isChecked() ^ true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryShieldActivity.1
 * JD-Core Version:    0.7.0.1
 */