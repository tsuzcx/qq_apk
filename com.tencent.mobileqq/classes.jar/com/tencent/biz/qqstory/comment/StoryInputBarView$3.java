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
    if (!this.a.jdField_a_of_type_Boolean)
    {
      paramView = this.a;
      paramView.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = StoryInputBarView.a(paramView.jdField_a_of_type_AndroidContentContext, this.a.jdField_a_of_type_AndroidViewView, this.a.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeAtvideoModelAtVideoTextWatcher.jdField_a_of_type_Boolean);
      this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeAtvideoModelAtVideoTextWatcher.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView = this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView;
      paramView = this.a;
      if (paramView.jdField_a_of_type_ComTencentBizQqstoryViewWidgetBubbleBubbleTextView != null) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      paramView.jdField_a_of_type_Boolean = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.comment.StoryInputBarView.3
 * JD-Core Version:    0.7.0.1
 */