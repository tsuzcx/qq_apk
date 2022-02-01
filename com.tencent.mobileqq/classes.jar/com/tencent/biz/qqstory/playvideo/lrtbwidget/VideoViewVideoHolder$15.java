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
    int i = 0;
    paramJobContext = "0";
    int j;
    if (this.jdField_a_of_type_Boolean)
    {
      j = 200;
      i = this.jdField_a_of_type_Int;
      paramVarArgs = String.valueOf(i) + "*";
      paramJobContext = paramVarArgs;
      i = j;
      if (this.jdField_a_of_type_JavaLangLong != null)
      {
        paramJobContext = paramVarArgs + String.valueOf(SystemClock.uptimeMillis() - this.jdField_a_of_type_JavaLangLong.longValue());
        i = j;
      }
      if ((i != 0) && (i != 7) && ((i != 200) || (this.jdField_a_of_type_Int < 6) || (this.jdField_a_of_type_Int > 10))) {
        break label509;
      }
      if (this.jdField_d_of_type_Int != 1) {
        break label503;
      }
      paramVarArgs = "1";
      label138:
      if ((!TextUtils.equals(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString)) || (i == 0)) {
        break label532;
      }
      SLog.d(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_JavaLangString, "reportDevPlayerDone, errorCode=%d, suError=%s => treat as success => 300", new Object[] { Integer.valueOf(i), paramJobContext });
      j = 300;
      String str = String.valueOf(i) + "*";
      paramJobContext = str + paramJobContext;
    }
    for (;;)
    {
      StoryReportor.b("play_video", "play_result", this.e, j, new String[] { paramJobContext, paramVarArgs, StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.a()), this.jdField_b_of_type_JavaLangString });
      StoryReportor.b("play_video", "play_buffering", this.e, j, new String[] { String.valueOf(this.f), String.valueOf(this.g), StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.a()), this.jdField_b_of_type_JavaLangString });
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerStoryPlayerTVKWrapper$ReportData.jdField_a_of_type_Long > 0L) {
        StoryReportor.b("play_video", "play_bitRate", this.e, j, new String[] { paramJobContext, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerStoryPlayerTVKWrapper$ReportData.toString(), StoryReportor.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.a()), this.jdField_b_of_type_JavaLangString });
      }
      if (this.jdField_a_of_type_Boolean) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          long l = 0L;
          if (this.jdField_a_of_type_Long != 0L) {
            l = SystemClock.uptimeMillis() - this.jdField_a_of_type_Long;
          }
          StoryReportor.b("sdk_download_video", "video_download_error", this.e, j, new String[] { this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, String.valueOf(i), String.valueOf(l) });
        }
        return null;
        if (!this.jdField_b_of_type_Boolean) {
          break;
        }
        i = this.jdField_b_of_type_Int;
        paramJobContext = String.valueOf(this.jdField_c_of_type_Int);
        break;
        label503:
        paramVarArgs = "2";
        break label138;
        label509:
        paramVarArgs = "0";
        break label138;
        if (this.jdField_b_of_type_Boolean) {
          i = 2;
        } else {
          i = 0;
        }
      }
      label532:
      j = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.15
 * JD-Core Version:    0.7.0.1
 */