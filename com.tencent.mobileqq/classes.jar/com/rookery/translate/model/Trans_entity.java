package com.rookery.translate.model;

public class Trans_entity
{
  private Boolean jdField_a_of_type_JavaLangBoolean;
  private final String jdField_a_of_type_JavaLangString;
  
  public Trans_entity(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramBoolean);
  }
  
  public Boolean a()
  {
    return this.jdField_a_of_type_JavaLangBoolean;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(this.jdField_a_of_type_JavaLangBoolean.booleanValue() ^ true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.rookery.translate.model.Trans_entity
 * JD-Core Version:    0.7.0.1
 */