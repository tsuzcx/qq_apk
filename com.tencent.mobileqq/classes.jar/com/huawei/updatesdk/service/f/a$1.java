package com.huawei.updatesdk.service.f;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.widget.Button;

class a$1
  implements DialogInterface.OnShowListener
{
  a$1(a parama) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    ((AlertDialog)paramDialogInterface).getButton(-1).setOnClickListener(new a.1.1(this));
    Button localButton = ((AlertDialog)paramDialogInterface).getButton(-2);
    if (localButton != null) {
      localButton.setOnClickListener(new a.1.2(this));
    }
    if (a.b(this.a) != null) {
      a.b(this.a).onShow(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.service.f.a.1
 * JD-Core Version:    0.7.0.1
 */