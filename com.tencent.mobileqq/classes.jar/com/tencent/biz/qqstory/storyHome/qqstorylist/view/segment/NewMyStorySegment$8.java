package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import uyc;
import vcp;
import vzl;

public class NewMyStorySegment$8
  implements Runnable
{
  public NewMyStorySegment$8(vcp paramvcp, TextView paramTextView, View paramView, ImageView paramImageView) {}
  
  public void run()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(vcp.a(this.this$0, vcp.a(this.this$0), this.jdField_a_of_type_AndroidViewView.getWidth() - this.jdField_a_of_type_AndroidWidgetImageView.getWidth() - vzl.a(vcp.a(this.this$0), 70.0F), this.jdField_a_of_type_AndroidWidgetTextView.getPaint()));
    if (vcp.a(this.this$0).f > 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-65536);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(vcp.b(this.this$0).getResources().getColor(2131166941));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewMyStorySegment.8
 * JD-Core Version:    0.7.0.1
 */