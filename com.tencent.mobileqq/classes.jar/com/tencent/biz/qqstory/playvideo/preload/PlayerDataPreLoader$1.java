package com.tencent.biz.qqstory.playvideo.preload;

import com.tencent.biz.qqstory.support.logging.SLog;

class PlayerDataPreLoader$1
  implements Runnable
{
  PlayerDataPreLoader$1(PlayerDataPreLoader paramPlayerDataPreLoader) {}
  
  public void run()
  {
    PlayerDataPreLoader.Result localResult = PlayerDataPreLoader.a(this.this$0, PlayerDataPreLoader.a(this.this$0), PlayerDataPreLoader.a(this.this$0), PlayerDataPreLoader.a(this.this$0), 5, 5, 5, 20);
    PlayerDataPreLoader.a(this.this$0, localResult.a);
    PlayerDataPreLoader.b(this.this$0, localResult.b);
    try
    {
      PlayerDataPreLoader.a(this.this$0);
      return;
    }
    catch (Exception localException)
    {
      SLog.c("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info error:%s", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.preload.PlayerDataPreLoader.1
 * JD-Core Version:    0.7.0.1
 */