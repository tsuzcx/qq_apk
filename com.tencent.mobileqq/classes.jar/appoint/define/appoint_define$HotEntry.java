package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class appoint_define$HotEntry
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_open_flag", "uint32_rest_time", "str_foreword", "str_background_src" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "" }, HotEntry.class);
  public final PBStringField str_background_src = PBField.initString("");
  public final PBStringField str_foreword = PBField.initString("");
  public final PBUInt32Field uint32_open_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_rest_time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     appoint.define.appoint_define.HotEntry
 * JD-Core Version:    0.7.0.1
 */