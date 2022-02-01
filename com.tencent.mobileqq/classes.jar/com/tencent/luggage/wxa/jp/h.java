package com.tencent.luggage.wxa.jp;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.jn.d;
import com.tencent.luggage.wxa.jo.c;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import rx.Observable;
import rx.subscriptions.CompositeSubscription;

public class h
{
  private static final String b = h.class.getSimpleName();
  private CompositeSubscription c = new CompositeSubscription();
  private ReentrantReadWriteLock d = new ReentrantReadWriteLock(true);
  private Lock e = this.d.writeLock();
  private boolean f = false;
  private int g = -1;
  private e h;
  private Pattern i = Pattern.compile("uuid:([a-fA-F\\d]{8}(-[a-fA-F\\d]{4}){3}-[a-fA-F\\d]{12})");
  private Set<String> j = new HashSet();
  
  public static h a()
  {
    return h.a.a();
  }
  
  @Nullable
  private String a(@Nullable String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    String str = null;
    if (bool) {
      return null;
    }
    Object localObject = this.i.matcher(paramString);
    if (((Matcher)localObject).find()) {
      str = ((Matcher)localObject).group(1);
    }
    localObject = str;
    if (str == null)
    {
      if ((!a) && (paramString == null)) {
        throw new AssertionError();
      }
      localObject = b(paramString);
    }
    return localObject;
  }
  
  private void a(Lock paramLock)
  {
    a(paramLock, e());
  }
  
