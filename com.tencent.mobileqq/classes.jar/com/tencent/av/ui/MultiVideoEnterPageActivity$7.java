package com.tencent.av.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.av.VideoController;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class MultiVideoEnterPageActivity$7
  implements DialogInterface.OnClickListener
{
  MultiVideoEnterPageActivity$7(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity, View paramView) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.b.e()) {
      return;
    }
    this.a.setEnabled(false);
    Object localObject = this.b;
    ((MultiVideoEnterPageActivity)localObject).D = ((MultiVideoEnterPageActivity)localObject).u.a(this.b.o, this.b.r, this.b.k);
    localObject = this.b.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("kickOutUsers begin, mGAudioRoomId[");
    localStringBuilder.append(this.b.D);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    this.b.u.a(1, this.b.o, this.b.r, this.b.k);
    ReportController.b(null, "CliOper", "", "", "0X8009E2A", "0X8009E2A", 0, 0, "", "", "", "");
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoEnterPageActivity.7
 * JD-Core Version:    0.7.0.1
 */