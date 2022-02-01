package com.tencent.biz.qqstory.playvideo.preload;

import xvy;
import xwa;
import yqp;

public class PlayerDataPreLoader$1
  implements Runnable
{
  public PlayerDataPreLoader$1(xvy paramxvy) {}
  
  public void run()
  {
    xwa localxwa = xvy.a(this.this$0, xvy.a(this.this$0), xvy.a(this.this$0), xvy.a(this.this$0), 5, 5, 5, 20);
    xvy.a(this.this$0, localxwa.a);
    xvy.b(this.this$0, localxwa.b);
    try
    {
      xvy.a(this.this$0);
      return;
    }
    catch (Exception localException)
    {
      yqp.c("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info error:%s", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.preload.PlayerDataPreLoader.1
 * JD-Core Version:    0.7.0.1
 */