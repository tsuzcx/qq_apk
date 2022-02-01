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
import com.tencent.biz.qqstory.playvideo.StoryPlayerLauncher;
import com.tencent.biz.qqstory.playvideo.entrance.SingleFeedPlayInfo;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class StoryMsgNotificationReceiver
  extends BroadcastReceiver
{
  public static final Intent a(Context paramContext)
  {
    ((QQStoryActivityManager)SuperManager.a(18)).c();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getMainIntent() isNowTabAdded = ");
      localStringBuilder.append(NowLiveManager.j);
      QLog.w("Q.qqstory.protocol", 2, localStringBuilder.toString());
    }
    if (NowLiveManager.j)
    {
      paramContext = new Intent(paramContext, SplashActivity.class);
      paramContext.putExtra("fragment_id", 1);
      paramContext.putExtra("tab_index", FrameControllerUtil.f);
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
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("MsgNotificationReceiver action: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("zivonchen", 2, ((StringBuilder)localObject2).toString());
    }
    int i;
    if ("com.tencent.biz.qqstory.notification.qqstory_delete_notify".equals(localObject1))
    {
      i = paramIntent.getIntExtra("push_type", 0);
      StoryMsgNotification.a().a(paramContext, i);
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("delete type = ");
        paramContext.append(i);
        QLog.d("zivonchen", 2, paramContext.toString());
      }
    }
    else if ("com.tencent.biz.qqstory.notification.qqstory_jump_activity_notify".equals(localObject1))
    {
      localObject1 = (StoryPushMsg)paramIntent.getParcelableExtra("storyPushMsg");
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("onReceive() jumpActivity pushMsg = ");
        paramIntent.append(localObject1);
        QLog.w("Q.qqstory.protocol", 2, paramIntent.toString());
      }
      localObject2 = a(paramContext);
      i = ((StoryPushMsg)localObject1).a;
      if (i != 3)
      {
        if (i != 5)
        {
          if (i == 6) {
            break label679;
          }
          if (i == 46) {
            break label658;
          }
          if (i == 47) {
            break label590;
          }
          switch (i)
          {
          default: 
            switch (i)
            {
            }
            break;
          }
        }
        for (;;)
        {
          break;
          paramIntent = new StringBuilder("https://story.now.qq.com/m/score/index.html?_wv=3&_nav_alpha=0");
          paramIntent.append("&vid=");
          paramIntent.append(((StoryPushMsg)localObject1).h);
          ((Intent)localObject2).putExtra("action", 10);
          ((Intent)localObject2).putExtra("url", paramIntent.toString());
          ((Intent)localObject2).putExtra("webStyle", "noBottomBar");
          continue;
          paramIntent = new StringBuilder("https://story.now.qq.com/m/vote/index.html?_wv=3&_nav_alpha=0");
          paramIntent.append("&vid=");
          paramIntent.append(((StoryPushMsg)localObject1).h);
          ((Intent)localObject2).putExtra("action", 10);
          ((Intent)localObject2).putExtra("url", paramIntent.toString());
          ((Intent)localObject2).putExtra("webStyle", "noBottomBar");
          continue;
          ((Intent)localObject2).putExtra("action", 10);
          ((Intent)localObject2).putExtra("url", ((StoryPushMsg)localObject1).m.getString("link"));
          ((Intent)localObject2).putExtra("webStyle", "noBottomBar");
          continue;
          ((Intent)localObject2).putExtra("action", 6);
          ((Intent)localObject2).putExtra("user_type", ((StoryPushMsg)localObject1).m.getInt("pgc_type"));
          ((Intent)localObject2).putExtra("user_unionid", ((StoryPushMsg)localObject1).m.getString("pgc_column_union_id"));
          ((Intent)localObject2).putExtra("come_from", 29);
          continue;
          ((Intent)localObject2).putExtra("action", 7);
          ((Intent)localObject2).putExtra("EXTRA_USER_UIN", ((StoryPushMsg)localObject1).m.getString("big_v_id"));
          ((Intent)localObject2).putExtra("EXTRA_USER_UNION_ID", ((StoryPushMsg)localObject1).m.getString("big_v_union_id"));
          ((Intent)localObject2).putExtra("extra_share_from_type", 31);
          continue;
          ((Intent)localObject2).putExtra("action", 1);
          continue;
          label590:
          ((Intent)localObject2).putExtra("action", 8);
          ((Intent)localObject2).putExtra("pushType", i);
          ((Intent)localObject2).putExtra("extra_feedid", ((StoryPushMsg)localObject1).f);
          StoryReportor.a("notice_msg", "clk_notice", 0, 0, new String[] { "", "", "", "" });
        }
        label658:
        StoryPlayerLauncher.b(paramContext, ((StoryPushMsg)localObject1).h, ((StoryPushMsg)localObject1).f, 29);
      }
      for (;;)
      {
        i = 1;
        break label885;
        label679:
        ((Intent)localObject2).putExtra("action", 4);
        ((Intent)localObject2).putExtra("extra_topic_id", ((StoryPushMsg)localObject1).m.getLong("hot_topic_id"));
        ((Intent)localObject2).putExtra("extra_topic_name", ((StoryPushMsg)localObject1).m.getString("hot_topic_name"));
        ((Intent)localObject2).putExtra("extra_share_from_type", 31);
        break;
        if (!((MsgTabStoryNodeConfigManager)QQStoryContext.j().getManager(QQManagerFactory.MSG_TAB_STORY_CONFIG_MANAGER)).a) {
          break label806;
        }
        StoryPlayerLauncher.a(paramContext, ((StoryPushMsg)localObject1).f, ((StoryPushMsg)localObject1).h);
        StoryReportor.a("notice_msg", "care_android", 0, 0, new String[] { "", "", "", "" });
      }
      label806:
      ((Intent)localObject2).putExtra("EXTRA_PLAY_INFO", new SingleFeedPlayInfo(((StoryPushMsg)localObject1).f, ((StoryPushMsg)localObject1).f, ((StoryPushMsg)localObject1).h, 1, true));
      ((Intent)localObject2).putExtra("action", 9);
      StoryReportor.a("notice_msg", "care_android", 0, 0, new String[] { "", "", "", "" });
      i = 0;
      label885:
      if ((((StoryPushMsg)localObject1).a != 3) && (((StoryPushMsg)localObject1).a != 9)) {
        paramIntent = "";
      } else {
        paramIntent = String.valueOf(((StoryPushMsg)localObject1).d);
      }
      if (TextUtils.isEmpty(((StoryPushMsg)localObject1).b)) {
        localObject1 = "9999";
      } else {
        localObject1 = ((StoryPushMsg)localObject1).b;
      }
      StoryReportor.a("notice_msg", "clk_push", 0, 0, new String[] { localObject1, paramIntent, "", "" });
      if ((i == 0) && (localObject2 != null))
      {
        ((Intent)localObject2).addFlags(268435456);
        paramContext.startActivity((Intent)localObject2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.notification.StoryMsgNotificationReceiver
 * JD-Core Version:    0.7.0.1
 */