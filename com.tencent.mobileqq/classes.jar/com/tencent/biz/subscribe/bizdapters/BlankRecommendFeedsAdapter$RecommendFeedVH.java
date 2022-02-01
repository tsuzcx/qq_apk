package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFollowRcmd;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.biz.subscribe.widget.relativevideo.BlankRecommendItemView;

class BlankRecommendFeedsAdapter$RecommendFeedVH
  extends RecyclerView.ViewHolder
{
  public BlankRecommendFeedsAdapter$RecommendFeedVH(BlankRecommendFeedsAdapter paramBlankRecommendFeedsAdapter, View paramView)
  {
    super(paramView);
  }
  
  public void a(CertifiedAccountMeta.StFollowRcmd paramStFollowRcmd, int paramInt)
  {
    if ((this.itemView instanceof BlankRecommendItemView))
    {
      ((BlankRecommendItemView)this.itemView).setData(paramStFollowRcmd);
      ((BlankRecommendItemView)this.itemView).setExtraTypeInfo(this.a.a());
      ((BlankRecommendItemView)this.itemView).setPos(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.BlankRecommendFeedsAdapter.RecommendFeedVH
 * JD-Core Version:    0.7.0.1
 */