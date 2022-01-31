package com.tencent.biz.qqcircle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import axho;
import com.tencent.biz.qqcircle.events.QCircleFollowUpdateEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import txt;
import txu;
import yej;

public class QCircleGlobalBroadcastHelper$QCircleGlobalBroadcastReceiver
  extends BroadcastReceiver
{
  public QCircleGlobalBroadcastHelper$QCircleGlobalBroadcastReceiver(QCircleGlobalBroadcastHelper paramQCircleGlobalBroadcastHelper) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramContext = paramIntent.getAction();
    QLog.d(QCircleGlobalBroadcastHelper.a(), 1, "onReceive action" + paramContext);
    if (TextUtils.equals(paramContext, "action_clear_message_red_poiont")) {}
    int i;
    do
    {
      do
      {
        do
        {
          try
          {
            i = paramIntent.getIntExtra("createTime", 0);
            QLog.d(QCircleGlobalBroadcastHelper.a(), 1, "ACTION_CLEAR_MESSAGE_RED_POIONT createTime:" + i);
            paramContext = (axho)BaseApplicationImpl.getApplication().getRuntime().getManager(36);
            paramContext.a(paramContext.a("140000"), 9, "");
            ThreadManager.getSubThreadHandler().postDelayed(new QCircleGlobalBroadcastHelper.QCircleGlobalBroadcastReceiver.1(this), 5000L);
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
        if (i == 1) {}
        for (;;)
        {
          txt.a().a(paramContext, bool1);
          yej.a().a(new QCircleFollowUpdateEvent(i, paramContext));
          return;
          bool1 = false;
        }
      } while (!TextUtils.equals(paramContext, "action_update_native_tag_follow_state"));
      paramContext = paramIntent.getStringExtra("tagId");
      i = paramIntent.getIntExtra("type", -1);
    } while ((TextUtils.isEmpty(paramContext)) || (i == -1));
    QLog.d(QCircleGlobalBroadcastHelper.a(), 1, "updateTagFollowManager tagId:" + paramContext + " type:" + i);
    if (i == 1) {}
    for (bool1 = bool2;; bool1 = false)
    {
      txu.a().a(paramContext, bool1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCircleGlobalBroadcastHelper.QCircleGlobalBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */