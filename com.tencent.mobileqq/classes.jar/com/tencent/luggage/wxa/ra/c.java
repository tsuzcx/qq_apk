package com.tencent.luggage.wxa.ra;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class c
{
  private String a;
  private volatile c.c b;
  private volatile HandlerThread c;
  
  protected c(String paramString, Looper paramLooper)
  {
    a(paramString, paramLooper);
  }
  
  private void a(String paramString, Looper paramLooper)
  {
    this.a = paramString;
    this.b = new c.c(paramLooper, this, null);
  }
  
  public final Message a(int paramInt, Object paramObject)
  {
    return Message.obtain(this.b, paramInt, paramObject);
  }
  
  protected String a(int paramInt)
  {
    return null;
  }
  
  protected void a(Message paramMessage)
  {
    if (c.c.d(this.b))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" - unhandledMessage: msg.what=");
      localStringBuilder.append(paramMessage.what);
      d(localStringBuilder.toString());
    }
  }
  
  protected final void a(a parama)
  {
    c.c.a(this.b, parama);
  }
  
  protected final void a(b paramb)
  {
    c.c.a(this.b, paramb, null);
  }
  
  protected void a(String paramString)
  {
    Log.d(this.a, paramString);
  }
  
  public final Message b(int paramInt)
  {
    return Message.obtain(this.b, paramInt);
  }
  
  protected final void b(b paramb)
  {
    c.c.a(this.b, paramb);
  }
  
  protected void b(String paramString)
  {
    Log.v(this.a, paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    c.c localc = this.b;
    if (localc == null) {
      return;
    }
    c.c.a(localc, paramBoolean);
  }
  
  protected boolean b(Message paramMessage)
  {
    return true;
  }
  
  public void c()
  {
    c.c localc = this.b;
    if (localc == null) {
      return;
    }
    c.c.g(localc);
  }
  
  public final void c(int paramInt)
  {
    c.c localc = this.b;
    if (localc == null) {
      return;
    }
    localc.sendMessage(b(paramInt));
  }
  
  protected void c(Message paramMessage) {}
  
  protected void c(String paramString)
  {
    Log.i(this.a, paramString);
  }
  
  protected String d(Message paramMessage)
  {
    return "";
  }
  
  protected void d(String paramString)
  {
    Log.e(this.a, paramString);
  }
  
  public final void e(Message paramMessage)
  {
    c.c localc = this.b;
    if (localc == null) {
      return;
    }
    localc.sendMessage(paramMessage);
  }
  
  protected void i() {}
  
  protected final Message n()
  {
    c.c localc = this.b;
    if (localc == null) {
      return null;
    }
    return c.c.b(localc);
  }
  
  protected final a o()
  {
    c.c localc = this.b;
    if (localc == null) {
      return null;
    }
    return c.c.c(localc);
  }
  
  protected void p() {}
  
  public final String q()
  {
    return this.a;
  }
  
  public final Handler r()
  {
    return this.b;
  }
  
  protected final void s()
  {
    c.c localc = this.b;
    if (localc == null) {
      return;
    }
    c.c.e(localc);
  }
  
  protected final void t()
  {
    c.c localc = this.b;
    if (localc == null) {
      return;
    }
    c.c.f(localc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ra.c
 * JD-Core Version:    0.7.0.1
 */