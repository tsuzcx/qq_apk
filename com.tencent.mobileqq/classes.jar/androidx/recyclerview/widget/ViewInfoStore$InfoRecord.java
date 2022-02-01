package androidx.recyclerview.widget;

import androidx.annotation.Nullable;
import androidx.core.util.Pools.Pool;
import androidx.core.util.Pools.SimplePool;

class ViewInfoStore$InfoRecord
{
  static final int FLAG_APPEAR = 2;
  static final int FLAG_APPEAR_AND_DISAPPEAR = 3;
  static final int FLAG_APPEAR_PRE_AND_POST = 14;
  static final int FLAG_DISAPPEARED = 1;
  static final int FLAG_POST = 8;
  static final int FLAG_PRE = 4;
  static final int FLAG_PRE_AND_POST = 12;
  static Pools.Pool<InfoRecord> sPool = new Pools.SimplePool(20);
  int flags;
  @Nullable
  RecyclerView.ItemAnimator.ItemHolderInfo postInfo;
  @Nullable
  RecyclerView.ItemAnimator.ItemHolderInfo preInfo;
  
  static void drainCache()
  {
    while (sPool.acquire() != null) {}
  }
  
  static InfoRecord obtain()
  {
    InfoRecord localInfoRecord2 = (InfoRecord)sPool.acquire();
    InfoRecord localInfoRecord1 = localInfoRecord2;
    if (localInfoRecord2 == null) {
      localInfoRecord1 = new InfoRecord();
    }
    return localInfoRecord1;
  }
  
  static void recycle(InfoRecord paramInfoRecord)
  {
    paramInfoRecord.flags = 0;
    paramInfoRecord.preInfo = null;
    paramInfoRecord.postInfo = null;
    sPool.release(paramInfoRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.recyclerview.widget.ViewInfoStore.InfoRecord
 * JD-Core Version:    0.7.0.1
 */