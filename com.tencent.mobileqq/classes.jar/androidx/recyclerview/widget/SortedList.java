package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

public class SortedList<T>
{
  private static final int CAPACITY_GROWTH = 10;
  private static final int DELETION = 2;
  private static final int INSERTION = 1;
  public static final int INVALID_POSITION = -1;
  private static final int LOOKUP = 4;
  private static final int MIN_CAPACITY = 10;
  private SortedList.BatchedCallback mBatchedCallback;
  private SortedList.Callback mCallback;
  T[] mData;
  private int mNewDataStart;
  private T[] mOldData;
  private int mOldDataSize;
  private int mOldDataStart;
  private int mSize;
  private final Class<T> mTClass;
  
  public SortedList(@NonNull Class<T> paramClass, @NonNull SortedList.Callback<T> paramCallback)
  {
    this(paramClass, paramCallback, 10);
  }
  
  public SortedList(@NonNull Class<T> paramClass, @NonNull SortedList.Callback<T> paramCallback, int paramInt)
  {
    this.mTClass = paramClass;
    this.mData = ((Object[])Array.newInstance(paramClass, paramInt));
    this.mCallback = paramCallback;
    this.mSize = 0;
  }
  
  private int add(T paramT, boolean paramBoolean)
  {
    int i = 0;
    int j = findIndexOf(paramT, this.mData, 0, this.mSize, 1);
    if (j == -1) {}
    for (;;)
    {
      addToData(i, paramT);
      if (paramBoolean) {
        this.mCallback.onInserted(i, 1);
      }
      return i;
      if (j < this.mSize)
      {
        Object localObject = this.mData[j];
        if (this.mCallback.areItemsTheSame(localObject, paramT))
        {
          if (this.mCallback.areContentsTheSame(localObject, paramT))
          {
            this.mData[j] = paramT;
            return j;
          }
          this.mData[j] = paramT;
          this.mCallback.onChanged(j, 1, this.mCallback.getChangePayload(localObject, paramT));
          return j;
        }
      }
      i = j;
    }
  }
  
  private void addAllInternal(T[] paramArrayOfT)
  {
    if (paramArrayOfT.length < 1) {
      return;
    }
    int i = sortAndDedup(paramArrayOfT);
    if (this.mSize == 0)
    {
      this.mData = paramArrayOfT;
      this.mSize = i;
      this.mCallback.onInserted(0, i);
      return;
    }
    merge(paramArrayOfT, i);
  }
  
  private void addToData(int paramInt, T paramT)
  {
    if (paramInt > this.mSize) {
      throw new IndexOutOfBoundsException("cannot add item to " + paramInt + " because size is " + this.mSize);
    }
    if (this.mSize == this.mData.length)
    {
      Object[] arrayOfObject = (Object[])Array.newInstance(this.mTClass, this.mData.length + 10);
      System.arraycopy(this.mData, 0, arrayOfObject, 0, paramInt);
      arrayOfObject[paramInt] = paramT;
      System.arraycopy(this.mData, paramInt, arrayOfObject, paramInt + 1, this.mSize - paramInt);
      this.mData = arrayOfObject;
    }
    for (;;)
    {
      this.mSize += 1;
      return;
      System.arraycopy(this.mData, paramInt, this.mData, paramInt + 1, this.mSize - paramInt);
      this.mData[paramInt] = paramT;
    }
  }
  
  private T[] copyArray(T[] paramArrayOfT)
  {
    Object[] arrayOfObject = (Object[])Array.newInstance(this.mTClass, paramArrayOfT.length);
    System.arraycopy(paramArrayOfT, 0, arrayOfObject, 0, paramArrayOfT.length);
    return arrayOfObject;
  }
  
