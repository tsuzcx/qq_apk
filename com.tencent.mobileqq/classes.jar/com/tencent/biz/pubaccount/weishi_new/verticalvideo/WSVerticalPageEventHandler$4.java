package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalCommonVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;

class WSVerticalPageEventHandler$4
  implements WSVerticalPageEventHandler.OnLoopHandle<WSVerticalVideoHolder>
{
  WSVerticalPageEventHandler$4(WSVerticalPageEventHandler paramWSVerticalPageEventHandler, boolean paramBoolean) {}
  
  public void a(WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    if ((paramWSVerticalVideoHolder instanceof WSVerticalCommonVideoHolder)) {
      ((WSVerticalCommonVideoHolder)paramWSVerticalVideoHolder).b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageEventHandler.4
 * JD-Core Version:    0.7.0.1
 */