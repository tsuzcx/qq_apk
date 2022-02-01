package com.tencent.biz.qqstory.takevideo.slideshow.core;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.aelight.camera.qqstory.api.ILaunchVideoEditorForAlbum;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.qphone.base.util.QLog;

class VideoMerger$1
  implements Runnable
{
  VideoMerger$1(VideoMerger paramVideoMerger, VideoMerger.MergeContext paramMergeContext, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, Bundle paramBundle1, Bundle paramBundle2) {}
  
  public void run()
  {
    ((ILaunchVideoEditorForAlbum)QRoute.api(ILaunchVideoEditorForAlbum.class)).jumpToEditVideoActivity(this.a.c, this.b, this.c, this.d, 7, this.e);
    if ((SlideShowPhotoListManager.a().d() == 14) && ((this.a.c instanceof NewPhotoListActivity)))
    {
      QLog.d("VideoMerger", 2, "shuoshuo merge complete, jump to editVideoActivity and finish PhotoListActivity");
      this.a.c.finish();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("merge complete, jump to editVideoActivity , context : ");
      localStringBuilder.append(this.a.c.getClass().getSimpleName());
      QLog.d("VideoMerger", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.VideoMerger.1
 * JD-Core Version:    0.7.0.1
 */