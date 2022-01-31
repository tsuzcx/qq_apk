package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Handler;
import com.tencent.biz.pubaccount.VideoInfo;
import qol;

class VideoFollowManager$CheckAccountFollowedRunnable
  implements Runnable
{
  private VideoInfo a;
  
  public VideoFollowManager$CheckAccountFollowedRunnable(VideoFollowManager paramVideoFollowManager, VideoInfo paramVideoInfo)
  {
    this.a = paramVideoInfo;
  }
  
  private boolean a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if ((paramVideoInfo.j != null) && (paramVideoInfo.j.equals(this.a.j)) && (!paramVideoInfo.c) && (paramVideoInfo.k != paramBoolean))
    {
      paramVideoInfo.k = paramBoolean;
      return true;
    }
    return false;
  }
  
  public void run()
  {
    try
    {
      boolean bool = qol.a(VideoFollowManager.a(this.this$0), Long.valueOf(this.a.j).longValue());
      if (VideoFollowManager.a(this.this$0) == null) {
        return;
      }
      VideoFollowManager.a(this.this$0).post(new VideoFollowManager.CheckAccountFollowedRunnable.1(this, bool));
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFollowManager.CheckAccountFollowedRunnable
 * JD-Core Version:    0.7.0.1
 */