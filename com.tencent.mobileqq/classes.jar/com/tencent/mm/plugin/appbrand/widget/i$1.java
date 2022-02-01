package com.tencent.mm.plugin.appbrand.widget;

import android.os.Looper;
import android.os.Message;
import com.tencent.luggage.wxa.qz.s;

class i$1
  extends s
{
  i$1(i parami, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1003: 
      i.d(this.a);
      return;
    case 1002: 
      i.c(this.a);
      return;
    case 1001: 
      i.b(this.a);
      return;
    }
    i.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.i.1
 * JD-Core Version:    0.7.0.1
 */