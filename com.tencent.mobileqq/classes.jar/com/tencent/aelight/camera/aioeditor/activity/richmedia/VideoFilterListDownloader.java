package com.tencent.aelight.camera.aioeditor.activity.richmedia;

import android.os.Bundle;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.aioeditor.richmedia.capture.data.CaptureVideoFilterManager;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.transfile.NetFailedListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.os.MqqHandler;

public class VideoFilterListDownloader
  implements NetFailedListener
{
  private static VideoFilterListDownloader d;
  VideoFilterListDownloader.MyListDownloaderListener a = new VideoFilterListDownloader.MyListDownloaderListener(this);
  private HashMap<String, VideoFilterListDownloader.DownloadListTask> b = new HashMap();
  private Lock c = new ReentrantLock();
  
  public static VideoFilterListDownloader a()
  {
    if (d == null) {
      d = new VideoFilterListDownloader();
    }
    return d;
  }
  
  private void a(FilterDesc paramFilterDesc, long paramLong, int paramInt)
  {
    if (paramFilterDesc != null) {}
    try
    {
      Object localObject2 = ((CaptureComboManager)QIMManager.a(5)).l;
      Object localObject1 = new ArrayList();
      if (localObject2 != null) {
        localObject1 = ((VideoFilterTools.ComboFilterData)localObject2).a(0).c;
      }
      localObject1 = ((List)localObject1).iterator();
      do
      {
        while (!((Iterator)localObject2).hasNext())
        {
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (QIMFilterCategoryItem)((Iterator)localObject1).next();
          } while (((QIMFilterCategoryItem)localObject2).e != 103);
          localObject2 = ((QIMFilterCategoryItem)localObject2).j.iterator();
        }
      } while (!((String)((Iterator)localObject2).next()).equals(paramFilterDesc.name));
      long l = paramFilterDesc.bundle.getLong("requestStartTime", System.currentTimeMillis());
      VSReporter.a("record_filter_download", VSReporter.a(paramInt, System.currentTimeMillis() - l, paramFilterDesc.resurl, paramLong, paramFilterDesc.name));
      QLog.i("VideoFilterListDownloader", 2, "MyListDownloaderListener report.");
      return;
    }
    catch (Exception paramFilterDesc)
    {
      label170:
      break label170;
    }
    QLog.i("VideoFilterListDownloader", 2, "Report exception.");
  }
  
  private void a(FilterDesc paramFilterDesc, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    this.c.lock();
    try
    {
      localDownloadListTask = (VideoFilterListDownloader.DownloadListTask)this.b.get(paramFilterDesc.name);
      j = 0;
      if ((localDownloadListTask == null) || (localDownloadListTask.b == null)) {
        break label120;
      }
      i = 0;
    }
    finally
    {
      for (;;)
      {
        VideoFilterListDownloader.DownloadListTask localDownloadListTask;
        int j;
        int i;
        VideoFilterListDownloader.downloadListTaskListener localdownloadListTaskListener;
        label120:
        this.c.unlock();
        for (;;)
        {
          throw paramFilterDesc;
        }
        i += 1;
      }
    }
    if (i < localDownloadListTask.b.size())
    {
      localdownloadListTaskListener = (VideoFilterListDownloader.downloadListTaskListener)((WeakReference)localDownloadListTask.b.get(i)).get();
      if (localdownloadListTaskListener != null) {
        localArrayList.add(localdownloadListTaskListener);
      }
    }
    else
    {
      localDownloadListTask.b.clear();
      this.b.remove(paramFilterDesc.name);
      this.c.unlock();
      if (localArrayList.size() > 0)
      {
        i = j;
        while (i < localArrayList.size())
        {
          paramFilterDesc = (VideoFilterListDownloader.downloadListTaskListener)localArrayList.get(i);
          if (paramFilterDesc != null) {
            paramFilterDesc.a(paramBoolean);
          }
          i += 1;
        }
      }
      return;
    }
  }
  
  public static boolean a(FilterDesc paramFilterDesc)
  {
    Object localObject = paramFilterDesc.getResFold(CaptureVideoFilterManager.b);
    if ((paramFilterDesc.respicname != null) && (!paramFilterDesc.respicname.equals("")))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(paramFilterDesc.respicname);
      if (!new File(localStringBuilder.toString()).exists())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("check false respicname file not exists :");
        ((StringBuilder)localObject).append(paramFilterDesc.name);
        QLog.i("VideoFilterListDownloader", 2, ((StringBuilder)localObject).toString());
        return true;
      }
    }
    return false;
  }
  
  private void b(FilterDesc paramFilterDesc)
  {
    ThreadManager.getSubThreadHandler().post(new VideoFilterListDownloader.1(this, paramFilterDesc));
  }
  
  private boolean b(FilterDesc paramFilterDesc, VideoFilterListDownloader.downloadListTaskListener paramdownloadListTaskListener)
  {
    this.c.lock();
    try
    {
      VideoFilterListDownloader.DownloadListTask localDownloadListTask = (VideoFilterListDownloader.DownloadListTask)this.b.get(paramFilterDesc.name);
      boolean bool;
      if (localDownloadListTask == null)
      {
        localDownloadListTask = new VideoFilterListDownloader.DownloadListTask(this);
        localDownloadListTask.a = paramFilterDesc;
        localDownloadListTask.b.add(new WeakReference(paramdownloadListTaskListener));
        this.b.put(paramFilterDesc.name, localDownloadListTask);
        bool = false;
      }
      else
      {
        bool = true;
        localDownloadListTask.b.add(new WeakReference(paramdownloadListTaskListener));
      }
      return bool;
    }
    finally
    {
      this.c.unlock();
    }
  }
  
  public void a(FilterDesc paramFilterDesc, VideoFilterListDownloader.downloadListTaskListener paramdownloadListTaskListener)
  {
    if (!b(paramFilterDesc, paramdownloadListTaskListener)) {
      b(paramFilterDesc);
    }
  }
  
  public void onFailed(NetResp paramNetResp)
  {
    paramNetResp = (FilterDesc)paramNetResp.mReq.getUserData();
    if (paramNetResp != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MyListDownloaderListener onFailed file: ");
      localStringBuilder.append(paramNetResp.resurl);
      QLog.e("VideoFilterListDownloader", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterListDownloader
 * JD-Core Version:    0.7.0.1
 */