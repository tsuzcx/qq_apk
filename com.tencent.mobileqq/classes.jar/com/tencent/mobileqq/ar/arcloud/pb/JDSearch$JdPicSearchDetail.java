package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class JDSearch$JdPicSearchDetail
  extends MessageMicro<JdPicSearchDetail>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50, 58 }, new String[] { "session_id", "errorcode", "errormsg", "promotion_url", "coupon_url", "rectangle", "jd_sku_item" }, new Object[] { "", Integer.valueOf(0), "", "", "", null, null }, JdPicSearchDetail.class);
  public final PBStringField coupon_url = PBField.initString("");
  public final PBInt32Field errorcode = PBField.initInt32(0);
  public final PBStringField errormsg = PBField.initString("");
  public final PBRepeatMessageField<JDSearch.JdSkuItem> jd_sku_item = PBField.initRepeatMessage(JDSearch.JdSkuItem.class);
  public final PBStringField promotion_url = PBField.initString("");
  public JDSearch.Rectangle rectangle = new JDSearch.Rectangle();
  public final PBStringField session_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.JDSearch.JdPicSearchDetail
 * JD-Core Version:    0.7.0.1
 */