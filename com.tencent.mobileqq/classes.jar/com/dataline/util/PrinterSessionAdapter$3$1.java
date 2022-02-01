package com.dataline.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.PrinterHandler;
import com.tencent.mobileqq.data.PrinterItemMsgRecord;

class PrinterSessionAdapter$3$1
  implements DialogInterface.OnClickListener
{
  PrinterSessionAdapter$3$1(PrinterSessionAdapter.3 param3) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.a.status < 10) {
      this.a.c.d.a(0, this.a.a.uSessionID, true);
    }
    this.a.c.d.e.a(this.a.a);
    this.a.c.d();
    this.a.c.notifyDataSetChanged();
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.util.PrinterSessionAdapter.3.1
 * JD-Core Version:    0.7.0.1
 */