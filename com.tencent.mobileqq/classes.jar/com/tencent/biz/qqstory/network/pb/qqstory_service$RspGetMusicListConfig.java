package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqstory_service$RspGetMusicListConfig
  extends MessageMicro<RspGetMusicListConfig>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "music_config" }, new Object[] { null, null }, RspGetMusicListConfig.class);
  public final PBRepeatMessageField<qqstory_struct.MusicConfigInfo> music_config = PBField.initRepeatMessage(qqstory_struct.MusicConfigInfo.class);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetMusicListConfig
 * JD-Core Version:    0.7.0.1
 */