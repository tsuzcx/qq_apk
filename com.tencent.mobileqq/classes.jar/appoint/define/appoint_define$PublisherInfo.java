package appoint.define;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class appoint_define$PublisherInfo
  extends MessageMicro<PublisherInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_nickname = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_stranger_declare = PBField.initBytes(ByteStringMicro.EMPTY);
  public appoint_define.CommonLabel msg_common_label = new appoint_define.CommonLabel();
  public final PBStringField str_constellation = PBField.initString("");
  public final PBStringField str_distance = PBField.initString("");
  public final PBStringField str_vipinfo = PBField.initString("");
  public final PBUInt32Field uint32_age = PBField.initUInt32(0);
  public final PBUInt32Field uint32_charm = PBField.initUInt32(0);
  public final PBUInt32Field uint32_charm_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_chatflag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_chatup_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_godflag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_history_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_marriage = PBField.initUInt32(0);
  public final PBUInt32Field uint32_profession = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pub_number = PBField.initUInt32(0);
  public final PBUInt32Field uint32_recent_vistor_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_recommend = PBField.initUInt32(0);
  public final PBUInt64Field uint64_followflag = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_friend_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 48, 58, 64, 74, 80, 88, 96, 104, 112, 120, 128, 138, 144, 154, 160, 168, 176 }, new String[] { "uint64_tinyid", "bytes_nickname", "uint32_age", "uint32_gender", "str_constellation", "uint32_profession", "str_distance", "uint32_marriage", "str_vipinfo", "uint32_recommend", "uint32_godflag", "uint32_chatflag", "uint32_chatup_count", "uint32_charm", "uint32_charm_level", "uint32_pub_number", "msg_common_label", "uint32_recent_vistor_time", "bytes_stranger_declare", "uint64_friend_uin", "uint32_history_flag", "uint64_followflag" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), localByteStringMicro2, Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, PublisherInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     appoint.define.appoint_define.PublisherInfo
 * JD-Core Version:    0.7.0.1
 */