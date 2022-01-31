package com.tencent.biz.qqstory.playvideo.preload;

import wcn;
import wcp;
import wxe;

public class PlayerDataPreLoader$1
  implements Runnable
{
  public PlayerDataPreLoader$1(wcn paramwcn) {}
  
  public void run()
  {
    wcp localwcp = wcn.a(this.this$0, wcn.a(this.this$0), wcn.a(this.this$0), wcn.a(this.this$0), 5, 5, 5, 20);
    wcn.a(this.this$0, localwcp.a);
    wcn.b(this.this$0, localwcp.b);
    try
    {
      wcn.a(this.this$0);
      return;
    }
    catch (Exception localException)
    {
      wxe.c("Q.qqstory.player.data.PlayerDataPreLoader", "preload feature info error:%s", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.preload.PlayerDataPreLoader.1
 * JD-Core Version:    0.7.0.1
 */