package com.tencent.gprosdk;

public final class GProLiveRoomInfo
{
  final GProAnchorInfo mAnchorInfo;
  final long mQueryId;
  final GProRoomInfo mRoomInfo;
  
  public GProLiveRoomInfo(long paramLong, GProAnchorInfo paramGProAnchorInfo, GProRoomInfo paramGProRoomInfo)
  {
    this.mQueryId = paramLong;
    this.mAnchorInfo = paramGProAnchorInfo;
    this.mRoomInfo = paramGProRoomInfo;
  }
  
  public GProAnchorInfo getAnchorInfo()
  {
    return this.mAnchorInfo;
  }
  
  public long getQueryId()
  {
    return this.mQueryId;
  }
  
  public GProRoomInfo getRoomInfo()
  {
    return this.mRoomInfo;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProLiveRoomInfo{mQueryId=");
    localStringBuilder.append(this.mQueryId);
    localStringBuilder.append(",mAnchorInfo=");
    localStringBuilder.append(this.mAnchorInfo);
    localStringBuilder.append(",mRoomInfo=");
    localStringBuilder.append(this.mRoomInfo);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProLiveRoomInfo
 * JD-Core Version:    0.7.0.1
 */