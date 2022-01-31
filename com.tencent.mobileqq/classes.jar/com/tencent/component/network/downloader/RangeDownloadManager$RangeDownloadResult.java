package com.tencent.component.network.downloader;

import okhttp3.Response;

class RangeDownloadManager$RangeDownloadResult
{
  private final byte[] contentBytes;
  private final int index;
  private final RangeDownloadReport rangeDownloadReport;
  private final Response response;
  
  RangeDownloadManager$RangeDownloadResult(int paramInt, Response paramResponse, byte[] paramArrayOfByte, RangeDownloadReport paramRangeDownloadReport)
  {
    this.index = paramInt;
    this.response = paramResponse;
    this.contentBytes = paramArrayOfByte;
    this.rangeDownloadReport = paramRangeDownloadReport;
  }
  
  public byte[] getContentBytes()
  {
    return this.contentBytes;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.network.downloader.RangeDownloadManager.RangeDownloadResult
 * JD-Core Version:    0.7.0.1
 */