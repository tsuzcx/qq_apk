package com.tencent.component.network.downloader;

import okhttp3.Response;

class RangeDownloadManager$RangeDownloadResult
{
  private final int index;
  private final RangeDownloadReport rangeDownloadReport;
  private final Response response;
  private final long responseDataLength;
  
  RangeDownloadManager$RangeDownloadResult(int paramInt, Response paramResponse, long paramLong, RangeDownloadReport paramRangeDownloadReport)
  {
    this.index = paramInt;
    this.response = paramResponse;
    this.responseDataLength = paramLong;
    this.rangeDownloadReport = paramRangeDownloadReport;
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public RangeDownloadReport getRangeDownloadReport()
  {
    return this.rangeDownloadReport;
  }
  
  public Response getResponse()
  {
    return this.response;
  }
  
  public long getResponseDataLength()
  {
    return this.responseDataLength;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.downloader.RangeDownloadManager.RangeDownloadResult
 * JD-Core Version:    0.7.0.1
 */