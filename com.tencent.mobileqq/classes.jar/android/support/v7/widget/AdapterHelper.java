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
  final Callback mCallback;
  final boolean mDisableRecycler;
  private int mExistingUpdateTypes = 0;
  Runnable mOnItemProcessedCallback;
  final OpReorderer mOpReorderer;
  final ArrayList<UpdateOp> mPendingUpdates = new ArrayList();
  final ArrayList<UpdateOp> mPostponedList = new ArrayList();
  private Pools.Pool<UpdateOp> mUpdateOpPool = new Pools.SimplePool(30);
  
  AdapterHelper(Callback paramCallback)
  {
    this(paramCallback, false);
  }
  
  AdapterHelper(Callback paramCallback, boolean paramBoolean)
  {
    this.mCallback = paramCallback;
    this.mDisableRecycler = paramBoolean;
    this.mOpReorderer = new OpReorderer(this);
  }
  
  private void applyAdd(UpdateOp paramUpdateOp)
  {
    postponeAndUpdateViewHolders(paramUpdateOp);
  }
  
  private void applyMove(UpdateOp paramUpdateOp)
  {
    postponeAndUpdateViewHolders(paramUpdateOp);
  }
  
  private void applyRemove(UpdateOp paramUpdateOp)
  {
    int i2 = paramUpdateOp.positionStart;
    int n = 0;
    int m = paramUpdateOp.positionStart + paramUpdateOp.itemCount;
    int i1 = -1;
    int i = paramUpdateOp.positionStart;
    if (i < m)
    {
      int k = 0;
      int j = 0;
      if ((this.mCallback.findViewHolder(i) != null) || (canFindInPreLayout(i)))
      {
        if (i1 == 0)
        {
          dispatchAndUpdateViewHolders(obtainUpdateOp(2, i2, n, null));
          j = 1;
        }
        i1 = 1;
        k = j;
        j = i1;
        label90:
        if (k == 0) {
          break label152;
        }
        i -= n;
        m -= n;
      }
      label152:
      for (k = 1;; k = n + 1)
      {
        i += 1;
        n = k;
        i1 = j;
        break;
        if (i1 == 1)
        {
          postponeAndUpdateViewHolders(obtainUpdateOp(2, i2, n, null));
          k = 1;
        }
        j = 0;
        break label90;
      }
    }
    UpdateOp localUpdateOp = paramUpdateOp;
    if (n != paramUpdateOp.itemCount)
    {
      recycleUpdateOp(paramUpdateOp);
      localUpdateOp = obtainUpdateOp(2, i2, n, null);
    }
    if (i1 == 0)
    {
      dispatchAndUpdateViewHolders(localUpdateOp);
      return;
    }
    postponeAndUpdateViewHolders(localUpdateOp);
  }
  
  private void applyUpdate(UpdateOp paramUpdateOp)
  {
    int k = paramUpdateOp.positionStart;
    int j = 0;
    int i3 = paramUpdateOp.positionStart;
    int i4 = paramUpdateOp.itemCount;
    int i2 = -1;
    int i = paramUpdateOp.positionStart;
    if (i < i3 + i4)
    {
      int n;
      int m;
      if ((this.mCallback.findViewHolder(i) != null) || (canFindInPreLayout(i)))
      {
        n = j;
        int i1 = k;
        if (i2 == 0)
        {
          dispatchAndUpdateViewHolders(obtainUpdateOp(4, k, j, paramUpdateOp.payload));
          n = 0;
          i1 = i;
        }
        m = 1;
        k = i1;
      }
      for (;;)
      {
        j = n + 1;
        i += 1;
        i2 = m;
        break;
        n = j;
        m = k;
        if (i2 == 1)
        {
          postponeAndUpdateViewHolders(obtainUpdateOp(4, k, j, paramUpdateOp.payload));
          n = 0;
          m = i;
        }
        j = 0;
        k = m;
        m = j;
      }
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
      dispatchAndUpdateViewHolders((UpdateOp)localObject);
      return;
    }
    postponeAndUpdateViewHolders((UpdateOp)localObject);
  }
  
  private boolean canFindInPreLayout(int paramInt)
  {
    int k = this.mPostponedList.size();
    int i = 0;
    while (i < k)
    {
      UpdateOp localUpdateOp = (UpdateOp)this.mPostponedList.get(i);
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
        for (;;)
        {
          if (j >= m + n) {
            break label115;
          }
          if (findPositionOffset(j, i + 1) == paramInt) {
            break;
          }
          j += 1;
        }
      }
      label115:
      i += 1;
    }
    return false;
  }
  
  private void dispatchAndUpdateViewHolders(UpdateOp paramUpdateOp)
  {
    if ((paramUpdateOp.cmd == 1) || (paramUpdateOp.cmd == 8)) {
      throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }
    int i1 = updatePositionWithPostponed(paramUpdateOp.positionStart, paramUpdateOp.cmd);
    int n = 1;
    int i = paramUpdateOp.positionStart;
    int k;
    int m;
    label113:
    int i2;
    switch (paramUpdateOp.cmd)
    {
    case 3: 
    default: 
      throw new IllegalArgumentException("op should be remove or update." + paramUpdateOp);
    case 4: 
      k = 1;
      m = 1;
      if (m >= paramUpdateOp.itemCount) {
        break label307;
      }
      i2 = updatePositionWithPostponed(paramUpdateOp.positionStart + k * m, paramUpdateOp.cmd);
      int i3 = 0;
      j = i3;
      switch (paramUpdateOp.cmd)
      {
      default: 
        j = i3;
      case 3: 
        if (j == 0) {}
        break;
      }
      break;
    }
    for (int j = n + 1;; j = n)
    {
      m += 1;
      n = j;
      break label113;
      k = 0;
      break;
      if (i2 == i1 + 1) {}
      for (j = 1;; j = 0) {
        break;
      }
      if (i2 == i1) {}
      for (j = 1;; j = 0) {
        break;
      }
      localObject = obtainUpdateOp(paramUpdateOp.cmd, i1, n, paramUpdateOp.payload);
      dispatchFirstPassAndUpdateViewHolders((UpdateOp)localObject, i);
      recycleUpdateOp((UpdateOp)localObject);
      j = i;
      if (paramUpdateOp.cmd == 4) {
        j = i + n;
      }
      i1 = i2;
      n = 1;
      i = j;
    }
    label307:
    Object localObject = paramUpdateOp.payload;
    recycleUpdateOp(paramUpdateOp);
    if (n > 0)
    {
      paramUpdateOp = obtainUpdateOp(paramUpdateOp.cmd, i1, n, localObject);
      dispatchFirstPassAndUpdateViewHolders(paramUpdateOp, i);
      recycleUpdateOp(paramUpdateOp);
    }
  }
  
  private void postponeAndUpdateViewHolders(UpdateOp paramUpdateOp)
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
    int i = this.mPostponedList.size() - 1;
    int j = paramInt1;
    UpdateOp localUpdateOp;
    if (i >= 0)
    {
      localUpdateOp = (UpdateOp)this.mPostponedList.get(i);
      int k;
      if (localUpdateOp.cmd == 8) {
        if (localUpdateOp.positionStart < localUpdateOp.itemCount)
        {
          k = localUpdateOp.positionStart;
          paramInt1 = localUpdateOp.itemCount;
          label66:
          if ((j < k) || (j > paramInt1)) {
            break label202;
          }
          if (k != localUpdateOp.positionStart) {
            break label157;
          }
          if (paramInt2 != 1) {
            break label137;
          }
          localUpdateOp.itemCount += 1;
          label106:
          paramInt1 = j + 1;
        }
      }
      for (;;)
      {
        i -= 1;
        j = paramInt1;
        break;
        k = localUpdateOp.itemCount;
        paramInt1 = localUpdateOp.positionStart;
        break label66;
        label137:
        if (paramInt2 != 2) {
          break label106;
        }
        localUpdateOp.itemCount -= 1;
        break label106;
        label157:
        if (paramInt2 == 1) {
          localUpdateOp.positionStart += 1;
        }
        for (;;)
        {
          paramInt1 = j - 1;
          break;
          if (paramInt2 == 2) {
            localUpdateOp.positionStart -= 1;
          }
        }
        label202:
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
              continue;
              if (localUpdateOp.positionStart <= j)
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
            }
          }
        }
      }
    }
    paramInt1 = this.mPostponedList.size() - 1;
    if (paramInt1 >= 0)
    {
      localUpdateOp = (UpdateOp)this.mPostponedList.get(paramInt1);
      if (localUpdateOp.cmd == 8) {
        if ((localUpdateOp.itemCount == localUpdateOp.positionStart) || (localUpdateOp.itemCount < 0))
        {
          this.mPostponedList.remove(paramInt1);
          recycleUpdateOp(localUpdateOp);
        }
      }
      for (;;)
      {
        paramInt1 -= 1;
        break;
        if (localUpdateOp.itemCount <= 0)
        {
          this.mPostponedList.remove(paramInt1);
          recycleUpdateOp(localUpdateOp);
        }
      }
    }
    return j;
  }
  
  AdapterHelper addUpdateOp(UpdateOp... paramVarArgs)
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
    UpdateOp localUpdateOp;
    if (k < m)
    {
      localUpdateOp = (UpdateOp)this.mPendingUpdates.get(k);
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
      this.mCallback.onDispatchSecondPass((UpdateOp)this.mPostponedList.get(i));
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
      UpdateOp localUpdateOp = (UpdateOp)this.mPendingUpdates.get(i);
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
  
  void dispatchFirstPassAndUpdateViewHolders(UpdateOp paramUpdateOp, int paramInt)
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
    UpdateOp localUpdateOp;
    if (j < k)
    {
      localUpdateOp = (UpdateOp)this.mPostponedList.get(j);
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
  
  public UpdateOp obtainUpdateOp(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    UpdateOp localUpdateOp = (UpdateOp)this.mUpdateOpPool.acquire();
    if (localUpdateOp == null) {
      return new UpdateOp(paramInt1, paramInt2, paramInt3, paramObject);
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
      UpdateOp localUpdateOp = (UpdateOp)this.mPendingUpdates.get(i);
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
  
  public void recycleUpdateOp(UpdateOp paramUpdateOp)
  {
    if (!this.mDisableRecycler)
    {
      paramUpdateOp.payload = null;
      this.mUpdateOpPool.release(paramUpdateOp);
    }
  }
  
  void recycleUpdateOpsAndClearList(List<UpdateOp> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      recycleUpdateOp((UpdateOp)paramList.get(i));
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
  
  static abstract interface Callback
  {
    public abstract RecyclerView.ViewHolder findViewHolder(int paramInt);
    
    public abstract void markViewHoldersUpdated(int paramInt1, int paramInt2, Object paramObject);
    
    public abstract void offsetPositionsForAdd(int paramInt1, int paramInt2);
    
    public abstract void offsetPositionsForMove(int paramInt1, int paramInt2);
    
    public abstract void offsetPositionsForRemovingInvisible(int paramInt1, int paramInt2);
    
    public abstract void offsetPositionsForRemovingLaidOutOrNewView(int paramInt1, int paramInt2);
    
    public abstract void onDispatchFirstPass(AdapterHelper.UpdateOp paramUpdateOp);
    
    public abstract void onDispatchSecondPass(AdapterHelper.UpdateOp paramUpdateOp);
  }
  
  static class UpdateOp
  {
    static final int ADD = 1;
    static final int MOVE = 8;
    static final int POOL_SIZE = 30;
    static final int REMOVE = 2;
    static final int UPDATE = 4;
    int cmd;
    int itemCount;
    Object payload;
    int positionStart;
    
    UpdateOp(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
    {
      this.cmd = paramInt1;
      this.positionStart = paramInt2;
      this.itemCount = paramInt3;
      this.payload = paramObject;
    }
    
    String cmdToString()
    {
      switch (this.cmd)
      {
      case 3: 
      case 5: 
      case 6: 
      case 7: 
      default: 
        return "??";
      case 1: 
        return "add";
      case 2: 
        return "rm";
      case 4: 
        return "up";
      }
      return "mv";
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        do
        {
          do
          {
            return true;
            if ((paramObject == null) || (getClass() != paramObject.getClass())) {
              return false;
            }
            paramObject = (UpdateOp)paramObject;
            if (this.cmd != paramObject.cmd) {
              return false;
            }
          } while ((this.cmd == 8) && (Math.abs(this.itemCount - this.positionStart) == 1) && (this.itemCount == paramObject.positionStart) && (this.positionStart == paramObject.itemCount));
          if (this.itemCount != paramObject.itemCount) {
            return false;
          }
          if (this.positionStart != paramObject.positionStart) {
            return false;
          }
          if (this.payload == null) {
            break;
          }
        } while (this.payload.equals(paramObject.payload));
        return false;
      } while (paramObject.payload == null);
      return false;
    }
    
    public int hashCode()
    {
      return (this.cmd * 31 + this.positionStart) * 31 + this.itemCount;
    }
    
    public String toString()
    {
      return Integer.toHexString(System.identityHashCode(this)) + "[" + cmdToString() + ",s:" + this.positionStart + "c:" + this.itemCount + ",p:" + this.payload + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.AdapterHelper
 * JD-Core Version:    0.7.0.1
 */