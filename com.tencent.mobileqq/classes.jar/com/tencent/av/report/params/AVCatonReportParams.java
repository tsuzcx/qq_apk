package com.tencent.av.report.params;

public class AVCatonReportParams
{
  private long mCurFrameCount;
  private long mFirstFrameTime;
  private long mFrameCount;
  private long mGap05;
  private long mGap10100;
  private long mGap510;
  private long mPlayDutation;
  private String mResolution;
  private long mRoomId;
  private String mSdkType;
  private long mStartPlayTime;
  private long mStopPlayTime;
  private String mUrl;
  
  public long getCurFrameCount()
  {
    return this.mCurFrameCount;
  }
  
  public long getFirstFrameTime()
  {
    return this.mFirstFrameTime;
  }
  
  public long getFrameCount()
  {
    return this.mFrameCount;
  }
  
  public long getGap05()
  {
    return this.mGap05;
  }
  
  public long getGap10100()
  {
    return this.mGap10100;
  }
  
  public long getGap510()
  {
    return this.mGap510;
  }
  
  public long getPlayDutation()
  {
    return this.mStopPlayTime - this.mFirstFrameTime;
  }
  
  public String getResolution()
  {
    return this.mResolution;
  }
  
  public long getRoomId()
  {
    return this.mRoomId;
  }
  
  public String getSdkType()
  {
    return this.mSdkType;
  }
  
  public long getStartPlayTime()
  {
    return this.mStartPlayTime;
  }
  
  public long getStopPlayTime()
  {
    return this.mStopPlayTime;
  }
  
  public String getUrl()
  {
    return this.mUrl;
  }
  
  public void init(String paramString, long paramLong)
  {
    this.mGap05 = 0L;
    this.mGap510 = 0L;
    this.mGap10100 = 0L;
    this.mFrameCount = 0L;
    this.mCurFrameCount = 0L;
    this.mFirstFrameTime = 0L;
    this.mPlayDutation = 0L;
    this.mStartPlayTime = 0L;
    this.mStopPlayTime = 0L;
    this.mRoomId = paramLong;
    this.mUrl = paramString;
    this.mResolution = null;
  }
  
  public void setCurFrameCount(long paramLong)
  {
    this.mCurFrameCount = paramLong;
  }
  
  public void setFirstFrameTime(long paramLong)
  {
    this.mFirstFrameTime = paramLong;
  }
  
  public void setFrameCount(long paramLong)
  {
    this.mFrameCount = paramLong;
  }
  
  public void setGap05(long paramLong)
  {
    this.mGap05 = paramLong;
  }
  
  public void setGap10100(long paramLong)
  {
    this.mGap10100 = paramLong;
  }
  
  public void setGap510(long paramLong)
  {
    this.mGap510 = paramLong;
  }
  
  public void setPlayDutation(long paramLong)
  {
    this.mPlayDutation = paramLong;
  }
  
  public void setResolution(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("x");
    localStringBuilder.append(paramInt2);
    this.mResolution = localStringBuilder.toString();
  }
  
  public void setResolution(String paramString)
  {
    this.mResolution = paramString;
  }
  
  public void setRoomId(long paramLong)
  {
    this.mRoomId = paramLong;
  }
  
  public void setSdkType(String paramString)
  {
    this.mSdkType = paramString;
  }
  
  public void setStartPlayTime(long paramLong)
  {
    this.mStartPlayTime = paramLong;
  }
  
  public void setStopPlayTime(long paramLong)
  {
    this.mStopPlayTime = paramLong;
  }
  
  public void setUrl(String paramString)
  {
    this.mUrl = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.report.params.AVCatonReportParams
 * JD-Core Version:    0.7.0.1
 */