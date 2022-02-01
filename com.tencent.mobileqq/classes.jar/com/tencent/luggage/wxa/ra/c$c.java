package com.tencent.luggage.wxa.ra;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

class c$c
  extends Handler
{
  private static final Object c = new Object();
  private boolean a = false;
  private boolean b = false;
  private Message d;
  private c.b e = new c.b(null);
  private boolean f;
  private c.c.c[] g;
  private int h = -1;
  private c.c.c[] i;
  private int j;
  private c.c.a k = new c.c.a(this, null);
  private c.c.b l = new c.c.b(this, null);
  private c m;
  private HashMap<b, c.c.c> n = new HashMap();
  private b o;
  private b p;
  private ArrayList<Message> q = new ArrayList();
  
  private c$c(Looper paramLooper, c paramc)
  {
    super(paramLooper);
    this.m = paramc;
    a(this.k, null);
    a(this.l, null);
  }
  
  private final b a(Message paramMessage)
  {
    Object localObject2 = this.g[this.h];
    StringBuilder localStringBuilder;
    if (this.b)
    {
      localObject1 = this.m;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("processMsg: ");
      localStringBuilder.append(((c.c.c)localObject2).a.c());
      ((c)localObject1).a(localStringBuilder.toString());
    }
    Object localObject1 = localObject2;
    if (b(paramMessage)) {
      a(this.l);
    } else {
      for (;;)
      {
        localObject2 = localObject1;
        if (((c.c.c)localObject1).a.a(paramMessage)) {
          break;
        }
        localObject2 = ((c.c.c)localObject1).b;
        if (localObject2 == null)
        {
          this.m.a(paramMessage);
          break;
        }
        localObject1 = localObject2;
        if (this.b)
        {
          localObject1 = this.m;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("processMsg: ");
          localStringBuilder.append(((c.c.c)localObject2).a.c());
          ((c)localObject1).a(localStringBuilder.toString());
          localObject1 = localObject2;
        }
      }
    }
    if (localObject2 != null) {
      return ((c.c.c)localObject2).a;
    }
    return null;
  }
  
  private final c.c.c a(b paramb)
  {
    this.j = 0;
    paramb = (c.c.c)this.n.get(paramb);
    Object localObject;
    do
    {
      localObject = this.i;
      int i1 = this.j;
      this.j = (i1 + 1);
      localObject[i1] = paramb;
      localObject = paramb.b;
      if (localObject == null) {
        break;
      }
      paramb = (b)localObject;
    } while (!((c.c.c)localObject).c);
    if (this.b)
    {
      paramb = this.m;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setupTempStateStackWithStatesToEnter: X mTempStateStackCount=");
      localStringBuilder.append(this.j);
      localStringBuilder.append(",curStateInfo: ");
      localStringBuilder.append(localObject);
      paramb.a(localStringBuilder.toString());
    }
    return localObject;
  }
  
  private final c.c.c a(b paramb1, b paramb2)
  {
    if (this.b)
    {
      localObject2 = this.m;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addStateInternal: E state=");
      localStringBuilder.append(paramb1.c());
      localStringBuilder.append(",parent=");
      if (paramb2 == null) {
        localObject1 = "";
      } else {
        localObject1 = paramb2.c();
      }
      localStringBuilder.append((String)localObject1);
      ((c)localObject2).a(localStringBuilder.toString());
    }
    if (paramb2 != null)
    {
      localObject1 = (c.c.c)this.n.get(paramb2);
      if (localObject1 == null) {
        paramb2 = a(paramb2, null);
      } else {
        paramb2 = (b)localObject1;
      }
    }
    else
    {
      paramb2 = null;
    }
    Object localObject2 = (c.c.c)this.n.get(paramb1);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new c.c.c(this, null);
      this.n.put(paramb1, localObject1);
    }
    if ((((c.c.c)localObject1).b != null) && (((c.c.c)localObject1).b != paramb2)) {
      throw new RuntimeException("state already added");
    }
    ((c.c.c)localObject1).a = paramb1;
    ((c.c.c)localObject1).b = paramb2;
    ((c.c.c)localObject1).c = false;
    if (this.b)
    {
      paramb1 = this.m;
      paramb2 = new StringBuilder();
      paramb2.append("addStateInternal: X stateInfo: ");
      paramb2.append(localObject1);
      paramb1.a(paramb2.toString());
    }
    return localObject1;
  }
  
  private final void a()
  {
    if (c.a(this.m) != null)
    {
      getLooper().quit();
      c.a(this.m, null);
    }
    c.a(this.m, null);
    this.m = null;
    this.d = null;
    this.e.b();
    this.g = null;
    this.i = null;
    this.n.clear();
    this.o = null;
    this.p = null;
    this.q.clear();
    this.a = true;
  }
  
  private final void a(int paramInt)
  {
    while (paramInt <= this.h)
    {
      if (this.b)
      {
        c localc = this.m;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("invokeEnterMethods: ");
        localStringBuilder.append(this.g[paramInt].a.c());
        localc.a(localStringBuilder.toString());
      }
      this.g[paramInt].a.a();
      this.g[paramInt].c = true;
      paramInt += 1;
    }
  }
  
  private final void a(a parama)
  {
    this.p = ((b)parama);
    if (this.b)
    {
      parama = this.m;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("transitionTo: destState=");
      localStringBuilder.append(this.p.c());
      parama.a(localStringBuilder.toString());
    }
  }
  
  private void a(b paramb, Message paramMessage)
  {
    b localb = this.g[this.h].a;
    int i1;
    if ((this.m.b(this.d)) && (paramMessage.obj != c)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    c localc;
    Message localMessage;
    if (this.e.a())
    {
      if (this.p != null)
      {
        paramMessage = this.e;
        localc = this.m;
        localMessage = this.d;
        paramMessage.a(localc, localMessage, localc.d(localMessage), paramb, localb, this.p);
      }
    }
    else if (i1 != 0)
    {
      paramMessage = this.e;
      localc = this.m;
      localMessage = this.d;
      paramMessage.a(localc, localMessage, localc.d(localMessage), paramb, localb, this.p);
    }
    paramb = this.p;
    paramMessage = paramb;
    if (paramb != null)
    {
      for (;;)
      {
        if (this.b) {
          this.m.a("handleMessage: new destination call exit/enter");
        }
        a(a(paramb));
        a(d());
        c();
        paramMessage = this.p;
        if (paramb == paramMessage) {
          break;
        }
        paramb = paramMessage;
      }
      this.p = null;
      paramMessage = paramb;
    }
    if (paramMessage != null)
    {
      if (paramMessage == this.l)
      {
        this.m.i();
        a();
        return;
      }
      if (paramMessage == this.k) {
        this.m.p();
      }
    }
  }
  
  private final void a(c.c.c paramc)
  {
    for (;;)
    {
      int i1 = this.h;
      if (i1 < 0) {
        break;
      }
      Object localObject = this.g;
      if (localObject[i1] == paramc) {
        break;
      }
      localObject = localObject[i1].a;
      if (this.b)
      {
        c localc = this.m;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("invokeExitMethods: ");
        localStringBuilder.append(((b)localObject).c());
        localc.a(localStringBuilder.toString());
      }
      ((b)localObject).b();
      localObject = this.g;
      i1 = this.h;
      localObject[i1].c = false;
      this.h = (i1 - 1);
    }
  }
  
  private final void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  private final void b()
  {
    if (this.b) {
      this.m.a("completeConstruction: E");
    }
    Object localObject2 = this.n.values().iterator();
    int i2 = 0;
    Object localObject1;
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = (c.c.c)((Iterator)localObject2).next();
      int i1 = 0;
      while (localObject1 != null)
      {
        localObject1 = ((c.c.c)localObject1).b;
        i1 += 1;
      }
      if (i2 < i1) {
        i2 = i1;
      }
    }
    if (this.b)
    {
      localObject1 = this.m;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("completeConstruction: maxDepth=");
      ((StringBuilder)localObject2).append(i2);
      ((c)localObject1).a(((StringBuilder)localObject2).toString());
    }
    this.g = new c.c.c[i2];
    this.i = new c.c.c[i2];
    e();
    sendMessageAtFrontOfQueue(obtainMessage(-2, c));
    if (this.b) {
      this.m.a("completeConstruction: X");
    }
  }
  
  private final void b(b paramb)
  {
    if (this.b)
    {
      c localc = this.m;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setInitialState: initialState=");
      localStringBuilder.append(paramb.c());
      localc.a(localStringBuilder.toString());
    }
    this.o = paramb;
  }
  
  private final boolean b(Message paramMessage)
  {
    return (paramMessage.what == -1) && (paramMessage.obj == c);
  }
  
  private final void c()
  {
    int i1 = this.q.size() - 1;
    while (i1 >= 0)
    {
      Message localMessage = (Message)this.q.get(i1);
      if (this.b)
      {
        c localc = this.m;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("moveDeferredMessageAtFrontOfQueue; what=");
        localStringBuilder.append(localMessage.what);
        localc.a(localStringBuilder.toString());
      }
      sendMessageAtFrontOfQueue(localMessage);
      i1 -= 1;
    }
    this.q.clear();
  }
  
  private final int d()
  {
    int i3 = this.h + 1;
    int i1 = this.j - 1;
    int i2 = i3;
    c localc;
    StringBuilder localStringBuilder;
    while (i1 >= 0)
    {
      if (this.b)
      {
        localc = this.m;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("moveTempStackToStateStack: i=");
        localStringBuilder.append(i1);
        localStringBuilder.append(",j=");
        localStringBuilder.append(i2);
        localc.a(localStringBuilder.toString());
      }
      this.g[i2] = this.i[i1];
      i2 += 1;
      i1 -= 1;
    }
    this.h = (i2 - 1);
    if (this.b)
    {
      localc = this.m;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("moveTempStackToStateStack: X mStateStackTop=");
      localStringBuilder.append(this.h);
      localStringBuilder.append(",startingIndex=");
      localStringBuilder.append(i3);
      localStringBuilder.append(",Top=");
      localStringBuilder.append(this.g[this.h].a.c());
      localc.a(localStringBuilder.toString());
    }
    return i3;
  }
  
  private final void e()
  {
    if (this.b)
    {
      localObject = this.m;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setupInitialStateStack: E mInitialState=");
      localStringBuilder.append(this.o.c());
      ((c)localObject).a(localStringBuilder.toString());
    }
    Object localObject = (c.c.c)this.n.get(this.o);
    for (int i1 = 0;; i1 = this.j + 1)
    {
      this.j = i1;
      if (localObject == null) {
        break;
      }
      this.i[this.j] = localObject;
      localObject = ((c.c.c)localObject).b;
    }
    this.h = -1;
    d();
  }
  
  private final Message f()
  {
    return this.d;
  }
  
  private final a g()
  {
    return this.g[this.h].a;
  }
  
  private final void h()
  {
    if (this.b) {
      this.m.a("quit:");
    }
    sendMessage(obtainMessage(-1, c));
  }
  
  private final void i()
  {
    if (this.b) {
      this.m.a("quitNow:");
    }
    sendMessageAtFrontOfQueue(obtainMessage(-1, c));
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (!this.a)
    {
      if (this.b)
      {
        localObject = this.m;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleMessage: E msg.what=");
        localStringBuilder.append(paramMessage.what);
        ((c)localObject).a(localStringBuilder.toString());
      }
      this.d = paramMessage;
      Object localObject = null;
      boolean bool = this.f;
      if (bool)
      {
        localObject = a(paramMessage);
      }
      else
      {
        if ((bool) || (this.d.what != -2) || (this.d.obj != c)) {
          break label150;
        }
        this.f = true;
        a(0);
      }
      a((b)localObject, paramMessage);
      if (this.b)
      {
        paramMessage = this.m;
        if (paramMessage != null)
        {
          paramMessage.a("handleMessage: X");
          return;
          label150:
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("StateMachine.handleMessage: The start method not called, received msg: ");
          ((StringBuilder)localObject).append(paramMessage);
          throw new RuntimeException(((StringBuilder)localObject).toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ra.c.c
 * JD-Core Version:    0.7.0.1
 */