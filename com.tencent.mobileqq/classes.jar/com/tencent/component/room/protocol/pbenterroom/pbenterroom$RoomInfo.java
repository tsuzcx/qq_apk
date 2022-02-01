package com.tencent.component.room.protocol.pbenterroom;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class pbenterroom$RoomInfo
  extends MessageMicro<RoomInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField announcement = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField full_logo = PBField.initString("");
  public final PBUInt32Field gift_flag = PBField.initUInt32(0);
  public final PBUInt32Field goods_flag = PBField.initUInt32(0);
  public final PBUInt32Field logo = PBField.initUInt32(0);
  public final PBStringField name = PBField.initString("");
  public final PBStringField program_id = PBField.initString("");
  public final PBUInt32Field report_flag = PBField.initUInt32(0);
  public final PBRepeatMessageField<pbenterroom.RichTitleElement> room_labels = PBField.initRepeatMessage(pbenterroom.RichTitleElement.class);
  public final PBUInt32Field room_status = PBField.initUInt32(0);
  public final PBUInt32Field room_type = PBField.initUInt32(0);
  public final PBUInt32Field roomid = PBField.initUInt32(0);
  public final PBStringField share_desc = PBField.initString("");
  public final PBStringField share_title = PBField.initString("");
  public final PBBytesField share_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field short_no = PBField.initUInt32(0);
  public final PBUInt32Field subroomid = PBField.initUInt32(0);
  public final PBUInt32Field total_num = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 48, 56, 66, 74, 82, 90, 98, 104, 112, 120, 130, 136, 144 }, new String[] { "roomid", "logo", "name", "subroomid", "room_labels", "room_type", "room_status", "full_logo", "announcement", "share_url", "share_title", "share_desc", "short_no", "total_num", "goods_flag", "program_id", "gift_flag", "report_flag" }, new Object[] { localInteger, localInteger, "", localInteger, null, localInteger, localInteger, "", localByteStringMicro1, localByteStringMicro2, "", "", localInteger, localInteger, localInteger, "", localInteger, localInteger }, RoomInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.room.protocol.pbenterroom.pbenterroom.RoomInfo
 * JD-Core Version:    0.7.0.1
 */