package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.common.gson.annotations.SerializedName;
import com.tencent.lbssearch.httpresponse.AdInfo;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public final class Address2GeoResultObject$Address2GeoResult
{
  public AdInfo ad_info;
  public AddressComponent address_components;
  public float deviation;
  @SerializedName("location")
  public LatLng latLng;
  public int level;
  public int reliability;
  public float similarity;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.lbssearch.object.result.Address2GeoResultObject.Address2GeoResult
 * JD-Core Version:    0.7.0.1
 */