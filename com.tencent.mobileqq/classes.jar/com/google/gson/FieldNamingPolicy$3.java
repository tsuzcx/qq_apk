package com.google.gson;

import java.lang.reflect.Field;

 enum FieldNamingPolicy$3
{
  FieldNamingPolicy$3()
  {
    super(str, i, null);
  }
  
  public String translateName(Field paramField)
  {
    return upperCaseFirstLetter(separateCamelCase(paramField.getName(), " "));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.gson.FieldNamingPolicy.3
 * JD-Core Version:    0.7.0.1
 */