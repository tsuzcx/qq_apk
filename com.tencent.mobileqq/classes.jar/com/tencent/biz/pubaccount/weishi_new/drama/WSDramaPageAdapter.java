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
  private final WSDramaPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaPageFragment;
  private AbsWSDramaVideoHolder jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHolderAbsWSDramaVideoHolder;
  private WSPlayerManager jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  private boolean jdField_a_of_type_Boolean;
  
  public WSDramaPageAdapter(Context paramContext, WSDramaPageFragment paramWSDramaPageFragment)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaPageFragment = paramWSDramaPageFragment;
  }
  
  public AbsWSDramaVideoHolder a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHolderAbsWSDramaVideoHolder;
  }
  
  public WSPlayerManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.d();
  }
  
  public void a(AbsWSDramaVideoHolder paramAbsWSDramaVideoHolder)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHolderAbsWSDramaVideoHolder = paramAbsWSDramaVideoHolder;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHolderAbsWSDramaVideoHolder.a(), false);
    WSDramaDataManager.a().a(paramAbsWSDramaVideoHolder.a());
    WSDramaDataManager.a().a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHolderAbsWSDramaVideoHolder.a);
  }
  
  public void a(WSPlayerManager paramWSPlayerManager)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerManager = paramWSPlayerManager;
    WSDramaPlayerStatusListenerImpl localWSDramaPlayerStatusListenerImpl = new WSDramaPlayerStatusListenerImpl();
    localWSDramaPlayerStatusListenerImpl.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaPageFragment);
    paramWSPlayerManager.a(localWSDramaPlayerStatusListenerImpl);
  }
  
  public void a(BaseViewHolder<WSDramaItemData> paramBaseViewHolder, int paramInt)
  {
    if ((paramBaseViewHolder instanceof AbsWSDramaHolder)) {
      ((AbsWSDramaHolder)paramBaseViewHolder).a(paramInt);
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
  
  public void b(AbsWSDramaVideoHolder paramAbsWSDramaVideoHolder)
  {
    a();
    a(paramAbsWSDramaVideoHolder);
  }
  
  public void c(AbsWSDramaVideoHolder paramAbsWSDramaVideoHolder)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaHolderAbsWSDramaVideoHolder = paramAbsWSDramaVideoHolder;
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
    if ((!this.jdField_a_of_type_Boolean) && (paramInt == 0))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaPageFragment.a(paramBaseViewHolder);
    }
  }
  
  public BaseViewHolder<WSDramaItemData> onCreateCustomViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    return WSDramaHolderFactory.a(paramViewGroup, paramInt, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDramaWSDramaPageFragment);
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
        localAbsWSDramaHolder.a.a();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.WSDramaPageAdapter
 * JD-Core Version:    0.7.0.1
 */