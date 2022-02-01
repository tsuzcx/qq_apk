package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.baseui.IWSItemView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;

class WSVerticalPageEventHandler$1
  implements WSVerticalPageEventHandler.OnLoopHandle<WSVerticalVideoHolder>
{
  WSVerticalPageEventHandler$1(WSVerticalPageEventHandler paramWSVerticalPageEventHandler, String paramString) {}
  
  public void a(WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = this.b.a((WSVerticalItemData)paramWSVerticalVideoHolder.e);
    if ((localstSimpleMetaFeed != null) && (TextUtils.equals(localstSimpleMetaFeed.id, this.a))) {
      paramWSVerticalVideoHolder.c.d(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageEventHandler.1
 * JD-Core Version:    0.7.0.1
 */