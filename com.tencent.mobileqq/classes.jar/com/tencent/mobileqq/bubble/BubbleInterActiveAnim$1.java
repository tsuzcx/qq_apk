package com.tencent.mobileqq.bubble;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;

class BubbleInterActiveAnim$1
  extends Handler
{
  BubbleInterActiveAnim$1(BubbleInterActiveAnim paramBubbleInterActiveAnim, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what != 1) {
      return;
    }
    paramMessage = (Pair)paramMessage.obj;
    this.a.b(((Long)paramMessage.first).longValue(), ((Long)paramMessage.second).longValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleInterActiveAnim.1
 * JD-Core Version:    0.7.0.1
 */