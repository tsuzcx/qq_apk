package com.tencent.biz.qqstory.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.QQStoryActivityManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
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
    Object localObject1 = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "MsgNotificationReceiver action: " + (String)localObject1);
    }
    if ("com.tencent.biz.qqstory.notification.qqstory_delete_notify".equals(localObject1))
    {
      i = paramIntent.getIntExtra("push_type", 0);
      StoryMsgNotification.a().a(paramContext, i);
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "delete type = " + i);
      }
    }
    while (!"com.tencent.biz.qqstory.notification.qqstory_jump_activity_notify".equals(localObject1)) {
      return;
    }
    Object localObject2 = (StoryPushMsg)paramIntent.getParcelableExtra("storyPushMsg");
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.protocol", 2, "onReceive() jumpActivity pushMsg = " + localObject2);
    }
    localObject1 = a(paramContext);
    int i = ((StoryPushMsg)localObject2).jdField_a_of_type_Int;
    paramIntent = (Intent)localObject1;
    switch (i)
    {
    default: 
    case 5: 
    case 12: 
    case 13: 
      for (paramIntent = (Intent)localObject1;; paramIntent = (Intent)localObject1)
      {
        localObject1 = "";
        if ((((StoryPushMsg)localObject2).jdField_a_of_type_Int == 3) || (((StoryPushMsg)localObject2).jdField_a_of_type_Int == 9)) {
          localObject1 = String.valueOf(((StoryPushMsg)localObject2).jdField_a_of_type_Long);
        }
        if (!TextUtils.isEmpty(((StoryPushMsg)localObject2).jdField_a_of_type_JavaLangString)) {
          break label1021;
        }
        localObject2 = "9999";
        StoryReportor.a("notice_msg", "clk_push", 0, 0, new String[] { localObject2, localObject1, "", "" });
        if (paramIntent == null) {
          break;
        }
        paramIntent.addFlags(268435456);
        paramContext.startActivity(paramIntent);
        return;
        ((Intent)localObject1).putExtra("action", 8);
        ((Intent)localObject1).putExtra("pushType", i);
        ((Intent)localObject1).putExtra("extra_feedid", ((StoryPushMsg)localObject2).d);
        StoryReportor.a("notice_msg", "clk_notice", 0, 0, new String[] { "", "", "", "" });
      }
    case 3: 
    case 37: 
    case 39: 
    case 40: 
    case 42: 
      label347:
      if (!((MsgTabStoryNodeConfigManager)QQStoryContext.a().getManager(251)).a) {
        break;
      }
    }
    for (paramIntent = new Intent(paramContext, StoryPlayVideoActivity.class);; paramIntent = (Intent)localObject1)
    {
      paramIntent.putExtra("action", 9);
      paramIntent.putExtra("EXTRA_VIDEO_MODE", 19);
      paramIntent.putExtra("EXTRA_USER_UIN", String.valueOf(((StoryPushMsg)localObject2).jdField_a_of_type_Long));
      paramIntent.putExtra("EXTRA_USER_UNION_ID", ((StoryPushMsg)localObject2).c);
      paramIntent.putExtra("extra_feedid", ((StoryPushMsg)localObject2).d);
      paramIntent.putExtra("extra_vid", ((StoryPushMsg)localObject2).e);
      paramIntent.putExtra("extra_is_use_cache_videolist", false);
      paramIntent.putExtra("extra_pull_type", 1);
      StoryReportor.a("notice_msg", "care_android", 0, 0, new String[] { "", "", "", "" });
      break;
      ((Intent)localObject1).putExtra("action", 4);
      ((Intent)localObject1).putExtra("EXTRA_VIDEO_MODE", 9);
      ((Intent)localObject1).putExtra("extra_topic_id", ((StoryPushMsg)localObject2).jdField_a_of_type_AndroidOsBundle.getLong("hot_topic_id"));
      ((Intent)localObject1).putExtra("extra_topic_name", ((StoryPushMsg)localObject2).jdField_a_of_type_AndroidOsBundle.getString("hot_topic_name"));
      ((Intent)localObject1).putExtra("extra_share_from_type", 31);
      paramIntent = (Intent)localObject1;
      break;
      ((Intent)localObject1).putExtra("action", 1);
      paramIntent = (Intent)localObject1;
      break;
      ((Intent)localObject1).putExtra("action", 7);
      ((Intent)localObject1).putExtra("EXTRA_USER_UIN", ((StoryPushMsg)localObject2).jdField_a_of_type_AndroidOsBundle.getString("big_v_id"));
      ((Intent)localObject1).putExtra("EXTRA_USER_UNION_ID", ((StoryPushMsg)localObject2).jdField_a_of_type_AndroidOsBundle.getString("big_v_union_id"));
      ((Intent)localObject1).putExtra("extra_share_from_type", 31);
      paramIntent = (Intent)localObject1;
      break;
      ((Intent)localObject1).putExtra("action", 6);
      ((Intent)localObject1).putExtra("user_type", ((StoryPushMsg)localObject2).jdField_a_of_type_AndroidOsBundle.getInt("pgc_type"));
      ((Intent)localObject1).putExtra("user_unionid", ((StoryPushMsg)localObject2).jdField_a_of_type_AndroidOsBundle.getString("pgc_column_union_id"));
      ((Intent)localObject1).putExtra("come_from", 29);
      paramIntent = (Intent)localObject1;
      break;
      ((Intent)localObject1).putExtra("action", 10);
      ((Intent)localObject1).putExtra("url", ((StoryPushMsg)localObject2).jdField_a_of_type_AndroidOsBundle.getString("link"));
      ((Intent)localObject1).putExtra("webStyle", "noBottomBar");
      paramIntent = (Intent)localObject1;
      break;
      paramIntent = new StringBuilder("http://story.now.qq.com/m/vote/index.html?_wv=3&_nav_alpha=0");
      paramIntent.append("&vid=").append(((StoryPushMsg)localObject2).e);
      ((Intent)localObject1).putExtra("action", 10);
      ((Intent)localObject1).putExtra("url", paramIntent.toString());
      ((Intent)localObject1).putExtra("webStyle", "noBottomBar");
      paramIntent = (Intent)localObject1;
      break;
      paramIntent = new StringBuilder("http://story.now.qq.com/m/score/index.html?_wv=3&_nav_alpha=0");
      paramIntent.append("&vid=").append(((StoryPushMsg)localObject2).e);
      ((Intent)localObject1).putExtra("action", 10);
      ((Intent)localObject1).putExtra("url", paramIntent.toString());
      ((Intent)localObject1).putExtra("webStyle", "noBottomBar");
      paramIntent = (Intent)localObject1;
      break;
      label1021:
      localObject2 = ((StoryPushMsg)localObject2).jdField_a_of_type_JavaLangString;
      break label347;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.notification.StoryMsgNotificationReceiver
 * JD-Core Version:    0.7.0.1
 */