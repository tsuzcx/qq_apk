package com.tencent.mobileqq.activity;

import acgw;
import acgy;
import acgz;
import akih;
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
        akih localakih = (akih)localIterator.next();
        acgy localacgy = new acgy();
        localacgy.jdField_a_of_type_JavaLangString = localakih.jdField_a_of_type_JavaLangString;
        localacgy.jdField_a_of_type_Long = localakih.jdField_a_of_type_Long;
        this.jdField_a_of_type_ComTencentMobileqqActivityTroopGagActivity$2$1.a.a.jdField_a_of_type_JavaUtilList.add(localacgy);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityTroopGagActivity$2$1.a.a.jdField_a_of_type_Acgz.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopGagActivity.2.1.1
 * JD-Core Version:    0.7.0.1
 */