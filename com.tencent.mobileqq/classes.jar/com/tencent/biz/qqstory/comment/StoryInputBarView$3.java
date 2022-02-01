package com.tencent.biz.qqstory.comment;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.biz.qqstory.storyHome.atvideo.model.AtVideoTextWatcher;

class StoryInputBarView$3
  implements View.OnFocusChangeListener
{
  StoryInputBarView$3(StoryInputBarView paramStoryInputBarView) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.a.a();
      return;
    }
    if (!this.a.m)
    {
      paramView = this.a;
      paramView.l = StoryInputBarView.a(paramView.a, this.a.d, this.a.e, this.a.k.e);
      this.a.k.g = this.a.l;
      paramView = this.a;
      if (paramView.l != null) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramView.m = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.StoryInputBarView.3
 * JD-Core Version:    0.7.0.1
 */