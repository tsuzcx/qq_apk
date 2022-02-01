package com.tencent.biz.qqstory.network.request.square;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqDiscoveryShareGroupInfoList;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspDiscoveryShareGroupInfoList;
import com.tencent.biz.qqstory.storyHome.model.FeedIdListSeqInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BatchGetSquareFeedInfoRequest
  extends NetworkRequest
{
  public static final String e = StoryApi.a("StorySvc.square_720_share_group_vid_list");
  public List<FeedIdListSeqInfo> f;
  
  public String a()
  {
    return e;
  }
  
  public BaseResponse b(byte[] paramArrayOfByte)
  {
    qqstory_service.RspDiscoveryShareGroupInfoList localRspDiscoveryShareGroupInfoList = new qqstory_service.RspDiscoveryShareGroupInfoList();
    try
    {
      localRspDiscoveryShareGroupInfoList.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      SLog.b("Q.qqstory.net:BatchGetFriendStoryFeedInfoRequest", "decode fail", paramArrayOfByte);
    }
    return new BatchGetSquareFeedInfoRequest.GetSquareFeedInfoResp(localRspDiscoveryShareGroupInfoList);
  }
  
  protected byte[] c()
  {
    Object localObject = new qqstory_service.ReqDiscoveryShareGroupInfoList();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      FeedIdListSeqInfo localFeedIdListSeqInfo = (FeedIdListSeqInfo)localIterator.next();
      if (localFeedIdListSeqInfo != null) {
        localArrayList.add(ByteStringMicro.copyFromUtf8(localFeedIdListSeqInfo.a));
      }
    }
    if (localArrayList.size() != 0)
    {
      ((qqstory_service.ReqDiscoveryShareGroupInfoList)localObject).share_group_unionid_list.set(localArrayList);
      return ((qqstory_service.ReqDiscoveryShareGroupInfoList)localObject).toByteArray();
    }
    localObject = new QQStoryCmdHandler.IllegalUinException("feed id seq is null");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.square.BatchGetSquareFeedInfoRequest
 * JD-Core Version:    0.7.0.1
 */