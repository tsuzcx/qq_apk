package com.tencent.biz.pubaccount.weishi_new.openws.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;

public class WSReportParams
{
  private String jdField_a_of_type_JavaLangString;
  private Map<String, String> jdField_a_of_type_JavaUtilMap;
  private Map<String, String> b;
  
  public WSReportParams(@Nullable String paramString, @NonNull Map<String, String> paramMap1, @NonNull Map<String, String> paramMap2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilMap = paramMap1;
    this.b = paramMap2;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public Map<String, String> a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public Map<String, String> b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.openws.data.WSReportParams
 * JD-Core Version:    0.7.0.1
 */