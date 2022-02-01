package com.tencent.biz.qqstory.base.preload;

import com.tencent.biz.qqstory.base.download.DownloadUrlManager.DownloadUrlQueryResult;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager.QueryUrlResultUICallBack;
import com.tencent.biz.qqstory.playvideo.TVKPreloader;
import com.tencent.biz.qqstory.playvideo.TVKPreloader.PreloadItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.io.File;

class PlayingListPreloader$2
  implements DownloadUrlManager.QueryUrlResultUICallBack
{
  PlayingListPreloader$2(PlayingListPreloader paramPlayingListPreloader, File paramFile, String paramString) {}
  
  public void a(DownloadUrlManager.DownloadUrlQueryResult paramDownloadUrlQueryResult)
  {
    if ((paramDownloadUrlQueryResult.e) && (this.a.exists()) && (!FileCacheUtils.a(this.a)))
    {
      this.a.delete();
      SLog.d("Q.qqstory.download.preload.PlayingListPreloader", "%s - %d found orphan tmp , delete it", new Object[] { paramDownloadUrlQueryResult.a, Integer.valueOf(paramDownloadUrlQueryResult.b) });
    }
    SLog.d("Q.qqstory.download.preload.PlayingListPreloader", "triggerDownload : supportStreamPlay=true : TVK preload : vid=%s, url=%s", new Object[] { this.b, paramDownloadUrlQueryResult.c });
    if (paramDownloadUrlQueryResult.c != null) {
      TVKPreloader.a(new TVKPreloader.PreloadItem(this.b, paramDownloadUrlQueryResult.c, this.a.getAbsolutePath(), ""));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.PlayingListPreloader.2
 * JD-Core Version:    0.7.0.1
 */