package com.tencent.biz.pubaccount.readinjoy.comment.handler.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData.CommentLinkData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import oxn;
import pay;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/SimpleCommentData;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "contentSrc", "", "businessInfo", "", "(ILjava/lang/String;)V", "articleId", "getArticleId", "()Ljava/lang/String;", "setArticleId", "(Ljava/lang/String;)V", "authorId", "", "getAuthorId", "()J", "getBusinessInfo", "setBusinessInfo", "getContentSrc", "()I", "setContentSrc", "(I)V", "linkDataList", "", "Lcom/tencent/biz/pubaccount/readinjoy/comment/data/BaseCommentData$CommentLinkData;", "getLinkDataList", "()Ljava/util/List;", "setLinkDataList", "(Ljava/util/List;)V", "reportScene", "getReportScene", "setReportScene", "rowKey", "getRowKey", "setRowKey", "src", "getSrc", "describeContents", "readFromParcel", "", "toString", "writeToParcel", "flags", "CREATOR", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public class SimpleCommentData
  implements Parcelable
{
  public static final oxn CREATOR = new oxn(null);
  private int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  @NotNull
  private String jdField_a_of_type_JavaLangString;
  @Nullable
  private List<BaseCommentData.CommentLinkData> jdField_a_of_type_JavaUtilList;
  private final int jdField_b_of_type_Int;
  @NotNull
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  @NotNull
  private String jdField_c_of_type_JavaLangString;
  
  public SimpleCommentData(int paramInt, @NotNull String paramString)
  {
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_c_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Long = pay.a();
    this.jdField_b_of_type_Int = 20;
  }
  
  public SimpleCommentData(@NotNull Parcel paramParcel) {}
  
  public final long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  @Nullable
  public final List<BaseCommentData.CommentLinkData> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    String str = paramParcel.readString();
    if (str != null)
    {
      this.jdField_a_of_type_JavaLangString = str;
      str = paramParcel.readString();
      if (str == null) {
        break label49;
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_JavaLangString = str;
      this.jdField_a_of_type_Int = paramParcel.readInt();
      return;
      str = "";
      break;
      label49:
      str = "";
    }
  }
  
  public final void a(@Nullable List<BaseCommentData.CommentLinkData> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public final int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public final String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public final int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  @NotNull
  public final String c()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public final void c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public final int d()
  {
    return this.jdField_c_of_type_Int;
  }
  
  @NotNull
  public final String d()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @NotNull
  public String toString()
  {
    return "rowKey: " + this.jdField_a_of_type_JavaLangString + ", " + "articleId: " + this.jdField_b_of_type_JavaLangString + ", " + "authorId: " + this.jdField_a_of_type_Long + ", " + "contentSrc: " + this.jdField_c_of_type_Int + ", " + "businessInfo: " + this.jdField_c_of_type_JavaLangString;
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.SimpleCommentData
 * JD-Core Version:    0.7.0.1
 */