package com.tencent.biz.qqstory.utils;

import java.lang.reflect.Field;

final class JsonORM$ColumnInfo
{
  public final int a;
  public final String a;
  public final Field a;
  
  public JsonORM$ColumnInfo(String paramString, int paramInt, Field paramField)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangReflectField = paramField;
    paramField.setAccessible(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.JsonORM.ColumnInfo
 * JD-Core Version:    0.7.0.1
 */