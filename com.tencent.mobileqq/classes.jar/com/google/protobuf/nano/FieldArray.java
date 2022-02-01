package com.google.protobuf.nano;

public final class FieldArray
  implements Cloneable
{
  private static final FieldData DELETED = new FieldData();
  private FieldData[] mData;
  private int[] mFieldNumbers;
  private boolean mGarbage = false;
  private int mSize;
  
  FieldArray()
  {
    this(10);
  }
  
  FieldArray(int paramInt)
  {
    paramInt = idealIntArraySize(paramInt);
    this.mFieldNumbers = new int[paramInt];
    this.mData = new FieldData[paramInt];
    this.mSize = 0;
  }
  
  private boolean arrayEquals(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (paramArrayOfInt1[i] != paramArrayOfInt2[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private boolean arrayEquals(FieldData[] paramArrayOfFieldData1, FieldData[] paramArrayOfFieldData2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (!paramArrayOfFieldData1[i].equals(paramArrayOfFieldData2[i])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private int binarySearch(int paramInt)
  {
    int i = 0;
    int j = this.mSize - 1;
    while (i <= j)
    {
      int k = i + j >>> 1;
      int m = this.mFieldNumbers[k];
      if (m < paramInt) {
        i = k + 1;
      } else if (m > paramInt) {
        j = k - 1;
      } else {
        return k;
      }
    }
    return i ^ 0xFFFFFFFF;
  }
  
  private void gc()
  {
    int m = this.mSize;
    int[] arrayOfInt = this.mFieldNumbers;
    FieldData[] arrayOfFieldData = this.mData;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      FieldData localFieldData = arrayOfFieldData[i];
      k = j;
      if (localFieldData != DELETED)
      {
        if (i != j)
        {
          arrayOfInt[j] = arrayOfInt[i];
          arrayOfFieldData[j] = localFieldData;
          arrayOfFieldData[i] = null;
        }
        k = j + 1;
      }
      i += 1;
    }
    this.mGarbage = false;
    this.mSize = j;
  }
  
  private int idealByteArraySize(int paramInt)
  {
    int i = 4;
    for (;;)
    {
      int j = paramInt;
      if (i < 32)
      {
        if (paramInt <= (1 << i) - 12) {
          j = (1 << i) - 12;
        }
      }
      else {
        return j;
      }
      i += 1;
    }
  }
  
  private int idealIntArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 4) / 4;
  }
  
  public final FieldArray clone()
  {
    int i = 0;
    int j = size();
    FieldArray localFieldArray = new FieldArray(j);
    System.arraycopy(this.mFieldNumbers, 0, localFieldArray.mFieldNumbers, 0, j);
    while (i < j)
    {
      if (this.mData[i] != null) {
        localFieldArray.mData[i] = this.mData[i].clone();
      }
      i += 1;
    }
    localFieldArray.mSize = j;
    return localFieldArray;
  }
  
  FieldData dataAt(int paramInt)
  {
    if (this.mGarbage) {
      gc();
    }
    return this.mData[paramInt];
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof FieldArray)) {
        return false;
      }
      paramObject = (FieldArray)paramObject;
      if (size() != paramObject.size()) {
        return false;
      }
    } while ((arrayEquals(this.mFieldNumbers, paramObject.mFieldNumbers, this.mSize)) && (arrayEquals(this.mData, paramObject.mData, this.mSize)));
    return false;
  }
  
  FieldData get(int paramInt)
  {
    paramInt = binarySearch(paramInt);
    if ((paramInt < 0) || (this.mData[paramInt] == DELETED)) {
      return null;
    }
    return this.mData[paramInt];
  }
  
  public int hashCode()
  {
    if (this.mGarbage) {
      gc();
    }
    int j = 17;
    int i = 0;
    while (i < this.mSize)
    {
      j = (j * 31 + this.mFieldNumbers[i]) * 31 + this.mData[i].hashCode();
      i += 1;
    }
    return j;
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  void put(int paramInt, FieldData paramFieldData)
  {
    int i = binarySearch(paramInt);
    if (i >= 0)
    {
      this.mData[i] = paramFieldData;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.mSize) && (this.mData[j] == DELETED))
    {
      this.mFieldNumbers[j] = paramInt;
      this.mData[j] = paramFieldData;
      return;
    }
    i = j;
    if (this.mGarbage)
    {
      i = j;
      if (this.mSize >= this.mFieldNumbers.length)
      {
        gc();
        i = binarySearch(paramInt) ^ 0xFFFFFFFF;
      }
    }
    if (this.mSize >= this.mFieldNumbers.length)
    {
      j = idealIntArraySize(this.mSize + 1);
      int[] arrayOfInt = new int[j];
      FieldData[] arrayOfFieldData = new FieldData[j];
      System.arraycopy(this.mFieldNumbers, 0, arrayOfInt, 0, this.mFieldNumbers.length);
      System.arraycopy(this.mData, 0, arrayOfFieldData, 0, this.mData.length);
      this.mFieldNumbers = arrayOfInt;
      this.mData = arrayOfFieldData;
    }
    if (this.mSize - i != 0)
    {
      System.arraycopy(this.mFieldNumbers, i, this.mFieldNumbers, i + 1, this.mSize - i);
      System.arraycopy(this.mData, i, this.mData, i + 1, this.mSize - i);
    }
    this.mFieldNumbers[i] = paramInt;
    this.mData[i] = paramFieldData;
    this.mSize += 1;
  }
  
  void remove(int paramInt)
  {
    paramInt = binarySearch(paramInt);
    if ((paramInt >= 0) && (this.mData[paramInt] != DELETED))
    {
      this.mData[paramInt] = DELETED;
      this.mGarbage = true;
    }
  }
  
  int size()
  {
    if (this.mGarbage) {
      gc();
    }
    return this.mSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.protobuf.nano.FieldArray
 * JD-Core Version:    0.7.0.1
 */