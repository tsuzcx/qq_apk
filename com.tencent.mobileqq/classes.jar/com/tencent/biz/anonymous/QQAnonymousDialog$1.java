package com.tencent.biz.anonymous;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.widget.TextView;

class QQAnonymousDialog$1
  implements Handler.Callback
{
  QQAnonymousDialog$1(QQAnonymousDialog paramQQAnonymousDialog) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 291)
    {
      int i = this.a.d;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3) {
              i = 0;
            } else {
              i = 2131893816;
            }
          }
          else {
            i = 2131893815;
          }
        }
        else {
          i = 2131893814;
        }
      }
      else {
        i = 2131893813;
      }
      this.a.c.setText(this.a.e.getResources().getString(i));
      paramMessage = this.a;
      paramMessage.d += 1;
      if (this.a.d == 4) {
        this.a.d = 0;
      }
      this.a.g.sendEmptyMessageDelayed(291, 1000L);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.anonymous.QQAnonymousDialog.1
 * JD-Core Version:    0.7.0.1
 */