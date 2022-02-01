package com.tencent.mobileqq.activity.recent.msgbox.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.msgbox.RecentUserCacheHelper;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class TempGameMsgSettingReceiver
  extends BroadcastReceiver
{
  private QQAppInterface a;
  
  public TempGameMsgSettingReceiver(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public String a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return "";
        }
        return "0X800BB93";
      }
      return "0X800BB92";
    }
    return "0X800BB91";
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onReceiver] action:");
      localStringBuilder.append(paramContext);
      QLog.d("TempGameMsgSettingReceiver", 2, localStringBuilder.toString());
    }
    if (paramContext != null)
    {
      if (!paramContext.equals("action_qgame_toggle_change")) {
        return;
      }
      int i = paramIntent.getIntExtra("key_msg_change_type_id", 1);
      paramContext = paramIntent.getStringExtra("key_msg_change_game_id");
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("type = [");
        paramIntent.append(i);
        paramIntent.append("], gameId = [");
        paramIntent.append(paramContext);
        paramIntent.append("]");
        QLog.d("TempGameMsgSettingReceiver", 2, paramIntent.toString());
      }
      if (TextUtils.isEmpty(paramContext)) {
        return;
      }
      new RecentUserCacheHelper().a(this.a);
      ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).removeMsgBoxIfNecessary(this.a, true);
      paramIntent = a(i);
      if (!TextUtils.isEmpty(paramIntent)) {
        ReportController.b(this.a, "dc00898", "", "", paramIntent, paramIntent, 0, 0, "", "", "", paramContext);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.receiver.TempGameMsgSettingReceiver
 * JD-Core Version:    0.7.0.1
 */