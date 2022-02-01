package com.tencent.biz.pubaccount.readinjoy.comment.handler.bean;

import android.os.Parcel;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData.CommentRptData;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/FirstCommentCreateData;", "Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/SimpleCommentData;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "contentSrc", "", "businessInfo", "", "(ILjava/lang/String;)V", "commentRptDataList", "", "Lcom/tencent/biz/pubaccount/readinjoy/comment/data/BaseCommentData$CommentRptData;", "getCommentRptDataList", "()Ljava/util/List;", "setCommentRptDataList", "(Ljava/util/List;)V", "commentStr", "getCommentStr", "()Ljava/lang/String;", "setCommentStr", "(Ljava/lang/String;)V", "wholeStringContent", "getWholeStringContent", "describeContents", "readFromParcel", "", "toString", "writeToParcel", "flags", "CREATOR", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class FirstCommentCreateData
  extends SimpleCommentData
{
  public static final FirstCommentCreateData.CREATOR CREATOR = new FirstCommentCreateData.CREATOR(null);
  @NotNull
  private String jdField_a_of_type_JavaLangString = "";
  @Nullable
  private List<BaseCommentData.CommentRptData> jdField_a_of_type_JavaUtilList;
  
  public FirstCommentCreateData(int paramInt, @NotNull String paramString)
  {
    super(paramInt, paramString);
  }
  
  public FirstCommentCreateData(@NotNull Parcel paramParcel) {}
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  @Nullable
  public final List<BaseCommentData.CommentRptData> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    super.a(paramParcel);
    paramParcel = paramParcel.readString();
    if (paramParcel != null) {}
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = paramParcel;
      return;
      paramParcel = "";
    }
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public final void a(@Nullable List<BaseCommentData.CommentRptData> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  @NotNull
  public final String b()
  {
    Object localObject1 = new StringBuilder(this.jdField_a_of_type_JavaLangString);
    Object localObject2 = this.jdField_a_of_type_JavaUtilList;
    if (localObject2 != null)
    {
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((StringBuilder)localObject1).append(((BaseCommentData.CommentRptData)((Iterator)localObject2).next()).jdField_a_of_type_JavaLangString);
      }
    }
    localObject1 = ((StringBuilder)localObject1).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "stringBuilder.toString()");
    return localObject1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @NotNull
  public String toString()
  {
    return "FirstCommentCreateData:" + super.toString() + "commentStr: " + this.jdField_a_of_type_JavaLangString;
  }
  
  public void writeToParcel(@NotNull Parcel paramParcel, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "parcel");
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentCreateData
 * JD-Core Version:    0.7.0.1
 */