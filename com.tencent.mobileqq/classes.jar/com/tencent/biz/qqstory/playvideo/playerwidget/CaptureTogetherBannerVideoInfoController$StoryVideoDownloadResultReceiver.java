package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder.DownloadVideoResultEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.lang.ref.WeakReference;

public class CaptureTogetherBannerVideoInfoController$StoryVideoDownloadResultReceiver
  extends QQUIEventReceiver<CaptureTogetherBannerVideoInfoController, StoryPlayerGroupHolder.DownloadVideoResultEvent>
{
  private WeakReference<BannerVideoInfoWidget3.VideoDownloadListener> a;
  
  public CaptureTogetherBannerVideoInfoController$StoryVideoDownloadResultReceiver(@NonNull CaptureTogetherBannerVideoInfoController paramCaptureTogetherBannerVideoInfoController)
  {
    super(paramCaptureTogetherBannerVideoInfoController);
  }
  
  public void a(@NonNull CaptureTogetherBannerVideoInfoController paramCaptureTogetherBannerVideoInfoController, @NonNull StoryPlayerGroupHolder.DownloadVideoResultEvent paramDownloadVideoResultEvent)
  {
    if (paramDownloadVideoResultEvent.a)
    {
      if (paramDownloadVideoResultEvent.b != null)
      {
        paramCaptureTogetherBannerVideoInfoController = this.a;
        if (paramCaptureTogetherBannerVideoInfoController != null)
        {
          paramCaptureTogetherBannerVideoInfoController = (BannerVideoInfoWidget3.VideoDownloadListener)paramCaptureTogetherBannerVideoInfoController.get();
          if (paramCaptureTogetherBannerVideoInfoController != null) {
            paramCaptureTogetherBannerVideoInfoController.a(paramDownloadVideoResultEvent.b);
          }
        }
      }
    }
    else
    {
      SLog.e(this.TAG, "StoryVideoDownloadResultReceiver, onEvent download failed, vid:%s", new Object[] { paramDownloadVideoResultEvent.b });
      paramCaptureTogetherBannerVideoInfoController = this.a;
      if (paramCaptureTogetherBannerVideoInfoController != null)
      {
        paramCaptureTogetherBannerVideoInfoController = (BannerVideoInfoWidget3.VideoDownloadListener)paramCaptureTogetherBannerVideoInfoController.get();
        if (paramCaptureTogetherBannerVideoInfoController != null) {
          paramCaptureTogetherBannerVideoInfoController.a();
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return StoryPlayerGroupHolder.DownloadVideoResultEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.CaptureTogetherBannerVideoInfoController.StoryVideoDownloadResultReceiver
 * JD-Core Version:    0.7.0.1
 */