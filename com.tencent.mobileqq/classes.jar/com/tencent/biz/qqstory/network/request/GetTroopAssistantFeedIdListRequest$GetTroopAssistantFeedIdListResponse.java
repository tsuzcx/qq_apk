package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.channel.BasePageResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_group.RspGroupStoryFeedIdList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedSeqInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedIdListSeqInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetTroopAssistantFeedIdListRequest$GetTroopAssistantFeedIdListResponse
  extends BasePageResponse
{
  public List<FeedIdListSeqInfo> e = new ArrayList();
  
  public GetTroopAssistantFeedIdListRequest$GetTroopAssistantFeedIdListResponse(qqstory_group.RspGroupStoryFeedIdList paramRspGroupStoryFeedIdList)
  {
    super(paramRspGroupStoryFeedIdList.result, paramRspGroupStoryFeedIdList.is_end, paramRspGroupStoryFeedIdList.next_cookie);
    paramRspGroupStoryFeedIdList = paramRspGroupStoryFeedIdList.feed_seq_info_list.get().iterator();
    while (paramRspGroupStoryFeedIdList.hasNext())
    {
      qqstory_struct.FeedSeqInfo localFeedSeqInfo = (qqstory_struct.FeedSeqInfo)paramRspGroupStoryFeedIdList.next();
      this.e.add(new FeedIdListSeqInfo(localFeedSeqInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetTroopAssistantFeedIdListRequest.GetTroopAssistantFeedIdListResponse
 * JD-Core Version:    0.7.0.1
 */