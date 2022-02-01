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
    TextView localTextView = this.a;
    NewMyStorySegment localNewMyStorySegment = this.this$0;
    localTextView.setText(NewMyStorySegment.a(localNewMyStorySegment, NewMyStorySegment.b(localNewMyStorySegment), this.b.getWidth() - this.c.getWidth() - UIUtils.a(NewMyStorySegment.c(this.this$0), 70.0F), this.a.getPaint()));
    if (NewMyStorySegment.b(this.this$0).q > 0)
    {
      this.a.setTextColor(-65536);
      return;
    }
    this.a.setTextColor(NewMyStorySegment.d(this.this$0).getResources().getColor(2131168133));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewMyStorySegment.8
 * JD-Core Version:    0.7.0.1
 */