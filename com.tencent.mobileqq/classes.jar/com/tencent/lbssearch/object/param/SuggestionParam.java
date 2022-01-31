package com.tencent.lbssearch.object.param;

import android.text.TextUtils;
import com.tencent.map.sdk.a.dh;
import com.tencent.map.sdk.a.fn;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class SuggestionParam
  implements ParamObject
{
  private String a;
  private String b;
  private int c;
  private LatLng d;
  private int e;
  private int f;
  private String g;
  private String h;
  private int i;
  private int j;
  
  public SuggestionParam() {}
  
  public SuggestionParam(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public SuggestionParam addressFormat(SuggestionParam.AddressFormat paramAddressFormat)
  {
    this.h = paramAddressFormat.value;
    return this;
  }
  
  public fn buildParameters()
  {
    fn localfn = new fn();
    if (!TextUtils.isEmpty(this.a)) {
      localfn.b("keyword", this.a);
    }
    if (!TextUtils.isEmpty(this.b)) {
      localfn.b("region", this.b);
    }
    if (!TextUtils.isEmpty(this.g)) {
      localfn.b("filter", this.g);
    }
    localfn.b("region_fix", this.c);
    if (this.d != null) {
      localfn.b("location", this.d.latitude + "," + this.d.longitude);
    }
    localfn.b("get_subpois", this.e);
    localfn.b("policy", this.f);
    if (!TextUtils.isEmpty(this.h)) {
      localfn.b("address_format", this.h);
    }
    if ((this.i > 0) && (this.i <= 20) && (this.j > 0) && (this.j <= 20))
    {
      localfn.b("page_index", this.i);
      localfn.b("page_size", this.j);
    }
    return localfn;
  }
  
  public boolean checkParams()
  {
    return (!TextUtils.isEmpty(this.a)) && (!TextUtils.isEmpty(this.b));
  }
  
  public SuggestionParam filter(String... paramVarArgs)
  {
    this.g = dh.a(paramVarArgs);
    return this;
  }
  
  public SuggestionParam getSubPois(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int k = 1;; k = 0)
    {
      this.e = k;
      return this;
    }
  }
  
  public SuggestionParam keyword(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public SuggestionParam location(LatLng paramLatLng)
  {
    this.d = paramLatLng;
    return this;
  }
  
  public SuggestionParam pageIndex(int paramInt)
  {
    this.i = paramInt;
    return this;
  }
  
  public SuggestionParam pageSize(int paramInt)
  {
    this.j = paramInt;
    return this;
  }
  
  public SuggestionParam policy(SuggestionParam.Policy paramPolicy)
  {
    this.f = paramPolicy.value;
    return this;
  }
  
  public SuggestionParam region(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public SuggestionParam regionFix(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int k = 1;; k = 0)
    {
      this.c = k;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.lbssearch.object.param.SuggestionParam
 * JD-Core Version:    0.7.0.1
 */