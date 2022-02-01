package com.tencent.biz.qqcircle.localphoto.scan.data;

import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

class ExpandExifInterface$ExifAttribute
{
  public final int a;
  public final int b;
  public final byte[] c;
  
  private ExpandExifInterface$ExifAttribute(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramArrayOfByte;
  }
  
  public static ExifAttribute a(long paramLong, ByteOrder paramByteOrder)
  {
    return a(new long[] { paramLong }, paramByteOrder);
  }
  
  public static ExifAttribute a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append('\000');
    paramString = localStringBuilder.toString().getBytes(ExpandExifInterface.b());
    return new ExifAttribute(2, paramString.length, paramString);
  }
  
  public static ExifAttribute a(long[] paramArrayOfLong, ByteOrder paramByteOrder)
  {
    ByteBuffer localByteBuffer = ByteBuffer.wrap(new byte[ExpandExifInterface.a()[4] * paramArrayOfLong.length]);
    localByteBuffer.order(paramByteOrder);
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      localByteBuffer.putInt((int)paramArrayOfLong[i]);
      i += 1;
    }
    return new ExifAttribute(4, paramArrayOfLong.length, localByteBuffer.array());
  }
  
  private Object d(ByteOrder paramByteOrder)
  {
    for (;;)
    {
      int i;
      try
      {
        ExpandExifInterface.ByteOrderAwarenessDataInputStream localByteOrderAwarenessDataInputStream = new ExpandExifInterface.ByteOrderAwarenessDataInputStream(this.c);
        localByteOrderAwarenessDataInputStream.a(paramByteOrder);
        int i6 = this.a;
        int m = 1;
        int j = 0;
        int n = 0;
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int k = 0;
        i = 0;
        switch (i6)
        {
        case 12: 
          paramByteOrder = new double[this.b];
          if (i >= this.b) {
            break;
          }
          paramByteOrder[i] = localByteOrderAwarenessDataInputStream.h();
          i += 1;
          break;
        case 11: 
          paramByteOrder = new double[this.b];
          i = j;
          if (i >= this.b) {
            break label611;
          }
          paramByteOrder[i] = localByteOrderAwarenessDataInputStream.g();
          i += 1;
          break;
        case 10: 
          paramByteOrder = new ExpandExifInterface.Rational[this.b];
          i = n;
          if (i >= this.b) {
            break label613;
          }
          paramByteOrder[i] = new ExpandExifInterface.Rational(localByteOrderAwarenessDataInputStream.c(), localByteOrderAwarenessDataInputStream.c(), null);
          i += 1;
          break;
        case 9: 
          paramByteOrder = new int[this.b];
          i = i1;
          if (i >= this.b) {
            break label615;
          }
          paramByteOrder[i] = localByteOrderAwarenessDataInputStream.c();
          i += 1;
          break;
        case 8: 
          paramByteOrder = new int[this.b];
          i = i2;
          if (i >= this.b) {
            break label617;
          }
          paramByteOrder[i] = localByteOrderAwarenessDataInputStream.b();
          i += 1;
          break;
        case 5: 
          paramByteOrder = new ExpandExifInterface.Rational[this.b];
          i = i3;
          if (i >= this.b) {
            break label619;
          }
          paramByteOrder[i] = new ExpandExifInterface.Rational(localByteOrderAwarenessDataInputStream.e(), localByteOrderAwarenessDataInputStream.e(), null);
          i += 1;
          break;
        case 4: 
          paramByteOrder = new long[this.b];
          i = i4;
          if (i >= this.b) {
            break label621;
          }
          paramByteOrder[i] = localByteOrderAwarenessDataInputStream.e();
          i += 1;
          break;
        case 3: 
          paramByteOrder = new int[this.b];
          i = i5;
          if (i >= this.b) {
            break label623;
          }
          paramByteOrder[i] = localByteOrderAwarenessDataInputStream.d();
          i += 1;
          break;
        case 2: 
        case 7: 
          i = k;
          if (this.b >= ExpandExifInterface.d().length)
          {
            i = 0;
            j = m;
            if (i < ExpandExifInterface.d().length)
            {
              if (this.c[i] == ExpandExifInterface.d()[i]) {
                break label625;
              }
              j = 0;
            }
            i = k;
            if (j != 0) {
              i = ExpandExifInterface.d().length;
            }
          }
          paramByteOrder = new StringBuilder();
          if (i < this.b)
          {
            j = this.c[i];
            if (j != 0)
            {
              if (j >= 32)
              {
                paramByteOrder.append((char)j);
                break label632;
              }
              paramByteOrder.append('?');
              break label632;
            }
          }
          return paramByteOrder.toString();
        }
      }
      catch (IOException paramByteOrder)
      {
        Log.w("ExpandExifInterface", "IOException occurred during reading a value", paramByteOrder);
        return null;
      }
      if ((this.c.length == 1) && (this.c[0] >= 0) && (this.c[0] <= 1)) {
        return new String(new char[] { (char)(this.c[0] + 48) });
      }
      paramByteOrder = new String(this.c, ExpandExifInterface.b());
      return paramByteOrder;
      return null;
      return paramByteOrder;
      label611:
      return paramByteOrder;
      label613:
      return paramByteOrder;
      label615:
      return paramByteOrder;
      label617:
      return paramByteOrder;
      label619:
      return paramByteOrder;
      label621:
      return paramByteOrder;
      label623:
      return paramByteOrder;
      label625:
      i += 1;
      continue;
      label632:
      i += 1;
    }
  }
  
  public double a(ByteOrder paramByteOrder)
  {
    paramByteOrder = d(paramByteOrder);
    if (paramByteOrder != null)
    {
      if ((paramByteOrder instanceof String)) {
        return Double.parseDouble((String)paramByteOrder);
      }
      if ((paramByteOrder instanceof long[]))
      {
        paramByteOrder = (long[])paramByteOrder;
        if (paramByteOrder.length == 1) {
          return paramByteOrder[0];
        }
        throw new NumberFormatException("There are more than one component");
      }
      if ((paramByteOrder instanceof int[]))
      {
        paramByteOrder = (int[])paramByteOrder;
        if (paramByteOrder.length == 1) {
          return paramByteOrder[0];
        }
        throw new NumberFormatException("There are more than one component");
      }
      if ((paramByteOrder instanceof double[]))
      {
        paramByteOrder = (double[])paramByteOrder;
        if (paramByteOrder.length == 1) {
          return paramByteOrder[0];
        }
        throw new NumberFormatException("There are more than one component");
      }
      if ((paramByteOrder instanceof ExpandExifInterface.Rational[]))
      {
        paramByteOrder = (ExpandExifInterface.Rational[])paramByteOrder;
        if (paramByteOrder.length == 1) {
          return paramByteOrder[0].a();
        }
        throw new NumberFormatException("There are more than one component");
      }
      throw new NumberFormatException("Couldn't find a double value");
    }
    throw new NumberFormatException("NULL can't be converted to a double value");
  }
  
  public int b(ByteOrder paramByteOrder)
  {
    paramByteOrder = d(paramByteOrder);
    if (paramByteOrder != null)
    {
      if ((paramByteOrder instanceof String)) {
        return Integer.parseInt((String)paramByteOrder);
      }
      if ((paramByteOrder instanceof long[]))
      {
        paramByteOrder = (long[])paramByteOrder;
        if (paramByteOrder.length == 1) {
          return (int)paramByteOrder[0];
        }
        throw new NumberFormatException("There are more than one component");
      }
      if ((paramByteOrder instanceof int[]))
      {
        paramByteOrder = (int[])paramByteOrder;
        if (paramByteOrder.length == 1) {
          return paramByteOrder[0];
        }
        throw new NumberFormatException("There are more than one component");
      }
      throw new NumberFormatException("Couldn't find a integer value");
    }
    throw new NumberFormatException("NULL can't be converted to a integer value");
  }
  
  public String c(ByteOrder paramByteOrder)
  {
    Object localObject = d(paramByteOrder);
    if (localObject == null) {
      return null;
    }
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    paramByteOrder = new StringBuilder();
    boolean bool = localObject instanceof long[];
    int j = 0;
    int k = 0;
    int m = 0;
    int i = 0;
    if (bool)
    {
      localObject = (long[])localObject;
      while (i < localObject.length)
      {
        paramByteOrder.append(localObject[i]);
        j = i + 1;
        i = j;
        if (j != localObject.length)
        {
          paramByteOrder.append(",");
          i = j;
        }
      }
      return paramByteOrder.toString();
    }
    if ((localObject instanceof int[]))
    {
      localObject = (int[])localObject;
      i = j;
      while (i < localObject.length)
      {
        paramByteOrder.append(localObject[i]);
        j = i + 1;
        i = j;
        if (j != localObject.length)
        {
          paramByteOrder.append(",");
          i = j;
        }
      }
      return paramByteOrder.toString();
    }
    if ((localObject instanceof double[]))
    {
      localObject = (double[])localObject;
      i = k;
      while (i < localObject.length)
      {
        paramByteOrder.append(localObject[i]);
        j = i + 1;
        i = j;
        if (j != localObject.length)
        {
          paramByteOrder.append(",");
          i = j;
        }
      }
      return paramByteOrder.toString();
    }
    if ((localObject instanceof ExpandExifInterface.Rational[]))
    {
      localObject = (ExpandExifInterface.Rational[])localObject;
      i = m;
      while (i < localObject.length)
      {
        paramByteOrder.append(localObject[i].a);
        paramByteOrder.append('/');
        paramByteOrder.append(localObject[i].b);
        j = i + 1;
        i = j;
        if (j != localObject.length)
        {
          paramByteOrder.append(",");
          i = j;
        }
      }
      return paramByteOrder.toString();
    }
    return null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    localStringBuilder.append(ExpandExifInterface.c()[this.a]);
    localStringBuilder.append(", data length:");
    localStringBuilder.append(this.c.length);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.localphoto.scan.data.ExpandExifInterface.ExifAttribute
 * JD-Core Version:    0.7.0.1
 */