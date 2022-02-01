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
    StickerBubbleAnimationViewHolder.a(this.a, StickerBubbleAnimationViewHolder.a(this.a));
    ThreadManager.getUIHandler().post(new StickerBubbleAnimationViewHolder.1.1(this));
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleAnimationViewHolder", 2, "onSurfaceDestroyed");
    }
    StickerBubbleAnimationViewHolder.b(this.a, StickerBubbleAnimationViewHolder.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationViewHolder.1
 * JD-Core Version:    0.7.0.1
 */