package androidx.recyclerview.widget;

import android.view.View;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.uimanager.ListItemRenderNode;
import com.tencent.mtt.hippy.uimanager.RenderManager;
import com.tencent.mtt.hippy.uimanager.RenderNode;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerViewHolder;
import com.tencent.mtt.hippy.views.hippylist.NodePositionHelper;
import java.util.ArrayList;

public class HippyRecyclerExtension
  extends RecyclerView.ViewCacheExtension
{
  private final HippyEngineContext a;
  private final NodePositionHelper b;
  private HippyRecyclerViewBase c;
  private int d;
  
  public HippyRecyclerExtension(HippyRecyclerViewBase paramHippyRecyclerViewBase, HippyEngineContext paramHippyEngineContext, NodePositionHelper paramNodePositionHelper)
  {
    this.b = paramNodePositionHelper;
    this.c = paramHippyRecyclerViewBase;
    this.a = paramHippyEngineContext;
  }
  
  private View a(RecyclerView.Recycler paramRecycler, int paramInt1, int paramInt2)
  {
    RecyclerView.ViewHolder localViewHolder = a(paramRecycler.mCachedViews, paramInt1, paramInt2);
    if (localViewHolder != null)
    {
      paramRecycler.mCachedViews.remove(localViewHolder);
      return localViewHolder.itemView;
    }
    return null;
  }
  
  private RecyclerView.ViewHolder a(ArrayList<RecyclerView.ViewHolder> paramArrayList, int paramInt1, int paramInt2)
  {
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)paramArrayList.get(i);
      if (isTheBestHolder(paramInt1, paramInt2, localViewHolder)) {
        return localViewHolder;
      }
      i += 1;
    }
    return null;
  }
  
  public static boolean isNodeEquals(ListItemRenderNode paramListItemRenderNode1, ListItemRenderNode paramListItemRenderNode2)
  {
    if ((paramListItemRenderNode1 != null) && (paramListItemRenderNode2 != null)) {
      return paramListItemRenderNode1.equals(paramListItemRenderNode2);
    }
    return false;
  }
  
  protected View findInAttachedScrap(RecyclerView.Recycler paramRecycler, int paramInt1, int paramInt2)
  {
    paramRecycler = a(paramRecycler.mAttachedScrap, paramInt1, paramInt2);
    if (paramRecycler != null)
    {
      paramRecycler.unScrap();
      return paramRecycler.itemView;
    }
    return null;
  }
  
  public int getCurrentPosition()
  {
    return this.d;
  }
  
  public View getViewForPositionAndType(RecyclerView.Recycler paramRecycler, int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    View localView2 = findInAttachedScrap(paramRecycler, paramInt1, paramInt2);
    View localView1 = localView2;
    if (localView2 == null) {
      localView1 = a(paramRecycler, paramInt1, paramInt2);
    }
    return localView1;
  }
  
  protected boolean isTheBestHolder(int paramInt1, int paramInt2, RecyclerView.ViewHolder paramViewHolder)
  {
    if ((paramViewHolder.getAdapterPosition() == paramInt1) && (!paramViewHolder.isInvalid()))
    {
      if (paramViewHolder.isRemoved()) {
        return false;
      }
      if ((paramViewHolder.getItemViewType() == paramInt2) && ((paramViewHolder instanceof HippyRecyclerViewHolder)))
      {
        RenderNode localRenderNode = this.a.getRenderManager().getRenderNode(this.c.getId()).getChildAt(this.b.getRenderNodePosition(paramInt1));
        return isNodeEquals(((HippyRecyclerViewHolder)paramViewHolder).bindNode, (ListItemRenderNode)localRenderNode);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.HippyRecyclerExtension
 * JD-Core Version:    0.7.0.1
 */