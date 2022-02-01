package com.tencent.mobileqq.ark.core;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.ark.util.SysUtil;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

public class ArkPredownloader
{
  public static ArkPredownloader.Task a(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    ArkPredownloader.Task localTask = new ArkPredownloader.Task();
    localTask.jdField_a_of_type_JavaLangString = paramString2;
    localTask.b = paramString1;
    if ((SysUtil.a()) && ((paramAppRuntime instanceof BaseQQAppInterface)))
    {
      IPreDownloadController localIPreDownloadController = (IPreDownloadController)paramAppRuntime.getRuntimeService(IPreDownloadController.class, "");
      if (!localIPreDownloadController.isEnable())
      {
        QLog.i("ArkApp.PredownloadImpl", 1, String.format("requestDownload, not use pre-download, name=%s, URL=%s.", new Object[] { paramString1, paramString2 }));
        return localTask;
      }
      localTask.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = ((BaseQQAppInterface)paramAppRuntime);
      localTask.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localIPreDownloadController);
      return localTask;
    }
    QLog.i("ArkApp.PredownloadImpl", 1, "requestDownload, not in main process");
    return localTask;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkPredownloader
 * JD-Core Version:    0.7.0.1
 */