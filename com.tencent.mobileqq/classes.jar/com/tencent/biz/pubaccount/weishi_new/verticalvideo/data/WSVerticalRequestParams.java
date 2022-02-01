package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data;

import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public class WSVerticalRequestParams
{
  private final int a;
  private final boolean b;
  private final boolean c;
  private String d = "";
  private String e = "";
  private Object f;
  private ArrayList<String> g;
  
  public WSVerticalRequestParams(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramInt;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public WSVerticalRequestParams a(Object paramObject)
  {
    this.f = paramObject;
    return this;
  }
  
  public WSVerticalRequestParams a(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public WSVerticalRequestParams a(ArrayList<String> paramArrayList)
  {
    this.g = paramArrayList;
    return this;
  }
  
  public WSVerticalRequestParams b(String paramString)
  {
    if (!this.c) {
      paramString = "";
    }
    this.d = paramString;
    return this;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public boolean c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.e;
  }
  
  public String e()
  {
    return this.d;
  }
  
  public Object f()
  {
    return this.f;
  }
  
  public ArrayList<String> g()
  {
    return this.g;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WSVerticalRequestParams{mScene=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mIsRefresh=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mIsFirst=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mPushInfo='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mContextFeedIds=");
    localStringBuilder.append(this.g);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalRequestParams
 * JD-Core Version:    0.7.0.1
 */