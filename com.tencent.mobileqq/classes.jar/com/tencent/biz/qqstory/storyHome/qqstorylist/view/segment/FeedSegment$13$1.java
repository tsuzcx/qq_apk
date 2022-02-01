package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspMultiRcmdDisLike;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ErrorInfo;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter;
import com.tencent.biz.qqstory.storyHome.model.HotRecommendFeedItem;
import com.tencent.biz.qqstory.storyHome.model.HotRecommendHomeFeed;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.util.List;

class FeedSegment$13$1
  extends ProtoUtils.TroopProtocolObserver
{
  FeedSegment$13$1(FeedSegment.13 param13) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqstory.home:FeedSegment", 2, "ReqMultiRcmdDisLike,onResult error=" + paramInt + " data=" + paramArrayOfByte);
      }
      return;
    }
    try
    {
      paramBundle = new qqstory_service.RspMultiRcmdDisLike();
      paramBundle.mergeFrom(paramArrayOfByte);
      paramInt = ((qqstory_struct.ErrorInfo)paramBundle.result.get()).error_code.get();
      if (paramInt != 0) {
        break label263;
      }
      QLog.d("Q.qqstory.home:FeedSegment", 1, "RspMultiRcmdDisLike, dislike success");
      paramArrayOfByte = (HotRecommendHomeFeed)this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment.a.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHotRecommendFeedItem.feedId);
      if (paramArrayOfByte != null) {
        paramArrayOfByte.a(this.a.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem);
      }
      if ((paramArrayOfByte != null) && (paramArrayOfByte.a().isEmpty()))
      {
        this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment.a.a().remove(paramArrayOfByte);
        paramArrayOfByte = this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHotRecommendFeedItem.feedId;
        Bosses.get().postJob(new FeedSegment.13.1.1(this, "Q.qqstory.home:FeedSegment", paramArrayOfByte));
        FeedSegment.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      QLog.d("Q.qqstory.home:FeedSegment", 1, "RspMultiRcmdDisLike, error protobuf content" + paramArrayOfByte.getStackTrace());
      return;
    }
    FeedSegment.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewSegmentFeedSegment, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHotRecommendFeedItem.feedId);
    return;
    label263:
    QLog.d("Q.qqstory.home:FeedSegment", 1, "RspMultiRcmdDisLike, errorcode:" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.13.1
 * JD-Core Version:    0.7.0.1
 */