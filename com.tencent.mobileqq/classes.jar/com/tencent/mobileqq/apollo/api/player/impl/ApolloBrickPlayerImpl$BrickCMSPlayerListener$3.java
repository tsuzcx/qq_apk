package com.tencent.mobileqq.apollo.api.player.impl;

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
    QLog.e("ApolloBrickPlayer", 1, "refreshViewOnRecordDone drawable loading success, actionKey:" + this.jdField_a_of_type_JavaLangString);
    paramURLDrawable = (Handler)ApolloBrickPlayerImpl.BrickCMSPlayerListener.a(this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerImplApolloBrickPlayerImpl$BrickCMSPlayerListener, ApolloBrickPlayerImpl.BrickCMSPlayerListener.c(this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerImplApolloBrickPlayerImpl$BrickCMSPlayerListener));
    if (paramURLDrawable != null) {
      paramURLDrawable.post(new ApolloBrickPlayerImpl.BrickCMSPlayerListener.3.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.player.impl.ApolloBrickPlayerImpl.BrickCMSPlayerListener.3
 * JD-Core Version:    0.7.0.1
 */