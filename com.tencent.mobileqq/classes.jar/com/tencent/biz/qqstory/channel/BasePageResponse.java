package com.tencent.biz.qqstory.channel;

import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class BasePageResponse
  extends BaseResponse
{
  public String a;
  public boolean a;
  
  public BasePageResponse(qqstory_struct.ErrorInfo paramErrorInfo, PBUInt32Field paramPBUInt32Field, PBBytesField paramPBBytesField)
  {
    super(paramErrorInfo);
    int i = paramPBUInt32Field.get();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
    this.jdField_a_of_type_JavaLangString = paramPBBytesField.get().toStringUtf8();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.channel.BasePageResponse
 * JD-Core Version:    0.7.0.1
 */