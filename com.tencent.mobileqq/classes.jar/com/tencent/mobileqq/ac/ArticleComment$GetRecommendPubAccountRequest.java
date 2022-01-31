package com.tencent.mobileqq.ac;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ArticleComment$GetRecommendPubAccountRequest
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "version", "cuin", "count" }, new Object[] { "", Long.valueOf(0L), Integer.valueOf(0) }, GetRecommendPubAccountRequest.class);
  public final PBUInt32Field count = PBField.initUInt32(0);
  public final PBUInt64Field cuin = PBField.initUInt64(0L);
  public final PBStringField version = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.ac.ArticleComment.GetRecommendPubAccountRequest
 * JD-Core Version:    0.7.0.1
 */