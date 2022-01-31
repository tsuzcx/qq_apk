package com.tencent.biz.qqstory.model.lbs;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.HashSet;

public class LbsManager$POIListRequestSession
{
  final int a;
  public final Bundle a;
  public String a;
  public HashSet a;
  public boolean a;
  String jdField_b_of_type_JavaLangString = "";
  boolean jdField_b_of_type_Boolean = true;
  
  public LbsManager$POIListRequestSession(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public static POIListRequestSession a()
  {
    return new POIListRequestSession(20);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.equals(paramString, this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_b_of_type_JavaLangString = paramString;
      a();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestSession
 * JD-Core Version:    0.7.0.1
 */