  private int findIndexOf(T paramT, T[] paramArrayOfT, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 < paramInt2)
    {
      int i = (paramInt1 + paramInt2) / 2;
      T ? = paramArrayOfT[i];
      int j = this.mCallback.compare(?, paramT);
      if (j < 0)
      {
        i += 1;
        paramInt1 = paramInt2;
        paramInt2 = i;
      }
      for (;;)
      {
        i = paramInt2;
        paramInt2 = paramInt1;
        paramInt1 = i;
        break;
        if (j == 0)
        {
          if (this.mCallback.areItemsTheSame(?, paramT)) {}
          do
          {
            return i;
            paramInt1 = linearEqualitySearch(paramT, i, paramInt1, paramInt2);
            if (paramInt3 != 1) {
              break;
            }
          } while (paramInt1 == -1);
          return paramInt1;
          return paramInt1;
        }
        paramInt2 = paramInt1;
        paramInt1 = i;
      }
    }
    if (paramInt3 == 1) {}
    for (;;)
    {
      return paramInt1;
      paramInt1 = -1;
    }
  }
  
  private int findSameItem(T paramT, T[] paramArrayOfT, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      if (this.mCallback.areItemsTheSame(paramArrayOfT[paramInt1], paramT)) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return -1;
  }
  
  private int linearEqualitySearch(T paramT, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = paramInt1 - 1;
    Object localObject;
    if (j >= paramInt2)
    {
      localObject = this.mData[j];
      if (this.mCallback.compare(localObject, paramT) == 0) {}
    }
    else
    {
      paramInt1 += 1;
    }
    for (;;)
    {
      int i;
      if (paramInt1 < paramInt3)
      {
        localObject = this.mData[paramInt1];
        if (this.mCallback.compare(localObject, paramT) == 0) {}
      }
      else
      {
        i = -1;
      }
      do
      {
        do
        {
          return i;
          i = j;
        } while (this.mCallback.areItemsTheSame(localObject, paramT));
        j -= 1;
        break;
        i = paramInt1;
      } while (this.mCallback.areItemsTheSame(localObject, paramT));
      paramInt1 += 1;
    }
  }
  
  private void merge(T[] paramArrayOfT, int paramInt)
  {
    int j;
    int i;
    if (!(this.mCallback instanceof SortedList.BatchedCallback))
    {
      j = 1;
      if (j != 0) {
        beginBatchedUpdates();
      }
      this.mOldData = this.mData;
      this.mOldDataStart = 0;
      this.mOldDataSize = this.mSize;
      i = this.mSize;
      this.mData = ((Object[])Array.newInstance(this.mTClass, i + paramInt + 10));
      this.mNewDataStart = 0;
      i = 0;
    }
    for (;;)
    {
      if ((this.mOldDataStart < this.mOldDataSize) || (i < paramInt))
      {
        if (this.mOldDataStart != this.mOldDataSize) {
          break label178;
        }
        paramInt -= i;
        System.arraycopy(paramArrayOfT, i, this.mData, this.mNewDataStart, paramInt);
        this.mNewDataStart += paramInt;
        this.mSize += paramInt;
        this.mCallback.onInserted(this.mNewDataStart - paramInt, paramInt);
      }
      for (;;)
      {
        this.mOldData = null;
        if (j != 0) {
          endBatchedUpdates();
        }
        return;
        j = 0;
        break;
        label178:
        if (i != paramInt) {
          break label226;
        }
        paramInt = this.mOldDataSize - this.mOldDataStart;
        System.arraycopy(this.mOldData, this.mOldDataStart, this.mData, this.mNewDataStart, paramInt);
        this.mNewDataStart = (paramInt + this.mNewDataStart);
      }
      label226:
      Object localObject1 = this.mOldData[this.mOldDataStart];
      Object localObject2 = paramArrayOfT[i];
      int k = this.mCallback.compare(localObject1, localObject2);
      if (k > 0)
      {
        localObject1 = this.mData;
        k = this.mNewDataStart;
        this.mNewDataStart = (k + 1);
        localObject1[k] = localObject2;
        this.mSize += 1;
        i += 1;
        this.mCallback.onInserted(this.mNewDataStart - 1, 1);
      }
      else if ((k == 0) && (this.mCallback.areItemsTheSame(localObject1, localObject2)))
      {
        Object[] arrayOfObject = this.mData;
        k = this.mNewDataStart;
        this.mNewDataStart = (k + 1);
        arrayOfObject[k] = localObject2;
        k = i + 1;
        this.mOldDataStart += 1;
        i = k;
        if (!this.mCallback.areContentsTheSame(localObject1, localObject2))
        {
          this.mCallback.onChanged(this.mNewDataStart - 1, 1, this.mCallback.getChangePayload(localObject1, localObject2));
          i = k;
        }
      }
      else
      {
        localObject2 = this.mData;
        k = this.mNewDataStart;
        this.mNewDataStart = (k + 1);
        localObject2[k] = localObject1;
        this.mOldDataStart += 1;
      }
    }
  }
  
  private boolean remove(T paramT, boolean paramBoolean)
  {
    int i = findIndexOf(paramT, this.mData, 0, this.mSize, 2);
    if (i == -1) {
      return false;
    }
    removeItemAtIndex(i, paramBoolean);
    return true;
  }
  
  private void removeItemAtIndex(int paramInt, boolean paramBoolean)
  {
    System.arraycopy(this.mData, paramInt + 1, this.mData, paramInt, this.mSize - paramInt - 1);
    this.mSize -= 1;
    this.mData[this.mSize] = null;
    if (paramBoolean) {
      this.mCallback.onRemoved(paramInt, 1);
    }
  }
  
  private void replaceAllInsert(T paramT)
  {
    this.mData[this.mNewDataStart] = paramT;
    this.mNewDataStart += 1;
    this.mSize += 1;
    this.mCallback.onInserted(this.mNewDataStart - 1, 1);
  }
  
  private void replaceAllInternal(@NonNull T[] paramArrayOfT)
  {
    int i;
    int j;
    if (!(this.mCallback instanceof SortedList.BatchedCallback))
    {
      i = 1;
      if (i != 0) {
        beginBatchedUpdates();
      }
      this.mOldDataStart = 0;
      this.mOldDataSize = this.mSize;
      this.mOldData = this.mData;
      this.mNewDataStart = 0;
      j = sortAndDedup(paramArrayOfT);
      this.mData = ((Object[])Array.newInstance(this.mTClass, j));
    }
    for (;;)
    {
      if ((this.mNewDataStart < j) || (this.mOldDataStart < this.mOldDataSize))
      {
        if (this.mOldDataStart < this.mOldDataSize) {
          break label175;
        }
        k = this.mNewDataStart;
        j -= this.mNewDataStart;
        System.arraycopy(paramArrayOfT, k, this.mData, k, j);
        this.mNewDataStart += j;
        this.mSize += j;
        this.mCallback.onInserted(k, j);
      }
      for (;;)
      {
        this.mOldData = null;
        if (i != 0) {
          endBatchedUpdates();
        }
        return;
        i = 0;
        break;
        label175:
        if (this.mNewDataStart < j) {
          break label218;
        }
        j = this.mOldDataSize - this.mOldDataStart;
        this.mSize -= j;
        this.mCallback.onRemoved(this.mNewDataStart, j);
      }
      label218:
      Object localObject = this.mOldData[this.mOldDataStart];
      T ? = paramArrayOfT[this.mNewDataStart];
      int k = this.mCallback.compare(localObject, ?);
      if (k < 0)
      {
        replaceAllRemove();
      }
      else if (k > 0)
      {
        replaceAllInsert(?);
      }
      else if (!this.mCallback.areItemsTheSame(localObject, ?))
      {
        replaceAllRemove();
        replaceAllInsert(?);
      }
      else
      {
        this.mData[this.mNewDataStart] = ?;
        this.mOldDataStart += 1;
        this.mNewDataStart += 1;
        if (!this.mCallback.areContentsTheSame(localObject, ?)) {
          this.mCallback.onChanged(this.mNewDataStart - 1, 1, this.mCallback.getChangePayload(localObject, ?));
        }
      }
    }
  }
  
  private void replaceAllRemove()
  {
    this.mSize -= 1;
    this.mOldDataStart += 1;
    this.mCallback.onRemoved(this.mNewDataStart, 1);
  }
  
  private int sortAndDedup(@NonNull T[] paramArrayOfT)
  {
    int j = 1;
    int m = 0;
    if (paramArrayOfT.length == 0) {}
    int k;
    int i;
    do
    {
      return m;
      Arrays.sort(paramArrayOfT, this.mCallback);
      k = 0;
      i = 1;
      m = i;
    } while (j >= paramArrayOfT.length);
    T ? = paramArrayOfT[j];
    if (this.mCallback.compare(paramArrayOfT[k], ?) == 0)
    {
      m = findSameItem(?, paramArrayOfT, k, i);
      if (m != -1) {
        paramArrayOfT[m] = ?;
      }
    }
    for (;;)
    {
      j += 1;
      break;
      if (i != j) {
        paramArrayOfT[i] = ?;
      }
      i += 1;
      continue;
      if (i != j) {
        paramArrayOfT[i] = ?;
      }
      k = i;
      i += 1;
    }
  }
  
  private void throwIfInMutationOperation()
  {
    if (this.mOldData != null) {
      throw new IllegalStateException("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
    }
  }
  
  public int add(T paramT)
  {
    throwIfInMutationOperation();
    return add(paramT, true);
  }
  
  public void addAll(@NonNull Collection<T> paramCollection)
  {
    addAll(paramCollection.toArray((Object[])Array.newInstance(this.mTClass, paramCollection.size())), true);
  }
  
  public void addAll(@NonNull T... paramVarArgs)
  {
    addAll(paramVarArgs, false);
  }
  
  public void addAll(@NonNull T[] paramArrayOfT, boolean paramBoolean)
  {
    throwIfInMutationOperation();
    if (paramArrayOfT.length == 0) {
      return;
    }
    if (paramBoolean)
    {
      addAllInternal(paramArrayOfT);
      return;
    }
    addAllInternal(copyArray(paramArrayOfT));
  }
  
  public void beginBatchedUpdates()
  {
    throwIfInMutationOperation();
    if ((this.mCallback instanceof SortedList.BatchedCallback)) {
      return;
    }
    if (this.mBatchedCallback == null) {
      this.mBatchedCallback = new SortedList.BatchedCallback(this.mCallback);
    }
    this.mCallback = this.mBatchedCallback;
  }
  
  public void clear()
  {
    throwIfInMutationOperation();
    if (this.mSize == 0) {
      return;
    }
    int i = this.mSize;
    Arrays.fill(this.mData, 0, i, null);
    this.mSize = 0;
    this.mCallback.onRemoved(0, i);
  }
  
  public void endBatchedUpdates()
  {
    throwIfInMutationOperation();
    if ((this.mCallback instanceof SortedList.BatchedCallback)) {
      ((SortedList.BatchedCallback)this.mCallback).dispatchLastEvent();
    }
    if (this.mCallback == this.mBatchedCallback) {
      this.mCallback = this.mBatchedCallback.mWrappedCallback;
    }
  }
  
  public T get(int paramInt)
  {
    if ((paramInt >= this.mSize) || (paramInt < 0)) {
      throw new IndexOutOfBoundsException("Asked to get item at " + paramInt + " but size is " + this.mSize);
    }
    if ((this.mOldData != null) && (paramInt >= this.mNewDataStart)) {
      return this.mOldData[(paramInt - this.mNewDataStart + this.mOldDataStart)];
    }
    return this.mData[paramInt];
  }
  
  public int indexOf(T paramT)
  {
    if (this.mOldData != null)
    {
      int i = findIndexOf(paramT, this.mData, 0, this.mNewDataStart, 4);
      if (i != -1) {
        return i;
      }
      i = findIndexOf(paramT, this.mOldData, this.mOldDataStart, this.mOldDataSize, 4);
      if (i != -1) {
        return i - this.mOldDataStart + this.mNewDataStart;
      }
      return -1;
    }
    return findIndexOf(paramT, this.mData, 0, this.mSize, 4);
  }
  
  public void recalculatePositionOfItemAt(int paramInt)
  {
    throwIfInMutationOperation();
    Object localObject = get(paramInt);
    removeItemAtIndex(paramInt, false);
    int i = add(localObject, false);
    if (paramInt != i) {
      this.mCallback.onMoved(paramInt, i);
    }
  }
  
  public boolean remove(T paramT)
  {
    throwIfInMutationOperation();
    return remove(paramT, true);
  }
  
  public T removeItemAt(int paramInt)
  {
    throwIfInMutationOperation();
    Object localObject = get(paramInt);
    removeItemAtIndex(paramInt, true);
    return localObject;
  }
  
  public void replaceAll(@NonNull Collection<T> paramCollection)
  {
    replaceAll(paramCollection.toArray((Object[])Array.newInstance(this.mTClass, paramCollection.size())), true);
  }
  
  public void replaceAll(@NonNull T... paramVarArgs)
  {
    replaceAll(paramVarArgs, false);
  }
  
  public void replaceAll(@NonNull T[] paramArrayOfT, boolean paramBoolean)
  {
    throwIfInMutationOperation();
    if (paramBoolean)
    {
      replaceAllInternal(paramArrayOfT);
      return;
    }
    replaceAllInternal(copyArray(paramArrayOfT));
  }
  
  public int size()
  {
    return this.mSize;
  }
  
  public void updateItemAt(int paramInt, T paramT)
  {
    throwIfInMutationOperation();
    Object localObject = get(paramInt);
    int i;
    if ((localObject == paramT) || (!this.mCallback.areContentsTheSame(localObject, paramT)))
    {
      i = 1;
      if ((localObject == paramT) || (this.mCallback.compare(localObject, paramT) != 0)) {
        break label87;
      }
      this.mData[paramInt] = paramT;
      if (i != 0) {
        this.mCallback.onChanged(paramInt, 1, this.mCallback.getChangePayload(localObject, paramT));
      }
    }
    label87:
    do
    {
      return;
      i = 0;
      break;
      if (i != 0) {
        this.mCallback.onChanged(paramInt, 1, this.mCallback.getChangePayload(localObject, paramT));
      }
      removeItemAtIndex(paramInt, false);
      i = add(paramT, false);
    } while (paramInt == i);
    this.mCallback.onMoved(paramInt, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.SortedList
 * JD-Core Version:    0.7.0.1
 */