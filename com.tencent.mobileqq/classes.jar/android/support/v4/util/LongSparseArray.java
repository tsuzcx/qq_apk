package android.support.v4.util;

public class LongSparseArray<E>
  implements Cloneable
{
  private static final Object DELETED = new Object();
  private boolean mGarbage = false;
  private long[] mKeys;
  private int mSize;
  private Object[] mValues;
  
  public LongSparseArray()
  {
    this(10);
  }
  
  public LongSparseArray(int paramInt)
  {
    if (paramInt == 0)
    {
      this.mKeys = ContainerHelpers.EMPTY_LONGS;
      this.mValues = ContainerHelpers.EMPTY_OBJECTS;
    }
    else
    {
      paramInt = ContainerHelpers.idealLongArraySize(paramInt);
      this.mKeys = new long[paramInt];
      this.mValues = new Object[paramInt];
    }
    this.mSize = 0;
  }
  
  private void gc()
  {
    int m = this.mSize;
    long[] arrayOfLong = this.mKeys;
    Object[] arrayOfObject = this.mValues;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      Object localObject = arrayOfObject[i];
      k = j;
      if (localObject != DELETED)
      {
        if (i != j)
        {
          arrayOfLong[j] = arrayOfLong[i];
          arrayOfObject[j] = localObject;
          arrayOfObject[i] = null;
        }
        k = j + 1;
      }
      i += 1;
    }
    this.mGarbage = false;
    this.mSize = j;
  }
  
  public void append(long paramLong, E paramE)
  {
    int i = this.mSize;
    if ((i != 0) && (paramLong <= this.mKeys[(i - 1)]))
    {
      put(paramLong, paramE);
      return;
    }
    if ((this.mGarbage) && (this.mSize >= this.mKeys.length)) {
      gc();
    }
    i = this.mSize;
    if (i >= this.mKeys.length)
    {
      int j = ContainerHelpers.idealLongArraySize(i + 1);
      long[] arrayOfLong = new long[j];
      Object[] arrayOfObject = new Object[j];
      Object localObject = this.mKeys;
      System.arraycopy(localObject, 0, arrayOfLong, 0, localObject.length);
      localObject = this.mValues;
      System.arraycopy(localObject, 0, arrayOfObject, 0, localObject.length);
      this.mKeys = arrayOfLong;
      this.mValues = arrayOfObject;
    }
    this.mKeys[i] = paramLong;
    this.mValues[i] = paramE;
    this.mSize = (i + 1);
  }
  
  public void clear()
  {
    int j = this.mSize;
    Object[] arrayOfObject = this.mValues;
    int i = 0;
    while (i < j)
    {
      arrayOfObject[i] = null;
      i += 1;
    }
    this.mSize = 0;
    this.mGarbage = false;
  }
  
  public LongSparseArray<E> clone()
  {
    for (;;)
    {
      try
      {
        localLongSparseArray = (LongSparseArray)super.clone();
      }
      catch (CloneNotSupportedException localCloneNotSupportedException1)
      {
        LongSparseArray localLongSparseArray;
        continue;
        return localCloneNotSupportedException1;
      }
      try
      {
        localLongSparseArray.mKeys = ((long[])this.mKeys.clone());
        localLongSparseArray.mValues = ((Object[])this.mValues.clone());
        return localLongSparseArray;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException2) {}
    }
    return null;
  }
  
  public void delete(long paramLong)
  {
    int i = ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramLong);
    if (i >= 0)
    {
      Object[] arrayOfObject = this.mValues;
      Object localObject1 = arrayOfObject[i];
      Object localObject2 = DELETED;
      if (localObject1 != localObject2)
      {
        arrayOfObject[i] = localObject2;
        this.mGarbage = true;
      }
    }
  }
  
  public E get(long paramLong)
  {
    return get(paramLong, null);
  }
  
  public E get(long paramLong, E paramE)
  {
    int i = ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramLong);
    if (i >= 0)
    {
      Object[] arrayOfObject = this.mValues;
      if (arrayOfObject[i] == DELETED) {
        return paramE;
      }
      return arrayOfObject[i];
    }
    return paramE;
  }
  
  public int indexOfKey(long paramLong)
  {
    if (this.mGarbage) {
      gc();
    }
    return ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramLong);
  }
  
  public int indexOfValue(E paramE)
  {
    if (this.mGarbage) {
      gc();
    }
    int i = 0;
    while (i < this.mSize)
    {
      if (this.mValues[i] == paramE) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public long keyAt(int paramInt)
  {
    if (this.mGarbage) {
      gc();
    }
    return this.mKeys[paramInt];
  }
  
  public void put(long paramLong, E paramE)
  {
    int i = ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramLong);
    if (i >= 0)
    {
      this.mValues[i] = paramE;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    Object localObject1;
    if (j < this.mSize)
    {
      localObject1 = this.mValues;
      if (localObject1[j] == DELETED)
      {
        this.mKeys[j] = paramLong;
        localObject1[j] = paramE;
        return;
      }
    }
    i = j;
    if (this.mGarbage)
    {
      i = j;
      if (this.mSize >= this.mKeys.length)
      {
        gc();
        i = ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramLong) ^ 0xFFFFFFFF;
      }
    }
    j = this.mSize;
    if (j >= this.mKeys.length)
    {
      j = ContainerHelpers.idealLongArraySize(j + 1);
      localObject1 = new long[j];
      Object[] arrayOfObject = new Object[j];
      Object localObject2 = this.mKeys;
      System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
      localObject2 = this.mValues;
      System.arraycopy(localObject2, 0, arrayOfObject, 0, localObject2.length);
      this.mKeys = ((long[])localObject1);
      this.mValues = arrayOfObject;
    }
    j = this.mSize;
    if (j - i != 0)
    {
      localObject1 = this.mKeys;
      int k = i + 1;
      System.arraycopy(localObject1, i, localObject1, k, j - i);
      localObject1 = this.mValues;
      System.arraycopy(localObject1, i, localObject1, k, this.mSize - i);
    }
    this.mKeys[i] = paramLong;
    this.mValues[i] = paramE;
    this.mSize += 1;
  }
  
  public void remove(long paramLong)
  {
    delete(paramLong);
  }
  
  public void removeAt(int paramInt)
  {
    Object[] arrayOfObject = this.mValues;
    Object localObject1 = arrayOfObject[paramInt];
    Object localObject2 = DELETED;
    if (localObject1 != localObject2)
    {
      arrayOfObject[paramInt] = localObject2;
      this.mGarbage = true;
    }
  }
  
  public void setValueAt(int paramInt, E paramE)
  {
    if (this.mGarbage) {
      gc();
    }
    this.mValues[paramInt] = paramE;
  }
  
  public int size()
  {
    if (this.mGarbage) {
      gc();
    }
    return this.mSize;
  }
  
  public String toString()
  {
    if (size() <= 0) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(this.mSize * 28);
    localStringBuilder.append('{');
    int i = 0;
    while (i < this.mSize)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(keyAt(i));
      localStringBuilder.append('=');
      Object localObject = valueAt(i);
      if (localObject != this) {
        localStringBuilder.append(localObject);
      } else {
        localStringBuilder.append("(this Map)");
      }
      i += 1;
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public E valueAt(int paramInt)
  {
    if (this.mGarbage) {
      gc();
    }
    return this.mValues[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.util.LongSparseArray
 * JD-Core Version:    0.7.0.1
 */