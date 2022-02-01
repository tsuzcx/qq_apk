package androidx.recyclerview.widget;

import android.util.SparseArray;
import android.view.View;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.uimanager.RenderManager;
import com.tencent.mtt.hippy.uimanager.RenderNode;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerViewHolder;
import com.tencent.mtt.hippy.views.hippylist.NodePositionHelper;
import java.util.ArrayList;
import java.util.Iterator;

public class HippyRecyclerPool
  extends RecyclerView.RecycledViewPool
{
  private final View a;
  private final HippyRecyclerExtension b;
  private final HippyEngineContext c;
  private final NodePositionHelper d;
  private IHippyViewAboundListener e;
  
  public HippyRecyclerPool(HippyEngineContext paramHippyEngineContext, View paramView, HippyRecyclerExtension paramHippyRecyclerExtension, NodePositionHelper paramNodePositionHelper)
  {
    this.d = paramNodePositionHelper;
    this.c = paramHippyEngineContext;
    this.a = paramView;
    this.b = paramHippyRecyclerExtension;
  }
  
  private void a(RecyclerView.ViewHolder paramViewHolder)
  {
    int i = paramViewHolder.getItemViewType();
    RecyclerView.RecycledViewPool.ScrapData localScrapData = (RecyclerView.RecycledViewPool.ScrapData)this.mScrap.get(i);
    if ((localScrapData != null) && (localScrapData.mScrapHeap.size() >= localScrapData.mMaxScrap)) {
      this.e.onViewAbound((HippyRecyclerViewHolder)paramViewHolder);
    }
  }
  
  private boolean a(HippyRecyclerViewHolder paramHippyRecyclerViewHolder)
  {
    if (paramHippyRecyclerViewHolder.bindNode == null) {
      return false;
    }
    RenderNode localRenderNode = this.c.getRenderManager().getRenderNode(this.a.getId()).getChildAt(this.d.getRenderNodePosition(this.b.getCurrentPosition()));
    return paramHippyRecyclerViewHolder.bindNode.equals(localRenderNode);
  }
  
  public RecyclerView.ViewHolder getRecycledView(int paramInt)
  {
    Object localObject = (RecyclerView.RecycledViewPool.ScrapData)this.mScrap.get(paramInt);
    if (localObject == null) {
      return null;
    }
    Iterator localIterator = ((RecyclerView.RecycledViewPool.ScrapData)localObject).mScrapHeap.iterator();
    while (localIterator.hasNext())
    {
      localViewHolder = (RecyclerView.ViewHolder)localIterator.next();
      if (a((HippyRecyclerViewHolder)localViewHolder))
      {
        ((RecyclerView.RecycledViewPool.ScrapData)localObject).mScrapHeap.remove(localViewHolder);
        break label73;
      }
    }
    RecyclerView.ViewHolder localViewHolder = null;
    label73:
    localObject = localViewHolder;
    if (localViewHolder == null) {
      localObject = super.getRecycledView(paramInt);
    }
    if (((localObject instanceof HippyRecyclerViewHolder)) && (((HippyRecyclerViewHolder)localObject).isRenderDeleted())) {
      return null;
    }
    return localObject;
  }
  
  public void putRecycledView(RecyclerView.ViewHolder paramViewHolder)
  {
    a(paramViewHolder);
    super.putRecycledView(paramViewHolder);
  }
  
  public void setViewAboundListener(IHippyViewAboundListener paramIHippyViewAboundListener)
  {
    this.e = paramIHippyViewAboundListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.HippyRecyclerPool
 * JD-Core Version:    0.7.0.1
 */