package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class ARCloudRecogCustomPb$ImgRetrievalResult
  extends MessageMicro<ImgRetrievalResult>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "errorcode", "errormsg", "msg_ir_logic_rsp", "jd_search_rsp" }, new Object[] { Integer.valueOf(0), "", null, null }, ImgRetrievalResult.class);
  public final PBInt32Field errorcode = PBField.initInt32(0);
  public final PBStringField errormsg = PBField.initString("");
  public JDSearch.JdSearchRsp jd_search_rsp = new JDSearch.JdSearchRsp();
  public ImageRetrievalLogic.IRLogicRsp msg_ir_logic_rsp = new ImageRetrievalLogic.IRLogicRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ImgRetrievalResult
 * JD-Core Version:    0.7.0.1
 */