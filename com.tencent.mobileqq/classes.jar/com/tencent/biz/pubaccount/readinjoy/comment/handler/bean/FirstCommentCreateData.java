package com.tencent.biz.pubaccount.readinjoy.comment.handler.bean;

import android.os.Parcel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import owl;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/FirstCommentCreateData;", "Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/SimpleCommentData;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "contentSrc", "", "businessInfo", "", "(ILjava/lang/String;)V", "commentStr", "getCommentStr", "()Ljava/lang/String;", "setCommentStr", "(Ljava/lang/String;)V", "describeContents", "readFromParcel", "", "toString", "writeToParcel", "flags", "CREATOR", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class FirstCommentCreateData
  extends SimpleCommentData
{
  public static final owl CREATOR = new owl(null);
  @NotNull
  private String a = "";
  
  public FirstCommentCreateData(int paramInt, @NotNull String paramString)
  {
    super(paramInt, paramString);
  }
  
  public FirstCommentCreateData(@NotNull Parcel paramParcel) {}
  
  @NotNull
  public final String a()
  {
    return this.a;
  }
  
  public void a(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    super.a(paramParcel);
    paramParcel = paramParcel.readString();
    if (paramParcel != null) {}
    for (;;)
    {
      this.a = paramParcel;
      return;
      paramParcel = "";
    }
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.a = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @NotNull
  public String toString()
  {
    return "FirstCommentCreateData:" + super.toString() + "commentStr: " + this.a;
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentCreateData
 * JD-Core Version:    0.7.0.1
 */