package com.tencent.mobileqq.activity.selectmember;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class TroopAddFrdsInnerFrame$2$1
  implements Runnable
{
  TroopAddFrdsInnerFrame$2$1(TroopAddFrdsInnerFrame.2 param2, List paramList) {}
  
  public void run()
  {
    try
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("onUpdateTroopGetMemberList:");
        if (this.jdField_a_of_type_JavaUtilList != null) {
          break label159;
        }
      }
      label159:
      for (int i = 0;; i = this.jdField_a_of_type_JavaUtilList.size())
      {
        QLog.d("TroopAddFrdsInnerFrame", 2, i);
        this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame$2.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getSharedPreferences("last_update_time" + this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame$2.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 4).edit().putLong("key_last_update_time" + this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame$2.a.b, System.currentTimeMillis()).commit();
        TroopAddFrdsInnerFrame.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame$2.a, this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberTroopAddFrdsInnerFrame$2.a.b, this.jdField_a_of_type_JavaUtilList);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAddFrdsInnerFrame", 2, "onUpdateTroopGetMemberList:" + localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopAddFrdsInnerFrame.2.1
 * JD-Core Version:    0.7.0.1
 */