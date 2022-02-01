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
      Object localObject;
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("GetJoinedShareGroupFriListResponse size = ");
        ((StringBuilder)localObject).append(j);
        QLog.i("zivonchen", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        localObject = ((ByteStringMicro)paramRspGetJoinedShareGroupFriList.uin_list.get(i)).toStringUtf8();
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
        if (QLog.isDevelopLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("GetJoinedShareGroupFriListResponse ");
          localStringBuilder.append(i);
          localStringBuilder.append(": ");
          localStringBuilder.append((String)localObject);
          QLog.i("zivonchen", 2, localStringBuilder.toString());
        }
        i += 1;
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetJoinedShareGroupFriListResponse{errorCode=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", errorMsg='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetJoinedShareGroupFriListResponse
 * JD-Core Version:    0.7.0.1
 */