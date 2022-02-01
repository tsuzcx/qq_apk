package com.tencent.biz.subscribe.comment;

import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tribe.async.dispatch.Dispatcher;

class CommentPresenter$14
  implements Runnable
{
  CommentPresenter$14(CommentPresenter paramCommentPresenter) {}
  
  public void run()
  {
    StoryDispatcher.a().dispatch(new CommentEvent(1, new Object[0]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentPresenter.14
 * JD-Core Version:    0.7.0.1
 */