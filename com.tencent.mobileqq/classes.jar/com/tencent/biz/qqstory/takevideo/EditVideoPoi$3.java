package com.tencent.biz.qqstory.takevideo;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.util.LocationPermissionHelper.LocationPermissionCallback;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;

class EditVideoPoi$3
  implements LocationPermissionHelper.LocationPermissionCallback
{
  EditVideoPoi$3(EditVideoPoi paramEditVideoPoi, boolean paramBoolean) {}
  
  public void onGetLocation()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoi.a = new EditVideoPoi.3.1(this, "NewStoryTakeVideoActivity");
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoi.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoPoi.3
 * JD-Core Version:    0.7.0.1
 */