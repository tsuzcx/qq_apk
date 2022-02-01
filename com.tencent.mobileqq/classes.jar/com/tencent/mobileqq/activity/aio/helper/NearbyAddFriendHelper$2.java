package com.tencent.mobileqq.activity.aio.helper;

import android.util.Pair;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.mobileqq.pb.PBStringField;
import nearby.nearbyLivebarSvr.nearbyLivebarSvr.GetLiveBarStatusRequest;

class NearbyAddFriendHelper$2
  implements TencentLocationListener
{
  NearbyAddFriendHelper$2(NearbyAddFriendHelper paramNearbyAddFriendHelper, GetLiveBarStatusRequest paramGetLiveBarStatusRequest, TencentLocationManager paramTencentLocationManager) {}
  
  public void onLocationChanged(TencentLocation paramTencentLocation, int paramInt, String paramString)
  {
    if ((paramTencentLocation != null) && (paramInt == 0))
    {
      paramString = String.valueOf(paramTencentLocation.getLongitude());
      paramTencentLocation = String.valueOf(paramTencentLocation.getLatitude());
      NearbyAddFriendHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperNearbyAddFriendHelper, new Pair(paramString, paramTencentLocation));
      this.jdField_a_of_type_NearbyNearbyLivebarSvrNearbyLivebarSvrGetLiveBarStatusRequest.longitude.set(paramString);
      this.jdField_a_of_type_NearbyNearbyLivebarSvrNearbyLivebarSvrGetLiveBarStatusRequest.latitude.set(paramTencentLocation);
    }
    else
    {
      this.jdField_a_of_type_NearbyNearbyLivebarSvrNearbyLivebarSvrGetLiveBarStatusRequest.latitude.set("0");
      this.jdField_a_of_type_NearbyNearbyLivebarSvrNearbyLivebarSvrGetLiveBarStatusRequest.longitude.set("0");
    }
    NearbyAddFriendHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperNearbyAddFriendHelper, this.jdField_a_of_type_NearbyNearbyLivebarSvrNearbyLivebarSvrGetLiveBarStatusRequest);
    this.jdField_a_of_type_ComTencentMapGeolocationTencentLocationManager.removeUpdates(this);
  }
  
  public void onStatusUpdate(String paramString1, int paramInt, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.NearbyAddFriendHelper.2
 * JD-Core Version:    0.7.0.1
 */