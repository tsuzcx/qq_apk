package com.tencent.mobileqq.activity.richmedia;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class QzoneSlideShowPreparingFragment$1
  extends Handler
{
  QzoneSlideShowPreparingFragment$1(QzoneSlideShowPreparingFragment paramQzoneSlideShowPreparingFragment, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what == 10) {
      postDelayed(QzoneSlideShowPreparingFragment.a(this.a), 200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.QzoneSlideShowPreparingFragment.1
 * JD-Core Version:    0.7.0.1
 */