package com.tencent.luggage.wxa.df;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.qu.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parceler;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/account/tdi/ipc/TdiResponse;", "Landroid/os/Parcelable;", "errCode", "", "errMsg", "", "resp", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "(ILjava/lang/String;Lcom/tencent/mm/protobuf/BaseProtoBuf;)V", "getErrCode", "()I", "setErrCode", "(I)V", "getErrMsg", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "getResp", "()Lcom/tencent/mm/protobuf/BaseProtoBuf;", "setResp", "(Lcom/tencent/mm/protobuf/BaseProtoBuf;)V", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
@Parcelize
public final class f
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new f.a();
  private int a;
  @Nullable
  private String b;
  @Nullable
  private a c;
  
  public f()
  {
    this(0, null, null, 7, null);
  }
  
  public f(int paramInt, @Nullable String paramString, @Nullable a parama)
  {
    this.a = paramInt;
    this.b = paramString;
    this.c = parama;
  }
  
  public final int a()
  {
    return this.a;
  }
  
  public final void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public final void a(@Nullable a parama)
  {
    this.c = parama;
  }
  
  public final void a(@Nullable String paramString)
  {
    this.b = paramString;
  }
  
  @Nullable
  public final String b()
  {
    return this.b;
  }
  
  @Nullable
  public final a c()
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
      if ((paramObject instanceof f))
      {
        paramObject = (f)paramObject;
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
    Object localObject = this.b;
    int j = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.c;
    if (localObject != null) {
      j = localObject.hashCode();
    }
    return (k * 31 + i) * 31 + j;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TdiResponse(errCode=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", errMsg=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", resp=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    a locala = this.c;
    b.a.write(locala, paramParcel, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.df.f
 * JD-Core Version:    0.7.0.1
 */