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
    int i = paramCommentEvent.jdField_a_of_type_Int;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 6) {
            return;
          }
          CommentPresenter.a(paramCommentPresenter, (Object[])paramCommentEvent.jdField_a_of_type_JavaLangObject);
          return;
        }
        CommentPresenter.a(paramCommentPresenter, false);
        CommentPresenter.a(paramCommentPresenter, null);
        CommentPresenter.a(paramCommentPresenter, null);
        if ((paramCommentEvent.jdField_a_of_type_JavaLangObject instanceof Object[]))
        {
          Object localObject = (Object[])paramCommentEvent.jdField_a_of_type_JavaLangObject;
          if ((localObject.length >= 2) && ((localObject[0] instanceof CertifiedAccountMeta.StFeed)) && ((localObject[1] instanceof Integer)))
          {
            paramCommentEvent = (CertifiedAccountMeta.StFeed)localObject[0];
            i = ((Integer)localObject[1]).intValue();
            if (paramCommentPresenter.a(paramCommentEvent))
            {
              CommentPresenter.c(paramCommentPresenter).put(Integer.valueOf(i), paramCommentEvent);
              paramCommentPresenter = this.TAG;
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("EVENT_SET_COMMENT_DATA, position:");
              ((StringBuilder)localObject).append(i);
              ((StringBuilder)localObject).append(", cellId:");
              ((StringBuilder)localObject).append(paramCommentEvent.id.get());
              QZLog.i(paramCommentPresenter, 1, ((StringBuilder)localObject).toString());
            }
          }
        }
      }
      else
      {
        paramCommentPresenter.j();
      }
    }
    else {
      paramCommentPresenter.i();
    }
  }
  
  public Class acceptEventClass()
  {
    return CommentEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentPresenter.CommentEventReceiver
 * JD-Core Version:    0.7.0.1
 */