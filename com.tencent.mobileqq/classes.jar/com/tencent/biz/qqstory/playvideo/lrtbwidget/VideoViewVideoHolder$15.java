package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.playvideo.player.StoryPlayerTVKWrapper.ReportData;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class VideoViewVideoHolder$15
  extends SimpleJob<Object>
{
  VideoViewVideoHolder$15(VideoViewVideoHolder paramVideoViewVideoHolder, String paramString1, boolean paramBoolean1, int paramInt1, Long paramLong, boolean paramBoolean2, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3, int paramInt5, int paramInt6, int paramInt7, StoryPlayerTVKWrapper.ReportData paramReportData, long paramLong1, String paramString4, String paramString5)
  {
    super(paramString1);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    boolean bool = this.a;
    Object localObject = "0";
    int i1;
    if (bool)
    {
      i1 = this.b;
      paramJobContext = new StringBuilder();
      paramJobContext.append(String.valueOf(i1));
      paramJobContext.append("*");
      paramVarArgs = paramJobContext.toString();
      paramJobContext = paramVarArgs;
      if (this.c != null)
      {
        paramJobContext = new StringBuilder();
        paramJobContext.append(paramVarArgs);
        paramJobContext.append(String.valueOf(SystemClock.uptimeMillis() - this.c.longValue()));
        paramJobContext = paramJobContext.toString();
      }
      i1 = 200;
    }
    else if (this.d)
    {
      i1 = this.e;
      paramJobContext = String.valueOf(this.f);
    }
    else
    {
      paramJobContext = "0";
      i1 = 0;
    }
    if ((i1 != 0) && (i1 != 7))
    {
      paramVarArgs = (Void[])localObject;
      if (i1 == 200)
      {
        i2 = this.b;
        paramVarArgs = (Void[])localObject;
        if (i2 >= 6)
        {
          paramVarArgs = (Void[])localObject;
          if (i2 > 10) {}
        }
      }
    }
    else if (this.g == 1)
    {
      paramVarArgs = "1";
    }
    else
    {
      paramVarArgs = "2";
    }
    localObject = paramJobContext;
    int i2 = i1;
    if (TextUtils.equals(this.h, this.i))
    {
      localObject = paramJobContext;
      i2 = i1;
      if (i1 != 0)
      {
        SLog.d(this.q.a, "reportDevPlayerDone, errorCode=%d, suError=%s => treat as success => 300", new Object[] { Integer.valueOf(i1), paramJobContext });
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(String.valueOf(i1));
        ((StringBuilder)localObject).append("*");
        localObject = ((StringBuilder)localObject).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(paramJobContext);
        localObject = localStringBuilder.toString();
        i2 = 300;
      }
    }
    StoryReportor.b("play_video", "play_result", this.j, i2, new String[] { localObject, paramVarArgs, StoryReportor.a(this.q.a()), this.i });
    StoryReportor.b("play_video", "play_buffering", this.j, i2, new String[] { String.valueOf(this.k), String.valueOf(this.l), StoryReportor.a(this.q.a()), this.i });
    long l2 = this.m.d;
    long l1 = 0L;
    if (l2 > 0L) {
      StoryReportor.b("play_video", "play_bitRate", this.j, i2, new String[] { localObject, this.m.toString(), StoryReportor.a(this.q.a()), this.i });
    }
    if (this.a) {
      i1 = 1;
    } else if (this.d) {
      i1 = 2;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      if (this.n != 0L) {
        l1 = SystemClock.uptimeMillis() - this.n;
      }
      StoryReportor.b("sdk_download_video", "video_download_error", this.j, i2, new String[] { this.o, this.p, String.valueOf(i1), String.valueOf(l1) });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.15
 * JD-Core Version:    0.7.0.1
 */