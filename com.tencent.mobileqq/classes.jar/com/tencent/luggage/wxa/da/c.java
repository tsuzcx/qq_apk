package com.tencent.luggage.wxa.da;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.wxa.eb.a;
import com.tencent.luggage.wxa.em.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/launch/task/WxaCloseMessage;", "Lcom/tencent/luggage/sdk/processes/client/LuggageClientProcessMessage;", "Lcom/tencent/luggage/standalone_ext/Runtime;", "appId", "", "(Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "describeContents", "", "runInLuggageProcess", "", "runtime", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
@Parcelize
public final class c
  extends a<d>
{
  public static final Parcelable.Creator CREATOR = new c.a();
  @NotNull
  private final String a;
  
  public c(@NotNull String paramString)
  {
    super(paramString);
    this.a = paramString;
  }
  
  @NotNull
  public String a()
  {
    return this.a;
  }
  
  public void a(@NotNull d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "runtime");
    paramd.y();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeString(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.da.c
 * JD-Core Version:    0.7.0.1
 */