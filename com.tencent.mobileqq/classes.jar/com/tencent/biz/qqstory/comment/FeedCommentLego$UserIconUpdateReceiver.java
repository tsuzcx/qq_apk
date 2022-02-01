package com.tencent.biz.qqstory.comment;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.network.handler.GetUserIconHandler.UserIconUpdateEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class FeedCommentLego$UserIconUpdateReceiver
  extends QQUIEventReceiver<FeedCommentLego, GetUserIconHandler.UserIconUpdateEvent>
{
  public FeedCommentLego$UserIconUpdateReceiver(@NonNull FeedCommentLego paramFeedCommentLego)
  {
    super(paramFeedCommentLego);
  }
  
  public void a(@NonNull FeedCommentLego paramFeedCommentLego, @NonNull GetUserIconHandler.UserIconUpdateEvent paramUserIconUpdateEvent)
  {
    if (paramUserIconUpdateEvent.g.isFail()) {
      return;
    }
    Iterator localIterator = paramFeedCommentLego.d.iterator();
    while (localIterator.hasNext())
    {
      CommentEntry localCommentEntry = (CommentEntry)localIterator.next();
      if ((paramUserIconUpdateEvent.a.get(localCommentEntry.authorUnionId) != null) || (paramUserIconUpdateEvent.a.get(localCommentEntry.replierUnionId) != null))
      {
        paramFeedCommentLego.h();
        SLog.e(this.TAG, "UserIconUpdateReceiver FeedCommentLego need to update");
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return GetUserIconHandler.UserIconUpdateEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.FeedCommentLego.UserIconUpdateReceiver
 * JD-Core Version:    0.7.0.1
 */