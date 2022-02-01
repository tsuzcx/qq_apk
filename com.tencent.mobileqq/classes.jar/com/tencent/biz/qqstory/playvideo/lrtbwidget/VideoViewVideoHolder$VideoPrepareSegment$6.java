package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager.DownloadUrlQueryResult;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager.QueryUrlResultUICallBack;
import com.tencent.biz.qqstory.base.preload.FileCacheUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.TVKPreloader;
import com.tencent.biz.qqstory.playvideo.TVKPreloader.PreloadItem;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.io.File;

class VideoViewVideoHolder$VideoPrepareSegment$6
  implements DownloadUrlManager.QueryUrlResultUICallBack
{
  VideoViewVideoHolder$VideoPrepareSegment$6(VideoViewVideoHolder.VideoPrepareSegment paramVideoPrepareSegment, StoryVideoItem paramStoryVideoItem, String paramString) {}
  
  public void a(DownloadUrlManager.DownloadUrlQueryResult paramDownloadUrlQueryResult)
  {
    if (this.c.isCanceled())
    {
      SLog.d(this.c.b.a, "queryAndUpdateUrl onResult. stream canceled");
      return;
    }
    if (!TextUtils.equals(paramDownloadUrlQueryResult.a, this.a.mVid))
    {
      SLog.e(this.c.b.a, "ignore queryAndUpdateUrl onResult. oldVid=%s. newVid=%s", new Object[] { paramDownloadUrlQueryResult.a, this.a.mVid });
      return;
    }
    if (!this.c.b.g())
    {
      VideoViewVideoHolder.VideoPrepareSegment.c(this.c, new ErrorMessage(-1, "queryAndUpdateUrl onResult already unBind"));
      return;
    }
    if (paramDownloadUrlQueryResult.e)
    {
      localObject1 = new File(this.b);
      if ((((File)localObject1).exists()) && (!FileCacheUtils.a((File)localObject1)))
      {
        boolean bool = ((File)localObject1).delete();
        SLog.d(this.c.b.a, "%s - %d found orphan tmp , delete it. %s", new Object[] { paramDownloadUrlQueryResult.a, Integer.valueOf(paramDownloadUrlQueryResult.b), Boolean.valueOf(bool) });
      }
    }
    if (TextUtils.isEmpty(paramDownloadUrlQueryResult.c))
    {
      VideoViewVideoHolder.VideoPrepareSegment.d(this.c, new ErrorMessage(13, "queryAndUpdateUrl onResult url empty"));
      return;
    }
    int i = TVKPreloader.b(new TVKPreloader.PreloadItem(this.a.mVid, paramDownloadUrlQueryResult.c, this.b, "TVKsetVideoPath"));
    Object localObject1 = this.c.b.a;
    Object localObject2 = this.a.mVid;
    Object localObject3 = this.b;
    SLog.d((String)localObject1, "setVideoPath, vid=%s, cache=%d, fileName = %s, url=%s", new Object[] { localObject2, Integer.valueOf(i), ((String)localObject3).substring(((String)localObject3).length() - 15), paramDownloadUrlQueryResult.c });
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i == 4) {
            VideoViewVideoHolder.a(this.c.b, HardCodeUtil.a(2131913626));
          }
        }
        else {
          VideoViewVideoHolder.a(this.c.b, HardCodeUtil.a(2131913624));
        }
      }
      else {
        VideoViewVideoHolder.a(this.c.b, HardCodeUtil.a(2131913630));
      }
    }
    else
    {
      localObject2 = this.c.b;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(HardCodeUtil.a(2131913632));
      if (this.c.b.l()) {
        localObject1 = "TVK";
      } else {
        localObject1 = "TexView";
      }
      ((StringBuilder)localObject3).append((String)localObject1);
      VideoViewVideoHolder.a((VideoViewVideoHolder)localObject2, ((StringBuilder)localObject3).toString());
      VideoViewVideoHolder.i(this.c.b).a(this.c.b, this.a.mVid, paramDownloadUrlQueryResult.c, null, false);
    }
    VideoViewVideoHolder.b(this.c.b, DownloadUrlManager.c(paramDownloadUrlQueryResult.c));
    this.c.b.v = paramDownloadUrlQueryResult.c;
    VideoViewVideoHolder.a(this.c.b, "SP", SystemClock.uptimeMillis());
    VideoViewVideoHolder.b(this.c.b, SystemClock.uptimeMillis());
    this.c.b.p.a(this.a.mVid, this.b, paramDownloadUrlQueryResult.c, this.a.mVideoBytes, (int)this.a.mVideoDuration, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoPrepareSegment.6
 * JD-Core Version:    0.7.0.1
 */