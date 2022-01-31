package com.tencent.mobileqq.app.automator.step;

import android.os.Build.VERSION;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.LebaHelper;
import com.tencent.mobileqq.app.PluginConfigProxy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.config.ResourcePluginListener;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.hotpic.HotPicManager;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.plugin.IPluginManager;
import protocol.KQQConfig.GetResourceReqInfo;
import znm;
import znn;

public class GetConfig
  extends AsyncStep
{
  private ResourcePluginListener a;
  
  protected int a()
  {
    Object localObject = new PluginConfigProxy();
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a().a((PluginConfigProxy)localObject);
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a().a((PluginConfigProxy)localObject);
    ((PluginConfigProxy)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b);
    ((IPluginManager)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.getManager(26)).a();
    ((EarlyDownloadManager)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.getManager(76)).b();
    localObject = (ConfigHandler)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a(4);
    ((ConfigHandler)localObject).a(null, new GetResourceReqInfo[] { ((ConfigHandler)localObject).d(), ((ConfigHandler)localObject).f(), ((ConfigHandler)localObject).b(), ((ConfigHandler)localObject).e(), ((ConfigHandler)localObject).c() });
    if ((!"5.0.2".equals(Build.VERSION.RELEASE)) && (NetworkUtil.b(BaseApplication.getContext()) == 1))
    {
      localObject = new znm(this);
      PreDownloadController localPreDownloadController = (PreDownloadController)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.getManager(192);
      if (!localPreDownloadController.a()) {
        break label251;
      }
      localPreDownloadController.a(10057, null, "tvk_sdkmgr", 0, "http://tvk_sdkmgr/unkown", "unkown", 1, 0, false, new RunnableTask(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b, "tvk_sdkmgr", (Runnable)localObject, 4000L));
    }
    for (;;)
    {
      HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b).b();
      return 2;
      label251:
      ((Runnable)localObject).run();
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener = new znn(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.a(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b.b(this.jdField_a_of_type_ComTencentMobileqqConfigResourcePluginListener);
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