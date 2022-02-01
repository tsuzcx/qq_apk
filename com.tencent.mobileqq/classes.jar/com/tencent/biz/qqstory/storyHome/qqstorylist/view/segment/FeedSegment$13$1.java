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
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null)) {
      try
      {
        paramBundle = new qqstory_service.RspMultiRcmdDisLike();
        paramBundle.mergeFrom(paramArrayOfByte);
        paramInt = ((qqstory_struct.ErrorInfo)paramBundle.result.get()).error_code.get();
        if (paramInt == 0)
        {
          QLog.d("Q.qqstory.home:FeedSegment", 1, "RspMultiRcmdDisLike, dislike success");
          paramArrayOfByte = (HotRecommendHomeFeed)this.a.e.b.a(this.a.d.feedId);
          if (paramArrayOfByte != null) {
            paramArrayOfByte.a(this.a.c);
          }
          if ((paramArrayOfByte != null) && (paramArrayOfByte.a().isEmpty()))
          {
            this.a.e.b.i().remove(paramArrayOfByte);
            paramArrayOfByte = this.a.d.feedId;
            Bosses.get().postJob(new FeedSegment.13.1.1(this, "Q.qqstory.home:FeedSegment", paramArrayOfByte));
            FeedSegment.p(this.a.e);
            return;
          }
          FeedSegment.a(this.a.e, this.a.d.feedId);
          return;
        }
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("RspMultiRcmdDisLike, errorcode:");
        paramArrayOfByte.append(paramInt);
        QLog.d("Q.qqstory.home:FeedSegment", 1, paramArrayOfByte.toString());
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        paramBundle = new StringBuilder();
        paramBundle.append("RspMultiRcmdDisLike, error protobuf content");
        paramBundle.append(paramArrayOfByte.getStackTrace());
        QLog.d("Q.qqstory.home:FeedSegment", 1, paramBundle.toString());
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("ReqMultiRcmdDisLike,onResult error=");
      paramBundle.append(paramInt);
      paramBundle.append(" data=");
      paramBundle.append(paramArrayOfByte);
      QLog.i("Q.qqstory.home:FeedSegment", 2, paramBundle.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment.13.1
 * JD-Core Version:    0.7.0.1
 */