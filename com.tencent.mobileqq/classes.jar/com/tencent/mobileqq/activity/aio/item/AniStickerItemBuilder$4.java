package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.data.MessageForAniSticker;
import com.tencent.mobileqq.emoticonview.anisticker.AniStickerAnimationListener;
import com.tencent.qphone.base.util.QLog;

class AniStickerItemBuilder$4
  implements AniStickerAnimationListener
{
  AniStickerItemBuilder$4(AniStickerItemBuilder paramAniStickerItemBuilder, MessageForAniSticker paramMessageForAniSticker) {}
  
  public void onAnimationEnd(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageForAniSticker", 2, "random emo result-anim finish");
    }
    paramString = this.b;
    AniStickerItemBuilder.a(paramString, paramString.d, this.a, 1, 2);
    AniStickerItemBuilder.a(this.b, this.a, paramInt);
  }
  
  public void onAnimationStart(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageForAniSticker", 2, "random emo result-anim start");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.AniStickerItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */