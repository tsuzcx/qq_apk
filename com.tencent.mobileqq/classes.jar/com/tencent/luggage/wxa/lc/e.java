package com.tencent.luggage.wxa.lc;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.ih.b;
import com.tencent.luggage.wxa.ih.d;
import com.tencent.luggage.wxa.ii.a.a.a;
import com.tencent.luggage.wxa.ii.a.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor;", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/ISubscribeMsgCGIExecutor;", "username", "", "eventListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor$EventListener;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor$EventListener;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "(Ljava/lang/String;)V", "buffers", "", "getBuffers", "()[B", "setBuffers", "([B)V", "dispatcher", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "getDispatcher", "()Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "setDispatcher", "(Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;)V", "getEventListener", "()Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor$EventListener;", "setEventListener", "(Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/SubscribeMsgExecutor$EventListener;)V", "value", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "subscribeMsgTmpItems", "getSubscribeMsgTmpItems", "()Ljava/util/List;", "setSubscribeMsgTmpItems", "(Ljava/util/List;)V", "uIData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "getUIData", "()Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "setUIData", "(Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;)V", "dealWithCgiResult", "", "context", "Landroid/content/Context;", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "describeContents", "", "onNetSceneEndCallback", "errType", "errCode", "errMsg", "requestCgi", "writeToParcel", "dest", "flags", "Companion", "EventListener", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class e
  implements c
{
  @JvmField
  @NotNull
  public static final Parcelable.Creator<e> CREATOR = (Parcelable.Creator)new e.b();
  public static final e.a a = new e.a(null);
  @Nullable
  private b b;
  @Nullable
  private e.c c;
  @Nullable
  private byte[] d;
  @NotNull
  private List<d> e;
  @NotNull
  private com.tencent.luggage.wxa.ik.a.a f;
  private final String g;
  
  public e(@NotNull Parcel paramParcel)
  {
    this((String)localObject);
    List localList = this.e;
    localObject = paramParcel.createTypedArrayList(d.CREATOR);
    if (localObject == null) {
      localObject = CollectionsKt.emptyList();
    }
    localList.addAll((Collection)localObject);
    this.d = new byte[paramParcel.readInt()];
    paramParcel.readByteArray(this.d);
    this.b = ((b)paramParcel.readParcelable(b.class.getClassLoader()));
  }
  
  private e(String paramString)
  {
    this.g = paramString;
    this.e = ((List)new ArrayList());
    this.f = ((com.tencent.luggage.wxa.ik.a.a)a.a);
  }
  
  public e(@NotNull String paramString, @NotNull e.c paramc)
  {
    this(paramString);
    this.c = paramc;
  }
  
  @NotNull
  public com.tencent.luggage.wxa.ik.a.a a()
  {
    return this.f;
  }
  
  public void a(int paramInt1, int paramInt2, @NotNull String paramString, @Nullable com.tencent.luggage.wxa.ih.c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    e.c localc = this.c;
    if (localc != null) {
      localc.a(paramInt1, paramInt2, paramString, paramc);
    }
  }
  
  public void a(@NotNull Context paramContext, @NotNull com.tencent.luggage.wxa.ih.c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramc, "result");
    paramContext = this.c;
    if (paramContext != null) {
      paramContext.a(paramc);
    }
  }
  
  public final void a(@Nullable b paramb)
  {
    this.b = paramb;
  }
  
  public void a(@NotNull com.tencent.luggage.wxa.ik.a.a parama)
  {
    Intrinsics.checkParameterIsNotNull(parama, "<set-?>");
    this.f = parama;
  }
  
  public final void a(@Nullable e.c paramc)
  {
    this.c = paramc;
  }
  
  public final void a(@NotNull List<d> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "value");
    this.e.clear();
    this.e.addAll((Collection)paramList);
  }
  
  public final void a(@Nullable byte[] paramArrayOfByte)
  {
    this.d = paramArrayOfByte;
  }
  
  public void b()
  {
    int i;
    if (this.b != null) {
      i = 1;
    } else {
      i = 0;
    }
    if ((_Assertions.ENABLED) && (i == 0)) {
      throw ((Throwable)new AssertionError("Assertion failed"));
    }
    a.a.a locala = com.tencent.luggage.wxa.ii.a.a.a;
    String str = this.g;
    List localList = this.e;
    a.c localc = (a.c)this;
    byte[] arrayOfByte = this.d;
    if (arrayOfByte == null) {
      arrayOfByte = new byte[0];
    }
    a.a.a.a(locala, str, localList, localc, false, arrayOfByte, this.b, 8, null).a(a());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(@Nullable Parcel paramParcel, int paramInt)
  {
    if (paramParcel != null) {
      paramParcel.writeString(this.g);
    }
    if (paramParcel != null) {
      paramParcel.writeTypedList(this.e);
    }
    byte[] arrayOfByte;
    if (paramParcel != null)
    {
      arrayOfByte = this.d;
      int i;
      if (arrayOfByte != null) {
        i = arrayOfByte.length;
      } else {
        i = 0;
      }
      paramParcel.writeInt(i);
    }
    if (paramParcel != null)
    {
      arrayOfByte = this.d;
      if (arrayOfByte == null) {
        arrayOfByte = new byte[0];
      }
      paramParcel.writeByteArray(arrayOfByte);
    }
    if (paramParcel != null) {
      paramParcel.writeParcelable((Parcelable)this.b, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lc.e
 * JD-Core Version:    0.7.0.1
 */