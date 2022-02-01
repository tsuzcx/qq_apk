package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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
      return;
    }
    paramInt = ContainerHelpers.idealLongArraySize(paramInt);
    this.mKeys = new long[paramInt];
    this.mValues = new Object[paramInt];
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
    if ((this.mSize != 0) && (paramLong <= this.mKeys[(this.mSize - 1)]))
    {
      put(paramLong, paramE);
      return;
    }
    if ((this.mGarbage) && (this.mSize >= this.mKeys.length)) {
      gc();
    }
    int i = this.mSize;
    if (i >= this.mKeys.length)
    {
      int j = ContainerHelpers.idealLongArraySize(i + 1);
      long[] arrayOfLong = new long[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.mKeys, 0, arrayOfLong, 0, this.mKeys.length);
      System.arraycopy(this.mValues, 0, arrayOfObject, 0, this.mValues.length);
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
    try
    {
      LongSparseArray localLongSparseArray = (LongSparseArray)super.clone();
      localLongSparseArray.mKeys = ((long[])this.mKeys.clone());
      localLongSparseArray.mValues = ((Object[])this.mValues.clone());
      return localLongSparseArray;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
  }
  
  public boolean containsKey(long paramLong)
  {
    return indexOfKey(paramLong) >= 0;
  }
  
  public boolean containsValue(E paramE)
  {
    return indexOfValue(paramE) >= 0;
  }
  
  @Deprecated
  public void delete(long paramLong)
  {
    remove(paramLong);
  }
  
  @Nullable
  public E get(long paramLong)
  {
    return get(paramLong, null);
  }
  
  public E get(long paramLong, E paramE)
  {
    int i = ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramLong);
    if ((i < 0) || (this.mValues[i] == DELETED)) {
      return paramE;
    }
    return this.mValues[i];
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
  
  public boolean isEmpty()
  {
    return size() == 0;
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
    if ((j < this.mSize) && (this.mValues[j] == DELETED))
    {
      this.mKeys[j] = paramLong;
      this.mValues[j] = paramE;
      return;
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
    if (this.mSize >= this.mKeys.length)
    {
      j = ContainerHelpers.idealLongArraySize(this.mSize + 1);
      long[] arrayOfLong = new long[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.mKeys, 0, arrayOfLong, 0, this.mKeys.length);
      System.arraycopy(this.mValues, 0, arrayOfObject, 0, this.mValues.length);
      this.mKeys = arrayOfLong;
      this.mValues = arrayOfObject;
    }
    if (this.mSize - i != 0)
    {
      System.arraycopy(this.mKeys, i, this.mKeys, i + 1, this.mSize - i);
      System.arraycopy(this.mValues, i, this.mValues, i + 1, this.mSize - i);
    }
    this.mKeys[i] = paramLong;
    this.mValues[i] = paramE;
    this.mSize += 1;
  }
  
  public void putAll(@NonNull LongSparseArray<? extends E> paramLongSparseArray)
  {
    int i = 0;
    int j = paramLongSparseArray.size();
    while (i < j)
    {
      put(paramLongSparseArray.keyAt(i), paramLongSparseArray.valueAt(i));
      i += 1;
    }
  }
  
  @Nullable
  public E putIfAbsent(long paramLong, E paramE)
  {
    Object localObject = get(paramLong);
    if (localObject == null) {
      put(paramLong, paramE);
    }
    return localObject;
  }
  
  public void remove(long paramLong)
  {
    int i = ContainerHelpers.binarySearch(this.mKeys, this.mSize, paramLong);
    if ((i >= 0) && (this.mValues[i] != DELETED))
    {
      this.mValues[i] = DELETED;
      this.mGarbage = true;
    }
  }
  
  public boolean remove(long paramLong, Object paramObject)
  {
    int i = indexOfKey(paramLong);
    if (i >= 0)
    {
      Object localObject = valueAt(i);
      if ((paramObject == localObject) || ((paramObject != null) && (paramObject.equals(localObject))))
      {
        removeAt(i);
        return true;
      }
    }
    return false;
  }
  
  public void removeAt(int paramInt)
  {
    if (this.mValues[paramInt] != DELETED)
    {
      this.mValues[paramInt] = DELETED;
      this.mGarbage = true;
    }
  }
  
  @Nullable
  public E replace(long paramLong, E paramE)
  {
    int i = indexOfKey(paramLong);
    if (i >= 0)
    {
      Object localObject = this.mValues[i];
      this.mValues[i] = paramE;
      return localObject;
    }
    return null;
  }
  
  public boolean replace(long paramLong, E paramE1, E paramE2)
  {
    int i = indexOfKey(paramLong);
    if (i >= 0)
    {
      Object localObject = this.mValues[i];
      if ((localObject == paramE1) || ((paramE1 != null) && (paramE1.equals(localObject))))
      {
        this.mValues[i] = paramE2;
        return true;
      }
    }
    return false;
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
    if (i < this.mSize)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(keyAt(i));
      localStringBuilder.append('=');
      Object localObject = valueAt(i);
      if (localObject != this) {
        localStringBuilder.append(localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append("(this Map)");
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.collection.LongSparseArray
 * JD-Core Version:    0.7.0.1
 */