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
import nyy;

public class HomeFeedPresenter$SendVidPollDataResultReceiver
  extends QQUIEventReceiver
{
  public HomeFeedPresenter$SendVidPollDataResultReceiver(HomeFeedPresenter paramHomeFeedPresenter1, @NonNull HomeFeedPresenter paramHomeFeedPresenter2)
  {
    super(paramHomeFeedPresenter2);
  }
  
  public void a(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull SendVidPollDataHandler.SendVidPollDataResultEvent paramSendVidPollDataResultEvent)
  {
    if ((TextUtils.isEmpty(paramSendVidPollDataResultEvent.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramSendVidPollDataResultEvent.jdField_b_of_type_JavaLangString)) || (paramSendVidPollDataResultEvent.jdField_a_of_type_Int == 0) || (paramSendVidPollDataResultEvent.jdField_a_of_type_Long == 0L))
    {
      SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "receive not eligible poll event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.commentFakeId = %d.", new Object[] { paramSendVidPollDataResultEvent.jdField_a_of_type_JavaLangString, paramSendVidPollDataResultEvent.jdField_b_of_type_JavaLangString, Integer.valueOf(paramSendVidPollDataResultEvent.jdField_a_of_type_Int), Long.valueOf(paramSendVidPollDataResultEvent.jdField_a_of_type_Long) });
      return;
    }
    Object localObject1 = paramHomeFeedPresenter.a(paramSendVidPollDataResultEvent.jdField_a_of_type_JavaLangString);
    if ((localObject1 == null) || (!(localObject1 instanceof VideoListHomeFeed)))
    {
      SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "storyHomeFeed is null or it's not a VideoListHomeFeed. feedId = %s", new Object[] { paramSendVidPollDataResultEvent.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject2 = (VideoListHomeFeed)localObject1;
    SLog.a("Q.qqstory.home.data.HomeFeedPresenter", "receive poll event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.pollIndex = %d.", paramSendVidPollDataResultEvent.jdField_a_of_type_JavaLangString, paramSendVidPollDataResultEvent.jdField_b_of_type_JavaLangString, Integer.valueOf(paramSendVidPollDataResultEvent.jdField_a_of_type_Int), Integer.valueOf(paramSendVidPollDataResultEvent.jdField_b_of_type_Int));
    localObject1 = ((VideoListHomeFeed)localObject2).a().iterator();
    Object localObject3;
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        localObject3 = (StoryVideoItem)((Iterator)localObject1).next();
        if (((StoryVideoItem)localObject3).mVid.equals(paramSendVidPollDataResultEvent.jdField_b_of_type_JavaLangString))
        {
          localObject1 = ((StoryVideoItem)localObject3).getPollLayout();
          if ((localObject1 != null) && (((StoryVideoItem.PollLayout)localObject1).a.length > paramSendVidPollDataResultEvent.jdField_b_of_type_Int)) {
            localObject1 = localObject1.a[(paramSendVidPollDataResultEvent.jdField_b_of_type_Int + 1)];
          }
        }
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = DetailCommentHelper.a(paramSendVidPollDataResultEvent.jdField_a_of_type_JavaLangString, paramSendVidPollDataResultEvent.jdField_a_of_type_Int, paramSendVidPollDataResultEvent.jdField_a_of_type_Long, 1, (String)localObject1);
        localObject3 = new ArrayList();
        ((List)localObject3).add(localObject1);
        ((VideoListHomeFeed)localObject2).a((List)localObject3, false);
        localObject2 = (CommentLikeFeedItem)((VideoListHomeFeed)localObject2).a;
        ((CommentLikeFeedItem)localObject2).mCommentCount += 1;
        if (HomeFeedPresenter.a((CommentLikeFeedItem)localObject2)) {
          ((CommentLikeFeedItem)localObject2).mFriendCommentCount += 1;
        }
        for (;;)
        {
          HomeFeedPresenter.a(paramHomeFeedPresenter).b(paramSendVidPollDataResultEvent.jdField_a_of_type_JavaLangString);
          ThreadManager.post(new nyy(this, (CommentLikeFeedItem)localObject2, (CommentEntry)localObject1), 5, null, false);
          HomeFeedPresenter.a((CommentLikeFeedItem)localObject2, (CommentEntry)localObject1);
          return;
          if (localObject1 == null) {}
          for (int i = 0;; i = ((StoryVideoItem.PollLayout)localObject1).a.length)
          {
            SLog.e("Q.qqstory.home.data.HomeFeedPresenter", "get poll answer failed because PollLayout is null or pollIndex lager than contents.length. pollLayout = %s, pollLayout.contents.length = %d, event.pollIndex = %d.", new Object[] { localObject1, Integer.valueOf(i), Integer.valueOf(paramSendVidPollDataResultEvent.jdField_b_of_type_Int) });
            localObject1 = null;
            break;
          }
          ((CommentLikeFeedItem)localObject2).mFanCommentCount += 1;
        }
      }
      SLog.e("Q.qqstory.home.data.HomeFeedPresenter", "generate vote comment failed because poll answer is empty.");
      return;
      localObject1 = null;
    }
  }
  
  public Class acceptEventClass()
  {
    return SendVidPollDataHandler.SendVidPollDataResultEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.SendVidPollDataResultReceiver
 * JD-Core Version:    0.7.0.1
 */