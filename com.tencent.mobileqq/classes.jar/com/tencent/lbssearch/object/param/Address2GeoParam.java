package com.tencent.lbssearch.object.param;

import android.text.TextUtils;
import com.tencent.map.sdk.a.fn;

public class Address2GeoParam
  implements ParamObject
{
  private String a;
  private String b;
  
  public Address2GeoParam() {}
  
  public Address2GeoParam(String paramString)
  {
    this.a = paramString;
  }
  
  public Address2GeoParam address(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public fn buildParameters()
  {
    fn localfn = new fn();
    if (!TextUtils.isEmpty(this.a)) {
      localfn.b("address", this.a);
    }
    if (!TextUtils.isEmpty(this.b)) {
      localfn.b("region", this.b);
    }
    return localfn;
  }
  
  public boolean checkParams()
  {
    return !TextUtils.isEmpty(this.a);
  }
  
  public Address2GeoParam region(String paramString)
  {
    this.b = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.lbssearch.object.param.Address2GeoParam
 * JD-Core Version:    0.7.0.1
 */