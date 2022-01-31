package com.tencent.biz.qqstory.settings;

import android.os.Bundle;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.boundaries.delegates.ActivityDelegate;
import com.tencent.biz.qqstory.boundaries.implement.NullableObjectFactoryImplement;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;

public class QQStoryFriendSettings
  extends IphoneTitleBarActivity
{
  protected ActivityDelegate a = StoryApi.a(QQStoryFriendSettingDelegate.class, NullableObjectFactoryImplement.a(ActivityDelegate.class), new Object[0]);
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.a.a(this, paramBundle);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.a.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryFriendSettings
 * JD-Core Version:    0.7.0.1
 */