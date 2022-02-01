package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class WadlTrpcReport$DcReportReply
  extends MessageMicro<DcReportReply>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field code = PBField.initInt32(0);
  public final PBStringField msg = PBField.initString("");
  public final PBInt32Field succNum = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "code", "msg", "succNum" }, new Object[] { localInteger, "", localInteger }, DcReportReply.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.WadlTrpcReport.DcReportReply
 * JD-Core Version:    0.7.0.1
 */