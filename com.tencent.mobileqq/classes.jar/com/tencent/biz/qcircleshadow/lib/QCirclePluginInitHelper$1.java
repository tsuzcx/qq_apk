package com.tencent.biz.qcircleshadow.lib;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import mqq.app.AppRuntime;

final class QCirclePluginInitHelper$1
  implements Runnable
{
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {}
    do
    {
      do
      {
        return;
      } while (!(localObject instanceof QQAppInterface));
      localObject = (WebProcessManager)((AppRuntime)localObject).getManager(QQManagerFactory.WEBPROCESS_MANAGER);
    } while (localObject == null);
    ((WebProcessManager)localObject).e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCirclePluginInitHelper.1
 * JD-Core Version:    0.7.0.1
 */