package com.tencent.luggage.wxa.lk;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentFilter.MalformedMimeTypeException;
import android.nfc.NdefMessage;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.nfc.tech.MifareClassic;
import android.nfc.tech.MifareUltralight;
import android.nfc.tech.Ndef;
import android.nfc.tech.NfcA;
import android.nfc.tech.NfcB;
import android.nfc.tech.NfcF;
import android.nfc.tech.NfcV;
import com.tencent.luggage.wxa.ll.a;
import com.tencent.luggage.wxa.ll.b;
import com.tencent.luggage.wxa.ll.b.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joor.ReflectException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager;", "", "appId", "", "activity", "Landroid/app/Activity;", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "(Ljava/lang/String;Landroid/app/Activity;Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;)V", "getActivity", "()Landroid/app/Activity;", "activityEventInterceptor", "Lkotlin/Function1;", "Landroid/content/Intent;", "", "getAppId", "()Ljava/lang/String;", "getComponent", "()Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "connectedTech", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/NFCTech;", "kotlin.jvm.PlatformType", "", "isActivityEventInterceptorAdded", "isLifeCycleListenerAdded", "isNFCDiscovering", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isNFCDiscoverySticky", "lifeCycleListener", "com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$lifeCycleListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$lifeCycleListener$1;", "nfcTagDiscoveredCallback", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "id", "", "techs", "Landroid/nfc/NdefMessage;", "ndefMessages", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCTagDiscoveredCallback;", "getNfcTagDiscoveredCallback", "()Lkotlin/jvm/functions/Function3;", "setNfcTagDiscoveredCallback", "(Lkotlin/jvm/functions/Function3;)V", "pendingIntent", "Landroid/app/PendingIntent;", "requireForegroundDispatch", "getRequireForegroundDispatch", "()Z", "setRequireForegroundDispatch", "(Z)V", "sysNfcSwitchToggleListener", "com/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$sysNfcSwitchToggleListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteManager$sysNfcSwitchToggleListener$1;", "tag", "Landroid/nfc/Tag;", "addActivityEventInterceptorOnce", "addLifeCycleListenerOnce", "close", "techName", "callback", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteResult;", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/logic/NFCReadWriteCallback;", "connect", "execTechLogic", "function", "params", "Lcom/tencent/mm/plugin/appbrand/jsapi/nfc/rw/model/INFCTechExecParams;", "execTechLogicAsync", "getMaxTransceiveLength", "", "getNFCTech", "T", "getTag", "getTagTechnology", "Landroid/nfc/tech/TagTechnology;", "nfcTech", "tagSnapshot", "isConnected", "removeActivityEventInterceptorIfNecessary", "removeLifeCycleListenerIfNecessary", "setTimeout", "timeoutMs", "startNFCDiscovery", "stopNFCDiscovery", "transceive", "reqData", "tryDispatchNfcTagDiscovered", "intent", "tryParseMessageMap", "writeNdefMessage", "message", "messageToString", "", "Companion", "luggage-commons-jsapi-nfc-ext_release"}, k=1, mv={1, 1, 16})
public class c
{
  public static final c.a a = new c.a(null);
  private static final Map<String, c> q = (Map)new ConcurrentHashMap();
  private static final IntentFilter[] r;
  private static final String[][] s = (String[][])new String[][] { { NfcA.class.getName() }, { NfcB.class.getName() }, { IsoDep.class.getName() }, { NfcF.class.getName() }, { NfcV.class.getName() }, { MifareClassic.class.getName() }, { MifareUltralight.class.getName() }, { Ndef.class.getName() } };
  @NotNull
  private static c.a.a t = (c.a.a)new c.b();
  private volatile boolean b;
  @Nullable
  private volatile Function3<? super byte[], ? super List<String>, ? super List<NdefMessage>, Unit> c;
  private final PendingIntent d;
  private boolean e;
  private final Function1<Intent, Boolean> f;
  private final AtomicBoolean g;
  private boolean h;
  private boolean i;
  private final c.i j;
  private volatile Tag k;
  private final Set<b> l;
  private final c.m m;
  @NotNull
  private final String n;
  @NotNull
  private final Activity o;
  @NotNull
  private final com.tencent.luggage.wxa.jx.c p;
  
  static
  {
    IntentFilter localIntentFilter = new IntentFilter("android.nfc.action.TAG_DISCOVERED");
    try
    {
      localIntentFilter.addDataType("*/*");
    }
    catch (IntentFilter.MalformedMimeTypeException localMalformedMimeTypeException)
    {
      label43:
      break label43;
    }
    o.c("MicroMsg.AppBrand.NFCReadWriteManager", "addDataType failed");
    r = new IntentFilter[] { localIntentFilter };
  }
  
