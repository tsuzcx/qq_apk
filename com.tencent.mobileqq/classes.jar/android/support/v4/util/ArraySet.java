package android.support.v4.util;

import android.support.annotation.RestrictTo;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class ArraySet<E>
  implements Collection<E>, Set<E>
{
  private static final int BASE_SIZE = 4;
  private static final int CACHE_SIZE = 10;
  private static final boolean DEBUG = false;
  private static final int[] INT = new int[0];
  private static final Object[] OBJECT = new Object[0];
  private static final String TAG = "ArraySet";
  static Object[] sBaseCache;
  static int sBaseCacheSize;
  static Object[] sTwiceBaseCache;
  static int sTwiceBaseCacheSize;
  Object[] mArray;
  MapCollections<E, E> mCollections;
  int[] mHashes;
  final boolean mIdentityHashCode;
  int mSize;
  
  public ArraySet()
  {
    this(0, false);
  }
  
  public ArraySet(int paramInt)
  {
    this(paramInt, false);
  }
  
  public ArraySet(int paramInt, boolean paramBoolean)
  {
    this.mIdentityHashCode = paramBoolean;
    if (paramInt == 0)
    {
      this.mHashes = INT;
      this.mArray = OBJECT;
    }
    for (;;)
    {
      this.mSize = 0;
      return;
      allocArrays(paramInt);
    }
  }
  
  public ArraySet(ArraySet<E> paramArraySet)
  {
    this();
    if (paramArraySet != null) {
      addAll(paramArraySet);
    }
  }
  
  public ArraySet(Collection<E> paramCollection)
  {
    this();
    if (paramCollection != null) {
      addAll(paramCollection);
    }
  }
  
  private void allocArrays(int paramInt)
  {
    if (paramInt == 8) {}
    for (;;)
    {
      try
      {
        if (sTwiceBaseCache != null)
        {
          Object[] arrayOfObject1 = sTwiceBaseCache;
          this.mArray = arrayOfObject1;
          sTwiceBaseCache = (Object[])(Object[])arrayOfObject1[0];
          this.mHashes = ((int[])(int[])arrayOfObject1[1]);
          arrayOfObject1[1] = null;
          arrayOfObject1[0] = null;
          sTwiceBaseCacheSize -= 1;
          return;
        }
        this.mHashes = new int[paramInt];
        this.mArray = new Object[paramInt];
        return;
      }
      finally {}
      if (paramInt == 4) {
        try
        {
          if (sBaseCache != null)
          {
            Object[] arrayOfObject2 = sBaseCache;
            this.mArray = arrayOfObject2;
            sBaseCache = (Object[])(Object[])arrayOfObject2[0];
            this.mHashes = ((int[])(int[])arrayOfObject2[1]);
            arrayOfObject2[1] = null;
            arrayOfObject2[0] = null;
            sBaseCacheSize -= 1;
            return;
          }
        }
        finally {}
      }
    }
  }
  
  private static void freeArrays(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramArrayOfInt.length == 8) {
      try
      {
        if (sTwiceBaseCacheSize < 10)
        {
          paramArrayOfObject[0] = sTwiceBaseCache;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt -= 1;
          break label113;
          sTwiceBaseCache = paramArrayOfObject;
          sTwiceBaseCacheSize += 1;
        }
        return;
      }
      finally {}
    } else {
      if (paramArrayOfInt.length != 4) {
        break label129;
      }
    }
    for (;;)
    {
      try
      {
        if (sBaseCacheSize < 10)
        {
          paramArrayOfObject[0] = sBaseCache;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt -= 1;
          break label130;
          sBaseCache = paramArrayOfObject;
          sBaseCacheSize += 1;
        }
        return;
      }
      finally {}
      label113:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
      break;
      label129:
      return;
      label130:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
    }
  }
  
  private MapCollections<E, E> getCollection()
  {
    if (this.mCollections == null) {
      this.mCollections = new ArraySet.1(this);
    }
    return this.mCollections;
  }
  
  private int indexOf(Object paramObject, int paramInt)
  {
    int m = this.mSize;
    int i;
    if (m == 0) {
      i = -1;
    }
    int j;
    do
    {
      do
      {
        return i;
        j = ContainerHelpers.binarySearch(this.mHashes, m, paramInt);
        i = j;
      } while (j < 0);
      i = j;
    } while (paramObject.equals(this.mArray[j]));
    int k = j + 1;
    while ((k < m) && (this.mHashes[k] == paramInt))
    {
      if (paramObject.equals(this.mArray[k])) {
        return k;
      }
      k += 1;
    }
    j -= 1;
    for (;;)
    {
      if ((j < 0) || (this.mHashes[j] != paramInt)) {
        break label150;
      }
      i = j;
      if (paramObject.equals(this.mArray[j])) {
        break;
      }
      j -= 1;
    }
    label150:
    return k ^ 0xFFFFFFFF;
  }
  
  private int indexOfNull()
  {
    int m = this.mSize;
    int i;
    if (m == 0) {
      i = -1;
    }
    int j;
    do
    {
      do
      {
        return i;
        j = ContainerHelpers.binarySearch(this.mHashes, m, 0);
        i = j;
      } while (j < 0);
      i = j;
    } while (this.mArray[j] == null);
    int k = j + 1;
    while ((k < m) && (this.mHashes[k] == 0))
    {
      if (this.mArray[k] == null) {
        return k;
      }
      k += 1;
    }
    j -= 1;
    for (;;)
    {
      if ((j < 0) || (this.mHashes[j] != 0)) {
        break label115;
      }
      i = j;
      if (this.mArray[j] == null) {
        break;
      }
      j -= 1;
    }
    label115:
    return k ^ 0xFFFFFFFF;
  }
  
  public boolean add(E paramE)
  {
    int k;
    int j;
    int i;
    if (paramE == null)
    {
      k = indexOfNull();
      j = 0;
      if (k >= 0) {
        return false;
      }
    }
    else
    {
      if (this.mIdentityHashCode) {}
      for (i = System.identityHashCode(paramE);; i = paramE.hashCode())
      {
        k = indexOf(paramE, i);
        j = i;
        break;
      }
    }
    k ^= 0xFFFFFFFF;
    if (this.mSize >= this.mHashes.length)
    {
      if (this.mSize < 8) {
        break label240;
      }
      i = this.mSize + (this.mSize >> 1);
    }
    for (;;)
    {
      int[] arrayOfInt = this.mHashes;
      Object[] arrayOfObject = this.mArray;
      allocArrays(i);
      if (this.mHashes.length > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.mHashes, 0, arrayOfInt.length);
        System.arraycopy(arrayOfObject, 0, this.mArray, 0, arrayOfObject.length);
      }
      freeArrays(arrayOfInt, arrayOfObject, this.mSize);
      if (k < this.mSize)
      {
        System.arraycopy(this.mHashes, k, this.mHashes, k + 1, this.mSize - k);
        System.arraycopy(this.mArray, k, this.mArray, k + 1, this.mSize - k);
      }
      this.mHashes[k] = j;
      this.mArray[k] = paramE;
      this.mSize += 1;
      return true;
      label240:
      if (this.mSize >= 4) {
        i = 8;
      } else {
        i = 4;
      }
    }
  }
  
  public void addAll(ArraySet<? extends E> paramArraySet)
  {
    int i = 0;
    int j = paramArraySet.mSize;
    ensureCapacity(this.mSize + j);
    if (this.mSize == 0) {
      if (j > 0)
      {
        System.arraycopy(paramArraySet.mHashes, 0, this.mHashes, 0, j);
        System.arraycopy(paramArraySet.mArray, 0, this.mArray, 0, j);
        this.mSize = j;
      }
    }
    for (;;)
    {
      return;
      while (i < j)
      {
        add(paramArraySet.valueAt(i));
        i += 1;
      }
    }
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    ensureCapacity(this.mSize + paramCollection.size());
    boolean bool = false;
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      bool |= add(paramCollection.next());
    }
    return bool;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void append(E paramE)
  {
    int j = this.mSize;
    int i;
    if (paramE == null) {
      i = 0;
    }
    while (j >= this.mHashes.length)
    {
      throw new IllegalStateException("Array is full");
      if (this.mIdentityHashCode) {
        i = System.identityHashCode(paramE);
      } else {
        i = paramE.hashCode();
      }
    }
    if ((j > 0) && (this.mHashes[(j - 1)] > i))
    {
      add(paramE);
      return;
    }
    this.mSize = (j + 1);
    this.mHashes[j] = i;
    this.mArray[j] = paramE;
  }
  
  public void clear()
  {
    if (this.mSize != 0)
    {
      freeArrays(this.mHashes, this.mArray, this.mSize);
      this.mHashes = INT;
      this.mArray = OBJECT;
      this.mSize = 0;
    }
  }
  
  public boolean contains(Object paramObject)
  {
    return indexOf(paramObject) >= 0;
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!contains(paramCollection.next())) {
        return false;
      }
    }
    return true;
  }
  
  public void ensureCapacity(int paramInt)
  {
    if (this.mHashes.length < paramInt)
    {
      int[] arrayOfInt = this.mHashes;
      Object[] arrayOfObject = this.mArray;
      allocArrays(paramInt);
      if (this.mSize > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.mHashes, 0, this.mSize);
        System.arraycopy(arrayOfObject, 0, this.mArray, 0, this.mSize);
      }
      freeArrays(arrayOfInt, arrayOfObject, this.mSize);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    for (;;)
    {
      return true;
      if ((paramObject instanceof Set))
      {
        paramObject = (Set)paramObject;
        if (size() != paramObject.size()) {
          return false;
        }
        int i = 0;
        try
        {
          while (i < this.mSize)
          {
            boolean bool = paramObject.contains(valueAt(i));
            if (!bool) {
              return false;
            }
            i += 1;
          }
          return false;
        }
        catch (NullPointerException paramObject)
        {
          return false;
        }
        catch (ClassCastException paramObject)
        {
          return false;
        }
      }
    }
  }
  
  public int hashCode()
  {
    int i = 0;
    int[] arrayOfInt = this.mHashes;
    int k = this.mSize;
    int j = 0;
    while (i < k)
    {
      j += arrayOfInt[i];
      i += 1;
    }
    return j;
  }
  
  public int indexOf(Object paramObject)
  {
    if (paramObject == null) {
      return indexOfNull();
    }
    if (this.mIdentityHashCode) {}
    for (int i = System.identityHashCode(paramObject);; i = paramObject.hashCode()) {
      return indexOf(paramObject, i);
    }
  }
  
  public boolean isEmpty()
  {
    return this.mSize <= 0;
  }
  
  public Iterator<E> iterator()
  {
    return getCollection().getKeySet().iterator();
  }
  
  public boolean remove(Object paramObject)
  {
    int i = indexOf(paramObject);
    if (i >= 0)
    {
      removeAt(i);
      return true;
    }
    return false;
  }
  
  public boolean removeAll(ArraySet<? extends E> paramArraySet)
  {
    boolean bool = false;
    int j = paramArraySet.mSize;
    int k = this.mSize;
    int i = 0;
    while (i < j)
    {
      remove(paramArraySet.valueAt(i));
      i += 1;
    }
    if (k != this.mSize) {
      bool = true;
    }
    return bool;
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    boolean bool = false;
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      bool |= remove(paramCollection.next());
    }
    return bool;
  }
  
  public E removeAt(int paramInt)
  {
    int i = 8;
    Object localObject = this.mArray[paramInt];
    if (this.mSize <= 1)
    {
      freeArrays(this.mHashes, this.mArray, this.mSize);
      this.mHashes = INT;
      this.mArray = OBJECT;
      this.mSize = 0;
    }
    int[] arrayOfInt;
    Object[] arrayOfObject;
    do
    {
      return localObject;
      if ((this.mHashes.length <= 8) || (this.mSize >= this.mHashes.length / 3)) {
        break;
      }
      if (this.mSize > 8) {
        i = this.mSize + (this.mSize >> 1);
      }
      arrayOfInt = this.mHashes;
      arrayOfObject = this.mArray;
      allocArrays(i);
      this.mSize -= 1;
      if (paramInt > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.mHashes, 0, paramInt);
        System.arraycopy(arrayOfObject, 0, this.mArray, 0, paramInt);
      }
    } while (paramInt >= this.mSize);
    System.arraycopy(arrayOfInt, paramInt + 1, this.mHashes, paramInt, this.mSize - paramInt);
    System.arraycopy(arrayOfObject, paramInt + 1, this.mArray, paramInt, this.mSize - paramInt);
    return localObject;
    this.mSize -= 1;
    if (paramInt < this.mSize)
    {
      System.arraycopy(this.mHashes, paramInt + 1, this.mHashes, paramInt, this.mSize - paramInt);
      System.arraycopy(this.mArray, paramInt + 1, this.mArray, paramInt, this.mSize - paramInt);
    }
    this.mArray[this.mSize] = null;
    return localObject;
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    int i = this.mSize;
    boolean bool = false;
    i -= 1;
    while (i >= 0)
    {
      if (!paramCollection.contains(this.mArray[i]))
      {
        removeAt(i);
        bool = true;
      }
      i -= 1;
    }
    return bool;
  }
  
  public int size()
  {
    return this.mSize;
  }
  
  public Object[] toArray()
  {
    Object[] arrayOfObject = new Object[this.mSize];
    System.arraycopy(this.mArray, 0, arrayOfObject, 0, this.mSize);
    return arrayOfObject;
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    if (paramArrayOfT.length < this.mSize) {
      paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), this.mSize);
    }
    for (;;)
    {
      System.arraycopy(this.mArray, 0, paramArrayOfT, 0, this.mSize);
      if (paramArrayOfT.length > this.mSize) {
        paramArrayOfT[this.mSize] = null;
      }
      return paramArrayOfT;
    }
  }
  
  public String toString()
  {
    if (isEmpty()) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(this.mSize * 14);
    localStringBuilder.append('{');
    int i = 0;
    if (i < this.mSize)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      Object localObject = valueAt(i);
      if (localObject != this) {
        localStringBuilder.append(localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append("(this Set)");
      }
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public E valueAt(int paramInt)
  {
    return this.mArray[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.util.ArraySet
 * JD-Core Version:    0.7.0.1
 */