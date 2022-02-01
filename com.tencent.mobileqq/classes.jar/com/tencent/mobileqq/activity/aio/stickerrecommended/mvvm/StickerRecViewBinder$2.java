package com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm;

import android.widget.RelativeLayout;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.data.LayoutStatusLiveData;
import com.tencent.mobileqq.emoticonview.EmotionKeywordLayout;
import com.tencent.mobileqq.emoticonview.api.IRecommendEmotionService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class StickerRecViewBinder$2
  implements Observer<LayoutStatusLiveData>
{
  StickerRecViewBinder$2(StickerRecViewBinder paramStickerRecViewBinder) {}
  
  public void a(LayoutStatusLiveData paramLayoutStatusLiveData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecViewBinder", 2, new Object[] { "layoutStatus change:", Integer.valueOf(paramLayoutStatusLiveData.a), " ,layout:", this.a.a });
    }
    int i = paramLayoutStatusLiveData.a;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return;
          }
          if ((this.a.a != null) && (StickerRecViewBinder.d(this.a) != null))
          {
            StickerRecViewBinder.d(this.a).removeView(this.a.a);
            paramLayoutStatusLiveData = this.a;
            paramLayoutStatusLiveData.a = null;
            StickerRecViewBinder.a(paramLayoutStatusLiveData, null);
            StickerRecViewBinder.b(this.a).c(false);
          }
        }
        else
        {
          if (this.a.a != null)
          {
            this.a.a.hide();
            StickerRecViewBinder.b(this.a).c(false);
          }
          ((IRecommendEmotionService)QRoute.api(IRecommendEmotionService.class)).clearSpecWordType(StickerRecViewBinder.c(this.a));
        }
      }
      else if (this.a.a != null)
      {
        this.a.a.hide();
        StickerRecViewBinder.b(this.a).c(false);
      }
    }
    else if (this.a.a != null)
    {
      this.a.a.show(paramLayoutStatusLiveData.b);
      StickerRecViewBinder.b(this.a).c(true);
      this.a.a.bringToFront();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.mvvm.StickerRecViewBinder.2
 * JD-Core Version:    0.7.0.1
 */