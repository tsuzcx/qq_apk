package com.tencent.av.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class MultiVideoCtrlLayerUI4Discussion$9
  implements DialogInterface.OnClickListener
{
  MultiVideoCtrlLayerUI4Discussion$9(MultiVideoCtrlLayerUI4Discussion paramMultiVideoCtrlLayerUI4Discussion) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showConfirmBoxToHangup, no, mRelationId[");
    localStringBuilder.append(this.a.b);
    localStringBuilder.append("]");
    QLog.w(paramDialogInterface, 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion.9
 * JD-Core Version:    0.7.0.1
 */