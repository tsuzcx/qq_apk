package com.tencent.biz.pubaccount.weishi_new.holder;

import UserGrowth.stFeed;
import UserGrowth.stMagicBrand;
import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.WSFollowAdapter;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.view.WSMarqueeDirector.OnTextContentListener;

class WSFollowFeedHolder$5
  implements WSMarqueeDirector.OnTextContentListener
{
  WSFollowFeedHolder$5(WSFollowFeedHolder paramWSFollowFeedHolder) {}
  
  public void a(Object paramObject)
  {
    if (WeishiUtils.c()) {}
    while (!(paramObject instanceof stSchema)) {
      return;
    }
    WSFeedUtils.a(WSFollowFeedHolder.a(this.a).a(), (stSchema)paramObject, 700, WSFollowFeedHolder.a(this.a), "bottom_label");
    WSFollowFeedHolder.a(this.a, "bottom_label", 2);
  }
  
  public void b(Object paramObject)
  {
    if (WeishiUtils.c()) {}
    while ((!(paramObject instanceof stSchema)) || (WSFollowFeedHolder.a(this.a).feed == null) || (WSFollowFeedHolder.a(this.a).feed.magicBrand == null)) {
      return;
    }
    WSFeedUtils.a(WSFollowFeedHolder.a(this.a).a(), (stSchema)paramObject, 700, WSFollowFeedHolder.a(this.a), "bottom_label");
    WSFollowFeedHolder.a(this.a, "bottom_label", WSFollowFeedHolder.a(this.a).feed.magicBrand.type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFeedHolder.5
 * JD-Core Version:    0.7.0.1
 */