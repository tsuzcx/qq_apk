package com.tencent.luggage.widget;

import android.os.Handler.Callback;
import android.os.Message;

class c$1
  implements Handler.Callback
{
  c$1(c paramc) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == 1) && (c.a(this.a) != null))
    {
      c.a(this.a, 0);
      paramMessage = this.a;
      c.a(paramMessage, c.a(paramMessage));
      this.a.performLongClick();
      c.b(this.a, null);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.widget.c.1
 * JD-Core Version:    0.7.0.1
 */