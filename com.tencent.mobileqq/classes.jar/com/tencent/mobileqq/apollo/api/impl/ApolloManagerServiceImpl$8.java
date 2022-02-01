package com.tencent.mobileqq.apollo.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.utils.ApolloListenerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

class ApolloManagerServiceImpl$8
  extends DownloadListener
{
  ApolloManagerServiceImpl$8(ApolloManagerServiceImpl paramApolloManagerServiceImpl) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloManager", 2, "download onDone");
    }
    if (paramDownloadTask.a() == 3) {
      VipUtils.a(ApolloManagerServiceImpl.access$300(this.a), "cmshow", "Apollo", "action_download_success", 0, 0, new String[0]);
    }
    if (this.a.mListenerManager != null) {
      this.a.mListenerManager.b();
    }
  }
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask == null) {}
    label311:
    label317:
    for (;;)
    {
      return;
      Object localObject = paramDownloadTask.c;
      paramDownloadTask = paramDownloadTask.a();
      if (paramDownloadTask != null)
      {
        paramDownloadTask = (ApolloActionData)paramDownloadTask.getSerializable((String)localObject);
        if (paramDownloadTask == null)
        {
          QLog.e("ApolloManager", 1, "action res onDoneFile but action data is null");
          return;
        }
        String str = ApolloUtilImpl.getApolloResPath(paramDownloadTask, 4);
        if (((String)localObject).equals(ApolloUtilImpl.getApolloResPath(paramDownloadTask, 5)))
        {
          try
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, "action res zip done acitonid=" + paramDownloadTask.actionId + " action name =" + paramDownloadTask.actionName);
            }
            if (!ApolloUtilImpl.isActionResDone(paramDownloadTask.actionId, paramDownloadTask.personNum))
            {
              FileUtils.a(str, ApolloUtilImpl.getApolloResPath(paramDownloadTask, 6), false);
              FileUtils.e(str);
              ApolloManagerServiceImpl.access$900(this.a, paramDownloadTask);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.e("ApolloManager", 2, "uncompressZip fail zip file: " + str, localException);
              }
            }
          }
          if (paramDownloadTask.compoundType <= 0) {
            break label311;
          }
        }
        for (boolean bool = ApolloUtilImpl.isWhiteFaceActionRscDone(paramDownloadTask.actionId, 1, paramDownloadTask.personNum, false);; bool = ApolloUtilImpl.isActionDone(paramDownloadTask))
        {
          if ((!bool) || (this.a.mListenerManager == null)) {
            break label317;
          }
          paramDownloadTask.status = 1;
          localObject = ApolloManagerServiceImpl.access$300(this.a);
          if (localObject != null) {
            ((ApolloDaoManagerServiceImpl)((QQAppInterface)localObject).getRuntimeService(IApolloDaoManagerService.class, "all")).changeActionStatus(paramDownloadTask);
          }
          this.a.mListenerManager.a(paramDownloadTask);
          return;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ApolloManager", 2, "onDoneFile panelView actionId = " + paramDownloadTask.actionId + " action name =" + paramDownloadTask.actionName);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.8
 * JD-Core Version:    0.7.0.1
 */