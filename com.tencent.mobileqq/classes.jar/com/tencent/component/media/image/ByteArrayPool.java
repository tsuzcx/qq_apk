package com.tencent.component.media.image;

import java.util.LinkedList;
import pek;

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
  
  protected pek getBuck(PoolParams.BucketParams paramBucketParams)
  {
    pek localpek = new pek(this);
    localpek.jdField_a_of_type_Int = paramBucketParams.arraysSize;
    localpek.b = paramBucketParams.bucketMinSize;
    localpek.c = localpek.jdField_a_of_type_Int;
    localpek.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    return localpek;
  }
  
  protected int getSizeForData(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      return paramArrayOfByte.length;
    }
    return 0;
  }
  
  protected int handleBucketListEmpty(pek parampek)
  {
    return parampek.b;
  }
  
  protected boolean handleRecyleData(pek parampek, byte[] paramArrayOfByte)
  {
    if (parampek.jdField_a_of_type_JavaUtilLinkedList.size() < parampek.jdField_a_of_type_Int)
    {
      parampek.jdField_a_of_type_JavaUtilLinkedList.add(paramArrayOfByte);
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