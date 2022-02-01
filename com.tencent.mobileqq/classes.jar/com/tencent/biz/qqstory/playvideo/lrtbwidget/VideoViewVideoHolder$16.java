package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.VideoGameInfo;
import com.tencent.biz.qqstory.model.item.VideoLinkInfo;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.ReportData;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.tag.CompInfoBase;
import com.tencent.biz.qqstory.takevideo.tag.TagItem.TagInfoBase;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.NetworkUtils;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import org.json.JSONException;
import org.json.JSONObject;

class VideoViewVideoHolder$16
  extends SimpleJob<Object>
{
  VideoViewVideoHolder$16(VideoViewVideoHolder paramVideoViewVideoHolder, String paramString1, StoryPlayerVideoData paramStoryPlayerVideoData, long paramLong1, long paramLong2, int paramInt, String paramString2)
  {
    super(paramString1);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    Object localObject1 = this.a.e();
    if (localObject1 == null)
    {
      SLog.e(this.f.a, "video info empty , report error! vid :%s", new Object[] { this.a.b });
      return null;
    }
    paramJobContext = ((UserManager)SuperManager.a(2)).b(((StoryVideoItem)localObject1).mOwnerUid);
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        paramVarArgs = new StringBuilder();
        paramVarArgs.append(((StoryVideoItem)localObject1).mOwnerUid);
        paramVarArgs.append("");
        localJSONObject.put("author_id", paramVarArgs.toString());
        i = ((StoryVideoItem)localObject1).mStoryType;
        if (i == 2)
        {
          paramJobContext = "6";
        }
        else
        {
          if ((paramJobContext == null) || (!paramJobContext.isVip)) {
            break label1128;
          }
          paramJobContext = "3";
        }
        localJSONObject.put("author_type", paramJobContext);
        localJSONObject.put("video_type", "1");
        paramVarArgs = new StringBuilder();
        paramVarArgs.append(this.b);
        paramVarArgs.append("");
        localJSONObject.put("video_time", paramVarArgs.toString());
        paramVarArgs = new StringBuilder();
        paramVarArgs.append(this.c);
        paramVarArgs.append("");
        localJSONObject.put("play_time", paramVarArgs.toString());
        paramVarArgs = new StringBuilder();
        paramVarArgs.append(((StoryVideoItem)localObject1).mBanType);
        paramVarArgs.append("");
        localJSONObject.put("video_restrict", paramVarArgs.toString());
        if (((StoryVideoItem)localObject1).mIsPicture != 1) {
          break label1134;
        }
        i = 1;
        localJSONObject.put("content_type", i);
        if (((StoryVideoItem)localObject1).mLocalCreateTime > 0L) {
          break label1139;
        }
        i = 1;
        localJSONObject.put("content_origin", i);
        localJSONObject.put("vote_id", StoryReportor.a((StoryVideoItem)localObject1));
        long l;
        if (VideoViewVideoHolder.o(this.f) > 0L) {
          l = VideoViewVideoHolder.o(this.f);
        } else {
          l = System.currentTimeMillis() - VideoViewVideoHolder.p(this.f);
        }
        Object localObject2 = this.a.f();
        paramVarArgs = new StringBuilder();
        paramVarArgs.append(l);
        paramVarArgs.append("");
        localJSONObject.put("load_time", paramVarArgs.toString());
        paramVarArgs = this.f.i();
        if (!(paramVarArgs.mInfo instanceof MsgTabPlayInfo)) {
          break label1144;
        }
        paramVarArgs = ((MsgTabPlayInfo)paramVarArgs.mInfo).nodeUnionId;
        localJSONObject.put("viewer_id", StoryReportor.a(paramVarArgs, (VideoListFeedItem)localObject2));
        localJSONObject.put("sharefromapp", Integer.toString(StoryApi.d(2131492921)));
        if (((StoryVideoItem)localObject1).mTagInfoBase == null) {
          break label1149;
        }
        localJSONObject.put("tag_id", ((StoryVideoItem)localObject1).mTagInfoBase.a);
        if (((StoryVideoItem)localObject1).mSourceType == -1) {
          break label1152;
        }
        bool = true;
        AssertUtils.assertTrue(bool, "storyVideoItem.mSourceType is illegal");
        if (!TextUtils.isEmpty(((StoryVideoItem)localObject1).mLinkInfoJson)) {
          break label1158;
        }
        i = 0;
        localJSONObject.put("video_url", i);
        i = ((StoryVideoItem)localObject1).mSourceType;
        if (((StoryVideoItem)localObject1).mSourceTagType == 1) {
          i = 1;
        }
        localJSONObject.put("video_origin", i);
        paramVarArgs = VideoLinkInfo.a(((StoryVideoItem)localObject1).mLinkInfoJson);
        if ((paramVarArgs != null) && (paramVarArgs.a == 5)) {
          localJSONObject.put("video_transmit", 1);
        } else {
          localJSONObject.put("video_transmit", 0);
        }
        Object localObject3 = ((StoryVideoItem)localObject1).mCompInfoBase;
        if ((localObject3 != null) && (!TextUtils.isEmpty(((StoryVideoItem)localObject1).mCompInfoBase.c))) {
          localJSONObject.put("copruduction", 1);
        } else if ((paramVarArgs != null) && (paramVarArgs.a == 3)) {
          localJSONObject.put("copruduction", 1);
        } else {
          localJSONObject.put("copruduction", 0);
        }
        paramVarArgs = ((StoryVideoItem)localObject1).getVideoGameInfo();
        if (paramVarArgs != null) {
          localJSONObject.put("game_id", paramVarArgs.b);
        }
        localJSONObject.put("mobile_type", Build.MODEL);
        localJSONObject.put("wifi_ssid", NetworkUtils.d(this.f.a()));
        localJSONObject.put("wifi_mac", NetworkUtils.c(this.f.a()));
        i = this.f.i().mReportData.from;
        int j = this.d;
        localObject3 = localJSONObject.toString();
        if (localObject2 == null) {
          paramVarArgs = "";
        } else {
          paramVarArgs = ((VideoListFeedItem)localObject2).feedId;
        }
        StoryReportor.a("play_video", "video_all_js", i, j, new String[] { localObject3, paramVarArgs, this.e, ((StoryVideoItem)localObject1).mVid });
        j = this.d;
        paramVarArgs = new StringBuilder();
        paramVarArgs.append(((StoryVideoItem)localObject1).mOwnerUid);
        paramVarArgs.append("");
        StoryReportor.a("play_video", "video_property", i, j, new String[] { paramVarArgs.toString(), paramJobContext, "1", ((StoryVideoItem)localObject1).mVid });
        j = this.d;
        paramJobContext = new StringBuilder();
        paramJobContext.append(this.b);
        paramJobContext.append("");
        paramJobContext = paramJobContext.toString();
        paramVarArgs = new StringBuilder();
        paramVarArgs.append(this.c);
        paramVarArgs.append("");
        paramVarArgs = paramVarArgs.toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(l);
        ((StringBuilder)localObject2).append("");
        StoryReportor.a("play_video", "video_time", i, j, new String[] { paramJobContext, paramVarArgs, ((StringBuilder)localObject2).toString(), ((StoryVideoItem)localObject1).mVid });
        SLog.a(this.f.a, "report user video done , op_result : %d ,json :%s", Integer.valueOf(this.d), localJSONObject);
        this.f.u = 3;
      }
      catch (JSONException paramJobContext)
      {
        if (QLog.isColorLevel())
        {
          paramVarArgs = this.f.a;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("reportViewVideo exception:");
          ((StringBuilder)localObject1).append(QLog.getStackTraceString(paramJobContext));
          QLog.w(paramVarArgs, 2, ((StringBuilder)localObject1).toString());
        }
      }
      return null;
      label1128:
      paramJobContext = "1";
      continue;
      label1134:
      int i = 2;
      continue;
      label1139:
      i = 2;
      continue;
      label1144:
      paramVarArgs = null;
      continue;
      label1149:
      continue;
      label1152:
      boolean bool = false;
      continue;
      label1158:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.16
 * JD-Core Version:    0.7.0.1
 */