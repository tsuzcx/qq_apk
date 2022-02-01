package com.tencent.mobileqq.bubble;

import com.tencent.mobileqq.utils.StartupTracker;

class BubbleManager$2
  implements Runnable
{
  BubbleManager$2(BubbleManager paramBubbleManager, int paramInt) {}
  
  public void run()
  {
    StartupTracker.a(null, "AIO_bubble_craete_bubble_info");
    this.this$0.b(this.a, true);
    StartupTracker.a("AIO_bubble_craete_bubble_info", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleManager.2
 * JD-Core Version:    0.7.0.1
 */