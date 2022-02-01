package com.tencent.hippy.qq.view.tkd.listview;

import android.os.Handler;
import android.os.Message;

class AnimatingBall$1
  extends Handler
{
  AnimatingBall$1(AnimatingBall paramAnimatingBall) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0) {
      return;
    }
    if (paramMessage.what == 0)
    {
      paramMessage = this.this$0;
      paramMessage.mRefreshing = false;
      paramMessage.mRefreshStartTime = -1L;
      paramMessage.mCb.postInvalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.AnimatingBall.1
 * JD-Core Version:    0.7.0.1
 */