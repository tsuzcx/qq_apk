package com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm;

import com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.StickerRecBarAdapter;
import com.tencent.mobileqq.emoticonview.EmotionKeywordLayout.OnVisibilityListener;

class StickerRecViewBinder$4
  implements EmotionKeywordLayout.OnVisibilityListener
{
  StickerRecViewBinder$4(StickerRecViewBinder paramStickerRecViewBinder) {}
  
  public void onVisibilityChanged(int paramInt)
  {
    if (paramInt == 8)
    {
      if (StickerRecViewBinder.a(this.a) != null) {
        StickerRecViewBinder.a(this.a).a();
      }
    }
    else if (paramInt == 0) {
      StickerRecViewBinder.b(this.a).f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.StickerRecViewBinder.4
 * JD-Core Version:    0.7.0.1
 */