package com.tencent.biz.pubaccount.readinjoy.view;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ReadInJoySearchTipsContainer$1
  extends Handler
{
  ReadInJoySearchTipsContainer$1(ReadInJoySearchTipsContainer paramReadInJoySearchTipsContainer, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (this.a.a != null)
    {
      if (paramMessage.obj != null) {
        this.a.a.a((String)paramMessage.obj);
      }
    }
    else {
      return;
    }
    this.a.a.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySearchTipsContainer.1
 * JD-Core Version:    0.7.0.1
 */