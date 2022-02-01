package com.tencent.mobileqq.activity.aio.stickerbubble;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class StickerBubbleAnimationViewHolder$2
  implements StickerBubbleAnimationView.StickerBubbleAnimationCallback
{
  StickerBubbleAnimationViewHolder$2(StickerBubbleAnimationViewHolder paramStickerBubbleAnimationViewHolder) {}
  
  public void a()
  {
    StickerBubbleAnimationViewHolder.a(this.a, StickerBubbleAnimationViewHolder.b(this.a));
    ThreadManager.getUIHandler().post(new StickerBubbleAnimationViewHolder.2.1(this));
  }
  
  public void b()
  {
    StickerBubbleAnimationViewHolder.b(this.a, StickerBubbleAnimationViewHolder.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationViewHolder.2
 * JD-Core Version:    0.7.0.1
 */