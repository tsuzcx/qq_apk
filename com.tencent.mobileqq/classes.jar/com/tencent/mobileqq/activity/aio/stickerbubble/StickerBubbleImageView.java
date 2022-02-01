package com.tencent.mobileqq.activity.aio.stickerbubble;

import android.content.Context;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class StickerBubbleImageView
  extends ImageView
{
  public StickerBubbleImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a()
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.25F, 1.0F, 1.25F, getWidth() / 2, getHeight() / 2);
    localScaleAnimation.setDuration(100L);
    localScaleAnimation.setFillAfter(true);
    startAnimation(localScaleAnimation);
    setAlpha(0.5F);
  }
  
  public void b()
  {
    clearAnimation();
    setAlpha(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleImageView
 * JD-Core Version:    0.7.0.1
 */