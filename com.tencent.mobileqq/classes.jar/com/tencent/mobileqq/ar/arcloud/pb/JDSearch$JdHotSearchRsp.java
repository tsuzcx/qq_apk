package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class JDSearch$JdHotSearchRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "jd_hot_search_errorcode", "jd_hot_search_ocr_errormsg", "jd_hot_search_detail" }, new Object[] { Integer.valueOf(0), "", null }, JdHotSearchRsp.class);
  public JDSearch.JdHotSearchDetail jd_hot_search_detail = new JDSearch.JdHotSearchDetail();
  public final PBInt32Field jd_hot_search_errorcode = PBField.initInt32(0);
  public final PBStringField jd_hot_search_ocr_errormsg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.JDSearch.JdHotSearchRsp
 * JD-Core Version:    0.7.0.1
 */