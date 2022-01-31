package com.tencent.biz.qqstory.playvideo.preload;

import twt;
import twv;
import urk;

public class PlayerDataPreLoader$1
  implements Runnable
{
  public PlayerDataPreLoader$1(twt paramtwt) {}
  
  public void run()
  {
    twv localtwv = twt.a(this.this$0, twt.a(this.this$0), twt.a(this.this$0), twt.a(this.this$0), 5, 5, 5, 20);
    twt.a(this.this$0, localtwv.a);
    twt.b(this.this$0, localtwv.b);
    try
    {
      twt.a(this.this$0);
      return;
    }
    catch (Exception localException)
    {
      urk.c("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info error:%s", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.preload.PlayerDataPreLoader.1
 * JD-Core Version:    0.7.0.1
 */