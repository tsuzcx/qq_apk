package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqConvertGroupId;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspConvertGroupId;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GroupId;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.Iterator;
import java.util.List;

public class GetUserGroupUnionIDHandler$GetUserGroupUnionIDRequest
  extends NetworkRequest<GetUserGroupUnionIDHandler.GetUserGroupUnionIDResponse>
{
  public static final String a;
  public List<String> a;
  public int c;
  
  static
  {
    jdField_a_of_type_JavaLangString = StoryApi.a("StoryGroupSvc.convert_group_id");
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspConvertGroupId localRspConvertGroupId = new qqstory_service.RspConvertGroupId();
    try
    {
      localRspConvertGroupId.mergeFrom(paramArrayOfByte);
      return new GetUserGroupUnionIDHandler.GetUserGroupUnionIDResponse(localRspConvertGroupId);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      SLog.b("Q.qqstory.net:BatchNetHandler", a(), paramArrayOfByte);
    }
    return null;
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  protected byte[] a()
  {
    qqstory_service.ReqConvertGroupId localReqConvertGroupId = new qqstory_service.ReqConvertGroupId();
    localReqConvertGroupId.convert_from.set(this.c);
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        qqstory_struct.GroupId localGroupId = new qqstory_struct.GroupId();
        localGroupId.group_uin.set(Long.valueOf(str).longValue());
        localReqConvertGroupId.group_req_list.add(localGroupId);
      }
    }
    return localReqConvertGroupId.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetUserGroupUnionIDHandler.GetUserGroupUnionIDRequest
 * JD-Core Version:    0.7.0.1
 */