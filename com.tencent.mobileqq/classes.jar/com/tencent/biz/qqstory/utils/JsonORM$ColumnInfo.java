package com.tencent.biz.qqstory.utils;

import java.lang.reflect.Field;

final class JsonORM$ColumnInfo
{
  public final String a;
  public final int b;
  public final Field c;
  
  public JsonORM$ColumnInfo(String paramString, int paramInt, Field paramField)
  {
    this.a = paramString;
    this.b = paramInt;
    this.c = paramField;
    paramField.setAccessible(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.JsonORM.ColumnInfo
 * JD-Core Version:    0.7.0.1
 */