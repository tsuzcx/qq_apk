package com.tencent.av.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;

class MultiVideoCtrlLayerUIBase$8
  implements DialogInterface.OnClickListener
{
  MultiVideoCtrlLayerUIBase$8(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.b.am != null) && (this.b.F()))
    {
      MultiVideoCtrlLayerUIBase.a(this.b, true);
      this.b.K();
      this.b.f(this.a, 16777215);
      this.b.am.k().bA = true;
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase.8
 * JD-Core Version:    0.7.0.1
 */