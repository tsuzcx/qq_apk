package com.tencent.mobileqq.activity.aio.stickerbubble;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class StickerBubbleAnimationViewHolder$1
  implements StickerBubbleAnimationView.StickerBubbleAnimationCallback
{
  StickerBubbleAnimationViewHolder$1(StickerBubbleAnimationViewHolder paramStickerBubbleAnimationViewHolder) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleAnimationViewHolder", 2, "onViewDetached");
    }
    StickerBubbleAnimationViewHolder localStickerBubbleAnimationViewHolder = this.a;
    StickerBubbleAnimationViewHolder.b(localStickerBubbleAnimationViewHolder, StickerBubbleAnimationViewHolder.a(localStickerBubbleAnimationViewHolder));
  }
  
  public void a(int paramInt)
  {
    StickerBubbleAnimationViewHolder localStickerBubbleAnimationViewHolder = this.a;
    StickerBubbleAnimationViewHolder.a(localStickerBubbleAnimationViewHolder, StickerBubbleAnimationViewHolder.a(localStickerBubbleAnimationViewHolder));
    ThreadManager.getUIHandler().post(new StickerBubbleAnimationViewHolder.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationViewHolder.1
 * JD-Core Version:    0.7.0.1
 */