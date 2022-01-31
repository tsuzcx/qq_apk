package android.support.v7.widget;

import java.util.List;

class OpReorderer
{
  final Callback mCallback;
  
  public OpReorderer(Callback paramCallback)
  {
    this.mCallback = paramCallback;
  }
  
  private int getLastMoveOutOfOrder(List<AdapterHelper.UpdateOp> paramList)
  {
    int j = 0;
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      int k;
      if (((AdapterHelper.UpdateOp)paramList.get(i)).cmd == 8)
      {
        k = j;
        if (j != 0) {
          return i;
        }
      }
      else
      {
        k = 1;
      }
      i -= 1;
      j = k;
    }
    return -1;
  }
  
  private void swapMoveAdd(List<AdapterHelper.UpdateOp> paramList, int paramInt1, AdapterHelper.UpdateOp paramUpdateOp1, int paramInt2, AdapterHelper.UpdateOp paramUpdateOp2)
  {
    int i = 0;
    if (paramUpdateOp1.itemCount < paramUpdateOp2.positionStart) {
      i = 0 - 1;
    }
    int j = i;
    if (paramUpdateOp1.positionStart < paramUpdateOp2.positionStart) {
      j = i + 1;
    }
    if (paramUpdateOp2.positionStart <= paramUpdateOp1.positionStart) {
      paramUpdateOp1.positionStart += paramUpdateOp2.itemCount;
    }
    if (paramUpdateOp2.positionStart <= paramUpdateOp1.itemCount) {
      paramUpdateOp1.itemCount += paramUpdateOp2.itemCount;
    }
    paramUpdateOp2.positionStart += j;
    paramList.set(paramInt1, paramUpdateOp2);
    paramList.set(paramInt2, paramUpdateOp1);
  }
  
  private void swapMoveOp(List<AdapterHelper.UpdateOp> paramList, int paramInt1, int paramInt2)
  {
    AdapterHelper.UpdateOp localUpdateOp1 = (AdapterHelper.UpdateOp)paramList.get(paramInt1);
    AdapterHelper.UpdateOp localUpdateOp2 = (AdapterHelper.UpdateOp)paramList.get(paramInt2);
    switch (localUpdateOp2.cmd)
    {
    case 3: 
    default: 
      return;
    case 2: 
      swapMoveRemove(paramList, paramInt1, localUpdateOp1, paramInt2, localUpdateOp2);
      return;
    case 1: 
      swapMoveAdd(paramList, paramInt1, localUpdateOp1, paramInt2, localUpdateOp2);
      return;
    }
    swapMoveUpdate(paramList, paramInt1, localUpdateOp1, paramInt2, localUpdateOp2);
  }
  
  void reorderOps(List<AdapterHelper.UpdateOp> paramList)
  {
    for (;;)
    {
      int i = getLastMoveOutOfOrder(paramList);
      if (i == -1) {
        break;
      }
      swapMoveOp(paramList, i, i + 1);
    }
  }
  
  void swapMoveRemove(List<AdapterHelper.UpdateOp> paramList, int paramInt1, AdapterHelper.UpdateOp paramUpdateOp1, int paramInt2, AdapterHelper.UpdateOp paramUpdateOp2)
  {
    AdapterHelper.UpdateOp localUpdateOp = null;
    int k = 0;
    int m;
    int j;
    int i;
    if (paramUpdateOp1.positionStart < paramUpdateOp1.itemCount)
    {
      m = 0;
      j = m;
      i = k;
      if (paramUpdateOp2.positionStart == paramUpdateOp1.positionStart)
      {
        j = m;
        i = k;
        if (paramUpdateOp2.itemCount == paramUpdateOp1.itemCount - paramUpdateOp1.positionStart)
        {
          i = 1;
          j = m;
        }
      }
      if (paramUpdateOp1.itemCount >= paramUpdateOp2.positionStart) {
        break label215;
      }
      paramUpdateOp2.positionStart -= 1;
      label96:
      if (paramUpdateOp1.positionStart > paramUpdateOp2.positionStart) {
        break label284;
      }
      paramUpdateOp2.positionStart += 1;
      label120:
      if (i == 0) {
        break label367;
      }
      paramList.set(paramInt1, paramUpdateOp2);
      paramList.remove(paramInt2);
      this.mCallback.recycleUpdateOp(paramUpdateOp1);
    }
    label649:
    for (;;)
    {
      return;
      m = 1;
      j = m;
      i = k;
      if (paramUpdateOp2.positionStart != paramUpdateOp1.itemCount + 1) {
        break;
      }
      j = m;
      i = k;
      if (paramUpdateOp2.itemCount != paramUpdateOp1.positionStart - paramUpdateOp1.itemCount) {
        break;
      }
      i = 1;
      j = m;
      break;
      label215:
      if (paramUpdateOp1.itemCount >= paramUpdateOp2.positionStart + paramUpdateOp2.itemCount) {
        break label96;
      }
      paramUpdateOp2.itemCount -= 1;
      paramUpdateOp1.cmd = 2;
      paramUpdateOp1.itemCount = 1;
      if (paramUpdateOp2.itemCount == 0)
      {
        paramList.remove(paramInt2);
        this.mCallback.recycleUpdateOp(paramUpdateOp2);
        return;
        label284:
        if (paramUpdateOp1.positionStart >= paramUpdateOp2.positionStart + paramUpdateOp2.itemCount) {
          break label120;
        }
        k = paramUpdateOp2.positionStart;
        m = paramUpdateOp2.itemCount;
        int n = paramUpdateOp1.positionStart;
        localUpdateOp = this.mCallback.obtainUpdateOp(2, paramUpdateOp1.positionStart + 1, k + m - n, null);
        paramUpdateOp2.itemCount = (paramUpdateOp1.positionStart - paramUpdateOp2.positionStart);
        break label120;
        label367:
        if (j != 0)
        {
          if (localUpdateOp != null)
          {
            if (paramUpdateOp1.positionStart > localUpdateOp.positionStart) {
              paramUpdateOp1.positionStart -= localUpdateOp.itemCount;
            }
            if (paramUpdateOp1.itemCount > localUpdateOp.positionStart) {
              paramUpdateOp1.itemCount -= localUpdateOp.itemCount;
            }
          }
          if (paramUpdateOp1.positionStart > paramUpdateOp2.positionStart) {
            paramUpdateOp1.positionStart -= paramUpdateOp2.itemCount;
          }
          if (paramUpdateOp1.itemCount > paramUpdateOp2.positionStart) {
            paramUpdateOp1.itemCount -= paramUpdateOp2.itemCount;
          }
          paramList.set(paramInt1, paramUpdateOp2);
          if (paramUpdateOp1.positionStart == paramUpdateOp1.itemCount) {
            break label639;
          }
          paramList.set(paramInt2, paramUpdateOp1);
        }
        for (;;)
        {
          if (localUpdateOp == null) {
            break label649;
          }
          paramList.add(paramInt1, localUpdateOp);
          return;
          if (localUpdateOp != null)
          {
            if (paramUpdateOp1.positionStart >= localUpdateOp.positionStart) {
              paramUpdateOp1.positionStart -= localUpdateOp.itemCount;
            }
            if (paramUpdateOp1.itemCount >= localUpdateOp.positionStart) {
              paramUpdateOp1.itemCount -= localUpdateOp.itemCount;
            }
          }
          if (paramUpdateOp1.positionStart >= paramUpdateOp2.positionStart) {
            paramUpdateOp1.positionStart -= paramUpdateOp2.itemCount;
          }
          if (paramUpdateOp1.itemCount < paramUpdateOp2.positionStart) {
            break;
          }
          paramUpdateOp1.itemCount -= paramUpdateOp2.itemCount;
          break;
          label639:
          paramList.remove(paramInt2);
        }
      }
    }
  }
  
  void swapMoveUpdate(List<AdapterHelper.UpdateOp> paramList, int paramInt1, AdapterHelper.UpdateOp paramUpdateOp1, int paramInt2, AdapterHelper.UpdateOp paramUpdateOp2)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramUpdateOp1.itemCount < paramUpdateOp2.positionStart)
    {
      paramUpdateOp2.positionStart -= 1;
      if (paramUpdateOp1.positionStart > paramUpdateOp2.positionStart) {
        break label166;
      }
      paramUpdateOp2.positionStart += 1;
      label54:
      paramList.set(paramInt2, paramUpdateOp1);
      if (paramUpdateOp2.itemCount <= 0) {
        break label243;
      }
      paramList.set(paramInt1, paramUpdateOp2);
    }
    for (;;)
    {
      if (localObject1 != null) {
        paramList.add(paramInt1, localObject1);
      }
      if (localObject2 != null) {
        paramList.add(paramInt1, localObject2);
      }
      return;
      if (paramUpdateOp1.itemCount >= paramUpdateOp2.positionStart + paramUpdateOp2.itemCount) {
        break;
      }
      paramUpdateOp2.itemCount -= 1;
      localObject1 = this.mCallback.obtainUpdateOp(4, paramUpdateOp1.positionStart, 1, paramUpdateOp2.payload);
      break;
      label166:
      if (paramUpdateOp1.positionStart >= paramUpdateOp2.positionStart + paramUpdateOp2.itemCount) {
        break label54;
      }
      int i = paramUpdateOp2.positionStart + paramUpdateOp2.itemCount - paramUpdateOp1.positionStart;
      localObject2 = this.mCallback.obtainUpdateOp(4, paramUpdateOp1.positionStart + 1, i, paramUpdateOp2.payload);
      paramUpdateOp2.itemCount -= i;
      break label54;
      label243:
      paramList.remove(paramInt1);
      this.mCallback.recycleUpdateOp(paramUpdateOp2);
    }
  }
  
  static abstract interface Callback
  {
    public abstract AdapterHelper.UpdateOp obtainUpdateOp(int paramInt1, int paramInt2, int paramInt3, Object paramObject);
    
    public abstract void recycleUpdateOp(AdapterHelper.UpdateOp paramUpdateOp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.OpReorderer
 * JD-Core Version:    0.7.0.1
 */