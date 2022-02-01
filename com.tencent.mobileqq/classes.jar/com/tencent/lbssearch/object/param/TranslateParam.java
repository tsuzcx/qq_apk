package com.tencent.lbssearch.object.param;

import com.tencent.map.sdk.a.fn;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;

public class TranslateParam
  implements ParamObject
{
  private List<LatLng> a;
  private TranslateParam.CoordType b = TranslateParam.CoordType.STANDARD;
  
  public TranslateParam addLocation(LatLng paramLatLng)
  {
    if (this.a == null) {
      this.a = new ArrayList();
    }
    this.a.add(paramLatLng);
    return this;
  }
  
  public fn buildParameters()
  {
    fn localfn = new fn();
    Object localObject = this.a;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      int i = 0;
      while (i < this.a.size())
      {
        localObject = "";
        if (i != 0)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("");
          ((StringBuilder)localObject).append(";");
          localObject = ((StringBuilder)localObject).toString();
        }
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append((String)localObject);
        localStringBuilder2.append(((LatLng)this.a.get(i)).latitude);
        localStringBuilder2.append(",");
        localStringBuilder2.append(((LatLng)this.a.get(i)).longitude);
        localStringBuilder1.append(localStringBuilder2.toString());
        i += 1;
      }
      localfn.b("locations", localStringBuilder1.toString());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.b.ordinal());
    localfn.b("type", ((StringBuilder)localObject).toString());
    return localfn;
  }
  
  public boolean checkParams()
  {
    return this.a != null;
  }
  
  public TranslateParam coordType(TranslateParam.CoordType paramCoordType)
  {
    this.b = paramCoordType;
    return this;
  }
  
  public TranslateParam coord_type(CoordTypeEnum paramCoordTypeEnum)
  {
    coordType(paramCoordTypeEnum.coordType);
    return this;
  }
  
  public TranslateParam locations(LatLng... paramVarArgs)
  {
    if (this.a == null) {
      this.a = new ArrayList();
    }
    int i = 0;
    while (i < paramVarArgs.length)
    {
      this.a.add(paramVarArgs[i]);
      i += 1;
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.lbssearch.object.param.TranslateParam
 * JD-Core Version:    0.7.0.1
 */