package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspProfileYearNodeList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.YearNodeInfo;
import com.tencent.biz.qqstory.storyHome.memory.model.MomeriesYearNode;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetProfileYearNodeListRequest$GetProfileYearNodeListResponse
  extends BaseResponse
{
  public List<MomeriesYearNode> a = new ArrayList();
  
  public GetProfileYearNodeListRequest$GetProfileYearNodeListResponse() {}
  
  public GetProfileYearNodeListRequest$GetProfileYearNodeListResponse(qqstory_service.RspProfileYearNodeList paramRspProfileYearNodeList)
  {
    super(paramRspProfileYearNodeList.result);
    paramRspProfileYearNodeList = paramRspProfileYearNodeList.year_node_list.get().iterator();
    while (paramRspProfileYearNodeList.hasNext())
    {
      qqstory_struct.YearNodeInfo localYearNodeInfo = (qqstory_struct.YearNodeInfo)paramRspProfileYearNodeList.next();
      MomeriesYearNode localMomeriesYearNode = new MomeriesYearNode();
      localMomeriesYearNode.convertFrom(localYearNodeInfo);
      this.a.add(localMomeriesYearNode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetProfileYearNodeListRequest.GetProfileYearNodeListResponse
 * JD-Core Version:    0.7.0.1
 */