package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.channel.BasePageResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspStoryFeedIdList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedSeqInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedIdListSeqInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetStoryFeedIdListRequest$GetStoryFeedIdListResponse
  extends BasePageResponse
{
  public List<FeedIdListSeqInfo> e = new ArrayList();
  public boolean f;
  
  public GetStoryFeedIdListRequest$GetStoryFeedIdListResponse(qqstory_service.RspStoryFeedIdList paramRspStoryFeedIdList)
  {
    super(paramRspStoryFeedIdList.result, paramRspStoryFeedIdList.is_end, paramRspStoryFeedIdList.next_cookie);
    int i = paramRspStoryFeedIdList.is_today_end.get();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    this.f = bool;
    paramRspStoryFeedIdList = paramRspStoryFeedIdList.feed_seq_info_list.get().iterator();
    while (paramRspStoryFeedIdList.hasNext())
    {
      FeedIdListSeqInfo localFeedIdListSeqInfo = new FeedIdListSeqInfo((qqstory_struct.FeedSeqInfo)paramRspStoryFeedIdList.next());
      this.e.add(localFeedIdListSeqInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetStoryFeedIdListRequest.GetStoryFeedIdListResponse
 * JD-Core Version:    0.7.0.1
 */