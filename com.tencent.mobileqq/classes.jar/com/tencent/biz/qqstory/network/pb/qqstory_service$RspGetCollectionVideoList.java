package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$RspGetCollectionVideoList
  extends MessageMicro<RspGetCollectionVideoList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<qqstory_struct.StoryVideoFullInfo> full_video_info_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoFullInfo.class);
  public final PBUInt32Field interact_status = PBField.initUInt32(0);
  public final PBUInt32Field is_end = PBField.initUInt32(0);
  public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBRepeatMessageField<qqstory_struct.StoryVideoBasicInfo> video_info_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoBasicInfo.class);
  public final PBRepeatMessageField<qqstory_struct.StoryVideoDes> video_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoDes.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50, 56 }, new String[] { "result", "video_list", "is_end", "next_cookie", "video_info_list", "full_video_info_list", "interact_status" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro, null, null, Integer.valueOf(0) }, RspGetCollectionVideoList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetCollectionVideoList
 * JD-Core Version:    0.7.0.1
 */