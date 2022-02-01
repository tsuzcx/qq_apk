package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.widget.TextView;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadProgressManager.UpdateProgressListener;
import com.tencent.mobileqq.app.HardCodeUtil;

class NewMyStorySegment$11
  implements StoryVideoUploadProgressManager.UpdateProgressListener
{
  NewMyStorySegment$11(NewMyStorySegment paramNewMyStorySegment, TextView paramTextView) {}
  
  public void a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131707519) + paramInt + "%");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewMyStorySegment.11
 * JD-Core Version:    0.7.0.1
 */