package com.tencent.biz.qqstory.base.download;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class DownloadUrlManager$5
  extends SimpleJob<Object>
{
  DownloadUrlManager$5(DownloadUrlManager paramDownloadUrlManager, String paramString1, String paramString2, DownloadUrlManager.PullNewVideoInfoCallBack paramPullNewVideoInfoCallBack)
  {
    super(paramString1);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    DownloadUrlManager.a(this.c, this.a, this.b);
    return null;
  }
  
  public int getJobType()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.download.DownloadUrlManager.5
 * JD-Core Version:    0.7.0.1
 */