package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import dov.com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback;
import java.util.ArrayList;

class PhotoListLogicAECamera$2
  implements MediaScanner.OnMediaInfoScannerListener
{
  PhotoListLogicAECamera$2(PhotoListLogicAECamera paramPhotoListLogicAECamera, Intent paramIntent, ArrayList paramArrayList) {}
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    if (QQStoryFlowCallback.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumlogicImpPhotoListLogicAECamera.mActivity, paramLocalMediaInfo))
    {
      if ((PhotoListLogicAECamera.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumlogicImpPhotoListLogicAECamera) != null) && (paramLocalMediaInfo.mDuration > PhotoListLogicAECamera.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumlogicImpPhotoListLogicAECamera).videoDurationLimit))
      {
        ((NewPhotoListActivity)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumlogicImpPhotoListLogicAECamera.mActivity).cancleProgressDailog();
        this.jdField_a_of_type_AndroidContentIntent.putExtra("media_info", paramLocalMediaInfo);
        PhotoUtils.sendPhoto(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumlogicImpPhotoListLogicAECamera.mActivity, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilArrayList, 2, true);
        return;
      }
      FrameVideoHelper localFrameVideoHelper = new FrameVideoHelper(paramLocalMediaInfo.path, paramLocalMediaInfo.mediaWidth, paramLocalMediaInfo.mediaHeight, paramLocalMediaInfo.mDuration);
      localFrameVideoHelper.a(new PhotoListLogicAECamera.2.1(this, paramLocalMediaInfo, localFrameVideoHelper));
      VSReporter.a("mystatus_localupload", "video_select", 0, 0, new String[0]);
      return;
    }
    ((NewPhotoListActivity)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumlogicImpPhotoListLogicAECamera.mActivity).cancleProgressDailog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListLogicAECamera.2
 * JD-Core Version:    0.7.0.1
 */