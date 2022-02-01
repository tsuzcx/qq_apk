package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.troop.troopgag.data.MemberGagInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TroopGagActivity$2$1$1
  implements Runnable
{
  TroopGagActivity$2$1$1(TroopGagActivity.2.1 param1, ArrayList paramArrayList) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopGagActivity$2$1.a.a.jdField_a_of_type_JavaUtilList.clear();
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        MemberGagInfo localMemberGagInfo = (MemberGagInfo)((Iterator)localObject).next();
        TroopGagActivity.GagMemInfo localGagMemInfo = new TroopGagActivity.GagMemInfo();
        localGagMemInfo.jdField_a_of_type_JavaLangString = localMemberGagInfo.jdField_a_of_type_JavaLangString;
        localGagMemInfo.jdField_a_of_type_Long = localMemberGagInfo.jdField_a_of_type_Long;
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopGagActivity$2$1.a.a.jdField_a_of_type_JavaUtilList.add(localGagMemInfo);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopGagActivity$2$1.a.a.jdField_a_of_type_ComTencentMobileqqActivityTroopGagActivity$TroopGagMemberAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopGagActivity.2.1.1
 * JD-Core Version:    0.7.0.1
 */