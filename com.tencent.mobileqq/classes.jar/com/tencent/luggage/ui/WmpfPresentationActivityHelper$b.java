package com.tencent.luggage.ui;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/ui/WmpfPresentationActivityHelper$PresentationToken;", "Landroid/os/Parcelable;", "presentationRef", "", "originProcessName", "", "name", "(ILjava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getOriginProcessName", "getPresentationRef", "()I", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
@Parcelize
final class WmpfPresentationActivityHelper$b
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new WmpfPresentationActivityHelper.b.a();
  private final int a;
  @NotNull
  private final String b;
  @NotNull
  private final String c;
  
  public WmpfPresentationActivityHelper$b(int paramInt, @NotNull String paramString1, @NotNull String paramString2)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.c = paramString2;
  }
  
  public final int a()
  {
    return this.a;
  }
  
  @NotNull
  public final String b()
  {
    return this.b;
  }
  
  @NotNull
  public final String c()
  {
    return this.c;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((this.a == paramObject.a) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int k = this.a;
    String str = this.b;
    int j = 0;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    str = this.c;
    if (str != null) {
      j = str.hashCode();
    }
    return (k * 31 + i) * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PresentationToken(presentationRef=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", originProcessName=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", name=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WmpfPresentationActivityHelper.b
 * JD-Core Version:    0.7.0.1
 */