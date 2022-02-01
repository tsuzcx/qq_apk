package com.tencent.component.network.downloader;

public class RangeDownloadReport
{
  private long contentLength;
  private int rangeId;
  private long timeCost;
  private long timeCostData;
  private long timeCostHeader;
  
  public long getContentLength()
  {
    return this.contentLength;
  }
  
  public int getRangeId()
  {
    return this.rangeId;
  }
  
  public long getTimeCost()
  {
    return this.timeCost;
  }
  
  public long getTimeCostData()
  {
    return this.timeCostData;
  }
  
  public long getTimeCostHeader()
  {
    return this.timeCostHeader;
  }
  
  public void setContentLength(long paramLong)
  {
    this.contentLength = paramLong;
  }
  
  public void setRangeId(int paramInt)
  {
    this.rangeId = paramInt;
  }
  
  public void setTimeCost(long paramLong)
  {
    this.timeCost = paramLong;
  }
  
  public void setTimeCostData(long paramLong)
  {
    this.timeCostData = paramLong;
  }
  
  public void setTimeCostHeader(long paramLong)
  {
    this.timeCostHeader = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.RangeDownloadReport
 * JD-Core Version:    0.7.0.1
 */