package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.ReportData;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import org.json.JSONException;
import org.json.JSONObject;

class VideoViewVideoHolder$17
  extends SimpleJob<Object>
{
  VideoViewVideoHolder$17(VideoViewVideoHolder paramVideoViewVideoHolder, String paramString1, StoryVideoItem paramStoryVideoItem, long paramLong1, long paramLong2, int paramInt, String paramString2)
  {
    super(paramString1);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    for (;;)
    {
      try
      {
        paramJobContext = new JSONObject();
        paramVarArgs = new StringBuilder();
        paramVarArgs.append(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mOwnerUid);
        paramVarArgs.append("");
        paramJobContext.put("author_id", paramVarArgs.toString());
        paramJobContext.put("author_type", "1");
        paramJobContext.put("video_type", "1");
        paramVarArgs = new StringBuilder();
        paramVarArgs.append(this.jdField_a_of_type_Long);
        paramVarArgs.append("");
        paramJobContext.put("video_time", paramVarArgs.toString());
        paramVarArgs = new StringBuilder();
        paramVarArgs.append(this.b);
        paramVarArgs.append("");
        paramJobContext.put("play_time", paramVarArgs.toString());
        paramVarArgs = new StringBuilder();
        paramVarArgs.append(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mBanType);
        paramVarArgs.append("");
        paramJobContext.put("video_restrict", paramVarArgs.toString());
        if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mIsPicture != 1) {
          break label457;
        }
        i = 1;
        paramJobContext.put("content_type", i);
        if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mLocalCreateTime > 0L) {
          break label462;
        }
        i = 1;
        paramJobContext.put("content_origin", i);
        paramJobContext.put("mobile_type", Build.MODEL);
        paramJobContext.put("wifi_ssid", NetworkUtils.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.a()));
        paramJobContext.put("wifi_mac", NetworkUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.a()));
        long l;
        if (VideoViewVideoHolder.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder) > 0L) {
          l = VideoViewVideoHolder.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder);
        } else {
          l = System.currentTimeMillis() - VideoViewVideoHolder.c(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder);
        }
        paramVarArgs = new StringBuilder();
        paramVarArgs.append(l);
        paramVarArgs.append("");
        paramJobContext.put("load_time", paramVarArgs.toString());
        StoryReportor.a("story_grp", "play_video_js", this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.a().mReportData.from, this.jdField_a_of_type_Int, new String[] { paramJobContext.toString(), "", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.d = 3;
      }
      catch (JSONException paramJobContext)
      {
        if (QLog.isColorLevel())
        {
          paramVarArgs = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("reportTroopVideo exception:");
          localStringBuilder.append(QLog.getStackTraceString(paramJobContext));
          QLog.w(paramVarArgs, 2, localStringBuilder.toString());
        }
      }
      return null;
      label457:
      int i = 2;
      continue;
      label462:
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.17
 * JD-Core Version:    0.7.0.1
 */