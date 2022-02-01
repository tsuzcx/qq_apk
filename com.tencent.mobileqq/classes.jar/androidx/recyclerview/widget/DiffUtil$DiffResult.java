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
    if (this.mSnakes.isEmpty()) {}
    for (DiffUtil.Snake localSnake = null;; localSnake = (DiffUtil.Snake)this.mSnakes.get(0))
    {
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
      return;
    }
  }
  
  private void dispatchAdditions(List<DiffUtil.PostponedUpdate> paramList, ListUpdateCallback paramListUpdateCallback, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.mDetectMoves) {
      paramListUpdateCallback.onInserted(paramInt1, paramInt2);
    }
    do
    {
      return;
      paramInt2 -= 1;
    } while (paramInt2 < 0);
    int i = this.mNewItemStatuses[(paramInt3 + paramInt2)] & 0x1F;
    Iterator localIterator;
    switch (i)
    {
    default: 
      throw new IllegalStateException("unknown flag for pos " + (paramInt2 + paramInt3) + " " + Long.toBinaryString(i));
    case 0: 
      paramListUpdateCallback.onInserted(paramInt1, 1);
      localIterator = paramList.iterator();
    case 4: 
    case 8: 
      while (localIterator.hasNext())
      {
        DiffUtil.PostponedUpdate localPostponedUpdate = (DiffUtil.PostponedUpdate)localIterator.next();
        localPostponedUpdate.currentPos += 1;
        continue;
        int j = this.mNewItemStatuses[(paramInt3 + paramInt2)] >> 5;
        paramListUpdateCallback.onMoved(removePostponedUpdate(paramList, j, true).currentPos, paramInt1);
        if (i == 4) {
          paramListUpdateCallback.onChanged(paramInt1, 1, this.mCallback.getChangePayload(j, paramInt3 + paramInt2));
        }
      }
    }
    for (;;)
    {
      paramInt2 -= 1;
      break;
      paramList.add(new DiffUtil.PostponedUpdate(paramInt3 + paramInt2, paramInt1, false));
    }
  }
  
  private void dispatchRemovals(List<DiffUtil.PostponedUpdate> paramList, ListUpdateCallback paramListUpdateCallback, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.mDetectMoves) {
      paramListUpdateCallback.onRemoved(paramInt1, paramInt2);
    }
    do
    {
      return;
      paramInt2 -= 1;
    } while (paramInt2 < 0);
    int i = this.mOldItemStatuses[(paramInt3 + paramInt2)] & 0x1F;
    Object localObject;
    switch (i)
    {
    default: 
      throw new IllegalStateException("unknown flag for pos " + (paramInt2 + paramInt3) + " " + Long.toBinaryString(i));
    case 0: 
      paramListUpdateCallback.onRemoved(paramInt1 + paramInt2, 1);
      localObject = paramList.iterator();
    case 4: 
    case 8: 
      while (((Iterator)localObject).hasNext())
      {
        DiffUtil.PostponedUpdate localPostponedUpdate = (DiffUtil.PostponedUpdate)((Iterator)localObject).next();
        localPostponedUpdate.currentPos -= 1;
        continue;
        int j = this.mOldItemStatuses[(paramInt3 + paramInt2)] >> 5;
        localObject = removePostponedUpdate(paramList, j, false);
        paramListUpdateCallback.onMoved(paramInt1 + paramInt2, ((DiffUtil.PostponedUpdate)localObject).currentPos - 1);
        if (i == 4) {
          paramListUpdateCallback.onChanged(((DiffUtil.PostponedUpdate)localObject).currentPos - 1, 1, this.mCallback.getChangePayload(paramInt3 + paramInt2, j));
        }
      }
    }
    for (;;)
    {
      paramInt2 -= 1;
      break;
      paramList.add(new DiffUtil.PostponedUpdate(paramInt3 + paramInt2, paramInt1 + paramInt2, true));
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
    int m = 8;
    int j;
    int k;
    int i;
    if (paramBoolean)
    {
      j = paramInt2 - 1;
      k = paramInt2 - 1;
      i = paramInt1;
      paramInt2 = j;
      j = k;
      k = i;
      i = paramInt2;
      paramInt2 = k;
    }
    for (;;)
    {
      if (paramInt3 < 0) {
        break label289;
      }
      DiffUtil.Snake localSnake = (DiffUtil.Snake)this.mSnakes.get(paramInt3);
      k = localSnake.x;
      int n = localSnake.size;
      int i1 = localSnake.y;
      int i2 = localSnake.size;
      if (paramBoolean)
      {
        paramInt2 -= 1;
        for (;;)
        {
          if (paramInt2 < k + n) {
            break label269;
          }
          if (this.mCallback.areItemsTheSame(paramInt2, j))
          {
            if (this.mCallback.areContentsTheSame(paramInt2, j)) {}
            for (paramInt1 = 8;; paramInt1 = 4)
            {
              this.mNewItemStatuses[j] = (paramInt2 << 5 | 0x10);
              this.mOldItemStatuses[paramInt2] = (paramInt1 | j << 5);
              return true;
              j = paramInt1 - 1;
              i = paramInt1 - 1;
              break;
            }
          }
          paramInt2 -= 1;
        }
      }
      paramInt2 = i - 1;
      while (paramInt2 >= i1 + i2)
      {
        if (this.mCallback.areItemsTheSame(j, paramInt2))
        {
          if (this.mCallback.areContentsTheSame(j, paramInt2)) {}
          for (paramInt3 = m;; paramInt3 = 4)
          {
            this.mOldItemStatuses[(paramInt1 - 1)] = (paramInt2 << 5 | 0x10);
            this.mNewItemStatuses[paramInt2] = (paramInt1 - 1 << 5 | paramInt3);
            return true;
          }
        }
        paramInt2 -= 1;
      }
      label269:
      paramInt2 = localSnake.x;
      i = localSnake.y;
      paramInt3 -= 1;
    }
    label289:
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
      if (i < localSnake.size)
      {
        m = localSnake.x + i;
        n = localSnake.y + i;
        if (this.mCallback.areContentsTheSame(m, n)) {}
        for (j = 1;; j = 2)
        {
          this.mOldItemStatuses[m] = (n << 5 | j);
          this.mNewItemStatuses[n] = (j | m << 5);
          i += 1;
          break;
        }
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
      DiffUtil.PostponedUpdate localPostponedUpdate2 = (DiffUtil.PostponedUpdate)paramList.get(i);
      if ((localPostponedUpdate2.posInOwnerList == paramInt) && (localPostponedUpdate2.removal == paramBoolean))
      {
        paramList.remove(i);
        paramInt = i;
        localPostponedUpdate1 = localPostponedUpdate2;
        if (paramInt >= paramList.size()) {
          break label123;
        }
        localPostponedUpdate1 = (DiffUtil.PostponedUpdate)paramList.get(paramInt);
        int j = localPostponedUpdate1.currentPos;
        if (paramBoolean) {}
        for (i = 1;; i = -1)
        {
          localPostponedUpdate1.currentPos = (i + j);
          paramInt += 1;
          break;
        }
      }
      i -= 1;
    }
    DiffUtil.PostponedUpdate localPostponedUpdate1 = null;
    label123:
    return localPostponedUpdate1;
  }
  
  public int convertNewPositionToOld(@IntRange(from=0L) int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mNewListSize)) {
      throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + paramInt + ", new list size = " + this.mNewListSize);
    }
    paramInt = this.mNewItemStatuses[paramInt];
    if ((paramInt & 0x1F) == 0) {
      return -1;
    }
    return paramInt >> 5;
  }
  
  public int convertOldPositionToNew(@IntRange(from=0L) int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mOldListSize)) {
      throw new IndexOutOfBoundsException("Index out of bounds - passed position = " + paramInt + ", old list size = " + this.mOldListSize);
    }
    paramInt = this.mOldItemStatuses[paramInt];
    if ((paramInt & 0x1F) == 0) {
      return -1;
    }
    return paramInt >> 5;
  }
  
  public void dispatchUpdatesTo(@NonNull ListUpdateCallback paramListUpdateCallback)
  {
    ArrayList localArrayList;
    int j;
    int k;
    int i;
    if ((paramListUpdateCallback instanceof BatchingListUpdateCallback))
    {
      paramListUpdateCallback = (BatchingListUpdateCallback)paramListUpdateCallback;
      localArrayList = new ArrayList();
      j = this.mOldListSize;
      k = this.mNewListSize;
      i = this.mSnakes.size() - 1;
    }
    for (;;)
    {
      if (i < 0) {
        break label234;
      }
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
      for (;;)
      {
        if (j >= 0)
        {
          if ((this.mOldItemStatuses[(localSnake.x + j)] & 0x1F) == 2) {
            paramListUpdateCallback.onChanged(localSnake.x + j, 1, this.mCallback.getChangePayload(localSnake.x + j, localSnake.y + j));
          }
          j -= 1;
          continue;
          paramListUpdateCallback = new BatchingListUpdateCallback(paramListUpdateCallback);
          break;
        }
      }
      j = localSnake.x;
      k = localSnake.y;
      i -= 1;
    }
    label234:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.DiffUtil.DiffResult
 * JD-Core Version:    0.7.0.1
 */