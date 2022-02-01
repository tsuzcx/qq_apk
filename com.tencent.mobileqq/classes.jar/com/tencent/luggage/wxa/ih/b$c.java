package com.tencent.luggage.wxa.ih;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData$ItemUiData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "chooseStatus", "", "getChooseStatus", "()I", "setChooseStatus", "(I)V", "templateId", "", "getTemplateId", "()Ljava/lang/String;", "setTemplateId", "(Ljava/lang/String;)V", "describeContents", "writeToParcel", "", "flags", "Companion", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 1, 16})
public final class b$c
  implements Parcelable
{
  @JvmField
  @NotNull
  public static final Parcelable.Creator<c> CREATOR = (Parcelable.Creator)new b.c.b();
  public static final b.c.a a = new b.c.a(null);
  private static final int d = 1;
  private static final int e = 0;
  @NotNull
  private String b = "";
  private int c;
  
  public b$c() {}
  
  public b$c(@NotNull Parcel paramParcel)
  {
    this();
    String str = paramParcel.readString();
    if (str == null) {
      str = "";
    }
    this.b = str;
    this.c = paramParcel.readInt();
  }
  
  @NotNull
  public final String a()
  {
    return this.b;
  }
  
  public final void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.b = paramString;
  }
  
  public final int b()
  {
    return this.c;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ih.b.c
 * JD-Core Version:    0.7.0.1
 */