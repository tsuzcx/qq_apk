package com.tencent.mobileqq.app.automator.step;

import android.os.Build.VERSION;
import ansg;
import aoik;
import aqwe;
import asbm;
import avmh;
import awcz;
import blvy;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.PluginConfigProxy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import protocol.KQQConfig.GetResourceReqInfo;

public class GetConfig
  extends AsyncStep
{
  private ResourcePluginListener a;
  
  public int a()
  {
    ((awcz)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getBusinessHandler(BusinessHandlerFactory.COMMPLGUGIN_HANDLER)).a();
    Object localObject = new PluginConfigProxy();
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getAboutConfig().a((PluginConfigProxy)localObject);
    ((PluginConfigProxy)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app);
    ((blvy)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(QQManagerFactory.MGR_PLUGIN)).a();
    ((asbm)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER)).a(true);
    localObject = (ansg)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
    ((ansg)localObject).a(null, new GetResourceReqInfo[] { ((ansg)localObject).d(), ((ansg)localObject).f(), ((ansg)localObject).b(), ((ansg)localObject).e(), ((ansg)localObject).c() });
    if (!"5.0.2".equals(Build.VERSION.RELEASE))
    {
      int i = NetworkUtil.getNetworkType(BaseApplication.getContext());
      if ((i == 1) || (i == 4))
      {
        localObject = new GetConfig.1(this);
        PreDownloadController localPreDownloadController = (PreDownloadController)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2);
        if (!localPreDownloadController.isEnable()) {
          break label268;
        }
        localPreDownloadController.requestPreDownload(10057, null, "tvk_sdkmgr", 0, "http://tvk_sdkmgr/unkown", "unkown", 1, 0, false, new RunnableTask(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app, "tvk_sdkmgr", (Runnable)localObject, 4000L));
      }
    }
    for (;;)
    {
      avmh.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app).b();
      return 2;
      label268:
      ((Runnable)localObject).run();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener = new aoik(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addLebaListener(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addAboutListener(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetConfig
 * JD-Core Version:    0.7.0.1
 */