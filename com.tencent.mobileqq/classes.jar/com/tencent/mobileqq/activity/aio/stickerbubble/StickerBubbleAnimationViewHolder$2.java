package com.tencent.mobileqq.activity.aio.stickerbubble;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class StickerBubbleAnimationViewHolder$2
  implements StickerBubbleAnimationView.StickerBubbleAnimationCallback
{
  StickerBubbleAnimationViewHolder$2(StickerBubbleAnimationViewHolder paramStickerBubbleAnimationViewHolder) {}
  
  public void a()
  {
    StickerBubbleAnimationViewHolder localStickerBubbleAnimationViewHolder = this.a;
    StickerBubbleAnimationViewHolder.b(localStickerBubbleAnimationViewHolder, StickerBubbleAnimationViewHolder.b(localStickerBubbleAnimationViewHolder));
  }
  
  public void a(int paramInt)
  {
    StickerBubbleAnimationViewHolder localStickerBubbleAnimationViewHolder = this.a;
    StickerBubbleAnimationViewHolder.a(localStickerBubbleAnimationViewHolder, StickerBubbleAnimationViewHolder.b(localStickerBubbleAnimationViewHolder));
    ThreadManager.getUIHandler().post(new StickerBubbleAnimationViewHolder.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationViewHolder.2
 * JD-Core Version:    0.7.0.1
 */