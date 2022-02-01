package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.MultiVideoMembersClickListener;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class MultiVideoCtrlLayerUIBase$6
  implements MultiVideoMembersClickListener
{
  MultiVideoCtrlLayerUIBase$6(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  private void b()
  {
    AVActivity localAVActivity = (AVActivity)this.a.ak.get();
    if (localAVActivity != null)
    {
      boolean bool;
      if ((!this.a.am.k().bg) && (!this.a.am.k().bh)) {
        bool = false;
      } else {
        bool = true;
      }
      VideoMsgTools.a(localAVActivity, String.valueOf(this.a.am.k().aN), bool, true);
      ReportController.b(null, "CliOper", "", "", "0X8009E27", "0X8009E27", 0, 0, "", "", "", "");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e(this.a.X, 2, "startMembersListViewPage-->can not get activity");
    }
  }
  
  public void a()
  {
    long l = AudioHelper.c();
    this.a.I(l);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.a.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MultiVideoMembersClickListener , Uin = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" , videoScr = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" , isNeedRequest ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" , positon = ");
      localStringBuilder.append(paramInt2);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if ((paramInt2 == 7) && (paramBoolean)) {
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase.6
 * JD-Core Version:    0.7.0.1
 */