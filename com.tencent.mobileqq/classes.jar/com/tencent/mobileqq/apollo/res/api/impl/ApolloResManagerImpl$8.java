package com.tencent.mobileqq.apollo.res.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.model.ApolloPreDownloadData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.engine.util.CMResUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ApolloResManagerImpl$8
  extends DownloadListener
{
  ApolloResManagerImpl$8(ApolloResManagerImpl paramApolloResManagerImpl) {}
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask == null) {
      return;
    }
    if (paramDownloadTask.a != 0)
    {
      QLog.e("[cmshow]cm_res", 1, new Object[] { "preDownloadListener task error:", Integer.valueOf(paramDownloadTask.a()) });
      return;
    }
    String str = paramDownloadTask.c;
    paramDownloadTask = paramDownloadTask.a();
    if (paramDownloadTask != null)
    {
      ApolloPreDownloadData localApolloPreDownloadData = (ApolloPreDownloadData)paramDownloadTask.getSerializable(str);
      if (localApolloPreDownloadData == null)
      {
        QLog.e("[cmshow]cm_res", 1, "preDownloadListener res onDoneFile but preDownload data is null");
        return;
      }
      if (!TextUtils.isEmpty(localApolloPreDownloadData.zipDir))
      {
        paramDownloadTask = new StringBuilder();
        paramDownloadTask.append(CMResUtil.c(localApolloPreDownloadData.dirType));
        localObject = localApolloPreDownloadData.zipDir;
      }
      else
      {
        paramDownloadTask = new StringBuilder();
        paramDownloadTask.append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/pre_download/");
        paramDownloadTask.append(localApolloPreDownloadData.resId);
        localObject = ".zip";
      }
      paramDownloadTask.append((String)localObject);
      paramDownloadTask = paramDownloadTask.toString();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(CMResUtil.c(localApolloPreDownloadData.dirType));
      ((StringBuilder)localObject).append(localApolloPreDownloadData.dir);
      localObject = ((StringBuilder)localObject).toString();
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]cm_res", 2, new Object[] { "preDownloadListener res zip done reportId:", localApolloPreDownloadData.reportId, ", url:", str });
      }
      ThreadManager.getSubThreadHandler().post(new ApolloResManagerImpl.8.1(this, localApolloPreDownloadData, paramDownloadTask, (String)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.impl.ApolloResManagerImpl.8
 * JD-Core Version:    0.7.0.1
 */