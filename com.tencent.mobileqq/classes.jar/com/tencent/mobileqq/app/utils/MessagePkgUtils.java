package com.tencent.mobileqq.app.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MessagePkgUtils
{
  public static Object a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
      return new ObjectInputStream(new ByteArrayInputStream(paramArrayOfByte)).readObject();
    }
    return null;
  }
  
  public static byte[] a(Serializable paramSerializable)
  {
    if (paramSerializable == null) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    new ObjectOutputStream(localByteArrayOutputStream).writeObject(paramSerializable);
    return localByteArrayOutputStream.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.utils.MessagePkgUtils
 * JD-Core Version:    0.7.0.1
 */