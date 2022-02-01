package com.tencent.mobileqq.apollo.res.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.utils.ApolloListenerManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.engine.util.CMGetResPathUtil;
import com.tencent.mobileqq.cmshow.engine.util.CMResUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class ApolloResManagerImpl$10
  extends DownloadListener
{
  ApolloResManagerImpl$10(ApolloResManagerImpl paramApolloResManagerImpl) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]cm_res", 2, "download onDone");
    }
    if (paramDownloadTask.a() == 3) {
      VipUtils.a(ApolloResManagerImpl.access$200(this.a), "cmshow", "Apollo", "action_download_success", 0, 0, new String[0]);
    }
    if (this.a.mListenerManager != null) {
      this.a.mListenerManager.b();
    }
  }
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask == null)
    {
      QLog.e("[cmshow]cm_res", 1, "onDoneFile task is null");
      return;
    }
    Object localObject2 = paramDownloadTask.c;
    paramDownloadTask = paramDownloadTask.a();
    if (paramDownloadTask == null)
    {
      QLog.e("[cmshow]cm_res", 1, "onDoneFile params is null");
      return;
    }
    paramDownloadTask = (ApolloActionData)paramDownloadTask.getSerializable((String)localObject2);
    if (paramDownloadTask == null)
    {
      QLog.e("[cmshow]cm_res", 1, "action res onDoneFile but action data is null");
      return;
    }
    Object localObject1 = CMGetResPathUtil.a(paramDownloadTask, 4);
    if (((String)localObject2).equals(CMGetResPathUtil.a(paramDownloadTask, 5)))
    {
      try
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("action res zip done acitonid=");
          ((StringBuilder)localObject2).append(paramDownloadTask.actionId);
          ((StringBuilder)localObject2).append(" action name =");
          ((StringBuilder)localObject2).append(paramDownloadTask.actionName);
          QLog.d("[cmshow]cm_res", 2, ((StringBuilder)localObject2).toString());
        }
        if (!CMResUtil.a(paramDownloadTask.actionId, paramDownloadTask.personNum))
        {
          FileUtils.uncompressZip((String)localObject1, CMGetResPathUtil.a(paramDownloadTask, 6), false);
          FileUtils.deleteFile((String)localObject1);
          ApolloResManagerImpl.access$1000(this.a, paramDownloadTask);
        }
        ThreadManager.getFileThreadHandler().postDelayed(new ApolloResManagerImpl.10.1(this, paramDownloadTask), 2000L);
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          break label305;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uncompressZip fail zip file: ");
      localStringBuilder.append((String)localObject1);
      QLog.e("[cmshow]cm_res", 2, localStringBuilder.toString(), localException);
    }
    else if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onDoneFile panelView actionId = ");
      ((StringBuilder)localObject1).append(paramDownloadTask.actionId);
      ((StringBuilder)localObject1).append(" action name =");
      ((StringBuilder)localObject1).append(paramDownloadTask.actionName);
      QLog.d("[cmshow]cm_res", 2, ((StringBuilder)localObject1).toString());
    }
    label305:
    boolean bool;
    if (paramDownloadTask.compoundType > 0) {
      bool = CMResUtil.a(paramDownloadTask.actionId, 1, paramDownloadTask.personNum, false);
    } else {
      bool = CMResUtil.a(paramDownloadTask);
    }
    if ((bool) && (this.a.mListenerManager != null))
    {
      paramDownloadTask.status = 1;
      localObject1 = ApolloResManagerImpl.access$200(this.a);
      if (localObject1 != null) {
        ((ApolloDaoManagerServiceImpl)((AppRuntime)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all")).changeActionStatus(paramDownloadTask);
      }
      this.a.mListenerManager.a(paramDownloadTask);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.impl.ApolloResManagerImpl.10
 * JD-Core Version:    0.7.0.1
 */