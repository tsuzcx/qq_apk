package com.tencent.biz.subscribe.bizdapters;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.biz.subscribe.beans.SubscribeDraftBean;
import com.tencent.biz.subscribe.widget.relativevideo.SubScribeDraftItemView;

class SubscribeDraftAdapter$DraftVH
  extends RecyclerView.ViewHolder
{
  public SubscribeDraftAdapter$DraftVH(SubscribeDraftAdapter paramSubscribeDraftAdapter, View paramView)
  {
    super(paramView);
  }
  
  public void a(SubscribeDraftBean paramSubscribeDraftBean)
  {
    if ((this.itemView instanceof SubScribeDraftItemView)) {
      ((SubScribeDraftItemView)this.itemView).setData(paramSubscribeDraftBean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.SubscribeDraftAdapter.DraftVH
 * JD-Core Version:    0.7.0.1
 */