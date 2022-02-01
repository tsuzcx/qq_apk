package com.tencent.luggage.wxa.lc;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.ih.d;
import com.tencent.luggage.wxa.ii.a.a.a;
import com.tencent.luggage.wxa.ii.a.c;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.mm.msgsubscription.ui.a.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor;", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/ISubscribeMsgCGIExecutor;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "username", "", "tmplIds", "", "eventListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;", "appid", "appType", "", "(Ljava/lang/String;Ljava/util/List;Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;Ljava/lang/String;I)V", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;I)V", "dispatcher", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "getDispatcher", "()Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "setDispatcher", "(Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;)V", "getEventListener", "()Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;", "setEventListener", "(Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;)V", "subscribeMsgRequestDialog", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "getSubscribeMsgRequestDialog", "()Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "setSubscribeMsgRequestDialog", "(Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;)V", "getTmplIds", "()Ljava/util/List;", "dealWithCgiResult", "", "context", "Landroid/content/Context;", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "describeContents", "itemsToReportList", "", "", "subscribeMsgTmpItems", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "items", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "onNetSceneEndCallback", "errType", "errCode", "errMsg", "report", "templateItems", "alwaysKeepSelected", "", "userOpType", "indexStr", "clickCountStr", "requestCgi", "toReportMap", "isCheck", "Lkotlin/Function1;", "writeToParcel", "dest", "flags", "Companion", "EventListener", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class b
  implements c
{
  @JvmField
  @NotNull
  public static final Parcelable.Creator<b> CREATOR = (Parcelable.Creator)new b.b();
  public static final b.a b = new b.a(null);
  @NotNull
  public com.tencent.mm.msgsubscription.ui.a a;
  @NotNull
  private com.tencent.luggage.wxa.ik.a.a c;
  @Nullable
  private b.c d;
  private final String e;
  @NotNull
  private final List<String> f;
  private final String g;
  private final int h;
  
  public b(@NotNull Parcel paramParcel)
  {
    this(str1, (List)localObject1, (String)localObject2, paramParcel.readInt());
  }
  
  public b(@NotNull String paramString1, @NotNull List<String> paramList, @NotNull b.c paramc, @NotNull String paramString2, int paramInt)
  {
    this(paramString1, paramList, paramString2, paramInt);
    this.d = paramc;
  }
  
  private b(String paramString1, List<String> paramList, String paramString2, int paramInt)
  {
    this.e = paramString1;
    this.f = paramList;
    this.g = paramString2;
    this.h = paramInt;
    this.c = ((com.tencent.luggage.wxa.ik.a.a)a.a);
  }
  
  private final List<Map<String, String>> a(List<d> paramList, List<a.b> paramList1)
  {
    return a(paramList, (Function1)new b.e(paramList1));
  }
  
  private final List<Map<String, String>> a(List<d> paramList, Function1<? super d, Boolean> paramFunction1)
  {
    List localList = (List)new ArrayList();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      d locald = (d)paramList.next();
      Map localMap = (Map)new LinkedHashMap();
      localMap.put("templateType", String.valueOf(locald.d()));
      localMap.put("selected", String.valueOf(((Boolean)paramFunction1.invoke(locald)).booleanValue()));
      localMap.put("templateID", locald.c());
      localList.add(localMap);
    }
    return localList;
  }
  
  private final void a(List<Map<String, String>> paramList, boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  public com.tencent.luggage.wxa.ik.a.a a()
  {
    return this.c;
  }
  
  public void a(int paramInt1, int paramInt2, @NotNull String paramString, @Nullable com.tencent.luggage.wxa.ih.c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    b.c localc = this.d;
    if (localc != null) {
      localc.a(paramInt1, paramInt2, paramString, paramc);
    }
  }
  
  public void a(@NotNull Context paramContext, @NotNull com.tencent.luggage.wxa.ih.c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramc, "result");
    if (paramc.c().size() == 0)
    {
      paramContext = this.d;
      if (paramContext != null) {
        b.c.a.a(paramContext, this.e, (List)paramc.c(), null, 4, null);
      }
      return;
    }
    List localList = (List)new ArrayList();
    Iterator localIterator = paramc.c().iterator();
    boolean bool1;
    for (;;)
    {
      boolean bool2 = localIterator.hasNext();
      bool1 = false;
      if (!bool2) {
        break;
      }
      d locald = (d)localIterator.next();
      if (locald.e() == 1) {
        bool1 = true;
      }
      localList.add(new a.b(bool1, locald.b(), locald.f(), locald.c()));
    }
    if (paramc.h() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (bool1) {
      ((a.b)localList.get(0)).b(true);
    }
    int i = ((d)paramc.c().get(0)).d();
    t.a((Runnable)new b.d(this, paramc, paramContext, localList, (Map)new LinkedHashMap(), bool1, i));
  }
  
  public void a(@NotNull com.tencent.luggage.wxa.ik.a.a parama)
  {
    Intrinsics.checkParameterIsNotNull(parama, "<set-?>");
    this.c = parama;
  }
  
  public final void a(@Nullable b.c paramc)
  {
    this.d = paramc;
  }
  
  public final void a(@NotNull com.tencent.mm.msgsubscription.ui.a parama)
  {
    Intrinsics.checkParameterIsNotNull(parama, "<set-?>");
    this.a = parama;
  }
  
  @Nullable
  public final b.c b()
  {
    return this.d;
  }
  
  @NotNull
  public final com.tencent.mm.msgsubscription.ui.a c()
  {
    com.tencent.mm.msgsubscription.ui.a locala = this.a;
    if (locala == null) {
      Intrinsics.throwUninitializedPropertyAccessException("subscribeMsgRequestDialog");
    }
    return locala;
  }
  
  public void d()
  {
    com.tencent.luggage.wxa.ii.a.a.a.a(this.e, this.f, (a.c)this).a(a());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @NotNull
  public final List<String> e()
  {
    return this.f;
  }
  
  public void writeToParcel(@Nullable Parcel paramParcel, int paramInt)
  {
    if (paramParcel != null) {
      paramParcel.writeString(this.e);
    }
    if (paramParcel != null) {
      paramParcel.writeStringList(this.f);
    }
    if (paramParcel != null) {
      paramParcel.writeString(this.g);
    }
    if (paramParcel != null) {
      paramParcel.writeInt(this.h);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lc.b
 * JD-Core Version:    0.7.0.1
 */