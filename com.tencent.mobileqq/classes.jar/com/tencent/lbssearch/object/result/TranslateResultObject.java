package com.tencent.lbssearch.object.result;

import com.tencent.lbssearch.common.gson.annotations.SerializedName;
import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

public class TranslateResultObject
  extends BaseObject
{
  @SerializedName("locations")
  public List<LatLng> latLngs;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.lbssearch.object.result.TranslateResultObject
 * JD-Core Version:    0.7.0.1
 */