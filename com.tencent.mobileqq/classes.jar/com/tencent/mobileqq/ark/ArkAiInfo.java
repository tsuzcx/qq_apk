package com.tencent.mobileqq.ark;

import java.util.LinkedHashMap;

public class ArkAiInfo
{
  public int a;
  public String a;
  public LinkedHashMap a;
  public int b;
  public String b = "";
  public String c = "1.0.0.1";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  public String i = "";
  
  public ArkAiInfo()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ArkAiInfo)) {}
    do
    {
      return false;
      paramObject = (ArkAiInfo)paramObject;
    } while ((!this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString)) || (!this.b.equals(paramObject.b)) || (!this.h.equals(paramObject.h)) || (!this.jdField_a_of_type_JavaUtilLinkedHashMap.equals(paramObject.jdField_a_of_type_JavaUtilLinkedHashMap)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiInfo
 * JD-Core Version:    0.7.0.1
 */