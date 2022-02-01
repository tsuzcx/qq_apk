package com.tencent.common.danmaku.edit.bean;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/common/danmaku/edit/bean/EditObject$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/common/danmaku/edit/bean/EditObject;", "()V", "TYPE_AT", "", "getTYPE_AT", "()I", "TYPE_NORMAL", "getTYPE_NORMAL", "TYPE_TOPIC", "getTYPE_TOPIC", "TYPE_URL", "getTYPE_URL", "serialVersionUID", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "(I)[Lcom/tencent/common/danmaku/edit/bean/EditObject;", "qqdanmaku_release"}, k=1, mv={1, 1, 16})
public final class EditObject$CREATOR
  implements Parcelable.Creator<EditObject>
{
  public final int a()
  {
    return EditObject.access$getTYPE_TOPIC$cp();
  }
  
  @NotNull
  public EditObject a(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    return new EditObject(paramParcel);
  }
  
  @NotNull
  public EditObject[] a(int paramInt)
  {
    return new EditObject[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.edit.bean.EditObject.CREATOR
 * JD-Core Version:    0.7.0.1
 */