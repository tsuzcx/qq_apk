package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.common.gson.annotations.SerializedName;
import com.tencent.lbssearch.httpresponse.AdInfo;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class SearchResultObject$SearchResultData
{
  public AdInfo ad_info;
  public String address;
  public String category;
  public String id;
  @SerializedName("location")
  public LatLng latLng;
  public SearchResultObject.SearchResultData.Pano pano;
  public String tel;
  public String title;
  public String type;
  
  public SearchResultObject$SearchResultData(SearchResultObject paramSearchResultObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.lbssearch.object.result.SearchResultObject.SearchResultData
 * JD-Core Version:    0.7.0.1
 */