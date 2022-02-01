package com.tencent.mobileqq.app.automator.step;

import android.os.Build.VERSION;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.PluginConfigProxy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.hotpic.HotPicManager;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.observer.ResourcePluginListener;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.plugin.IPluginManager;
import protocol.KQQConfig.GetResourceReqInfo;

public class GetConfig
  extends AsyncStep
{
  private ResourcePluginListener a;
  
  public int a()
  {
    ((ILebaHelperService)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getRuntimeService(ILebaHelperService.class, "")).getAllPluginList(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a);
    Object localObject = new PluginConfigProxy();
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getAboutConfig().a((PluginConfigProxy)localObject);
    ((PluginConfigProxy)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a);
    ((IPluginManager)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getManager(QQManagerFactory.MGR_PLUGIN)).a();
    ((EarlyDownloadManager)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getManager(QQManagerFactory.EARLY_DOWNLOAD_MANAGER)).a(true);
    localObject = (ConfigHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
    ((ConfigHandler)localObject).a(null, new GetResourceReqInfo[] { ((ConfigHandler)localObject).d(), ((ConfigHandler)localObject).f(), ((ConfigHandler)localObject).b(), ((ConfigHandler)localObject).e(), ((ConfigHandler)localObject).c() });
    if (!"5.0.2".equals(Build.VERSION.RELEASE))
    {
      int i = NetworkUtil.b(BaseApplication.getContext());
      if ((i == 1) || (i == 4))
      {
        localObject = new GetConfig.1(this);
        PreDownloadController localPreDownloadController = (PreDownloadController)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2);
        if (!localPreDownloadController.isEnable()) {
          break label278;
        }
        localPreDownloadController.requestPreDownload(10057, null, "tvk_sdkmgr", 0, "http://tvk_sdkmgr/unkown", "unkown", 1, 0, false, new RunnableTask(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a, "tvk_sdkmgr", (Runnable)localObject, 4000L));
      }
    }
    for (;;)
    {
      HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a).b();
      return 2;
      label278:
      ((Runnable)localObject).run();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLebaObserverResourcePluginListener == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqLebaObserverResourcePluginListener = new GetConfig.MyResourcePluginListener(this, null);
      ((ILebaHelperService)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.getRuntimeService(ILebaHelperService.class, "")).addLebaListener(this.jdField_a_of_type_ComTencentMobileqqLebaObserverResourcePluginListener);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a.addAboutListener(this.jdField_a_of_type_ComTencentMobileqqLebaObserverResourcePluginListener);
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaObserverResourcePluginListener = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetConfig
 * JD-Core Version:    0.7.0.1
 */