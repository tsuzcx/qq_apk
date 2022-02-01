package com.qwallet.temp.impl;

import com.qwallet.temp.IIndividualRedPacket;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class IndividualRedPacketImpl
  implements IIndividualRedPacket
{
  private QQAppInterface mApp;
  
  private boolean checkAppRuntimeInValid()
  {
    if (QLog.isColorLevel())
    {
      boolean bool;
      if (this.mApp == null) {
        bool = true;
      } else {
        bool = false;
      }
      QLog.d("IndividualRedPacketImpl", 2, new Object[] { "checkAppRuntimeInValid: ", Boolean.valueOf(bool) });
    }
    return this.mApp == null;
  }
  
  private IndividualRedPacketManager getManager()
  {
    return (IndividualRedPacketManager)this.mApp.getManager(QQManagerFactory.INDIVIDUAL_RED_PACKET_MANAGER);
  }
  
  public int IndividualRedPacketManager$FLAG_REDPACKET_CANNOT_USE()
  {
    return 0;
  }
  
  public int IndividualRedPacketManager$FLAG_REDPACKET_ENABLE()
  {
    return 0;
  }
  
  public boolean IndividualRedPacketResDownloader$isShowRedpacket()
  {
    if (checkAppRuntimeInValid()) {
      return false;
    }
    return getManager().a().j;
  }
  
  public void dealRedPacketToShow(RedPacketInfo paramRedPacketInfo)
  {
    IndividualRedPacketManager.a(this.mApp, getManager(), paramRedPacketInfo);
  }
  
  public boolean getIndividualRedPacketEnable()
  {
    if (checkAppRuntimeInValid()) {
      return false;
    }
    return getManager().f();
  }
  
  public String getMallURL(int paramInt)
  {
    return IndividualRedPacketManager.a(paramInt, this.mApp);
  }
  
  public String getTenpayCombineImg(String paramString1, String paramString2)
  {
    if (checkAppRuntimeInValid()) {
      return null;
    }
    return getManager().a(paramString1, paramString2);
  }
  
  public boolean isAllowShowRedpacket()
  {
    if (checkAppRuntimeInValid()) {
      return false;
    }
    return getManager().h();
  }
  
  public boolean isIndividualRedPacketEnable()
  {
    if (checkAppRuntimeInValid()) {
      return false;
    }
    return getManager().g();
  }
  
  public boolean isSDCardError()
  {
    if (checkAppRuntimeInValid()) {
      return false;
    }
    return getManager().m.get();
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      this.mApp = ((QQAppInterface)paramAppRuntime);
    }
  }
  
  public void onDestroy() {}
  
  public void setRedPacketFlags(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (checkAppRuntimeInValid()) {
      return;
    }
    getManager().a(paramInt1, paramInt2, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.qwallet.temp.impl.IndividualRedPacketImpl
 * JD-Core Version:    0.7.0.1
 */