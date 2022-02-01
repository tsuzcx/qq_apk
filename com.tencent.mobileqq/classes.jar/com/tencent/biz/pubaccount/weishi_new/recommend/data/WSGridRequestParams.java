package com.tencent.biz.pubaccount.weishi_new.recommend.data;

import UserGrowth.stExposureFeedInfo;
import android.text.TextUtils;
import java.util.ArrayList;

public class WSGridRequestParams
{
  private final boolean a;
  private final boolean b;
  private final boolean c;
  private final long d;
  private String e;
  private String f;
  private String g;
  private String h;
  private ArrayList<stExposureFeedInfo> i;
  
  public WSGridRequestParams(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.a = paramBoolean1;
    this.b = paramBoolean2;
    this.c = paramBoolean3;
    this.d = System.currentTimeMillis();
  }
  
  public WSGridRequestParams a(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public WSGridRequestParams a(ArrayList<stExposureFeedInfo> paramArrayList)
  {
    this.i = paramArrayList;
    return this;
  }
  
  public String a()
  {
    return this.e;
  }
  
  public WSGridRequestParams b(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public boolean b()
  {
    return this.a;
  }
  
  public WSGridRequestParams c(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public boolean c()
  {
    return this.b;
  }
  
  public WSGridRequestParams d(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public boolean d()
  {
    return this.c;
  }
  
  public String e()
  {
    return this.f;
  }
  
  public String f()
  {
    return this.g;
  }
  
  public ArrayList<String> g()
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(this.h)) {
      localArrayList.add(this.h);
    }
    return localArrayList;
  }
  
  public long h()
  {
    return this.d;
  }
  
  public ArrayList<stExposureFeedInfo> i()
  {
    return this.i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WSGridRequestParams{mIsRefresh=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mIsFirstFromService=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mIsRedDotCacheValid=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mStartLoadTimestamp=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mSubTabId='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mPushInfo='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mRowKey='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mLastFeedId='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.data.WSGridRequestParams
 * JD-Core Version:    0.7.0.1
 */