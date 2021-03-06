package com.tencent.lbssearch.object.param;

import android.text.TextUtils;
import com.tencent.lbssearch.object.result.TransitResultObject;
import com.tencent.map.sdk.a.fn;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class TransitParam
  extends RoutePlanningParam
{
  private String a;
  private long b;
  
  public TransitParam() {}
  
  public TransitParam(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    super(paramLatLng1, paramLatLng2);
  }
  
  public fn buildParameters()
  {
    fn localfn = super.buildParameters();
    if (!TextUtils.isEmpty(this.a)) {
      localfn.a("policy", this.a);
    }
    long l = this.b;
    if (l > 0L) {
      localfn.a("departure_time", l);
    }
    return localfn;
  }
  
  public TransitParam departureTime(long paramLong)
  {
    this.b = paramLong;
    return this;
  }
  
  public Class<TransitResultObject> getResultClass()
  {
    return TransitResultObject.class;
  }
  
  public String getUrl()
  {
    return "https://apis.map.qq.com/ws/direction/v1/transit";
  }
  
  public TransitParam policy(RoutePlanningParam.TransitPolicy paramTransitPolicy)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramTransitPolicy != null) {
      localStringBuilder.append(paramTransitPolicy.name());
    }
    this.a = localStringBuilder.toString();
    return this;
  }
  
  public TransitParam policy(TransitParam.Policy paramPolicy, TransitParam.Preference... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramPolicy != null) {
      localStringBuilder.append(paramPolicy.name());
    }
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        paramPolicy = paramVarArgs[i];
        localStringBuilder.append(",");
        localStringBuilder.append(paramPolicy.name());
        i += 1;
      }
    }
    this.a = localStringBuilder.toString();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.lbssearch.object.param.TransitParam
 * JD-Core Version:    0.7.0.1
 */