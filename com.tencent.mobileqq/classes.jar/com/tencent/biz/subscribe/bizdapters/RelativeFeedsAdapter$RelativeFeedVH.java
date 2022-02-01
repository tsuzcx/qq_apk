package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLike;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeAdFeedItemView;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class RelativeFeedsAdapter$RelativeFeedVH
  extends RecyclerView.ViewHolder
{
  public RelativeFeedsAdapter$RelativeFeedVH(RelativeFeedsAdapter paramRelativeFeedsAdapter, View paramView)
  {
    super(paramView);
  }
  
  private boolean a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if ((this.itemView instanceof BaseWidgetView))
    {
      CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)((BaseWidgetView)this.itemView).a();
      if ((localStFeed != null) && (paramStFeed != null) && (!TextUtils.isEmpty(localStFeed.id.get())) && (!TextUtils.isEmpty(localStFeed.id.get()))) {
        return (localStFeed.id.get().equals(paramStFeed.id.get())) && (localStFeed.likeInfo.count.get() == paramStFeed.likeInfo.count.get());
      }
    }
    return false;
  }
  
  public void a(CertifiedAccountMeta.StFeed paramStFeed, ExtraTypeInfo paramExtraTypeInfo)
  {
    if (a(paramStFeed)) {
      return;
    }
    if ((this.itemView instanceof RelativeFeedItemView))
    {
      ((RelativeFeedItemView)this.itemView).setIsInNightMode(RelativeFeedsAdapter.a(this.a));
      ((RelativeFeedItemView)this.itemView).setExtraTypeInfo(paramExtraTypeInfo);
      ((RelativeFeedItemView)this.itemView).setData(paramStFeed);
      ((RelativeFeedItemView)this.itemView).setDataPosInList(getAdapterPosition());
    }
    for (;;)
    {
      if (RelativeFeedsAdapter.a(this.a) != null) {
        this.itemView.setOnClickListener(new RelativeFeedsAdapter.RelativeFeedVH.1(this, paramStFeed));
      }
      this.itemView.setOnLongClickListener(new RelativeFeedsAdapter.RelativeFeedVH.2(this, paramExtraTypeInfo, paramStFeed));
      return;
      if ((this.itemView instanceof RelativeAdFeedItemView))
      {
        ((RelativeAdFeedItemView)this.itemView).setIsInNightMode(RelativeFeedsAdapter.a(this.a));
        ((RelativeAdFeedItemView)this.itemView).setExtraTypeInfo(paramExtraTypeInfo);
        ((RelativeAdFeedItemView)this.itemView).setData(paramStFeed);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.RelativeFeedsAdapter.RelativeFeedVH
 * JD-Core Version:    0.7.0.1
 */