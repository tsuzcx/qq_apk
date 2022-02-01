package com.tencent.biz.subscribe.widget;

import android.os.Handler;
import android.os.Message;

class AlphaLoadingView$1
  extends Handler
{
  AlphaLoadingView$1(AlphaLoadingView paramAlphaLoadingView) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (!AlphaLoadingView.a(this.a))
    {
      this.a.invalidate();
      sendEmptyMessageDelayed(1, AlphaLoadingView.b(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.AlphaLoadingView.1
 * JD-Core Version:    0.7.0.1
 */