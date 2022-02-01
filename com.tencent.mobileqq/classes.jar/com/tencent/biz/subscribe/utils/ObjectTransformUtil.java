package com.tencent.biz.subscribe.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectTransformUtil
{
  public static Object a(byte[] paramArrayOfByte)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
      localObject1 = localObject2;
      ObjectInputStream localObjectInputStream = new ObjectInputStream(localByteArrayInputStream);
      localObject1 = localObject2;
      paramArrayOfByte = localObjectInputStream.readObject();
      localObject1 = paramArrayOfByte;
      localByteArrayInputStream.close();
      localObject1 = paramArrayOfByte;
      localObjectInputStream.close();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localObject1;
  }
  
  public static byte[] a(Object paramObject)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      localObject1 = localObject2;
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObject1 = localObject2;
      localObjectOutputStream.writeObject(paramObject);
      localObject1 = localObject2;
      paramObject = localByteArrayOutputStream.toByteArray();
      localObject1 = paramObject;
      localByteArrayOutputStream.close();
      localObject1 = paramObject;
      localObjectOutputStream.close();
      return paramObject;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.ObjectTransformUtil
 * JD-Core Version:    0.7.0.1
 */