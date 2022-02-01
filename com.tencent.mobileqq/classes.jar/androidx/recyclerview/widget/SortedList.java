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
    int j = findIndexOf(paramT, this.mData, 0, this.mSize, 1);
    int i;
    if (j == -1)
    {
      i = 0;
    }
    else
    {
      i = j;
      if (j < this.mSize)
      {
        Object localObject = this.mData[j];
        i = j;
        if (this.mCallback.areItemsTheSame(localObject, paramT))
        {
          if (this.mCallback.areContentsTheSame(localObject, paramT))
          {
            this.mData[j] = paramT;
            return j;
          }
          this.mData[j] = paramT;
          SortedList.Callback localCallback = this.mCallback;
          localCallback.onChanged(j, 1, localCallback.getChangePayload(localObject, paramT));
          return j;
        }
      }
    }
    addToData(i, paramT);
    if (paramBoolean) {
      this.mCallback.onInserted(i, 1);
    }
    return i;
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
    int i = this.mSize;
    if (paramInt <= i)
    {
      Object[] arrayOfObject = this.mData;
      if (i == arrayOfObject.length)
      {
        arrayOfObject = (Object[])Array.newInstance(this.mTClass, arrayOfObject.length + 10);
        System.arraycopy(this.mData, 0, arrayOfObject, 0, paramInt);
        arrayOfObject[paramInt] = paramT;
        System.arraycopy(this.mData, paramInt, arrayOfObject, paramInt + 1, this.mSize - paramInt);
        this.mData = arrayOfObject;
      }
      else
      {
        System.arraycopy(arrayOfObject, paramInt, arrayOfObject, paramInt + 1, i - paramInt);
        this.mData[paramInt] = paramT;
      }
      this.mSize += 1;
      return;
    }
    paramT = new StringBuilder();
    paramT.append("cannot add item to ");
    paramT.append(paramInt);
    paramT.append(" because size is ");
    paramT.append(this.mSize);
    throw new IndexOutOfBoundsException(paramT.toString());
  }
  
  private T[] copyArray(T[] paramArrayOfT)
  {
    Object[] arrayOfObject = (Object[])Array.newInstance(this.mTClass, paramArrayOfT.length);
    System.arraycopy(paramArrayOfT, 0, arrayOfObject, 0, paramArrayOfT.length);
    return arrayOfObject;
  }
  
  private int findIndexOf(T paramT, T[] paramArrayOfT, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    while (i < paramInt2)
    {
      paramInt1 = (i + paramInt2) / 2;
      T ? = paramArrayOfT[paramInt1];
      int j = this.mCallback.compare(?, paramT);
      if (j < 0)
      {
        i = paramInt1 + 1;
      }
      else
      {
        if (j == 0)
        {
          if (this.mCallback.areItemsTheSame(?, paramT)) {
            return paramInt1;
          }
          i = linearEqualitySearch(paramT, paramInt1, i, paramInt2);
          paramInt2 = i;
          if (paramInt3 == 1)
          {
            paramInt2 = i;
            if (i == -1) {
              paramInt2 = paramInt1;
            }
          }
          return paramInt2;
        }
        paramInt2 = paramInt1;
      }
    }
    if (paramInt3 == 1) {
      return i;
    }
    return -1;
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
    int i;
    Object localObject;
    for (;;)
    {
      i = paramInt1;
      if (j < paramInt2) {
        break;
      }
      localObject = this.mData[j];
      if (this.mCallback.compare(localObject, paramT) != 0)
      {
        i = paramInt1;
        break;
      }
      if (this.mCallback.areItemsTheSame(localObject, paramT)) {
        return j;
      }
      j -= 1;
    }
    do
    {
      paramInt1 = i + 1;
      if (paramInt1 >= paramInt3) {
        break;
      }
      localObject = this.mData[paramInt1];
      if (this.mCallback.compare(localObject, paramT) != 0) {
        break;
      }
      i = paramInt1;
    } while (!this.mCallback.areItemsTheSame(localObject, paramT));
    return paramInt1;
    return -1;
  }
  
  private void merge(T[] paramArrayOfT, int paramInt)
  {
    boolean bool = this.mCallback instanceof SortedList.BatchedCallback;
    int i = 0;
    int j;
    if (!bool) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0) {
      beginBatchedUpdates();
    }
    this.mOldData = this.mData;
    this.mOldDataStart = 0;
    int k = this.mSize;
    this.mOldDataSize = k;
    this.mData = ((Object[])Array.newInstance(this.mTClass, k + paramInt + 10));
    this.mNewDataStart = 0;
    for (;;)
    {
      if ((this.mOldDataStart < this.mOldDataSize) || (i < paramInt))
      {
        k = this.mOldDataStart;
        int m = this.mOldDataSize;
        if (k == m)
        {
          paramInt -= i;
          System.arraycopy(paramArrayOfT, i, this.mData, this.mNewDataStart, paramInt);
          this.mNewDataStart += paramInt;
          this.mSize += paramInt;
          this.mCallback.onInserted(this.mNewDataStart - paramInt, paramInt);
        }
        else
        {
          if (i != paramInt) {
            break label232;
          }
          paramInt = m - k;
          System.arraycopy(this.mOldData, k, this.mData, this.mNewDataStart, paramInt);
          this.mNewDataStart += paramInt;
        }
      }
      this.mOldData = null;
      if (j != 0) {
        endBatchedUpdates();
      }
      return;
      label232:
      Object localObject1 = this.mOldData[k];
      Object localObject2 = paramArrayOfT[i];
      k = this.mCallback.compare(localObject1, localObject2);
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
        Object localObject3 = this.mData;
        k = this.mNewDataStart;
        this.mNewDataStart = (k + 1);
        localObject3[k] = localObject2;
        k = i + 1;
        this.mOldDataStart += 1;
        i = k;
        if (!this.mCallback.areContentsTheSame(localObject1, localObject2))
        {
          localObject3 = this.mCallback;
          ((SortedList.Callback)localObject3).onChanged(this.mNewDataStart - 1, 1, ((SortedList.Callback)localObject3).getChangePayload(localObject1, localObject2));
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
    Object[] arrayOfObject = this.mData;
    System.arraycopy(arrayOfObject, paramInt + 1, arrayOfObject, paramInt, this.mSize - paramInt - 1);
    this.mSize -= 1;
    this.mData[this.mSize] = null;
    if (paramBoolean) {
      this.mCallback.onRemoved(paramInt, 1);
    }
  }
  
  private void replaceAllInsert(T paramT)
  {
    Object[] arrayOfObject = this.mData;
    int i = this.mNewDataStart;
    arrayOfObject[i] = paramT;
    this.mNewDataStart = (i + 1);
    this.mSize += 1;
    this.mCallback.onInserted(this.mNewDataStart - 1, 1);
  }
  
  private void replaceAllInternal(@NonNull T[] paramArrayOfT)
  {
    int i;
    if (!(this.mCallback instanceof SortedList.BatchedCallback)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      beginBatchedUpdates();
    }
    this.mOldDataStart = 0;
    this.mOldDataSize = this.mSize;
    this.mOldData = this.mData;
    this.mNewDataStart = 0;
    int j = sortAndDedup(paramArrayOfT);
    this.mData = ((Object[])Array.newInstance(this.mTClass, j));
    for (;;)
    {
      int m;
      if ((this.mNewDataStart < j) || (this.mOldDataStart < this.mOldDataSize))
      {
        m = this.mOldDataStart;
        int n = this.mOldDataSize;
        if (m >= n)
        {
          k = this.mNewDataStart;
          j -= k;
          System.arraycopy(paramArrayOfT, k, this.mData, k, j);
          this.mNewDataStart += j;
          this.mSize += j;
          this.mCallback.onInserted(k, j);
        }
        else
        {
          k = this.mNewDataStart;
          if (k < j) {
            break label222;
          }
          j = n - m;
          this.mSize -= j;
          this.mCallback.onRemoved(k, j);
        }
      }
      this.mOldData = null;
      if (i != 0) {
        endBatchedUpdates();
      }
      return;
      label222:
      Object localObject1 = this.mOldData[m];
      T ? = paramArrayOfT[k];
      int k = this.mCallback.compare(localObject1, ?);
      if (k < 0)
      {
        replaceAllRemove();
      }
      else if (k > 0)
      {
        replaceAllInsert(?);
      }
      else if (!this.mCallback.areItemsTheSame(localObject1, ?))
      {
        replaceAllRemove();
        replaceAllInsert(?);
      }
      else
      {
        Object localObject2 = this.mData;
        k = this.mNewDataStart;
        localObject2[k] = ?;
        this.mOldDataStart += 1;
        this.mNewDataStart = (k + 1);
        if (!this.mCallback.areContentsTheSame(localObject1, ?))
        {
          localObject2 = this.mCallback;
          ((SortedList.Callback)localObject2).onChanged(this.mNewDataStart - 1, 1, ((SortedList.Callback)localObject2).getChangePayload(localObject1, ?));
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
    if (paramArrayOfT.length == 0) {
      return 0;
    }
    Arrays.sort(paramArrayOfT, this.mCallback);
    int j = 1;
    int i = 1;
    int k = 0;
    while (j < paramArrayOfT.length)
    {
      T ? = paramArrayOfT[j];
      if (this.mCallback.compare(paramArrayOfT[k], ?) == 0)
      {
        int m = findSameItem(?, paramArrayOfT, k, i);
        if (m != -1)
        {
          paramArrayOfT[m] = ?;
        }
        else
        {
          if (i != j) {
            paramArrayOfT[i] = ?;
          }
          i += 1;
        }
      }
      else
      {
        if (i != j) {
          paramArrayOfT[i] = ?;
        }
        k = i;
        i += 1;
      }
      j += 1;
    }
    return i;
  }
  
  private void throwIfInMutationOperation()
  {
    if (this.mOldData == null) {
      return;
    }
    throw new IllegalStateException("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
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
    SortedList.Callback localCallback = this.mCallback;
    if ((localCallback instanceof SortedList.BatchedCallback)) {
      return;
    }
    if (this.mBatchedCallback == null) {
      this.mBatchedCallback = new SortedList.BatchedCallback(localCallback);
    }
    this.mCallback = this.mBatchedCallback;
  }
  
  public void clear()
  {
    throwIfInMutationOperation();
    int i = this.mSize;
    if (i == 0) {
      return;
    }
    Arrays.fill(this.mData, 0, i, null);
    this.mSize = 0;
    this.mCallback.onRemoved(0, i);
  }
  
  public void endBatchedUpdates()
  {
    throwIfInMutationOperation();
    SortedList.Callback localCallback = this.mCallback;
    if ((localCallback instanceof SortedList.BatchedCallback)) {
      ((SortedList.BatchedCallback)localCallback).dispatchLastEvent();
    }
    localCallback = this.mCallback;
    SortedList.BatchedCallback localBatchedCallback = this.mBatchedCallback;
    if (localCallback == localBatchedCallback) {
      this.mCallback = localBatchedCallback.mWrappedCallback;
    }
  }
  
  public T get(int paramInt)
  {
    if ((paramInt < this.mSize) && (paramInt >= 0))
    {
      localObject = this.mOldData;
      if (localObject != null)
      {
        int i = this.mNewDataStart;
        if (paramInt >= i) {
          return localObject[(paramInt - i + this.mOldDataStart)];
        }
      }
      return this.mData[paramInt];
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Asked to get item at ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" but size is ");
    ((StringBuilder)localObject).append(this.mSize);
    throw new IndexOutOfBoundsException(((StringBuilder)localObject).toString());
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
    if ((localObject != paramT) && (this.mCallback.areContentsTheSame(localObject, paramT))) {
      i = 0;
    } else {
      i = 1;
    }
    SortedList.Callback localCallback;
    if ((localObject != paramT) && (this.mCallback.compare(localObject, paramT) == 0))
    {
      this.mData[paramInt] = paramT;
      if (i != 0)
      {
        localCallback = this.mCallback;
        localCallback.onChanged(paramInt, 1, localCallback.getChangePayload(localObject, paramT));
      }
      return;
    }
    if (i != 0)
    {
      localCallback = this.mCallback;
      localCallback.onChanged(paramInt, 1, localCallback.getChangePayload(localObject, paramT));
    }
    removeItemAtIndex(paramInt, false);
    int i = add(paramT, false);
    if (paramInt != i) {
      this.mCallback.onMoved(paramInt, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.SortedList
 * JD-Core Version:    0.7.0.1
 */