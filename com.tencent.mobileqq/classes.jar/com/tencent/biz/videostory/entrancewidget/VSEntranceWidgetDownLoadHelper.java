package com.tencent.biz.videostory.entrancewidget;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.biz.videostory.config.processor.VSEntranceStyleBean;
import com.tencent.biz.videostory.config.processor.VSEntranceWidgetBean;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.Downloader.DownloadListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VSEntranceWidgetDownLoadHelper
{
  public static String a;
  private static VSEntranceWidgetDownLoadHelper b;
  private Map<String, VSEntranceWidgetDownLoadHelper.DownLoadStatus> c = new ConcurrentHashMap();
  
  private VSEntranceWidgetDownLoadHelper()
  {
    a(BaseApplicationImpl.getContext());
  }
  
  public static VSEntranceWidgetDownLoadHelper a()
  {
    try
    {
      if (b == null) {
        b = new VSEntranceWidgetDownLoadHelper();
      }
      VSEntranceWidgetDownLoadHelper localVSEntranceWidgetDownLoadHelper = b;
      return localVSEntranceWidgetDownLoadHelper;
    }
    finally {}
  }
  
  private String a(Context paramContext)
  {
    if (TextUtils.isEmpty(a))
    {
      paramContext = paramContext.getExternalFilesDir("video_story");
      if (paramContext != null) {
        a = paramContext.getAbsolutePath();
      }
    }
    if (TextUtils.isEmpty(a))
    {
      paramContext = Environment.getExternalStorageDirectory().getAbsolutePath();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext);
      localStringBuilder.append("/Tencent/MobileQQ/");
      localStringBuilder.append("video_story");
      a = localStringBuilder.toString();
    }
    paramContext = new StringBuilder();
    paramContext.append("intDownLoadRoot");
    paramContext.append(a);
    QZLog.i("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, paramContext.toString());
    return null;
  }
  
  public void a(VSEntranceStyleBean paramVSEntranceStyleBean)
  {
    if (paramVSEntranceStyleBean != null) {
      a(paramVSEntranceStyleBean.a(), null);
    }
  }
  
  public void a(VSEntranceWidgetBean paramVSEntranceWidgetBean)
  {
    if (paramVSEntranceWidgetBean != null) {
      a(paramVSEntranceWidgetBean.a(), null);
    }
  }
  
  public void a(String paramString, Downloader.DownloadListener paramDownloadListener)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("downLoadByUrl:");
    ((StringBuilder)localObject1).append(paramString);
    QZLog.i("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, ((StringBuilder)localObject1).toString());
    if (TextUtils.isEmpty(paramString))
    {
      QZLog.e("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, new Object[] { "downLoadByUrl:url is empty" });
      return;
    }
    localObject1 = d(paramString);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      QZLog.e("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, new Object[] { "downLoadByUrl:prefixId is empty" });
      return;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("downLoadByUrl:prefixId:");
    ((StringBuilder)localObject2).append((String)localObject1);
    QZLog.d("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, ((StringBuilder)localObject2).toString());
    if (b((String)localObject1))
    {
      QZLog.d("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "downLoadByUrl:resource has download");
      return;
    }
    if (c((String)localObject1))
    {
      QZLog.d("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, "downLoadByUrl:resource on download");
      return;
    }
    if (TextUtils.isEmpty(a))
    {
      QZLog.e("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, new Object[] { "downLoadByUrl:mDownLoadRoot is empty" });
      return;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(a);
    ((StringBuilder)localObject2).append("/");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(".zip");
    localObject2 = ((StringBuilder)localObject2).toString();
    if (!TextUtils.isEmpty(paramString))
    {
      VSEntranceWidgetDownLoadHelper.DownLoadStatus localDownLoadStatus = new VSEntranceWidgetDownLoadHelper.DownLoadStatus(this, null);
      this.c.put(localObject1, localDownLoadStatus);
      DownloaderInterface localDownloaderInterface = ((DownloaderFactory)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
      if (localDownloaderInterface != null)
      {
        DownloadTask localDownloadTask = new DownloadTask(paramString, new File((String)localObject2));
        localDownloadTask.e = 1;
        Bundle localBundle = new Bundle();
        if (localDownloaderInterface != null) {
          localDownloaderInterface.startDownload(localDownloadTask, new VSEntranceWidgetDownLoadHelper.1(this, paramDownloadListener, (String)localObject2, localDownLoadStatus, (String)localObject1, paramString), localBundle);
        }
      }
    }
  }
  
  public boolean a(String paramString)
  {
    paramString = d(paramString);
    if (!TextUtils.isEmpty(paramString)) {
      return b(paramString);
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(a);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(".zip");
    if (new File(localStringBuilder.toString()).exists())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("upZip failed:");
      ((StringBuilder)localObject).append(paramString);
      QZLog.d("Q.videostory.config.VSEntranceWidgetDownLoadHelper", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    boolean bool1;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      boolean bool2 = new File((String)localObject).exists();
      bool1 = bool2;
      if (bool2)
      {
        localObject = new VSEntranceWidgetDownLoadHelper.DownLoadStatus(this, null);
        VSEntranceWidgetDownLoadHelper.DownLoadStatus.a((VSEntranceWidgetDownLoadHelper.DownLoadStatus)localObject, 0);
        this.c.put(paramString, localObject);
        return bool2;
      }
    }
    else
    {
      bool1 = false;
    }
    return bool1;
  }
  
  public boolean c(String paramString)
  {
    paramString = (VSEntranceWidgetDownLoadHelper.DownLoadStatus)this.c.get(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null) {
      if (VSEntranceWidgetDownLoadHelper.DownLoadStatus.a(paramString) != -1)
      {
        bool1 = bool2;
        if (VSEntranceWidgetDownLoadHelper.DownLoadStatus.a(paramString) != 1) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public String d(String paramString)
  {
    try
    {
      paramString = paramString.split("/");
      paramString = paramString[(paramString.length - 1)];
      paramString = paramString.substring(0, paramString.indexOf(".zip"));
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public String e(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append("/");
    localStringBuilder.append(d(paramString));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.entrancewidget.VSEntranceWidgetDownLoadHelper
 * JD-Core Version:    0.7.0.1
 */