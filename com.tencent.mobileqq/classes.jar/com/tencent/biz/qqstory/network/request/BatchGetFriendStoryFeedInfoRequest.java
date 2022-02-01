package com.tencent.biz.qqstory.network.request;

import android.text.TextUtils;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler.IllegalUinException;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqStoryFeed;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspStoryFeed;
import com.tencent.biz.qqstory.storyHome.model.FeedIdListSeqInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BatchGetFriendStoryFeedInfoRequest
  extends NetworkRequest
{
  public static final String a;
  public List<FeedIdListSeqInfo> a;
  public List<String> b = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangString = StoryApi.a("StorySvc.homepage_batch_feeds_detail_720");
  }
  
  public BatchGetFriendStoryFeedInfoRequest()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_service.RspStoryFeed localRspStoryFeed = new qqstory_service.RspStoryFeed();
    try
    {
      localRspStoryFeed.mergeFrom(paramArrayOfByte);
      return new BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp(localRspStoryFeed);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public byte[] a()
  {
    qqstory_service.ReqStoryFeed localReqStoryFeed = new qqstory_service.ReqStoryFeed();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FeedIdListSeqInfo localFeedIdListSeqInfo = (FeedIdListSeqInfo)localIterator.next();
      if (localFeedIdListSeqInfo != null) {
        if (TextUtils.isEmpty(localFeedIdListSeqInfo.jdField_a_of_type_JavaLangString)) {
          SLog.e("Q.qqstory.net:BatchGetFriendStoryFeedInfoRequest", "check your param feedId is null");
        } else {
          localArrayList.add(localFeedIdListSeqInfo.a());
        }
      }
    }
    if (localArrayList.size() == 0) {
      throw new QQStoryCmdHandler.IllegalUinException("feed id seq is null");
    }
    localReqStoryFeed.feed_id_list.set(localArrayList);
    return localReqStoryFeed.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.BatchGetFriendStoryFeedInfoRequest
 * JD-Core Version:    0.7.0.1
 */