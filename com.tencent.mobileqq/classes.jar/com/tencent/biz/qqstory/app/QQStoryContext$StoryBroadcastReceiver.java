package com.tencent.biz.qqstory.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import mqq.app.MobileQQ;

public class QQStoryContext$StoryBroadcastReceiver
  extends BroadcastReceiver
{
  private static final String a;
  private boolean b = false;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StoryBroadcastReceiver_");
    localStringBuilder.append(MobileQQ.processName);
    a = localStringBuilder.toString();
  }
  
  public void a(Context paramContext)
  {
    if (!this.b)
    {
      this.b = true;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("action_fire_create_story");
      localIntentFilter.addAction("action_fire_get_config");
      localIntentFilter.addAction("action_fire_create_video_story");
      paramContext.getApplicationContext().registerReceiver(this, localIntentFilter);
    }
  }
  
  public void b(Context paramContext)
  {
    if (this.b)
    {
      this.b = false;
      paramContext.getApplicationContext().unregisterReceiver(this);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    SLog.a(a, "onReceive, [context, intent=%s]", paramIntent);
    paramIntent = paramIntent.getAction();
    if ("action_fire_create_story".equals(paramIntent))
    {
      if (TextUtils.equals(paramContext.getPackageName(), MobileQQ.processName)) {
        Bosses.get().postJob(new QQStoryContext.StoryBroadcastReceiver.1(this, a));
      }
    }
    else
    {
      if ("action_fire_get_config".equals(paramIntent))
      {
        long l = ((StoryConfigManager)SuperManager.a(10)).k();
        if (Math.abs(System.currentTimeMillis() - l) > 3600000L)
        {
          SLog.b(a, "fireGetStoryConfig update story config from server.");
          ((QQStoryHandler)QQStoryContext.j().getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).a();
          return;
        }
        SLog.b(a, "fireGetStoryConfig do not need update story config from server.");
        return;
      }
      "action_fire_create_video_story".equals(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.app.QQStoryContext.StoryBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */