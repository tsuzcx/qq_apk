package com.tencent.av.business.manager;

import java.util.ArrayList;

class Checker$ItemRecord
{
  int jdField_a_of_type_Int = 0;
  final EffectConfigBase.ItemBase jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase$ItemBase;
  String jdField_a_of_type_JavaLangString;
  final ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList(0);
  boolean jdField_a_of_type_Boolean = false;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  
  Checker$ItemRecord(EffectConfigBase.ItemBase paramItemBase, ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase$ItemBase = paramItemBase;
    this.jdField_a_of_type_Int = 0;
    if (paramArrayList != null) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Int >= 3;
  }
  
  public String toString()
  {
    return "ItemRecord{" + this.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase$ItemBase + "," + this.jdField_a_of_type_Int + "," + this.jdField_a_of_type_JavaLangString + "," + this.jdField_b_of_type_JavaLangString + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.business.manager.Checker.ItemRecord
 * JD-Core Version:    0.7.0.1
 */