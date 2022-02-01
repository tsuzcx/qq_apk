package appoint.define;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class appoint_define$StrangerInfo
  extends MessageMicro<StrangerInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_nickname = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_constellation = PBField.initString("");
  public final PBStringField str_vipinfo = PBField.initString("");
  public final PBUInt32Field uint32_age = PBField.initUInt32(0);
  public final PBUInt32Field uint32_charm = PBField.initUInt32(0);
  public final PBUInt32Field uint32_charm_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_dating = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_godflag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_list_idx = PBField.initUInt32(0);
  public final PBUInt32Field uint32_marriage = PBField.initUInt32(0);
  public final PBUInt32Field uint32_profession = PBField.initUInt32(0);
  public final PBUInt32Field uint32_recommend = PBField.initUInt32(0);
  public final PBUInt64Field uint64_tinyid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 58, 64, 72, 82, 88, 96, 104, 112, 120 }, new String[] { "uint64_tinyid", "bytes_nickname", "uint32_age", "uint32_gender", "uint32_dating", "uint32_list_idx", "str_constellation", "uint32_profession", "uint32_marriage", "str_vipinfo", "uint32_recommend", "uint32_godflag", "uint32_charm", "uint32_charm_level", "uint64_uin" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, StrangerInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     appoint.define.appoint_define.StrangerInfo
 * JD-Core Version:    0.7.0.1
 */