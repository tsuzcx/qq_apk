package com.tencent.biz.qqstory.takevideo.slideshow.core;

import android.app.Activity;
import android.os.Bundle;
import bqaa;
import brdx;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.qphone.base.util.QLog;
import zkg;
import zky;
import zkz;

public class VideoMerger$1
  implements Runnable
{
  public VideoMerger$1(zky paramzky, zkz paramzkz, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, bqaa parambqaa, Bundle paramBundle1, Bundle paramBundle2) {}
  
  public void run()
  {
    brdx.a(this.jdField_a_of_type_Zkz.a, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, this.jdField_a_of_type_Bqaa, this.jdField_a_of_type_AndroidOsBundle, 7, this.b);
    if ((zkg.a().a() == 14) && ((this.jdField_a_of_type_Zkz.a instanceof NewPhotoListActivity)))
    {
      QLog.d("VideoMerger", 2, "shuoshuo merge complete, jump to editVideoActivity and finish PhotoListActivity");
      this.jdField_a_of_type_Zkz.a.finish();
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoMerger", 2, "merge complete, jump to editVideoActivity , context : " + this.jdField_a_of_type_Zkz.a.getClass().getSimpleName());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.VideoMerger.1
 * JD-Core Version:    0.7.0.1
 */