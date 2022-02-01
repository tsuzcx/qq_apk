package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.VideoCompressProcessor.CompressUpdateListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;

class ShortVideoItemBuilder$CompressUpdateListenerImpl
  implements VideoCompressProcessor.CompressUpdateListener
{
  private ShortVideoItemBuilder$CompressUpdateListenerImpl(ShortVideoItemBuilder paramShortVideoItemBuilder) {}
  
  public void a(MessageForShortVideo paramMessageForShortVideo, float paramFloat)
  {
    ShortVideoItemBuilder.Holder localHolder = ShortVideoItemBuilder.a(this.a, paramMessageForShortVideo);
    if (localHolder == null) {
      return;
    }
    paramMessageForShortVideo = paramMessageForShortVideo.frienduin + paramMessageForShortVideo.uniseq;
    localHolder.a.setAnimProgress(HardCodeUtil.a(2131714011), paramMessageForShortVideo);
    localHolder.a.a(paramMessageForShortVideo, paramFloat);
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "<MessageProgressView> CompressUpdateListener,onFinish. seq = " + paramMessageForShortVideo.uniseq);
    }
    UiThreadUtil.a(new ShortVideoItemBuilder.CompressUpdateListenerImpl.2(this, paramMessageForShortVideo, paramInt));
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean)
  {
    ShortVideoItemBuilder.Holder localHolder = ShortVideoItemBuilder.a(this.a, paramMessageForShortVideo);
    if (localHolder == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoItemBuilder", 2, "<MessageProgressView> CompressUpdateListenerImpl , onLaunch. seq = " + paramMessageForShortVideo.uniseq);
    }
    UiThreadUtil.a(new ShortVideoItemBuilder.CompressUpdateListenerImpl.1(this, paramMessageForShortVideo, paramBoolean, localHolder));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.CompressUpdateListenerImpl
 * JD-Core Version:    0.7.0.1
 */