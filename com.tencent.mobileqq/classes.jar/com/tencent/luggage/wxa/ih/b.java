package com.tencent.luggage.wxa.ih;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "isAlways", "", "()I", "setAlways", "(I)V", "opType", "getOpType", "setOpType", "uIItem", "Ljava/util/ArrayList;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData;", "Lkotlin/collections/ArrayList;", "getUIItem", "()Ljava/util/ArrayList;", "setUIItem", "(Ljava/util/ArrayList;)V", "describeContents", "writeToParcel", "", "flags", "Companion", "ItemUiData", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 1, 16})
public final class b
  implements Parcelable
{
  @JvmField
  @NotNull
  public static final Parcelable.Creator<b> CREATOR = (Parcelable.Creator)new b.b();
  public static final b.a a = new b.a(null);
  private static final int e = 0;
  private static final int f = 1;
  private static final int g = 2;
  private static final int h = 3;
  private static final int i = 1;
  private static final int j = 0;
  private int b = e;
  private int c;
  @NotNull
  private ArrayList<b.c> d = new ArrayList();
  
  public b() {}
  
  public b(@NotNull Parcel paramParcel)
  {
    this();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
    ArrayList localArrayList = new ArrayList();
    paramParcel.readList((List)localArrayList, b.c.class.getClassLoader());
    this.d = localArrayList;
  }
  
  public final int a()
  {
    return this.b;
  }
  
  public final void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final int b()
  {
    return this.c;
  }
  
  public final void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  @NotNull
  public final ArrayList<b.c> c()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeList((List)this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ih.b
 * JD-Core Version:    0.7.0.1
 */