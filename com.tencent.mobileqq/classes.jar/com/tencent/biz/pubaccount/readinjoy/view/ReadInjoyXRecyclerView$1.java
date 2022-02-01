package com.tencent.biz.pubaccount.readinjoy.view;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ReadInjoyXRecyclerView$1
  extends Handler
{
  ReadInjoyXRecyclerView$1(ReadInjoyXRecyclerView paramReadInjoyXRecyclerView, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what == ReadInjoyXRecyclerView.b) {
      this.a.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInjoyXRecyclerView.1
 * JD-Core Version:    0.7.0.1
 */