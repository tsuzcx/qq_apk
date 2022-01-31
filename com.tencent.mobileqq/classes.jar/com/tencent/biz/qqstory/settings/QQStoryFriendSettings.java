package com.tencent.biz.qqstory.settings;

import android.os.Bundle;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import sxp;
import sxy;
import syd;
import ujx;
import vel;

public class QQStoryFriendSettings
  extends IphoneTitleBarActivity
{
  protected sxy<QQStoryFriendSettings> a = sxp.a(ujx.class, syd.a(sxy.class), new Object[0]);
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.a.a(this, paramBundle);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.a.a(this);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    vel.a(7, this.currentActivityStayTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryFriendSettings
 * JD-Core Version:    0.7.0.1
 */