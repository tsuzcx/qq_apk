package android.support.v7.widget;

import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;
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
    int k = paramUpdateOp.positionStart + paramUpdateOp.itemCount;
    int j = -1;
    int i = paramUpdateOp.positionStart;
    int n = 0;
    if (i < k) {
      if ((this.mCallback.findViewHolder(i) != null) || (canFindInPreLayout(i)))
      {
        if (j != 0) {
          break label216;
        }
        dispatchAndUpdateViewHolders(obtainUpdateOp(2, i2, n, null));
      }
    }
    label211:
    label216:
    for (int m = 1;; m = 0)
    {
      j = 1;
      if (m != 0)
      {
        m = i - n;
        i = k - n;
        k = 1;
        label97:
        n = k;
        k = i;
        i = m + 1;
        break;
        if (j != 1) {
          break label211;
        }
        postponeAndUpdateViewHolders(obtainUpdateOp(2, i2, n, null));
      }
      for (j = 1;; j = 0)
      {
        int i1 = 0;
        m = j;
        j = i1;
        break;
        n += 1;
        m = i;
        i = k;
        k = n;
        break label97;
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
        return;
      }
    }
  }
  
  private void applyUpdate(AdapterHelper.UpdateOp paramUpdateOp)
  {
    int k = paramUpdateOp.positionStart;
    int i2 = paramUpdateOp.positionStart;
    int i3 = paramUpdateOp.itemCount;
    int i = paramUpdateOp.positionStart;
    int i1 = -1;
    int j = 0;
    if (i < i2 + i3)
    {
      int m;
      int n;
      if ((this.mCallback.findViewHolder(i) != null) || (canFindInPreLayout(i)))
      {
        m = j;
        n = k;
        if (i1 == 0)
        {
          dispatchAndUpdateViewHolders(obtainUpdateOp(4, k, j, paramUpdateOp.payload));
          m = 0;
          n = i;
        }
        k = n;
      }
      for (j = 1;; j = 0)
      {
        i += 1;
        m += 1;
        i1 = j;
        j = m;
        break;
        m = j;
        n = k;
        if (i1 == 1)
        {
          postponeAndUpdateViewHolders(obtainUpdateOp(4, k, j, paramUpdateOp.payload));
          m = 0;
          n = i;
        }
        k = n;
      }
    }
    Object localObject = paramUpdateOp;
    if (j != paramUpdateOp.itemCount)
    {
      localObject = paramUpdateOp.payload;
      recycleUpdateOp(paramUpdateOp);
      localObject = obtainUpdateOp(4, k, j, localObject);
    }
    if (i1 == 0)
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
    if ((paramUpdateOp.cmd == 1) || (paramUpdateOp.cmd == 8)) {
      throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }
    int i1 = updatePositionWithPostponed(paramUpdateOp.positionStart, paramUpdateOp.cmd);
    int j = paramUpdateOp.positionStart;
    int k;
    int n;
    int m;
    label112:
    int i2;
    switch (paramUpdateOp.cmd)
    {
    case 3: 
    default: 
      throw new IllegalArgumentException("op should be remove or update." + paramUpdateOp);
    case 4: 
      k = 1;
      n = 1;
      m = 1;
      if (m >= paramUpdateOp.itemCount) {
        break label298;
      }
      i2 = updatePositionWithPostponed(paramUpdateOp.positionStart + k * m, paramUpdateOp.cmd);
      switch (paramUpdateOp.cmd)
      {
      case 3: 
      default: 
        i = 0;
        label174:
        if (i == 0) {}
        break;
      }
      break;
    }
    for (int i = n + 1;; i = n)
    {
      m += 1;
      n = i;
      break label112;
      k = 0;
      break;
      if (i2 == i1 + 1)
      {
        i = 1;
        break label174;
      }
      i = 0;
      break label174;
      if (i2 == i1)
      {
        i = 1;
        break label174;
      }
      i = 0;
      break label174;
      localObject = obtainUpdateOp(paramUpdateOp.cmd, i1, n, paramUpdateOp.payload);
      dispatchFirstPassAndUpdateViewHolders((AdapterHelper.UpdateOp)localObject, j);
      recycleUpdateOp((AdapterHelper.UpdateOp)localObject);
      i = j;
      if (paramUpdateOp.cmd == 4) {
        i = j + n;
      }
      n = 1;
      i1 = i2;
      j = i;
    }
    label298:
    Object localObject = paramUpdateOp.payload;
    recycleUpdateOp(paramUpdateOp);
    if (n > 0)
    {
      paramUpdateOp = obtainUpdateOp(paramUpdateOp.cmd, i1, n, localObject);
      dispatchFirstPassAndUpdateViewHolders(paramUpdateOp, j);
      recycleUpdateOp(paramUpdateOp);
    }
  }
  
  private void postponeAndUpdateViewHolders(AdapterHelper.UpdateOp paramUpdateOp)
  {
    this.mPostponedList.add(paramUpdateOp);
    switch (paramUpdateOp.cmd)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      throw new IllegalArgumentException("Unknown update op type for " + paramUpdateOp);
    case 1: 
      this.mCallback.offsetPositionsForAdd(paramUpdateOp.positionStart, paramUpdateOp.itemCount);
      return;
    case 8: 
      this.mCallback.offsetPositionsForMove(paramUpdateOp.positionStart, paramUpdateOp.itemCount);
      return;
    case 2: 
      this.mCallback.offsetPositionsForRemovingLaidOutOrNewView(paramUpdateOp.positionStart, paramUpdateOp.itemCount);
      return;
    }
    this.mCallback.markViewHoldersUpdated(paramUpdateOp.positionStart, paramUpdateOp.itemCount, paramUpdateOp.payload);
  }
  
  private int updatePositionWithPostponed(int paramInt1, int paramInt2)
  {
    int j = this.mPostponedList.size() - 1;
    AdapterHelper.UpdateOp localUpdateOp;
    if (j >= 0)
    {
      localUpdateOp = (AdapterHelper.UpdateOp)this.mPostponedList.get(j);
      int k;
      int i;
      if (localUpdateOp.cmd == 8) {
        if (localUpdateOp.positionStart < localUpdateOp.itemCount)
        {
          k = localUpdateOp.positionStart;
          i = localUpdateOp.itemCount;
          label66:
          if ((paramInt1 < k) || (paramInt1 > i)) {
            break label201;
          }
          if (k != localUpdateOp.positionStart) {
            break label157;
          }
          if (paramInt2 != 1) {
            break label137;
          }
          localUpdateOp.itemCount += 1;
          label104:
          paramInt1 += 1;
          label108:
          i = paramInt1;
        }
      }
      for (;;)
      {
        j -= 1;
        paramInt1 = i;
        break;
        k = localUpdateOp.itemCount;
        i = localUpdateOp.positionStart;
        break label66;
        label137:
        if (paramInt2 != 2) {
          break label104;
        }
        localUpdateOp.itemCount -= 1;
        break label104;
        label157:
        if (paramInt2 == 1) {
          localUpdateOp.positionStart += 1;
        }
        for (;;)
        {
          paramInt1 -= 1;
          break;
          if (paramInt2 == 2) {
            localUpdateOp.positionStart -= 1;
          }
        }
        label201:
        if (paramInt1 < localUpdateOp.positionStart)
        {
          if (paramInt2 == 1)
          {
            localUpdateOp.positionStart += 1;
            localUpdateOp.itemCount += 1;
            break label108;
          }
          if (paramInt2 == 2)
          {
            localUpdateOp.positionStart -= 1;
            localUpdateOp.itemCount -= 1;
          }
        }
        break label108;
        if (localUpdateOp.positionStart <= paramInt1)
        {
          if (localUpdateOp.cmd == 1)
          {
            i = paramInt1 - localUpdateOp.itemCount;
          }
          else
          {
            i = paramInt1;
            if (localUpdateOp.cmd == 2) {
              i = paramInt1 + localUpdateOp.itemCount;
            }
          }
        }
        else if (paramInt2 == 1)
        {
          localUpdateOp.positionStart += 1;
          i = paramInt1;
        }
        else
        {
          i = paramInt1;
          if (paramInt2 == 2)
          {
            localUpdateOp.positionStart -= 1;
            i = paramInt1;
          }
        }
      }
    }
    paramInt2 = this.mPostponedList.size() - 1;
    if (paramInt2 >= 0)
    {
      localUpdateOp = (AdapterHelper.UpdateOp)this.mPostponedList.get(paramInt2);
      if (localUpdateOp.cmd == 8) {
        if ((localUpdateOp.itemCount == localUpdateOp.positionStart) || (localUpdateOp.itemCount < 0))
        {
          this.mPostponedList.remove(paramInt2);
          recycleUpdateOp(localUpdateOp);
        }
      }
      for (;;)
      {
        paramInt2 -= 1;
        break;
        if (localUpdateOp.itemCount <= 0)
        {
          this.mPostponedList.remove(paramInt2);
          recycleUpdateOp(localUpdateOp);
        }
      }
    }
    return paramInt1;
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
    int i = paramInt;
    paramInt = i;
    AdapterHelper.UpdateOp localUpdateOp;
    if (k < m)
    {
      localUpdateOp = (AdapterHelper.UpdateOp)this.mPendingUpdates.get(k);
      switch (localUpdateOp.cmd)
      {
      default: 
        paramInt = i;
      }
    }
    for (;;)
    {
      k += 1;
      i = paramInt;
      break;
      paramInt = i;
      if (localUpdateOp.positionStart <= i)
      {
        paramInt = i + localUpdateOp.itemCount;
        continue;
        paramInt = i;
        if (localUpdateOp.positionStart <= i)
        {
          if (localUpdateOp.positionStart + localUpdateOp.itemCount > i)
          {
            paramInt = -1;
            return paramInt;
          }
          paramInt = i - localUpdateOp.itemCount;
          continue;
          if (localUpdateOp.positionStart == i)
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
      }
    }
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
    if (i < j)
    {
      AdapterHelper.UpdateOp localUpdateOp = (AdapterHelper.UpdateOp)this.mPendingUpdates.get(i);
      switch (localUpdateOp.cmd)
      {
      }
      for (;;)
      {
        if (this.mOnItemProcessedCallback != null) {
          this.mOnItemProcessedCallback.run();
        }
        i += 1;
        break;
        this.mCallback.onDispatchSecondPass(localUpdateOp);
        this.mCallback.offsetPositionsForAdd(localUpdateOp.positionStart, localUpdateOp.itemCount);
        continue;
        this.mCallback.onDispatchSecondPass(localUpdateOp);
        this.mCallback.offsetPositionsForRemovingInvisible(localUpdateOp.positionStart, localUpdateOp.itemCount);
        continue;
        this.mCallback.onDispatchSecondPass(localUpdateOp);
        this.mCallback.markViewHoldersUpdated(localUpdateOp.positionStart, localUpdateOp.itemCount, localUpdateOp.payload);
        continue;
        this.mCallback.onDispatchSecondPass(localUpdateOp);
        this.mCallback.offsetPositionsForMove(localUpdateOp.positionStart, localUpdateOp.itemCount);
      }
    }
    recycleUpdateOpsAndClearList(this.mPendingUpdates);
    this.mExistingUpdateTypes = 0;
  }
  
  void dispatchFirstPassAndUpdateViewHolders(AdapterHelper.UpdateOp paramUpdateOp, int paramInt)
  {
    this.mCallback.onDispatchFirstPass(paramUpdateOp);
    switch (paramUpdateOp.cmd)
    {
    case 3: 
    default: 
      throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
    case 2: 
      this.mCallback.offsetPositionsForRemovingInvisible(paramInt, paramUpdateOp.itemCount);
      return;
    }
    this.mCallback.markViewHoldersUpdated(paramInt, paramUpdateOp.itemCount, paramUpdateOp.payload);
  }
  
  int findPositionOffset(int paramInt)
  {
    return findPositionOffset(paramInt, 0);
  }
  
  int findPositionOffset(int paramInt1, int paramInt2)
  {
    int k = this.mPostponedList.size();
    int j = paramInt2;
    paramInt2 = paramInt1;
    paramInt1 = paramInt2;
    AdapterHelper.UpdateOp localUpdateOp;
    if (j < k)
    {
      localUpdateOp = (AdapterHelper.UpdateOp)this.mPostponedList.get(j);
      if (localUpdateOp.cmd == 8) {
        if (localUpdateOp.positionStart == paramInt2) {
          paramInt1 = localUpdateOp.itemCount;
        }
      }
    }
    for (;;)
    {
      j += 1;
      paramInt2 = paramInt1;
      break;
      int i = paramInt2;
      if (localUpdateOp.positionStart < paramInt2) {
        i = paramInt2 - 1;
      }
      paramInt1 = i;
      if (localUpdateOp.itemCount <= i)
      {
        paramInt1 = i + 1;
        continue;
        paramInt1 = paramInt2;
        if (localUpdateOp.positionStart <= paramInt2) {
          if (localUpdateOp.cmd == 2)
          {
            if (paramInt2 < localUpdateOp.positionStart + localUpdateOp.itemCount)
            {
              paramInt1 = -1;
              return paramInt1;
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
    }
  }
  
  boolean hasAnyUpdateTypes(int paramInt)
  {
    return (this.mExistingUpdateTypes & paramInt) != 0;
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
    this.mPendingUpdates.add(obtainUpdateOp(4, paramInt1, paramInt2, paramObject));
    this.mExistingUpdateTypes |= 0x4;
    return this.mPendingUpdates.size() == 1;
  }
  
  boolean onItemRangeInserted(int paramInt1, int paramInt2)
  {
    this.mPendingUpdates.add(obtainUpdateOp(1, paramInt1, paramInt2, null));
    this.mExistingUpdateTypes |= 0x1;
    return this.mPendingUpdates.size() == 1;
  }
  
  boolean onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    if (paramInt1 == paramInt2) {
      return false;
    }
    if (paramInt3 != 1) {
      throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }
    this.mPendingUpdates.add(obtainUpdateOp(8, paramInt1, paramInt2, null));
    this.mExistingUpdateTypes |= 0x8;
    if (this.mPendingUpdates.size() == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  boolean onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    this.mPendingUpdates.add(obtainUpdateOp(2, paramInt1, paramInt2, null));
    this.mExistingUpdateTypes |= 0x2;
    return this.mPendingUpdates.size() == 1;
  }
  
  void preProcess()
  {
    this.mOpReorderer.reorderOps(this.mPendingUpdates);
    int j = this.mPendingUpdates.size();
    int i = 0;
    if (i < j)
    {
      AdapterHelper.UpdateOp localUpdateOp = (AdapterHelper.UpdateOp)this.mPendingUpdates.get(i);
      switch (localUpdateOp.cmd)
      {
      }
      for (;;)
      {
        if (this.mOnItemProcessedCallback != null) {
          this.mOnItemProcessedCallback.run();
        }
        i += 1;
        break;
        applyAdd(localUpdateOp);
        continue;
        applyRemove(localUpdateOp);
        continue;
        applyUpdate(localUpdateOp);
        continue;
        applyMove(localUpdateOp);
      }
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
 * Qualified Name:     android.support.v7.widget.AdapterHelper
 * JD-Core Version:    0.7.0.1
 */