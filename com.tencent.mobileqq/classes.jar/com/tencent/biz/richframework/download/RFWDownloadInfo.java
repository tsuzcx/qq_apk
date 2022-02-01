package com.tencent.biz.richframework.download;

public class RFWDownloadInfo
{
  private long mDownloadedLength;
  private String mFilePath;
  private String mMD5;
  private String mTmpFilePath;
  private long mTotalContentLength;
  private String mUrl;
  
  public long getDownedLength()
  {
    return this.mDownloadedLength;
  }
  
  public String getFilePath()
  {
    return this.mFilePath;
  }
  
  public String getMD5()
  {
    return this.mMD5;
  }
  
  public String getTmpFilePath()
  {
    return this.mTmpFilePath;
  }
  
  public long getTotalContentLength()
  {
    return this.mTotalContentLength;
  }
  
  public String getUrl()
  {
    return this.mUrl;
  }
  
  public void setDownloadedLength(long paramLong)
  {
    this.mDownloadedLength = paramLong;
  }
  
  public void setFilePath(String paramString)
  {
    this.mFilePath = paramString;
  }
  
  public void setMD5(String paramString)
  {
    this.mMD5 = paramString;
  }
  
  public void setTmpFilePath(String paramString)
  {
    this.mTmpFilePath = paramString;
  }
  
  public void setTotalContentLength(long paramLong)
  {
    this.mTotalContentLength = paramLong;
  }
  
  public void setUrl(String paramString)
  {
    this.mUrl = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.download.RFWDownloadInfo
 * JD-Core Version:    0.7.0.1
 */