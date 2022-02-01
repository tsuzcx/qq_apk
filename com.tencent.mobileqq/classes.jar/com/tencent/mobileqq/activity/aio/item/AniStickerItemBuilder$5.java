package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.emoticonview.anisticker.AniStickerAnimationListener;
import com.tencent.mobileqq.emoticonview.anisticker.AniStickerLottieView;

class AniStickerItemBuilder$5
  implements AniStickerAnimationListener
{
  AniStickerItemBuilder$5(AniStickerItemBuilder paramAniStickerItemBuilder, AniStickerLottieView paramAniStickerLottieView) {}
  
  public void onAnimationEnd(int paramInt, String paramString)
  {
    AniStickerItemBuilder.a(this.b, this.a);
  }
  
  public void onAnimationStart(int paramInt, String paramString)
  {
    this.a.bringToFront();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.AniStickerItemBuilder.5
 * JD-Core Version:    0.7.0.1
 */