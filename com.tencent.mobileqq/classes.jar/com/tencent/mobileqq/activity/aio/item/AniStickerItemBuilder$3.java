package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.emoticonview.anisticker.AniStickerAnimationListener;
import com.tencent.qphone.base.util.QLog;

class AniStickerItemBuilder$3
  implements AniStickerAnimationListener
{
  AniStickerItemBuilder$3(AniStickerItemBuilder paramAniStickerItemBuilder) {}
  
  public void onAnimationEnd(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageForAniSticker", 2, "random emo prepare-anim finish");
    }
  }
  
  public void onAnimationStart(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageForAniSticker", 2, "random emo prepare-anim start");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.AniStickerItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */