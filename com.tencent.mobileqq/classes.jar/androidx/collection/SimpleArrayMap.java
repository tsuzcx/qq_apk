package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ConcurrentModificationException;
import java.util.Map;

public class SimpleArrayMap<K, V>
{
  private static final int BASE_SIZE = 4;
  private static final int CACHE_SIZE = 10;
  private static final boolean CONCURRENT_MODIFICATION_EXCEPTIONS = true;
  private static final boolean DEBUG = false;
  private static final String TAG = "ArrayMap";
  @Nullable
  static Object[] mBaseCache;
  static int mBaseCacheSize;
  @Nullable
  static Object[] mTwiceBaseCache;
  static int mTwiceBaseCacheSize;
  Object[] mArray;
  int[] mHashes;
  int mSize;
  
  public SimpleArrayMap()
  {
    this.mHashes = ContainerHelpers.EMPTY_INTS;
    this.mArray = ContainerHelpers.EMPTY_OBJECTS;
    this.mSize = 0;
  }
  
  public SimpleArrayMap(int paramInt)
  {
    if (paramInt == 0)
    {
      this.mHashes = ContainerHelpers.EMPTY_INTS;
      this.mArray = ContainerHelpers.EMPTY_OBJECTS;
    }
    else
    {
      allocArrays(paramInt);
    }
    this.mSize = 0;
  }
  
  public SimpleArrayMap(SimpleArrayMap<K, V> paramSimpleArrayMap)
  {
    this();
    if (paramSimpleArrayMap != null) {
      putAll(paramSimpleArrayMap);
    }
  }
  
  private void allocArrays(int paramInt)
  {
    if (paramInt == 8) {
      try
      {
        if (mTwiceBaseCache != null)
        {
          Object[] arrayOfObject1 = mTwiceBaseCache;
          this.mArray = arrayOfObject1;
          mTwiceBaseCache = (Object[])arrayOfObject1[0];
          this.mHashes = ((int[])arrayOfObject1[1]);
          arrayOfObject1[1] = null;
          arrayOfObject1[0] = null;
          mTwiceBaseCacheSize -= 1;
          return;
        }
      }
      finally {}
    } else if (paramInt == 4) {
      try
      {
        if (mBaseCache != null)
        {
          Object[] arrayOfObject2 = mBaseCache;
          this.mArray = arrayOfObject2;
          mBaseCache = (Object[])arrayOfObject2[0];
          this.mHashes = ((int[])arrayOfObject2[1]);
          arrayOfObject2[1] = null;
          arrayOfObject2[0] = null;
          mBaseCacheSize -= 1;
          return;
        }
      }
      finally {}
    }
    this.mHashes = new int[paramInt];
    this.mArray = new Object[paramInt << 1];
  }
  
