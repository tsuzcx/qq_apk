package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.common.gson.annotations.SerializedName;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class SuggestionResultObject$SubPoi
{
  public String adcode;
  public String address;
  public String city;
  public String id;
  @SerializedName("location")
  public LatLng latLng;
  public String parent_id;
  public String title;
  
  public SuggestionResultObject$SubPoi(SuggestionResultObject paramSuggestionResultObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.lbssearch.object.result.SuggestionResultObject.SubPoi
 * JD-Core Version:    0.7.0.1
 */