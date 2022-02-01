package com.tencent.biz.pubaccount.weishi_new.holder;

import UserGrowth.stFeed;
import UserGrowth.stMagicBrand;
import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.WSFollowAdapter;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.view.WSMarqueeDirector.OnTextContentListener;

class WSFollowFeedHolder$7
  implements WSMarqueeDirector.OnTextContentListener
{
  WSFollowFeedHolder$7(WSFollowFeedHolder paramWSFollowFeedHolder) {}
  
  public void a(Object paramObject)
  {
    if (WeishiUtils.o()) {
      return;
    }
    if ((paramObject instanceof stSchema))
    {
      WSFeedUtils.a(WSFollowFeedHolder.c(this.a).f(), (stSchema)paramObject, 700, WSFollowFeedHolder.d(this.a), "bottom_label");
      WSFollowFeedHolder.b(this.a, "bottom_label", 2);
    }
  }
  
  public void b(Object paramObject)
  {
    if (WeishiUtils.o()) {
      return;
    }
    if (((paramObject instanceof stSchema)) && (WSFollowFeedHolder.e(this.a).feed != null))
    {
      if (WSFollowFeedHolder.e(this.a).feed.magicBrand == null) {
        return;
      }
      WSFeedUtils.a(WSFollowFeedHolder.c(this.a).f(), (stSchema)paramObject, 700, WSFollowFeedHolder.d(this.a), "bottom_label");
      paramObject = this.a;
      WSFollowFeedHolder.b(paramObject, "bottom_label", WSFollowFeedHolder.e(paramObject).feed.magicBrand.type);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFeedHolder.7
 * JD-Core Version:    0.7.0.1
 */