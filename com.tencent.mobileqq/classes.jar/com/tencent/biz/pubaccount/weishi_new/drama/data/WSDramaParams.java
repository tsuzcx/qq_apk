package com.tencent.biz.pubaccount.weishi_new.drama.data;

import com.tencent.biz.pubaccount.weishi_new.data.FetcherParams;

public class WSDramaParams
  extends FetcherParams
{
  private final String a;
  
  public WSDramaParams(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    super(paramBoolean1, paramBoolean2);
    this.a = paramString;
  }
  
  public String c()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaParams
 * JD-Core Version:    0.7.0.1
 */