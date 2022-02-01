package androidx.recyclerview.widget;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DiffUtil$DiffResult
{
  private static final int FLAG_CHANGED = 2;
  private static final int FLAG_IGNORE = 16;
  private static final int FLAG_MASK = 31;
  private static final int FLAG_MOVED_CHANGED = 4;
  private static final int FLAG_MOVED_NOT_CHANGED = 8;
  private static final int FLAG_NOT_CHANGED = 1;
  private static final int FLAG_OFFSET = 5;
  public static final int NO_POSITION = -1;
  private final DiffUtil.Callback mCallback;
  private final boolean mDetectMoves;
  private final int[] mNewItemStatuses;
  private final int mNewListSize;
  private final int[] mOldItemStatuses;
  private final int mOldListSize;
  private final List<DiffUtil.Snake> mSnakes;
  
  DiffUtil$DiffResult(DiffUtil.Callback paramCallback, List<DiffUtil.Snake> paramList, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean)
  {
    this.mSnakes = paramList;
    this.mOldItemStatuses = paramArrayOfInt1;
    this.mNewItemStatuses = paramArrayOfInt2;
    Arrays.fill(this.mOldItemStatuses, 0);
    Arrays.fill(this.mNewItemStatuses, 0);
    this.mCallback = paramCallback;
    this.mOldListSize = paramCallback.getOldListSize();
    this.mNewListSize = paramCallback.getNewListSize();
    this.mDetectMoves = paramBoolean;
    addRootSnake();
    findMatchingItems();
  }
  
  private void addRootSnake()
  {
    DiffUtil.Snake localSnake;
    if (this.mSnakes.isEmpty()) {
      localSnake = null;
    } else {
      localSnake = (DiffUtil.Snake)this.mSnakes.get(0);
    }
    if ((localSnake == null) || (localSnake.x != 0) || (localSnake.y != 0))
    {
      localSnake = new DiffUtil.Snake();
      localSnake.x = 0;
      localSnake.y = 0;
      localSnake.removal = false;
      localSnake.size = 0;
      localSnake.reverse = false;
      this.mSnakes.add(0, localSnake);
    }
  }
  
  private void dispatchAdditions(List<DiffUtil.PostponedUpdate> paramList, ListUpdateCallback paramListUpdateCallback, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.mDetectMoves)
    {
      paramListUpdateCallback.onInserted(paramInt1, paramInt2);
      return;
    }
    paramInt2 -= 1;
    while (paramInt2 >= 0)
    {
      Object localObject = this.mNewItemStatuses;
      int i = paramInt3 + paramInt2;
      int j = localObject[i] & 0x1F;
      if (j != 0)
      {
        if ((j != 4) && (j != 8))
        {
          if (j == 16)
          {
            paramList.add(new DiffUtil.PostponedUpdate(i, paramInt1, false));
          }
          else
          {
            paramList = new StringBuilder();
            paramList.append("unknown flag for pos ");
            paramList.append(i);
            paramList.append(" ");
            paramList.append(Long.toBinaryString(j));
            throw new IllegalStateException(paramList.toString());
          }
        }
        else
        {
          int k = this.mNewItemStatuses[i] >> 5;
          paramListUpdateCallback.onMoved(removePostponedUpdate(paramList, k, true).currentPos, paramInt1);
          if (j == 4) {
            paramListUpdateCallback.onChanged(paramInt1, 1, this.mCallback.getChangePayload(k, i));
          }
        }
      }
      else
      {
        paramListUpdateCallback.onInserted(paramInt1, 1);
        localObject = paramList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          DiffUtil.PostponedUpdate localPostponedUpdate = (DiffUtil.PostponedUpdate)((Iterator)localObject).next();
          localPostponedUpdate.currentPos += 1;
        }
      }
      paramInt2 -= 1;
    }
  }
  
  private void dispatchRemovals(List<DiffUtil.PostponedUpdate> paramList, ListUpdateCallback paramListUpdateCallback, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.mDetectMoves)
    {
      paramListUpdateCallback.onRemoved(paramInt1, paramInt2);
      return;
    }
    paramInt2 -= 1;
    while (paramInt2 >= 0)
    {
      Object localObject = this.mOldItemStatuses;
      int i = paramInt3 + paramInt2;
      int j = localObject[i] & 0x1F;
      if (j != 0)
      {
        if ((j != 4) && (j != 8))
        {
          if (j == 16)
          {
            paramList.add(new DiffUtil.PostponedUpdate(i, paramInt1 + paramInt2, true));
          }
          else
          {
            paramList = new StringBuilder();
            paramList.append("unknown flag for pos ");
            paramList.append(i);
            paramList.append(" ");
            paramList.append(Long.toBinaryString(j));
            throw new IllegalStateException(paramList.toString());
          }
        }
        else
        {
          int k = this.mOldItemStatuses[i] >> 5;
          localObject = removePostponedUpdate(paramList, k, false);
          paramListUpdateCallback.onMoved(paramInt1 + paramInt2, ((DiffUtil.PostponedUpdate)localObject).currentPos - 1);
          if (j == 4) {
            paramListUpdateCallback.onChanged(((DiffUtil.PostponedUpdate)localObject).currentPos - 1, 1, this.mCallback.getChangePayload(i, k));
          }
        }
      }
      else
      {
        paramListUpdateCallback.onRemoved(paramInt1 + paramInt2, 1);
        localObject = paramList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          DiffUtil.PostponedUpdate localPostponedUpdate = (DiffUtil.PostponedUpdate)((Iterator)localObject).next();
          localPostponedUpdate.currentPos -= 1;
        }
      }
      paramInt2 -= 1;
    }
  }
  
  private void findAddition(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mOldItemStatuses[(paramInt1 - 1)] != 0) {
      return;
    }
    findMatchingItem(paramInt1, paramInt2, paramInt3, false);
  }
  
  private boolean findMatchingItem(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i;
    int j;
    int k;
    if (paramBoolean)
    {
      i = paramInt2 - 1;
      paramInt2 = paramInt1;
      j = i;
    }
    else
    {
      k = paramInt1 - 1;
      j = k;
      i = paramInt2;
      paramInt2 = k;
    }
    while (paramInt3 >= 0)
    {
      Object localObject = (DiffUtil.Snake)this.mSnakes.get(paramInt3);
      int m = ((DiffUtil.Snake)localObject).x;
      int n = ((DiffUtil.Snake)localObject).size;
      int i1 = ((DiffUtil.Snake)localObject).y;
      int i2 = ((DiffUtil.Snake)localObject).size;
      k = 8;
      if (paramBoolean)
      {
        paramInt2 -= 1;
        while (paramInt2 >= m + n)
        {
          if (this.mCallback.areItemsTheSame(paramInt2, j))
          {
            if (!this.mCallback.areContentsTheSame(paramInt2, j)) {
              k = 4;
            }
            this.mNewItemStatuses[j] = (paramInt2 << 5 | 0x10);
            this.mOldItemStatuses[paramInt2] = (j << 5 | k);
            return true;
          }
          paramInt2 -= 1;
        }
      }
      paramInt2 = i - 1;
      while (paramInt2 >= i1 + i2)
      {
        if (this.mCallback.areItemsTheSame(j, paramInt2))
        {
          if (!this.mCallback.areContentsTheSame(j, paramInt2)) {
            k = 4;
          }
          localObject = this.mOldItemStatuses;
          paramInt1 -= 1;
          localObject[paramInt1] = (paramInt2 << 5 | 0x10);
          this.mNewItemStatuses[paramInt2] = (paramInt1 << 5 | k);
          return true;
        }
        paramInt2 -= 1;
      }
      paramInt2 = ((DiffUtil.Snake)localObject).x;
      i = ((DiffUtil.Snake)localObject).y;
      paramInt3 -= 1;
    }
    return false;
  }
  
  private void findMatchingItems()
  {
    int j = this.mOldListSize;
    int i = this.mNewListSize;
    int k = this.mSnakes.size() - 1;
    while (k >= 0)
    {
      DiffUtil.Snake localSnake = (DiffUtil.Snake)this.mSnakes.get(k);
      int i2 = localSnake.x;
      int i3 = localSnake.size;
      int n = localSnake.y;
      int i1 = localSnake.size;
      int m;
      if (this.mDetectMoves)
      {
        for (;;)
        {
          m = i;
          if (j <= i2 + i3) {
            break;
          }
          findAddition(j, i, k);
          j -= 1;
        }
        while (m > n + i1)
        {
          findRemoval(j, m, k);
          m -= 1;
        }
      }
      i = 0;
      while (i < localSnake.size)
      {
        m = localSnake.x + i;
        n = localSnake.y + i;
        if (this.mCallback.areContentsTheSame(m, n)) {
          j = 1;
        } else {
          j = 2;
        }
        this.mOldItemStatuses[m] = (n << 5 | j);
        this.mNewItemStatuses[n] = (m << 5 | j);
        i += 1;
      }
      j = localSnake.x;
      i = localSnake.y;
      k -= 1;
    }
  }
  
  private void findRemoval(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mNewItemStatuses[(paramInt2 - 1)] != 0) {
      return;
    }
    findMatchingItem(paramInt1, paramInt2, paramInt3, true);
  }
  
  private static DiffUtil.PostponedUpdate removePostponedUpdate(List<DiffUtil.PostponedUpdate> paramList, int paramInt, boolean paramBoolean)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      DiffUtil.PostponedUpdate localPostponedUpdate1 = (DiffUtil.PostponedUpdate)paramList.get(i);
      if ((localPostponedUpdate1.posInOwnerList == paramInt) && (localPostponedUpdate1.removal == paramBoolean))
      {
        paramList.remove(i);
        while (i < paramList.size())
        {
          DiffUtil.PostponedUpdate localPostponedUpdate2 = (DiffUtil.PostponedUpdate)paramList.get(i);
          int j = localPostponedUpdate2.currentPos;
          if (paramBoolean) {
            paramInt = 1;
          } else {
            paramInt = -1;
          }
          localPostponedUpdate2.currentPos = (j + paramInt);
          i += 1;
        }
        return localPostponedUpdate1;
      }
      i -= 1;
    }
    return null;
  }
  
  public int convertNewPositionToOld(@IntRange(from=0L) int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.mNewListSize))
    {
      paramInt = this.mNewItemStatuses[paramInt];
      if ((paramInt & 0x1F) == 0) {
        return -1;
      }
      return paramInt >> 5;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Index out of bounds - passed position = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", new list size = ");
    localStringBuilder.append(this.mNewListSize);
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public int convertOldPositionToNew(@IntRange(from=0L) int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.mOldListSize))
    {
      paramInt = this.mOldItemStatuses[paramInt];
      if ((paramInt & 0x1F) == 0) {
        return -1;
      }
      return paramInt >> 5;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Index out of bounds - passed position = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", old list size = ");
    localStringBuilder.append(this.mOldListSize);
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public void dispatchUpdatesTo(@NonNull ListUpdateCallback paramListUpdateCallback)
  {
    if ((paramListUpdateCallback instanceof BatchingListUpdateCallback)) {
      paramListUpdateCallback = (BatchingListUpdateCallback)paramListUpdateCallback;
    } else {
      paramListUpdateCallback = new BatchingListUpdateCallback(paramListUpdateCallback);
    }
    ArrayList localArrayList = new ArrayList();
    int j = this.mOldListSize;
    int k = this.mNewListSize;
    int i = this.mSnakes.size();
    i -= 1;
    while (i >= 0)
    {
      DiffUtil.Snake localSnake = (DiffUtil.Snake)this.mSnakes.get(i);
      int m = localSnake.size;
      int n = localSnake.x + m;
      int i1 = localSnake.y + m;
      if (n < j) {
        dispatchRemovals(localArrayList, paramListUpdateCallback, n, j - n, n);
      }
      if (i1 < k) {
        dispatchAdditions(localArrayList, paramListUpdateCallback, n, k - i1, i1);
      }
      j = m - 1;
      while (j >= 0)
      {
        if ((this.mOldItemStatuses[(localSnake.x + j)] & 0x1F) == 2) {
          paramListUpdateCallback.onChanged(localSnake.x + j, 1, this.mCallback.getChangePayload(localSnake.x + j, localSnake.y + j));
        }
        j -= 1;
      }
      j = localSnake.x;
      k = localSnake.y;
      i -= 1;
    }
    paramListUpdateCallback.dispatchLastEvent();
  }
  
  public void dispatchUpdatesTo(@NonNull RecyclerView.Adapter paramAdapter)
  {
    dispatchUpdatesTo(new AdapterListUpdateCallback(paramAdapter));
  }
  
  @VisibleForTesting
  List<DiffUtil.Snake> getSnakes()
  {
    return this.mSnakes;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.DiffUtil.DiffResult
 * JD-Core Version:    0.7.0.1
 */