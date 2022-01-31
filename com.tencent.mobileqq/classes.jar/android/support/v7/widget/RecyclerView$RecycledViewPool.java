package android.support.v7.widget;

import android.util.SparseArray;
import android.util.SparseIntArray;
import java.util.ArrayList;

public class RecyclerView$RecycledViewPool
{
  private static final int DEFAULT_MAX_SCRAP = 5;
  private int mAttachCount = 0;
  private SparseIntArray mMaxScrap = new SparseIntArray();
  private SparseArray<ArrayList<RecyclerView.ViewHolder>> mScrap = new SparseArray();
  
  private ArrayList<RecyclerView.ViewHolder> getScrapHeapForType(int paramInt)
  {
    ArrayList localArrayList2 = (ArrayList)this.mScrap.get(paramInt);
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList2 = new ArrayList();
      this.mScrap.put(paramInt, localArrayList2);
      localArrayList1 = localArrayList2;
      if (this.mMaxScrap.indexOfKey(paramInt) < 0)
      {
        this.mMaxScrap.put(paramInt, 5);
        localArrayList1 = localArrayList2;
      }
    }
    return localArrayList1;
  }
  
  void attach(RecyclerView.Adapter paramAdapter)
  {
    this.mAttachCount += 1;
  }
  
  public void clear()
  {
    this.mScrap.clear();
  }
  
  void detach()
  {
    this.mAttachCount -= 1;
  }
  
  public RecyclerView.ViewHolder getRecycledView(int paramInt)
  {
    ArrayList localArrayList = (ArrayList)this.mScrap.get(paramInt);
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      paramInt = localArrayList.size() - 1;
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)localArrayList.get(paramInt);
      localArrayList.remove(paramInt);
      return localViewHolder;
    }
    return null;
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
      attach(paramAdapter2);
    }
  }
  
  public void putRecycledView(RecyclerView.ViewHolder paramViewHolder)
  {
    int i = paramViewHolder.getItemViewType();
    ArrayList localArrayList = getScrapHeapForType(i);
    if (this.mMaxScrap.get(i) <= localArrayList.size()) {
      return;
    }
    paramViewHolder.resetInternal();
    localArrayList.add(paramViewHolder);
  }
  
  public void setMaxRecycledViews(int paramInt1, int paramInt2)
  {
    this.mMaxScrap.put(paramInt1, paramInt2);
    ArrayList localArrayList = (ArrayList)this.mScrap.get(paramInt1);
    if (localArrayList != null) {
      while (localArrayList.size() > paramInt2) {
        localArrayList.remove(localArrayList.size() - 1);
      }
    }
  }
  
  int size()
  {
    int i = 0;
    int k;
    for (int j = 0; i < this.mScrap.size(); j = k)
    {
      ArrayList localArrayList = (ArrayList)this.mScrap.valueAt(i);
      k = j;
      if (localArrayList != null) {
        k = j + localArrayList.size();
      }
      i += 1;
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.RecycledViewPool
 * JD-Core Version:    0.7.0.1
 */