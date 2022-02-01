package com.tencent.mobileqq.activity.aio.item;

import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.mobileqq.videoplatform.view.CropBubbleVideoView;
import com.tencent.qphone.base.util.QLog;

class TribeShortVideoItemBuilder$6
  implements Runnable
{
  TribeShortVideoItemBuilder$6(TribeShortVideoItemBuilder paramTribeShortVideoItemBuilder, TribeShortVideoItemBuilder.TribeShortVideoMsgHolder paramTribeShortVideoMsgHolder, long paramLong) {}
  
  public void run()
  {
    Object localObject = this.a;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TribeShortVideoItemBuilder", 2, "showPlayIcon");
      }
      return;
    }
    localObject = (Long)((TribeShortVideoItemBuilder.TribeShortVideoMsgHolder)localObject).b.getTag();
    if (localObject != null)
    {
      if (((Long)localObject).longValue() != this.b) {
        return;
      }
      this.a.c.setDrawStatus(2);
      this.a.c.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder.6
 * JD-Core Version:    0.7.0.1
 */