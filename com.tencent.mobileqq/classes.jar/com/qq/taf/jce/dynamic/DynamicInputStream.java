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
      str = new String(arrayOfByte, this.sServerEncoding);
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      String str;
      label32:
      break label32;
    }
    str = new String(arrayOfByte);
    return JceField.create(str, paramHeadData.tag);
  }
  
  public JceField read()
  {
    try
    {
      localObject1 = new JceInputStream.HeadData();
      JceInputStream.readHead((JceInputStream.HeadData)localObject1, this.bs);
      k = ((JceInputStream.HeadData)localObject1).type;
      j = 0;
      i = 0;
      switch (k)
      {
      case 13: 
        i = ((JceInputStream.HeadData)localObject1).tag;
        JceInputStream.readHead((JceInputStream.HeadData)localObject1, this.bs);
        if (((JceInputStream.HeadData)localObject1).type == 0)
        {
          localObject1 = new byte[((NumberField)read()).intValue()];
          this.bs.get((byte[])localObject1);
          return JceField.create((byte[])localObject1, i);
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("type mismatch, simple_list only support byte, tag: ");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(", type: ");
        ((StringBuilder)localObject2).append(((JceInputStream.HeadData)localObject1).type);
        throw new JceDecodeException(((StringBuilder)localObject2).toString());
      }
    }
    catch (BufferUnderflowException localBufferUnderflowException)
    {
      Object localObject1;
      int k;
      int j;
      int i;
      Object localObject2;
      return null;
    }
    return JceField.createZero(((JceInputStream.HeadData)localObject1).tag);
    localObject2 = new ArrayList();
    for (;;)
    {
      Object localObject3 = read();
      if (localObject3 == null) {
        return JceField.createStruct((JceField[])((List)localObject2).toArray(new JceField[0]), ((JceInputStream.HeadData)localObject1).tag);
      }
      ((List)localObject2).add(localObject3);
      continue;
      j = ((NumberField)read()).intValue();
      localObject2 = new JceField[j];
      for (;;)
      {
        if (i < j)
        {
          localObject2[i] = read();
          i += 1;
        }
        else
        {
          return JceField.createList((JceField[])localObject2, ((JceInputStream.HeadData)localObject1).tag);
          k = ((NumberField)read()).intValue();
          localObject2 = new JceField[k];
          localObject3 = new JceField[k];
          i = j;
          for (;;)
          {
            if (i < k)
            {
              localObject2[i] = read();
              localObject3[i] = read();
              i += 1;
            }
            else
            {
              return JceField.createMap((JceField[])localObject2, (JceField[])localObject3, ((JceInputStream.HeadData)localObject1).tag);
              return readString((JceInputStream.HeadData)localObject1, this.bs.getInt());
              j = this.bs.get();
              i = j;
              if (j < 0) {
                i = j + 256;
              }
              return readString((JceInputStream.HeadData)localObject1, i);
              return JceField.create(this.bs.getDouble(), ((JceInputStream.HeadData)localObject1).tag);
              return JceField.create(this.bs.getFloat(), ((JceInputStream.HeadData)localObject1).tag);
              return JceField.create(this.bs.getLong(), ((JceInputStream.HeadData)localObject1).tag);
              return JceField.create(this.bs.getInt(), ((JceInputStream.HeadData)localObject1).tag);
              return JceField.create(this.bs.getShort(), ((JceInputStream.HeadData)localObject1).tag);
              localObject1 = JceField.create(this.bs.get(), ((JceInputStream.HeadData)localObject1).tag);
              return localObject1;
            }
          }
        }
      }
    }
    return null;
    return null;
  }
  
  public int setServerEncoding(String paramString)
  {
    this.sServerEncoding = paramString;
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.taf.jce.dynamic.DynamicInputStream
 * JD-Core Version:    0.7.0.1
 */