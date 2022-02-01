package com.tencent.map.sdk.a;

import android.os.Handler;
import android.os.Message;

final class mt$a$1
  extends Handler
{
  mt$a$1(mt.a parama) {}
  
  public final void handleMessage(Message paramMessage)
  {
    paramMessage = this.a;
    paramMessage.h += this.a.g;
    mt.a(this.a.l, this.a.a, this.a.b, this.a.c, this.a.h);
    paramMessage = this.a;
    int i = paramMessage.i;
    paramMessage.i = (i + 1);
    if (i < this.a.e - 1)
    {
      this.a.k.sendEmptyMessageDelayed(0, this.a.f);
      return;
    }
    if (this.a.j)
    {
      this.a.l.c();
      paramMessage = this.a;
      paramMessage.k = null;
      paramMessage.l.b();
      return;
    }
    mt.a(this.a.l, this.a.a, this.a.b, this.a.c, this.a.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.mt.a.1
 * JD-Core Version:    0.7.0.1
 */