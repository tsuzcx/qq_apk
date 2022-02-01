package com.tencent.biz.pubaccount.readinjoy.model;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;

public class AtlasStackInfo
{
  private int jdField_a_of_type_Int = 0;
  private ArrayDeque<String> jdField_a_of_type_JavaUtilArrayDeque = new ArrayDeque();
  private LinkedHashMap<String, AtlasStackInfo.StackGallery> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  
  public String toString()
  {
    return "AtlasStackInfo{stackGalleryMap=" + this.jdField_a_of_type_JavaUtilLinkedHashMap + "mScanStack=" + this.jdField_a_of_type_JavaUtilArrayDeque.toString() + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.AtlasStackInfo
 * JD-Core Version:    0.7.0.1
 */