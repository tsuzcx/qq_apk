package com.tencent.biz.qqstory.storyHome;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.qqstory.base.preload.PreloadDownloaderManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;

public class QQStoryMainController$ScreenActionBroadcastReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext.equals("android.intent.action.SCREEN_OFF"))
    {
      ((PreloadDownloaderManager)SuperManager.a(6)).a(120000L);
      SLog.d("Q.qqstory.home.QQStoryMainActivity", "screen off , preloader stop");
    }
    while (!paramContext.equals("android.intent.action.SCREEN_ON")) {
      return;
    }
    ((PreloadDownloaderManager)SuperManager.a(6)).c();
    SLog.d("Q.qqstory.home.QQStoryMainActivity", "screen on , preloader start");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryMainController.ScreenActionBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */