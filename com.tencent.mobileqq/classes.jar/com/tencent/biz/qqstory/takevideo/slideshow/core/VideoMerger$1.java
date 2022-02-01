package com.tencent.biz.qqstory.takevideo.slideshow.core;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.setting.CaptureEntranceParams;
import dov.com.tencent.mobileqq.richmedia.capture.util.JumpUtil;

class VideoMerger$1
  implements Runnable
{
  VideoMerger$1(VideoMerger paramVideoMerger, VideoMerger.MergeContext paramMergeContext, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, CaptureEntranceParams paramCaptureEntranceParams, Bundle paramBundle1, Bundle paramBundle2) {}
  
  public void run()
  {
    JumpUtil.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreVideoMerger$MergeContext.a, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, this.jdField_a_of_type_DovComQqImSettingCaptureEntranceParams, this.jdField_a_of_type_AndroidOsBundle, 7, this.b);
    if ((SlideShowPhotoListManager.a().a() == 14) && ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreVideoMerger$MergeContext.a instanceof NewPhotoListActivity)))
    {
      QLog.d("VideoMerger", 2, "shuoshuo merge complete, jump to editVideoActivity and finish PhotoListActivity");
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreVideoMerger$MergeContext.a.finish();
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoMerger", 2, "merge complete, jump to editVideoActivity , context : " + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreVideoMerger$MergeContext.a.getClass().getSimpleName());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.VideoMerger.1
 * JD-Core Version:    0.7.0.1
 */