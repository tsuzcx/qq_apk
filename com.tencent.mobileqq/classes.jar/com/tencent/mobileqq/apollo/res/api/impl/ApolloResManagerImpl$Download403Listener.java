package com.tencent.mobileqq.apollo.res.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.apollo.listener.Download403Callback;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class ApolloResManagerImpl$Download403Listener
  extends DownloadListener
{
  WeakReference<AppRuntime> a;
  WeakReference<Download403Callback> b;
  
  public ApolloResManagerImpl$Download403Listener(AppRuntime paramAppRuntime, Download403Callback paramDownload403Callback)
  {
    this.a = new WeakReference(paramAppRuntime);
    this.b = new WeakReference(paramDownload403Callback);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    Object localObject1 = (AppRuntime)this.a.get();
    Download403Callback localDownload403Callback = (Download403Callback)this.b.get();
    if ((localObject1 != null) && (localDownload403Callback != null) && (paramDownloadTask != null) && (paramDownloadTask.a() != null))
    {
      if (paramDownloadTask.jdField_a_of_type_JavaUtilMap == null) {
        return;
      }
      super.onDone(paramDownloadTask);
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloManager", 2, new Object[] { "mDownload403Listener [onDoneFile] httpCode: ", Integer.valueOf(paramDownloadTask.f), ", status: ", Integer.valueOf(paramDownloadTask.a()), ",task.currUrl:", paramDownloadTask.c });
      }
      if (paramDownloadTask.jdField_a_of_type_Int == 0)
      {
        localObject1 = ((AppRuntime)localObject1).getApplication().getSharedPreferences("apollo_sp", 0).edit();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramDownloadTask.c);
        ((StringBuilder)localObject2).append("_lastModifiedTime");
        ((SharedPreferences.Editor)localObject1).putLong(((StringBuilder)localObject2).toString(), paramDownloadTask.i);
        long l2 = 0L;
        localObject2 = (File)paramDownloadTask.jdField_a_of_type_JavaUtilMap.get(paramDownloadTask.c);
        long l1 = l2;
        if (localObject2 != null)
        {
          l1 = l2;
          if (((File)localObject2).exists())
          {
            l1 = ((File)localObject2).lastModified();
            ((SharedPreferences.Editor)localObject1).putLong(paramDownloadTask.c, l1);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloManager", 2, new Object[] { "mDownload403Listener [onDoneFile] lastModifiedTime:", Long.valueOf(paramDownloadTask.i), ",file sd lastModifiedTime:", Long.valueOf(l1) });
        }
        ((SharedPreferences.Editor)localObject1).commit();
      }
      localDownload403Callback.a(paramDownloadTask.jdField_a_of_type_Int, paramDownloadTask.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.impl.ApolloResManagerImpl.Download403Listener
 * JD-Core Version:    0.7.0.1
 */