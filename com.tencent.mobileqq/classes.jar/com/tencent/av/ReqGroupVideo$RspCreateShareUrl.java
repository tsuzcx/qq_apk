package com.tencent.av;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class ReqGroupVideo$RspCreateShareUrl
  extends MessageMicro<RspCreateShareUrl>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public common.ErrorInfo result = new common.ErrorInfo();
  public final PBBytesField share_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField share_url_with_no_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "result", "share_url", "share_url_with_no_sig" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2 }, RspCreateShareUrl.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ReqGroupVideo.RspCreateShareUrl
 * JD-Core Version:    0.7.0.1
 */