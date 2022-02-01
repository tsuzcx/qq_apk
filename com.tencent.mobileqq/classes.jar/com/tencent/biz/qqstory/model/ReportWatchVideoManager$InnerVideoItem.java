package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.database.ReportWatchVideoEntry;

public class ReportWatchVideoManager$InnerVideoItem
{
  public String a;
  public String b;
  public boolean c;
  public long d;
  public int e;
  public int f;
  
  public ReportWatchVideoManager$InnerVideoItem() {}
  
  public ReportWatchVideoManager$InnerVideoItem(String paramString1, String paramString2, boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramBoolean;
    this.d = paramLong;
    this.e = paramInt1;
    this.f = paramInt2;
  }
  
  public ReportWatchVideoEntry a()
  {
    ReportWatchVideoEntry localReportWatchVideoEntry = new ReportWatchVideoEntry();
    localReportWatchVideoEntry.vid = this.a;
    localReportWatchVideoEntry.videoUnionId = this.b;
    localReportWatchVideoEntry.isLiveVideo = this.c;
    localReportWatchVideoEntry.createTime = this.d;
    localReportWatchVideoEntry.source = this.e;
    localReportWatchVideoEntry.vidType = this.f;
    return localReportWatchVideoEntry;
  }
  
  public void a(ReportWatchVideoEntry paramReportWatchVideoEntry)
  {
    this.a = paramReportWatchVideoEntry.vid;
    this.b = paramReportWatchVideoEntry.videoUnionId;
    this.c = paramReportWatchVideoEntry.isLiveVideo;
    this.d = paramReportWatchVideoEntry.createTime;
    this.e = paramReportWatchVideoEntry.source;
    this.f = paramReportWatchVideoEntry.vidType;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (InnerVideoItem)paramObject;
      return this.a.equals(paramObject.a);
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("InnerVideoItem { mVid=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" mVideoUid=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" mIsLiveVideo=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" mCreateTime=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" mSource=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" mVidType=");
    localStringBuilder.append(this.f);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.ReportWatchVideoManager.InnerVideoItem
 * JD-Core Version:    0.7.0.1
 */