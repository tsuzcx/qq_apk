package com.tencent.biz.pubaccount.readinjoy.comment.handler.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import pgs;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/SubCommentCreateData;", "Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/SimpleCommentData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "contentSrc", "", "businessInfo", "", "(ILjava/lang/String;)V", "commentStr", "getCommentStr", "()Ljava/lang/String;", "setCommentStr", "(Ljava/lang/String;)V", "firstCommentId", "getFirstCommentId", "setFirstCommentId", "repliedSubAuthorId", "", "getRepliedSubAuthorId", "()J", "setRepliedSubAuthorId", "(J)V", "repliedSubCommentId", "getRepliedSubCommentId", "setRepliedSubCommentId", "describeContents", "toString", "writeToParcel", "", "flags", "CREATOR", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class SubCommentCreateData
  extends SimpleCommentData
  implements Parcelable
{
  public static final pgs CREATOR = new pgs(null);
  private long jdField_a_of_type_Long;
  @NotNull
  private String jdField_a_of_type_JavaLangString = "";
  @NotNull
  private String b = "";
  @NotNull
  private String c = "";
  
  public SubCommentCreateData(int paramInt, @NotNull String paramString)
  {
    super(paramInt, paramString);
  }
  
  public SubCommentCreateData(@NotNull Parcel paramParcel) {}
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public final long b()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public final void d(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.b = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @NotNull
  public final String e()
  {
    return this.b;
  }
  
  public final void e(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.c = paramString;
  }
  
  @NotNull
  public final String f()
  {
    return this.c;
  }
  
  @NotNull
  public String toString()
  {
    return "SubCommentCreateData:" + super.toString() + "commentStr: " + this.b + ", " + "firstCommentId: " + this.jdField_a_of_type_JavaLangString + ", " + "repliedSubAuthorId: " + this.jdField_a_of_type_Long + ", " + "repliedSubCommentId: " + this.c;
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SubCommentCreateData
 * JD-Core Version:    0.7.0.1
 */