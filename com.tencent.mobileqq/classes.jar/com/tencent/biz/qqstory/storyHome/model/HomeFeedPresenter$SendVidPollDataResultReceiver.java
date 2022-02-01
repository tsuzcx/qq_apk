package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.PollLayout;
import com.tencent.biz.qqstory.network.handler.SendVidPollDataHandler.SendVidPollDataResultEvent;
import com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailCommentHelper;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HomeFeedPresenter$SendVidPollDataResultReceiver
  extends QQUIEventReceiver<HomeFeedPresenter, SendVidPollDataHandler.SendVidPollDataResultEvent>
{
  public HomeFeedPresenter$SendVidPollDataResultReceiver(HomeFeedPresenter paramHomeFeedPresenter1, @NonNull HomeFeedPresenter paramHomeFeedPresenter2)
  {
    super(paramHomeFeedPresenter2);
  }
  
  public void a(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull SendVidPollDataHandler.SendVidPollDataResultEvent paramSendVidPollDataResultEvent)
  {
    if ((!TextUtils.isEmpty(paramSendVidPollDataResultEvent.a)) && (!TextUtils.isEmpty(paramSendVidPollDataResultEvent.b)) && (paramSendVidPollDataResultEvent.d != 0) && (paramSendVidPollDataResultEvent.e != 0L))
    {
      Object localObject1 = paramHomeFeedPresenter.a(paramSendVidPollDataResultEvent.a);
      if ((localObject1 != null) && ((localObject1 instanceof VideoListHomeFeed)))
      {
        Object localObject2 = (VideoListHomeFeed)localObject1;
        SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "receive poll event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.pollIndex = %d.", paramSendVidPollDataResultEvent.a, paramSendVidPollDataResultEvent.b, Integer.valueOf(paramSendVidPollDataResultEvent.d), Integer.valueOf(paramSendVidPollDataResultEvent.f));
        localObject1 = ((VideoListHomeFeed)localObject2).a().iterator();
        Object localObject3;
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (StoryVideoItem)((Iterator)localObject1).next();
          if (((StoryVideoItem)localObject3).mVid.equals(paramSendVidPollDataResultEvent.b))
          {
            localObject1 = ((StoryVideoItem)localObject3).getPollLayout();
            if ((localObject1 != null) && (((StoryVideoItem.PollLayout)localObject1).j.length > paramSendVidPollDataResultEvent.f))
            {
              localObject1 = localObject1.j[(paramSendVidPollDataResultEvent.f + 1)];
              break label245;
            }
            int i;
            if (localObject1 == null) {
              i = 0;
            } else {
              i = ((StoryVideoItem.PollLayout)localObject1).j.length;
            }
            SLog.e("Q.qqstory.home.data.HomeFeedPresenter", "get poll answer failed because PollLayout is null or pollIndex lager than contents.length. pollLayout = %s, pollLayout.contents.length = %d, event.pollIndex = %d.", new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(paramSendVidPollDataResultEvent.f) });
          }
        }
        localObject1 = null;
        label245:
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = DetailCommentHelper.a(paramSendVidPollDataResultEvent.a, paramSendVidPollDataResultEvent.d, paramSendVidPollDataResultEvent.e, 1, (String)localObject1);
          localObject3 = new ArrayList();
          ((List)localObject3).add(localObject1);
          ((VideoListHomeFeed)localObject2).a((List)localObject3, false);
          localObject2 = (CommentLikeFeedItem)((VideoListHomeFeed)localObject2).f;
          ((CommentLikeFeedItem)localObject2).mCommentCount += 1;
          if (HomeFeedPresenter.a((CommentLikeFeedItem)localObject2)) {
            ((CommentLikeFeedItem)localObject2).mFriendCommentCount += 1;
          } else {
            ((CommentLikeFeedItem)localObject2).mFanCommentCount += 1;
          }
          HomeFeedPresenter.c(paramHomeFeedPresenter).b(paramSendVidPollDataResultEvent.a);
          ThreadManager.post(new HomeFeedPresenter.SendVidPollDataResultReceiver.1(this, (CommentLikeFeedItem)localObject2, (CommentEntry)localObject1), 5, null, false);
          HomeFeedPresenter.a((CommentLikeFeedItem)localObject2, (CommentEntry)localObject1);
          return;
        }
        SLog.e("Q.qqstory.home.data.HomeFeedPresenter", "generate vote comment failed because poll answer is empty.");
        return;
      }
      SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "storyHomeFeed is null or it's not a VideoListHomeFeed. feedId = %s", new Object[] { paramSendVidPollDataResultEvent.a });
      return;
    }
    SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "receive not eligible poll event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.commentFakeId = %d.", new Object[] { paramSendVidPollDataResultEvent.a, paramSendVidPollDataResultEvent.b, Integer.valueOf(paramSendVidPollDataResultEvent.d), Long.valueOf(paramSendVidPollDataResultEvent.e) });
  }
  
  public Class acceptEventClass()
  {
    return SendVidPollDataHandler.SendVidPollDataResultEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.SendVidPollDataResultReceiver
 * JD-Core Version:    0.7.0.1
 */