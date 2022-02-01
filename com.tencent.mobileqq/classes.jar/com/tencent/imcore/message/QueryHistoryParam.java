package com.tencent.imcore.message;

import android.database.Cursor;

public class QueryHistoryParam<T>
{
  String a;
  int b;
  String c;
  int d;
  T e;
  Cursor f;
  public Object g;
  
  public QueryHistoryParam(String paramString1, int paramInt1, String paramString2, int paramInt2, T paramT)
  {
    this.a = paramString1;
    this.b = paramInt1;
    this.c = paramString2;
    this.d = paramInt2;
    this.e = paramT;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public void a(Cursor paramCursor)
  {
    this.f = paramCursor;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.QueryHistoryParam
 * JD-Core Version:    0.7.0.1
 */