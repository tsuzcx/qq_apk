package com.tencent.av.ui;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.effect.menuview.QavEffectBaseMenuView;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

class DoubleVideoCtrlUI$28
  implements QQPermissionCallback
{
  DoubleVideoCtrlUI$28(DoubleVideoCtrlUI paramDoubleVideoCtrlUI, long paramLong, boolean paramBoolean, String paramString) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = this.d.X;
    paramArrayOfInt = new StringBuilder();
    paramArrayOfInt.append("avatar2DCheckCameraPermission, deny, seq[");
    paramArrayOfInt.append(this.a);
    paramArrayOfInt.append("]");
    QLog.w(paramArrayOfString, 1, paramArrayOfInt.toString());
    paramArrayOfString = this.d.U();
    if (paramArrayOfString == null) {
      return;
    }
    paramArrayOfInt = this.d.am();
    if (paramArrayOfInt != null) {
      paramArrayOfInt.a(false, this.b);
    }
    this.d.a(this.a, paramArrayOfString.getString(2131893123), paramArrayOfString.getString(2131893406));
    ReportController.b(null, "dc00898", "", "", "0X800BCE5", "0X800BCE5", 0, 0, "", "", "", "");
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = this.d.X;
    paramArrayOfInt = new StringBuilder();
    paramArrayOfInt.append("avatar2DCheckCameraPermission, grant, seq[");
    paramArrayOfInt.append(this.a);
    paramArrayOfInt.append("]");
    QLog.w(paramArrayOfString, 1, paramArrayOfInt.toString());
    if (this.d.U() == null) {
      return;
    }
    if (this.b) {
      this.d.al.a(new Object[] { Integer.valueOf(9050), Long.valueOf(AudioHelper.c()), Boolean.valueOf(true), this.c });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.28
 * JD-Core Version:    0.7.0.1
 */