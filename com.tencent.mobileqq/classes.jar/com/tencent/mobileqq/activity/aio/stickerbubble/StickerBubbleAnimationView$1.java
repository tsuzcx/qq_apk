package com.tencent.mobileqq.activity.aio.stickerbubble;

import agxh;
import java.util.List;
import java.util.Map;

class StickerBubbleAnimationView$1
  implements Runnable
{
  StickerBubbleAnimationView$1(StickerBubbleAnimationView paramStickerBubbleAnimationView, agxh paramagxh) {}
  
  public void run()
  {
    List localList = (List)StickerBubbleAnimationView.a(this.this$0).get(this.a.a());
    if ((localList == null) || (!localList.remove(this.a)))
    {
      localList = (List)StickerBubbleAnimationView.b(this.this$0).get(this.a.a());
      if (localList != null) {
        localList.remove(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView.1
 * JD-Core Version:    0.7.0.1
 */