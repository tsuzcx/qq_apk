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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c);
    localfn.b("region_fix", localStringBuilder.toString());
    if (this.d != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.d.latitude);
      localStringBuilder.append(",");
      localStringBuilder.append(this.d.longitude);
      localfn.b("location", localStringBuilder.toString());
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.e);
    localfn.b("get_subpois", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.f);
    localfn.b("policy", localStringBuilder.toString());
    if (!TextUtils.isEmpty(this.h)) {
      localfn.b("address_format", this.h);
    }
    int k = this.i;
    if ((k > 0) && (k <= 20))
    {
      k = this.j;
      if ((k > 0) && (k <= 20))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.i);
        localfn.b("page_index", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.j);
        localfn.b("page_size", localStringBuilder.toString());
      }
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
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
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.lbssearch.object.param.SuggestionParam
 * JD-Core Version:    0.7.0.1
 */