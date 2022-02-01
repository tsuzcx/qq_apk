package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.common.gson.annotations.SerializedName;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class SuggestionResultObject$SuggestionData
{
  public float _distance;
  public String adcode;
  public String address;
  public String city;
  public String district;
  public String id;
  @SerializedName("location")
  public LatLng latLng;
  public String province;
  public String title;
  public int type;
  
  public SuggestionResultObject$SuggestionData(SuggestionResultObject paramSuggestionResultObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.lbssearch.object.result.SuggestionResultObject.SuggestionData
 * JD-Core Version:    0.7.0.1
 */