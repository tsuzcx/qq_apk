package com.qq.taf.jce.dynamic;

import com.qq.taf.jce.JceDecodeException;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceInputStream.HeadData;
import java.io.UnsupportedEncodingException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class DynamicInputStream
{
  private ByteBuffer bs;
  private String sServerEncoding = "GBK";
  
  public DynamicInputStream(ByteBuffer paramByteBuffer)
  {
    this.bs = paramByteBuffer;
  }
  
  public DynamicInputStream(byte[] paramArrayOfByte)
  {
    this.bs = ByteBuffer.wrap(paramArrayOfByte);
  }
  
  private JceField readString(JceInputStream.HeadData paramHeadData, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    this.bs.get(arrayOfByte);
    try
    {
      String str1 = new String(arrayOfByte, this.sServerEncoding);
      return JceField.create(str1, paramHeadData.tag);
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        String str2 = new String(arrayOfByte);
      }
    }
  }
  
  public JceField read()
  {
    int i = 0;
    try
    {
      localObject1 = new JceInputStream.HeadData();
      JceInputStream.readHead((JceInputStream.HeadData)localObject1, this.bs);
      switch (((JceInputStream.HeadData)localObject1).type)
      {
      case 0: 
        return JceField.create(this.bs.get(), ((JceInputStream.HeadData)localObject1).tag);
      }
    }
    catch (BufferUnderflowException localBufferUnderflowException)
    {
      Object localObject1;
      int j;
      Object localObject2;
      Object localObject3;
      return null;
    }
    return JceField.create(this.bs.getShort(), ((JceInputStream.HeadData)localObject1).tag);
    return JceField.create(this.bs.getInt(), ((JceInputStream.HeadData)localObject1).tag);
    return JceField.create(this.bs.getLong(), ((JceInputStream.HeadData)localObject1).tag);
    return JceField.create(this.bs.getFloat(), ((JceInputStream.HeadData)localObject1).tag);
    return JceField.create(this.bs.getDouble(), ((JceInputStream.HeadData)localObject1).tag);
    j = this.bs.get();
    i = j;
    if (j < 0) {
      i = j + 256;
    }
    return readString((JceInputStream.HeadData)localObject1, i);
    return readString((JceInputStream.HeadData)localObject1, this.bs.getInt());
    j = ((NumberField)read()).intValue();
    localObject2 = new JceField[j];
    while (i < j)
    {
      localObject2[i] = read();
      i += 1;
    }
    return JceField.createList((JceField[])localObject2, ((JceInputStream.HeadData)localObject1).tag);
    j = ((NumberField)read()).intValue();
    localObject2 = new JceField[j];
    localObject3 = new JceField[j];
    i = 0;
    while (i < j)
    {
      localObject2[i] = read();
      localObject3[i] = read();
      i += 1;
    }
    return JceField.createMap((JceField[])localObject2, (JceField[])localObject3, ((JceInputStream.HeadData)localObject1).tag);
    localObject2 = new ArrayList();
    for (;;)
    {
      localObject3 = read();
      if (localObject3 == null) {
        return JceField.createStruct((JceField[])((List)localObject2).toArray(new JceField[0]), ((JceInputStream.HeadData)localObject1).tag);
      }
      ((List)localObject2).add(localObject3);
    }
    return JceField.createZero(((JceInputStream.HeadData)localObject1).tag);
    i = ((JceInputStream.HeadData)localObject1).tag;
    JceInputStream.readHead((JceInputStream.HeadData)localObject1, this.bs);
    if (((JceInputStream.HeadData)localObject1).type != 0) {
      throw new JceDecodeException("type mismatch, simple_list only support byte, tag: " + i + ", type: " + ((JceInputStream.HeadData)localObject1).type);
    }
    localObject1 = new byte[((NumberField)read()).intValue()];
    this.bs.get((byte[])localObject1);
    localObject1 = JceField.create((byte[])localObject1, i);
    return localObject1;
    return null;
    return null;
  }
  
  public int setServerEncoding(String paramString)
  {
    this.sServerEncoding = paramString;
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qq.taf.jce.dynamic.DynamicInputStream
 * JD-Core Version:    0.7.0.1
 */