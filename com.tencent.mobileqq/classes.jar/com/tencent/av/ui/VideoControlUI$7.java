package com.tencent.av.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class VideoControlUI$7
  implements DialogInterface.OnClickListener
{
  VideoControlUI$7(VideoControlUI paramVideoControlUI, long paramLong) {}
  
  public void onClick(DialogInterface arg1, int paramInt)
  {
    if (this.b.V()) {
      return;
    }
    ??? = this.b.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showPermissionDialog.gotoSetting, seq[");
    localStringBuilder.append(this.a);
    localStringBuilder.append("]");
    QLog.w(???, 1, localStringBuilder.toString());
    if ((this.b.bm) && (this.b.bl != null)) {
      ReportController.b(null, "CliOper", "", "", this.b.bl, this.b.bl, 0, 0, "", "", this.b.bo, "");
    }
    UITools.a(this.b.U());
    if ((this.b.bn == 2) || (this.b.bn == 1))
    {
      this.b.ao.update(null, new Object[] { Integer.valueOf(106), Long.valueOf(this.a) });
      long l = Long.valueOf(this.b.al.getCurrentAccountUin()).longValue();
      paramInt = this.b.am.k().b(l, 1);
      if (paramInt == -1) {
        return;
      }
      this.b.am.k().bi.remove(paramInt);
      synchronized (this.b.am.k().bk)
      {
        paramInt = this.b.am.k().c(l, 1);
        if (paramInt != -1)
        {
          this.b.am.k().bk.remove(paramInt);
          this.b.am.k().C();
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI.7
 * JD-Core Version:    0.7.0.1
 */