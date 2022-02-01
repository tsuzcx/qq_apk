package com.tencent.ilivesdk.service.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SwitchAndEnterRoom$SwitchAndEnterRoomRsp
  extends MessageMicro<SwitchAndEnterRoomRsp>
{
  public static final int ENTER_RSP_FIELD_NUMBER = 3;
  public static final int RESULT_FIELD_NUMBER = 1;
  public static final int SWITCH_RSP_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField enter_rsp = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field result = PBField.initUInt32(0);
  public SwitchAndEnterRoom.GetRoomListRsp switch_rsp = new SwitchAndEnterRoom.GetRoomListRsp();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "result", "switch_rsp", "enter_rsp" }, new Object[] { Integer.valueOf(0), null, localByteStringMicro }, SwitchAndEnterRoomRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.service.pb.SwitchAndEnterRoom.SwitchAndEnterRoomRsp
 * JD-Core Version:    0.7.0.1
 */