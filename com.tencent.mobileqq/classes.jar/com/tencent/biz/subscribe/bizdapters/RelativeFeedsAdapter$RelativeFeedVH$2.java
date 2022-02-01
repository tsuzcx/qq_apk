package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.pb.PBStringField;

class RelativeFeedsAdapter$RelativeFeedVH$2
  implements View.OnLongClickListener
{
  RelativeFeedsAdapter$RelativeFeedVH$2(RelativeFeedsAdapter.RelativeFeedVH paramRelativeFeedVH, ExtraTypeInfo paramExtraTypeInfo, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public boolean onLongClick(View paramView)
  {
    paramView = this.a;
    if (paramView != null)
    {
      if (paramView.pageType == 7003)
      {
        RelativeFeedsAdapter.a(this.c.a, this.b);
        return true;
      }
      if (this.a.pageType == 7002) {
        return true;
      }
    }
    if ((this.c.itemView instanceof RelativeFeedItemView))
    {
      if (this.b == null) {
        return false;
      }
      this.c.a.a(this.b, new RelativeFeedsAdapter.RelativeFeedVH.2.1(this), new RelativeFeedsAdapter.RelativeFeedVH.2.2(this));
      paramView = this.b.poster.id.get();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.c.getAdapterPosition());
      localStringBuilder.append("");
      VSReporter.a(paramView, "auth_feeds", "press", 0, 0, new String[] { "", localStringBuilder.toString(), this.b.poster.nick.get(), this.b.title.get() });
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.RelativeFeedsAdapter.RelativeFeedVH.2
 * JD-Core Version:    0.7.0.1
 */