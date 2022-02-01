package com.tencent.hippy.qq.view.tkd.listview;

import android.os.Handler;
import android.os.Message;

class AnimatingBall$1
  extends Handler
{
  AnimatingBall$1(AnimatingBall paramAnimatingBall) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {}
    while (paramMessage.what != 0) {
      return;
    }
    this.this$0.mRefreshing = false;
    this.this$0.mRefreshStartTime = -1L;
    this.this$0.mCb.postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.AnimatingBall.1
 * JD-Core Version:    0.7.0.1
 */