package android.support.v7.widget;

import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;

class ViewInfoStore
{
  private static final boolean DEBUG = false;
  @VisibleForTesting
  final ArrayMap<RecyclerView.ViewHolder, ViewInfoStore.InfoRecord> mLayoutHolderMap = new ArrayMap();
  @VisibleForTesting
  final LongSparseArray<RecyclerView.ViewHolder> mOldChangedHolders = new LongSparseArray();
  
  private RecyclerView.ItemAnimator.ItemHolderInfo popFromLayoutStep(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int i = this.mLayoutHolderMap.indexOfKey(paramViewHolder);
    if (i < 0) {
      return null;
    }
    ViewInfoStore.InfoRecord localInfoRecord = (ViewInfoStore.InfoRecord)this.mLayoutHolderMap.valueAt(i);
    if ((localInfoRecord != null) && ((localInfoRecord.flags & paramInt) != 0))
    {
      localInfoRecord.flags &= (paramInt ^ 0xFFFFFFFF);
      if (paramInt == 4)
      {
        paramViewHolder = localInfoRecord.preInfo;
      }
      else
      {
        if (paramInt != 8) {
          break label110;
        }
        paramViewHolder = localInfoRecord.postInfo;
      }
      if ((localInfoRecord.flags & 0xC) == 0)
      {
        this.mLayoutHolderMap.removeAt(i);
        ViewInfoStore.InfoRecord.recycle(localInfoRecord);
      }
      return paramViewHolder;
      label110:
      throw new IllegalArgumentException("Must provide flag PRE or POST");
    }
    return null;
  }
  
  void addToAppearedInPreLayoutHolders(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo)
  {
    ViewInfoStore.InfoRecord localInfoRecord2 = (ViewInfoStore.InfoRecord)this.mLayoutHolderMap.get(paramViewHolder);
    ViewInfoStore.InfoRecord localInfoRecord1 = localInfoRecord2;
    if (localInfoRecord2 == null)
    {
      localInfoRecord1 = ViewInfoStore.InfoRecord.obtain();
      this.mLayoutHolderMap.put(paramViewHolder, localInfoRecord1);
    }
    localInfoRecord1.flags |= 0x2;
    localInfoRecord1.preInfo = paramItemHolderInfo;
  }
  
  void addToDisappearedInLayout(RecyclerView.ViewHolder paramViewHolder)
  {
    ViewInfoStore.InfoRecord localInfoRecord2 = (ViewInfoStore.InfoRecord)this.mLayoutHolderMap.get(paramViewHolder);
    ViewInfoStore.InfoRecord localInfoRecord1 = localInfoRecord2;
    if (localInfoRecord2 == null)
    {
      localInfoRecord1 = ViewInfoStore.InfoRecord.obtain();
      this.mLayoutHolderMap.put(paramViewHolder, localInfoRecord1);
    }
    localInfoRecord1.flags |= 0x1;
  }
  
  void addToOldChangeHolders(long paramLong, RecyclerView.ViewHolder paramViewHolder)
  {
    this.mOldChangedHolders.put(paramLong, paramViewHolder);
  }
  
  void addToPostLayout(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo)
  {
    ViewInfoStore.InfoRecord localInfoRecord2 = (ViewInfoStore.InfoRecord)this.mLayoutHolderMap.get(paramViewHolder);
    ViewInfoStore.InfoRecord localInfoRecord1 = localInfoRecord2;
    if (localInfoRecord2 == null)
    {
      localInfoRecord1 = ViewInfoStore.InfoRecord.obtain();
      this.mLayoutHolderMap.put(paramViewHolder, localInfoRecord1);
    }
    localInfoRecord1.postInfo = paramItemHolderInfo;
    localInfoRecord1.flags |= 0x8;
  }
  
  void addToPreLayout(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo)
  {
    ViewInfoStore.InfoRecord localInfoRecord2 = (ViewInfoStore.InfoRecord)this.mLayoutHolderMap.get(paramViewHolder);
    ViewInfoStore.InfoRecord localInfoRecord1 = localInfoRecord2;
    if (localInfoRecord2 == null)
    {
      localInfoRecord1 = ViewInfoStore.InfoRecord.obtain();
      this.mLayoutHolderMap.put(paramViewHolder, localInfoRecord1);
    }
    localInfoRecord1.preInfo = paramItemHolderInfo;
    localInfoRecord1.flags |= 0x4;
  }
  
