package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.TroopManager.MemberGagInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TroopGagActivity$2$1$1
  implements Runnable
{
  TroopGagActivity$2$1$1(TroopGagActivity.2.1 param1, ArrayList paramArrayList) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopGagActivity$2$1.a.a.jdField_a_of_type_JavaUtilList.clear();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        TroopManager.MemberGagInfo localMemberGagInfo = (TroopManager.MemberGagInfo)localIterator.next();
        TroopGagActivity.GagMemInfo localGagMemInfo = new TroopGagActivity.GagMemInfo();
        localGagMemInfo.jdField_a_of_type_JavaLangString = localMemberGagInfo.jdField_a_of_type_JavaLangString;
        localGagMemInfo.jdField_a_of_type_Long = localMemberGagInfo.jdField_a_of_type_Long;
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopGagActivity$2$1.a.a.jdField_a_of_type_JavaUtilList.add(localGagMemInfo);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopGagActivity$2$1.a.a.jdField_a_of_type_ComTencentMobileqqActivityTroopGagActivity$TroopGagMemberAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopGagActivity.2.1.1
 * JD-Core Version:    0.7.0.1
 */