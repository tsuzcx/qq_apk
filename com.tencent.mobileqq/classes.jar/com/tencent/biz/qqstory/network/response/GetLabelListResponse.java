package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetLabelList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetLabelListResponse
  extends BaseResponse
{
  public String a;
  public List a;
  public boolean a;
  
  public GetLabelListResponse(qqstory_service.RspGetLabelList paramRspGetLabelList)
  {
    super(paramRspGetLabelList.result);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramRspGetLabelList.next_cookie.get().toStringUtf8();
    if (paramRspGetLabelList.is_end.get() == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      paramRspGetLabelList = paramRspGetLabelList.label_list.get();
      if (paramRspGetLabelList == null) {
        break;
      }
      paramRspGetLabelList = paramRspGetLabelList.iterator();
      while (paramRspGetLabelList.hasNext())
      {
        ByteStringMicro localByteStringMicro = (ByteStringMicro)paramRspGetLabelList.next();
        this.jdField_a_of_type_JavaUtilList.add(localByteStringMicro.toStringUtf8());
      }
      bool = false;
    }
  }
  
  public String toString()
  {
    return "GetLabelListResponse{isEnd=" + this.jdField_a_of_type_Boolean + ", labelList=" + this.jdField_a_of_type_JavaUtilList.size() + ", nextCookie='" + this.jdField_a_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetLabelListResponse
 * JD-Core Version:    0.7.0.1
 */