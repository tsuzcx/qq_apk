package com.tencent.lbssearch.httpresponse;

import com.tencent.lbssearch.common.gson.annotations.SerializedName;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class Poi
{
  public float _distance;
  public String address;
  public String category;
  public String id;
  @SerializedName("location")
  public LatLng latLng;
  public String title;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.lbssearch.httpresponse.Poi
 * JD-Core Version:    0.7.0.1
 */