package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class qqstory_struct$TagInfoBaseVidList
  extends MessageMicro<TagInfoBaseVidList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public qqstory_struct.CompInfoBase comp_info = new qqstory_struct.CompInfoBase();
  public final PBBytesField extern_config_json = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_struct.TagInfoBase tag_info = new qqstory_struct.TagInfoBase();
  public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "vid", "tag_info", "comp_info", "extern_config_json" }, new Object[] { localByteStringMicro1, null, null, localByteStringMicro2 }, TagInfoBaseVidList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.TagInfoBaseVidList
 * JD-Core Version:    0.7.0.1
 */