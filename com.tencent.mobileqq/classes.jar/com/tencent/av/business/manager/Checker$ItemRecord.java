package com.tencent.av.business.manager;

import com.tencent.av.business.manager.pendant.ItemBase;
import java.util.ArrayList;

class Checker$ItemRecord
{
  int jdField_a_of_type_Int = 0;
  final ItemBase jdField_a_of_type_ComTencentAvBusinessManagerPendantItemBase;
  String jdField_a_of_type_JavaLangString;
  final ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList(0);
  boolean jdField_a_of_type_Boolean = false;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  
  Checker$ItemRecord(ItemBase paramItemBase, ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentAvBusinessManagerPendantItemBase = paramItemBase;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ItemRecord{");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvBusinessManagerPendantItemBase);
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.Checker.ItemRecord
 * JD-Core Version:    0.7.0.1
 */