package com.tencent.biz.qqstory.storyHome;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import sia;
import sqg;
import urk;

public class QQStoryMainController$ScreenActionBroadcastReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.SCREEN_OFF"))
    {
      ((sia)sqg.a(6)).a(120000L);
      urk.d("Q.qqstory.home.QQStoryMainActivity", "screen off , preloader stop");
    }
    while (!paramContext.equals("android.intent.action.SCREEN_ON")) {
      return;
    }
    ((sia)sqg.a(6)).c();
    urk.d("Q.qqstory.home.QQStoryMainActivity", "screen on , preloader start");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryMainController.ScreenActionBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */