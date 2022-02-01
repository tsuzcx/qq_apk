package com.google.protobuf;

import java.lang.reflect.Field;

final class OneofInfo
{
  private final int a;
  private final Field b;
  private final Field c;
  
  public OneofInfo(int paramInt, Field paramField1, Field paramField2)
  {
    this.a = paramInt;
    this.b = paramField1;
    this.c = paramField2;
  }
  
  public Field a()
  {
    return this.b;
  }
  
  public Field b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.OneofInfo
 * JD-Core Version:    0.7.0.1
 */