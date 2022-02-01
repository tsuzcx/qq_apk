package com.tencent.biz.qqstory.playvideo.player;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.VideoServerInfoManager;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils.DebugInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.util.URLUtil;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import mqq.os.MqqHandler;

class VideoViewTVKImpl$1
  extends SimpleJob<Object>
{
  VideoViewTVKImpl$1(VideoViewTVKImpl paramVideoViewTVKImpl, String paramString1, VideoServerInfoManager paramVideoServerInfoManager, PlayModeUtils.DebugInfo paramDebugInfo, DownloadUrlManager paramDownloadUrlManager, String paramString2, TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo)
  {
    super(paramString1);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl.d;
    if (TextUtils.isEmpty(paramJobContext)) {
      return null;
    }
    if (paramJobContext.contains("qqstocdnd"))
    {
      paramVarArgs = this.jdField_a_of_type_ComTencentBizQqstoryBaseVideoServerInfoManager.a();
      SLog.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl.jdField_a_of_type_JavaLangString, "get url key:%s", paramVarArgs);
      if (TextUtils.isEmpty(paramVarArgs)) {
        break label85;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerVideoViewTVKImpl.d = URLUtil.a(paramJobContext, "authkey", paramVarArgs);
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new VideoViewTVKImpl.1.2(this));
      return null;
      label85:
      ThreadManager.getUIHandler().post(new VideoViewTVKImpl.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.player.VideoViewTVKImpl.1
 * JD-Core Version:    0.7.0.1
 */