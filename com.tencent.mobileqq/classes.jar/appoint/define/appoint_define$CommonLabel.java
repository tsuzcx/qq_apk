package appoint.define;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class appoint_define$CommonLabel
  extends MessageMicro<CommonLabel>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_lable_msg_last = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_lable_msg_pre = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<ByteStringMicro> rpt_interst_name = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatField<Integer> rpt_interst_type = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_lable_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40 }, new String[] { "uint32_lable_id", "bytes_lable_msg_pre", "bytes_lable_msg_last", "rpt_interst_name", "rpt_interst_type" }, new Object[] { localInteger, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localInteger }, CommonLabel.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     appoint.define.appoint_define.CommonLabel
 * JD-Core Version:    0.7.0.1
 */