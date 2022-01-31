package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspConvertGroupId;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GroupId;
import com.tencent.biz.qqstory.shareGroup.model.GroupID;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetUserGroupUnionIDHandler$GetUserGroupUnionIDResponse
  extends BaseResponse
{
  public List a = new ArrayList();
  
  public GetUserGroupUnionIDHandler$GetUserGroupUnionIDResponse(qqstory_service.RspConvertGroupId paramRspConvertGroupId)
  {
    super(paramRspConvertGroupId.result);
    if (paramRspConvertGroupId.group_rsp_list.has())
    {
      paramRspConvertGroupId = paramRspConvertGroupId.group_rsp_list.get().iterator();
      while (paramRspConvertGroupId.hasNext())
      {
        Object localObject = (qqstory_struct.GroupId)paramRspConvertGroupId.next();
        localObject = new GroupID(String.valueOf(((qqstory_struct.GroupId)localObject).group_uin.get()), ((qqstory_struct.GroupId)localObject).group_union_id.get().toStringUtf8());
        this.a.add(localObject);
      }
    }
  }
  
  public String toString()
  {
    return "GetUserGroupUnionIDResponse{groupIDList=" + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetUserGroupUnionIDHandler.GetUserGroupUnionIDResponse
 * JD-Core Version:    0.7.0.1
 */