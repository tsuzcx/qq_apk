package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.network.handler.SendVidRateDataHandler.SendVidRateDataResultEvent;
import com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailCommentHelper;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.List;

public class HomeFeedPresenter$SendVidRateDataResultReceiver
  extends QQUIEventReceiver<HomeFeedPresenter, SendVidRateDataHandler.SendVidRateDataResultEvent>
{
  public HomeFeedPresenter$SendVidRateDataResultReceiver(HomeFeedPresenter paramHomeFeedPresenter1, @NonNull HomeFeedPresenter paramHomeFeedPresenter2)
  {
    super(paramHomeFeedPresenter2);
  }
  
  public void a(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull SendVidRateDataHandler.SendVidRateDataResultEvent paramSendVidRateDataResultEvent)
  {
    if ((!TextUtils.isEmpty(paramSendVidRateDataResultEvent.a)) && (!TextUtils.isEmpty(paramSendVidRateDataResultEvent.b)) && (paramSendVidRateDataResultEvent.f != 0) && (paramSendVidRateDataResultEvent.h != 0L) && (paramSendVidRateDataResultEvent.c >= 1))
    {
      Object localObject1 = paramHomeFeedPresenter.a(paramSendVidRateDataResultEvent.a);
      if ((localObject1 != null) && ((localObject1 instanceof VideoListHomeFeed)))
      {
        Object localObject2 = (VideoListHomeFeed)localObject1;
        SLog.b("Q.qqstory.home.data.HomeFeedPresenter", "receive rate event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.commentFakeId = %d, event.rate = %d.", new Object[] { paramSendVidRateDataResultEvent.a, paramSendVidRateDataResultEvent.b, Integer.valueOf(paramSendVidRateDataResultEvent.f), Long.valueOf(paramSendVidRateDataResultEvent.h), Integer.valueOf(paramSendVidRateDataResultEvent.c) });
        localObject1 = DetailCommentHelper.a(paramSendVidRateDataResultEvent.a, paramSendVidRateDataResultEvent.f, paramSendVidRateDataResultEvent.h, 2, String.valueOf(paramSendVidRateDataResultEvent.c));
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localObject1);
        ((VideoListHomeFeed)localObject2).a(localArrayList, false);
        localObject2 = (CommentLikeFeedItem)((VideoListHomeFeed)localObject2).f;
        ((CommentLikeFeedItem)localObject2).mCommentCount += 1;
        if (HomeFeedPresenter.a((CommentLikeFeedItem)localObject2)) {
          ((CommentLikeFeedItem)localObject2).mFriendCommentCount += 1;
        } else {
          ((CommentLikeFeedItem)localObject2).mFanCommentCount += 1;
        }
        HomeFeedPresenter.c(paramHomeFeedPresenter).b(paramSendVidRateDataResultEvent.a);
        ThreadManager.post(new HomeFeedPresenter.SendVidRateDataResultReceiver.1(this, (CommentLikeFeedItem)localObject2, (CommentEntry)localObject1), 5, null, false);
        HomeFeedPresenter.a((CommentLikeFeedItem)localObject2, (CommentEntry)localObject1);
        return;
      }
      SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "storyHomeFeed is null or it's not a VideoListHomeFeed. feedId = %s", new Object[] { paramSendVidRateDataResultEvent.a });
      return;
    }
    SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "receive not eligible rate event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.commentFakeId = %d, event.rate = %d.", new Object[] { paramSendVidRateDataResultEvent.a, paramSendVidRateDataResultEvent.b, Integer.valueOf(paramSendVidRateDataResultEvent.f), Long.valueOf(paramSendVidRateDataResultEvent.h), Integer.valueOf(paramSendVidRateDataResultEvent.c) });
  }
  
  public Class acceptEventClass()
  {
    return SendVidRateDataHandler.SendVidRateDataResultEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.SendVidRateDataResultReceiver
 * JD-Core Version:    0.7.0.1
 */