package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.MyStorys;
import com.tencent.biz.qqstory.utils.UIUtils;

class NewMyStorySegment$8
  implements Runnable
{
  NewMyStorySegment$8(NewMyStorySegment paramNewMyStorySegment, TextView paramTextView, View paramView, ImageView paramImageView) {}
  
  public void run()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(NewMyStorySegment.a(this.this$0, NewMyStorySegment.a(this.this$0), this.jdField_a_of_type_AndroidViewView.getWidth() - this.jdField_a_of_type_AndroidWidgetImageView.getWidth() - UIUtils.a(NewMyStorySegment.a(this.this$0), 70.0F), this.jdField_a_of_type_AndroidWidgetTextView.getPaint()));
    if (NewMyStorySegment.a(this.this$0).f > 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-65536);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(NewMyStorySegment.b(this.this$0).getResources().getColor(2131167127));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewMyStorySegment.8
 * JD-Core Version:    0.7.0.1
 */