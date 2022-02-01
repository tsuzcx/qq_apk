package com.tencent.aelight.camera.aioeditor;

import android.content.Intent;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.QQStoryFlowCallback;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivityHandler;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListData;
import java.util.ArrayList;

class PhotoListCustomizationAECamera$2
  implements MediaScanner.OnMediaInfoScannerListener
{
  PhotoListCustomizationAECamera$2(PhotoListCustomizationAECamera paramPhotoListCustomizationAECamera, Intent paramIntent, ArrayList paramArrayList) {}
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (QQStoryFlowCallback.a(PhotoListCustomizationAECamera.b(this.jdField_a_of_type_ComTencentAelightCameraAioeditorPhotoListCustomizationAECamera), paramLocalMediaInfo))
    {
      if ((PhotoListCustomizationAECamera.b(this.jdField_a_of_type_ComTencentAelightCameraAioeditorPhotoListCustomizationAECamera) != null) && (paramLocalMediaInfo.mDuration > this.jdField_a_of_type_ComTencentAelightCameraAioeditorPhotoListCustomizationAECamera.a.filter.videoMaxDuration))
      {
        PhotoListCustomizationAECamera.c(this.jdField_a_of_type_ComTencentAelightCameraAioeditorPhotoListCustomizationAECamera).a.b();
        this.jdField_a_of_type_AndroidContentIntent.putExtra("media_info", paramLocalMediaInfo);
        PhotoUtils.sendPhoto(PhotoListCustomizationAECamera.c(this.jdField_a_of_type_ComTencentAelightCameraAioeditorPhotoListCustomizationAECamera), this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilArrayList, 2, true);
        return;
      }
      FrameVideoHelper localFrameVideoHelper = new FrameVideoHelper(paramLocalMediaInfo.path, paramLocalMediaInfo.mediaWidth, paramLocalMediaInfo.mediaHeight, paramLocalMediaInfo.mDuration);
      localFrameVideoHelper.a(new PhotoListCustomizationAECamera.2.1(this, paramLocalMediaInfo, localFrameVideoHelper));
      VSReporter.a("mystatus_localupload", "video_select", 0, 0, new String[0]);
      return;
    }
    PhotoListCustomizationAECamera.e(this.jdField_a_of_type_ComTencentAelightCameraAioeditorPhotoListCustomizationAECamera).a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.PhotoListCustomizationAECamera.2
 * JD-Core Version:    0.7.0.1
 */