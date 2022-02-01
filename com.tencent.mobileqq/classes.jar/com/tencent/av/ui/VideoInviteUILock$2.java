package com.tencent.av.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.utils.DataReport;

class VideoInviteUILock$2
  implements DialogInterface.OnClickListener
{
  VideoInviteUILock$2(VideoInviteUILock paramVideoInviteUILock) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DataReport.e(false, false);
    if (paramDialogInterface != null)
    {
      paramDialogInterface.dismiss();
      if ((this.a.a.a != null) && (this.a.a.a.a != null)) {
        this.a.a.a.a.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteUILock.2
 * JD-Core Version:    0.7.0.1
 */