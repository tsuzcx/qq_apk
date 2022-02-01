package com.tencent.aelight.camera.aioeditor.capture.paster;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.util.LocationPermissionHelper.LocationPermissionCallback;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;

class PasterDataManager$3
  implements LocationPermissionHelper.LocationPermissionCallback
{
  PasterDataManager$3(PasterDataManager paramPasterDataManager, boolean paramBoolean) {}
  
  public void onGetLocation()
  {
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new PasterDataManager.3.1(this, "NewStoryTakeVideoActivity"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.PasterDataManager.3
 * JD-Core Version:    0.7.0.1
 */