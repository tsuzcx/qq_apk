package com.tencent.mobileqq.activity.aio.item;

import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;

class TribeShortVideoItemBuilder$3
  implements Runnable
{
  TribeShortVideoItemBuilder$3(TribeShortVideoItemBuilder paramTribeShortVideoItemBuilder, TribeShortVideoItemBuilder.TribeShortVideoMsgHolder paramTribeShortVideoMsgHolder) {}
  
  public void run()
  {
    TribeShortVideoItemBuilder.TribeShortVideoMsgHolder localTribeShortVideoMsgHolder = this.a;
    localTribeShortVideoMsgHolder.s = true;
    localTribeShortVideoMsgHolder.c.setDrawStatus(1);
    this.a.c.setVisibility(0);
    this.a.c.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */