package com.tencent.biz.qqcircle;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants._InvitationWebViewPlugin;
import com.tencent.biz.qqcircle.events.QCircleFeedListRefreshEvent;
import com.tencent.biz.qqcircle.events.QCirclePopWindowUpdateBalanceEvent;
import com.tencent.biz.qqcircle.manager.QCircleTagFollowManager;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeInfoManger;
import com.tencent.biz.qqcircle.utils.QCircleBindPhoneNumberHelper;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qcircle.api.event.QCircleFollowUpdateEvent;
import com.tencent.mobileqq.qcircle.api.event.QCircleRefreshHippyPageEvent;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleFollowManager;
import cooperation.qqcircle.relation.QCircleRelationGroupManager;

public class QCircleGlobalBroadcastHelper$QCircleGlobalBroadcastReceiver
  extends BroadcastReceiver
{
  public QCircleGlobalBroadcastHelper$QCircleGlobalBroadcastReceiver(QCircleGlobalBroadcastHelper paramQCircleGlobalBroadcastHelper) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    Object localObject = QCircleGlobalBroadcastHelper.e();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReceive action");
    localStringBuilder.append(paramContext);
    QLog.d((String)localObject, 1, localStringBuilder.toString());
    boolean bool3 = TextUtils.equals(paramContext, "action_clear_message_red_poiont");
    boolean bool2 = false;
    boolean bool1 = false;
    int i;
    if (bool3) {
      try
      {
        i = paramIntent.getIntExtra("createTime", 0);
        paramContext = QCircleGlobalBroadcastHelper.e();
        paramIntent = new StringBuilder();
        paramIntent.append("ACTION_CLEAR_MESSAGE_RED_POIONT createTime:");
        paramIntent.append(i);
        QLog.d(paramContext, 1, paramIntent.toString());
        this.a.d();
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
    }
    if (TextUtils.equals(paramContext, "action_update_native_user_follow_state"))
    {
      paramContext = paramIntent.getStringExtra("uin");
      i = paramIntent.getIntExtra("type", -1);
      if ((!TextUtils.isEmpty(paramContext)) && (i != -1))
      {
        localObject = QCircleGlobalBroadcastHelper.e();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateFollowManager uin:");
        localStringBuilder.append(paramContext);
        localStringBuilder.append(" type:");
        localStringBuilder.append(i);
        QLog.d((String)localObject, 1, localStringBuilder.toString());
        if (i == 1) {
          bool1 = true;
        }
        QCircleFollowManager.getInstance().setUinFollowed(paramContext, i);
        SimpleEventBus.getInstance().dispatchEvent(new QCircleFollowUpdateEvent(i, paramContext));
        paramIntent = paramIntent.getStringExtra("nick");
        QCircleRelationGroupManager.instance().updateFollowFriendListToDB(paramContext, paramIntent, bool1);
      }
    }
    else if (TextUtils.equals(paramContext, "action_update_native_tag_follow_state"))
    {
      paramContext = paramIntent.getStringExtra("tagId");
      i = paramIntent.getIntExtra("type", -1);
      if ((!TextUtils.isEmpty(paramContext)) && (i != -1))
      {
        paramIntent = QCircleGlobalBroadcastHelper.e();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateTagFollowManager tagId:");
        ((StringBuilder)localObject).append(paramContext);
        ((StringBuilder)localObject).append(" type:");
        ((StringBuilder)localObject).append(i);
        QLog.d(paramIntent, 1, ((StringBuilder)localObject).toString());
        bool1 = bool2;
        if (i == 1) {
          bool1 = true;
        }
        QCircleTagFollowManager.a().a(paramContext, bool1);
      }
    }
    else
    {
      if (TextUtils.equals(paramContext, "action_receive_message_push")) {
        return;
      }
      if (TextUtils.equals(paramContext, "action_refresh_feed_list"))
      {
        if ("focus".equals(paramIntent.getStringExtra("pageType"))) {
          SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedListRefreshEvent(1));
        }
      }
      else
      {
        if (TextUtils.equals(paramContext, "action_refresh_hippy_page"))
        {
          paramContext = paramIntent.getStringExtra("pageType");
          SimpleEventBus.getInstance().dispatchEvent(new QCircleRefreshHippyPageEvent(paramContext));
          return;
        }
        if (TextUtils.equals(paramContext, QCircleHostConstants._InvitationWebViewPlugin.AUTHORITY_ACTION()))
        {
          QCircleBindPhoneNumberHelper.a(true);
          return;
        }
        if (TextUtils.equals(paramContext, "action_update_native_balance"))
        {
          paramContext = paramIntent.getStringExtra("uin");
          i = paramIntent.getIntExtra("balance", (int)QCirclePolyLikeInfoManger.a().c());
          paramIntent = new StringBuilder();
          paramIntent.append("onReceive BroadCast:");
          paramIntent.append(i);
          QLog.d("QCirclePolymorphicLikePopWindow", 1, paramIntent.toString());
          SimpleEventBus.getInstance().dispatchEvent(new QCirclePopWindowUpdateBalanceEvent(paramContext, i));
          return;
        }
        if (TextUtils.equals(paramContext, "action_receive_js_request")) {
          return;
        }
        if (TextUtils.equals(paramContext, "action_confirm_school_name"))
        {
          QCircleGlobalBroadcastHelper.a(this.a, paramIntent);
          return;
        }
        if (TextUtils.equals(paramContext, "action_get_lbs_location"))
        {
          QCircleGlobalBroadcastHelper.b(this.a, paramIntent);
          return;
        }
        if (TextUtils.equals(paramContext, "report_share_qq_to_forward_result"))
        {
          QCircleGlobalBroadcastHelper.c(this.a, paramIntent);
          return;
        }
        if (TextUtils.equals(paramContext, "report_share_qq_to_recently_click")) {
          QCircleGlobalBroadcastHelper.d(this.a, paramIntent);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCircleGlobalBroadcastHelper.QCircleGlobalBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */