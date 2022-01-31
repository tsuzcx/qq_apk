package com.tencent.biz.qqstory.playvideo.preload;

import ujm;
import ujo;
import ved;

public class PlayerDataPreLoader$1
  implements Runnable
{
  public PlayerDataPreLoader$1(ujm paramujm) {}
  
  public void run()
  {
    ujo localujo = ujm.a(this.this$0, ujm.a(this.this$0), ujm.a(this.this$0), ujm.a(this.this$0), 5, 5, 5, 20);
    ujm.a(this.this$0, localujo.a);
    ujm.b(this.this$0, localujo.b);
    try
    {
      ujm.a(this.this$0);
      return;
    }
    catch (Exception localException)
    {
      ved.c("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info error:%s", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.preload.PlayerDataPreLoader.1
 * JD-Core Version:    0.7.0.1
 */