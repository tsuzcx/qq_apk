package com.tencent.biz.pubaccount.readinjoy.comment.handler.bean;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/FirstCommentSinkData;", "Lcom/tencent/biz/pubaccount/readinjoy/comment/handler/bean/SimpleCommentData;", "commentID", "", "rowkey", "contentSrc", "", "businessInfo", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getCommentID", "()Ljava/lang/String;", "toString", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class FirstCommentSinkData
  extends SimpleCommentData
{
  @NotNull
  private final String a;
  
  public FirstCommentSinkData(@NotNull String paramString1, @NotNull String paramString2, int paramInt, @NotNull String paramString3)
  {
    super(paramInt, paramString3);
    this.a = paramString1;
    b(paramString2);
  }
  
  @NotNull
  public final String a()
  {
    return this.a;
  }
  
  @NotNull
  public String toString()
  {
    return "FirstCommentSinkData(commentID='" + this.a + "', super=" + super.toString() + ')';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.handler.bean.FirstCommentSinkData
 * JD-Core Version:    0.7.0.1
 */