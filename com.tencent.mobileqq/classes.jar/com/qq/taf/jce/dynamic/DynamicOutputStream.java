package com.qq.taf.jce.dynamic;

import com.qq.taf.jce.JceDecodeException;
import com.qq.taf.jce.JceOutputStream;
import java.nio.ByteBuffer;

public final class DynamicOutputStream
  extends JceOutputStream
{
  public DynamicOutputStream() {}
  
  public DynamicOutputStream(int paramInt)
  {
    super(paramInt);
  }
  
  public DynamicOutputStream(ByteBuffer paramByteBuffer)
  {
    super(paramByteBuffer);
  }
  
  public void write(JceField paramJceField)
  {
    int k = paramJceField.getTag();
    boolean bool = paramJceField instanceof ZeroField;
    int j = 0;
    int i = 0;
    if (bool)
    {
      write(0, k);
      return;
    }
    if ((paramJceField instanceof IntField))
    {
      write(((IntField)paramJceField).get(), k);
      return;
    }
    if ((paramJceField instanceof ShortField))
    {
      write(((ShortField)paramJceField).get(), k);
      return;
    }
    if ((paramJceField instanceof ByteField))
    {
      write(((ByteField)paramJceField).get(), k);
      return;
    }
    if ((paramJceField instanceof StringField))
    {
      write(((StringField)paramJceField).get(), k);
      return;
    }
    if ((paramJceField instanceof ByteArrayField))
    {
      write(((ByteArrayField)paramJceField).get(), k);
      return;
    }
    if ((paramJceField instanceof ListField))
    {
      paramJceField = (ListField)paramJceField;
      reserve(8);
      writeHead((byte)9, k);
      write(paramJceField.size(), 0);
      paramJceField = paramJceField.get();
      j = paramJceField.length;
      while (i < j)
      {
        write(paramJceField[i]);
        i += 1;
      }
    }
    if ((paramJceField instanceof MapField))
    {
      paramJceField = (MapField)paramJceField;
      reserve(8);
      writeHead((byte)8, k);
      k = paramJceField.size();
      write(k, 0);
      i = j;
      while (i < k)
      {
        write(paramJceField.getKey(i));
        write(paramJceField.getValue(i));
        i += 1;
      }
    }
    if ((paramJceField instanceof StructField))
    {
      paramJceField = (StructField)paramJceField;
      reserve(2);
      writeHead((byte)10, k);
      paramJceField = paramJceField.get();
      j = paramJceField.length;
      i = 0;
      while (i < j)
      {
        write(paramJceField[i]);
        i += 1;
      }
      reserve(2);
      writeHead((byte)11, 0);
      return;
    }
    if ((paramJceField instanceof LongField))
    {
      write(((LongField)paramJceField).get(), k);
      return;
    }
    if ((paramJceField instanceof FloatField))
    {
      write(((FloatField)paramJceField).get(), k);
      return;
    }
    if ((paramJceField instanceof DoubleField))
    {
      write(((DoubleField)paramJceField).get(), k);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unknow JceField type: ");
    localStringBuilder.append(paramJceField.getClass().getName());
    paramJceField = new JceDecodeException(localStringBuilder.toString());
    for (;;)
    {
      throw paramJceField;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.taf.jce.dynamic.DynamicOutputStream
 * JD-Core Version:    0.7.0.1
 */