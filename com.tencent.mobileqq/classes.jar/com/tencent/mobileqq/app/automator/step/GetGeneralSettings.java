package com.tencent.mobileqq.app.automator.step;

import ConfigPush.FileStoragePushFSSvcList;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.pttlogic.api.IPTTPreDownloader;
import com.tencent.mobileqq.servlet.PushServlet;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService;
import com.tencent.qphone.base.util.QLog;

public class GetGeneralSettings
  extends AsyncStep
{
  private GetGeneralSettings.MyRoamSettingObserver a;
  
  protected int doStep()
  {
    boolean bool;
    if (this.mAutomator.b == 1) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      if (this.a == null)
      {
        this.a = new GetGeneralSettings.MyRoamSettingObserver(this, null);
        this.mAutomator.k.addObserver(this.a, true);
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("getAllGeneralSettings , needTroopSettings=");
        ((StringBuilder)???).append(bool);
        QLog.d("QQInitHandler", 2, ((StringBuilder)???).toString());
      }
      ((IRoamSettingService)this.mAutomator.k.getRuntimeService(IRoamSettingService.class, "")).loadAllRoamSettings(bool);
      return 2;
    }
    synchronized (FMTSrvAddrProvider.getInstance().saveSvcListLock)
    {
      FileStoragePushFSSvcList localFileStoragePushFSSvcList = FMTSrvAddrProvider.getInstance().getSvcListCache();
      if (localFileStoragePushFSSvcList != null)
      {
        PushServlet.a(localFileStoragePushFSSvcList, this.mAutomator.k);
        FMTSrvAddrProvider.getInstance().setSvcListCache(null);
      }
      ((IPTTPreDownloader)this.mAutomator.k.getRuntimeService(IPTTPreDownloader.class)).onAddrProviderReady(true, true);
      return 7;
    }
  }
  
  public void onDestroy()
  {
    if (this.a != null)
    {
      this.mAutomator.k.removeObserver(this.a);
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetGeneralSettings
 * JD-Core Version:    0.7.0.1
 */