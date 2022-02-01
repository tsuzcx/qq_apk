package com.tencent.biz.qqstory.takevideo.slideshow.core;

import android.app.Activity;
import android.os.Bundle;
import boqz;
import bpnk;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.qphone.base.util.QLog;
import yzz;
import zar;
import zas;

public class VideoMerger$1
  implements Runnable
{
  public VideoMerger$1(zar paramzar, zas paramzas, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo, boqz paramboqz, Bundle paramBundle1, Bundle paramBundle2) {}
  
  public void run()
  {
    bpnk.a(this.jdField_a_of_type_Zas.a, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, this.jdField_a_of_type_Boqz, this.jdField_a_of_type_AndroidOsBundle, 7, this.b);
    if ((yzz.a().a() == 14) && ((this.jdField_a_of_type_Zas.a instanceof NewPhotoListActivity)))
    {
      QLog.d("VideoMerger", 2, "shuoshuo merge complete, jump to editVideoActivity and finish PhotoListActivity");
      this.jdField_a_of_type_Zas.a.finish();
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoMerger", 2, "merge complete, jump to editVideoActivity , context : " + this.jdField_a_of_type_Zas.a.getClass().getSimpleName());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.VideoMerger.1
 * JD-Core Version:    0.7.0.1
 */