  public c(@NotNull String paramString, @NotNull Activity paramActivity, @NotNull com.tencent.luggage.wxa.jx.c paramc)
  {
    this.n = paramString;
    this.o = paramActivity;
    this.p = paramc;
    paramString = this.o;
    paramString = new Intent((Context)paramString, paramString.getClass()).addFlags(536870912);
    this.d = PendingIntent.getActivity((Context)this.o, 0, paramString, 0);
    this.f = ((Function1)new c.c(this));
    this.g = new AtomicBoolean(false);
    this.j = new c.i(this);
    this.l = Collections.newSetFromMap((Map)new ConcurrentHashMap());
    this.m = new c.m(this);
    this.o.registerReceiver((BroadcastReceiver)this.m, new IntentFilter("android.nfc.action.ADAPTER_STATE_CHANGED"));
    com.tencent.luggage.wxa.iu.c.a(this.n, (com.tencent.luggage.wxa.iu.c.c)new c.1(this));
  }
  
  private final String a(@NotNull Throwable paramThrowable)
  {
    if ((paramThrowable instanceof ReflectException))
    {
      paramThrowable = paramThrowable.getCause();
      if (paramThrowable != null)
      {
        paramThrowable = paramThrowable.getCause();
        if (paramThrowable != null) {
          return paramThrowable.toString();
        }
      }
      return null;
    }
    return paramThrowable.toString();
  }
  
  private final List<NdefMessage> b(Intent paramIntent)
  {
    o.e("MicroMsg.AppBrand.NFCReadWriteManager", "tryParseMessageMap");
    paramIntent = paramIntent.getParcelableArrayExtra("android.nfc.extra.NDEF_MESSAGES");
    if (paramIntent != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("tryDispatchNdefMessagesRead, rawMessages: ");
      String str = Arrays.toString(paramIntent);
      Intrinsics.checkExpressionValueIsNotNull(str, "java.util.Arrays.toString(this)");
      ((StringBuilder)localObject).append(str);
      o.d("MicroMsg.AppBrand.NFCReadWriteManager", ((StringBuilder)localObject).toString());
      localObject = (Collection)new ArrayList(paramIntent.length);
      int i2 = paramIntent.length;
      int i1 = 0;
      while (i1 < i2)
      {
        str = paramIntent[i1];
        if (str != null)
        {
          ((Collection)localObject).add((NdefMessage)str);
          i1 += 1;
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type android.nfc.NdefMessage");
        }
      }
      return (List)localObject;
    }
    return null;
  }
  
  private final void h()
  {
    o.e("MicroMsg.AppBrand.NFCReadWriteManager", "addActivityEventInterceptorOnce");
    if (!this.e)
    {
      String str = this.n;
      Function1 localFunction1 = this.f;
      Object localObject = localFunction1;
      if (localFunction1 != null) {
        localObject = new d(localFunction1);
      }
      com.tencent.luggage.wxa.iu.c.a(str, (com.tencent.luggage.wxa.iu.c.a)localObject);
      this.e = true;
    }
  }
  
  private final void i()
  {
    o.e("MicroMsg.AppBrand.NFCReadWriteManager", "removeActivityEventInterceptorIfNecessary");
    if (this.e)
    {
      String str = this.n;
      Function1 localFunction1 = this.f;
      Object localObject = localFunction1;
      if (localFunction1 != null) {
        localObject = new d(localFunction1);
      }
      com.tencent.luggage.wxa.iu.c.b(str, (com.tencent.luggage.wxa.iu.c.a)localObject);
      this.e = false;
    }
  }
  
  private final void j()
  {
    o.e("MicroMsg.AppBrand.NFCReadWriteManager", "addLifeCycleListenerOnce");
    if (!this.i)
    {
      com.tencent.luggage.wxa.iu.c.a(this.n, (com.tencent.luggage.wxa.iu.c.c)this.j);
      this.i = true;
    }
  }
  
  private final void k()
  {
    o.e("MicroMsg.AppBrand.NFCReadWriteManager", "removeLifeCycleListenerIfNecessary");
    if (this.i)
    {
      com.tencent.luggage.wxa.iu.c.b(this.n, (com.tencent.luggage.wxa.iu.c.c)this.j);
      this.i = false;
    }
  }
  
  @NotNull
  protected final String a()
  {
    return this.n;
  }
  
