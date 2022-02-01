package com.tencent.luggage.wxa.df;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.ilink.tdi.b.y;
import com.tencent.luggage.wxa.qu.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parceler;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/account/tdi/ipc/TdiRequest;", "Landroid/os/Parcelable;", "cmdId", "", "url", "", "networkType", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiNetType;", "req", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "respClassName", "(ILjava/lang/String;Lcom/tencent/ilink/tdi/TdiApiProto$TdiNetType;Lcom/tencent/mm/protobuf/BaseProtoBuf;Ljava/lang/String;)V", "getCmdId", "()I", "setCmdId", "(I)V", "getNetworkType", "()Lcom/tencent/ilink/tdi/TdiApiProto$TdiNetType;", "setNetworkType", "(Lcom/tencent/ilink/tdi/TdiApiProto$TdiNetType;)V", "getReq", "()Lcom/tencent/mm/protobuf/BaseProtoBuf;", "setReq", "(Lcom/tencent/mm/protobuf/BaseProtoBuf;)V", "getRespClassName", "()Ljava/lang/String;", "setRespClassName", "(Ljava/lang/String;)V", "getUrl", "setUrl", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
@Parcelize
public final class e
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new e.a();
  private int a;
  @NotNull
  private String b;
  @NotNull
  private b.y c;
  @Nullable
  private a d;
  @NotNull
  private String e;
  
  public e()
  {
    this(0, null, null, null, null, 31, null);
  }
  
  public e(int paramInt, @NotNull String paramString1, @NotNull b.y paramy, @Nullable a parama, @NotNull String paramString2)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.c = paramy;
    this.d = parama;
    this.e = paramString2;
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
  public final b.y c()
  {
    return this.c;
  }
  
  @Nullable
  public final a d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @NotNull
  public final String e()
  {
    return this.e;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof e))
      {
        paramObject = (e)paramObject;
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
    int n = this.a;
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
    localStringBuilder.append("TdiRequest(cmdId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", url=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", networkType=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", req=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", respClassName=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c.name());
    a locala = this.d;
    b.a.write(locala, paramParcel, paramInt);
    paramParcel.writeString(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.df.e
 * JD-Core Version:    0.7.0.1
 */