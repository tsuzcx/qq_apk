package com.tencent.featuretoggle.hltxkg.common.a.c;

import java.util.HashMap;
import java.util.Map;

public final class b
{
  private String jdField_a_of_type_JavaLangString;
  private Map<String, c> jdField_a_of_type_JavaUtilMap;
  
  public b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final void a(c paramc)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramc.jdField_a_of_type_JavaLangString, paramc);
  }
  
  public final Map<String, c> b()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.a.c.b
 * JD-Core Version:    0.7.0.1
 */