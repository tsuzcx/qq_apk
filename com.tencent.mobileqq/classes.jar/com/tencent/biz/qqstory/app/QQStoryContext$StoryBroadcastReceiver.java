package com.tencent.biz.qqstory.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import mqq.app.MobileQQ;
import nde;

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
      paramContext.getApplicationContext().registerReceiver(this, localIntentFilter);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    SLog.a(jdField_a_of_type_JavaLangString, "onReceive, [context, intent=%s]", paramIntent);
    if (("action_fire_create_story".equals(paramIntent.getAction())) && (TextUtils.equals(paramContext.getPackageName(), MobileQQ.processName))) {
      Bosses.get().postJob(new nde(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.app.QQStoryContext.StoryBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */