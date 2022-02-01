package com.tencent.biz.qqstory.storyHome.detail.model.cmment;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.qqstory.comment.StoryInputBarView;
import com.tencent.biz.qqstory.storyHome.atvideo.model.AtVideoTextWatcher;

class DetailCommentHelper$2
  implements View.OnTouchListener
{
  DetailCommentHelper$2(DetailCommentHelper paramDetailCommentHelper) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      if (!DetailCommentHelper.a(this.a))
      {
        paramView = this.a;
        paramView.b = StoryInputBarView.a(DetailCommentHelper.b(paramView), DetailCommentHelper.c(this.a), this.a.a, DetailCommentHelper.d(this.a).e);
        DetailCommentHelper.d(this.a).g = this.a.b;
        paramView = this.a;
        boolean bool;
        if (paramView.b != null) {
          bool = true;
        } else {
          bool = false;
        }
        DetailCommentHelper.a(paramView, bool);
        return false;
      }
      this.a.b();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailCommentHelper.2
 * JD-Core Version:    0.7.0.1
 */