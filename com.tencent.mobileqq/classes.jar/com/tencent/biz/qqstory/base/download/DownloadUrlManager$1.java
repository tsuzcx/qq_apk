package com.tencent.biz.qqstory.base.download;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class DownloadUrlManager$1
  implements DownloadUrlManager.PullNewVideoInfoCallBack
{
  DownloadUrlManager$1(DownloadUrlManager paramDownloadUrlManager, String paramString, int paramInt, DownloadUrlManager.QueryUrlResultUICallBack paramQueryUrlResultUICallBack) {}
  
  public void a(boolean paramBoolean)
  {
    DownloadUrlManager.DownloadUrlQueryResult localDownloadUrlQueryResult = this.d.a(this.a, this.b, paramBoolean);
    ThreadManager.getUIHandler().post(new DownloadUrlManager.1.1(this, localDownloadUrlQueryResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.download.DownloadUrlManager.1
 * JD-Core Version:    0.7.0.1
 */