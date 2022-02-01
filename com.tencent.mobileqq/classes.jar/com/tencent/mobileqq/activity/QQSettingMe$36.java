package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;

class QQSettingMe$36
  extends ProfileCardObserver
{
  QQSettingMe$36(QQSettingMe paramQQSettingMe) {}
  
  public void onGetProfileCard(boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return;
      if ((paramBoolean) && (this.a.c) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && ((paramObject instanceof Card)) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(((Card)paramObject).uin)))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new QQSettingMe.36.1(this));
        ThreadManager.post(new QQSettingMe.36.2(this), 5, null, true);
        return;
      }
    } while ((!paramBoolean) || (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!(paramObject instanceof Card)) || (this.a.c) || (!this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(((Card)paramObject).uin)));
    ThreadManager.post(new QQSettingMe.36.3(this, (Card)paramObject), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.36
 * JD-Core Version:    0.7.0.1
 */