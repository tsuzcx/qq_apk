package com.tencent.mobileqq.activity.aio.item;

import com.tencent.image.VideoDrawable.OnAudioPlayOnceListener;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ShortVideoPTVItemBuilder$2
  implements VideoDrawable.OnAudioPlayOnceListener
{
  ShortVideoPTVItemBuilder$2(ShortVideoPTVItemBuilder paramShortVideoPTVItemBuilder) {}
  
  public void onFinish()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoPTVItemBuilder", 2, "VideoDrawable.OnAudioPlayOnceListener.onFinish");
    }
    if ((ShortVideoPTVItemBuilder.h() != null) && (ShortVideoPTVItemBuilder.h().get() != null))
    {
      ShortVideoPTVItemBuilder.a(ShortVideoPTVItemBuilder.a(this.a), (ChatMessage)ShortVideoPTVItemBuilder.h().get());
      ShortVideoPTVItemBuilder.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */