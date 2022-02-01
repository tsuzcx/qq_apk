package com.tencent.mobileqq.activity.aio.anim;

import agci;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class XBubbleAnimation$3
  implements Runnable
{
  public XBubbleAnimation$3(agci paramagci, Object[] paramArrayOfObject) {}
  
  public void run()
  {
    this.this$0.b(this.a);
    ThreadManager.getUIHandler().postDelayed(new XBubbleAnimation.3.1(this), 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.XBubbleAnimation.3
 * JD-Core Version:    0.7.0.1
 */