package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ARCloudRecogCustomPb$ARGameInfo
  extends MessageMicro<ARGameInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90, 98 }, new String[] { "uint32_ar_game_cmd", "msg_get_id_req", "msg_recog_id_req" }, new Object[] { Integer.valueOf(0), null, null }, ARGameInfo.class);
  public ARCloudRecogCustomPb.GetIdentityReq msg_get_id_req = new ARCloudRecogCustomPb.GetIdentityReq();
  public ARCloudRecogCustomPb.RecogIdentityReq msg_recog_id_req = new ARCloudRecogCustomPb.RecogIdentityReq();
  public final PBUInt32Field uint32_ar_game_cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ARGameInfo
 * JD-Core Version:    0.7.0.1
 */