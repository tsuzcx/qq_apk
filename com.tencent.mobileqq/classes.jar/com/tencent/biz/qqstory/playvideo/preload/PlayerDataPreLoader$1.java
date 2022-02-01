package com.tencent.biz.qqstory.playvideo.preload;

import xzt;
import xzv;
import yuk;

public class PlayerDataPreLoader$1
  implements Runnable
{
  public PlayerDataPreLoader$1(xzt paramxzt) {}
  
  public void run()
  {
    xzv localxzv = xzt.a(this.this$0, xzt.a(this.this$0), xzt.a(this.this$0), xzt.a(this.this$0), 5, 5, 5, 20);
    xzt.a(this.this$0, localxzv.a);
    xzt.b(this.this$0, localxzv.b);
    try
    {
      xzt.a(this.this$0);
      return;
    }
    catch (Exception localException)
    {
      yuk.c("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info error:%s", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.preload.PlayerDataPreLoader.1
 * JD-Core Version:    0.7.0.1
 */