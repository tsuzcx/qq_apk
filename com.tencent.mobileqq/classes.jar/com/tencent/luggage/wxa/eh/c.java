package com.tencent.luggage.wxa.eh;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.luggage.wxa.ih.d;
import com.tencent.luggage.wxa.ih.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/setting/entity/SubscribeMsgSettingData;", "Landroid/os/Parcelable;", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "filter", "", "(Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;Z)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "exampleTitle", "", "getExampleTitle", "()Ljava/lang/String;", "setExampleTitle", "(Ljava/lang/String;)V", "items", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "originalData", "showEntry", "getShowEntry", "()Z", "setShowEntry", "(Z)V", "subscribeSwitch", "getSubscribeSwitch", "setSubscribeSwitch", "copyItem", "", "Ljava/util/ArrayList;", "describeContents", "", "getItemChanged", "isSubscribeMsgTmpItemChanged", "a", "b", "refresh", "", "writeToParcel", "flags", "CREATOR", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class c
  implements Parcelable
{
  public static final c.a CREATOR = new c.a(null);
  private boolean a;
  private boolean b;
  @NotNull
  private List<d> c;
  @NotNull
  private String d;
  private com.tencent.luggage.wxa.ih.c e;
  
  public c(@NotNull Parcel paramParcel)
  {
    int i = paramParcel.readByte();
    boolean bool2 = false;
    int j = (byte)0;
    if (i != j) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.a = bool1;
    boolean bool1 = bool2;
    if (paramParcel.readByte() != j) {
      bool1 = true;
    }
    this.b = bool1;
    Object localObject = paramParcel.createTypedArrayList(d.CREATOR);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "parcel.createTypedArrayL…scribeMsgTmpItem.CREATOR)");
    this.c = ((List)localObject);
    localObject = paramParcel.readString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "parcel.readString()");
    this.d = ((String)localObject);
    paramParcel = paramParcel.readParcelable(com.tencent.luggage.wxa.ih.c.class.getClassLoader());
    Intrinsics.checkExpressionValueIsNotNull(paramParcel, "parcel.readParcelable(Su…::class.java.classLoader)");
    this.e = ((com.tencent.luggage.wxa.ih.c)paramParcel);
  }
  
  public c(@NotNull com.tencent.luggage.wxa.ih.c paramc, boolean paramBoolean)
  {
    this.e = paramc;
    this.a = paramc.f();
    this.b = paramc.e();
    Object localObject = paramc.d();
    if (localObject != null)
    {
      localObject = ((e)localObject).e();
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    this.d = ((String)localObject);
    localObject = (List)new ArrayList();
    paramc = ((Iterable)paramc.c()).iterator();
    while (paramc.hasNext())
    {
      d locald = (d)paramc.next();
      Parcel localParcel = Parcel.obtain();
      locald.writeToParcel(localParcel, 0);
      localParcel.setDataPosition(0);
      Intrinsics.checkExpressionValueIsNotNull(localParcel, "parcel");
      ((List)localObject).add(new d(localParcel));
      localParcel.recycle();
    }
    this.c = ((List)localObject);
  }
  
  private final List<d> a(ArrayList<d> paramArrayList)
  {
    List localList = (List)new ArrayList();
    paramArrayList = ((Iterable)paramArrayList).iterator();
    while (paramArrayList.hasNext())
    {
      d locald = (d)paramArrayList.next();
      Parcel localParcel = Parcel.obtain();
      locald.writeToParcel(localParcel, 0);
      localParcel.setDataPosition(0);
      Intrinsics.checkExpressionValueIsNotNull(localParcel, "parcel");
      localList.add(new d(localParcel));
      localParcel.recycle();
    }
    return localList;
  }
  
  private final boolean a(d paramd1, d paramd2)
  {
    return paramd1.g() != paramd2.g();
  }
  
  public final void a(@NotNull com.tencent.luggage.wxa.ih.c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "result");
    this.a = paramc.f();
    this.b = paramc.e();
    Object localObject1 = paramc.d();
    if (localObject1 != null)
    {
      localObject1 = ((e)localObject1).e();
      if (localObject1 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    this.d = ((String)localObject1);
    localObject1 = a(paramc.c());
    Object localObject2 = (List)new ArrayList();
    ((List)localObject2).addAll((Collection)this.c);
    localObject1 = (Iterable)localObject1;
    int i = 0;
    Object localObject3 = ((Iterable)localObject1).iterator();
    d locald1;
    for (;;)
    {
      boolean bool = ((Iterator)localObject3).hasNext();
      locald1 = null;
      if (!bool) {
        break;
      }
      localObject1 = ((Iterator)localObject3).next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      d locald2 = (d)localObject1;
      Iterator localIterator = ((Iterable)localObject2).iterator();
      do
      {
        localObject1 = locald1;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = localIterator.next();
      } while (!TextUtils.equals((CharSequence)((d)localObject1).c(), (CharSequence)locald2.c()));
      localObject1 = (d)localObject1;
      if (localObject1 != null) {
        ((List)localObject2).set(((List)localObject2).indexOf(localObject1), locald2);
      }
      i += 1;
    }
    this.c = ((List)localObject2);
    localObject1 = ((Iterable)paramc.c()).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      locald1 = (d)((Iterator)localObject1).next();
      localObject2 = ((Iterable)this.e.c()).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        paramc = ((Iterator)localObject2).next();
        localObject3 = (d)paramc;
        if (TextUtils.equals((CharSequence)locald1.c(), (CharSequence)((d)localObject3).c())) {
          break label359;
        }
      }
      paramc = null;
      label359:
      paramc = (d)paramc;
      this.e.c().set(CollectionsKt.indexOf((List)this.e.c(), paramc), locald1);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public final boolean a()
  {
    return this.a;
  }
  
  public final boolean b()
  {
    return this.b;
  }
  
  @NotNull
  public final List<d> c()
  {
    return this.c;
  }
  
  @NotNull
  public final String d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @NotNull
  public final List<d> e()
  {
    List localList = (List)new ArrayList();
    Iterator localIterator1 = ((Iterable)this.c).iterator();
    while (localIterator1.hasNext())
    {
      d locald = (d)localIterator1.next();
      Iterator localIterator2 = ((Iterable)this.e.c()).iterator();
      while (localIterator2.hasNext())
      {
        localObject = localIterator2.next();
        if (TextUtils.equals((CharSequence)((d)localObject).c(), (CharSequence)locald.c())) {
          break label108;
        }
      }
      Object localObject = null;
      label108:
      localObject = (d)localObject;
      if ((localObject != null) && (a((d)localObject, locald))) {
        localList.add(locald);
      }
    }
    return localList;
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.eh.c
 * JD-Core Version:    0.7.0.1
 */