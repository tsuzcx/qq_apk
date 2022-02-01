package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;

class QQBroadcastActivity$Adapter$1$1
  implements DialogInterface.OnClickListener
{
  QQBroadcastActivity$Adapter$1$1(QQBroadcastActivity.Adapter.1 param1) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      if (this.a.b.b.d.getCount() > 0)
      {
        this.a.b.b.app.getMessageFacade().c(this.a.b.b.b(), 0);
        this.a.b.b.d.changeCursor(this.a.b.getCursor());
      }
    }
    else
    {
      this.a.b.b.app.getMessageFacade().h(this.a.b.b.b(), 0, this.a.a);
      this.a.b.b.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQBroadcastActivity.Adapter.1.1
 * JD-Core Version:    0.7.0.1
 */