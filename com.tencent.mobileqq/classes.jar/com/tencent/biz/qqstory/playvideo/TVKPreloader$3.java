package com.tencent.biz.qqstory.playvideo;

import com.tencent.biz.qqstory.base.download.DownloadUrlManager.DownloadUrlQueryResult;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager.QueryUrlResultUICallBack;
import com.tencent.biz.qqstory.base.preload.FileCacheUtils;
import java.io.File;

final class TVKPreloader$3
  implements DownloadUrlManager.QueryUrlResultUICallBack
{
  TVKPreloader$3(File paramFile, String paramString) {}
  
  public void a(DownloadUrlManager.DownloadUrlQueryResult paramDownloadUrlQueryResult)
  {
    String str = paramDownloadUrlQueryResult.c;
    if (str != null)
    {
      if ((paramDownloadUrlQueryResult.e) && (this.a.exists()) && (!FileCacheUtils.a(this.a))) {
        this.a.delete();
      }
      TVKPreloader.a(new TVKPreloader.PreloadItem(this.b, str, this.a.getAbsolutePath(), ""));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.3
 * JD-Core Version:    0.7.0.1
 */