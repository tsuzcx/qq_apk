package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class JDSearch$JdSearchDetail
  extends MessageMicro<JdSearchDetail>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50 }, new String[] { "session_id", "errorcode", "errormsg", "jd_sku_item", "jd_more_url", "rectangle" }, new Object[] { "", Integer.valueOf(0), "", null, "", null }, JdSearchDetail.class);
  public final PBInt32Field errorcode = PBField.initInt32(0);
  public final PBStringField errormsg = PBField.initString("");
  public final PBStringField jd_more_url = PBField.initString("");
  public final PBRepeatMessageField<JDSearch.JdSkuItem> jd_sku_item = PBField.initRepeatMessage(JDSearch.JdSkuItem.class);
  public JDSearch.Rectangle rectangle = new JDSearch.Rectangle();
  public final PBStringField session_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.JDSearch.JdSearchDetail
 * JD-Core Version:    0.7.0.1
 */