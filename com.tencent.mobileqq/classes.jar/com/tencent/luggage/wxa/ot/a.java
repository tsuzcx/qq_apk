package com.tencent.luggage.wxa.ot;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/profile/IDKey;", "Landroid/os/Parcelable;", "id", "", "key", "value", "(III)V", "()V", "", "(JJJ)V", "getId", "()J", "setId", "(J)V", "getKey", "setKey", "getValue", "setValue", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "luggage-commons_release"}, k=1, mv={1, 1, 16})
@Parcelize
public final class a
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new a.a();
  private long a;
  private long b;
  private long c;
  
  public a()
  {
    this(0, 0, 0);
  }
  
  public a(int paramInt1, int paramInt2, int paramInt3)
  {
    this(l1, l2, l2);
  }
  
  public a(long paramLong1, long paramLong2, long paramLong3)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramLong3;
  }
  
  public final long a()
  {
    return this.a;
  }
  
  public final void a(long paramLong)
  {
    this.a = paramLong;
  }
  
  public final long b()
  {
    return this.b;
  }
  
  public final void b(long paramLong)
  {
    this.b = paramLong;
  }
  
  public final long c()
  {
    return this.c;
  }
  
  public final void c(long paramLong)
  {
    this.c = paramLong;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.a == paramObject.a) && (this.b == paramObject.b) && (this.c == paramObject.c)) {}
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
    long l = this.a;
    int i = (int)(l ^ l >>> 32);
    l = this.b;
    int j = (int)(l ^ l >>> 32);
    l = this.c;
    return (i * 31 + j) * 31 + (int)(l ^ l >>> 32);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IDKey(id=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", key=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", value=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeLong(this.a);
    paramParcel.writeLong(this.b);
    paramParcel.writeLong(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ot.a
 * JD-Core Version:    0.7.0.1
 */