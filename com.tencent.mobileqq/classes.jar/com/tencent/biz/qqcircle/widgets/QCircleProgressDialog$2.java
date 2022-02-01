package com.tencent.biz.qqcircle.widgets;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class QCircleProgressDialog$2
  implements DialogInterface.OnKeyListener
{
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt != 84) && (paramInt != 4)) {
      return false;
    }
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleProgressDialog.2
 * JD-Core Version:    0.7.0.1
 */