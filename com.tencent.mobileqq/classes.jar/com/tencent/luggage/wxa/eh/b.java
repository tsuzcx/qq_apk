package com.tencent.luggage.wxa.eh;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.qw.jc;
import com.tencent.luggage.wxa.qw.jd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/setting/entity/MMUserAvatarInfo;", "Landroid/os/Parcelable;", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "avatar_info", "Lcom/tencent/mm/protocal/protobuf/UserAvatarInfo;", "(Lcom/tencent/mm/protocal/protobuf/UserAvatarInfo;)V", "avatar_limit", "", "getAvatar_limit", "()I", "setAvatar_limit", "(I)V", "avatar_list", "Ljava/util/ArrayList;", "Lcom/tencent/luggage/setting/entity/MMUserAvatarInfo$MMUserAvatarItem;", "getAvatar_list", "()Ljava/util/ArrayList;", "setAvatar_list", "(Ljava/util/ArrayList;)V", "avatar_wording", "", "getAvatar_wording", "()Ljava/lang/String;", "setAvatar_wording", "(Ljava/lang/String;)V", "default_avatar_id", "getDefault_avatar_id", "setDefault_avatar_id", "default_headimg_fileid", "getDefault_headimg_fileid", "setDefault_headimg_fileid", "default_headimg_url", "getDefault_headimg_url", "setDefault_headimg_url", "is_ban_modify_avatar", "", "()Z", "set_ban_modify_avatar", "(Z)V", "limit_wording", "getLimit_wording", "setLimit_wording", "describeContents", "writeToParcel", "", "dest", "flags", "CREATOR", "MMUserAvatarItem", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class b
  implements Parcelable
{
  public static final b.a CREATOR = new b.a(null);
  @NotNull
  private ArrayList<b.b> a = new ArrayList();
  private boolean b;
  private int c;
  private int d;
  @Nullable
  private String e;
  @Nullable
  private String f;
  @Nullable
  private String g;
  @Nullable
  private String h;
  
  protected b(@NotNull Parcel paramParcel)
  {
    ArrayList localArrayList = paramParcel.readArrayList(b.b.class.getClassLoader());
    if (localArrayList == null) {
      localArrayList = new ArrayList();
    }
    this.a = localArrayList;
    boolean bool;
    if (paramParcel.readByte() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.b = bool;
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.e = paramParcel.readString();
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = paramParcel.readString();
  }
  
  public b(@NotNull jc paramjc)
  {
    Iterator localIterator = paramjc.a.iterator();
    while (localIterator.hasNext())
    {
      jd localjd = (jd)localIterator.next();
      ArrayList localArrayList = this.a;
      if (localArrayList == null) {
        Intrinsics.throwNpe();
      }
      Intrinsics.checkExpressionValueIsNotNull(localjd, "item");
      localArrayList.add(new b.b(localjd));
    }
    this.b = paramjc.b;
    this.c = paramjc.c;
    this.d = paramjc.d;
    this.e = paramjc.e;
    this.f = paramjc.f;
    this.g = paramjc.g;
    this.h = paramjc.h;
  }
  
  @NotNull
  public final ArrayList<b.b> a()
  {
    return this.a;
  }
  
  public final boolean b()
  {
    return this.b;
  }
  
  public final int c()
  {
    return this.c;
  }
  
  public final int d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @Nullable
  public final String e()
  {
    return this.g;
  }
  
  @Nullable
  public final String f()
  {
    return this.h;
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "dest");
    paramParcel.writeList((List)this.a);
    paramParcel.writeByte((byte)this.b);
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeString(this.e);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeString(this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.eh.b
 * JD-Core Version:    0.7.0.1
 */