package com.tencent.mobileqq.apollo.web;

import com.tencent.mobileqq.apollo.model.ApolloPandora;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class CmShowWebIPCModule$8
  implements Runnable
{
  CmShowWebIPCModule$8(CmShowWebIPCModule paramCmShowWebIPCModule, QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    IApolloDaoManagerService localIApolloDaoManagerService = (IApolloDaoManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
    ApolloPandora localApolloPandora = localIApolloDaoManagerService.getApolloPandora(this.jdField_a_of_type_JavaLangString, true);
    if (localApolloPandora != null)
    {
      localApolloPandora.hadStolen = 1;
      localIApolloDaoManagerService.saveOrUpdateApolloPandora(localApolloPandora);
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]CmShowHandler", 2, "setCapsuleHadStolenAsync uin had Stolen");
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("[cmshow]CmShowHandler", 2, "setCapsuleHadStolenAsync local not save apolloPandora");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.CmShowWebIPCModule.8
 * JD-Core Version:    0.7.0.1
 */