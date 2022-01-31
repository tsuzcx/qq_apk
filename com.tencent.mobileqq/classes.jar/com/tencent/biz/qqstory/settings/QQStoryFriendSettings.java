package com.tencent.biz.qqstory.settings;

import android.os.Bundle;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import uqn;
import uqw;
import urb;
import wcv;
import wxj;

public class QQStoryFriendSettings
  extends IphoneTitleBarActivity
{
  protected uqw<QQStoryFriendSettings> a = uqn.a(wcv.class, urb.a(uqw.class), new Object[0]);
  
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
    wxj.a(7, this.currentActivityStayTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryFriendSettings
 * JD-Core Version:    0.7.0.1
 */