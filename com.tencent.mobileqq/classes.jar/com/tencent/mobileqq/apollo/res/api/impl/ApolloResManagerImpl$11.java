package com.tencent.mobileqq.apollo.res.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.utils.ApolloListenerManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

class ApolloResManagerImpl$11
  extends DownloadListener
{
  ApolloResManagerImpl$11(ApolloResManagerImpl paramApolloResManagerImpl) {}
  
  public void onDone(DownloadTask paramDownloadTask) {}
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask == null) {
      return;
    }
    Object localObject = paramDownloadTask.a();
    if (localObject == null) {
      return;
    }
    int i = ((Bundle)localObject).getInt(paramDownloadTask.c);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[onDoneFile], taskType:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(",httpCode: ");
      ((StringBuilder)localObject).append(paramDownloadTask.f);
      ((StringBuilder)localObject).append(", status: ");
      ((StringBuilder)localObject).append(paramDownloadTask.a());
      ((StringBuilder)localObject).append(",task.currUrl:");
      ((StringBuilder)localObject).append(paramDownloadTask.c);
      QLog.d("[cmshow]cm_res", 2, ((StringBuilder)localObject).toString());
    }
    if (1 != i) {
      return;
    }
    super.onDone(paramDownloadTask);
    if (paramDownloadTask.a() != 3) {
      this.a.mListenerManager.a(Boolean.valueOf(false));
    }
    try
    {
      this.a.parseActionPanelJSon();
      VipUtils.a(ApolloResManagerImpl.access$200(this.a), "cmshow", "Apollo", "json_download_success", 0, 0, new String[0]);
      return;
    }
    catch (Exception paramDownloadTask)
    {
      QLog.e("[cmshow]cm_res", 1, "read apollo panel json content fail", paramDownloadTask);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.impl.ApolloResManagerImpl.11
 * JD-Core Version:    0.7.0.1
 */