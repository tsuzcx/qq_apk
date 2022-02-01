package com.tencent.lbssearch.object.param;

import android.text.TextUtils;
import com.tencent.map.sdk.a.fn;

public class DistrictSearchParam
  implements ParamObject
{
  private String a;
  
  public DistrictSearchParam() {}
  
  public DistrictSearchParam(String paramString)
  {
    this.a = paramString;
  }
  
  public fn buildParameters()
  {
    fn localfn = new fn();
    if (!TextUtils.isEmpty(this.a)) {
      localfn.b("keyword", this.a);
    }
    return localfn;
  }
  
  public boolean checkParams()
  {
    return !TextUtils.isEmpty(this.a);
  }
  
  public DistrictSearchParam keyword(String paramString)
  {
    this.a = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.lbssearch.object.param.DistrictSearchParam
 * JD-Core Version:    0.7.0.1
 */