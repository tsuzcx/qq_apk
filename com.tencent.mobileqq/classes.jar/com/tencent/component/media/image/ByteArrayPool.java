package com.tencent.component.media.image;

import java.util.LinkedList;
import pkw;

public class ByteArrayPool
  extends BucketPool
{
  public ByteArrayPool(PoolParams paramPoolParams)
  {
    super(paramPoolParams);
  }
  
  protected byte[] allocData(int paramInt)
  {
    return new byte[paramInt];
  }
  
  protected pkw getBuck(PoolParams.BucketParams paramBucketParams)
  {
    pkw localpkw = new pkw(this);
    localpkw.jdField_a_of_type_Int = paramBucketParams.arraysSize;
    localpkw.b = paramBucketParams.bucketMinSize;
    localpkw.c = localpkw.jdField_a_of_type_Int;
    localpkw.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    return localpkw;
  }
  
  protected int getSizeForData(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      return paramArrayOfByte.length;
    }
    return 0;
  }
  
  protected int handleBucketListEmpty(pkw parampkw)
  {
    return parampkw.b;
  }
  
  protected boolean handleRecyleData(pkw parampkw, byte[] paramArrayOfByte)
  {
    if (parampkw.jdField_a_of_type_JavaUtilLinkedList.size() < parampkw.jdField_a_of_type_Int)
    {
      parampkw.jdField_a_of_type_JavaUtilLinkedList.add(paramArrayOfByte);
      return false;
    }
    return true;
  }
  
  protected void releaseData(byte[] paramArrayOfByte) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.ByteArrayPool
 * JD-Core Version:    0.7.0.1
 */