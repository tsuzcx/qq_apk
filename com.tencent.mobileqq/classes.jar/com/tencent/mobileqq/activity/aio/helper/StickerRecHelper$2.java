package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecBarAdapter;
import com.tencent.mobileqq.emoticonview.EmotionKeywordLayout.OnVisibilityListener;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;

class StickerRecHelper$2
  implements EmotionKeywordLayout.OnVisibilityListener
{
  StickerRecHelper$2(StickerRecHelper paramStickerRecHelper) {}
  
  public void onVisibilityChanged(int paramInt)
  {
    if (paramInt == 8) {
      StickerRecHelper.a(this.a).c();
    }
    while ((paramInt != 0) || (StickerRecHelper.a(this.a) == 0L)) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = StickerRecHelper.a(this.a);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "StickerRecShowCost", true, l1 - l2, 0L, null, "");
    StickerRecHelper.a(this.a, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.StickerRecHelper.2
 * JD-Core Version:    0.7.0.1
 */