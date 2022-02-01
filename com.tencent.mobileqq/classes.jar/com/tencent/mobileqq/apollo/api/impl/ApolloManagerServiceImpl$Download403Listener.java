package com.tencent.mobileqq.apollo.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.apollo.api.impl.listener.Download403Callback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import mqq.app.MobileQQ;

class ApolloManagerServiceImpl$Download403Listener
  extends DownloadListener
{
  WeakReference<QQAppInterface> a;
  WeakReference<Download403Callback> b;
  
  public ApolloManagerServiceImpl$Download403Listener(QQAppInterface paramQQAppInterface, Download403Callback paramDownload403Callback)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramDownload403Callback);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    Object localObject = (QQAppInterface)this.a.get();
    Download403Callback localDownload403Callback = (Download403Callback)this.b.get();
    if ((localObject == null) || (localDownload403Callback == null) || (paramDownloadTask == null) || (paramDownloadTask.a() == null) || (paramDownloadTask.jdField_a_of_type_JavaUtilMap == null)) {
      return;
    }
    super.onDone(paramDownloadTask);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, new Object[] { "mDownload403Listener [onDoneFile] httpCode: ", Integer.valueOf(paramDownloadTask.f), ", status: ", Integer.valueOf(paramDownloadTask.a()), ",task.currUrl:", paramDownloadTask.c });
    }
    if (paramDownloadTask.jdField_a_of_type_Int == 0)
    {
      localObject = ((QQAppInterface)localObject).getApplication().getSharedPreferences("apollo_sp", 0).edit();
      ((SharedPreferences.Editor)localObject).putLong(paramDownloadTask.c + "_lastModifiedTime", paramDownloadTask.i);
      long l2 = 0L;
      File localFile = (File)paramDownloadTask.jdField_a_of_type_JavaUtilMap.get(paramDownloadTask.c);
      long l1 = l2;
      if (localFile != null)
      {
        l1 = l2;
        if (localFile.exists())
        {
          l1 = localFile.lastModified();
          ((SharedPreferences.Editor)localObject).putLong(paramDownloadTask.c, l1);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, new Object[] { "mDownload403Listener [onDoneFile] lastModifiedTime:", Long.valueOf(paramDownloadTask.i), ",file sd lastModifiedTime:", Long.valueOf(l1) });
      }
      ((SharedPreferences.Editor)localObject).commit();
    }
    localDownload403Callback.a(paramDownloadTask.jdField_a_of_type_Int, paramDownloadTask.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.Download403Listener
 * JD-Core Version:    0.7.0.1
 */