package androidx.recyclerview.widget;

import android.util.SparseArray;
import com.tencent.mtt.hippy.uimanager.ListItemRenderNode;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerViewHolder;
import java.util.ArrayList;
import java.util.Iterator;

public class HippyItemTypeHelper
{
  HippyRecyclerViewBase a;
  private RecyclerView.Recycler b;
  
  public HippyItemTypeHelper(HippyRecyclerViewBase paramHippyRecyclerViewBase)
  {
    this.a = paramHippyRecyclerViewBase;
    this.b = paramHippyRecyclerViewBase.mRecycler;
  }
  
  private void a(int paramInt1, int paramInt2, ListItemRenderNode paramListItemRenderNode)
  {
    if (this.b.getRecycledViewPool() != null)
    {
      RecyclerView.RecycledViewPool.ScrapData localScrapData = (RecyclerView.RecycledViewPool.ScrapData)this.b.getRecycledViewPool().mScrap.get(paramInt1);
      if ((localScrapData != null) && (!localScrapData.mScrapHeap.isEmpty()))
      {
        Iterator localIterator = localScrapData.mScrapHeap.iterator();
        while (localIterator.hasNext())
        {
          RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)localIterator.next();
          if (a(paramInt1, paramInt2, paramListItemRenderNode, localViewHolder))
          {
            localScrapData.mScrapHeap.remove(localViewHolder);
            a(paramInt2, localViewHolder);
          }
        }
      }
    }
  }
  
  private void a(int paramInt, RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder.mItemViewType = paramInt;
    SparseArray localSparseArray = this.b.getRecycledViewPool().mScrap;
    RecyclerView.RecycledViewPool.ScrapData localScrapData2 = (RecyclerView.RecycledViewPool.ScrapData)localSparseArray.get(paramInt);
    RecyclerView.RecycledViewPool.ScrapData localScrapData1 = localScrapData2;
    if (localScrapData2 == null)
    {
      localScrapData1 = new RecyclerView.RecycledViewPool.ScrapData();
      localSparseArray.append(paramInt, localScrapData1);
    }
    localScrapData1.mScrapHeap.add(paramViewHolder);
  }
  
  private boolean a(int paramInt1, int paramInt2, ListItemRenderNode paramListItemRenderNode, RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder.getItemViewType() == paramInt1) && ((paramViewHolder instanceof HippyRecyclerViewHolder)) && (((HippyRecyclerViewHolder)paramViewHolder).bindNode == paramListItemRenderNode))
    {
      paramViewHolder.mItemViewType = paramInt2;
      return true;
    }
    return false;
  }
  
  private boolean a(int paramInt1, int paramInt2, ListItemRenderNode paramListItemRenderNode, ArrayList<RecyclerView.ViewHolder> paramArrayList)
  {
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      if (a(paramInt1, paramInt2, paramListItemRenderNode, (RecyclerView.ViewHolder)paramArrayList.get(i))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void updateItemType(int paramInt1, int paramInt2, ListItemRenderNode paramListItemRenderNode)
  {
    int j = this.a.getChildCount();
    int i = 0;
    while (i < j)
    {
      HippyRecyclerViewBase localHippyRecyclerViewBase = this.a;
      if (a(paramInt1, paramInt2, paramListItemRenderNode, localHippyRecyclerViewBase.getChildViewHolder(localHippyRecyclerViewBase.getChildAt(i)))) {
        return;
      }
      i += 1;
    }
    if (a(paramInt1, paramInt2, paramListItemRenderNode, this.b.mAttachedScrap)) {
      return;
    }
    if (a(paramInt1, paramInt2, paramListItemRenderNode, this.a.mRecycler.mCachedViews)) {
      return;
    }
    a(paramInt1, paramInt2, paramListItemRenderNode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.HippyItemTypeHelper
 * JD-Core Version:    0.7.0.1
 */