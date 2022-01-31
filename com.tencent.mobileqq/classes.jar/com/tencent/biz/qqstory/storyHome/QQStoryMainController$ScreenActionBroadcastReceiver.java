package com.tencent.biz.qqstory.storyHome;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import suw;
import tdc;
import veg;

public class QQStoryMainController$ScreenActionBroadcastReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.SCREEN_OFF"))
    {
      ((suw)tdc.a(6)).a(120000L);
      veg.d("Q.qqstory.home.QQStoryMainActivity", "screen off , preloader stop");
    }
    while (!paramContext.equals("android.intent.action.SCREEN_ON")) {
      return;
    }
    ((suw)tdc.a(6)).c();
    veg.d("Q.qqstory.home.QQStoryMainActivity", "screen on , preloader start");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryMainController.ScreenActionBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */