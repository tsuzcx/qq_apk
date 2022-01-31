package com.tencent.biz.qqstory.playvideo.preload;

import ujp;
import ujr;
import veg;

public class PlayerDataPreLoader$1
  implements Runnable
{
  public PlayerDataPreLoader$1(ujp paramujp) {}
  
  public void run()
  {
    ujr localujr = ujp.a(this.this$0, ujp.a(this.this$0), ujp.a(this.this$0), ujp.a(this.this$0), 5, 5, 5, 20);
    ujp.a(this.this$0, localujr.a);
    ujp.b(this.this$0, localujr.b);
    try
    {
      ujp.a(this.this$0);
      return;
    }
    catch (Exception localException)
    {
      veg.c("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info error:%s", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.preload.PlayerDataPreLoader.1
 * JD-Core Version:    0.7.0.1
 */