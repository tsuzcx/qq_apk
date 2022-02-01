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
        paramView.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = StoryInputBarView.a(DetailCommentHelper.a(paramView), DetailCommentHelper.a(this.a), this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx, DetailCommentHelper.a(this.a).jdField_a_of_type_Boolean);
        DetailCommentHelper.a(this.a).jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView;
        paramView = this.a;
        boolean bool;
        if (paramView.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView != null) {
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