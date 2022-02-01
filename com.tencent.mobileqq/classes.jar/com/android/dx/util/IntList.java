package com.android.dx.util;

import java.util.Arrays;

public final class IntList
  extends MutabilityControl
{
  public static final IntList EMPTY = new IntList(0);
  private int size;
  private boolean sorted;
  private int[] values;
  
  static
  {
    EMPTY.setImmutable();
  }
  
  public IntList()
  {
    this(4);
  }
  
  public IntList(int paramInt)
  {
    super(true);
    try
    {
      this.values = new int[paramInt];
      this.size = 0;
      this.sorted = true;
      return;
    }
    catch (NegativeArraySizeException localNegativeArraySizeException)
    {
      throw new IllegalArgumentException("size < 0");
    }
  }
  
  private void growIfNeeded()
  {
    if (this.size == this.values.length)
    {
      int[] arrayOfInt = new int[this.size * 3 / 2 + 10];
      System.arraycopy(this.values, 0, arrayOfInt, 0, this.size);
      this.values = arrayOfInt;
    }
  }
  
  public static IntList makeImmutable(int paramInt)
  {
    IntList localIntList = new IntList(1);
    localIntList.add(paramInt);
    localIntList.setImmutable();
    return localIntList;
  }
  
  public static IntList makeImmutable(int paramInt1, int paramInt2)
  {
    IntList localIntList = new IntList(2);
    localIntList.add(paramInt1);
    localIntList.add(paramInt2);
    localIntList.setImmutable();
    return localIntList;
  }
  
  public void add(int paramInt)
  {
    boolean bool = true;
    throwIfImmutable();
    growIfNeeded();
    int[] arrayOfInt = this.values;
    int i = this.size;
    this.size = (i + 1);
    arrayOfInt[i] = paramInt;
    if ((this.sorted) && (this.size > 1)) {
      if (paramInt < this.values[(this.size - 2)]) {
        break label69;
      }
    }
    for (;;)
    {
      this.sorted = bool;
      return;
      label69:
      bool = false;
    }
  }
  
  public int binarysearch(int paramInt)
  {
    int m = this.size;
    int i;
    int j;
    if (!this.sorted)
    {
      i = 0;
      if (i < m) {
        if (this.values[i] == paramInt) {
          j = i;
        }
      }
    }
    do
    {
      return j;
      i += 1;
      break;
      return -m;
      j = -1;
      i = m;
      if (i > j + 1)
      {
        int k = (i - j >> 1) + j;
        if (paramInt <= this.values[k]) {
          i = k;
        }
        for (;;)
        {
          break;
          j = k;
        }
      }
      if (i == m) {
        break label113;
      }
      j = i;
    } while (paramInt == this.values[i]);
    return -i - 1;
    label113:
    return -m - 1;
  }
  
  public boolean contains(int paramInt)
  {
    return indexOf(paramInt) >= 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (!(paramObject instanceof IntList));
        paramObject = (IntList)paramObject;
        bool1 = bool2;
      } while (this.sorted != paramObject.sorted);
      bool1 = bool2;
    } while (this.size != paramObject.size);
    int i = 0;
    for (;;)
    {
      if (i >= this.size) {
        break label90;
      }
      bool1 = bool2;
      if (this.values[i] != paramObject.values[i]) {
        break;
      }
      i += 1;
    }
    label90:
    return true;
  }
  
  public int get(int paramInt)
  {
    if (paramInt >= this.size) {
      throw new IndexOutOfBoundsException("n >= size()");
    }
    try
    {
      paramInt = this.values[paramInt];
      return paramInt;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      throw new IndexOutOfBoundsException("n < 0");
    }
  }
  
  public int hashCode()
  {
    int i = 0;
    int j = 0;
    while (i < this.size)
    {
      j = j * 31 + this.values[i];
      i += 1;
    }
    return j;
  }
  
  public int indexOf(int paramInt)
  {
    paramInt = binarysearch(paramInt);
    if (paramInt >= 0) {
      return paramInt;
    }
    return -1;
  }
  
  public void insert(int paramInt1, int paramInt2)
  {
    if (paramInt1 > this.size) {
      throw new IndexOutOfBoundsException("n > size()");
    }
    growIfNeeded();
    System.arraycopy(this.values, paramInt1, this.values, paramInt1 + 1, this.size - paramInt1);
    this.values[paramInt1] = paramInt2;
    this.size += 1;
    if ((this.sorted) && ((paramInt1 == 0) || (paramInt2 > this.values[(paramInt1 - 1)])) && ((paramInt1 == this.size - 1) || (paramInt2 < this.values[(paramInt1 + 1)]))) {}
    for (boolean bool = true;; bool = false)
    {
      this.sorted = bool;
      return;
    }
  }
  
  public IntList mutableCopy()
  {
    int j = this.size;
    IntList localIntList = new IntList(j);
    int i = 0;
    while (i < j)
    {
      localIntList.add(this.values[i]);
      i += 1;
    }
    return localIntList;
  }
  
  public int pop()
  {
    throwIfImmutable();
    int i = get(this.size - 1);
    this.size -= 1;
    return i;
  }
  
  public void pop(int paramInt)
  {
    throwIfImmutable();
    this.size -= paramInt;
  }
  
  public void removeIndex(int paramInt)
  {
    if (paramInt >= this.size) {
      throw new IndexOutOfBoundsException("n >= size()");
    }
    System.arraycopy(this.values, paramInt + 1, this.values, paramInt, this.size - paramInt - 1);
    this.size -= 1;
  }
  
  public void set(int paramInt1, int paramInt2)
  {
    throwIfImmutable();
    if (paramInt1 >= this.size) {
      throw new IndexOutOfBoundsException("n >= size()");
    }
    try
    {
      this.values[paramInt1] = paramInt2;
      this.sorted = false;
      return;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      while (paramInt1 >= 0) {}
      throw new IllegalArgumentException("n < 0");
    }
  }
  
  public void shrink(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("newSize < 0");
    }
    if (paramInt > this.size) {
      throw new IllegalArgumentException("newSize > size");
    }
    throwIfImmutable();
    this.size = paramInt;
  }
  
  public int size()
  {
    return this.size;
  }
  
  public void sort()
  {
    throwIfImmutable();
    if (!this.sorted)
    {
      Arrays.sort(this.values, 0, this.size);
      this.sorted = true;
    }
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(this.size * 5 + 10);
    localStringBuffer.append('{');
    int i = 0;
    while (i < this.size)
    {
      if (i != 0) {
        localStringBuffer.append(", ");
      }
      localStringBuffer.append(this.values[i]);
      i += 1;
    }
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
  
  public int top()
  {
    return get(this.size - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.util.IntList
 * JD-Core Version:    0.7.0.1
 */