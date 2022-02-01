package com.qflutter.vistaimage;

import android.graphics.drawable.Drawable;
import rx.Subscriber;

class VistaImageTask$1$1
  implements IVistaImage.LoadBitmapCallback
{
  VistaImageTask$1$1(VistaImageTask.1 param1, Subscriber paramSubscriber) {}
  
  public void onFailed(String paramString1, int paramInt, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onFailed] url=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", code=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", msg=");
    localStringBuilder.append(paramString2);
    VistaImageLog.e("VistaImageTask", localStringBuilder.toString());
    paramString1 = new TextureRecord(this.a.a, "-5", "load bitmap error occurred");
    this.b.onNext(paramString1);
    this.b.onCompleted();
  }
  
  public void onLoaded(String paramString, Drawable paramDrawable, boolean paramBoolean, IRenderer paramIRenderer)
  {
    if (VistaImageLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[loadImage] url=");
      localStringBuilder.append(paramString);
      VistaImageLog.d("VistaImageTask", localStringBuilder.toString());
    }
    if (paramDrawable == null) {
      VistaImageLog.e("VistaImageTask", "[loadImage] no bitmap");
    }
    for (paramString = new TextureRecord(this.a.a, "-2", "no bitmap");; paramString = new TextureRecord(this.a.a, this.a.b, paramBoolean, paramDrawable, paramIRenderer))
    {
      this.b.onNext(paramString);
      this.b.onCompleted();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.vistaimage.VistaImageTask.1.1
 * JD-Core Version:    0.7.0.1
 */