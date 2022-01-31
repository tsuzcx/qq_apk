package com.tencent.biz.qqstory.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.qqstory.model.QQStoryActivityManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.qphone.base.util.QLog;

public class StoryMsgNotificationReceiver
  extends BroadcastReceiver
{
  public static final Intent a(Context paramContext)
  {
    ((QQStoryActivityManager)SuperManager.a(18)).a();
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.protocol", 2, "getMainIntent() isNowTabAdded = " + NowLiveManager.c);
    }
    if (NowLiveManager.c)
    {
      paramContext = new Intent(paramContext, SplashActivity.class);
      paramContext.putExtra("fragment_id", 1);
      paramContext.putExtra("tab_index", MainFragment.f);
      paramContext.putExtra("open_now_tab_fragment", true);
      paramContext.putExtra("extra_from_share", true);
      paramContext.setFlags(335544320);
      return paramContext;
    }
    paramContext = new Intent(paramContext, QQStoryMainActivity.class);
    paramContext.setFlags(335544320);
    return paramContext;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "MsgNotificationReceiver action: " + (String)localObject);
    }
    if ("com.tencent.biz.qqstory.notification.qqstory_delete_notify".equals(localObject))
    {
      i = paramIntent.getIntExtra("push_type", 0);
      StoryMsgNotification.a().a(paramContext, i);
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "delete type = " + i);
      }
    }
    while (!"com.tencent.biz.qqstory.notification.qqstory_jump_activity_notify".equals(localObject)) {
      return;
    }
    localObject = (StoryPushMsg)paramIntent.getParcelableExtra("storyPushMsg");
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.protocol", 2, "onReceive() jumpActivity pushMsg = " + localObject);
    }
    Intent localIntent = a(paramContext);
    int i = ((StoryPushMsg)localObject).jdField_a_of_type_Int;
    switch (i)
    {
    case 5: 
    default: 
      label292:
      paramIntent = "";
      if ((((StoryPushMsg)localObject).jdField_a_of_type_Int == 3) || (((StoryPushMsg)localObject).jdField_a_of_type_Int == 9)) {
        paramIntent = String.valueOf(((StoryPushMsg)localObject).jdField_a_of_type_Long);
      }
      if (!TextUtils.isEmpty(((StoryPushMsg)localObject).jdField_a_of_type_JavaLangString)) {
        break;
      }
    }
    for (localObject = "9999";; localObject = ((StoryPushMsg)localObject).jdField_a_of_type_JavaLangString)
    {
      StoryReportor.a("notice_msg", "clk_push", 0, 0, new String[] { localObject, paramIntent, "", "" });
      if (localIntent == null) {
        break;
      }
      paramContext.startActivity(localIntent);
      return;
      localIntent.putExtra("action", 8);
      localIntent.putExtra("pushType", i);
      localIntent.putExtra("extra_feedid", ((StoryPushMsg)localObject).d);
      StoryReportor.a("notice_msg", "clk_notice", 0, 0, new String[] { "", "", "", "" });
      break label292;
      localIntent.putExtra("action", 9);
      localIntent.putExtra("EXTRA_VIDEO_MODE", 19);
      localIntent.putExtra("EXTRA_USER_UIN", String.valueOf(((StoryPushMsg)localObject).jdField_a_of_type_Long));
      localIntent.putExtra("EXTRA_USER_UNION_ID", ((StoryPushMsg)localObject).c);
      localIntent.putExtra("extra_feedid", ((StoryPushMsg)localObject).d);
      localIntent.putExtra("extra_vid", ((StoryPushMsg)localObject).e);
      localIntent.putExtra("extra_is_use_cache_videolist", false);
      localIntent.putExtra("extra_pull_type", 1);
      StoryReportor.a("notice_msg", "care_android", 0, 0, new String[] { "", "", "", "" });
      break label292;
      localIntent.putExtra("action", 4);
      localIntent.putExtra("EXTRA_VIDEO_MODE", 9);
      localIntent.putExtra("extra_topic_id", ((StoryPushMsg)localObject).jdField_a_of_type_AndroidOsBundle.getLong("hot_topic_id"));
      localIntent.putExtra("extra_topic_name", ((StoryPushMsg)localObject).jdField_a_of_type_AndroidOsBundle.getString("hot_topic_name"));
      localIntent.putExtra("extra_share_from_type", 31);
      break label292;
      localIntent.putExtra("action", 1);
      break label292;
      localIntent.putExtra("action", 7);
      localIntent.putExtra("EXTRA_USER_UIN", ((StoryPushMsg)localObject).jdField_a_of_type_AndroidOsBundle.getString("big_v_id"));
      localIntent.putExtra("EXTRA_USER_UNION_ID", ((StoryPushMsg)localObject).jdField_a_of_type_AndroidOsBundle.getString("big_v_union_id"));
      localIntent.putExtra("extra_share_from_type", 31);
      break label292;
      localIntent.putExtra("action", 6);
      localIntent.putExtra("user_type", ((StoryPushMsg)localObject).jdField_a_of_type_AndroidOsBundle.getInt("pgc_type"));
      localIntent.putExtra("user_unionid", ((StoryPushMsg)localObject).jdField_a_of_type_AndroidOsBundle.getString("pgc_column_union_id"));
      localIntent.putExtra("come_from", 29);
      break label292;
      localIntent.putExtra("action", 10);
      localIntent.putExtra("url", ((StoryPushMsg)localObject).jdField_a_of_type_AndroidOsBundle.getString("link"));
      localIntent.putExtra("webStyle", "noBottomBar");
      break label292;
      paramIntent = new StringBuilder("http://story.now.qq.com/m/vote/index.html?_wv=3&_nav_alpha=0");
      paramIntent.append("&vid=").append(((StoryPushMsg)localObject).e);
      localIntent.putExtra("action", 10);
      localIntent.putExtra("url", paramIntent.toString());
      localIntent.putExtra("webStyle", "noBottomBar");
      break label292;
      paramIntent = new StringBuilder("http://story.now.qq.com/m/score/index.html?_wv=3&_nav_alpha=0");
      paramIntent.append("&vid=").append(((StoryPushMsg)localObject).e);
      localIntent.putExtra("action", 10);
      localIntent.putExtra("url", paramIntent.toString());
      localIntent.putExtra("webStyle", "noBottomBar");
      break label292;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.notification.StoryMsgNotificationReceiver
 * JD-Core Version:    0.7.0.1
 */