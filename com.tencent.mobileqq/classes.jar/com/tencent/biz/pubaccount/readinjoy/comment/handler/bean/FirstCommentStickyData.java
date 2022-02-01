package com.tencent.biz.pubaccount.readinjoy.comment.handler.bean;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import pgq;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/FirstCommentStickyData;", "Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/SimpleCommentData;", "rowkey", "", "contentSrc", "", "businessInfo", "commentID", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getCommentID", "()Ljava/lang/String;", "opType", "getOpType", "()I", "setOpType", "(I)V", "toString", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class FirstCommentStickyData
  extends SimpleCommentData
{
  public static final pgq a;
  private int jdField_a_of_type_Int;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_Pgq = new pgq(null);
  }
  
  public FirstCommentStickyData(@NotNull String paramString1, int paramInt, @NotNull String paramString2, @NotNull String paramString3)
  {
    super(paramInt, paramString2);
    this.jdField_a_of_type_JavaLangString = paramString3;
    b(paramString1);
    this.jdField_a_of_type_Int = 1;
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
    return "FirstCommentStickyData(commentID='" + this.jdField_a_of_type_JavaLangString + "', opType=" + this.jdField_a_of_type_Int + ") super=" + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentStickyData
 * JD-Core Version:    0.7.0.1
 */