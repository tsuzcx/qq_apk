package com.google.gson;

import java.lang.reflect.Field;

 enum FieldNamingPolicy$2
{
  FieldNamingPolicy$2()
  {
    super(str, i, null);
  }
  
  public String translateName(Field paramField)
  {
    return upperCaseFirstLetter(paramField.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.google.gson.FieldNamingPolicy.2
 * JD-Core Version:    0.7.0.1
 */