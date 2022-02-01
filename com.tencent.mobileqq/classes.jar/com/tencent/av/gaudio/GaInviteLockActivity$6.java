package com.tencent.av.gaudio;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.QavPanelSlideTouchListener;
import com.tencent.av.utils.DataReport;

class GaInviteLockActivity$6
  implements DialogInterface.OnClickListener
{
  GaInviteLockActivity$6(GaInviteLockActivity paramGaInviteLockActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DataReport.e(false, false);
    if (paramDialogInterface != null)
    {
      paramDialogInterface.dismiss();
      if ((this.a.a != null) && (this.a.a.a != null)) {
        this.a.a.a.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity.6
 * JD-Core Version:    0.7.0.1
 */