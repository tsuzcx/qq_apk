package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.comment.GamePKCommentEvent;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailCommentHelper;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.List;

public class HomeFeedPresenter$GamePKCommentReceiver
  extends QQUIEventReceiver<HomeFeedPresenter, GamePKCommentEvent>
{
  public HomeFeedPresenter$GamePKCommentReceiver(@NonNull HomeFeedPresenter paramHomeFeedPresenter)
  {
    super(paramHomeFeedPresenter);
  }
  
  public void a(@NonNull HomeFeedPresenter paramHomeFeedPresenter, @NonNull GamePKCommentEvent paramGamePKCommentEvent)
  {
    if ((!TextUtils.isEmpty(paramGamePKCommentEvent.jdField_a_of_type_JavaLangString)) && (paramGamePKCommentEvent.jdField_a_of_type_Int != 0) && (paramGamePKCommentEvent.jdField_a_of_type_Long != 0L) && (!TextUtils.isEmpty(paramGamePKCommentEvent.b)))
    {
      Object localObject1 = paramHomeFeedPresenter.a(paramGamePKCommentEvent.jdField_a_of_type_JavaLangString);
      if ((localObject1 != null) && ((localObject1 instanceof VideoListHomeFeed)))
      {
        Object localObject2 = (VideoListHomeFeed)localObject1;
        localObject1 = DetailCommentHelper.a(paramGamePKCommentEvent.jdField_a_of_type_JavaLangString, paramGamePKCommentEvent.jdField_a_of_type_Int, paramGamePKCommentEvent.jdField_a_of_type_Long, paramGamePKCommentEvent.b, paramGamePKCommentEvent.c, paramGamePKCommentEvent.d, paramGamePKCommentEvent.e, paramGamePKCommentEvent.f);
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localObject1);
        ((VideoListHomeFeed)localObject2).a(localArrayList, false);
        localObject2 = (CommentLikeFeedItem)((VideoListHomeFeed)localObject2).a;
        ((CommentLikeFeedItem)localObject2).mCommentCount += 1;
        if (HomeFeedPresenter.a((CommentLikeFeedItem)localObject2)) {
          ((CommentLikeFeedItem)localObject2).mFriendCommentCount += 1;
        } else {
          ((CommentLikeFeedItem)localObject2).mFanCommentCount += 1;
        }
        HomeFeedPresenter.a(paramHomeFeedPresenter).b(paramGamePKCommentEvent.jdField_a_of_type_JavaLangString);
        ThreadManager.post(new HomeFeedPresenter.GamePKCommentReceiver.1(this, (CommentLikeFeedItem)localObject2, (CommentEntry)localObject1, paramGamePKCommentEvent), 5, null, false);
        HomeFeedPresenter.a((CommentLikeFeedItem)localObject2, (CommentEntry)localObject1);
        return;
      }
      SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "storyHomeFeed is null or it's not a VideoListHomeFeed. feedId = %s", new Object[] { paramGamePKCommentEvent.jdField_a_of_type_JavaLangString });
      return;
    }
    SLog.d("Q.qqstory.home.data.HomeFeedPresenter", "receive not eligible gamepk event. event.feedId = %s, event.commentId = %d, event.commentFakeId = %d, event.content = %s.", new Object[] { paramGamePKCommentEvent.jdField_a_of_type_JavaLangString, Integer.valueOf(paramGamePKCommentEvent.jdField_a_of_type_Int), Long.valueOf(paramGamePKCommentEvent.jdField_a_of_type_Long), paramGamePKCommentEvent.b });
  }
  
  public Class acceptEventClass()
  {
    return GamePKCommentEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.GamePKCommentReceiver
 * JD-Core Version:    0.7.0.1
 */