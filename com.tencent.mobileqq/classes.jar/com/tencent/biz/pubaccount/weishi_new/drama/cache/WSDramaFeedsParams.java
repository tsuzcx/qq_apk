package com.tencent.biz.pubaccount.weishi_new.drama.cache;

import UserGrowth.stDramaFeed;
import com.tencent.biz.pubaccount.weishi_new.data.FetcherParams;
import java.util.Map;

public class WSDramaFeedsParams
  extends FetcherParams
{
  private final String a;
  private String b;
  private int c;
  private int d;
  private String e;
  private Map<Integer, stDramaFeed> f;
  private boolean g;
  private boolean h;
  
  public WSDramaFeedsParams(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(Map<Integer, stDramaFeed> paramMap)
  {
    this.f = paramMap;
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.a;
  }
  
  public String e()
  {
    return this.b;
  }
  
  public Map<Integer, stDramaFeed> f()
  {
    return this.f;
  }
  
  public int g()
  {
    return this.d;
  }
  
  public String h()
  {
    return this.e;
  }
  
  public boolean i()
  {
    return this.g;
  }
  
  public boolean j()
  {
    return this.h;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WSDramaFeedsParams{dramaId='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", feedId='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", episodeNum=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", direction=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", attachInfo='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", dramaFeedMap=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", isPreloadData=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", isUpdateNum=");
    localStringBuilder.append(this.h);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.cache.WSDramaFeedsParams
 * JD-Core Version:    0.7.0.1
 */