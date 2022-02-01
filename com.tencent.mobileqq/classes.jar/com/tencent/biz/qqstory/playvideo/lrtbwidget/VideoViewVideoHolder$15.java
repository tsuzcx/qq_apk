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
    boolean bool = this.jdField_a_of_type_Boolean;
    Object localObject = "0";
    int i;
    if (bool)
    {
      i = this.jdField_a_of_type_Int;
      paramJobContext = new StringBuilder();
      paramJobContext.append(String.valueOf(i));
      paramJobContext.append("*");
      paramVarArgs = paramJobContext.toString();
      paramJobContext = paramVarArgs;
      if (this.jdField_a_of_type_JavaLangLong != null)
      {
        paramJobContext = new StringBuilder();
        paramJobContext.append(paramVarArgs);
        paramJobContext.append(String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_JavaLangLong.longValue()));
        paramJobContext = paramJobContext.toString();
      }
      i = 200;
    }
    else if (this.jdField_b_of_type_Boolean)
    {
      i = this.jdField_b_of_type_Int;
      paramJobContext = String.valueOf(this.jdField_c_of_type_Int);
    }
    else
    {
      paramJobContext = "0";
      i = 0;
    }
    if ((i != 0) && (i != 7))
    {
      paramVarArgs = (Void[])localObject;
      if (i == 200)
      {
        j = this.jdField_a_of_type_Int;
        paramVarArgs = (Void[])localObject;
        if (j >= 6)
        {
          paramVarArgs = (Void[])localObject;
          if (j > 10) {}
        }
      }
    }
    else if (this.jdField_d_of_type_Int == 1)
    {
      paramVarArgs = "1";
    }
    else
    {
      paramVarArgs = "2";
    }
    localObject = paramJobContext;
    int j = i;
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString))
    {
      localObject = paramJobContext;
      j = i;
      if (i != 0)
      {
        SLog.d(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_JavaLangString, "reportDevPlayerDone, errorCode=%d, suError=%s => treat as success => 300", new Object[] { Integer.valueOf(i), paramJobContext });
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(String.valueOf(i));
        ((StringBuilder)localObject).append("*");
        localObject = ((StringBuilder)localObject).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(paramJobContext);
        localObject = localStringBuilder.toString();
        j = 300;
      }
    }
    StoryReportor.b("play_video", "play_result", this.e, j, new String[] { localObject, paramVarArgs, StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.a()), this.jdField_b_of_type_JavaLangString });
    StoryReportor.b("play_video", "play_buffering", this.e, j, new String[] { String.valueOf(this.f), String.valueOf(this.g), StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.a()), this.jdField_b_of_type_JavaLangString });
    long l2 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerStoryPlayerTVKWrapper$ReportData.jdField_a_of_type_Long;
    long l1 = 0L;
    if (l2 > 0L) {
      StoryReportor.b("play_video", "play_bitRate", this.e, j, new String[] { localObject, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerStoryPlayerTVKWrapper$ReportData.toString(), StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.a()), this.jdField_b_of_type_JavaLangString });
    }
    if (this.jdField_a_of_type_Boolean) {
      i = 1;
    } else if (this.jdField_b_of_type_Boolean) {
      i = 2;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (this.jdField_a_of_type_Long != 0L) {
        l1 = SystemClock.uptimeMillis() - this.jdField_a_of_type_Long;
      }
      StoryReportor.b("sdk_download_video", "video_download_error", this.e, j, new String[] { this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, String.valueOf(i), String.valueOf(l1) });
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.15
 * JD-Core Version:    0.7.0.1
 */