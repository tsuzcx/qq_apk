package android.support.v7.widget;

import java.util.List;

class OpReorderer
{
  final OpReorderer.Callback mCallback;
  
  public OpReorderer(OpReorderer.Callback paramCallback)
  {
    this.mCallback = paramCallback;
  }
  
  private int getLastMoveOutOfOrder(List<AdapterHelper.UpdateOp> paramList)
  {
    int i = paramList.size() - 1;
    int k;
    for (int j = 0; i >= 0; j = k)
    {
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
    }
    return -1;
  }
  
  private void swapMoveAdd(List<AdapterHelper.UpdateOp> paramList, int paramInt1, AdapterHelper.UpdateOp paramUpdateOp1, int paramInt2, AdapterHelper.UpdateOp paramUpdateOp2)
  {
    int i;
    if (paramUpdateOp1.itemCount < paramUpdateOp2.positionStart) {
      i = -1;
    } else {
      i = 0;
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
    int i = localUpdateOp2.cmd;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 4) {
          return;
        }
        swapMoveUpdate(paramList, paramInt1, localUpdateOp1, paramInt2, localUpdateOp2);
        return;
      }
      swapMoveRemove(paramList, paramInt1, localUpdateOp1, paramInt2, localUpdateOp2);
      return;
    }
    swapMoveAdd(paramList, paramInt1, localUpdateOp1, paramInt2, localUpdateOp2);
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
    int i = paramUpdateOp1.positionStart;
    int k = paramUpdateOp1.itemCount;
    int j = 0;
    if (i < k)
    {
      if ((paramUpdateOp2.positionStart == paramUpdateOp1.positionStart) && (paramUpdateOp2.itemCount == paramUpdateOp1.itemCount - paramUpdateOp1.positionStart))
      {
        i = 0;
      }
      else
      {
        i = 0;
        break label106;
      }
    }
    else
    {
      if ((paramUpdateOp2.positionStart != paramUpdateOp1.itemCount + 1) || (paramUpdateOp2.itemCount != paramUpdateOp1.positionStart - paramUpdateOp1.itemCount)) {
        break label103;
      }
      i = 1;
    }
    j = 1;
    break label106;
    label103:
    i = 1;
    label106:
    if (paramUpdateOp1.itemCount < paramUpdateOp2.positionStart)
    {
      paramUpdateOp2.positionStart -= 1;
    }
    else if (paramUpdateOp1.itemCount < paramUpdateOp2.positionStart + paramUpdateOp2.itemCount)
    {
      paramUpdateOp2.itemCount -= 1;
      paramUpdateOp1.cmd = 2;
      paramUpdateOp1.itemCount = 1;
      if (paramUpdateOp2.itemCount == 0)
      {
        paramList.remove(paramInt2);
        this.mCallback.recycleUpdateOp(paramUpdateOp2);
      }
      return;
    }
    k = paramUpdateOp1.positionStart;
    int m = paramUpdateOp2.positionStart;
    AdapterHelper.UpdateOp localUpdateOp = null;
    if (k <= m)
    {
      paramUpdateOp2.positionStart += 1;
    }
    else if (paramUpdateOp1.positionStart < paramUpdateOp2.positionStart + paramUpdateOp2.itemCount)
    {
      k = paramUpdateOp2.positionStart;
      m = paramUpdateOp2.itemCount;
      int n = paramUpdateOp1.positionStart;
      localUpdateOp = this.mCallback.obtainUpdateOp(2, paramUpdateOp1.positionStart + 1, k + m - n, null);
      paramUpdateOp2.itemCount = (paramUpdateOp1.positionStart - paramUpdateOp2.positionStart);
    }
    if (j != 0)
    {
      paramList.set(paramInt1, paramUpdateOp2);
      paramList.remove(paramInt2);
      this.mCallback.recycleUpdateOp(paramUpdateOp1);
      return;
    }
    if (i != 0)
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
    }
    else
    {
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
      if (paramUpdateOp1.itemCount >= paramUpdateOp2.positionStart) {
        paramUpdateOp1.itemCount -= paramUpdateOp2.itemCount;
      }
    }
    paramList.set(paramInt1, paramUpdateOp2);
    if (paramUpdateOp1.positionStart != paramUpdateOp1.itemCount) {
      paramList.set(paramInt2, paramUpdateOp1);
    } else {
      paramList.remove(paramInt2);
    }
    if (localUpdateOp != null) {
      paramList.add(paramInt1, localUpdateOp);
    }
  }
  
  void swapMoveUpdate(List<AdapterHelper.UpdateOp> paramList, int paramInt1, AdapterHelper.UpdateOp paramUpdateOp1, int paramInt2, AdapterHelper.UpdateOp paramUpdateOp2)
  {
    int i = paramUpdateOp1.itemCount;
    int j = paramUpdateOp2.positionStart;
    AdapterHelper.UpdateOp localUpdateOp2 = null;
    if (i < j)
    {
      paramUpdateOp2.positionStart -= 1;
    }
    else if (paramUpdateOp1.itemCount < paramUpdateOp2.positionStart + paramUpdateOp2.itemCount)
    {
      paramUpdateOp2.itemCount -= 1;
      localUpdateOp1 = this.mCallback.obtainUpdateOp(4, paramUpdateOp1.positionStart, 1, paramUpdateOp2.payload);
      break label96;
    }
    AdapterHelper.UpdateOp localUpdateOp1 = null;
    label96:
    if (paramUpdateOp1.positionStart <= paramUpdateOp2.positionStart)
    {
      paramUpdateOp2.positionStart += 1;
    }
    else if (paramUpdateOp1.positionStart < paramUpdateOp2.positionStart + paramUpdateOp2.itemCount)
    {
      i = paramUpdateOp2.positionStart + paramUpdateOp2.itemCount - paramUpdateOp1.positionStart;
      localUpdateOp2 = this.mCallback.obtainUpdateOp(4, paramUpdateOp1.positionStart + 1, i, paramUpdateOp2.payload);
      paramUpdateOp2.itemCount -= i;
    }
    paramList.set(paramInt2, paramUpdateOp1);
    if (paramUpdateOp2.itemCount > 0)
    {
      paramList.set(paramInt1, paramUpdateOp2);
    }
    else
    {
      paramList.remove(paramInt1);
      this.mCallback.recycleUpdateOp(paramUpdateOp2);
    }
    if (localUpdateOp1 != null) {
      paramList.add(paramInt1, localUpdateOp1);
    }
    if (localUpdateOp2 != null) {
      paramList.add(paramInt1, localUpdateOp2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.OpReorderer
 * JD-Core Version:    0.7.0.1
 */