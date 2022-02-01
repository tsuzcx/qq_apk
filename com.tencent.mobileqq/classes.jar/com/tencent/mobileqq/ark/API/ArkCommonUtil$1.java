package com.tencent.mobileqq.ark.API;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ark.ArkAppCGI;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.image.ChooseImageIPCModule;
import com.tencent.mobileqq.ark.image.ChooseImageIPCModule.IReportCallBack;
import com.tencent.qphone.base.util.QLog;

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
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if ((localObject instanceof QQAppInterface)) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        localObject = ((ArkAppCenter)((QQAppInterface)localObject).getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER)).a();
        if (localObject != null) {
          ((ArkAppCGI)localObject).a(paramString);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkCommonUtil.1
 * JD-Core Version:    0.7.0.1
 */