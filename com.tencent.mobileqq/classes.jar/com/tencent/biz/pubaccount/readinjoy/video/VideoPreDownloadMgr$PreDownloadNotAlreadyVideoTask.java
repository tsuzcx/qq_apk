package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.Set;

public class VideoPreDownloadMgr$PreDownloadNotAlreadyVideoTask
  implements Runnable
{
  private boolean a;
  
  public VideoPreDownloadMgr$PreDownloadNotAlreadyVideoTask(VideoPreDownloadMgr paramVideoPreDownloadMgr, boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void run()
  {
    if (this.a)
    {
      if (VideoPreDownloadMgr.a(this.this$0) != null) {
        VideoPreDownloadMgr.a(this.this$0).add(VideoPreDownloadMgr.a(this.this$0));
      }
      if (VideoPreDownloadMgr.a() != null) {
        VideoPreDownloadMgr.a().add(VideoPreDownloadMgr.a(this.this$0));
      }
    }
    VideoPreDownloadMgr.a(this.this$0, null);
    VideoPreDownloadMgr.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr.PreDownloadNotAlreadyVideoTask
 * JD-Core Version:    0.7.0.1
 */