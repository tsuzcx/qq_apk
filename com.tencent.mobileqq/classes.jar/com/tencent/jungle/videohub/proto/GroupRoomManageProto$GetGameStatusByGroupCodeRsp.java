package com.tencent.jungle.videohub.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GroupRoomManageProto$GetGameStatusByGroupCodeRsp
  extends MessageMicro<GetGameStatusByGroupCodeRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field app_type = PBField.initUInt32(0);
  public final PBUInt32Field game_id = PBField.initUInt32(0);
  public final PBUInt32Field is_group_member = PBField.initUInt32(0);
  public final PBUInt32Field room_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "room_id", "app_type", "game_id", "is_group_member" }, new Object[] { localInteger, localInteger, localInteger, localInteger }, GetGameStatusByGroupCodeRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.jungle.videohub.proto.GroupRoomManageProto.GetGameStatusByGroupCodeRsp
 * JD-Core Version:    0.7.0.1
 */