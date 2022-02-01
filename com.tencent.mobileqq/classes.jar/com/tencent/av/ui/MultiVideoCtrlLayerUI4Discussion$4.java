package com.tencent.av.ui;

import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;

class MultiVideoCtrlLayerUI4Discussion$4
  implements QavInOutAnimation.QavOutAnimationListener
{
  MultiVideoCtrlLayerUI4Discussion$4(MultiVideoCtrlLayerUI4Discussion paramMultiVideoCtrlLayerUI4Discussion, long paramLong) {}
  
  public void a()
  {
    MultiVideoCtrlLayerUI4Discussion localMultiVideoCtrlLayerUI4Discussion = this.b;
    localMultiVideoCtrlLayerUI4Discussion.aU = true;
    localMultiVideoCtrlLayerUI4Discussion.aj();
  }
  
  public void b()
  {
    SessionInfo localSessionInfo = this.b.am.k();
    if (localSessionInfo != null)
    {
      String str = this.b.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" TYPE_NOTIFY_CAMERA_CLOSE 2: ");
      localStringBuilder.append(localSessionInfo.H);
      localStringBuilder.append("|");
      localStringBuilder.append(localSessionInfo.g);
      AVLog.printAllUserLog(str, localStringBuilder.toString());
      if (localSessionInfo.H) {
        this.b.ao.update(null, new Object[] { Integer.valueOf(106), Long.valueOf(this.a) });
      }
    }
    MultiVideoCtrlLayerUI4Discussion.a(this.b, this.a);
    this.b.e(true);
    ReportController.b(null, "CliOper", "", "", "0X8004CF2", "0X8004CF2", 0, 0, "", "", "", "");
    if (((this.b.l == 90) || (this.b.l == 270)) && (this.b.am.k().B() != -1) && (((VideoViewInfo)this.b.am.k().bi.get(0)).b == 1)) {
      ReportController.b(null, "CliOper", "", "", "0X8004CFB", "0X8004CFB", 0, 0, "", "", "", "");
    } else if (((this.b.l == 90) || (this.b.l == 270)) && (this.b.am.k().B() != -1) && (((VideoViewInfo)this.b.am.k().bi.get(0)).b == 2)) {
      ReportController.b(null, "CliOper", "", "", "0X8004CFC", "0X8004CFC", 0, 0, "", "", "", "");
    }
    this.b.aU = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion.4
 * JD-Core Version:    0.7.0.1
 */