package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.biz.videostory.video.FrameVideoHelper.GetFrameByteArrayListener;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import java.util.ArrayList;

class PhotoListLogicAECamera$2$1
  implements FrameVideoHelper.GetFrameByteArrayListener
{
  PhotoListLogicAECamera$2$1(PhotoListLogicAECamera.2 param2, LocalMediaInfo paramLocalMediaInfo, FrameVideoHelper paramFrameVideoHelper) {}
  
  public void a(boolean paramBoolean, ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, long paramLong)
  {
    ((NewPhotoListActivity)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumlogicImpPhotoListLogicAECamera$2.a.mActivity).cancleProgressDailog();
    Bundle localBundle = new Bundle();
    localBundle.putLong("KEY_VIDEO_STORY_CAPTYRE_FRAMES_SIZE", paramLong);
    localBundle.putBoolean("VIDEO_STORY_PHOTO_LIST_TO_EDIT", true);
    localBundle.putSerializable("KEY_VIDEO_STORY_CAPTYRE_FRAMES", paramArrayList);
    ((NewPhotoListActivity)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumlogicImpPhotoListLogicAECamera$2.a.mActivity).getIntent().putExtra("VIDEO_STORY_MEDIA_TYPE", 100);
    PhotoListLogicAECamera.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumlogicImpPhotoListLogicAECamera$2.a, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, localBundle);
    this.jdField_a_of_type_ComTencentBizVideostoryVideoFrameVideoHelper.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListLogicAECamera.2.1
 * JD-Core Version:    0.7.0.1
 */