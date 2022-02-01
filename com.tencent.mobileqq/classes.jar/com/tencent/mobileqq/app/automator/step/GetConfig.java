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
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.hotpic.HotPicManager;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.observer.ResourcePluginListener;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.plugin.IPluginManager;
import protocol.KQQConfig.GetResourceReqInfo;

public class GetConfig
  extends AsyncStep
{
  private ResourcePluginListener a;
  
  protected int doStep()
  {
    ((ILebaHelperService)this.mAutomator.k.getRuntimeService(ILebaHelperService.class, "")).getAllPluginList(this.mAutomator.k);
    Object localObject = new PluginConfigProxy();
    this.mAutomator.k.getAboutConfig().a((PluginConfigProxy)localObject);
    ((PluginConfigProxy)localObject).a(this.mAutomator.k);
    ((IPluginManager)this.mAutomator.k.getManager(QQManagerFactory.MGR_PLUGIN)).a();
    ((IEarlyDownloadService)this.mAutomator.k.getRuntimeService(IEarlyDownloadService.class, "")).updateConfigs(true);
    localObject = (ConfigHandler)this.mAutomator.k.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
    ((ConfigHandler)localObject).a(null, new GetResourceReqInfo[] { ((ConfigHandler)localObject).j(), ((ConfigHandler)localObject).l(), ((ConfigHandler)localObject).h(), ((ConfigHandler)localObject).k(), ((ConfigHandler)localObject).i() });
    if (!"5.0.2".equals(Build.VERSION.RELEASE))
    {
      int i = NetworkUtil.getNetworkType(BaseApplication.getContext());
      if ((i == 1) || (i == 4))
      {
        localObject = new GetConfig.1(this);
        IPreDownloadController localIPreDownloadController = (IPreDownloadController)this.mAutomator.k.getRuntimeService(IPreDownloadController.class);
        if (localIPreDownloadController.isEnable()) {
          localIPreDownloadController.requestPreDownload(10057, null, "tvk_sdkmgr", 0, "http://tvk_sdkmgr/unkown", "unkown", 1, 0, false, new RunnableTask(this.mAutomator.k, "tvk_sdkmgr", (Runnable)localObject, 4000L));
        } else {
          ((Runnable)localObject).run();
        }
      }
    }
    HotPicManager.a(this.mAutomator.k).d();
    return 2;
  }
  
  public void onCreate()
  {
    if (this.a == null)
    {
      this.a = new GetConfig.MyResourcePluginListener(this, null);
      ((ILebaHelperService)this.mAutomator.k.getRuntimeService(ILebaHelperService.class, "")).addLebaListener(this.a);
      this.mAutomator.k.addAboutListener(this.a);
    }
  }
  
  public void onDestroy()
  {
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetConfig
 * JD-Core Version:    0.7.0.1
 */