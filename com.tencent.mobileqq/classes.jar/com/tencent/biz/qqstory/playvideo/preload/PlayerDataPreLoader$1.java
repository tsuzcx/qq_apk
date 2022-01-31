package com.tencent.biz.qqstory.playvideo.preload;

import vye;
import vyg;
import wsv;

public class PlayerDataPreLoader$1
  implements Runnable
{
  public PlayerDataPreLoader$1(vye paramvye) {}
  
  public void run()
  {
    vyg localvyg = vye.a(this.this$0, vye.a(this.this$0), vye.a(this.this$0), vye.a(this.this$0), 5, 5, 5, 20);
    vye.a(this.this$0, localvyg.a);
    vye.b(this.this$0, localvyg.b);
    try
    {
      vye.a(this.this$0);
      return;
    }
    catch (Exception localException)
    {
      wsv.c("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info error:%s", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.preload.PlayerDataPreLoader.1
 * JD-Core Version:    0.7.0.1
 */