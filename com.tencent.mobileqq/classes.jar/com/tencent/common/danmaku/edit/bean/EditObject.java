package com.tencent.common.danmaku.edit.bean;

import android.os.Parcel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/common/danmaku/edit/bean/EditObject;", "Ljava/io/Serializable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "wording", "", "type", "", "(Ljava/lang/String;I)V", "atType", "getAtType", "()I", "setAtType", "(I)V", "avatarUrl", "getAvatarUrl", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", "href", "getHref", "setHref", "id", "getId", "key", "getKey", "setKey", "getType", "setType", "getWording", "setWording", "toString", "CREATOR", "qqdanmaku_release"}, k=1, mv={1, 1, 16})
public final class EditObject
  implements Serializable
{
  public static final EditObject.CREATOR CREATOR = new EditObject.CREATOR(null);
  private static final int a = 1;
  private static final int b = 2;
  private static final int c = 3;
  private static final int d = 4;
  private static final long serialVersionUID = 0L;
  private int atType;
  @NotNull
  private String avatarUrl;
  @NotNull
  private String href;
  @NotNull
  private String key;
  private int type;
  @NotNull
  private String wording;
  
  public EditObject(@NotNull Parcel paramParcel)
  {
    this(str, a);
    str = paramParcel.readString();
    if (str == null) {
      str = "";
    }
    this.key = str;
    str = paramParcel.readString();
    if (str == null) {
      str = "";
    }
    this.href = str;
    paramParcel = paramParcel.readString();
    if (paramParcel == null) {
      paramParcel = "";
    }
    this.avatarUrl = paramParcel;
  }
  
  public EditObject(@NotNull String paramString, int paramInt)
  {
    this.wording = paramString;
    this.type = paramInt;
    this.key = "";
    this.href = "";
    this.avatarUrl = "";
    this.atType = 1;
  }
  
  public final int getAtType()
  {
    return this.atType;
  }
  
  @NotNull
  public final String getAvatarUrl()
  {
    return this.avatarUrl;
  }
  
  @NotNull
  public final String getHref()
  {
    return this.href;
  }
  
  @NotNull
  public final String getId()
  {
    if (this.type == d) {
      return this.href;
    }
    return this.key;
  }
  
  @NotNull
  public final String getKey()
  {
    return this.key;
  }
  
  public final int getType()
  {
    return this.type;
  }
  
  @NotNull
  public final String getWording()
  {
    return this.wording;
  }
  
  public final void setAtType(int paramInt)
  {
    this.atType = paramInt;
  }
  
  public final void setAvatarUrl(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.avatarUrl = paramString;
  }
  
  public final void setHref(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.href = paramString;
  }
  
  public final void setKey(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.key = paramString;
  }
  
  public final void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public final void setWording(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.wording = paramString;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EditObject: [");
    localStringBuilder.append("id = ");
    localStringBuilder.append(getId());
    localStringBuilder.append(", ");
    localStringBuilder.append("wording = ");
    localStringBuilder.append(this.wording);
    localStringBuilder.append(", ");
    localStringBuilder.append("type = ");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", ");
    localStringBuilder.append("key = ");
    localStringBuilder.append(this.key);
    localStringBuilder.append(", ");
    localStringBuilder.append("href = ");
    localStringBuilder.append(this.href);
    localStringBuilder.append(", ");
    localStringBuilder.append("avatarUrl = ");
    localStringBuilder.append(this.avatarUrl);
    localStringBuilder.append("]\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.edit.bean.EditObject
 * JD-Core Version:    0.7.0.1
 */