package com.tencent.biz.qqstory.takevideo.slideshow.core;

import android.app.Activity;
import android.os.Bundle;
import bjrd;
import bkvh;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.qphone.base.util.QLog;
import vtz;
import vur;
import vus;

public class VideoMerger$1
  implements Runnable
{
  public VideoMerger$1(vur paramvur, vus paramvus, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, bjrd parambjrd, Bundle paramBundle1, Bundle paramBundle2) {}
  
  public void run()
  {
    bkvh.a(this.jdField_a_of_type_Vus.a, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, this.jdField_a_of_type_Bjrd, this.jdField_a_of_type_AndroidOsBundle, 7, this.b);
    if ((vtz.a().a() == 14) && ((this.jdField_a_of_type_Vus.a instanceof PhotoListActivity)))
    {
      QLog.d("VideoMerger", 2, "shuoshuo merge complete, jump to editVideoActivity and finish PhotoListActivity");
      this.jdField_a_of_type_Vus.a.finish();
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoMerger", 2, "merge complete, jump to editVideoActivity , context : " + this.jdField_a_of_type_Vus.a.getClass().getSimpleName());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.VideoMerger.1
 * JD-Core Version:    0.7.0.1
 */