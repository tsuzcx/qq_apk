package com.tencent.biz.qqstory.comment;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.qqstory.storyHome.atvideo.model.AtVideoTextWatcher;

class StoryInputBarView$2
  implements View.OnTouchListener
{
  StoryInputBarView$2(StoryInputBarView paramStoryInputBarView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      StoryInputBarView.b(this.a);
      if (!this.a.m)
      {
        paramView = this.a;
        paramView.l = StoryInputBarView.a(paramView.a, this.a.d, this.a.e, this.a.k.e);
        paramView = this.a;
        boolean bool;
        if (paramView.l != null) {
          bool = true;
        } else {
          bool = false;
        }
        paramView.m = bool;
        return false;
      }
      this.a.a();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.StoryInputBarView.2
 * JD-Core Version:    0.7.0.1
 */