package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data;

import com.tencent.biz.pubaccount.weishi_new.data.FetcherParams;

public class WSCollectionRequestParams
  extends FetcherParams
{
  public boolean a;
  public boolean b;
  public String c = "";
  public String d = "";
  public int e = 0;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WSCollectionRequestParams{isFirst=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", isRefresh=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", cid='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", feedId='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pageOrder=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSCollectionRequestParams
 * JD-Core Version:    0.7.0.1
 */