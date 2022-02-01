package com.tencent.mobileqq.activity.aio.stickerbubble;

import android.view.View;

class StickerBubbleListView$1
  implements StickerBubbleListView.Action
{
  StickerBubbleListView$1(StickerBubbleListView paramStickerBubbleListView, int[] paramArrayOfInt) {}
  
  public void a(View paramView)
  {
    if ((paramView.getTag() instanceof Integer))
    {
      paramView = (Integer)paramView.getTag();
      this.a[0] = paramView.intValue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleListView.1
 * JD-Core Version:    0.7.0.1
 */