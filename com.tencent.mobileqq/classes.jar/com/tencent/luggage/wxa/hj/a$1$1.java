package com.tencent.luggage.wxa.hj;

import android.os.Parcelable;

class a$1$1
  implements Runnable
{
  a$1$1(a.1 param1, c paramc, Parcelable paramParcelable, com.tencent.luggage.wxa.hl.b paramb, String paramString) {}
  
  public void run()
  {
    try
    {
      this.a.a(this.b, new a.a(this.c));
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      com.tencent.luggage.wxa.hs.b.b("IPC.BaseIPCService", "invoke task, clazz=%s, npe=%s", new Object[] { this.d, localNullPointerException });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hj.a.1.1
 * JD-Core Version:    0.7.0.1
 */