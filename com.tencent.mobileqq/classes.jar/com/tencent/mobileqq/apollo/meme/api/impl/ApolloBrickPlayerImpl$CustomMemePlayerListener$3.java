package com.tencent.mobileqq.apollo.meme.api.impl;

import android.os.Handler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

class ApolloBrickPlayerImpl$CustomMemePlayerListener$3
  implements URLDrawable.URLDrawableListener
{
  ApolloBrickPlayerImpl$CustomMemePlayerListener$3(ApolloBrickPlayerImpl.CustomMemePlayerListener paramCustomMemePlayerListener, String paramString) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append("refreshViewOnRecordDone drawable loading success, actionKey:");
    paramURLDrawable.append(this.a);
    QLog.e("[cmshow]ApolloBrickPlayer", 1, paramURLDrawable.toString());
    paramURLDrawable = this.b;
    paramURLDrawable = (Handler)ApolloBrickPlayerImpl.CustomMemePlayerListener.a(paramURLDrawable, ApolloBrickPlayerImpl.CustomMemePlayerListener.e(paramURLDrawable));
    if (paramURLDrawable != null) {
      paramURLDrawable.post(new ApolloBrickPlayerImpl.CustomMemePlayerListener.3.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.api.impl.ApolloBrickPlayerImpl.CustomMemePlayerListener.3
 * JD-Core Version:    0.7.0.1
 */