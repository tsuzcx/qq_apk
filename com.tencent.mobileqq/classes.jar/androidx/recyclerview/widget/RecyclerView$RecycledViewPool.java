package androidx.recyclerview.widget;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class RecyclerView$RecycledViewPool
{
  private static final int DEFAULT_MAX_SCRAP = 5;
  private int mAttachCount = 0;
  SparseArray<RecyclerView.RecycledViewPool.ScrapData> mScrap = new SparseArray();
  
  private RecyclerView.RecycledViewPool.ScrapData getScrapDataForType(int paramInt)
  {
    RecyclerView.RecycledViewPool.ScrapData localScrapData2 = (RecyclerView.RecycledViewPool.ScrapData)this.mScrap.get(paramInt);
    RecyclerView.RecycledViewPool.ScrapData localScrapData1 = localScrapData2;
    if (localScrapData2 == null)
    {
      localScrapData1 = new RecyclerView.RecycledViewPool.ScrapData();
      this.mScrap.put(paramInt, localScrapData1);
    }
    return localScrapData1;
  }
  
  void attach()
  {
    this.mAttachCount += 1;
  }
  
  public void clear()
  {
    int i = 0;
    while (i < this.mScrap.size())
    {
      ((RecyclerView.RecycledViewPool.ScrapData)this.mScrap.valueAt(i)).mScrapHeap.clear();
      i += 1;
    }
  }
  
  void detach()
  {
    this.mAttachCount -= 1;
  }
  
  void factorInBindTime(int paramInt, long paramLong)
  {
    RecyclerView.RecycledViewPool.ScrapData localScrapData = getScrapDataForType(paramInt);
    localScrapData.mBindRunningAverageNs = runningAverage(localScrapData.mBindRunningAverageNs, paramLong);
  }
  
  void factorInCreateTime(int paramInt, long paramLong)
  {
    RecyclerView.RecycledViewPool.ScrapData localScrapData = getScrapDataForType(paramInt);
    localScrapData.mCreateRunningAverageNs = runningAverage(localScrapData.mCreateRunningAverageNs, paramLong);
  }
  
  @Nullable
  public RecyclerView.ViewHolder getRecycledView(int paramInt)
  {
    Object localObject = (RecyclerView.RecycledViewPool.ScrapData)this.mScrap.get(paramInt);
    if ((localObject != null) && (!((RecyclerView.RecycledViewPool.ScrapData)localObject).mScrapHeap.isEmpty()))
    {
      localObject = ((RecyclerView.RecycledViewPool.ScrapData)localObject).mScrapHeap;
      paramInt = ((ArrayList)localObject).size() - 1;
      while (paramInt >= 0)
      {
        if (!((RecyclerView.ViewHolder)((ArrayList)localObject).get(paramInt)).isAttachedToTransitionOverlay()) {
          return (RecyclerView.ViewHolder)((ArrayList)localObject).remove(paramInt);
        }
        paramInt -= 1;
      }
    }
    return null;
  }
  
  public int getRecycledViewCount(int paramInt)
  {
    return getScrapDataForType(paramInt).mScrapHeap.size();
  }
  
  void onAdapterChanged(RecyclerView.Adapter paramAdapter1, RecyclerView.Adapter paramAdapter2, boolean paramBoolean)
  {
    if (paramAdapter1 != null) {
      detach();
    }
    if ((!paramBoolean) && (this.mAttachCount == 0)) {
      clear();
    }
    if (paramAdapter2 != null) {
      attach();
    }
  }
  
  public void putRecycledView(RecyclerView.ViewHolder paramViewHolder)
  {
    int i = paramViewHolder.getItemViewType();
    ArrayList localArrayList = getScrapDataForType(i).mScrapHeap;
    if (((RecyclerView.RecycledViewPool.ScrapData)this.mScrap.get(i)).mMaxScrap <= localArrayList.size()) {
      return;
    }
    paramViewHolder.resetInternal();
    localArrayList.add(paramViewHolder);
  }
  
  long runningAverage(long paramLong1, long paramLong2)
  {
    if (paramLong1 == 0L) {
      return paramLong2;
    }
    return paramLong1 / 4L * 3L + paramLong2 / 4L;
  }
  
  public void setMaxRecycledViews(int paramInt1, int paramInt2)
  {
    Object localObject = getScrapDataForType(paramInt1);
    ((RecyclerView.RecycledViewPool.ScrapData)localObject).mMaxScrap = paramInt2;
    localObject = ((RecyclerView.RecycledViewPool.ScrapData)localObject).mScrapHeap;
    while (((ArrayList)localObject).size() > paramInt2) {
      ((ArrayList)localObject).remove(((ArrayList)localObject).size() - 1);
    }
  }
  
  int size()
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.mScrap.size(); j = k)
    {
      ArrayList localArrayList = ((RecyclerView.RecycledViewPool.ScrapData)this.mScrap.valueAt(i)).mScrapHeap;
      k = j;
      if (localArrayList != null) {
        k = j + localArrayList.size();
      }
      i += 1;
    }
    return j;
  }
  
  boolean willBindInTime(int paramInt, long paramLong1, long paramLong2)
  {
    long l = getScrapDataForType(paramInt).mBindRunningAverageNs;
    return (l == 0L) || (l + paramLong1 < paramLong2);
  }
  
  boolean willCreateInTime(int paramInt, long paramLong1, long paramLong2)
  {
    long l = getScrapDataForType(paramInt).mCreateRunningAverageNs;
    return (l == 0L) || (l + paramLong1 < paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.RecyclerView.RecycledViewPool
 * JD-Core Version:    0.7.0.1
 */