package com.tencent.mobileqq.ac;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class ArticleComment$CheckArticleLikeRespond
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ret", "data" }, new Object[] { null, null }, CheckArticleLikeRespond.class);
  public final PBRepeatMessageField data = PBField.initRepeatMessage(ArticleComment.LikeRet.class);
  public ArticleComment.RetInfo ret = new ArticleComment.RetInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.ac.ArticleComment.CheckArticleLikeRespond
 * JD-Core Version:    0.7.0.1
 */