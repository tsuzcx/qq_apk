package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;

class TroopManager$TmiCallBackForTroopMemberNewLevel
  implements TroopManager.ITroopMemberInfoCallBack
{
  public int a;
  public String a;
  public String b;
  
  private TroopManager$TmiCallBackForTroopMemberNewLevel(TroopManager paramTroopManager) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    if ((paramTroopMemberInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.b)))
    {
      if (!this.jdField_a_of_type_JavaLangString.equals(paramTroopMemberInfo.memberuin)) {
        return;
      }
      paramTroopMemberInfo.newRealLevel = this.jdField_a_of_type_Int;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("newRealLevel:");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append(",troopUin : ");
        localStringBuilder.append(this.b);
        localStringBuilder.append(",memberUin");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        QLog.d("Q.contacttab.", 2, localStringBuilder.toString());
      }
      if (paramTroopMemberInfo.getStatus() == 1000) {
        this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a(this.b, this.jdField_a_of_type_JavaLangString, paramTroopMemberInfo);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.b(this.b, this.jdField_a_of_type_JavaLangString, paramTroopMemberInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopManager.TmiCallBackForTroopMemberNewLevel
 * JD-Core Version:    0.7.0.1
 */