  private void a(Lock paramLock, int paramInt)
  {
    long l = paramInt;
    try
    {
      if (paramLock.tryLock(l, TimeUnit.MILLISECONDS)) {
        return;
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("Router wasn't available exclusively after waiting ");
      localStringBuilder1.append(paramInt);
      localStringBuilder1.append("ms, lock failed: ");
      localStringBuilder1.append(paramLock.getClass().getSimpleName());
      throw new com.tencent.luggage.wxa.js.a(localStringBuilder1.toString());
    }
    catch (InterruptedException localInterruptedException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("Interruption while waiting for exclusive access: ");
      localStringBuilder2.append(paramLock.getClass().getSimpleName());
      throw new com.tencent.luggage.wxa.js.a(localStringBuilder2.toString(), localInterruptedException);
    }
  }
  
  private String b(String paramString)
  {
    String str = b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fallbackGetUuid: ");
    localStringBuilder.append(paramString);
    com.tencent.luggage.wxa.jm.a.b(str, localStringBuilder.toString());
    str = paramString;
    if (paramString.startsWith("uuid:")) {
      str = paramString.substring(5);
    }
    return str;
  }
  
  private void b(Lock paramLock)
  {
    paramLock.unlock();
  }
  
  private boolean b(com.tencent.luggage.wxa.jr.b paramb)
  {
    String str1 = paramb.a("NT");
    Object localObject2 = paramb.a("ST");
    Object localObject1 = paramb.a("NTS");
    String str2 = paramb.a("USN");
    paramb = paramb.a("LOCATION");
    if ((!"upnp:rootdevice".equals(str1)) && (!"upnp:rootdevice".equals(localObject2))) {
      return false;
    }
    if ((this.j.size() > 0) && (this.j.contains(paramb))) {
      return false;
    }
    str1 = a(str2);
    if (TextUtils.isEmpty(str1)) {
      return false;
    }
    localObject2 = com.tencent.luggage.wxa.jo.a.a();
    if ("ssdp:alive".equals(localObject1))
    {
      localObject1 = ((com.tencent.luggage.wxa.jo.a)localObject2).c(str1);
      if (localObject1 != null)
      {
        if (!((c)localObject1).a().a.equals(paramb))
        {
          ((com.tencent.luggage.wxa.jo.a)localObject2).b(str1);
          this.j.add(paramb);
          return true;
        }
        return false;
      }
      if (!TextUtils.isEmpty(paramb))
      {
        this.j.add(paramb);
        return true;
      }
      return false;
    }
    if ("ssdp:byebye".equals(localObject1))
    {
      if (((com.tencent.luggage.wxa.jo.a)localObject2).a(str1)) {
        ((com.tencent.luggage.wxa.jo.a)localObject2).b(str1);
      }
      return false;
    }
    if (TextUtils.isEmpty(paramb))
    {
      com.tencent.luggage.wxa.jm.a.b(b, "mDevice location is empty");
      return false;
    }
    return ((com.tencent.luggage.wxa.jo.a)localObject2).a(str1) ^ true;
  }
  
  private int e()
  {
    return 6000;
  }
  
  public void a(d paramd)
  {
    if (!this.f)
    {
      com.tencent.luggage.wxa.jm.a.b(b, "DLNA Router is not enable");
      return;
    }
    this.c.add(new b.c(paramd).a().subscribe(new h.4(this), new h.5(this)));
  }
  
  public void a(com.tencent.luggage.wxa.jn.e parame, com.tencent.luggage.wxa.jq.a parama)
  {
    if (!this.f)
    {
      com.tencent.luggage.wxa.jm.a.b(b, "DLNA Router is not enable");
      return;
    }
    this.c.add(new b.b(parame).a().subscribe(new h.2(this, parame, parama), new h.3(this, parama)));
  }
  
  /* Error */
  public void a(com.tencent.luggage.wxa.jr.b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 62	com/tencent/luggage/wxa/jp/h:e	Ljava/util/concurrent/locks/Lock;
    //   5: invokespecial 300	com/tencent/luggage/wxa/jp/h:a	(Ljava/util/concurrent/locks/Lock;)V
    //   8: aload_0
    //   9: getfield 64	com/tencent/luggage/wxa/jp/h:f	Z
    //   12: istore_2
    //   13: iload_2
    //   14: ifne +12 -> 26
    //   17: aload_0
    //   18: aload_0
    //   19: getfield 62	com/tencent/luggage/wxa/jp/h:e	Ljava/util/concurrent/locks/Lock;
    //   22: invokespecial 302	com/tencent/luggage/wxa/jp/h:b	(Ljava/util/concurrent/locks/Lock;)V
    //   25: return
    //   26: aload_0
    //   27: aload_1
    //   28: invokespecial 304	com/tencent/luggage/wxa/jp/h:b	(Lcom/tencent/luggage/wxa/jr/b;)Z
    //   31: ifeq +44 -> 75
    //   34: aload_0
    //   35: getfield 49	com/tencent/luggage/wxa/jp/h:c	Lrx/subscriptions/CompositeSubscription;
    //   38: new 306	com/tencent/luggage/wxa/jp/b$a
    //   41: dup
    //   42: aload_1
    //   43: invokespecial 308	com/tencent/luggage/wxa/jp/b$a:<init>	(Lcom/tencent/luggage/wxa/jr/b;)V
    //   46: invokevirtual 309	com/tencent/luggage/wxa/jp/b$a:a	()Lrx/Observable;
    //   49: new 311	com/tencent/luggage/wxa/jp/h$6
    //   52: dup
    //   53: aload_0
    //   54: aload_1
    //   55: invokespecial 314	com/tencent/luggage/wxa/jp/h$6:<init>	(Lcom/tencent/luggage/wxa/jp/h;Lcom/tencent/luggage/wxa/jr/b;)V
    //   58: new 316	com/tencent/luggage/wxa/jp/h$7
    //   61: dup
    //   62: aload_0
    //   63: invokespecial 317	com/tencent/luggage/wxa/jp/h$7:<init>	(Lcom/tencent/luggage/wxa/jp/h;)V
    //   66: invokevirtual 275	rx/Observable:subscribe	(Lrx/functions/Action1;Lrx/functions/Action1;)Lrx/Subscription;
    //   69: invokevirtual 278	rx/subscriptions/CompositeSubscription:add	(Lrx/Subscription;)V
    //   72: goto +30 -> 102
    //   75: getstatic 40	com/tencent/luggage/wxa/jp/h:b	Ljava/lang/String;
    //   78: ldc_w 319
    //   81: invokestatic 321	com/tencent/luggage/wxa/jm/a:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: goto +18 -> 102
    //   87: astore_1
    //   88: goto +23 -> 111
    //   91: astore_1
    //   92: getstatic 40	com/tencent/luggage/wxa/jp/h:b	Ljava/lang/String;
    //   95: aload_1
    //   96: ldc_w 323
    //   99: invokestatic 326	com/tencent/luggage/wxa/jm/a:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   102: aload_0
    //   103: aload_0
    //   104: getfield 62	com/tencent/luggage/wxa/jp/h:e	Ljava/util/concurrent/locks/Lock;
    //   107: invokespecial 302	com/tencent/luggage/wxa/jp/h:b	(Ljava/util/concurrent/locks/Lock;)V
    //   110: return
    //   111: aload_0
    //   112: aload_0
    //   113: getfield 62	com/tencent/luggage/wxa/jp/h:e	Ljava/util/concurrent/locks/Lock;
    //   116: invokespecial 302	com/tencent/luggage/wxa/jp/h:b	(Ljava/util/concurrent/locks/Lock;)V
    //   119: aload_1
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	h
    //   0	121	1	paramb	com.tencent.luggage.wxa.jr.b
    //   12	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   0	13	87	finally
    //   26	72	87	finally
    //   75	84	87	finally
    //   92	102	87	finally
    //   0	13	91	java/lang/Exception
    //   26	72	91	java/lang/Exception
    //   75	84	91	java/lang/Exception
  }
  
  public void a(boolean paramBoolean)
  {
    a(new com.tencent.luggage.wxa.jn.h(paramBoolean));
  }
  
  public boolean b()
  {
    com.tencent.luggage.wxa.jm.a.a(b, "mRouter is starting ...");
    this.g = i.a().c();
    try
    {
      if (!this.f)
      {
        List localList = g.a();
        this.h = new e(new f("239.255.255.250", 1900), localList, this, this.g);
        this.h.b();
        this.f = true;
        return true;
      }
      return false;
    }
    catch (Exception localException)
    {
      com.tencent.luggage.wxa.jm.a.a(b, localException, "");
    }
    return false;
  }
  
  public boolean c()
  {
    com.tencent.luggage.wxa.jm.a.a(b, "mRouter is shutting down...");
    if (this.f)
    {
      this.j.clear();
      this.h.c();
      this.c.clear();
      this.f = false;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jp.h
 * JD-Core Version:    0.7.0.1
 */