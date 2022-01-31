package com.tencent.mobileqq.activity.selectmember;

import android.text.TextUtils;
import axqw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopMemberInfo;

final class TroopAddFrdsInnerFrame$6
  implements Runnable
{
  TroopAddFrdsInnerFrame$6(boolean paramBoolean, QQAppInterface paramQQAppInterface, TroopMemberInfo paramTroopMemberInfo) {}
  
  public void run()
  {
    String str2;
    QQAppInterface localQQAppInterface;
    String str3;
    String str1;
    if (this.jdField_a_of_type_Boolean)
    {
      str2 = "multiMode_add";
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      str3 = this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.troopuin;
      if (!this.jdField_a_of_type_Boolean) {
        break label63;
      }
      str1 = "1";
    }
    for (;;)
    {
      axqw.b(localQQAppInterface, "dc00899", "Grp_addFrd", "", "frd_select", str2, 0, 0, str3, str1, "", "");
      return;
      str2 = "singleMode_add";
      break;
      label63:
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo.recommendRemark)) {
        str1 = "0";
      } else {
        str1 = "1";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopAddFrdsInnerFrame.6
 * JD-Core Version:    0.7.0.1
 */