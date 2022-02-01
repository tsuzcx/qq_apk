package com.tencent.mobileqq.activity.aio.photo;

import android.os.Handler;
import android.os.Looper;
import com.tencent.image.VideoDrawable.OnPlayRepeatListener;

class AIOGalleryAdapter$VideoListener
  implements VideoDrawable.OnPlayRepeatListener
{
  AIOGalleryAdapter a;
  
  public AIOGalleryAdapter$VideoListener(AIOGalleryAdapter paramAIOGalleryAdapter)
  {
    this.a = paramAIOGalleryAdapter;
  }
  
  public void onPlayRepeat(int paramInt)
  {
    if (paramInt != 1) {
      return;
    }
    new Handler(Looper.getMainLooper()).post(new AIOGalleryAdapter.VideoListener.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter.VideoListener
 * JD-Core Version:    0.7.0.1
 */