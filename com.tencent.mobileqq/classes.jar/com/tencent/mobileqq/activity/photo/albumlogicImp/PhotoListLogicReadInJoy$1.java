package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner.OnMediaInfoScannerListener;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import dov.com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback;
import java.util.ArrayList;

class PhotoListLogicReadInJoy$1
  implements MediaScanner.OnMediaInfoScannerListener
{
  PhotoListLogicReadInJoy$1(PhotoListLogicReadInJoy paramPhotoListLogicReadInJoy, Intent paramIntent, ArrayList paramArrayList) {}
  
  public void onMediaInfoChanged(LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean)
  {
    ((NewPhotoListActivity)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumlogicImpPhotoListLogicReadInJoy.mActivity).cancleProgressDailog();
    if (QQStoryFlowCallback.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumlogicImpPhotoListLogicReadInJoy.mActivity, paramLocalMediaInfo))
    {
      this.jdField_a_of_type_AndroidContentIntent.putExtra("media_info", paramLocalMediaInfo);
      PhotoUtils.sendPhoto(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumlogicImpPhotoListLogicReadInJoy.mActivity, this.jdField_a_of_type_AndroidContentIntent, this.jdField_a_of_type_JavaUtilArrayList, 2, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListLogicReadInJoy.1
 * JD-Core Version:    0.7.0.1
 */