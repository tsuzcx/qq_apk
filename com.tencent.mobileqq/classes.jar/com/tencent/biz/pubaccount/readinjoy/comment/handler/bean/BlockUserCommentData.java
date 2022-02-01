package com.tencent.biz.pubaccount.readinjoy.comment.handler.bean;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/BlockUserCommentData;", "", "firstCommentId", "", "subCommentId", "commentType", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getCommentType", "()I", "setCommentType", "(I)V", "getFirstCommentId", "()Ljava/lang/String;", "setFirstCommentId", "(Ljava/lang/String;)V", "getSubCommentId", "setSubCommentId", "toString", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class BlockUserCommentData
{
  public static final BlockUserCommentData.Companion a;
  private int jdField_a_of_type_Int;
  @NotNull
  private String jdField_a_of_type_JavaLangString;
  @Nullable
  private String b;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentHandlerBeanBlockUserCommentData$Companion = new BlockUserCommentData.Companion(null);
  }
  
  public BlockUserCommentData(@NotNull String paramString1, @Nullable String paramString2, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Int = paramInt;
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
  
  @Nullable
  public final String b()
  {
    return this.b;
  }
  
  @NotNull
  public String toString()
  {
    return "BlockUserCommentData(firstCommentId='" + this.jdField_a_of_type_JavaLangString + "', subCommentId='" + this.b + "', commentType=" + this.jdField_a_of_type_Int + ')';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.BlockUserCommentData
 * JD-Core Version:    0.7.0.1
 */