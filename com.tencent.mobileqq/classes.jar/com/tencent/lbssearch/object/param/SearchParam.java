package com.tencent.lbssearch.object.param;

import android.text.TextUtils;
import com.tencent.map.sdk.a.dh;
import com.tencent.map.sdk.a.fn;

public class SearchParam
  implements ParamObject
{
  private String a;
  private SearchParam.Boundary b;
  private String c;
  private boolean d = true;
  private int e = -1;
  private int f = 1;
  
  public SearchParam() {}
  
  public SearchParam(String paramString, SearchParam.Boundary paramBoundary)
  {
    this.a = paramString;
    this.b = paramBoundary;
  }
  
  public SearchParam boundary(SearchParam.Boundary paramBoundary)
  {
    this.b = paramBoundary;
    return this;
  }
  
  public fn buildParameters()
  {
    fn localfn = new fn();
    if (!TextUtils.isEmpty(this.a)) {
      localfn.b("keyword", this.a);
    }
    Object localObject = this.b;
    if (localObject != null) {
      localfn.b("boundary", ((SearchParam.Boundary)localObject).toString());
    }
    if (!TextUtils.isEmpty(this.c)) {
      localfn.b("filter", this.c);
    }
    if (this.d) {
      localObject = "_distance";
    } else {
      localObject = "_distance desc";
    }
    localfn.b("orderby", (String)localObject);
    int i = this.e;
    if (i > 0) {
      localfn.b("page_size", String.valueOf(i));
    }
    i = this.f;
    if (i > 0) {
      localfn.b("page_index", String.valueOf(i));
    }
    return localfn;
  }
  
  public boolean checkParams()
  {
    return (!TextUtils.isEmpty(this.a)) && (this.b != null);
  }
  
  public SearchParam filter(String... paramVarArgs)
  {
    this.c = dh.a(paramVarArgs);
    return this;
  }
  
  public SearchParam keyword(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public SearchParam orderby(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public SearchParam pageIndex(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  public SearchParam pageSize(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public SearchParam page_index(int paramInt)
  {
    this.f = paramInt;
    return this;
  }
  
  public SearchParam page_size(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public SearchParam region(SearchParam.Region paramRegion)
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.lbssearch.object.param.SearchParam
 * JD-Core Version:    0.7.0.1
 */