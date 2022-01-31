package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class JDSearch$JdPicSearchRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "jd_pic_search_errorcode", "jd_pic_search_ocr_errormsg", "jd_pic_search_detail" }, new Object[] { Integer.valueOf(0), "", null }, JdPicSearchRsp.class);
  public JDSearch.JdPicSearchDetail jd_pic_search_detail = new JDSearch.JdPicSearchDetail();
  public final PBInt32Field jd_pic_search_errorcode = PBField.initInt32(0);
  public final PBStringField jd_pic_search_ocr_errormsg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.JDSearch.JdPicSearchRsp
 * JD-Core Version:    0.7.0.1
 */