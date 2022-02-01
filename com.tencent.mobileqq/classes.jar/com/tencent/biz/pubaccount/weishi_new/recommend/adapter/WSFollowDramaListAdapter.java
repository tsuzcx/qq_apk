package com.tencent.biz.pubaccount.weishi_new.recommend.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSFollowDramaItemData;
import com.tencent.biz.pubaccount.weishi_new.recommend.holder.WSFollowDramaItemHolder;
import com.tencent.widget.pull2refresh.BaseAdapter;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import java.util.List;

public class WSFollowDramaListAdapter
  extends BaseAdapter<WSFollowDramaItemData, WSFollowDramaItemHolder>
{
  private WSFollowDramaListAdapter.ItemViewExposedListener a;
  
  public WSFollowDramaListAdapter(Context paramContext)
  {
    super(paramContext);
  }
  
  public WSFollowDramaItemHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new WSFollowDramaItemHolder(LayoutInflater.from(this.context).inflate(2131560003, paramViewGroup, false));
  }
  
  public void a(@Nullable WSFollowDramaListAdapter.ItemViewExposedListener paramItemViewExposedListener)
  {
    this.a = paramItemViewExposedListener;
  }
  
  public void a(WSFollowDramaItemHolder paramWSFollowDramaItemHolder, int paramInt)
  {
    paramWSFollowDramaItemHolder.a((WSFollowDramaItemData)getDataList().get(paramInt));
  }
  
  public void a(BaseViewHolder<WSFollowDramaItemData> paramBaseViewHolder)
  {
    super.onViewAttachedToWindow(paramBaseViewHolder);
    WSFollowDramaListAdapter.ItemViewExposedListener localItemViewExposedListener = this.a;
    if (localItemViewExposedListener != null) {
      localItemViewExposedListener.a(paramBaseViewHolder);
    }
  }
  
  public int getCustomItemViewType(int paramInt)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.adapter.WSFollowDramaListAdapter
 * JD-Core Version:    0.7.0.1
 */