package com.tencent.map.sdk.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.lbssearch.ITencentSearch;
import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.object.param.Address2GeoParam;
import com.tencent.lbssearch.object.param.DistrictChildrenParam;
import com.tencent.lbssearch.object.param.DistrictSearchParam;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.lbssearch.object.param.ParamObject;
import com.tencent.lbssearch.object.param.RoutePlanningParam;
import com.tencent.lbssearch.object.param.SearchParam;
import com.tencent.lbssearch.object.param.StreetViewParam;
import com.tencent.lbssearch.object.param.SuggestionParam;
import com.tencent.lbssearch.object.param.TranslateParam;
import com.tencent.lbssearch.object.result.Address2GeoResultObject;
import com.tencent.lbssearch.object.result.DistrictResultObject;
import com.tencent.lbssearch.object.result.Geo2AddressResultObject;
import com.tencent.lbssearch.object.result.SearchResultObject;
import com.tencent.lbssearch.object.result.StreetViewResultObject;
import com.tencent.lbssearch.object.result.SuggestionResultObject;
import com.tencent.lbssearch.object.result.TranslateResultObject;
import com.tencent.map.tools.net.http.HttpResponseListener;

public final class fr
  implements ITencentSearch
{
  private Context a;
  
  public fr(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private <T extends BaseObject> void a(String paramString, ParamObject paramParamObject, Class<T> paramClass, HttpResponseListener<T> paramHttpResponseListener)
  {
    if ((paramParamObject == null) || (!paramParamObject.checkParams())) {
      or.b("wrong parameter");
    }
    String str;
    do
    {
      return;
      str = pz.a(this.a, "TencentMapSDK");
      if (!TextUtils.isEmpty(str)) {
        break;
      }
    } while (paramHttpResponseListener == null);
    paramHttpResponseListener.onFailure(-1, "请申请并填写开发者密钥", null);
    return;
    paramParamObject = paramParamObject.buildParameters();
    if (paramParamObject != null)
    {
      paramParamObject.b("key", str);
      paramParamObject.b("output", "json");
    }
    for (;;)
    {
      paramParamObject.b("__suid", pz.f(this.a));
      paramParamObject.b("__pf", "android");
      paramParamObject.b("__chan", "search");
      paramParamObject.b("__pid", this.a.getPackageName());
      paramParamObject.b("__psv", pz.d(this.a));
      paramParamObject.b("__ver", "1.1.7");
      fj.a(this.a, paramString, paramParamObject, paramClass, paramHttpResponseListener);
      return;
      paramParamObject = new fn();
    }
  }
  
  public final void address2geo(Address2GeoParam paramAddress2GeoParam, HttpResponseListener paramHttpResponseListener)
  {
    a("https://apis.map.qq.com/ws/geocoder/v1", paramAddress2GeoParam, Address2GeoResultObject.class, paramHttpResponseListener);
  }
  
  public final void geo2address(Geo2AddressParam paramGeo2AddressParam, HttpResponseListener paramHttpResponseListener)
  {
    a("https://apis.map.qq.com/ws/geocoder/v1", paramGeo2AddressParam, Geo2AddressResultObject.class, paramHttpResponseListener);
  }
  
  public final void getDistrictChildren(DistrictChildrenParam paramDistrictChildrenParam, HttpResponseListener paramHttpResponseListener)
  {
    a("https://apis.map.qq.com/ws/district/v1/getchildren", paramDistrictChildrenParam, DistrictResultObject.class, paramHttpResponseListener);
  }
  
  public final void getDistrictList(HttpResponseListener paramHttpResponseListener)
  {
    a("https://apis.map.qq.com/ws/district/v1/list", new DistrictChildrenParam(), DistrictResultObject.class, paramHttpResponseListener);
  }
  
  public final void getDistrictSearch(DistrictSearchParam paramDistrictSearchParam, HttpResponseListener paramHttpResponseListener)
  {
    a("https://apis.map.qq.com/ws/district/v1/search", paramDistrictSearchParam, DistrictResultObject.class, paramHttpResponseListener);
  }
  
  public final void getRoutePlan(RoutePlanningParam paramRoutePlanningParam, HttpResponseListener paramHttpResponseListener)
  {
    a(paramRoutePlanningParam.getUrl(), paramRoutePlanningParam, paramRoutePlanningParam.getResultClass(), paramHttpResponseListener);
  }
  
  public final void getpano(StreetViewParam paramStreetViewParam, HttpResponseListener paramHttpResponseListener)
  {
    a("https://apis.map.qq.com/ws/streetview/v1/getpano", paramStreetViewParam, StreetViewResultObject.class, paramHttpResponseListener);
  }
  
  public final void search(SearchParam paramSearchParam, HttpResponseListener paramHttpResponseListener)
  {
    a("https://apis.map.qq.com/ws/place/v1/search", paramSearchParam, SearchResultObject.class, paramHttpResponseListener);
  }
  
  public final void suggestion(SuggestionParam paramSuggestionParam, HttpResponseListener paramHttpResponseListener)
  {
    a("https://apis.map.qq.com/ws/place/v1/suggestion", paramSuggestionParam, SuggestionResultObject.class, paramHttpResponseListener);
  }
  
  public final void translate(TranslateParam paramTranslateParam, HttpResponseListener paramHttpResponseListener)
  {
    a("https://apis.map.qq.com/ws/coord/v1/translate", paramTranslateParam, TranslateResultObject.class, paramHttpResponseListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.fr
 * JD-Core Version:    0.7.0.1
 */