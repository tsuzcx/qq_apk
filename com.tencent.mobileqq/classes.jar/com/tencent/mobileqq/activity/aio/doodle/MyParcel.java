package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.Rect;
import java.util.List;

public class MyParcel
{
  private byte[] a = null;
  private int b = -1;
  private int c = 0;
  
  public MyParcel(int paramInt)
  {
    if (paramInt > 0)
    {
      this.a = new byte[paramInt];
      this.b = 0;
      this.c = paramInt;
    }
  }
  
  private void a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    if (this.a != null)
    {
      int j = paramArrayOfByte.length;
      int i = j;
      if (paramBoolean) {
        i = j + 4;
      }
      byte[] arrayOfByte1 = this.a;
      j = arrayOfByte1.length;
      int k = this.b;
      if (j > k + i)
      {
        if (paramBoolean) {
          b(paramArrayOfByte.length);
        }
        System.arraycopy(paramArrayOfByte, 0, this.a, this.b, paramArrayOfByte.length);
        this.b += paramArrayOfByte.length;
        return;
      }
      byte[] arrayOfByte2 = new byte[arrayOfByte1.length * 2 + i];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, k);
      this.a = arrayOfByte2;
      this.c = arrayOfByte2.length;
      if (paramBoolean) {
        b(paramArrayOfByte.length);
      }
      System.arraycopy(paramArrayOfByte, 0, this.a, this.b, paramArrayOfByte.length);
      this.b += paramArrayOfByte.length;
    }
  }
  
  private final void b(int paramInt)
  {
    a(DoodleMsgTranslator.a(paramInt), false);
  }
  
  private int f()
  {
    byte[] arrayOfByte = this.a;
    if (arrayOfByte != null)
    {
      int i = this.b;
      if (i + 4 <= this.c)
      {
        i = DoodleMsgTranslator.a(arrayOfByte, i);
        this.b += 4;
        return i;
      }
    }
    return -1;
  }
  
  public MyParcel.DataElement a()
  {
    MyParcel.DataElement localDataElement = new MyParcel.DataElement(this);
    localDataElement.a = this.b;
    localDataElement.b = this.a;
    this.a = null;
    this.b = -1;
    return localDataElement;
  }
  
  public final <T> Object a(MyParcelable.Creator<T> paramCreator)
  {
    f();
    return paramCreator.b(this);
  }
  
  public final void a(float paramFloat)
  {
    a(DoodleMsgTranslator.a(Float.floatToIntBits(paramFloat)), true);
  }
  
  public final void a(int paramInt)
  {
    a(DoodleMsgTranslator.a(paramInt), true);
  }
  
  public final void a(long paramLong)
  {
    a(DoodleMsgTranslator.a(paramLong), true);
  }
  
  public final void a(Rect paramRect)
  {
    if (paramRect == null)
    {
      b(-1);
      return;
    }
    byte[] arrayOfByte1 = new byte[16];
    byte[] arrayOfByte2 = DoodleMsgTranslator.a(paramRect.left);
    byte[] arrayOfByte3 = DoodleMsgTranslator.a(paramRect.top);
    byte[] arrayOfByte4 = DoodleMsgTranslator.a(paramRect.right);
    paramRect = DoodleMsgTranslator.a(paramRect.bottom);
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, 4);
    System.arraycopy(arrayOfByte3, 0, arrayOfByte1, 4, 4);
    System.arraycopy(arrayOfByte4, 0, arrayOfByte1, 8, 4);
    System.arraycopy(paramRect, 0, arrayOfByte1, 12, 4);
    a(arrayOfByte1, true);
  }
  
  public final void a(MyParcelable paramMyParcelable)
  {
    if (paramMyParcelable != null)
    {
      int i = this.b;
      b(0);
      paramMyParcelable.a(this, 0);
      int j = this.b;
      if (this.a != null) {
        System.arraycopy(DoodleMsgTranslator.a(j - i - 4), 0, this.a, i, 4);
      }
    }
  }
  
  public final <T extends MyParcelable> void a(List<T> paramList)
  {
    if (paramList == null)
    {
      b(-1);
      return;
    }
    int j = paramList.size();
    b(j);
    int i = 0;
    while (i < j)
    {
      MyParcelable localMyParcelable = (MyParcelable)paramList.get(i);
      if (localMyParcelable != null)
      {
        b(1);
        localMyParcelable.a(this, 0);
      }
      else
      {
        b(0);
      }
      i += 1;
    }
  }
  
  public final <T> void a(List<T> paramList, MyParcelable.Creator<T> paramCreator)
  {
    int k = paramList.size();
    int m = f();
    int j = 0;
    int i;
    for (;;)
    {
      i = j;
      if (j >= k) {
        break;
      }
      i = j;
      if (j >= m) {
        break;
      }
      if (f() != 0) {
        paramList.set(j, paramCreator.b(this));
      } else {
        paramList.set(j, null);
      }
      j += 1;
    }
    for (;;)
    {
      j = i;
      if (i >= m) {
        break;
      }
      if (f() != 0) {
        paramList.add(paramCreator.b(this));
      } else {
        paramList.add(null);
      }
      i += 1;
    }
    while (j < k)
    {
      paramList.remove(m);
      j += 1;
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a = paramArrayOfByte;
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public int b()
  {
    int i = f();
    byte[] arrayOfByte = this.a;
    if (arrayOfByte != null)
    {
      int j = this.b;
      if ((j + 4 <= this.c) && (i == 4))
      {
        i = DoodleMsgTranslator.a(arrayOfByte, j);
        this.b += 4;
        return i;
      }
    }
    return -1;
  }
  
  public Rect c()
  {
    int i = f();
    if (i == -1) {
      return null;
    }
    if ((this.a != null) && (this.b + 16 <= this.c) && (i == 16))
    {
      Rect localRect = new Rect();
      localRect.left = DoodleMsgTranslator.a(this.a, this.b);
      this.b += 4;
      localRect.top = DoodleMsgTranslator.a(this.a, this.b);
      this.b += 4;
      localRect.right = DoodleMsgTranslator.a(this.a, this.b);
      this.b += 4;
      localRect.bottom = DoodleMsgTranslator.a(this.a, this.b);
      this.b += 4;
      return localRect;
    }
    return null;
  }
  
  public float d()
  {
    int i = f();
    byte[] arrayOfByte = this.a;
    if (arrayOfByte != null)
    {
      int j = this.c;
      int k = this.b;
      if ((j >= k + 4) && (i == 4))
      {
        i = DoodleMsgTranslator.a(arrayOfByte, k);
        this.b += 4;
        return Float.intBitsToFloat(i);
      }
    }
    return -1.0F;
  }
  
  public long e()
  {
    int i = f();
    byte[] arrayOfByte = this.a;
    if (arrayOfByte != null)
    {
      int j = this.c;
      int k = this.b;
      if ((j >= k + 8) && (i == 8))
      {
        long l = DoodleMsgTranslator.b(arrayOfByte, k);
        this.b += 8;
        return l;
      }
    }
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.MyParcel
 * JD-Core Version:    0.7.0.1
 */