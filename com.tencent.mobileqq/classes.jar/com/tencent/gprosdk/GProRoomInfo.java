package com.tencent.gprosdk;

import java.util.HashMap;

public final class GProRoomInfo
{
  final String mProgramId;
  final HashMap<String, String> mRoomIcons;
  final long mRoomId;
  final String mRoomName;
  final int mRoomState;
  final long mViewer;
  final GProViewerExt mViewerExt;
  
  public GProRoomInfo(long paramLong1, String paramString1, long paramLong2, int paramInt, GProViewerExt paramGProViewerExt, String paramString2, HashMap<String, String> paramHashMap)
  {
    this.mRoomId = paramLong1;
    this.mRoomName = paramString1;
    this.mViewer = paramLong2;
    this.mRoomState = paramInt;
    this.mViewerExt = paramGProViewerExt;
    this.mProgramId = paramString2;
    this.mRoomIcons = paramHashMap;
  }
  
  public String getProgramId()
  {
    return this.mProgramId;
  }
  
  public HashMap<String, String> getRoomIcons()
  {
    return this.mRoomIcons;
  }
  
  public long getRoomId()
  {
    return this.mRoomId;
  }
  
  public String getRoomName()
  {
    return this.mRoomName;
  }
  
  public int getRoomState()
  {
    return this.mRoomState;
  }
  
  public long getViewer()
  {
    return this.mViewer;
  }
  
  public GProViewerExt getViewerExt()
  {
    return this.mViewerExt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProRoomInfo{mRoomId=");
    localStringBuilder.append(this.mRoomId);
    localStringBuilder.append(",mRoomName=");
    localStringBuilder.append(this.mRoomName);
    localStringBuilder.append(",mViewer=");
    localStringBuilder.append(this.mViewer);
    localStringBuilder.append(",mRoomState=");
    localStringBuilder.append(this.mRoomState);
    localStringBuilder.append(",mViewerExt=");
    localStringBuilder.append(this.mViewerExt);
    localStringBuilder.append(",mProgramId=");
    localStringBuilder.append(this.mProgramId);
    localStringBuilder.append(",mRoomIcons=");
    localStringBuilder.append(this.mRoomIcons);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gprosdk.GProRoomInfo
 * JD-Core Version:    0.7.0.1
 */