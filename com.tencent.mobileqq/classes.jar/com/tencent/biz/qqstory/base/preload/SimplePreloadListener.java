package com.tencent.biz.qqstory.base.preload;

import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.File;

public class SimplePreloadListener
  implements IVideoPreloader.OnPreloadListener
{
  private String a = "SimplePreloadListener";
  
  public SimplePreloadListener(String paramString)
  {
    this.a = paramString;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, DownloadTask paramDownloadTask) {}
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, DownloadTask paramDownloadTask)
  {
    if ((paramInt1 == 1) && (paramErrorMessage.errorCode == 14))
    {
      SLog.b(this.a, "download ignore because no mask pic url");
      return;
    }
    SLog.d(this.a, "download error! vid = %s , fileType = %d , error = %s", new Object[] { paramString, Integer.valueOf(paramInt1), paramErrorMessage });
  }
  
  public void a(String paramString, int paramInt, DownloadTask paramDownloadTask) {}
  
  public void a(String paramString, int paramInt1, File paramFile, int paramInt2, DownloadTask paramDownloadTask)
  {
    paramString = ((StoryManager)SuperManager.a(5)).a(paramString);
    if (paramString != null) {
      FileCacheUtils.a(paramString, paramFile.getAbsolutePath(), paramInt1);
    }
  }
  
  public void b(String paramString, int paramInt, DownloadTask paramDownloadTask)
  {
    SLog.a(this.a, "onPause! vid = %s , fileType = %d ", paramString, Integer.valueOf(paramInt));
  }
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, DownloadTask paramDownloadTask)
  {
    SLog.a(this.a, "download success! vid = %s , fileType = %s , file path = %s", paramString, QQStoryConstant.a(paramInt1), paramFile.getAbsolutePath());
    paramString = ((StoryManager)SuperManager.a(5)).a(paramString);
    if (paramString != null) {
      FileCacheUtils.a(paramString, paramFile.getAbsolutePath(), paramInt1, StoryReportor.a(BaseApplicationImpl.getContext()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.SimplePreloadListener
 * JD-Core Version:    0.7.0.1
 */