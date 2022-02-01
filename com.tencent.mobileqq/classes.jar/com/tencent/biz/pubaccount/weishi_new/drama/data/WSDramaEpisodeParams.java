package com.tencent.biz.pubaccount.weishi_new.drama.data;

import com.tencent.biz.pubaccount.weishi_new.data.FetcherParams;

public class WSDramaEpisodeParams
  extends FetcherParams
{
  private final String a;
  private final String b;
  private final boolean c;
  
  public WSDramaEpisodeParams(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, boolean paramBoolean3)
  {
    super(paramBoolean1, paramBoolean2);
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramBoolean3;
  }
  
  public String c()
  {
    return this.a;
  }
  
  public String d()
  {
    return this.b;
  }
  
  public boolean e()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaEpisodeParams
 * JD-Core Version:    0.7.0.1
 */