  public void a(@NotNull Intent paramIntent)
  {
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    o.e("MicroMsg.AppBrand.NFCReadWriteManager", "tryDispatchNfcTagDiscovered");
    Function3 localFunction3 = this.c;
    if (localFunction3 != null)
    {
      Object localObject1 = this.k;
      if (localObject1 != null)
      {
        localObject1 = ((Tag)localObject1).getTechList();
        if (localObject1 != null)
        {
          Collection localCollection = (Collection)new ArrayList();
          int i2 = localObject1.length;
          int i1 = 0;
          while (i1 < i2)
          {
            localObject2 = localObject1[i1];
            localObject2 = (String)b.i.b().get(localObject2);
            if (localObject2 != null) {
              localCollection.add(localObject2);
            }
            i1 += 1;
          }
          Object localObject2 = (List)localCollection;
          byte[] arrayOfByte = paramIntent.getByteArrayExtra("android.nfc.extra.ID");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("tryDispatchNfcTagDiscovered, id: ");
          localCollection = null;
          if (arrayOfByte != null)
          {
            localObject1 = Arrays.toString(arrayOfByte);
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "java.util.Arrays.toString(this)");
          }
          else
          {
            localObject1 = null;
          }
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(", techs: ");
          localStringBuilder.append(localObject2);
          o.d("MicroMsg.AppBrand.NFCReadWriteManager", localStringBuilder.toString());
          if ((((Collection)localObject2).isEmpty() ^ true))
          {
            localObject1 = localCollection;
            if (((List)localObject2).contains(b.h.a())) {
              localObject1 = b(paramIntent);
            }
            localFunction3.invoke(arrayOfByte, localObject2, localObject1);
          }
        }
      }
    }
  }
  
  public final void a(@NotNull NdefMessage paramNdefMessage, @NotNull Function1<? super e<Unit>, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramNdefMessage, "message");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("writeNdefMessage, message: ");
    localStringBuilder.append(paramNdefMessage);
    o.e("MicroMsg.AppBrand.NFCReadWriteManager", localStringBuilder.toString());
    f.a.a((Runnable)new c.o(this, paramFunction1, paramNdefMessage), "NFC-IO");
  }
  
  public final void a(@NotNull String paramString, int paramInt, @NotNull Function1<? super e<Unit>, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "techName");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setTimeout, techName: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", timeoutMs: ");
    localStringBuilder.append(paramInt);
    o.e("MicroMsg.AppBrand.NFCReadWriteManager", localStringBuilder.toString());
    f.a.a((Runnable)new c.j(this, paramFunction1, paramString, paramInt), "NFC-IO");
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2, @Nullable a parama, @NotNull Function1<? super e<Object>, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "techName");
    Intrinsics.checkParameterIsNotNull(paramString2, "function");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("execTechLogicAsync, techName: ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", function: ");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", params: ");
    localStringBuilder.append(parama);
    o.e("MicroMsg.AppBrand.NFCReadWriteManager", localStringBuilder.toString());
    f.a.a((Runnable)new c.f(this, paramFunction1, paramString1, paramString2, parama), "NFC-IO");
  }
  
  public final void a(@NotNull String paramString, @NotNull Function1<? super e<Unit>, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "techName");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("connect, techName: ");
    localStringBuilder.append(paramString);
    o.e("MicroMsg.AppBrand.NFCReadWriteManager", localStringBuilder.toString());
    f.a.a((Runnable)new c.e(this, paramFunction1, paramString), "NFC-IO");
  }
  
  public final void a(@NotNull String paramString, @NotNull byte[] paramArrayOfByte, @NotNull Function1<? super e<byte[]>, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "techName");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "reqData");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("transceive, techName: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", reqData: ");
    String str = Arrays.toString(paramArrayOfByte);
    Intrinsics.checkExpressionValueIsNotNull(str, "java.util.Arrays.toString(this)");
    localStringBuilder.append(str);
    o.e("MicroMsg.AppBrand.NFCReadWriteManager", localStringBuilder.toString());
    f.a.a((Runnable)new c.n(this, paramFunction1, paramString, paramArrayOfByte), "NFC-IO");
  }
  
  public final void a(@NotNull Function1<? super e<Unit>, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    o.e("MicroMsg.AppBrand.NFCReadWriteManager", "startNFCDiscovery");
    f.a.a((Runnable)new c.k(this, paramFunction1));
  }
  
  public final void a(@Nullable Function3<? super byte[], ? super List<String>, ? super List<NdefMessage>, Unit> paramFunction3)
  {
    this.c = paramFunction3;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  @NotNull
  protected final Activity b()
  {
    return this.o;
  }
  
  public final void b(@NotNull String paramString, @NotNull Function1<? super e<Unit>, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "techName");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("close, techName: ");
    localStringBuilder.append(paramString);
    o.e("MicroMsg.AppBrand.NFCReadWriteManager", localStringBuilder.toString());
    f.a.a((Runnable)new c.d(this, paramFunction1, paramString), "NFC-IO");
  }
  
  public final void b(@NotNull Function1<? super e<Unit>, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    o.e("MicroMsg.AppBrand.NFCReadWriteManager", "stopNFCDiscovery");
    f.a.a((Runnable)new c.l(this, paramFunction1));
  }
  
  @NotNull
  protected final com.tencent.luggage.wxa.jx.c c()
  {
    return this.p;
  }
  
  public final void c(@NotNull String paramString, @NotNull Function1<? super e<Boolean>, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "techName");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isConnected, techName: ");
    localStringBuilder.append(paramString);
    o.e("MicroMsg.AppBrand.NFCReadWriteManager", localStringBuilder.toString());
    f.a.a((Runnable)new c.h(this, paramFunction1, paramString), "NFC-IO");
  }
  
  public final void d(@NotNull String paramString, @NotNull Function1<? super e<Integer>, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "techName");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "callback");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getMaxTransceiveLength, techName: ");
    localStringBuilder.append(paramString);
    o.e("MicroMsg.AppBrand.NFCReadWriteManager", localStringBuilder.toString());
    f.a.a((Runnable)new c.g(this, paramFunction1, paramString), "NFC-IO");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lk.c
 * JD-Core Version:    0.7.0.1
 */