package com.tencent.luggage.wxa.jj;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$CloseWhenClickEmptyAreaConfig;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "activityClassName", "", "closeAnimStyle", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;)V", "getActivityClassName", "()Ljava/lang/String;", "getCloseAnimStyle", "()Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig$ActivityAnimationStyle;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "Companion", "data-model_release"}, k=1, mv={1, 1, 16})
public final class p$c
  implements Parcelable
{
  @JvmField
  @NotNull
  public static final Parcelable.Creator<c> CREATOR = (Parcelable.Creator)new p.c.b();
  @JvmField
  @NotNull
  public static final c a = new c("", p.a.a);
  public static final p.c.a b = new p.c.a(null);
  @NotNull
  private final String c;
  @NotNull
  private final p.a d;
  
  public p$c(@NotNull Parcel paramParcel)
  {
    this(str, p.a.valueOf(paramParcel));
  }
  
  public p$c(@NotNull String paramString, @NotNull p.a parama)
  {
    this.c = paramString;
    this.d = parama;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((Intrinsics.areEqual(this.c, paramObject.c)) && (Intrinsics.areEqual(this.d, paramObject.d))) {}
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
    Object localObject = this.c;
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.d;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return i * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CloseWhenClickEmptyAreaConfig(activityClassName=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", closeAnimStyle=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d.name());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jj.p.c
 * JD-Core Version:    0.7.0.1
 */