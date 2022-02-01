package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ReqGroupVideo$ReqScreenShareAnswer
  extends MessageMicro<ReqScreenShareAnswer>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "from_uin", "to_uin", "is_accept" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false) }, ReqScreenShareAnswer.class);
  public final PBUInt64Field from_uin = PBField.initUInt64(0L);
  public final PBBoolField is_accept = PBField.initBool(false);
  public final PBUInt64Field to_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ReqGroupVideo.ReqScreenShareAnswer
 * JD-Core Version:    0.7.0.1
 */