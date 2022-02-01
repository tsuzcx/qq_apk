package com.tencent.av.ui.redbag;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.ControlUIObserver.CPreEventInfo;
import com.tencent.qphone.base.util.QLog;

class AVRedBag$3
  extends ControlUIObserver
{
  AVRedBag$3(AVRedBag paramAVRedBag) {}
  
  public void a(ControlUIObserver.CPreEventInfo paramCPreEventInfo)
  {
    AVRedBagMgr localAVRedBagMgr = this.a.a();
    if (localAVRedBagMgr == null) {}
    while ((!localAVRedBagMgr.a()) || (localAVRedBagMgr.d())) {
      return;
    }
    RedBagReport.c();
    TipsUtil.a(this.a.a, 1045, 2131695797);
    paramCPreEventInfo.jdField_b_of_type_Boolean = true;
    paramCPreEventInfo.jdField_b_of_type_JavaLangString = "AVRedBag";
  }
  
  public void a(String paramString, Boolean paramBoolean)
  {
    paramString = this.a.a();
    if (paramString != null)
    {
      GetRedBag localGetRedBag = paramString.jdField_a_of_type_ComTencentAvUiRedbagGetRedBag;
      if (localGetRedBag != null) {
        localGetRedBag.a(-4, 10000L);
      }
      paramString.c(paramBoolean.booleanValue());
    }
  }
  
  public void b(String paramString, Boolean paramBoolean)
  {
    AVRedBagMgr localAVRedBagMgr = this.a.a();
    if (localAVRedBagMgr != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.a.i, 4, "onAVActivityStop, peerUin[" + paramString + "], isQuit[" + paramBoolean + "], isInGameMode[" + localAVRedBagMgr.a() + "], isGameStarter[" + localAVRedBagMgr.d() + "]");
      }
      if (localAVRedBagMgr.a()) {
        ((AVRedPacketManager)this.a.a.a(6)).b(false);
      }
      localAVRedBagMgr.c();
      if ((!paramBoolean.booleanValue()) && (localAVRedBagMgr.a()) && (!localAVRedBagMgr.d())) {
        RedBagReport.e();
      }
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    AVRedBagMgr localAVRedBagMgr = this.a.a();
    if (localAVRedBagMgr == null) {}
    do
    {
      do
      {
        return;
      } while ((!localAVRedBagMgr.a()) || (localAVRedBagMgr.jdField_a_of_type_ComTencentAvUiRedbagGameSink == null) || (localAVRedBagMgr.jdField_a_of_type_ComTencentAvUiRedbagGameSink.a == null));
      QLog.w(this.a.i, 1, "onViewSwitch, uinBig[" + paramString1 + "], uinSmall[" + paramString2 + "]");
    } while (!localAVRedBagMgr.jdField_a_of_type_ComTencentAvUiRedbagGameSink.a.jdField_b_of_type_Boolean);
    ((AVRedPacketManager)this.a.a.a(6)).a(paramString1, paramString2);
  }
  
  public void d(String paramString)
  {
    paramString = this.a.a();
    if ((paramString != null) && (paramString.a())) {
      ((AVRedPacketManager)this.a.a.a(6)).b(true);
    }
  }
  
  public void e(String paramString)
  {
    if (this.a.a == null) {
      return;
    }
    this.a.a.a().post(new AVRedBag.3.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.redbag.AVRedBag.3
 * JD-Core Version:    0.7.0.1
 */