package com.tencent.biz.qqstory.network.request.square;

import com.tencent.biz.qqstory.channel.BasePageResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspDiscoveryShareGroupList;
import com.tencent.biz.qqstory.storyHome.model.FeedIdListSeqInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetSquareFeedIdListRequest$GetSquareFeedIdListResponse
  extends BasePageResponse
{
  public List a = new ArrayList();
  
  public GetSquareFeedIdListRequest$GetSquareFeedIdListResponse(qqstory_service.RspDiscoveryShareGroupList paramRspDiscoveryShareGroupList)
  {
    super(paramRspDiscoveryShareGroupList.result, paramRspDiscoveryShareGroupList.is_end, paramRspDiscoveryShareGroupList.next_cookie);
    paramRspDiscoveryShareGroupList = paramRspDiscoveryShareGroupList.share_group_unionid_list.get().iterator();
    while (paramRspDiscoveryShareGroupList.hasNext())
    {
      FeedIdListSeqInfo localFeedIdListSeqInfo = new FeedIdListSeqInfo(((ByteStringMicro)paramRspDiscoveryShareGroupList.next()).toStringUtf8(), 0, "", "");
      this.a.add(localFeedIdListSeqInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.square.GetSquareFeedIdListRequest.GetSquareFeedIdListResponse
 * JD-Core Version:    0.7.0.1
 */