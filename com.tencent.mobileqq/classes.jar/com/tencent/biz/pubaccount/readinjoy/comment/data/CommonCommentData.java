package com.tencent.biz.pubaccount.readinjoy.comment.data;

import java.io.Serializable;

public class CommonCommentData
  implements Serializable
{
  private int adTag = -1;
  private String articleId = "";
  private long biuDuration = -1L;
  private String biuPicUrl = "";
  private String biuSourceName = "";
  private String biuTitle = "";
  private String feedsId = "";
  private int feedsType = -1;
  
  public CommonCommentData() {}
  
  public CommonCommentData(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, String paramString5, long paramLong)
  {
    this.articleId = paramString1;
    this.feedsType = paramInt1;
    this.feedsId = paramString2;
    this.adTag = paramInt2;
    this.biuTitle = paramString3;
    this.biuSourceName = paramString4;
    this.biuPicUrl = paramString5;
    this.biuDuration = paramLong;
  }
  
  public int getAdTag()
  {
    return this.adTag;
  }
  
  public String getArticleId()
  {
    return this.articleId;
  }
  
  public long getBiuDuration()
  {
    return this.biuDuration;
  }
  
  public String getBiuPicUrl()
  {
    return this.biuPicUrl;
  }
  
  public String getBiuSourceName()
  {
    return this.biuSourceName;
  }
  
  public String getBiuTitle()
  {
    return this.biuTitle;
  }
  
  public String getFeedsId()
  {
    return this.feedsId;
  }
  
  public int getFeedsType()
  {
    return this.feedsType;
  }
  
  public void setAdTag(int paramInt)
  {
    this.adTag = paramInt;
  }
  
  public void setArticleId(String paramString)
  {
    this.articleId = paramString;
  }
  
  public void setBiuDuration(long paramLong)
  {
    this.biuDuration = paramLong;
  }
  
  public void setBiuPicUrl(String paramString)
  {
    this.biuPicUrl = paramString;
  }
  
  public void setBiuSourceName(String paramString)
  {
    this.biuSourceName = paramString;
  }
  
  public void setBiuTitle(String paramString)
  {
    this.biuTitle = paramString;
  }
  
  public void setFeedsId(String paramString)
  {
    this.feedsId = paramString;
  }
  
  public void setFeedsType(int paramInt)
  {
    this.feedsType = paramInt;
  }
  
  public String toString()
  {
    return "CommonCommentData{feedsType=" + this.feedsType + ", feedsId='" + this.feedsId + '\'' + ", adTag=" + this.adTag + ", articleId='" + this.articleId + '\'' + ", biuTitle='" + this.biuTitle + '\'' + ", biuSourceName='" + this.biuSourceName + '\'' + ", biuPicUrl='" + this.biuPicUrl + '\'' + ", biuDuration=" + this.biuDuration + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.CommonCommentData
 * JD-Core Version:    0.7.0.1
 */