  private static int binarySearchHashes(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 = ContainerHelpers.binarySearch(paramArrayOfInt, paramInt1, paramInt2);
      return paramInt1;
    }
    catch (ArrayIndexOutOfBoundsException paramArrayOfInt)
    {
      label9:
      break label9;
    }
    throw new ConcurrentModificationException();
  }
  
  private static void freeArrays(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramArrayOfInt.length == 8) {
      try
      {
        if (mTwiceBaseCacheSize < 10)
        {
          paramArrayOfObject[0] = mTwiceBaseCache;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt = (paramInt << 1) - 1;
          break label118;
          mTwiceBaseCache = paramArrayOfObject;
          mTwiceBaseCacheSize += 1;
        }
        return;
      }
      finally {}
    } else if (paramArrayOfInt.length != 4) {}
    for (;;)
    {
      try
      {
        if (mBaseCacheSize < 10)
        {
          paramArrayOfObject[0] = mBaseCache;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt = (paramInt << 1) - 1;
          break label134;
          mBaseCache = paramArrayOfObject;
          mBaseCacheSize += 1;
        }
        return;
      }
      finally {}
      return;
      label118:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
      break;
      label134:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
    }
  }
  
  public void clear()
  {
    int i = this.mSize;
    if (i > 0)
    {
      int[] arrayOfInt = this.mHashes;
      Object[] arrayOfObject = this.mArray;
      this.mHashes = ContainerHelpers.EMPTY_INTS;
      this.mArray = ContainerHelpers.EMPTY_OBJECTS;
      this.mSize = 0;
      freeArrays(arrayOfInt, arrayOfObject, i);
    }
    if (this.mSize <= 0) {
      return;
    }
    throw new ConcurrentModificationException();
  }
  
  public boolean containsKey(@Nullable Object paramObject)
  {
    return indexOfKey(paramObject) >= 0;
  }
  
  public boolean containsValue(Object paramObject)
  {
    return indexOfValue(paramObject) >= 0;
  }
  
  public void ensureCapacity(int paramInt)
  {
    int i = this.mSize;
    int[] arrayOfInt = this.mHashes;
    if (arrayOfInt.length < paramInt)
    {
      Object[] arrayOfObject = this.mArray;
      allocArrays(paramInt);
      if (this.mSize > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.mHashes, 0, i);
        System.arraycopy(arrayOfObject, 0, this.mArray, 0, i << 1);
      }
      freeArrays(arrayOfInt, arrayOfObject, i);
    }
    if (this.mSize == i) {
      return;
    }
    throw new ConcurrentModificationException();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    int i;
    if ((paramObject instanceof SimpleArrayMap))
    {
      paramObject = (SimpleArrayMap)paramObject;
      if (size() != paramObject.size()) {
        return false;
      }
      i = 0;
    }
    try
    {
      while (i < this.mSize)
      {
        localObject1 = keyAt(i);
        localObject2 = valueAt(i);
        localObject3 = paramObject.get(localObject1);
        if (localObject2 == null)
        {
          if (localObject3 != null) {
            break label223;
          }
          if (!paramObject.containsKey(localObject1)) {
            return false;
          }
        }
        else
        {
          bool = localObject2.equals(localObject3);
          if (!bool) {
            return false;
          }
        }
        i += 1;
      }
      return true;
    }
    catch (NullPointerException|ClassCastException paramObject)
    {
      Object localObject1;
      Object localObject2;
      Object localObject3;
      boolean bool;
      return false;
    }
    if ((paramObject instanceof Map))
    {
      paramObject = (Map)paramObject;
      if (size() != paramObject.size()) {
        return false;
      }
      i = 0;
    }
    try
    {
      while (i < this.mSize)
      {
        localObject1 = keyAt(i);
        localObject2 = valueAt(i);
        localObject3 = paramObject.get(localObject1);
        if (localObject2 == null)
        {
          if (localObject3 != null) {
            break label225;
          }
          if (!paramObject.containsKey(localObject1)) {
            return false;
          }
        }
        else
        {
          bool = localObject2.equals(localObject3);
          if (!bool) {
            return false;
          }
        }
        i += 1;
      }
      return true;
    }
    catch (NullPointerException|ClassCastException paramObject)
    {
      return false;
    }
    return false;
    label223:
    return false;
    label225:
    return false;
  }
  
  @Nullable
  public V get(Object paramObject)
  {
    return getOrDefault(paramObject, null);
  }
  
  public V getOrDefault(Object paramObject, V paramV)
  {
    int i = indexOfKey(paramObject);
    if (i >= 0) {
      paramV = this.mArray[((i << 1) + 1)];
    }
    return paramV;
  }
  
  public int hashCode()
  {
    int[] arrayOfInt = this.mHashes;
    Object[] arrayOfObject = this.mArray;
    int n = this.mSize;
    int j = 0;
    int k = 0;
    int i = 1;
    while (j < n)
    {
      Object localObject = arrayOfObject[i];
      int i1 = arrayOfInt[j];
      int m;
      if (localObject == null) {
        m = 0;
      } else {
        m = localObject.hashCode();
      }
      k += (m ^ i1);
      j += 1;
      i += 2;
    }
    return k;
  }
  
  int indexOf(Object paramObject, int paramInt)
  {
    int j = this.mSize;
    if (j == 0) {
      return -1;
    }
    int k = binarySearchHashes(this.mHashes, j, paramInt);
    if (k < 0) {
      return k;
    }
    if (paramObject.equals(this.mArray[(k << 1)])) {
      return k;
    }
    int i = k + 1;
    while ((i < j) && (this.mHashes[i] == paramInt))
    {
      if (paramObject.equals(this.mArray[(i << 1)])) {
        return i;
      }
      i += 1;
    }
    j = k - 1;
    while ((j >= 0) && (this.mHashes[j] == paramInt))
    {
      if (paramObject.equals(this.mArray[(j << 1)])) {
        return j;
      }
      j -= 1;
    }
    return i ^ 0xFFFFFFFF;
  }
  
  public int indexOfKey(@Nullable Object paramObject)
  {
    if (paramObject == null) {
      return indexOfNull();
    }
    return indexOf(paramObject, paramObject.hashCode());
  }
  
  int indexOfNull()
  {
    int j = this.mSize;
    if (j == 0) {
      return -1;
    }
    int k = binarySearchHashes(this.mHashes, j, 0);
    if (k < 0) {
      return k;
    }
    if (this.mArray[(k << 1)] == null) {
      return k;
    }
    int i = k + 1;
    while ((i < j) && (this.mHashes[i] == 0))
    {
      if (this.mArray[(i << 1)] == null) {
        return i;
      }
      i += 1;
    }
    j = k - 1;
    while ((j >= 0) && (this.mHashes[j] == 0))
    {
      if (this.mArray[(j << 1)] == null) {
        return j;
      }
      j -= 1;
    }
    return i ^ 0xFFFFFFFF;
  }
  
  int indexOfValue(Object paramObject)
  {
    int j = this.mSize * 2;
    Object[] arrayOfObject = this.mArray;
    if (paramObject == null)
    {
      i = 1;
      while (i < j)
      {
        if (arrayOfObject[i] == null) {
          return i >> 1;
        }
        i += 2;
      }
    }
    int i = 1;
    while (i < j)
    {
      if (paramObject.equals(arrayOfObject[i])) {
        return i >> 1;
      }
      i += 2;
    }
    return -1;
  }
  
  public boolean isEmpty()
  {
    return this.mSize <= 0;
  }
  
  public K keyAt(int paramInt)
  {
    return this.mArray[(paramInt << 1)];
  }
  
  @Nullable
  public V put(K paramK, V paramV)
  {
    int k = this.mSize;
    int j;
    if (paramK == null)
    {
      i = indexOfNull();
      j = 0;
    }
    else
    {
      j = paramK.hashCode();
      i = indexOf(paramK, j);
    }
    Object localObject;
    if (i >= 0)
    {
      i = (i << 1) + 1;
      paramK = this.mArray;
      localObject = paramK[i];
      paramK[i] = paramV;
      return localObject;
    }
    int m = i ^ 0xFFFFFFFF;
    if (k >= this.mHashes.length)
    {
      i = 4;
      if (k >= 8) {
        i = (k >> 1) + k;
      } else if (k >= 4) {
        i = 8;
      }
      localObject = this.mHashes;
      Object[] arrayOfObject = this.mArray;
      allocArrays(i);
      if (k == this.mSize)
      {
        int[] arrayOfInt = this.mHashes;
        if (arrayOfInt.length > 0)
        {
          System.arraycopy(localObject, 0, arrayOfInt, 0, localObject.length);
          System.arraycopy(arrayOfObject, 0, this.mArray, 0, arrayOfObject.length);
        }
        freeArrays((int[])localObject, arrayOfObject, k);
      }
      else
      {
        throw new ConcurrentModificationException();
      }
    }
    if (m < k)
    {
      localObject = this.mHashes;
      i = m + 1;
      System.arraycopy(localObject, m, localObject, i, k - m);
      localObject = this.mArray;
      System.arraycopy(localObject, m << 1, localObject, i << 1, this.mSize - m << 1);
    }
    int i = this.mSize;
    if (k == i)
    {
      localObject = this.mHashes;
      if (m < localObject.length)
      {
        localObject[m] = j;
        localObject = this.mArray;
        j = m << 1;
        localObject[j] = paramK;
        localObject[(j + 1)] = paramV;
        this.mSize = (i + 1);
        return null;
      }
    }
    throw new ConcurrentModificationException();
  }
  
  public void putAll(@NonNull SimpleArrayMap<? extends K, ? extends V> paramSimpleArrayMap)
  {
    int j = paramSimpleArrayMap.mSize;
    ensureCapacity(this.mSize + j);
    int k = this.mSize;
    int i = 0;
    if (k == 0)
    {
      if (j > 0)
      {
        System.arraycopy(paramSimpleArrayMap.mHashes, 0, this.mHashes, 0, j);
        System.arraycopy(paramSimpleArrayMap.mArray, 0, this.mArray, 0, j << 1);
        this.mSize = j;
      }
    }
    else {
      while (i < j)
      {
        put(paramSimpleArrayMap.keyAt(i), paramSimpleArrayMap.valueAt(i));
        i += 1;
      }
    }
  }
  
  @Nullable
  public V putIfAbsent(K paramK, V paramV)
  {
    Object localObject2 = get(paramK);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = put(paramK, paramV);
    }
    return localObject1;
  }
  
  @Nullable
  public V remove(Object paramObject)
  {
    int i = indexOfKey(paramObject);
    if (i >= 0) {
      return removeAt(i);
    }
    return null;
  }
  
  public boolean remove(Object paramObject1, Object paramObject2)
  {
    int i = indexOfKey(paramObject1);
    if (i >= 0)
    {
      paramObject1 = valueAt(i);
      if ((paramObject2 == paramObject1) || ((paramObject2 != null) && (paramObject2.equals(paramObject1))))
      {
        removeAt(i);
        return true;
      }
    }
    return false;
  }
  
  public V removeAt(int paramInt)
  {
    Object localObject = this.mArray;
    int m = paramInt << 1;
    V ? = localObject[(m + 1)];
    int k = this.mSize;
    int i;
    if (k <= 1)
    {
      freeArrays(this.mHashes, (Object[])localObject, k);
      this.mHashes = ContainerHelpers.EMPTY_INTS;
      this.mArray = ContainerHelpers.EMPTY_OBJECTS;
      i = 0;
    }
    else
    {
      int j = k - 1;
      localObject = this.mHashes;
      int n = localObject.length;
      i = 8;
      if ((n > 8) && (k < localObject.length / 3))
      {
        if (k > 8) {
          i = k + (k >> 1);
        }
        localObject = this.mHashes;
        Object[] arrayOfObject = this.mArray;
        allocArrays(i);
        if (k == this.mSize)
        {
          if (paramInt > 0)
          {
            System.arraycopy(localObject, 0, this.mHashes, 0, paramInt);
            System.arraycopy(arrayOfObject, 0, this.mArray, 0, m);
          }
          i = j;
          if (paramInt < j)
          {
            i = paramInt + 1;
            int[] arrayOfInt = this.mHashes;
            n = j - paramInt;
            System.arraycopy(localObject, i, arrayOfInt, paramInt, n);
            System.arraycopy(arrayOfObject, i << 1, this.mArray, m, n << 1);
            i = j;
          }
        }
        else
        {
          throw new ConcurrentModificationException();
        }
      }
      else
      {
        if (paramInt < j)
        {
          localObject = this.mHashes;
          i = paramInt + 1;
          n = j - paramInt;
          System.arraycopy(localObject, i, localObject, paramInt, n);
          localObject = this.mArray;
          System.arraycopy(localObject, i << 1, localObject, m, n << 1);
        }
        localObject = this.mArray;
        paramInt = j << 1;
        localObject[paramInt] = null;
        localObject[(paramInt + 1)] = null;
        i = j;
      }
    }
    if (k == this.mSize)
    {
      this.mSize = i;
      return ?;
    }
    throw new ConcurrentModificationException();
  }
  
  @Nullable
  public V replace(K paramK, V paramV)
  {
    int i = indexOfKey(paramK);
    if (i >= 0) {
      return setValueAt(i, paramV);
    }
    return null;
  }
  
  public boolean replace(K paramK, V paramV1, V paramV2)
  {
    int i = indexOfKey(paramK);
    if (i >= 0)
    {
      paramK = valueAt(i);
      if ((paramK == paramV1) || ((paramV1 != null) && (paramV1.equals(paramK))))
      {
        setValueAt(i, paramV2);
        return true;
      }
    }
    return false;
  }
  
  public V setValueAt(int paramInt, V paramV)
  {
    paramInt = (paramInt << 1) + 1;
    Object[] arrayOfObject = this.mArray;
    Object localObject = arrayOfObject[paramInt];
    arrayOfObject[paramInt] = paramV;
    return localObject;
  }
  
  public int size()
  {
    return this.mSize;
  }
  
  public String toString()
  {
    if (isEmpty()) {
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
      Object localObject = keyAt(i);
      if (localObject != this) {
        localStringBuilder.append(localObject);
      } else {
        localStringBuilder.append("(this Map)");
      }
      localStringBuilder.append('=');
      localObject = valueAt(i);
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
  
  public V valueAt(int paramInt)
  {
    return this.mArray[((paramInt << 1) + 1)];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.collection.SimpleArrayMap
 * JD-Core Version:    0.7.0.1
 */