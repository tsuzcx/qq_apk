package com.tencent.biz.qqstory.storyHome;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VideoEncodeActivity$3
  implements RadioGroup.OnCheckedChangeListener
{
  VideoEncodeActivity$3(VideoEncodeActivity paramVideoEncodeActivity) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    RadioButton localRadioButton = (RadioButton)paramRadioGroup.findViewById(paramInt);
    VideoEncodeActivity.a(this.a, (String)localRadioButton.getTag());
    SLog.d("Q.qqstory:VideoEncodeActivity", "select fake vid %s", new Object[] { VideoEncodeActivity.a(this.a) });
    VideoEncodeActivity.a(this.a);
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.VideoEncodeActivity.3
 * JD-Core Version:    0.7.0.1
 */