package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.os.Bundle;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import java.io.Serializable;
import java.util.List;

class PhotoListLogicAECamera$3$1
  implements Runnable
{
  PhotoListLogicAECamera$3$1(PhotoListLogicAECamera.3 param3, List paramList, long paramLong, LocalMediaInfo paramLocalMediaInfo) {}
  
  public void run()
  {
    if (!((NewPhotoListActivity)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumlogicImpPhotoListLogicAECamera$3.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumlogicImpPhotoListLogicAECamera.mActivity).isFinishing())
    {
      ((NewPhotoListActivity)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumlogicImpPhotoListLogicAECamera$3.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumlogicImpPhotoListLogicAECamera.mActivity).cancleProgressDailog();
      Bundle localBundle = new Bundle();
      localBundle.putString("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumlogicImpPhotoListLogicAECamera$3.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path);
      localBundle.putBoolean("KEY_FROM_PIC_TO_VIDEO", true);
      localBundle.putSerializable("KEY_VIDEO_STORY_CAPTYRE_FRAMES", (Serializable)this.jdField_a_of_type_JavaUtilList);
      localBundle.putLong("KEY_VIDEO_STORY_CAPTYRE_FRAMES_SIZE", this.jdField_a_of_type_Long);
      PhotoListLogicAECamera.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumlogicImpPhotoListLogicAECamera$3.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumlogicImpPhotoListLogicAECamera, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListLogicAECamera.3.1
 * JD-Core Version:    0.7.0.1
 */