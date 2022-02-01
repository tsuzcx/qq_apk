package androidx.recyclerview.widget;

import androidx.core.util.Pools.Pool;
import androidx.core.util.Pools.SimplePool;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class AdapterHelper
  implements OpReorderer.Callback
{
  private static final boolean DEBUG = false;
  static final int POSITION_TYPE_INVISIBLE = 0;
  static final int POSITION_TYPE_NEW_OR_LAID_OUT = 1;
  private static final String TAG = "AHT";
  final AdapterHelper.Callback mCallback;
  final boolean mDisableRecycler;
  private int mExistingUpdateTypes = 0;
  Runnable mOnItemProcessedCallback;
  final OpReorderer mOpReorderer;
  final ArrayList<AdapterHelper.UpdateOp> mPendingUpdates = new ArrayList();
  final ArrayList<AdapterHelper.UpdateOp> mPostponedList = new ArrayList();
  private Pools.Pool<AdapterHelper.UpdateOp> mUpdateOpPool = new Pools.SimplePool(30);
  
  AdapterHelper(AdapterHelper.Callback paramCallback)
  {
    this(paramCallback, false);
  }
  
  AdapterHelper(AdapterHelper.Callback paramCallback, boolean paramBoolean)
  {
    this.mCallback = paramCallback;
    this.mDisableRecycler = paramBoolean;
    this.mOpReorderer = new OpReorderer(this);
  }
  
  private void applyAdd(AdapterHelper.UpdateOp paramUpdateOp)
  {
    postponeAndUpdateViewHolders(paramUpdateOp);
  }
  
  private void applyMove(AdapterHelper.UpdateOp paramUpdateOp)
  {
    postponeAndUpdateViewHolders(paramUpdateOp);
  }
  
  private void applyRemove(AdapterHelper.UpdateOp paramUpdateOp)
  {
    int i2 = paramUpdateOp.positionStart;
    int m = paramUpdateOp.positionStart + paramUpdateOp.itemCount;
    int i = paramUpdateOp.positionStart;
    int n = 0;
    int j = -1;
    while (i < m)
    {
      int k;
      if ((this.mCallback.findViewHolder(i) == null) && (!canFindInPreLayout(i)))
      {
        if (j == 1)
        {
          postponeAndUpdateViewHolders(obtainUpdateOp(2, i2, n, null));
          j = 1;
        }
        else
        {
          j = 0;
        }
        int i1 = 0;
        k = j;
        j = i1;
      }
      else
      {
        if (j == 0)
        {
          dispatchAndUpdateViewHolders(obtainUpdateOp(2, i2, n, null));
          k = 1;
        }
        else
        {
          k = 0;
        }
        j = 1;
      }
      if (k != 0)
      {
        i -= n;
        m -= n;
        k = 1;
      }
      else
      {
        k = n + 1;
      }
      i += 1;
      n = k;
    }
    AdapterHelper.UpdateOp localUpdateOp = paramUpdateOp;
    if (n != paramUpdateOp.itemCount)
    {
      recycleUpdateOp(paramUpdateOp);
      localUpdateOp = obtainUpdateOp(2, i2, n, null);
    }
    if (j == 0)
    {
      dispatchAndUpdateViewHolders(localUpdateOp);
      return;
    }
    postponeAndUpdateViewHolders(localUpdateOp);
  }
  
  private void applyUpdate(AdapterHelper.UpdateOp paramUpdateOp)
  {
    int k = paramUpdateOp.positionStart;
    int i3 = paramUpdateOp.positionStart;
    int i4 = paramUpdateOp.itemCount;
    int i = paramUpdateOp.positionStart;
    int j = 0;
    int m;
    for (int i2 = -1; i < i3 + i4; i2 = m)
    {
      int n;
      if ((this.mCallback.findViewHolder(i) == null) && (!canFindInPreLayout(i)))
      {
        n = j;
        m = k;
        if (i2 == 1)
        {
          postponeAndUpdateViewHolders(obtainUpdateOp(4, k, j, paramUpdateOp.payload));
          m = i;
          n = 0;
        }
        j = 0;
        k = m;
        m = j;
      }
      else
      {
        n = j;
        int i1 = k;
        if (i2 == 0)
        {
          dispatchAndUpdateViewHolders(obtainUpdateOp(4, k, j, paramUpdateOp.payload));
          i1 = i;
          n = 0;
        }
        m = 1;
        k = i1;
      }
      j = n + 1;
      i += 1;
    }
    Object localObject = paramUpdateOp;
    if (j != paramUpdateOp.itemCount)
    {
      localObject = paramUpdateOp.payload;
      recycleUpdateOp(paramUpdateOp);
      localObject = obtainUpdateOp(4, k, j, localObject);
    }
    if (i2 == 0)
    {
      dispatchAndUpdateViewHolders((AdapterHelper.UpdateOp)localObject);
      return;
    }
    postponeAndUpdateViewHolders((AdapterHelper.UpdateOp)localObject);
  }
  
  private boolean canFindInPreLayout(int paramInt)
  {
    int k = this.mPostponedList.size();
    int i = 0;
    while (i < k)
    {
      AdapterHelper.UpdateOp localUpdateOp = (AdapterHelper.UpdateOp)this.mPostponedList.get(i);
      if (localUpdateOp.cmd == 8)
      {
        if (findPositionOffset(localUpdateOp.itemCount, i + 1) == paramInt) {
          return true;
        }
      }
      else if (localUpdateOp.cmd == 1)
      {
        int m = localUpdateOp.positionStart;
        int n = localUpdateOp.itemCount;
        int j = localUpdateOp.positionStart;
        while (j < m + n)
        {
          if (findPositionOffset(j, i + 1) == paramInt) {
            return true;
          }
          j += 1;
        }
      }
      i += 1;
    }
    return false;
  }
  
  private void dispatchAndUpdateViewHolders(AdapterHelper.UpdateOp paramUpdateOp)
  {
    if ((paramUpdateOp.cmd != 1) && (paramUpdateOp.cmd != 8))
    {
      int n = updatePositionWithPostponed(paramUpdateOp.positionStart, paramUpdateOp.cmd);
      int i = paramUpdateOp.positionStart;
      int j = paramUpdateOp.cmd;
      int k;
      if (j != 2)
      {
        if (j == 4)
        {
          k = 1;
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("op should be remove or update.");
          ((StringBuilder)localObject).append(paramUpdateOp);
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      else {
        k = 0;
      }
      int m = 1;
      for (int i1 = 1; m < paramUpdateOp.itemCount; i1 = j)
      {
        int i2 = updatePositionWithPostponed(paramUpdateOp.positionStart + k * m, paramUpdateOp.cmd);
        j = paramUpdateOp.cmd;
        if (j != 2)
        {
          if (j != 4) {}
          while (i2 != n + 1)
          {
            j = 0;
            break;
          }
        }
        for (;;)
        {
          j = 1;
          break label176;
          if (i2 != n) {
            break;
          }
        }
        label176:
        if (j != 0)
        {
          j = i1 + 1;
        }
        else
        {
          localObject = obtainUpdateOp(paramUpdateOp.cmd, n, i1, paramUpdateOp.payload);
          dispatchFirstPassAndUpdateViewHolders((AdapterHelper.UpdateOp)localObject, i);
          recycleUpdateOp((AdapterHelper.UpdateOp)localObject);
          j = i;
          if (paramUpdateOp.cmd == 4) {
            j = i + i1;
          }
          n = i2;
          i1 = 1;
          i = j;
          j = i1;
        }
        m += 1;
      }
      Object localObject = paramUpdateOp.payload;
      recycleUpdateOp(paramUpdateOp);
      if (i1 > 0)
      {
        paramUpdateOp = obtainUpdateOp(paramUpdateOp.cmd, n, i1, localObject);
        dispatchFirstPassAndUpdateViewHolders(paramUpdateOp, i);
        recycleUpdateOp(paramUpdateOp);
      }
      return;
    }
    paramUpdateOp = new IllegalArgumentException("should not dispatch add or move for pre layout");
    for (;;)
    {
      throw paramUpdateOp;
    }
  }
  
  private void postponeAndUpdateViewHolders(AdapterHelper.UpdateOp paramUpdateOp)
  {
    this.mPostponedList.add(paramUpdateOp);
    int i = paramUpdateOp.cmd;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 4)
        {
          if (i == 8)
          {
            this.mCallback.offsetPositionsForMove(paramUpdateOp.positionStart, paramUpdateOp.itemCount);
            return;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Unknown update op type for ");
          localStringBuilder.append(paramUpdateOp);
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
        this.mCallback.markViewHoldersUpdated(paramUpdateOp.positionStart, paramUpdateOp.itemCount, paramUpdateOp.payload);
        return;
      }
      this.mCallback.offsetPositionsForRemovingLaidOutOrNewView(paramUpdateOp.positionStart, paramUpdateOp.itemCount);
      return;
    }
    this.mCallback.offsetPositionsForAdd(paramUpdateOp.positionStart, paramUpdateOp.itemCount);
  }
  
  private int updatePositionWithPostponed(int paramInt1, int paramInt2)
  {
    int i = this.mPostponedList.size() - 1;
    AdapterHelper.UpdateOp localUpdateOp;
    for (int j = paramInt1; i >= 0; j = paramInt1)
    {
      localUpdateOp = (AdapterHelper.UpdateOp)this.mPostponedList.get(i);
      if (localUpdateOp.cmd == 8)
      {
        int k;
        if (localUpdateOp.positionStart < localUpdateOp.itemCount)
        {
          paramInt1 = localUpdateOp.positionStart;
          k = localUpdateOp.itemCount;
        }
        else
        {
          paramInt1 = localUpdateOp.itemCount;
          k = localUpdateOp.positionStart;
        }
        if ((j >= paramInt1) && (j <= k))
        {
          if (paramInt1 == localUpdateOp.positionStart)
          {
            if (paramInt2 == 1) {
              localUpdateOp.itemCount += 1;
            } else if (paramInt2 == 2) {
              localUpdateOp.itemCount -= 1;
            }
            paramInt1 = j + 1;
          }
          else
          {
            if (paramInt2 == 1) {
              localUpdateOp.positionStart += 1;
            } else if (paramInt2 == 2) {
              localUpdateOp.positionStart -= 1;
            }
            paramInt1 = j - 1;
          }
        }
        else
        {
          paramInt1 = j;
          if (j < localUpdateOp.positionStart) {
            if (paramInt2 == 1)
            {
              localUpdateOp.positionStart += 1;
              localUpdateOp.itemCount += 1;
              paramInt1 = j;
            }
            else
            {
              paramInt1 = j;
              if (paramInt2 == 2)
              {
                localUpdateOp.positionStart -= 1;
                localUpdateOp.itemCount -= 1;
                paramInt1 = j;
              }
            }
          }
        }
      }
      else if (localUpdateOp.positionStart <= j)
      {
        if (localUpdateOp.cmd == 1)
        {
          paramInt1 = j - localUpdateOp.itemCount;
        }
        else
        {
          paramInt1 = j;
          if (localUpdateOp.cmd == 2) {
            paramInt1 = j + localUpdateOp.itemCount;
          }
        }
      }
      else if (paramInt2 == 1)
      {
        localUpdateOp.positionStart += 1;
        paramInt1 = j;
      }
      else
      {
        paramInt1 = j;
        if (paramInt2 == 2)
        {
          localUpdateOp.positionStart -= 1;
          paramInt1 = j;
        }
      }
      i -= 1;
    }
    paramInt1 = this.mPostponedList.size() - 1;
    while (paramInt1 >= 0)
    {
      localUpdateOp = (AdapterHelper.UpdateOp)this.mPostponedList.get(paramInt1);
      if (localUpdateOp.cmd == 8)
      {
        if ((localUpdateOp.itemCount == localUpdateOp.positionStart) || (localUpdateOp.itemCount < 0))
        {
          this.mPostponedList.remove(paramInt1);
          recycleUpdateOp(localUpdateOp);
        }
      }
      else if (localUpdateOp.itemCount <= 0)
      {
        this.mPostponedList.remove(paramInt1);
        recycleUpdateOp(localUpdateOp);
      }
      paramInt1 -= 1;
    }
    return j;
  }
  
  AdapterHelper addUpdateOp(AdapterHelper.UpdateOp... paramVarArgs)
  {
    Collections.addAll(this.mPendingUpdates, paramVarArgs);
    return this;
  }
  
  public int applyPendingUpdatesToPosition(int paramInt)
  {
    int m = this.mPendingUpdates.size();
    int k = 0;
    for (int i = paramInt; k < m; i = paramInt)
    {
      AdapterHelper.UpdateOp localUpdateOp = (AdapterHelper.UpdateOp)this.mPendingUpdates.get(k);
      paramInt = localUpdateOp.cmd;
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 8)
          {
            paramInt = i;
          }
          else if (localUpdateOp.positionStart == i)
          {
            paramInt = localUpdateOp.itemCount;
          }
          else
          {
            int j = i;
            if (localUpdateOp.positionStart < i) {
              j = i - 1;
            }
            paramInt = j;
            if (localUpdateOp.itemCount <= j) {
              paramInt = j + 1;
            }
          }
        }
        else
        {
          paramInt = i;
          if (localUpdateOp.positionStart <= i)
          {
            if (localUpdateOp.positionStart + localUpdateOp.itemCount > i) {
              return -1;
            }
            paramInt = i - localUpdateOp.itemCount;
          }
        }
      }
      else
      {
        paramInt = i;
        if (localUpdateOp.positionStart <= i) {
          paramInt = i + localUpdateOp.itemCount;
        }
      }
      k += 1;
    }
    return i;
  }
  
  void consumePostponedUpdates()
  {
    int j = this.mPostponedList.size();
    int i = 0;
    while (i < j)
    {
      this.mCallback.onDispatchSecondPass((AdapterHelper.UpdateOp)this.mPostponedList.get(i));
      i += 1;
    }
    recycleUpdateOpsAndClearList(this.mPostponedList);
    this.mExistingUpdateTypes = 0;
  }
  
  void consumeUpdatesInOnePass()
  {
    consumePostponedUpdates();
    int j = this.mPendingUpdates.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (AdapterHelper.UpdateOp)this.mPendingUpdates.get(i);
      int k = ((AdapterHelper.UpdateOp)localObject).cmd;
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 4)
          {
            if (k == 8)
            {
              this.mCallback.onDispatchSecondPass((AdapterHelper.UpdateOp)localObject);
              this.mCallback.offsetPositionsForMove(((AdapterHelper.UpdateOp)localObject).positionStart, ((AdapterHelper.UpdateOp)localObject).itemCount);
            }
          }
          else
          {
            this.mCallback.onDispatchSecondPass((AdapterHelper.UpdateOp)localObject);
            this.mCallback.markViewHoldersUpdated(((AdapterHelper.UpdateOp)localObject).positionStart, ((AdapterHelper.UpdateOp)localObject).itemCount, ((AdapterHelper.UpdateOp)localObject).payload);
          }
        }
        else
        {
          this.mCallback.onDispatchSecondPass((AdapterHelper.UpdateOp)localObject);
          this.mCallback.offsetPositionsForRemovingInvisible(((AdapterHelper.UpdateOp)localObject).positionStart, ((AdapterHelper.UpdateOp)localObject).itemCount);
        }
      }
      else
      {
        this.mCallback.onDispatchSecondPass((AdapterHelper.UpdateOp)localObject);
        this.mCallback.offsetPositionsForAdd(((AdapterHelper.UpdateOp)localObject).positionStart, ((AdapterHelper.UpdateOp)localObject).itemCount);
      }
      localObject = this.mOnItemProcessedCallback;
      if (localObject != null) {
        ((Runnable)localObject).run();
      }
      i += 1;
    }
    recycleUpdateOpsAndClearList(this.mPendingUpdates);
    this.mExistingUpdateTypes = 0;
  }
  
  void dispatchFirstPassAndUpdateViewHolders(AdapterHelper.UpdateOp paramUpdateOp, int paramInt)
  {
    this.mCallback.onDispatchFirstPass(paramUpdateOp);
    int i = paramUpdateOp.cmd;
    if (i != 2)
    {
      if (i == 4)
      {
        this.mCallback.markViewHoldersUpdated(paramInt, paramUpdateOp.itemCount, paramUpdateOp.payload);
        return;
      }
      throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
    }
    this.mCallback.offsetPositionsForRemovingInvisible(paramInt, paramUpdateOp.itemCount);
  }
  
  int findPositionOffset(int paramInt)
  {
    return findPositionOffset(paramInt, 0);
  }
  
  int findPositionOffset(int paramInt1, int paramInt2)
  {
    int k = this.mPostponedList.size();
    int j = paramInt2;
    for (paramInt2 = paramInt1; j < k; paramInt2 = paramInt1)
    {
      AdapterHelper.UpdateOp localUpdateOp = (AdapterHelper.UpdateOp)this.mPostponedList.get(j);
      if (localUpdateOp.cmd == 8)
      {
        if (localUpdateOp.positionStart == paramInt2)
        {
          paramInt1 = localUpdateOp.itemCount;
        }
        else
        {
          int i = paramInt2;
          if (localUpdateOp.positionStart < paramInt2) {
            i = paramInt2 - 1;
          }
          paramInt1 = i;
          if (localUpdateOp.itemCount <= i) {
            paramInt1 = i + 1;
          }
        }
      }
      else
      {
        paramInt1 = paramInt2;
        if (localUpdateOp.positionStart <= paramInt2) {
          if (localUpdateOp.cmd == 2)
          {
            if (paramInt2 < localUpdateOp.positionStart + localUpdateOp.itemCount) {
              return -1;
            }
            paramInt1 = paramInt2 - localUpdateOp.itemCount;
          }
          else
          {
            paramInt1 = paramInt2;
            if (localUpdateOp.cmd == 1) {
              paramInt1 = paramInt2 + localUpdateOp.itemCount;
            }
          }
        }
      }
      j += 1;
    }
    return paramInt2;
  }
  
  boolean hasAnyUpdateTypes(int paramInt)
  {
    return (paramInt & this.mExistingUpdateTypes) != 0;
  }
  
  boolean hasPendingUpdates()
  {
    return this.mPendingUpdates.size() > 0;
  }
  
  boolean hasUpdates()
  {
    return (!this.mPostponedList.isEmpty()) && (!this.mPendingUpdates.isEmpty());
  }
  
  public AdapterHelper.UpdateOp obtainUpdateOp(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    AdapterHelper.UpdateOp localUpdateOp = (AdapterHelper.UpdateOp)this.mUpdateOpPool.acquire();
    if (localUpdateOp == null) {
      return new AdapterHelper.UpdateOp(paramInt1, paramInt2, paramInt3, paramObject);
    }
    localUpdateOp.cmd = paramInt1;
    localUpdateOp.positionStart = paramInt2;
    localUpdateOp.itemCount = paramInt3;
    localUpdateOp.payload = paramObject;
    return localUpdateOp;
  }
  
  boolean onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    boolean bool = false;
    if (paramInt2 < 1) {
      return false;
    }
    this.mPendingUpdates.add(obtainUpdateOp(4, paramInt1, paramInt2, paramObject));
    this.mExistingUpdateTypes |= 0x4;
    if (this.mPendingUpdates.size() == 1) {
      bool = true;
    }
    return bool;
  }
  
  boolean onItemRangeInserted(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (paramInt2 < 1) {
      return false;
    }
    this.mPendingUpdates.add(obtainUpdateOp(1, paramInt1, paramInt2, null));
    this.mExistingUpdateTypes |= 0x1;
    if (this.mPendingUpdates.size() == 1) {
      bool = true;
    }
    return bool;
  }
  
  boolean onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = false;
    if (paramInt1 == paramInt2) {
      return false;
    }
    if (paramInt3 == 1)
    {
      this.mPendingUpdates.add(obtainUpdateOp(8, paramInt1, paramInt2, null));
      this.mExistingUpdateTypes |= 0x8;
      if (this.mPendingUpdates.size() == 1) {
        bool = true;
      }
      return bool;
    }
    throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
  }
  
  boolean onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (paramInt2 < 1) {
      return false;
    }
    this.mPendingUpdates.add(obtainUpdateOp(2, paramInt1, paramInt2, null));
    this.mExistingUpdateTypes |= 0x2;
    if (this.mPendingUpdates.size() == 1) {
      bool = true;
    }
    return bool;
  }
  
  void preProcess()
  {
    this.mOpReorderer.reorderOps(this.mPendingUpdates);
    int j = this.mPendingUpdates.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = (AdapterHelper.UpdateOp)this.mPendingUpdates.get(i);
      int k = ((AdapterHelper.UpdateOp)localObject).cmd;
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 4)
          {
            if (k == 8) {
              applyMove((AdapterHelper.UpdateOp)localObject);
            }
          }
          else {
            applyUpdate((AdapterHelper.UpdateOp)localObject);
          }
        }
        else {
          applyRemove((AdapterHelper.UpdateOp)localObject);
        }
      }
      else {
        applyAdd((AdapterHelper.UpdateOp)localObject);
      }
      localObject = this.mOnItemProcessedCallback;
      if (localObject != null) {
        ((Runnable)localObject).run();
      }
      i += 1;
    }
    this.mPendingUpdates.clear();
  }
  
  public void recycleUpdateOp(AdapterHelper.UpdateOp paramUpdateOp)
  {
    if (!this.mDisableRecycler)
    {
      paramUpdateOp.payload = null;
      this.mUpdateOpPool.release(paramUpdateOp);
    }
  }
  
  void recycleUpdateOpsAndClearList(List<AdapterHelper.UpdateOp> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      recycleUpdateOp((AdapterHelper.UpdateOp)paramList.get(i));
      i += 1;
    }
    paramList.clear();
  }
  
  void reset()
  {
    recycleUpdateOpsAndClearList(this.mPendingUpdates);
    recycleUpdateOpsAndClearList(this.mPostponedList);
    this.mExistingUpdateTypes = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.AdapterHelper
 * JD-Core Version:    0.7.0.1
 */