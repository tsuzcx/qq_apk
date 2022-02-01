package com.android.dx.util;

import java.util.Arrays;

public class FixedSizeList
  extends MutabilityControl
  implements ToHuman
{
  private Object[] arr;
  
  public FixedSizeList(int paramInt) {}
  
  private Object throwIndex(int paramInt)
  {
    if (paramInt < 0) {
      throw new IndexOutOfBoundsException("n < 0");
    }
    throw new IndexOutOfBoundsException("n >= size()");
  }
  
  private String toString0(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    int j = this.arr.length;
    StringBuffer localStringBuffer = new StringBuffer(j * 10 + 10);
    if (paramString1 != null) {
      localStringBuffer.append(paramString1);
    }
    int i = 0;
    if (i < j)
    {
      if ((i != 0) && (paramString2 != null)) {
        localStringBuffer.append(paramString2);
      }
      if (paramBoolean) {
        localStringBuffer.append(((ToHuman)this.arr[i]).toHuman());
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuffer.append(this.arr[i]);
      }
    }
    if (paramString3 != null) {
      localStringBuffer.append(paramString3);
    }
    return localStringBuffer.toString();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    paramObject = (FixedSizeList)paramObject;
    return Arrays.equals(this.arr, paramObject.arr);
  }
  
  public final Object get0(int paramInt)
  {
    try
    {
      Object localObject3 = this.arr[paramInt];
      Object localObject1 = localObject3;
      if (localObject3 == null) {
        throw new NullPointerException("unset: " + paramInt);
      }
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      Object localObject2 = throwIndex(paramInt);
      return localObject2;
    }
  }
  
  protected final Object getOrNull0(int paramInt)
  {
    return this.arr[paramInt];
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.arr);
  }
  
  public final void set0(int paramInt, Object paramObject)
  {
    throwIfImmutable();
    try
    {
      this.arr[paramInt] = paramObject;
      return;
    }
    catch (ArrayIndexOutOfBoundsException paramObject)
    {
      throwIndex(paramInt);
    }
  }
  
  public void shrinkToFit()
  {
    int m = 0;
    int n = this.arr.length;
    int j = 0;
    int k;
    for (int i = 0; j < n; i = k)
    {
      k = i;
      if (this.arr[j] != null) {
        k = i + 1;
      }
      j += 1;
    }
    if (n == i) {}
    do
    {
      return;
      throwIfImmutable();
      Object[] arrayOfObject = new Object[i];
      j = 0;
      for (k = m; j < n; k = m)
      {
        Object localObject = this.arr[j];
        m = k;
        if (localObject != null)
        {
          arrayOfObject[k] = localObject;
          m = k + 1;
        }
        j += 1;
      }
      this.arr = arrayOfObject;
    } while (i != 0);
    setImmutable();
  }
  
  public final int size()
  {
    return this.arr.length;
  }
  
  public String toHuman()
  {
    String str = getClass().getName();
    return toString0(str.substring(str.lastIndexOf('.') + 1) + '{', ", ", "}", true);
  }
  
  public String toHuman(String paramString1, String paramString2, String paramString3)
  {
    return toString0(paramString1, paramString2, paramString3, true);
  }
  
  public String toString()
  {
    String str = getClass().getName();
    return toString0(str.substring(str.lastIndexOf('.') + 1) + '{', ", ", "}", false);
  }
  
  public String toString(String paramString1, String paramString2, String paramString3)
  {
    return toString0(paramString1, paramString2, paramString3, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.util.FixedSizeList
 * JD-Core Version:    0.7.0.1
 */