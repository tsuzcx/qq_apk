package com.google.gson;

import java.lang.reflect.Field;
import java.util.Locale;

 enum FieldNamingPolicy$4
{
  FieldNamingPolicy$4()
  {
    super(str, i, null);
  }
  
  public String translateName(Field paramField)
  {
    return separateCamelCase(paramField.getName(), "_").toLowerCase(Locale.ENGLISH);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.gson.FieldNamingPolicy.4
 * JD-Core Version:    0.7.0.1
 */