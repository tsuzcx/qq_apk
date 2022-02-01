package com.tencent.biz.flatbuffers;

import java.nio.ByteBuffer;

public class FbArray
  extends Table
{
  public int a;
  
  public byte a(int paramInt)
  {
    paramInt = this.d + paramInt;
    if (a(paramInt, 1)) {
      return this.e.get(paramInt);
    }
    return 0;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public FbArray a(int paramInt, FbArray paramFbArray)
  {
    return paramFbArray.a(d(this.d + paramInt * 4), this.e);
  }
  
  public FbArray a(int paramInt, ByteBuffer paramByteBuffer)
  {
    if (paramInt >= 0)
    {
      int i = paramByteBuffer.capacity();
      int j = paramInt + 4;
      if (i >= j)
      {
        this.a = paramByteBuffer.getInt(paramInt);
        this.d = j;
        this.e = paramByteBuffer;
        return this;
      }
    }
    return null;
  }
  
  public FbTable a(int paramInt, FbTable paramFbTable)
  {
    return paramFbTable.a(d(this.d + paramInt * 4), this.e);
  }
  
  public String b()
  {
    return a(this.d - 4, true);
  }
  
  public String b(int paramInt)
  {
    return e(this.d + paramInt * 4);
  }
  
  public FbTable c(int paramInt)
  {
    return a(paramInt, new FbTable());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.flatbuffers.FbArray
 * JD-Core Version:    0.7.0.1
 */