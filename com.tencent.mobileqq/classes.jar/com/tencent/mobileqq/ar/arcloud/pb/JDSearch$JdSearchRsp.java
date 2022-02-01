package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class JDSearch$JdSearchRsp
  extends MessageMicro<JdSearchRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "jd_search_errorcode", "jd_search_errormsg", "jd_search_detail" }, new Object[] { Integer.valueOf(0), "", null }, JdSearchRsp.class);
  public JDSearch.JdSearchDetail jd_search_detail = new JDSearch.JdSearchDetail();
  public final PBInt32Field jd_search_errorcode = PBField.initInt32(0);
  public final PBStringField jd_search_errormsg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.JDSearch.JdSearchRsp
 * JD-Core Version:    0.7.0.1
 */