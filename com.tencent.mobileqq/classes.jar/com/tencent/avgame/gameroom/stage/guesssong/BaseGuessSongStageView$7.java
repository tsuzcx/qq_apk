package com.tencent.avgame.gameroom.stage.guesssong;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;

class BaseGuessSongStageView$7
  implements URLDrawable.URLDrawableListener
{
  BaseGuessSongStageView$7(BaseGuessSongStageView paramBaseGuessSongStageView) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.d("BaseGuessSongStageView", 2, "onLoadFialed " + paramThrowable);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    QLog.d("BaseGuessSongStageView", 2, "onLoadSuccessed ");
    if ((paramURLDrawable != null) && (paramURLDrawable.getCurrDrawable() != null) && (this.a.a != null) && (this.a.a.getImageAsset("image_6") != null))
    {
      paramURLDrawable = this.a.a(paramURLDrawable, 280, 280);
      this.a.a.updateBitmap("image_6", paramURLDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.guesssong.BaseGuessSongStageView.7
 * JD-Core Version:    0.7.0.1
 */