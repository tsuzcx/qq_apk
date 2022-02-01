package com.tencent.lbssearch;

import com.tencent.lbssearch.object.param.Address2GeoParam;
import com.tencent.lbssearch.object.param.DistrictChildrenParam;
import com.tencent.lbssearch.object.param.DistrictSearchParam;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.lbssearch.object.param.RoutePlanningParam;
import com.tencent.lbssearch.object.param.SearchParam;
import com.tencent.lbssearch.object.param.StreetViewParam;
import com.tencent.lbssearch.object.param.SuggestionParam;
import com.tencent.lbssearch.object.param.TranslateParam;
import com.tencent.map.tools.net.http.HttpResponseListener;

public abstract interface ITencentSearch
{
  public abstract void address2geo(Address2GeoParam paramAddress2GeoParam, HttpResponseListener paramHttpResponseListener);
  
  public abstract void geo2address(Geo2AddressParam paramGeo2AddressParam, HttpResponseListener paramHttpResponseListener);
  
  public abstract void getDistrictChildren(DistrictChildrenParam paramDistrictChildrenParam, HttpResponseListener paramHttpResponseListener);
  
  public abstract void getDistrictList(HttpResponseListener paramHttpResponseListener);
  
  public abstract void getDistrictSearch(DistrictSearchParam paramDistrictSearchParam, HttpResponseListener paramHttpResponseListener);
  
  public abstract void getRoutePlan(RoutePlanningParam paramRoutePlanningParam, HttpResponseListener paramHttpResponseListener);
  
  public abstract void getpano(StreetViewParam paramStreetViewParam, HttpResponseListener paramHttpResponseListener);
  
  public abstract void search(SearchParam paramSearchParam, HttpResponseListener paramHttpResponseListener);
  
  public abstract void suggestion(SuggestionParam paramSuggestionParam, HttpResponseListener paramHttpResponseListener);
  
  public abstract void translate(TranslateParam paramTranslateParam, HttpResponseListener paramHttpResponseListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.lbssearch.ITencentSearch
 * JD-Core Version:    0.7.0.1
 */