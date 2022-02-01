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
    if (paramDownloadVideoResultEvent.jdField_a_of_type_Boolean) {
      if ((paramDownloadVideoResultEvent.jdField_a_of_type_JavaLangString != null) && (this.a != null))
      {
        paramCaptureTogetherBannerVideoInfoController = (BannerVideoInfoWidget3.VideoDownloadListener)this.a.get();
        if (paramCaptureTogetherBannerVideoInfoController != null) {
          paramCaptureTogetherBannerVideoInfoController.a(paramDownloadVideoResultEvent.jdField_a_of_type_JavaLangString);
        }
      }
    }
    do
    {
      do
      {
        return;
        SLog.e(this.TAG, "StoryVideoDownloadResultReceiver, onEvent download failed, vid:%s", new Object[] { paramDownloadVideoResultEvent.jdField_a_of_type_JavaLangString });
      } while (this.a == null);
      paramCaptureTogetherBannerVideoInfoController = (BannerVideoInfoWidget3.VideoDownloadListener)this.a.get();
    } while (paramCaptureTogetherBannerVideoInfoController == null);
    paramCaptureTogetherBannerVideoInfoController.a();
  }
  
  public Class acceptEventClass()
  {
    return StoryPlayerGroupHolder.DownloadVideoResultEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.CaptureTogetherBannerVideoInfoController.StoryVideoDownloadResultReceiver
 * JD-Core Version:    0.7.0.1
 */