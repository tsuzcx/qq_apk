package com.tencent.mobileqq.apollo.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.utils.ApolloListenerManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

class ApolloManagerServiceImpl$7
  extends DownloadListener
{
  ApolloManagerServiceImpl$7(ApolloManagerServiceImpl paramApolloManagerServiceImpl) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "download panel json done httpCode: " + paramDownloadTask.f + ", status: " + paramDownloadTask.a());
    }
  }
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask == null) {}
    Bundle localBundle;
    do
    {
      return;
      localBundle = paramDownloadTask.a();
    } while (localBundle == null);
    int i = localBundle.getInt(paramDownloadTask.c);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "[onDoneFile], taskType:" + i + ",httpCode: " + paramDownloadTask.f + ", status: " + paramDownloadTask.a() + ",task.currUrl:" + paramDownloadTask.c);
    }
    if (1 == i) {}
    try
    {
      super.onDone(paramDownloadTask);
      if (paramDownloadTask.a() != 3) {
        this.a.mListenerManager.a(Boolean.valueOf(false));
      }
      this.a.parseActionPanelJSon();
      VipUtils.a(ApolloManagerServiceImpl.access$300(this.a), "cmshow", "Apollo", "json_download_success", 0, 0, new String[0]);
      return;
    }
    catch (Exception paramDownloadTask)
    {
      QLog.e("ApolloManager", 1, "read apollo panel json content fail", paramDownloadTask);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.7
 * JD-Core Version:    0.7.0.1
 */