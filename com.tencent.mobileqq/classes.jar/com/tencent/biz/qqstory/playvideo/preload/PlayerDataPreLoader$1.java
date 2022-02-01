package com.tencent.biz.qqstory.playvideo.preload;

import xpz;
import xqb;
import ykq;

public class PlayerDataPreLoader$1
  implements Runnable
{
  public PlayerDataPreLoader$1(xpz paramxpz) {}
  
  public void run()
  {
    xqb localxqb = xpz.a(this.this$0, xpz.a(this.this$0), xpz.a(this.this$0), xpz.a(this.this$0), 5, 5, 5, 20);
    xpz.a(this.this$0, localxqb.a);
    xpz.b(this.this$0, localxqb.b);
    try
    {
      xpz.a(this.this$0);
      return;
    }
    catch (Exception localException)
    {
      ykq.c("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info error:%s", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.preload.PlayerDataPreLoader.1
 * JD-Core Version:    0.7.0.1
 */