package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.baseui.IWSItemView;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;

class WSVerticalPageEventHandler$2
  implements WSVerticalPageEventHandler.OnLoopHandle<WSVerticalVideoHolder>
{
  WSVerticalPageEventHandler$2(WSVerticalPageEventHandler paramWSVerticalPageEventHandler, String paramString) {}
  
  public void a(WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = this.b.a((WSVerticalItemData)paramWSVerticalVideoHolder.e);
    if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.poster != null) && (TextUtils.equals(localstSimpleMetaFeed.poster.id, this.a)))
    {
      paramWSVerticalVideoHolder.c.d(1);
      paramWSVerticalVideoHolder = new StringBuilder();
      paramWSVerticalVideoHolder.append("[WSVerticalPageEventHandler.java][updateFollowUIStatus]");
      paramWSVerticalVideoHolder.append(localstSimpleMetaFeed.poster.followStatus);
      paramWSVerticalVideoHolder.append(", this:");
      paramWSVerticalVideoHolder.append(this);
      WSLog.e("WSVerticalEventHandlerLog", paramWSVerticalVideoHolder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageEventHandler.2
 * JD-Core Version:    0.7.0.1
 */