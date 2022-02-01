package com.tencent.mobileqq.ark.api;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.image.ChooseImageIPCModule;
import com.tencent.mobileqq.ark.image.ChooseImageIPCModule.IReportCallBack;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

final class ArkCommonUtil$1
  implements ChooseImageIPCModule.IReportCallBack
{
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp.ArkCommonUtil", 2, "ArkSafe.report onDisableReport");
    }
    ChooseImageIPCModule.a().a(null);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp.ArkCommonUtil", 2, new Object[] { "ArkSafe.report onReportUrlCheck content=", paramString });
    }
    QQAppInterface localQQAppInterface = null;
    AppRuntime localAppRuntime = BaseApplicationImpl.sApplication.getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)localAppRuntime;
    }
    if (localQQAppInterface != null) {
      ((IArkService)localQQAppInterface.getRuntimeService(IArkService.class)).doURLReport(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.ArkCommonUtil.1
 * JD-Core Version:    0.7.0.1
 */