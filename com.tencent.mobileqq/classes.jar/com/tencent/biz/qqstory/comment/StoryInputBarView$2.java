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
      StoryInputBarView.a(this.a);
      if (this.a.jdField_a_of_type_Boolean) {
        break label94;
      }
      this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = StoryInputBarView.a(this.a.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_AndroidViewView, this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeAtvideoModelAtVideoTextWatcher.jdField_a_of_type_Boolean);
      paramView = this.a;
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView == null) {
        break label89;
      }
    }
    label89:
    for (boolean bool = true;; bool = false)
    {
      paramView.jdField_a_of_type_Boolean = bool;
      return false;
    }
    label94:
    this.a.a();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.StoryInputBarView.2
 * JD-Core Version:    0.7.0.1
 */