package androidx.recyclerview.widget;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;

class ViewInfoStore
{
  private static final boolean DEBUG = false;
  @VisibleForTesting
  final SimpleArrayMap<RecyclerView.ViewHolder, ViewInfoStore.InfoRecord> mLayoutHolderMap = new SimpleArrayMap();
  @VisibleForTesting
  final LongSparseArray<RecyclerView.ViewHolder> mOldChangedHolders = new LongSparseArray();
  
  private RecyclerView.ItemAnimator.ItemHolderInfo popFromLayoutStep(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject2 = null;
    int i = this.mLayoutHolderMap.indexOfKey(paramViewHolder);
    Object localObject1;
    if (i < 0) {
      localObject1 = localObject2;
    }
    ViewInfoStore.InfoRecord localInfoRecord;
    do
    {
      do
      {
        return localObject1;
        localInfoRecord = (ViewInfoStore.InfoRecord)this.mLayoutHolderMap.valueAt(i);
        localObject1 = localObject2;
      } while (localInfoRecord == null);
      localObject1 = localObject2;
    } while ((localInfoRecord.flags & paramInt) == 0);
    localInfoRecord.flags &= (paramInt ^ 0xFFFFFFFF);
    if (paramInt == 4) {}
    for (paramViewHolder = localInfoRecord.preInfo;; paramViewHolder = localInfoRecord.postInfo)
    {
      localObject1 = paramViewHolder;
      if ((localInfoRecord.flags & 0xC) != 0) {
        break;
      }
      this.mLayoutHolderMap.removeAt(i);
      ViewInfoStore.InfoRecord.recycle(localInfoRecord);
      return paramViewHolder;
      if (paramInt != 8) {
        break label129;
      }
    }
    label129:
    throw new IllegalArgumentException("Must provide flag PRE or POST");
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
    if (i >= 0)
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)this.mLayoutHolderMap.keyAt(i);
      ViewInfoStore.InfoRecord localInfoRecord = (ViewInfoStore.InfoRecord)this.mLayoutHolderMap.removeAt(i);
      if ((localInfoRecord.flags & 0x3) == 3) {
        paramProcessCallback.unused(localViewHolder);
      }
      for (;;)
      {
        ViewInfoStore.InfoRecord.recycle(localInfoRecord);
        i -= 1;
        break;
        if ((localInfoRecord.flags & 0x1) != 0)
        {
          if (localInfoRecord.preInfo == null) {
            paramProcessCallback.unused(localViewHolder);
          } else {
            paramProcessCallback.processDisappeared(localViewHolder, localInfoRecord.preInfo, localInfoRecord.postInfo);
          }
        }
        else if ((localInfoRecord.flags & 0xE) == 14) {
          paramProcessCallback.processAppeared(localViewHolder, localInfoRecord.preInfo, localInfoRecord.postInfo);
        } else if ((localInfoRecord.flags & 0xC) == 12) {
          paramProcessCallback.processPersistent(localViewHolder, localInfoRecord.preInfo, localInfoRecord.postInfo);
        } else if ((localInfoRecord.flags & 0x4) != 0) {
          paramProcessCallback.processDisappeared(localViewHolder, localInfoRecord.preInfo, null);
        } else if ((localInfoRecord.flags & 0x8) != 0) {
          paramProcessCallback.processAppeared(localViewHolder, localInfoRecord.preInfo, localInfoRecord.postInfo);
        } else if ((localInfoRecord.flags & 0x2) == 0) {}
      }
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
    for (;;)
    {
      if (i >= 0)
      {
        if (paramViewHolder == this.mOldChangedHolders.valueAt(i)) {
          this.mOldChangedHolders.removeAt(i);
        }
      }
      else
      {
        paramViewHolder = (ViewInfoStore.InfoRecord)this.mLayoutHolderMap.remove(paramViewHolder);
        if (paramViewHolder != null) {
          ViewInfoStore.InfoRecord.recycle(paramViewHolder);
        }
        return;
      }
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.ViewInfoStore
 * JD-Core Version:    0.7.0.1
 */