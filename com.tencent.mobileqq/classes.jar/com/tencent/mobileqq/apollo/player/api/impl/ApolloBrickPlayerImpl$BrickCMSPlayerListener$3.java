package com.tencent.mobileqq.apollo.player.api.impl;

import android.os.Handler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

class ApolloBrickPlayerImpl$BrickCMSPlayerListener$3
  implements URLDrawable.URLDrawableListener
{
  ApolloBrickPlayerImpl$BrickCMSPlayerListener$3(ApolloBrickPlayerImpl.BrickCMSPlayerListener paramBrickCMSPlayerListener, String paramString) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append("refreshViewOnRecordDone drawable loading success, actionKey:");
    paramURLDrawable.append(this.jdField_a_of_type_JavaLangString);
    QLog.e("[cmshow]ApolloBrickPlayer", 1, paramURLDrawable.toString());
    paramURLDrawable = this.jdField_a_of_type_ComTencentMobileqqApolloPlayerApiImplApolloBrickPlayerImpl$BrickCMSPlayerListener;
    paramURLDrawable = (Handler)ApolloBrickPlayerImpl.BrickCMSPlayerListener.a(paramURLDrawable, ApolloBrickPlayerImpl.BrickCMSPlayerListener.c(paramURLDrawable));
    if (paramURLDrawable != null) {
      paramURLDrawable.post(new ApolloBrickPlayerImpl.BrickCMSPlayerListener.3.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.api.impl.ApolloBrickPlayerImpl.BrickCMSPlayerListener.3
 * JD-Core Version:    0.7.0.1
 */