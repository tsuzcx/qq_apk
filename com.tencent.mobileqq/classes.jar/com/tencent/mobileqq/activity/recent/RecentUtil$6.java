package com.tencent.mobileqq.activity.recent;

import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class RecentUtil$6
  implements Runnable
{
  RecentUtil$6(QQAppInterface paramQQAppInterface, String paramString, int paramInt) {}
  
  public void run()
  {
    Message localMessage = this.a.getMessageFacade().getLastMessage(this.b, 1008);
    String str2 = "0";
    if (localMessage != null)
    {
      str1 = localMessage.getExtInfoFromExtStr("gdt_msgClick");
      if (TextUtils.isEmpty(str1)) {}
    }
    try
    {
      localObject = new JSONObject(str1);
      str1 = str2;
      if (!((JSONObject)localObject).has("ad_id")) {
        break label90;
      }
      str1 = ((JSONObject)localObject).getString("ad_id");
    }
    catch (Exception localException)
    {
      Object localObject;
      label72:
      QQAppInterface localQQAppInterface;
      StringBuilder localStringBuilder;
      break label72;
    }
    String str1 = str2;
    if (QLog.isColorLevel())
    {
      QLog.i("Q.recent", 2, "from_enterchat");
      str1 = str2;
    }
    label90:
    localObject = localMessage.getExtInfoFromExtStr("pa_msgId");
    if (this.c == 1) {
      str2 = "0X8005C36";
    } else {
      str2 = "0X8005C39";
    }
    localQQAppInterface = this.a;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(localMessage.frienduin);
    ReportController.b(localQQAppInterface, "P_CliOper", "Pb_account_lifeservice", localStringBuilder.toString(), str2, str2, 0, 1, 0, (String)localObject, String.valueOf(NetConnInfoCenter.getServerTime() * 1000L), "", str1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentUtil.6
 * JD-Core Version:    0.7.0.1
 */