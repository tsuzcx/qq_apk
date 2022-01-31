package com.tencent.mobileqq.ac;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ArticleComment$ReportReadPhotoCollectionRequest
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField article_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field cuin = PBField.initUInt64(0L);
  public final PBRepeatMessageField item = PBField.initRepeatMessage(ArticleComment.ReadPhotoItemInfo.class);
  public final PBRepeatField recommend_article_id = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBUInt32Field report_timing_type = PBField.initUInt32(0);
  public final PBUInt32Field total_remain_time = PBField.initUInt32(0);
  public final PBStringField versionInfo = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 50, 58 }, new String[] { "versionInfo", "cuin", "article_id", "report_timing_type", "total_remain_time", "item", "recommend_article_id" }, new Object[] { "", Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro2 }, ReportReadPhotoCollectionRequest.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.ac.ArticleComment.ReportReadPhotoCollectionRequest
 * JD-Core Version:    0.7.0.1
 */