package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.channel.BasePageResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspProfileStoryFeedIdList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedSeqInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedIdListSeqInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetProfileFeedIdListRequest$GetProfileFeedIdListResponse
  extends BasePageResponse
{
  public List<FeedIdListSeqInfo> e = new ArrayList();
  
  public GetProfileFeedIdListRequest$GetProfileFeedIdListResponse(qqstory_service.RspProfileStoryFeedIdList paramRspProfileStoryFeedIdList)
  {
    super(paramRspProfileStoryFeedIdList.result, paramRspProfileStoryFeedIdList.is_end, paramRspProfileStoryFeedIdList.next_cookie);
    paramRspProfileStoryFeedIdList = paramRspProfileStoryFeedIdList.feed_seq_info_list.get().iterator();
    while (paramRspProfileStoryFeedIdList.hasNext())
    {
      qqstory_struct.FeedSeqInfo localFeedSeqInfo = (qqstory_struct.FeedSeqInfo)paramRspProfileStoryFeedIdList.next();
      this.e.add(new FeedIdListSeqInfo(localFeedSeqInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetProfileFeedIdListRequest.GetProfileFeedIdListResponse
 * JD-Core Version:    0.7.0.1
 */