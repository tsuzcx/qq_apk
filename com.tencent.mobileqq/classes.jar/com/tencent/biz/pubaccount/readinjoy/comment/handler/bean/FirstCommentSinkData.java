package com.tencent.biz.pubaccount.readinjoy.comment.handler.bean;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/FirstCommentSinkData;", "Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/SimpleCommentData;", "commentID", "", "rowkey", "contentSrc", "", "businessInfo", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getCommentID", "()Ljava/lang/String;", "opType", "getOpType", "()I", "setOpType", "(I)V", "toString", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class FirstCommentSinkData
  extends SimpleCommentData
{
  public static final FirstCommentSinkData.Companion a;
  private int jdField_a_of_type_Int;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanFirstCommentSinkData$Companion = new FirstCommentSinkData.Companion(null);
  }
  
  public FirstCommentSinkData(@NotNull String paramString1, @NotNull String paramString2, int paramInt, @NotNull String paramString3)
  {
    super(paramInt, paramString3);
    this.jdField_a_of_type_JavaLangString = paramString1;
    b(paramString2);
    this.jdField_a_of_type_Int = 3;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  @NotNull
  public String toString()
  {
    return "FirstCommentSinkData(commentID='" + this.jdField_a_of_type_JavaLangString + "', opType=" + this.jdField_a_of_type_Int + ") super=" + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentSinkData
 * JD-Core Version:    0.7.0.1
 */