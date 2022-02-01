package com.tencent.biz.qqstory.playvideo.player;

class VideoViewTVKImpl$4$1
  implements Runnable
{
  VideoViewTVKImpl$4$1(VideoViewTVKImpl.4 param4, int paramInt, Object paramObject) {}
  
  public void run()
  {
    if (this.c.a.n != null)
    {
      int j = this.a;
      int i;
      if (j == 21)
      {
        i = 2;
      }
      else
      {
        i = j;
        if (j == 22) {
          i = 3;
        }
      }
      this.c.a.n.a(this.c.a, i, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.4.1
 * JD-Core Version:    0.7.0.1
 */