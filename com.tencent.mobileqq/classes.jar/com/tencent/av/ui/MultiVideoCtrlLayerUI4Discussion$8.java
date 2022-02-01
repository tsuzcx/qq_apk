package com.tencent.av.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class MultiVideoCtrlLayerUI4Discussion$8
  implements DialogInterface.OnClickListener
{
  MultiVideoCtrlLayerUI4Discussion$8(MultiVideoCtrlLayerUI4Discussion paramMultiVideoCtrlLayerUI4Discussion, VideoAppInterface paramVideoAppInterface, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.c.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showConfirmBoxToHangup, yes, mRelationId[");
    localStringBuilder.append(this.c.j);
    localStringBuilder.append("]");
    QLog.w(paramDialogInterface, 1, localStringBuilder.toString());
    this.c.h(0L);
    paramDialogInterface = new Bundle();
    paramDialogInterface.putString("uin", String.valueOf(this.c.j));
    this.a.a(4, 0, 0, paramDialogInterface, null);
    if (!QAVHrMeeting.a(this.b)) {
      MultiVideoCtrlLayerUI4Discussion.a(this.c.X, this.a, String.valueOf(this.c.j), 3000, this.a.getApp().getString(2131893376));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion.8
 * JD-Core Version:    0.7.0.1
 */