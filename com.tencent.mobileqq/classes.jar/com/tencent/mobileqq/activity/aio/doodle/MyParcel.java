package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.Rect;
import java.util.List;

public class MyParcel
{
  private int jdField_a_of_type_Int = -1;
  private byte[] jdField_a_of_type_ArrayOfByte = null;
  private int b = 0;
  
  public MyParcel(int paramInt)
  {
    if (paramInt > 0)
    {
      this.jdField_a_of_type_ArrayOfByte = new byte[paramInt];
      this.jdField_a_of_type_Int = 0;
      this.b = paramInt;
    }
  }
  
  private void a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    if (this.jdField_a_of_type_ArrayOfByte != null)
    {
      int j = paramArrayOfByte.length;
      int i = j;
      if (paramBoolean) {
        i = j + 4;
      }
      byte[] arrayOfByte1 = this.jdField_a_of_type_ArrayOfByte;
      j = arrayOfByte1.length;
      int k = this.jdField_a_of_type_Int;
      if (j > k + i)
      {
        if (paramBoolean) {
          b(paramArrayOfByte.length);
        }
        System.arraycopy(paramArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int, paramArrayOfByte.length);
        this.jdField_a_of_type_Int += paramArrayOfByte.length;
        return;
      }
      byte[] arrayOfByte2 = new byte[arrayOfByte1.length * 2 + i];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, k);
      this.jdField_a_of_type_ArrayOfByte = arrayOfByte2;
      this.b = arrayOfByte2.length;
      if (paramBoolean) {
        b(paramArrayOfByte.length);
      }
      System.arraycopy(paramArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int, paramArrayOfByte.length);
      this.jdField_a_of_type_Int += paramArrayOfByte.length;
    }
  }
  
  private int b()
  {
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    if (arrayOfByte != null)
    {
      int i = this.jdField_a_of_type_Int;
      if (i + 4 <= this.b)
      {
        i = DoodleMsgTranslator.a(arrayOfByte, i);
        this.jdField_a_of_type_Int += 4;
        return i;
      }
    }
    return -1;
  }
  
  private final void b(int paramInt)
  {
    a(DoodleMsgTranslator.a(paramInt), false);
  }
  
  public float a()
  {
    int i = b();
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    if (arrayOfByte != null)
    {
      int j = this.b;
      int k = this.jdField_a_of_type_Int;
      if ((j >= k + 4) && (i == 4))
      {
        i = DoodleMsgTranslator.a(arrayOfByte, k);
        this.jdField_a_of_type_Int += 4;
        return Float.intBitsToFloat(i);
      }
    }
    return -1.0F;
  }
  
  public int a()
  {
    int i = b();
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    if (arrayOfByte != null)
    {
      int j = this.jdField_a_of_type_Int;
      if ((j + 4 <= this.b) && (i == 4))
      {
        i = DoodleMsgTranslator.a(arrayOfByte, j);
        this.jdField_a_of_type_Int += 4;
        return i;
      }
    }
    return -1;
  }
  
  public long a()
  {
    int i = b();
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    if (arrayOfByte != null)
    {
      int j = this.b;
      int k = this.jdField_a_of_type_Int;
      if ((j >= k + 8) && (i == 8))
      {
        long l = DoodleMsgTranslator.a(arrayOfByte, k);
        this.jdField_a_of_type_Int += 8;
        return l;
      }
    }
    return -1L;
  }
  
  public Rect a()
  {
    int i = b();
    if (i == -1) {
      return null;
    }
    if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_Int + 16 <= this.b) && (i == 16))
    {
      Rect localRect = new Rect();
      localRect.left = DoodleMsgTranslator.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int += 4;
      localRect.top = DoodleMsgTranslator.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int += 4;
      localRect.right = DoodleMsgTranslator.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int += 4;
      localRect.bottom = DoodleMsgTranslator.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int += 4;
      return localRect;
    }
    return null;
  }
  
  public MyParcel.DataElement a()
  {
    MyParcel.DataElement localDataElement = new MyParcel.DataElement(this);
    localDataElement.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localDataElement.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_Int = -1;
    return localDataElement;
  }
  
  public final <T> Object a(MyParcelable.Creator<T> paramCreator)
  {
    b();
    return paramCreator.a(this);
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
      int i = this.jdField_a_of_type_Int;
      b(0);
      paramMyParcelable.a(this, 0);
      int j = this.jdField_a_of_type_Int;
      if (this.jdField_a_of_type_ArrayOfByte != null) {
        System.arraycopy(DoodleMsgTranslator.a(j - i - 4), 0, this.jdField_a_of_type_ArrayOfByte, i, 4);
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
    int m = b();
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
      if (b() != 0) {
        paramList.set(j, paramCreator.a(this));
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
      if (b() != 0) {
        paramList.add(paramCreator.a(this));
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
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.MyParcel
 * JD-Core Version:    0.7.0.1
 */