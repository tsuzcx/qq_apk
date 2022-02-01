package com.tencent.luggage.wxa.pt;

import android.os.Looper;
import android.os.Message;
import com.tencent.luggage.wxa.qz.s;

class a$1
  extends s
{
  a$1(a parama, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void a(Message paramMessage)
  {
    if (1000 == paramMessage.what)
    {
      String str = (String)paramMessage.obj;
      int i = paramMessage.arg1;
      if (a.a(this.a) != null) {
        a.a(this.a).a(str, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pt.a.1
 * JD-Core Version:    0.7.0.1
 */