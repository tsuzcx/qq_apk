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
    int i = paramJceField.getTag();
    if ((paramJceField instanceof ZeroField)) {
      write(0, i);
    }
    int j;
    for (;;)
    {
      return;
      if ((paramJceField instanceof IntField))
      {
        write(((IntField)paramJceField).get(), i);
        return;
      }
      if ((paramJceField instanceof ShortField))
      {
        write(((ShortField)paramJceField).get(), i);
        return;
      }
      if ((paramJceField instanceof ByteField))
      {
        write(((ByteField)paramJceField).get(), i);
        return;
      }
      if ((paramJceField instanceof StringField))
      {
        write(((StringField)paramJceField).get(), i);
        return;
      }
      if ((paramJceField instanceof ByteArrayField))
      {
        write(((ByteArrayField)paramJceField).get(), i);
        return;
      }
      if ((paramJceField instanceof ListField))
      {
        paramJceField = (ListField)paramJceField;
        reserve(8);
        writeHead((byte)9, i);
        write(paramJceField.size(), 0);
        paramJceField = paramJceField.get();
        j = paramJceField.length;
        i = 0;
        while (i < j)
        {
          write(paramJceField[i]);
          i += 1;
        }
      }
      else
      {
        if (!(paramJceField instanceof MapField)) {
          break;
        }
        paramJceField = (MapField)paramJceField;
        reserve(8);
        writeHead((byte)8, i);
        j = paramJceField.size();
        write(j, 0);
        i = 0;
        while (i < j)
        {
          write(paramJceField.getKey(i));
          write(paramJceField.getValue(i));
          i += 1;
        }
      }
    }
    if ((paramJceField instanceof StructField))
    {
      paramJceField = (StructField)paramJceField;
      reserve(2);
      writeHead((byte)10, i);
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
      write(((LongField)paramJceField).get(), i);
      return;
    }
    if ((paramJceField instanceof FloatField))
    {
      write(((FloatField)paramJceField).get(), i);
      return;
    }
    if ((paramJceField instanceof DoubleField))
    {
      write(((DoubleField)paramJceField).get(), i);
      return;
    }
    throw new JceDecodeException("unknow JceField type: " + paramJceField.getClass().getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qq.taf.jce.dynamic.DynamicOutputStream
 * JD-Core Version:    0.7.0.1
 */