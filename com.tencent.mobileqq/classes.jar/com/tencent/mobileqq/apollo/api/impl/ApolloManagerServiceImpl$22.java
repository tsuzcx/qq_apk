package com.tencent.mobileqq.apollo.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.model.ApolloPreDownloadData;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ApolloManagerServiceImpl$22
  extends DownloadListener
{
  ApolloManagerServiceImpl$22(ApolloManagerServiceImpl paramApolloManagerServiceImpl) {}
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask == null) {}
    String str1;
    do
    {
      return;
      if (paramDownloadTask.a != 0)
      {
        QLog.e("ApolloManager", 1, new Object[] { "preDownloadListener task error:", Integer.valueOf(paramDownloadTask.a()) });
        return;
      }
      str1 = paramDownloadTask.c;
      paramDownloadTask = paramDownloadTask.a();
    } while (paramDownloadTask == null);
    ApolloPreDownloadData localApolloPreDownloadData = (ApolloPreDownloadData)paramDownloadTask.getSerializable(str1);
    if (localApolloPreDownloadData == null)
    {
      QLog.e("ApolloManager", 1, "preDownloadListener res onDoneFile but preDownload data is null");
      return;
    }
    if (!TextUtils.isEmpty(localApolloPreDownloadData.zipDir)) {}
    for (paramDownloadTask = ApolloUtilImpl.getApolloFileDir(localApolloPreDownloadData.dirType) + localApolloPreDownloadData.zipDir;; paramDownloadTask = "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/pre_download/" + localApolloPreDownloadData.resId + ".zip")
    {
      String str2 = ApolloUtilImpl.getApolloFileDir(localApolloPreDownloadData.dirType) + localApolloPreDownloadData.dir;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, new Object[] { "preDownloadListener res zip done reportId:", localApolloPreDownloadData.reportId, ", url:", str1 });
      }
      ThreadManager.getSubThreadHandler().post(new ApolloManagerServiceImpl.22.1(this, localApolloPreDownloadData, paramDownloadTask, str2));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.22
 * JD-Core Version:    0.7.0.1
 */