  void clear()
  {
    this.mLayoutHolderMap.clear();
    this.mOldChangedHolders.clear();
  }
  
  RecyclerView.ViewHolder getFromOldChangeHolders(long paramLong)
  {
    return (RecyclerView.ViewHolder)this.mOldChangedHolders.get(paramLong);
  }
  
  boolean isDisappearing(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (ViewInfoStore.InfoRecord)this.mLayoutHolderMap.get(paramViewHolder);
    return (paramViewHolder != null) && ((paramViewHolder.flags & 0x1) != 0);
  }
  
  boolean isInPreLayout(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (ViewInfoStore.InfoRecord)this.mLayoutHolderMap.get(paramViewHolder);
    return (paramViewHolder != null) && ((paramViewHolder.flags & 0x4) != 0);
  }
  
  void onDetach() {}
  
  public void onViewDetached(RecyclerView.ViewHolder paramViewHolder)
  {
    removeFromDisappearedInLayout(paramViewHolder);
  }
  
  @Nullable
  RecyclerView.ItemAnimator.ItemHolderInfo popFromPostLayout(RecyclerView.ViewHolder paramViewHolder)
  {
    return popFromLayoutStep(paramViewHolder, 8);
  }
  
  @Nullable
  RecyclerView.ItemAnimator.ItemHolderInfo popFromPreLayout(RecyclerView.ViewHolder paramViewHolder)
  {
    return popFromLayoutStep(paramViewHolder, 4);
  }
  
  void process(ViewInfoStore.ProcessCallback paramProcessCallback)
  {
    int i = this.mLayoutHolderMap.size() - 1;
    while (i >= 0)
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)this.mLayoutHolderMap.keyAt(i);
      ViewInfoStore.InfoRecord localInfoRecord = (ViewInfoStore.InfoRecord)this.mLayoutHolderMap.removeAt(i);
      if ((localInfoRecord.flags & 0x3) == 3) {
        paramProcessCallback.unused(localViewHolder);
      } else if ((localInfoRecord.flags & 0x1) != 0) {
        paramProcessCallback.processDisappeared(localViewHolder, localInfoRecord.preInfo, localInfoRecord.postInfo);
      } else if ((localInfoRecord.flags & 0xE) == 14) {
        paramProcessCallback.processAppeared(localViewHolder, localInfoRecord.preInfo, localInfoRecord.postInfo);
      } else if ((localInfoRecord.flags & 0xC) == 12) {
        paramProcessCallback.processPersistent(localViewHolder, localInfoRecord.preInfo, localInfoRecord.postInfo);
      } else if ((localInfoRecord.flags & 0x4) != 0) {
        paramProcessCallback.processDisappeared(localViewHolder, localInfoRecord.preInfo, null);
      } else if ((localInfoRecord.flags & 0x8) != 0) {
        paramProcessCallback.processAppeared(localViewHolder, localInfoRecord.preInfo, localInfoRecord.postInfo);
      } else {
        int j = localInfoRecord.flags;
      }
      ViewInfoStore.InfoRecord.recycle(localInfoRecord);
      i -= 1;
    }
  }
  
  void removeFromDisappearedInLayout(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (ViewInfoStore.InfoRecord)this.mLayoutHolderMap.get(paramViewHolder);
    if (paramViewHolder == null) {
      return;
    }
    paramViewHolder.flags &= 0xFFFFFFFE;
  }
  
  void removeViewHolder(RecyclerView.ViewHolder paramViewHolder)
  {
    int i = this.mOldChangedHolders.size() - 1;
    while (i >= 0)
    {
      if (paramViewHolder == this.mOldChangedHolders.valueAt(i))
      {
        this.mOldChangedHolders.removeAt(i);
        break;
      }
      i -= 1;
    }
    paramViewHolder = (ViewInfoStore.InfoRecord)this.mLayoutHolderMap.remove(paramViewHolder);
    if (paramViewHolder != null) {
      ViewInfoStore.InfoRecord.recycle(paramViewHolder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.ViewInfoStore
 * JD-Core Version:    0.7.0.1
 */