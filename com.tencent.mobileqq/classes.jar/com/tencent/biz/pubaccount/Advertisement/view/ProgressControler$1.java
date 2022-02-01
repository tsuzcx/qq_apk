package com.tencent.biz.pubaccount.Advertisement.view;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ProgressControler$1
  extends Handler
{
  ProgressControler$1(ProgressControler paramProgressControler, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.jdField_a_of_type_Boolean) {
      return;
    }
    this.a.a(this.a.jdField_a_of_type_Int, this.a.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.ProgressControler.1
 * JD-Core Version:    0.7.0.1
 */