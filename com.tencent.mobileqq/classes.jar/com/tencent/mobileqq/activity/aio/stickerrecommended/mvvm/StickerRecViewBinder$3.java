package com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.emoticonview.EmoticonReportDtHelper;

class StickerRecViewBinder$3
  implements Observer<String>
{
  StickerRecViewBinder$3(StickerRecViewBinder paramStickerRecViewBinder) {}
  
  public void a(String paramString)
  {
    if (this.a.a != null) {
      EmoticonReportDtHelper.bindStickersRecommendBar(this.a.a, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.StickerRecViewBinder.3
 * JD-Core Version:    0.7.0.1
 */