package com.tencent.biz.qqcircle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.events.QCircleFeedListRefreshEvent;
import com.tencent.biz.qqcircle.events.QCircleFollowUpdateEvent;
import com.tencent.biz.qqcircle.events.QCircleRefreshHippyPageEvent;
import com.tencent.qphone.base.util.QLog;
import vof;
import vot;
import vtj;
import zwp;

public class QCircleGlobalBroadcastHelper$QCircleGlobalBroadcastReceiver
  extends BroadcastReceiver
{
  public QCircleGlobalBroadcastHelper$QCircleGlobalBroadcastReceiver(QCircleGlobalBroadcastHelper paramQCircleGlobalBroadcastHelper) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    paramContext = paramIntent.getAction();
    QLog.d(QCircleGlobalBroadcastHelper.a(), 1, "onReceive action" + paramContext);
    if (TextUtils.equals(paramContext, "action_clear_message_red_poiont")) {}
    label242:
    do
    {
      do
      {
        do
        {
          int i;
          do
          {
            do
            {
              try
              {
                i = paramIntent.getIntExtra("createTime", 0);
                QLog.d(QCircleGlobalBroadcastHelper.a(), 1, "ACTION_CLEAR_MESSAGE_RED_POIONT createTime:" + i);
                this.a.c();
                return;
              }
              catch (Exception paramContext)
              {
                paramContext.printStackTrace();
                return;
              }
              if (!TextUtils.equals(paramContext, "action_update_native_user_follow_state")) {
                break;
              }
              paramContext = paramIntent.getStringExtra("uin");
              i = paramIntent.getIntExtra("type", -1);
            } while ((TextUtils.isEmpty(paramContext)) || (i == -1));
            QLog.d(QCircleGlobalBroadcastHelper.a(), 1, "updateFollowManager uin:" + paramContext + " type:" + i);
            vtj localvtj;
            if (i == 1)
            {
              bool1 = true;
              vof.a().a(paramContext, bool1);
              zwp.a().a(new QCircleFollowUpdateEvent(i, paramContext));
              i = paramIntent.getIntExtra("isDoubly", 0);
              paramIntent = paramIntent.getStringExtra("nick");
              localvtj = vtj.a();
              if (i != 1) {
                break label242;
              }
            }
            for (bool1 = bool2;; bool1 = false)
            {
              localvtj.a(paramContext, paramIntent, bool1);
              return;
              bool1 = false;
              break;
            }
            if (!TextUtils.equals(paramContext, "action_update_native_tag_follow_state")) {
              break;
            }
            paramContext = paramIntent.getStringExtra("tagId");
            i = paramIntent.getIntExtra("type", -1);
          } while ((TextUtils.isEmpty(paramContext)) || (i == -1));
          QLog.d(QCircleGlobalBroadcastHelper.a(), 1, "updateTagFollowManager tagId:" + paramContext + " type:" + i);
          if (i == 1) {}
          for (;;)
          {
            vot.a().a(paramContext, bool1);
            return;
            bool1 = false;
          }
        } while (TextUtils.equals(paramContext, "action_receive_message_push"));
        if (!TextUtils.equals(paramContext, "action_refresh_feed_list")) {
          break;
        }
      } while (!"focus".equals(paramIntent.getStringExtra("pageType")));
      zwp.a().a(new QCircleFeedListRefreshEvent(1));
      return;
    } while (!TextUtils.equals(paramContext, "action_refresh_hippy_page"));
    paramContext = paramIntent.getStringExtra("pageType");
    zwp.a().a(new QCircleRefreshHippyPageEvent(paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCircleGlobalBroadcastHelper.QCircleGlobalBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */