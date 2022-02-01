package com.tencent.biz.qqstory.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import mqq.app.MobileQQ;
import wet;
import wff;
import wpf;
import wpm;
import yqp;

public class QQStoryContext$StoryBroadcastReceiver
  extends BroadcastReceiver
{
  private static final String jdField_a_of_type_JavaLangString = "StoryBroadcastReceiver_" + MobileQQ.processName;
  private boolean jdField_a_of_type_Boolean;
  
  public void a(Context paramContext)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("action_fire_create_story");
      localIntentFilter.addAction("action_fire_get_config");
      localIntentFilter.addAction("action_fire_create_video_story");
      paramContext.getApplicationContext().registerReceiver(this, localIntentFilter);
    }
  }
  
  public void b(Context paramContext)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      paramContext.getApplicationContext().unregisterReceiver(this);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    yqp.a(jdField_a_of_type_JavaLangString, "onReceive, [context, intent=%s]", paramIntent);
    paramIntent = paramIntent.getAction();
    if ("action_fire_create_story".equals(paramIntent)) {
      if (TextUtils.equals(paramContext.getPackageName(), MobileQQ.processName)) {
        Bosses.get().postJob(new wet(this, jdField_a_of_type_JavaLangString));
      }
    }
    do
    {
      return;
      if ("action_fire_get_config".equals(paramIntent))
      {
        long l = ((wpf)wpm.a(10)).b();
        if (Math.abs(System.currentTimeMillis() - l) > 3600000L)
        {
          yqp.b(jdField_a_of_type_JavaLangString, "fireGetStoryConfig update story config from server.");
          ((wff)QQStoryContext.a().a(98)).d();
          return;
        }
        yqp.b(jdField_a_of_type_JavaLangString, "fireGetStoryConfig do not need update story config from server.");
        return;
      }
    } while (!"action_fire_create_video_story".equals(paramIntent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.app.QQStoryContext.StoryBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */