package com.tencent.luggage.wxa.ft;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.cx.t.c;
import com.tencent.luggage.wxa.cx.t.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/launch/WxaAppLaunchTraceEventDispatcher$TraceEvent;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "timestampNs", "", "instanceId", "", "eventGroup", "Lcom/tencent/luggage/launch/WxaLaunchTracer$TraceEventGroup;", "event", "Lcom/tencent/luggage/launch/WxaLaunchTracer$TraceEvent;", "message", "(JLjava/lang/String;Lcom/tencent/luggage/launch/WxaLaunchTracer$TraceEventGroup;Lcom/tencent/luggage/launch/WxaLaunchTracer$TraceEvent;Ljava/lang/String;)V", "getEvent", "()Lcom/tencent/luggage/launch/WxaLaunchTracer$TraceEvent;", "getEventGroup", "()Lcom/tencent/luggage/launch/WxaLaunchTracer$TraceEventGroup;", "getInstanceId", "()Ljava/lang/String;", "getMessage", "getTimestampNs", "()J", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "flags", "CREATOR", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class b$a
  implements Parcelable
{
  public static final b.a.a CREATOR = new b.a.a(null);
  private final long a;
  @NotNull
  private final String b;
  @NotNull
  private final t.d c;
  @NotNull
  private final t.c d;
  @Nullable
  private final String e;
  
  public b$a(long paramLong, @NotNull String paramString1, @NotNull t.d paramd, @NotNull t.c paramc, @Nullable String paramString2)
  {
    this.a = paramLong;
    this.b = paramString1;
    this.c = paramd;
    this.d = paramc;
    this.e = paramString2;
  }
  
  public b$a(@NotNull Parcel paramParcel) {}
  
  public final long a()
  {
    return this.a;
  }
  
  @NotNull
  public final t.d b()
  {
    return this.c;
  }
  
  @NotNull
  public final t.c c()
  {
    return this.d;
  }
  
  @Nullable
  public final String d()
  {
    return this.e;
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
        if ((this.a == paramObject.a) && (Intrinsics.areEqual(this.b, paramObject.b)) && (Intrinsics.areEqual(this.c, paramObject.c)) && (Intrinsics.areEqual(this.d, paramObject.d)) && (Intrinsics.areEqual(this.e, paramObject.e))) {}
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
    int n = (int)(l ^ l >>> 32);
    Object localObject = this.b;
    int m = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.c;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.d;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.e;
    if (localObject != null) {
      m = localObject.hashCode();
    }
    return (((n * 31 + i) * 31 + j) * 31 + k) * 31 + m;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TraceEvent(timestampNs=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", instanceId=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", eventGroup=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", event=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", message=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "dest");
    paramParcel.writeLong(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.c.ordinal());
    paramParcel.writeInt(this.d.ordinal());
    paramParcel.writeString(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ft.b.a
 * JD-Core Version:    0.7.0.1
 */