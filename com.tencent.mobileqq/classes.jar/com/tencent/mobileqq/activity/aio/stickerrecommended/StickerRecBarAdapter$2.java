package com.tencent.mobileqq.activity.aio.stickerrecommended;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class StickerRecBarAdapter$2
  implements URLDrawable.URLDrawableListener
{
  StickerRecBarAdapter$2(StickerRecBarAdapter paramStickerRecBarAdapter) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    StickerRecBarAdapter.a(this.a).remove(paramURLDrawable);
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecBarAdapter", 2, "firstDrawableListener onLoadCanceled");
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    StickerRecBarAdapter.a(this.a, paramURLDrawable);
    StickerRecBarAdapter.a(this.a).remove(paramURLDrawable);
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecBarAdapter", 2, "firstDrawableListener onLoadFialed");
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    long l1 = System.currentTimeMillis();
    long l2 = StickerRecBarAdapter.a(this.a);
    StickerRecBarAdapter.a(this.a, paramURLDrawable, l1 - l2);
    StickerRecBarAdapter.a(this.a, true);
    StickerRecBarAdapter.a(this.a).remove(paramURLDrawable);
    this.a.a();
    if (QLog.isColorLevel()) {
      QLog.d("StickerRecBarAdapter", 2, "firstDrawableListener downloadSuccess");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecBarAdapter.2
 * JD-Core Version:    0.7.0.1
 */