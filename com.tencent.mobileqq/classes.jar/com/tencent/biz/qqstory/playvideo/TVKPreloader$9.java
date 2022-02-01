package com.tencent.biz.qqstory.playvideo;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.VideoServerInfoManager;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.util.URLUtil;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

final class TVKPreloader$9
  extends SimpleJob<Object>
{
  TVKPreloader$9(String paramString, VideoServerInfoManager paramVideoServerInfoManager, String[] paramArrayOfString, int paramInt, TVKPreloader.PreloadItem paramPreloadItem, TVK_ICacheMgr paramTVK_ICacheMgr, TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo)
  {
    super(paramString);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = this.a.e();
    if (!TextUtils.isEmpty(paramJobContext))
    {
      paramVarArgs = this.b;
      paramVarArgs[0] = URLUtil.a(paramVarArgs[0], "authkey", paramJobContext);
    }
    TVKPreloader.a(this.e, this.f, this.b[0], this.d);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.9
 * JD-Core Version:    0.7.0.1
 */