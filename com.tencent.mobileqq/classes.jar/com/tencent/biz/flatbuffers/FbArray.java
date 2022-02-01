package com.tencent.biz.flatbuffers;

import java.nio.ByteBuffer;

public class FbArray
  extends Table
{
  public int a;
  
  public byte a(int paramInt)
  {
    paramInt = this.c + paramInt;
    if (a(paramInt, 1)) {
      return this.jdField_a_of_type_JavaNioByteBuffer.get(paramInt);
    }
    return 0;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public FbArray a(int paramInt, FbArray paramFbArray)
  {
    return paramFbArray.a(a(this.c + paramInt * 4), this.jdField_a_of_type_JavaNioByteBuffer);
  }
  
  public FbArray a(int paramInt, ByteBuffer paramByteBuffer)
  {
    if (paramInt >= 0)
    {
      int i = paramByteBuffer.capacity();
      int j = paramInt + 4;
      if (i >= j)
      {
        this.jdField_a_of_type_Int = paramByteBuffer.getInt(paramInt);
        this.c = j;
        this.jdField_a_of_type_JavaNioByteBuffer = paramByteBuffer;
        return this;
      }
    }
    return null;
  }
  
  public FbTable a(int paramInt)
  {
    return a(paramInt, new FbTable());
  }
  
  public FbTable a(int paramInt, FbTable paramFbTable)
  {
    return paramFbTable.a(a(this.c + paramInt * 4), this.jdField_a_of_type_JavaNioByteBuffer);
  }
  
  public String a()
  {
    return a(this.c - 4, true);
  }
  
  public String a(int paramInt)
  {
    return b(this.c + paramInt * 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.flatbuffers.FbArray
 * JD-Core Version:    0.7.0.1
 */