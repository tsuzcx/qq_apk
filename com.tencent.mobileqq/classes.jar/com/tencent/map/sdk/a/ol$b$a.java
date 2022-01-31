package com.tencent.map.sdk.a;

import android.os.Handler;
import android.os.Message;
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
  
  public final void a()
  {
    if (this.g == null)
    {
      this.j = false;
      os.a("DispatchUtil").a();
      return;
    }
    this.j = true;
    Object localObject = Message.obtain();
    ((Message)localObject).obj = this;
    this.g.sendMessageDelayed((Message)localObject, this.k);
    localObject = os.a("DispatchUtil");
    new StringBuilder("delay:").append(this.k).toString();
    ((os.a)localObject).a();
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
      this.i = Message.obtain(this.g, this.m);
      this.i.copyFrom(paramMessage);
      this.g.sendMessageDelayed(this.i, paramLong);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.ol.b.a
 * JD-Core Version:    0.7.0.1
 */