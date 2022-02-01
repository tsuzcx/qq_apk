package com.tencent.luggage.wxa.de;

import android.os.HandlerThread;
import android.util.SparseArray;
import com.google.protobuf.ByteString;
import com.tencent.ilink.tdi.b.c;
import com.tencent.ilink.tdi.b.c.a;
import com.tencent.ilink.tdi.b.d;
import com.tencent.ilink.tdi.b.h;
import com.tencent.ilink.tdi.b.y;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.dc.w;
import com.tencent.luggage.wxa.ob.a.a;
import com.tencent.luggage.wxa.qw.aa;
import com.tencent.luggage.wxa.qw.gt;
import com.tencent.luggage.wxa.qw.gu;
import com.tencent.luggage.wxa.qw.hf;
import com.tencent.luggage.wxa.qw.ir;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rp.g;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/account/tdi/TdiCgiServiceBase;", "TRAN_REQ", "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "TRAN_RESP", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/mm/plugin/appbrand/networking/ICgiService;", "Lcom/tencent/luggage/login/account/tdi/ITdiCgiService;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "baseLogTag", "getBaseLogTag", "baseLogTag$delegate", "Lkotlin/Lazy;", "mBootCallbacks", "Ljava/util/ArrayList;", "Lkotlin/Function2;", "", "", "Lkotlin/collections/ArrayList;", "mBooting", "mSyncObj", "Ljava/lang/Object;", "mTdiCgi", "Lcom/tencent/luggage/login/account/tdi/ITdiCgi;", "mTdiCgiCallbackInner", "Lcom/tencent/luggage/login/account/tdi/ITdiCgiCallback;", "mTdiCgiCallbackMap", "Landroid/util/SparseArray;", "transfer_action", "Lcom/tencent/mm/protocal/protobuf/TransferAction;", "getTransfer_action", "(Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;)Lcom/tencent/mm/protocal/protobuf/TransferAction;", "avoidProtoCrash", "req", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "boot", "bootCallback", "bootInner", "createTdiAppRequest", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiAppRequest;", "cmdId", "", "url", "networkType", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiNetType;", "createTransferReq", "appId", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protobuf/BaseProtoBuf;)Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "createTransferRespClass", "Ljava/lang/Class;", "decode", "RESP", "resClz", "buf", "", "(Ljava/lang/Class;[B)Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "fixBaseReq", "installNoLoginTdiCgi", "tdiCgi", "installTdiCgi", "processTdiResp", "resp", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiAppResponse;", "respClazz", "(Lcom/tencent/ilink/tdi/TdiApiProto$TdiAppResponse;Ljava/lang/Class;)Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "processTransResp", "transResp", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;Ljava/lang/Class;)Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "sendTdiRequest", "callback", "sync", "(ILjava/lang/String;Lcom/tencent/ilink/tdi/TdiApiProto$TdiNetType;Lcom/tencent/mm/protobuf/BaseProtoBuf;Ljava/lang/Class;)Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protobuf/BaseProtoBuf;Ljava/lang/Class;)Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "syncPipeline", "Lcom/tencent/mm/vending/pipeline/Pipeable;", "toRespData", "(Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;)[B", "transferCmdId", "transferNetworkType", "transferUrl", "uninstall", "Companion", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public abstract class j<TRAN_REQ extends gt, TRAN_RESP extends gu>
  implements d, com.tencent.luggage.wxa.ob.b
{
  public static final j.a a = new j.a(null);
  private static HandlerThread i;
  @NotNull
  private final Lazy b = LazyKt.lazy((Function0)new j.b(this));
  private volatile b c;
  private boolean d;
  private Object e = new Object();
  private ArrayList<Function2<Boolean, String, Unit>> f = new ArrayList();
  private final c g = (c)new j.e(this);
  private final SparseArray<c> h = new SparseArray();
  
  static
  {
    HandlerThread localHandlerThread = new HandlerThread("tdi_thread_name", -2);
    localHandlerThread.start();
    g.a("tdi_thread_name", (com.tencent.luggage.wxa.rp.d)new com.tencent.luggage.wxa.rp.h(localHandlerThread.getLooper(), "tdi_thread_name"));
    i = localHandlerThread;
  }
  
  private final int a(b.c paramc, c paramc1)
  {
    ??? = this.c;
    int j;
    if (??? != null) {
      j = ((b)???).a(paramc);
    } else {
      j = -1;
    }
    String str1 = f();
    ??? = new StringBuilder();
    ((StringBuilder)???).append(paramc.c());
    ((StringBuilder)???).append(" sendTdiRequest taskId[%d] cmdId[%d] url[%s] tdi[%s]");
    Object localObject2 = ((StringBuilder)???).toString();
    int k = paramc.c();
    String str2 = paramc.i();
    ??? = this.c;
    if (??? != null)
    {
      ??? = ???.getClass();
      if (??? != null)
      {
        ??? = ((Class)???).getCanonicalName();
        if (??? != null) {
          break label119;
        }
      }
    }
    ??? = "null";
    label119:
    o.d(str1, (String)localObject2, new Object[] { Integer.valueOf(j), Integer.valueOf(k), str2, ??? });
    if ((j != -1) && (j != 0)) {
      synchronized (this.h)
      {
        if (this.c != null)
        {
          this.h.put(j, paramc1);
        }
        else
        {
          str1 = b();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramc.c());
          ((StringBuilder)localObject2).append(" sendTdiRequest taskId:");
          ((StringBuilder)localObject2).append(j);
          ((StringBuilder)localObject2).append(", mTdiCgi==null, callback -1 directly");
          o.d(str1, ((StringBuilder)localObject2).toString());
          paramc1.a(j, -1, null);
        }
        paramc = Unit.INSTANCE;
        return j;
      }
    }
    paramc1.a(j, -1, null);
    return j;
  }
  
  private final <RESP extends gu> RESP a(String paramString, TRAN_RESP paramTRAN_RESP, Class<RESP> paramClass)
  {
    StringBuilder localStringBuilder2 = null;
    StringBuilder localStringBuilder1 = null;
    Object localObject;
    if (paramTRAN_RESP != null) {
      localObject = paramTRAN_RESP.a();
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      localObject = a(paramTRAN_RESP);
      int j;
      if (localObject != null) {
        j = ((ir)localObject).a;
      } else {
        j = 0;
      }
      if (j != 0)
      {
        localObject = f();
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("processTransResp, transResp: [");
        localStringBuilder2.append(paramTRAN_RESP.a().a);
        localStringBuilder2.append(',');
        localStringBuilder2.append(' ');
        paramClass = paramTRAN_RESP.a().b;
        if (paramClass != null) {
          paramClass = paramClass.a();
        } else {
          paramClass = null;
        }
        localStringBuilder2.append(paramClass);
        localStringBuilder2.append(", ");
        paramClass = a(paramTRAN_RESP);
        if (paramClass == null) {
          Intrinsics.throwNpe();
        }
        localStringBuilder2.append(paramClass);
        localStringBuilder2.append("] url=");
        localStringBuilder2.append(paramString);
        o.b((String)localObject, localStringBuilder2.toString());
        j = paramTRAN_RESP.a().a;
        paramClass = paramTRAN_RESP.a().b;
        paramString = localStringBuilder1;
        if (paramClass != null) {
          paramString = paramClass.a();
        }
        paramTRAN_RESP = a(paramTRAN_RESP);
        if (paramTRAN_RESP == null) {
          Intrinsics.throwNpe();
        }
        throw ((Throwable)new com.tencent.luggage.wxa.dc.d(j, paramString, paramTRAN_RESP));
      }
      if (paramTRAN_RESP.a().a != 0)
      {
        localObject = paramTRAN_RESP.a().b;
        paramClass = localStringBuilder2;
        if (localObject != null) {
          paramClass = ((hf)localObject).a();
        }
        localObject = f();
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("processTransResp, baseResponse=[");
        localStringBuilder1.append(paramTRAN_RESP.a().a);
        localStringBuilder1.append(" \"");
        localStringBuilder1.append(paramClass);
        localStringBuilder1.append("\"] url=");
        localStringBuilder1.append(paramString);
        o.b((String)localObject, localStringBuilder1.toString());
        throw ((Throwable)new com.tencent.luggage.wxa.ob.a(a.a.f, paramTRAN_RESP.a().a, paramClass));
      }
      paramTRAN_RESP = a(paramClass, b(paramTRAN_RESP));
      if (paramTRAN_RESP != null) {
        return paramTRAN_RESP;
      }
      paramTRAN_RESP = f();
      paramClass = new StringBuilder();
      paramClass.append("processTransResp, decode failed, url=");
      paramClass.append(paramString);
      o.b(paramTRAN_RESP, paramClass.toString());
      throw ((Throwable)new com.tencent.luggage.wxa.ob.a(a.a.c, 0, null));
    }
    paramTRAN_RESP = f();
    paramClass = new StringBuilder();
    paramClass.append("processTransResp: recv failed url:");
    paramClass.append(paramString);
    o.b(paramTRAN_RESP, paramClass.toString());
    throw ((Throwable)new com.tencent.luggage.wxa.ob.a(a.a.c, 0, null));
  }
  
  private final void b(Function2<? super Boolean, ? super String, Unit> paramFunction2)
  {
    synchronized (this.e)
    {
      if (this.c != null)
      {
        if (paramFunction2 != null) {
          paramFunction2.invoke(Boolean.valueOf(true), "");
        }
        return;
      }
      if (paramFunction2 != null) {
        this.f.add(paramFunction2);
      }
      boolean bool = this.d;
      if (bool) {
        return;
      }
      this.d = true;
      paramFunction2 = Unit.INSTANCE;
      a((Function2)new j.c(this));
      return;
    }
  }
  
  @NotNull
  public b.c a(int paramInt, @NotNull String paramString, @NotNull b.y paramy, @Nullable com.tencent.luggage.wxa.qu.a parama)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Intrinsics.checkParameterIsNotNull(paramy, "networkType");
    b.c.a locala = b.c.u();
    if (parama != null)
    {
      parama = parama.b();
      if (parama != null) {}
    }
    else
    {
      parama = new byte[0];
    }
    paramString = locala.a(ByteString.copyFrom(parama)).a(paramString).a(paramInt).b(30000).a(paramy).a(b.h.b).c();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "TdiApiProto.TdiAppReques…ion)\n            .build()");
    return paramString;
  }
  
  @Nullable
  public <RESP extends gu> RESP a(int paramInt, @NotNull String paramString, @NotNull b.y paramy, @Nullable com.tencent.luggage.wxa.qu.a parama, @NotNull Class<RESP> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Intrinsics.checkParameterIsNotNull(paramy, "networkType");
    Intrinsics.checkParameterIsNotNull(paramClass, "respClazz");
    if (parama == null) {
      return null;
    }
    AtomicReference localAtomicReference = new AtomicReference();
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    b((Function2)new j.f(this, parama, paramInt, paramString, paramy, localAtomicReference, paramClass, localCountDownLatch));
    try
    {
      localCountDownLatch.await(60L, TimeUnit.SECONDS);
      if (localAtomicReference.get() == null)
      {
        paramy = f();
        parama = new StringBuilder();
        parama.append(paramInt);
        parama.append(' ');
        parama.append(paramString);
        parama.append(" sync fail, timeout");
        o.b(paramy, parama.toString());
        return null;
      }
      paramString = localAtomicReference.get();
      if (paramString != null) {
        return (gu)paramString;
      }
      throw new TypeCastException("null cannot be cast to non-null type RESP");
    }
    catch (Exception paramString) {}
    return null;
  }
  
  @Nullable
  protected final <RESP extends gu> RESP a(@NotNull b.d paramd, @NotNull Class<RESP> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "resp");
    Intrinsics.checkParameterIsNotNull(paramClass, "respClazz");
    if (paramd.c() != null) {
      return a(paramClass, paramd.c().toByteArray());
    }
    o.b(f(), "runSync::recv failed resp is null");
    throw ((Throwable)new com.tencent.luggage.wxa.ob.a(a.a.c, 0, null));
  }
  
  @Nullable
  protected final <RESP extends gu> RESP a(@Nullable Class<RESP> paramClass, @Nullable byte[] paramArrayOfByte)
  {
    if (paramClass != null) {}
    for (;;)
    {
      try
      {
        localObject1 = (gu)paramClass.newInstance();
        if (localObject1 != null) {
          ((gu)localObject1).a(paramArrayOfByte);
        }
        localObject3 = f();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("RespData decode done for response class ");
        localStringBuilder.append(paramClass);
        o.e((String)localObject3, localStringBuilder.toString());
        return localObject1;
      }
      catch (Exception localException)
      {
        Object localObject1;
        Object localObject3;
        continue;
      }
      localObject1 = f();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("RespData decode failed for response class ");
      ((StringBuilder)localObject3).append(paramClass);
      ((StringBuilder)localObject3).append(" buf:");
      if (paramArrayOfByte != null) {
        paramClass = Integer.valueOf(paramArrayOfByte.length);
      } else {
        paramClass = null;
      }
      ((StringBuilder)localObject3).append(paramClass);
      o.b((String)localObject1, ((StringBuilder)localObject3).toString());
      return null;
      Object localObject2 = null;
    }
  }
  
  @Nullable
  public <RESP extends gu> RESP a(@Nullable String paramString1, @Nullable String paramString2, @Nullable com.tencent.luggage.wxa.qu.a parama, @NotNull Class<RESP> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "respClazz");
    if (parama == null) {
      return null;
    }
    a(parama);
    b(parama);
    Object localObject = b(paramString1, paramString2, parama);
    int j = h();
    paramString2 = g();
    parama = i();
    localObject = (com.tencent.luggage.wxa.qu.a)localObject;
    Class localClass = e();
    if (localClass == null) {
      Intrinsics.throwNpe();
    }
    paramString2 = a(j, paramString2, parama, (com.tencent.luggage.wxa.qu.a)localObject, localClass);
    try
    {
      paramString1 = a(paramString1, paramString2, paramClass);
      return paramString1;
    }
    catch (com.tencent.luggage.wxa.ob.a paramString1)
    {
      o.b(f(), "e:%s", new Object[] { paramString1 });
    }
    return null;
  }
  
  @Nullable
  protected abstract ir a(@NotNull TRAN_RESP paramTRAN_RESP);
  
  public void a()
  {
    ??? = this.c;
    if (??? != null) {
      ((b)???).a();
    }
    this.c = ((b)null);
    int j = 0;
    this.d = false;
    synchronized (this.h)
    {
      int k = this.h.size();
      Object localObject2;
      if (j < k)
      {
        int m = this.h.keyAt(j);
        localObject2 = (c)this.h.get(m);
        if (localObject2 != null) {
          ((c)localObject2).a(m, -1, null);
        }
      }
      else
      {
        this.h.clear();
        localObject2 = Unit.INSTANCE;
        return;
      }
    }
  }
  
  public void a(@NotNull b paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "tdiCgi");
    String str = f();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this);
    localStringBuilder.append(" installTdiCgi: ");
    localStringBuilder.append(paramb);
    o.d(str, localStringBuilder.toString());
    a();
    this.c = paramb;
    paramb = this.c;
    if (paramb != null) {
      paramb.a(this.g);
    }
  }
  
  public void a(@Nullable com.tencent.luggage.wxa.qu.a parama) {}
  
  public void a(@Nullable Function2<? super Boolean, ? super String, Unit> paramFunction2)
  {
    com.tencent.luggage.wxa.dg.b localb = (com.tencent.luggage.wxa.dg.b)e.a(com.tencent.luggage.wxa.dg.b.class);
    if (localb == null) {
      localb = com.tencent.luggage.wxa.dg.b.b;
    }
    w localw = w.a;
    Intrinsics.checkExpressionValueIsNotNull(localb, "activateDeviceLogic");
    localw.b(localb, (Function2)new j.d(this, paramFunction2));
  }
  
  @Nullable
  public TRAN_REQ b(@Nullable String paramString1, @Nullable String paramString2, @Nullable com.tencent.luggage.wxa.qu.a parama)
  {
    return null;
  }
  
  @NotNull
  public <RESP extends gu> com.tencent.luggage.wxa.ro.d<RESP> b(int paramInt, @NotNull String paramString, @NotNull b.y paramy, @Nullable com.tencent.luggage.wxa.qu.a parama, @NotNull Class<RESP> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Intrinsics.checkParameterIsNotNull(paramy, "networkType");
    Intrinsics.checkParameterIsNotNull(paramClass, "respClazz");
    paramString = com.tencent.luggage.wxa.ro.h.a().a("tdi_thread_name").a((com.tencent.luggage.wxa.rl.b)new j.g(this)).a("tdi_thread_name").a((com.tencent.luggage.wxa.rl.b)new j.h(this, parama, paramInt, paramString, paramy, paramClass));
    Intrinsics.checkExpressionValueIsNotNull(paramString, "QuickAccess.pipeline()\n …       null\n            }");
    return paramString;
  }
  
  @NotNull
  public <RESP extends gu> com.tencent.luggage.wxa.ro.d<RESP> b(@Nullable String paramString1, @Nullable String paramString2, @Nullable com.tencent.luggage.wxa.qu.a parama, @NotNull Class<RESP> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "respClazz");
    a(parama);
    Object localObject = b(paramString1, paramString2, parama);
    int j = h();
    paramString2 = g();
    parama = i();
    localObject = (com.tencent.luggage.wxa.qu.a)localObject;
    Class localClass = e();
    if (localClass == null) {
      Intrinsics.throwNpe();
    }
    paramString1 = b(j, paramString2, parama, (com.tencent.luggage.wxa.qu.a)localObject, localClass).a((com.tencent.luggage.wxa.rl.b)new j.i(this, paramString1, paramClass));
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "syncPipeline(transferCmd…           null\n        }");
    return paramString1;
  }
  
  @NotNull
  protected abstract String b();
  
  public void b(@Nullable com.tencent.luggage.wxa.qu.a parama) {}
  
  @NotNull
  public byte[] b(@NotNull TRAN_RESP paramTRAN_RESP)
  {
    Intrinsics.checkParameterIsNotNull(paramTRAN_RESP, "resp");
    return new byte[0];
  }
  
  @Nullable
  public Class<TRAN_RESP> e()
  {
    return null;
  }
  
  @NotNull
  public final String f()
  {
    return (String)this.b.getValue();
  }
  
  @NotNull
  public String g()
  {
    return a.a.b();
  }
  
  public int h()
  {
    return a.a.a();
  }
  
  @NotNull
  public b.y i()
  {
    return b.y.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.de.j
 * JD-Core Version:    0.7.0.1
 */