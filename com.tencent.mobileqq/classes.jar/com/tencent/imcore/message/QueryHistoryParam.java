package com.tencent.imcore.message;

import android.database.Cursor;

public class QueryHistoryParam<T>
{
  int jdField_a_of_type_Int;
  Cursor jdField_a_of_type_AndroidDatabaseCursor;
  T jdField_a_of_type_JavaLangObject;
  String jdField_a_of_type_JavaLangString;
  int jdField_b_of_type_Int;
  public Object b;
  String jdField_b_of_type_JavaLangString;
  
  public QueryHistoryParam(String paramString1, int paramInt1, String paramString2, int paramInt2, T paramT)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaLangObject = paramT;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(Cursor paramCursor)
  {
    this.jdField_a_of_type_AndroidDatabaseCursor = paramCursor;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.QueryHistoryParam
 * JD-Core Version:    0.7.0.1
 */