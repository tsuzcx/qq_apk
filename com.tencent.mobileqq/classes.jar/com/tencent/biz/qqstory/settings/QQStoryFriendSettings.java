package com.tencent.biz.qqstory.settings;

import android.os.Bundle;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import ume;
import umn;
import ums;
import vym;
import wta;

public class QQStoryFriendSettings
  extends IphoneTitleBarActivity
{
  protected umn<QQStoryFriendSettings> a = ume.a(vym.class, ums.a(umn.class), new Object[0]);
  
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
    wta.a(7, this.currentActivityStayTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryFriendSettings
 * JD-Core Version:    0.7.0.1
 */