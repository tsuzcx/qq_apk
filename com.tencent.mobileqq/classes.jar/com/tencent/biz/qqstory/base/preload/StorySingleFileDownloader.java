package com.tencent.biz.qqstory.base.preload;

import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.HashMap;
import java.util.Map;

public class StorySingleFileDownloader
  implements AsyncFileDownloader.DownloadResult
{
  private AsyncFileDownloader a = new AsyncFileDownloader();
  private Map<String, DownloadTask> b = new HashMap();
  private Handler c = new Handler(ThreadManager.getSubThreadLooper());
  private Handler d = new Handler(Looper.getMainLooper());
  
  private void a(String paramString, int paramInt, ErrorMessage paramErrorMessage, StorySingleFileDownloader.FileDownloadListener paramFileDownloadListener)
  {
    if (paramFileDownloadListener == null) {
      return;
    }
    this.d.post(new StorySingleFileDownloader.7(this, paramFileDownloadListener, paramString, paramInt, paramErrorMessage));
  }
  
  private void a(String paramString, int paramInt, StorySingleFileDownloader.FileDownloadListener paramFileDownloadListener)
  {
    if (paramFileDownloadListener == null) {
      return;
    }
    this.d.post(new StorySingleFileDownloader.5(this, paramFileDownloadListener, paramString, paramInt));
  }
  
  private void b(DownloadTask paramDownloadTask, ErrorMessage paramErrorMessage)
  {
    Object localObject = paramDownloadTask.a;
    int i = 0;
    SLog.d("Q.qqstory.download:StorySingleFileDownloader", "on download resp , key: %s , error: %d", new Object[] { localObject, Integer.valueOf(paramErrorMessage.errorCode) });
    if (paramErrorMessage.errorCode == 0) {
      i = 1;
    }
    if (i != 0)
    {
      paramDownloadTask.d = 3;
      ((DownloadUrlManager)SuperManager.a(28)).c(paramDownloadTask.b, paramDownloadTask.c);
      paramErrorMessage = ((StoryManager)SuperManager.a(5)).a(paramDownloadTask.b);
      if (paramErrorMessage != null) {
        FileCacheUtils.a(paramErrorMessage, paramDownloadTask.g, paramDownloadTask.c, StoryReportor.a(BaseApplicationImpl.getContext()));
      }
      paramErrorMessage = paramDownloadTask.l.get("DOWNLOAD_TASK_KEY_LISTENER");
      if ((paramErrorMessage != null) && ((paramErrorMessage instanceof StorySingleFileDownloader.FileDownloadListener))) {
        a(paramDownloadTask.b, paramDownloadTask.c, (StorySingleFileDownloader.FileDownloadListener)paramErrorMessage);
      }
    }
    else
    {
      localObject = paramDownloadTask.l.get("DOWNLOAD_TASK_KEY_LISTENER");
      if ((localObject != null) && ((localObject instanceof StorySingleFileDownloader.FileDownloadListener))) {
        a(paramDownloadTask.b, paramDownloadTask.c, paramErrorMessage, (StorySingleFileDownloader.FileDownloadListener)localObject);
      }
    }
  }
  
  private void b(String paramString, int paramInt, StorySingleFileDownloader.FileDownloadListener paramFileDownloadListener)
  {
    if (paramFileDownloadListener == null) {
      return;
    }
    this.d.post(new StorySingleFileDownloader.6(this, paramFileDownloadListener, paramString, paramInt));
  }
  
  public void a()
  {
    this.c.post(new StorySingleFileDownloader.1(this));
  }
  
  public void a(DownloadTask paramDownloadTask, ErrorMessage paramErrorMessage)
  {
    this.c.post(new StorySingleFileDownloader.4(this, paramDownloadTask, paramErrorMessage));
  }
  
  public void a(String paramString, int paramInt)
  {
    this.c.post(new StorySingleFileDownloader.3(this, paramString, paramInt));
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean, StorySingleFileDownloader.FileDownloadListener paramFileDownloadListener)
  {
    this.c.post(new StorySingleFileDownloader.2(this, paramString, paramInt, paramFileDownloadListener, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.StorySingleFileDownloader
 * JD-Core Version:    0.7.0.1
 */