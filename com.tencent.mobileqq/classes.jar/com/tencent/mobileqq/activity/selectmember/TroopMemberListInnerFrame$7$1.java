package com.tencent.mobileqq.activity.selectmember;

import aigh;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class TroopMemberListInnerFrame$7$1
  implements Runnable
{
  public TroopMemberListInnerFrame$7$1(aigh paramaigh, List paramList) {}
  
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
        QLog.d("TroopMemberListInnerFrame", 2, i);
        this.jdField_a_of_type_Aigh.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.getSharedPreferences("last_update_time" + this.jdField_a_of_type_Aigh.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 4).edit().putLong("key_last_update_time" + this.jdField_a_of_type_Aigh.a.b, System.currentTimeMillis()).commit();
        TroopMemberListInnerFrame.a(this.jdField_a_of_type_Aigh.a, this.jdField_a_of_type_Aigh.a.b, this.jdField_a_of_type_JavaUtilList);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopMemberListInnerFrame", 2, "onUpdateTroopGetMemberList:" + localException.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame.7.1
 * JD-Core Version:    0.7.0.1
 */