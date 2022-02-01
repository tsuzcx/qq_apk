package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetJoinedShareGroupFriList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class GetJoinedShareGroupFriListResponse
  extends BaseResponse
{
  public ArrayList<String> a;
  
  public GetJoinedShareGroupFriListResponse(qqstory_service.RspGetJoinedShareGroupFriList paramRspGetJoinedShareGroupFriList)
  {
    super(paramRspGetJoinedShareGroupFriList.result);
    this.jdField_a_of_type_JavaUtilArrayList = null;
    if (paramRspGetJoinedShareGroupFriList.uin_list.has())
    {
      int j = paramRspGetJoinedShareGroupFriList.uin_list.size();
      if (QLog.isDevelopLevel()) {
        QLog.i("zivonchen", 2, "GetJoinedShareGroupFriListResponse size = " + j);
      }
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        String str = ((ByteStringMicro)paramRspGetJoinedShareGroupFriList.uin_list.get(i)).toStringUtf8();
        this.jdField_a_of_type_JavaUtilArrayList.add(str);
        if (QLog.isDevelopLevel()) {
          QLog.i("zivonchen", 2, "GetJoinedShareGroupFriListResponse " + i + ": " + str);
        }
        i += 1;
      }
    }
  }
  
  public String toString()
  {
    return "GetJoinedShareGroupFriListResponse{errorCode=" + this.jdField_a_of_type_Int + ", errorMsg='" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetJoinedShareGroupFriListResponse
 * JD-Core Version:    0.7.0.1
 */