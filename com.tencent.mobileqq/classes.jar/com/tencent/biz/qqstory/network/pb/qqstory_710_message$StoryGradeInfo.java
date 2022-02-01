package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_710_message$StoryGradeInfo
  extends MessageMicro<StoryGradeInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field at_video_ts = PBField.initUInt32(0);
  public final PBUInt32Field grade_option = PBField.initUInt32(0);
  public final PBBytesField grade_question = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field grade_time = PBField.initUInt32(0);
  public final PBUInt32Field grade_type = PBField.initUInt32(0);
  public final PBUInt64Field grade_uid = PBField.initUInt64(0L);
  public final PBUInt32Field is_bigv = PBField.initUInt32(0);
  public final PBUInt32Field is_my_grade = PBField.initUInt32(0);
  public final PBBytesField nick_postfix = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field video_del = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50, 56, 64, 72, 82, 88 }, new String[] { "grade_uid", "grade_time", "is_bigv", "union_id", "grade_type", "grade_question", "grade_option", "video_del", "is_my_grade", "nick_postfix", "at_video_ts" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, localByteStringMicro1, localInteger, localByteStringMicro2, localInteger, localInteger, localInteger, localByteStringMicro3, localInteger }, StoryGradeInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryGradeInfo
 * JD-Core Version:    0.7.0.1
 */