package com.tencent.biz.qqstory.storyHome.detail.model.cmment;

import com.tencent.biz.qqstory.comment.StoryInputBarView;
import com.tencent.biz.qqstory.storyHome.atvideo.model.AtVideoTextWatcher;

class DetailCommentHelper$3$1
  implements Runnable
{
  DetailCommentHelper$3$1(DetailCommentHelper.3 param3) {}
  
  public void run()
  {
    this.a.a.b = StoryInputBarView.a(DetailCommentHelper.b(this.a.a), DetailCommentHelper.c(this.a.a), this.a.a.a, DetailCommentHelper.d(this.a.a).e);
    DetailCommentHelper localDetailCommentHelper = this.a.a;
    boolean bool;
    if (this.a.a.b != null) {
      bool = true;
    } else {
      bool = false;
    }
    DetailCommentHelper.a(localDetailCommentHelper, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailCommentHelper.3.1
 * JD-Core Version:    0.7.0.1
 */