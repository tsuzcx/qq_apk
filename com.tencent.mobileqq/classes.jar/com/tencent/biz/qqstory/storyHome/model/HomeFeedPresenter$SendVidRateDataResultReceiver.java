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
import nyz;

public class HomeFeedPresenter$SendVidRateDataResultReceiver
  extends QQUIEventReceiver
{
  public HomeFeedPresenter$SendVidRateDataResultReceiver(HomeFeedPresenter paramHomeFeedPresenter1, @NonNull HomeFeedPresenter paramHomeFeedPresenter2)
  {
    super(paramHomeFeedPresenter2);
  }
  
  public void a(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull SendVidRateDataHandler.SendVidRateDataResultEvent paramSendVidRateDataResultEvent)
  {
    if ((TextUtils.isEmpty(paramSendVidRateDataResultEvent.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramSendVidRateDataResultEvent.jdField_b_of_type_JavaLangString)) || (paramSendVidRateDataResultEvent.c == 0) || (paramSendVidRateDataResultEvent.jdField_b_of_type_Long == 0L) || (paramSendVidRateDataResultEvent.jdField_a_of_type_Int < 1))
    {
      SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "receive not eligible rate event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.commentFakeId = %d, event.rate = %d.", new Object[] { paramSendVidRateDataResultEvent.jdField_a_of_type_JavaLangString, paramSendVidRateDataResultEvent.jdField_b_of_type_JavaLangString, Integer.valueOf(paramSendVidRateDataResultEvent.c), Long.valueOf(paramSendVidRateDataResultEvent.jdField_b_of_type_Long), Integer.valueOf(paramSendVidRateDataResultEvent.jdField_a_of_type_Int) });
      return;
    }
    Object localObject1 = paramHomeFeedPresenter.a(paramSendVidRateDataResultEvent.jdField_a_of_type_JavaLangString);
    if ((localObject1 == null) || (!(localObject1 instanceof VideoListHomeFeed)))
    {
      SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "storyHomeFeed is null or it's not a VideoListHomeFeed. feedId = %s", new Object[] { paramSendVidRateDataResultEvent.jdField_a_of_type_JavaLangString });
      return;
    }
    Object localObject2 = (VideoListHomeFeed)localObject1;
    SLog.b("Q.qqstory.home.data.HomeFeedPresenter", "receive rate event. event.feedId = %s, event.vid = %s, event.commentId = %d, event.commentFakeId = %d, event.rate = %d.", new Object[] { paramSendVidRateDataResultEvent.jdField_a_of_type_JavaLangString, paramSendVidRateDataResultEvent.jdField_b_of_type_JavaLangString, Integer.valueOf(paramSendVidRateDataResultEvent.c), Long.valueOf(paramSendVidRateDataResultEvent.jdField_b_of_type_Long), Integer.valueOf(paramSendVidRateDataResultEvent.jdField_a_of_type_Int) });
    localObject1 = DetailCommentHelper.a(paramSendVidRateDataResultEvent.jdField_a_of_type_JavaLangString, paramSendVidRateDataResultEvent.c, paramSendVidRateDataResultEvent.jdField_b_of_type_Long, 2, String.valueOf(paramSendVidRateDataResultEvent.jdField_a_of_type_Int));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject1);
    ((VideoListHomeFeed)localObject2).a(localArrayList, false);
    localObject2 = (CommentLikeFeedItem)((VideoListHomeFeed)localObject2).a;
    ((CommentLikeFeedItem)localObject2).mCommentCount += 1;
    if (HomeFeedPresenter.a((CommentLikeFeedItem)localObject2)) {
      ((CommentLikeFeedItem)localObject2).mFriendCommentCount += 1;
    }
    for (;;)
    {
      HomeFeedPresenter.a(paramHomeFeedPresenter).b(paramSendVidRateDataResultEvent.jdField_a_of_type_JavaLangString);
      ThreadManager.post(new nyz(this, (CommentLikeFeedItem)localObject2, (CommentEntry)localObject1), 5, null, false);
      HomeFeedPresenter.a((CommentLikeFeedItem)localObject2, (CommentEntry)localObject1);
      return;
      ((CommentLikeFeedItem)localObject2).mFanCommentCount += 1;
    }
  }
  
  public Class acceptEventClass()
  {
    return SendVidRateDataHandler.SendVidRateDataResultEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.SendVidRateDataResultReceiver
 * JD-Core Version:    0.7.0.1
 */