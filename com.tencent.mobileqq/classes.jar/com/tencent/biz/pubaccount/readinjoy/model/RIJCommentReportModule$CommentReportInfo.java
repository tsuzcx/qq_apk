package com.tencent.biz.pubaccount.readinjoy.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/model/RIJCommentReportModule$CommentReportInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "firstCommentId", "", "getFirstCommentId", "()Ljava/lang/String;", "setFirstCommentId", "(Ljava/lang/String;)V", "reportReason", "getReportReason", "setReportReason", "reportType", "", "getReportType", "()I", "setReportType", "(I)V", "rowkey", "getRowkey", "setRowkey", "subCommentId", "getSubCommentId", "setSubCommentId", "describeContents", "toString", "writeToParcel", "", "flags", "CREATOR", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJCommentReportModule$CommentReportInfo
  implements Parcelable
{
  public static final RIJCommentReportModule.CommentReportInfo.CREATOR CREATOR = new RIJCommentReportModule.CommentReportInfo.CREATOR(null);
  private int jdField_a_of_type_Int;
  @Nullable
  private String jdField_a_of_type_JavaLangString = "";
  @Nullable
  private String b = "";
  @Nullable
  private String c = "";
  @Nullable
  private String d = "";
  
  public RIJCommentReportModule$CommentReportInfo() {}
  
  public RIJCommentReportModule$CommentReportInfo(@NotNull Parcel paramParcel)
  {
    this();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.d = paramParcel.readString();
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @Nullable
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void a(@Nullable String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  @Nullable
  public final String b()
  {
    return this.b;
  }
  
  public final void b(@Nullable String paramString)
  {
    this.b = paramString;
  }
  
  @Nullable
  public final String c()
  {
    return this.c;
  }
  
  public final void c(@Nullable String paramString)
  {
    this.c = paramString;
  }
  
  @Nullable
  public final String d()
  {
    return this.d;
  }
  
  public final void d(@Nullable String paramString)
  {
    this.d = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("CommentReportInfo[").append("rowkey:").append(this.jdField_a_of_type_JavaLangString).append("\n").append("firstCommentId:").append(this.b).append("\n").append("subCommentId:").append(this.c).append("\n").append("reportType:").append(this.jdField_a_of_type_Int).append("\n").append("reportReason:").append(this.d).append("]");
    localObject = ((StringBuilder)localObject).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "sb.toString()");
    return localObject;
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.RIJCommentReportModule.CommentReportInfo
 * JD-Core Version:    0.7.0.1
 */