package com.tencent.av.wtogether.util;

public class WatchTogetherDataReportHelper$WTFilePlayInfo
{
  public String a;
  public int b;
  public int c;
  
  public WatchTogetherDataReportHelper$WTFilePlayInfo(String paramString)
  {
    this.a = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WTFilePlayInfo{mVideoKey: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mVideoDurationMs: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mVideoPlayTimeMs: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.util.WatchTogetherDataReportHelper.WTFilePlayInfo
 * JD-Core Version:    0.7.0.1
 */