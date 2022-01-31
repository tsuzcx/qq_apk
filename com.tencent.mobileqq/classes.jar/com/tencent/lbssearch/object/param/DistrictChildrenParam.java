package com.tencent.lbssearch.object.param;

import com.tencent.map.sdk.a.fn;

public class DistrictChildrenParam
  implements ParamObject
{
  private int a;
  
  public fn buildParameters()
  {
    fn localfn = new fn();
    if (this.a > 0) {
      localfn.b("id", String.valueOf(this.a));
    }
    return localfn;
  }
  
  public boolean checkParams()
  {
    return true;
  }
  
  public DistrictChildrenParam id(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.lbssearch.object.param.DistrictChildrenParam
 * JD-Core Version:    0.7.0.1
 */