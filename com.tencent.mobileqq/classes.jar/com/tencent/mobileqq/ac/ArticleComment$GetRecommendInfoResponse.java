package com.tencent.mobileqq.ac;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class ArticleComment$GetRecommendInfoResponse
  extends MessageMicro<GetRecommendInfoResponse>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ret", "item" }, new Object[] { null, null }, GetRecommendInfoResponse.class);
  public final PBRepeatMessageField<ArticleComment.RecommendItemInfo> item = PBField.initRepeatMessage(ArticleComment.RecommendItemInfo.class);
  public ArticleComment.RetInfo ret = new ArticleComment.RetInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ac.ArticleComment.GetRecommendInfoResponse
 * JD-Core Version:    0.7.0.1
 */