package com.tencent.mobileqq.app.utils;

import azqs;
import bctz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;

public final class BatchAddFriendData$1
  implements Runnable
{
  public BatchAddFriendData$1(int paramInt, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    String str1 = bctz.a(false, this.jdField_a_of_type_Int);
    Object localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    Object localObject1 = ((TroopManager)localObject2).b(this.jdField_a_of_type_JavaLangString);
    String str2;
    if (localObject1 != null)
    {
      if (this.jdField_a_of_type_Int != 1) {
        break label109;
      }
      ((TroopInfo)localObject1).wClickBAFTipCount += 1;
      ((TroopManager)localObject2).b((TroopInfo)localObject1);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      str2 = this.jdField_a_of_type_JavaLangString;
      if (((TroopInfo)localObject1).wInsertBAFTipCount != 1) {
        break label103;
      }
    }
    label103:
    for (localObject1 = "0";; localObject1 = "1")
    {
      azqs.b((QQAppInterface)localObject2, "dc00899", "Grp_addFrd", "", "Grp_AIO", str1, 0, 0, str2, (String)localObject1, "", "");
      return;
    }
    label109:
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_addFrd", "", "Grp_AIO", str1, 0, 0, this.jdField_a_of_type_JavaLangString, "0", Integer.toString(((TroopInfo)localObject1).wMemberNum), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.BatchAddFriendData.1
 * JD-Core Version:    0.7.0.1
 */