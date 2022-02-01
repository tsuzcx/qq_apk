package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ARCloudRecogCustomPb$ARGameResult
  extends MessageMicro<ARGameResult>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field errorcode = PBField.initInt32(0);
  public final PBStringField errormsg = PBField.initString("");
  public ARCloudRecogCustomPb.GetIdentityRsp msg_get_id_rsp = new ARCloudRecogCustomPb.GetIdentityRsp();
  public ARCloudRecogCustomPb.RecogIdentityRsp msg_recog_id_rsp = new ARCloudRecogCustomPb.RecogIdentityRsp();
  public final PBUInt32Field uint32_ar_game_cmd = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 90, 98 }, new String[] { "uint32_ar_game_cmd", "errorcode", "errormsg", "msg_get_id_rsp", "msg_recog_id_rsp" }, new Object[] { localInteger, localInteger, "", null, null }, ARGameResult.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ARGameResult
 * JD-Core Version:    0.7.0.1
 */