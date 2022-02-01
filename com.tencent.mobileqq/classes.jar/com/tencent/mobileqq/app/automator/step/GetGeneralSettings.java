package com.tencent.mobileqq.app.automator.step;

import ConfigPush.FileStoragePushFSSvcList;
import com.tencent.kingkong.Common;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.pttlogic.api.IPTTPreDownloader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.servlet.PushServlet;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class GetGeneralSettings
  extends AsyncStep
{
  private GetGeneralSettings.MyRoamSettingObserver a;
  
  protected int doStep()
  {
    ??? = this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (??? != null)
    {
      Common.SetContext(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      Common.SetQQUni((String)???);
    }
    boolean bool2 = "0".endsWith(((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.KKFixerConfig.name(), "0"));
    boolean bool1 = false;
    if (bool2)
    {
      Common.SetDPCStatus(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), false);
    }
    else
    {
      Common.SetDPCStatus(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), true);
      Common.SetContext(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext());
      Common.SetSafeStatus(true);
    }
    if (this.mAutomator.jdField_a_of_type_Int == 1) {
      bool1 = true;
    }
    if (bool1)
    {
      if (this.a == null)
      {
        this.a = new GetGeneralSettings.MyRoamSettingObserver(this, null);
        this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.a, true);
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("getAllGeneralSettings , needTroopSettings=");
        ((StringBuilder)???).append(bool1);
        QLog.d("QQInitHandler", 2, ((StringBuilder)???).toString());
      }
      ((IRoamSettingService)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IRoamSettingService.class, "")).loadAllRoamSettings(bool1);
      return 2;
    }
    synchronized (FMTSrvAddrProvider.getInstance().saveSvcListLock)
    {
      FileStoragePushFSSvcList localFileStoragePushFSSvcList = FMTSrvAddrProvider.getInstance().getSvcListCache();
      if (localFileStoragePushFSSvcList != null)
      {
        PushServlet.a(localFileStoragePushFSSvcList, this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        FMTSrvAddrProvider.getInstance().setSvcListCache(null);
      }
      ((IPTTPreDownloader)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPTTPreDownloader.class)).onAddrProviderReady(true, true);
      return 7;
    }
  }
  
  public void onDestroy()
  {
    if (this.a != null)
    {
      this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.a);
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetGeneralSettings
 * JD-Core Version:    0.7.0.1
 */