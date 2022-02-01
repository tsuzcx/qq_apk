package com.tencent.mm.ui.widget.dialog;

import android.os.Handler;
import android.os.Message;
import com.tencent.mm.ui.base.j;

final class MMTipsBar$1
  extends Handler
{
  MMTipsBar$1(j paramj) {}
  
  public void handleMessage(Message paramMessage)
  {
    this.a.dismiss();
    super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.dialog.MMTipsBar.1
 * JD-Core Version:    0.7.0.1
 */