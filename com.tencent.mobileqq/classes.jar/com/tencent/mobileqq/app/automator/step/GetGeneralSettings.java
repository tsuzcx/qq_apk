package com.tencent.mobileqq.app.automator.step;

import ConfigPush.FileStoragePushFSSvcList;
import com.tencent.kingkong.Common;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.ptt.preop.PTTPreDownloader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.servlet.PushServlet;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import mqq.app.MobileQQ;

public class GetGeneralSettings
  extends AsyncStep
{
  private FriendListObserver a;
  
  public int a()
  {
    ??? = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (??? != null)
    {
      Common.SetContext(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      Common.SetQQUni((String)???);
    }
    if ("0".endsWith(((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(DPCNames.KKFixerConfig.name(), "0")))
    {
      Common.SetDPCStatus(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), false);
      if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_Int != 1) {
        break label186;
      }
    }
    label186:
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        break label191;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new GetGeneralSettings.MyFriendListObserver(this, null);
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver, true);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAllGeneralSettings(bool)) {
        break label191;
      }
      return 2;
      Common.SetDPCStatus(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), true);
      Common.SetContext(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext());
      Common.SetSafeStatus(true);
      break;
    }
    label191:
    synchronized (FMTSrvAddrProvider.getInstance().saveSvcListLock)
    {
      FileStoragePushFSSvcList localFileStoragePushFSSvcList = FMTSrvAddrProvider.getInstance().getSvcListCache();
      if (localFileStoragePushFSSvcList != null)
      {
        PushServlet.a(localFileStoragePushFSSvcList, this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        FMTSrvAddrProvider.getInstance().setSvcListCache(null);
      }
      PTTPreDownloader.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(true, true);
      return 7;
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetGeneralSettings
 * JD-Core Version:    0.7.0.1
 */