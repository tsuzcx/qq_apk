package com.tencent.biz.qqcircle.beans;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.List;

public class QCirclePicPreviewInitBean
  extends QCircleInitBean
{
  private String clientTraceId;
  private List<LocalMediaInfo> mMediaInfoList;
  
  public String getClientTraceId()
  {
    return this.clientTraceId;
  }
  
  public List<LocalMediaInfo> getMediaInfoList()
  {
    return this.mMediaInfoList;
  }
  
  public void setClientTraceId(String paramString)
  {
    this.clientTraceId = paramString;
  }
  
  public void setMediaInfoList(List<LocalMediaInfo> paramList)
  {
    this.mMediaInfoList = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.beans.QCirclePicPreviewInitBean
 * JD-Core Version:    0.7.0.1
 */