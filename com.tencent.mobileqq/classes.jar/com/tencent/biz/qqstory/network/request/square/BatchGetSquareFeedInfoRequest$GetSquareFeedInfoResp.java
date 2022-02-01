package com.tencent.biz.qqstory.network.request.square;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspDiscoveryShareGroupInfoList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.DiscoveryShareGroupInfo;
import com.tencent.biz.qqstory.storyHome.square.model.SquareFeed;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BatchGetSquareFeedInfoRequest$GetSquareFeedInfoResp
  extends BaseResponse
{
  public List<SquareFeed> a = new ArrayList();
  
  public BatchGetSquareFeedInfoRequest$GetSquareFeedInfoResp(qqstory_service.RspDiscoveryShareGroupInfoList paramRspDiscoveryShareGroupInfoList)
  {
    super(paramRspDiscoveryShareGroupInfoList.result);
    paramRspDiscoveryShareGroupInfoList = paramRspDiscoveryShareGroupInfoList.share_group_info_list.get().iterator();
    while (paramRspDiscoveryShareGroupInfoList.hasNext())
    {
      qqstory_struct.DiscoveryShareGroupInfo localDiscoveryShareGroupInfo = (qqstory_struct.DiscoveryShareGroupInfo)paramRspDiscoveryShareGroupInfoList.next();
      this.a.add(new SquareFeed(localDiscoveryShareGroupInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.square.BatchGetSquareFeedInfoRequest.GetSquareFeedInfoResp
 * JD-Core Version:    0.7.0.1
 */