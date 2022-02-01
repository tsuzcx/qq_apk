package com.tencent.map.sdk.a;

import android.os.Handler;
import android.os.Message;
import java.lang.reflect.Field;
import java.util.Set;
import java.util.concurrent.Future;

public final class ol$b$a<T>
{
  boolean a;
  ol.c<T> b;
  ol.e<T> c;
  ol.a<T> d;
  Future<T> e;
  T f;
  Handler g;
  Handler h;
  Message i;
  boolean j;
  int k = 0;
  private ol.a<T> m;
  
  ol$b$a(Handler paramHandler, ol.c<T> paramc, ol.e<T> parame)
  {
    this.g = paramc;
    this.b = parame;
    Object localObject;
    this.c = localObject;
  }
  
  private static void a(Handler paramHandler, Message paramMessage, long paramLong)
  {
    if ((paramHandler == null) || (paramMessage == null)) {
      return;
    }
    try
    {
      Field localField = paramMessage.getClass().getDeclaredField("flags");
      localField.setAccessible(true);
      localField.set(paramMessage, Integer.valueOf(0));
      paramHandler.sendMessageDelayed(paramMessage, paramLong);
      return;
    }
    catch (Throwable paramHandler)
    {
      or.b(paramHandler.getMessage(), paramHandler);
    }
  }
  
  public final void a()
  {
    if (this.g == null)
    {
      this.j = false;
      os.a("DispatchUtil").a();
      return;
    }
    this.j = true;
    Message localMessage = Message.obtain();
    localMessage.obj = this;
    os.a locala = os.a("DispatchUtil");
    new StringBuilder("delay:").append(this.k).toString();
    locala.a();
    a(this.g, localMessage, this.k);
  }
  
  final void a(Message paramMessage, Handler paramHandler, long paramLong)
  {
    os.a locala = os.a("DispatchUtil");
    new StringBuilder("count:").append(ol.b.a(this.l).size()).toString();
    "msg:".concat(String.valueOf(paramMessage));
    locala.a();
    if ((this.m != null) && (paramHandler != null) && (paramMessage != null))
    {
      this.g = paramHandler;
      this.g.removeCallbacks(this.m);
      this.i = Message.obtain(this.g, this.m);
      this.i.copyFrom(paramMessage);
      a(this.g, this.i, paramLong);
    }
  }
  
  final void a(ol.a<T> parama)
  {
    this.m = parama;
    ol.e.a(this.c, this.m);
  }
  
  final void a(T paramT)
  {
    os.a locala = os.a("DispatchUtil");
    new StringBuilder("count:").append(ol.b.a(this.l).size()).toString();
    "result:".concat(String.valueOf(paramT));
    new StringBuilder("userCallback:").append(this.d).toString();
    locala.a();
    this.f = paramT;
    if (this.g != null) {
      this.g.removeCallbacks(this.m);
    }
    if (this.d != null) {
      this.d.a(this.f);
    }
    ol.b.a(this.l).remove(this);
  }
  
  public final void b(ol.a<T> parama)
  {
    this.d = parama;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ol.b.a
 * JD-Core Version:    0.7.0.1
 */