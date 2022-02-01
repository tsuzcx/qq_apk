package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Handler;
import com.tencent.biz.pubaccount.VideoInfo;
import ryx;

class VideoFollowManager$CheckAccountFollowedRunnable
  implements Runnable
{
  private VideoInfo a;
  
  private boolean a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if ((paramVideoInfo.j != null) && (paramVideoInfo.j.equals(this.a.j)) && (!paramVideoInfo.c) && (paramVideoInfo.q != paramBoolean))
    {
      paramVideoInfo.q = paramBoolean;
      return true;
    }
    return false;
  }
  
  public void run()
  {
    try
    {
      boolean bool = ryx.a(VideoFollowManager.a(this.this$0), Long.valueOf(this.a.j).longValue());
      if (VideoFollowManager.a(this.this$0) == null) {
        return;
      }
      VideoFollowManager.a(this.this$0).post(new VideoFollowManager.CheckAccountFollowedRunnable.1(this, bool));
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFollowManager.CheckAccountFollowedRunnable
 * JD-Core Version:    0.7.0.1
 */