package com.tencent.av.ui;

import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;

class MultiVideoCtrlLayerUI4NewGroupChat$2
  implements QavInOutAnimation.QavOutAnimationListener
{
  MultiVideoCtrlLayerUI4NewGroupChat$2(MultiVideoCtrlLayerUI4NewGroupChat paramMultiVideoCtrlLayerUI4NewGroupChat, long paramLong) {}
  
  public void a()
  {
    MultiVideoCtrlLayerUI4NewGroupChat localMultiVideoCtrlLayerUI4NewGroupChat = this.b;
    localMultiVideoCtrlLayerUI4NewGroupChat.aU = true;
    localMultiVideoCtrlLayerUI4NewGroupChat.aj();
  }
  
  public void b()
  {
    ReportController.b(null, "CliOper", "", "", "0X800592D", "0X800592D", 0, 0, "", "", "", "");
    if (((this.b.l == 90) || (this.b.l == 270)) && (this.b.am.k().B() != -1) && (((VideoViewInfo)this.b.am.k().bi.get(0)).b == 1)) {
      ReportController.b(null, "CliOper", "", "", "0X800594D", "0X800594D", 0, 0, "", "", "", "");
    } else if (((this.b.l == 90) || (this.b.l == 270)) && (this.b.am.k().B() != -1) && (((VideoViewInfo)this.b.am.k().bi.get(0)).b == 2)) {
      ReportController.b(null, "CliOper", "", "", "0X800594E", "0X800594E", 0, 0, "", "", "", "");
    }
    SessionInfo localSessionInfo = this.b.am.k();
    if (localSessionInfo != null)
    {
      String str = this.b.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" TYPE_NOTIFY_CAMERA_CLOSE: ");
      localStringBuilder.append(localSessionInfo.H);
      localStringBuilder.append("|");
      localStringBuilder.append(localSessionInfo.g);
      AVLog.printAllUserLog(str, localStringBuilder.toString());
      if (localSessionInfo.H) {
        this.b.ao.update(null, new Object[] { Integer.valueOf(106), Long.valueOf(this.a) });
      }
    }
    MultiVideoCtrlLayerUI4NewGroupChat.a(this.b, this.a);
    MultiVideoCtrlLayerUI4NewGroupChat.a(this.b, true);
    this.b.aU = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat.2
 * JD-Core Version:    0.7.0.1
 */