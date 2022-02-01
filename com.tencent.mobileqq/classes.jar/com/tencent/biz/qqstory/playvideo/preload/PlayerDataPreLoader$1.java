package com.tencent.biz.qqstory.playvideo.preload;

import xbe;
import xbg;
import xvv;

public class PlayerDataPreLoader$1
  implements Runnable
{
  public PlayerDataPreLoader$1(xbe paramxbe) {}
  
  public void run()
  {
    xbg localxbg = xbe.a(this.this$0, xbe.a(this.this$0), xbe.a(this.this$0), xbe.a(this.this$0), 5, 5, 5, 20);
    xbe.a(this.this$0, localxbg.a);
    xbe.b(this.this$0, localxbg.b);
    try
    {
      xbe.a(this.this$0);
      return;
    }
    catch (Exception localException)
    {
      xvv.c("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info error:%s", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.preload.PlayerDataPreLoader.1
 * JD-Core Version:    0.7.0.1
 */