package com.tencent.biz.pubaccount.weishi_new.push;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/weishi_new/push/WSPushCommentModel$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/biz/pubaccount/weishi_new/push/WSPushCommentModel;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/biz/pubaccount/weishi_new/push/WSPushCommentModel;", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSPushCommentModel$Companion$CREATOR$1
  implements Parcelable.Creator<WSPushCommentModel>
{
  @NotNull
  public WSPushCommentModel a(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    return new WSPushCommentModel(paramParcel);
  }
  
  @NotNull
  public WSPushCommentModel[] a(int paramInt)
  {
    return new WSPushCommentModel[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.push.WSPushCommentModel.Companion.CREATOR.1
 * JD-Core Version:    0.7.0.1
 */