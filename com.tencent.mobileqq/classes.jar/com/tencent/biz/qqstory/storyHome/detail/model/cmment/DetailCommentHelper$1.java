package com.tencent.biz.qqstory.storyHome.detail.model.cmment;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class DetailCommentHelper$1
  implements TextView.OnEditorActionListener
{
  DetailCommentHelper$1(DetailCommentHelper paramDetailCommentHelper) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      this.a.d();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.cmment.DetailCommentHelper.1
 * JD-Core Version:    0.7.0.1
 */