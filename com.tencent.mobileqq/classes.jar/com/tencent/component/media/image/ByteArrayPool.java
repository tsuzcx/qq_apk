package com.tencent.component.media.image;

import java.util.LinkedList;
import pge;

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
  
  protected pge getBuck(PoolParams.BucketParams paramBucketParams)
  {
    pge localpge = new pge(this);
    localpge.jdField_a_of_type_Int = paramBucketParams.arraysSize;
    localpge.b = paramBucketParams.bucketMinSize;
    localpge.c = localpge.jdField_a_of_type_Int;
    localpge.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    return localpge;
  }
  
  protected int getSizeForData(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      return paramArrayOfByte.length;
    }
    return 0;
  }
  
  protected int handleBucketListEmpty(pge parampge)
  {
    return parampge.b;
  }
  
  protected boolean handleRecyleData(pge parampge, byte[] paramArrayOfByte)
  {
    if (parampge.jdField_a_of_type_JavaUtilLinkedList.size() < parampge.jdField_a_of_type_Int)
    {
      parampge.jdField_a_of_type_JavaUtilLinkedList.add(paramArrayOfByte);
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