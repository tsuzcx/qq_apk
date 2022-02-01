package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.pb.PBStringField;
import com.tribe.async.dispatch.QQUIEventReceiver;
import cooperation.qzone.util.QZLog;
import java.util.Map;

public class CommentPresenter$CommentEventReceiver
  extends QQUIEventReceiver<CommentPresenter, CommentEvent>
{
  public CommentPresenter$CommentEventReceiver(@NonNull CommentPresenter paramCommentPresenter)
  {
    super(paramCommentPresenter);
  }
  
  public void a(@NonNull CommentPresenter paramCommentPresenter, @NonNull CommentEvent paramCommentEvent)
  {
    switch (paramCommentEvent.jdField_a_of_type_Int)
    {
    case 4: 
    case 5: 
    default: 
    case 1: 
    case 2: 
    case 3: 
      CertifiedAccountMeta.StFeed localStFeed;
      int i;
      do
      {
        do
        {
          do
          {
            return;
            paramCommentPresenter.i();
            return;
            paramCommentPresenter.j();
            return;
            CommentPresenter.a(paramCommentPresenter, false);
            CommentPresenter.a(paramCommentPresenter, null);
            CommentPresenter.a(paramCommentPresenter, null);
          } while (!(paramCommentEvent.jdField_a_of_type_JavaLangObject instanceof Object[]));
          paramCommentEvent = (Object[])paramCommentEvent.jdField_a_of_type_JavaLangObject;
        } while ((paramCommentEvent.length < 2) || (!(paramCommentEvent[0] instanceof CertifiedAccountMeta.StFeed)) || (!(paramCommentEvent[1] instanceof Integer)));
        localStFeed = (CertifiedAccountMeta.StFeed)paramCommentEvent[0];
        i = ((Integer)paramCommentEvent[1]).intValue();
      } while (!paramCommentPresenter.a(localStFeed));
      CommentPresenter.c(paramCommentPresenter).put(Integer.valueOf(i), localStFeed);
      QZLog.i(this.TAG, 1, "EVENT_SET_COMMENT_DATA, position:" + i + ", cellId:" + localStFeed.id.get());
      return;
    }
    CommentPresenter.a(paramCommentPresenter, (Object[])paramCommentEvent.jdField_a_of_type_JavaLangObject);
  }
  
  public Class acceptEventClass()
  {
    return CommentEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentPresenter.CommentEventReceiver
 * JD-Core Version:    0.7.0.1
 */