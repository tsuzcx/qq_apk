package com.tencent.lbssearch.object.param;

import android.text.TextUtils;
import com.tencent.lbssearch.object.result.DrivingResultObject;
import com.tencent.map.sdk.a.fn;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DrivingParam
  extends RoutePlanningParam
{
  private List<LatLng> a = new ArrayList();
  private String b;
  private String c;
  private String d;
  private String e;
  private int f = -1;
  private int g = -1;
  private int h = -1;
  private DrivingParam.RoadType i = DrivingParam.RoadType.DEF;
  private DrivingParam.Travel j;
  
  public DrivingParam() {}
  
  public DrivingParam(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    super(paramLatLng1, paramLatLng2);
  }
  
  public DrivingParam accuracy(int paramInt)
  {
    this.h = paramInt;
    return this;
  }
  
  public DrivingParam addWayPoint(LatLng paramLatLng)
  {
    if (this.a.size() < 10) {
      this.a.add(paramLatLng);
    }
    return this;
  }
  
  public DrivingParam addWayPoints(Iterable<LatLng> paramIterable)
  {
    if (paramIterable != null)
    {
      int k = 0;
      paramIterable = paramIterable.iterator();
      int m;
      do
      {
        if (!paramIterable.hasNext()) {
          break;
        }
        LatLng localLatLng = (LatLng)paramIterable.next();
        this.a.add(localLatLng);
        m = k + 1;
        k = m;
      } while (m <= 10);
    }
    return this;
  }
  
  public fn buildParameters()
  {
    fn localfn = super.buildParameters();
    if (!TextUtils.isEmpty(this.d)) {
      localfn.a("from_poi", this.d);
    }
    if (!TextUtils.isEmpty(this.e)) {
      localfn.a("to_poi", this.e);
    }
    int k = this.f;
    if (k != -1) {
      localfn.a("heading", k);
    }
    k = this.g;
    if (k != -1) {
      localfn.a("speed", k);
    }
    k = this.h;
    if (k != -1) {
      localfn.a("accuracy", k);
    }
    localfn.a("road_type", this.i.ordinal());
    Object localObject = this.j;
    if ((localObject != null) && (((DrivingParam.Travel)localObject).points.size() > 0)) {
      localfn.a("from_track", this.j.toString());
    }
    if (this.a.size() > 0)
    {
      localObject = new StringBuilder();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        ((StringBuilder)localObject).append(a((LatLng)localIterator.next()));
        ((StringBuilder)localObject).append(";");
      }
      ((StringBuilder)localObject).setLength(((StringBuilder)localObject).length() - 1);
      localfn.a("waypoints", ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(this.b)) {
      localfn.a("policy", this.b);
    }
    if (!TextUtils.isEmpty(this.c)) {
      localfn.a("plate_number", this.c);
    }
    return localfn;
  }
  
  public DrivingParam fromPOI(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public DrivingParam fromTravel(DrivingParam.Travel paramTravel)
  {
    this.j = paramTravel;
    return this;
  }
  
  public Class<DrivingResultObject> getResultClass()
  {
    return DrivingResultObject.class;
  }
  
  public String getUrl()
  {
    return "https://apis.map.qq.com/ws/direction/v1/driving";
  }
  
  public DrivingParam heading(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  public DrivingParam policy(DrivingParam.Policy paramPolicy, DrivingParam.Preference... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramPolicy != null) {
      localStringBuilder.append(paramPolicy.name());
    }
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      int m = paramVarArgs.length;
      int k = 0;
      while (k < m)
      {
        paramPolicy = paramVarArgs[k];
        localStringBuilder.append(",");
        localStringBuilder.append(paramPolicy.name());
        k += 1;
      }
    }
    this.b = localStringBuilder.toString();
    return this;
  }
  
  public DrivingParam policy(RoutePlanningParam.DrivingPolicy paramDrivingPolicy)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramDrivingPolicy != null) {
      localStringBuilder.append(paramDrivingPolicy.name());
    }
    this.b = localStringBuilder.toString();
    return this;
  }
  
  public DrivingParam roadType(DrivingParam.RoadType paramRoadType)
  {
    this.i = paramRoadType;
    return this;
  }
  
  public DrivingParam setCarNumber(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public void setMultyPlan(boolean paramBoolean) {}
  
  public DrivingParam speed(int paramInt)
  {
    this.g = paramInt;
    return this;
  }
  
  public DrivingParam toPOI(String paramString)
  {
    this.e = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.lbssearch.object.param.DrivingParam
 * JD-Core Version:    0.7.0.1
 */