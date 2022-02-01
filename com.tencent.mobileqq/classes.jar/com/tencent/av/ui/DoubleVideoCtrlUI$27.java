package com.tencent.av.ui;

import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectOperateManager;
import com.tencent.av.business.manager.filter.EffectFilterTools.DataReport;
import com.tencent.av.business.manager.magicface.MagicDataReport;
import com.tencent.av.business.manager.pendant.EffectPendantTools.DataReport;
import com.tencent.av.business.manager.zimu.EffectZimuManager.DataReport;
import com.tencent.av.ui.effect.toolbar.oldversion.BeautyToolbar.DataReport;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.TraeHelper;

class DoubleVideoCtrlUI$27
  implements QavInOutAnimation.QavOutAnimationListener
{
  DoubleVideoCtrlUI$27(DoubleVideoCtrlUI paramDoubleVideoCtrlUI, long paramLong, String paramString) {}
  
  public void a()
  {
    Object localObject = this.c;
    ((DoubleVideoCtrlUI)localObject).aU = true;
    ((DoubleVideoCtrlUI)localObject).aj();
    localObject = (EffectOperateManager)this.c.al.c(8);
    if (localObject != null) {
      ((EffectOperateManager)localObject).b(false);
    }
    this.c.an();
  }
  
  public void b()
  {
    SessionInfo localSessionInfo = this.c.am.k();
    TraeHelper.a().b(this.a);
    localSessionInfo.C = false;
    if (localSessionInfo.ay == -1) {
      localSessionInfo.ay = 0;
    }
    localSessionInfo.R = true;
    DataReport.d(this.c.am);
    if (this.c.c) {
      DataReport.r(this.c.am);
    }
    if ((localSessionInfo.j()) && (localSessionInfo.g == 2) && (!localSessionInfo.H)) {
      DataReport.e();
    }
    AVLog.printColorLog(this.c.X, "DataReport onClose: ");
    EffectPendantTools.DataReport.a(this.c.X, this.c.al);
    EffectZimuManager.DataReport.a(this.c.al);
    EffectFilterTools.DataReport.a(this.c.al);
    BeautyToolbar.DataReport.b(this.c.al.getCurrentAccountUin());
    VoiceChangeDataReport.a(localSessionInfo);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(localSessionInfo.D());
    ((StringBuilder)localObject).append("");
    localObject = ((StringBuilder)localObject).toString();
    this.c.am.a(this.b, 237);
    this.c.am.b(237);
    MagicDataReport.a(this.c.al, (String)localObject);
    MagicDataReport.a(2, (String)localObject);
    MagicDataReport.a(2);
    this.c.am.b(this.b, localSessionInfo.ay);
    this.c.b = true;
    localSessionInfo.a("onClick_HangeUP", false);
    localSessionInfo.c("onClick_HangeUP", 0);
    this.c.aU = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.27
 * JD-Core Version:    0.7.0.1
 */