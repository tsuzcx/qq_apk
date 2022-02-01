package com.tencent.biz.qqstory.takevideo;

import android.os.Handler;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager;
import com.tencent.biz.qqstory.utils.LocationUtils;
import com.tencent.mobileqq.richmedia.capture.util.LocationPermissionHelper.LocationPermissionCallback;

class EditVideoDoodle$3
  implements LocationPermissionHelper.LocationPermissionCallback
{
  EditVideoDoodle$3(EditVideoDoodle paramEditVideoDoodle) {}
  
  public void onGetLocation()
  {
    this.a.jdField_a_of_type_Boolean = false;
    this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(this.a.jdField_a_of_type_JavaLangRunnable, 10000L);
    ((DoodleEmojiManager)SuperManager.a(8)).a(LocationUtils.a(this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a), this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleModelDoodleEmojiManager$POIPostersRequestCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoDoodle.3
 * JD-Core Version:    0.7.0.1
 */