package com.tencent.mobileqq.activity;

import afsk;
import afsm;
import afsn;
import aojo;
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
        aojo localaojo = (aojo)localIterator.next();
        afsm localafsm = new afsm();
        localafsm.jdField_a_of_type_JavaLangString = localaojo.jdField_a_of_type_JavaLangString;
        localafsm.jdField_a_of_type_Long = localaojo.jdField_a_of_type_Long;
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopGagActivity$2$1.a.a.jdField_a_of_type_JavaUtilList.add(localafsm);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopGagActivity$2$1.a.a.jdField_a_of_type_Afsn.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopGagActivity.2.1.1
 * JD-Core Version:    0.7.0.1
 */