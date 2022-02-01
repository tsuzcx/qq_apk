package com.tencent.biz.qqstory.storyHome.detail.model.cmment;

import android.os.Handler;
import android.view.View;
import android.view.View.OnFocusChangeListener;

class DetailCommentHelper$3
  implements View.OnFocusChangeListener
{
  DetailCommentHelper$3(DetailCommentHelper paramDetailCommentHelper) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.a.b();
    }
    while (DetailCommentHelper.a(this.a)) {
      return;
    }
    new Handler().postDelayed(new DetailCommentHelper.3.1(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailCommentHelper.3
 * JD-Core Version:    0.7.0.1
 */