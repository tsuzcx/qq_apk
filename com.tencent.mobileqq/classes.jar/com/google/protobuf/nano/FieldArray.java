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
    int j = this.mSize - 1;
    int i = 0;
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
    while (i < 32)
    {
      int j = (1 << i) - 12;
      if (paramInt <= j) {
        return j;
      }
      i += 1;
    }
    return paramInt;
  }
  
  private int idealIntArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt * 4) / 4;
  }
  
  public final FieldArray clone()
  {
    int j = size();
    FieldArray localFieldArray = new FieldArray(j);
    Object localObject = this.mFieldNumbers;
    int[] arrayOfInt = localFieldArray.mFieldNumbers;
    int i = 0;
    System.arraycopy(localObject, 0, arrayOfInt, 0, j);
    while (i < j)
    {
      localObject = this.mData;
      if (localObject[i] != null) {
        localFieldArray.mData[i] = localObject[i].clone();
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
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof FieldArray)) {
      return false;
    }
    paramObject = (FieldArray)paramObject;
    if (size() != paramObject.size()) {
      return false;
    }
    return (arrayEquals(this.mFieldNumbers, paramObject.mFieldNumbers, this.mSize)) && (arrayEquals(this.mData, paramObject.mData, this.mSize));
  }
  
  FieldData get(int paramInt)
  {
    paramInt = binarySearch(paramInt);
    if (paramInt >= 0)
    {
      FieldData[] arrayOfFieldData = this.mData;
      if (arrayOfFieldData[paramInt] != DELETED) {
        return arrayOfFieldData[paramInt];
      }
    }
    return null;
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
    Object localObject1;
    if (j < this.mSize)
    {
      localObject1 = this.mData;
      if (localObject1[j] == DELETED)
      {
        this.mFieldNumbers[j] = paramInt;
        localObject1[j] = paramFieldData;
        return;
      }
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
    j = this.mSize;
    if (j >= this.mFieldNumbers.length)
    {
      j = idealIntArraySize(j + 1);
      localObject1 = new int[j];
      FieldData[] arrayOfFieldData = new FieldData[j];
      Object localObject2 = this.mFieldNumbers;
      System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
      localObject2 = this.mData;
      System.arraycopy(localObject2, 0, arrayOfFieldData, 0, localObject2.length);
      this.mFieldNumbers = ((int[])localObject1);
      this.mData = arrayOfFieldData;
    }
    j = this.mSize;
    if (j - i != 0)
    {
      localObject1 = this.mFieldNumbers;
      int k = i + 1;
      System.arraycopy(localObject1, i, localObject1, k, j - i);
      localObject1 = this.mData;
      System.arraycopy(localObject1, i, localObject1, k, this.mSize - i);
    }
    this.mFieldNumbers[i] = paramInt;
    this.mData[i] = paramFieldData;
    this.mSize += 1;
  }
  
  void remove(int paramInt)
  {
    paramInt = binarySearch(paramInt);
    if (paramInt >= 0)
    {
      FieldData[] arrayOfFieldData = this.mData;
      FieldData localFieldData1 = arrayOfFieldData[paramInt];
      FieldData localFieldData2 = DELETED;
      if (localFieldData1 != localFieldData2)
      {
        arrayOfFieldData[paramInt] = localFieldData2;
        this.mGarbage = true;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.protobuf.nano.FieldArray
 * JD-Core Version:    0.7.0.1
 */