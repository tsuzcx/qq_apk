package com.tencent.luggage.wxa.eh;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.qw.jd;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/setting/entity/MMUserAvatarInfo$MMUserAvatarItem;", "Landroid/os/Parcelable;", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "item", "Lcom/tencent/mm/protocal/protobuf/UserAvatarItem;", "(Lcom/tencent/mm/protocal/protobuf/UserAvatarItem;)V", "avatarurl", "", "getAvatarurl", "()Ljava/lang/String;", "setAvatarurl", "(Ljava/lang/String;)V", "desc", "getDesc", "setDesc", "id", "", "getId", "()I", "setId", "(I)V", "nickname", "getNickname", "setNickname", "describeContents", "writeToParcel", "", "dest", "flags", "CREATOR", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class b$b
  implements Parcelable
{
  public static final b.b.a CREATOR = new b.b.a(null);
  private int a;
  @NotNull
  private String b = "";
  @NotNull
  private String c = "";
  @Nullable
  private String d;
  
  protected b$b(@NotNull Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    String str = paramParcel.readString();
    Intrinsics.checkExpressionValueIsNotNull(str, "`in`.readString()");
    this.b = str;
    str = paramParcel.readString();
    Intrinsics.checkExpressionValueIsNotNull(str, "`in`.readString()");
    this.c = str;
    this.d = paramParcel.readString();
  }
  
  public b$b(@NotNull jd paramjd)
  {
    this.a = paramjd.a;
    String str = paramjd.b;
    Intrinsics.checkExpressionValueIsNotNull(str, "item.nickname");
    this.b = str;
    str = paramjd.c;
    Intrinsics.checkExpressionValueIsNotNull(str, "item.avatarurl");
    this.c = str;
    this.d = paramjd.d;
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
  
  @Nullable
  public final String d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "dest");
    paramParcel.writeInt(this.a);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.eh.b.b
 * JD-Core Version:    0.7.0.1
 */