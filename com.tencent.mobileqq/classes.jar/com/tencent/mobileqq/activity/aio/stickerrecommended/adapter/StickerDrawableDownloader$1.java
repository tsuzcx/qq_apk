package com.tencent.mobileqq.activity.aio.stickerrecommended.adapter;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class StickerDrawableDownloader$1
  implements URLDrawable.URLDrawableListener
{
  StickerDrawableDownloader$1(StickerDrawableDownloader paramStickerDrawableDownloader) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    StickerDrawableDownloader.a(this.a).remove(paramURLDrawable);
    if (QLog.isColorLevel()) {
      QLog.d("StickerDrawableDownloader", 2, "firstDrawableListener onLoadCanceled");
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    StickerDrawableDownloader.a(this.a, paramURLDrawable);
    StickerDrawableDownloader.a(this.a).remove(paramURLDrawable);
    if (QLog.isColorLevel()) {
      QLog.d("StickerDrawableDownloader", 2, "firstDrawableListener onLoadFialed");
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    long l1 = System.currentTimeMillis();
    long l2 = StickerDrawableDownloader.a(this.a);
    StickerDrawableDownloader.a(this.a, paramURLDrawable, l1 - l2);
    StickerDrawableDownloader.a(this.a, true);
    StickerDrawableDownloader.a(this.a).remove(paramURLDrawable);
    if (StickerDrawableDownloader.a(this.a) != null) {
      StickerDrawableDownloader.a(this.a).a(StickerDrawableDownloader.a(this.a));
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerDrawableDownloader", 2, "firstDrawableListener downloadSuccess");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.StickerDrawableDownloader.1
 * JD-Core Version:    0.7.0.1
 */