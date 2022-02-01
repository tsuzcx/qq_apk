package com.tencent.biz.pubaccount.weishi_new.drama;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.baseui.IWSItemView;
import com.tencent.biz.pubaccount.weishi_new.drama.cache.WSDramaDataManager;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaItemData;
import com.tencent.biz.pubaccount.weishi_new.drama.holder.AbsWSDramaHolder;
import com.tencent.biz.pubaccount.weishi_new.drama.holder.AbsWSDramaVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.drama.holder.WSDramaHolderFactory;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerManager;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.widget.pull2refresh.BaseAdapter;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.List;

public class WSDramaPageAdapter
  extends BaseAdapter<WSDramaItemData, BaseViewHolder<WSDramaItemData>>
{
  private boolean a;
  private final WSDramaPageFragment b;
  private WSPlayerManager c;
  private AbsWSDramaVideoHolder d;
  
  public WSDramaPageAdapter(Context paramContext, WSDramaPageFragment paramWSDramaPageFragment)
  {
    super(paramContext);
    this.b = paramWSDramaPageFragment;
  }
  
  public WSPlayerManager a()
  {
    return this.c;
  }
  
  public void a(AbsWSDramaVideoHolder paramAbsWSDramaVideoHolder)
  {
    this.d = paramAbsWSDramaVideoHolder;
    this.c.b(this.d.e(), false);
    WSDramaDataManager.a().a(paramAbsWSDramaVideoHolder.e());
    WSDramaDataManager.a().a(this.d.c);
  }
  
  public void a(WSPlayerManager paramWSPlayerManager)
  {
    this.c = paramWSPlayerManager;
    WSDramaPlayerStatusListenerImpl localWSDramaPlayerStatusListenerImpl = new WSDramaPlayerStatusListenerImpl();
    localWSDramaPlayerStatusListenerImpl.a(this.b);
    paramWSPlayerManager.a(localWSDramaPlayerStatusListenerImpl);
  }
  
  public void a(BaseViewHolder<WSDramaItemData> paramBaseViewHolder, int paramInt)
  {
    if ((paramBaseViewHolder instanceof AbsWSDramaHolder)) {
      ((AbsWSDramaHolder)paramBaseViewHolder).b(paramInt);
    }
    if ((paramBaseViewHolder instanceof AbsWSDramaVideoHolder)) {
      b((AbsWSDramaVideoHolder)paramBaseViewHolder);
    }
  }
  
  public void a(List<WSDramaItemData> paramList)
  {
    List localList = getDataList();
    if ((localList != null) && (localList.addAll(paramList))) {
      notifyItemRangeChanged(localList.size() - paramList.size(), paramList.size());
    }
  }
  
  public void b()
  {
    this.c.n();
  }
  
  public void b(AbsWSDramaVideoHolder paramAbsWSDramaVideoHolder)
  {
    b();
    a(paramAbsWSDramaVideoHolder);
  }
  
  public AbsWSDramaVideoHolder c()
  {
    return this.d;
  }
  
  public void c(AbsWSDramaVideoHolder paramAbsWSDramaVideoHolder)
  {
    this.d = paramAbsWSDramaVideoHolder;
  }
  
  public int getCustomItemViewType(int paramInt)
  {
    return 0;
  }
  
  public void onBindCustomViewHolder(BaseViewHolder<WSDramaItemData> paramBaseViewHolder, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[WSDramaPageAdapter.java][onBindCustomViewHolder] position:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", holder:");
    ((StringBuilder)localObject).append(paramBaseViewHolder);
    WSLog.e("WSDramaPageAdapterLog", ((StringBuilder)localObject).toString());
    localObject = (WSDramaItemData)getItem(paramInt);
    if (localObject == null) {
      return;
    }
    paramBaseViewHolder.bindData(localObject);
    if ((!this.a) && (paramInt == 0))
    {
      this.a = true;
      this.b.a(paramBaseViewHolder);
    }
  }
  
  public BaseViewHolder<WSDramaItemData> onCreateCustomViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return WSDramaHolderFactory.a(paramViewGroup, paramInt, this.b);
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    int j = paramRecyclerView.getChildCount();
    int i = 0;
    while (i < j)
    {
      AbsWSDramaHolder localAbsWSDramaHolder = (AbsWSDramaHolder)paramRecyclerView.getChildViewHolder(paramRecyclerView.getChildAt(i));
      if (localAbsWSDramaHolder != null) {
        localAbsWSDramaHolder.b.a();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageAdapter
 * JD-Core Version:    0.7.0.1
 */