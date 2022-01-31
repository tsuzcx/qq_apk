package com.tencent.biz.qqstory.debug.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.biz.qqstory.utils.PollWidgetUtils;
import com.tencent.biz.qqstory.utils.PollWidgetUtils.IPollWidget;

public class DebugPollLayoutActivity
  extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968604);
    paramBundle = PollWidgetUtils.a(this, 1, 1, null);
    ((FrameLayout)findViewById(2131362841)).addView(paramBundle.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.debug.activities.DebugPollLayoutActivity
 * JD-Core Version:    0.7.0.1
 */