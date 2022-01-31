package com.tencent.mobileqq.armap.map;

import com.tencent.mobileqq.armap.ItemInfo;

public class ARGridMapViewDialog$OpenBoxExtraData
{
  int jdField_a_of_type_Int;
  ItemInfo jdField_a_of_type_ComTencentMobileqqArmapItemInfo;
  String jdField_a_of_type_JavaLangString;
  
  public ARGridMapViewDialog$OpenBoxExtraData(int paramInt, String paramString, ItemInfo paramItemInfo)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqArmapItemInfo = paramItemInfo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("taskType:").append(this.jdField_a_of_type_Int).append(",busiJumpUrl:").append(this.jdField_a_of_type_JavaLangString).append(",itemInfo:").append(this.jdField_a_of_type_ComTencentMobileqqArmapItemInfo);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.map.ARGridMapViewDialog.OpenBoxExtraData
 * JD-Core Version:    0.7.0.1
 */