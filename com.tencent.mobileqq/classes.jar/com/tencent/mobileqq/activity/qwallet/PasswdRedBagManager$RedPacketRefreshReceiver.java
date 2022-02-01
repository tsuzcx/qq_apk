package com.tencent.mobileqq.activity.qwallet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class PasswdRedBagManager$RedPacketRefreshReceiver
  extends BroadcastReceiver
{
  private PasswdRedBagManager$RedPacketRefreshReceiver(PasswdRedBagManager paramPasswdRedBagManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i;
    String str1;
    String str2;
    int j;
    String str3;
    PasswdRedBagInfo localPasswdRedBagInfo;
    if ("grap_idiom_hb_result_action".equals(paramIntent.getAction()))
    {
      i = paramIntent.getIntExtra("grap_hb_state", 0);
      paramContext = paramIntent.getStringExtra("listid");
      str1 = paramIntent.getStringExtra("grap_hb_frienduin");
      str2 = paramIntent.getStringExtra("grap_hb_idiom");
      j = paramIntent.getIntExtra("grap_hb_seq", 0);
      str3 = paramIntent.getStringExtra("grap_idiom_alpha");
      paramIntent = paramIntent.getStringExtra("grap_poem_rule");
      localPasswdRedBagInfo = this.a.a(paramContext);
      QLog.i("PasswdRedBagManager", 1, "grapHbState=" + i + ",passwdRedBagInfo=" + localPasswdRedBagInfo);
      if ((i != 1) && (i != 10)) {
        break label136;
      }
      PasswdRedBagManager.a(this.a, paramContext, str1, 1, true);
    }
    label136:
    do
    {
      do
      {
        do
        {
          return;
          if (i != 12) {
            break;
          }
        } while (localPasswdRedBagInfo == null);
        PasswdRedBagManager.a(this.a, paramContext, str1, 1, false);
        this.a.a(paramContext, str2, str3, j, paramIntent);
        return;
        if (i != 0) {
          break;
        }
      } while (localPasswdRedBagInfo.a() != 2);
      PasswdRedBagManager.a(this.a, paramContext, str1, 1, true);
      return;
    } while ((i != 14) || (localPasswdRedBagInfo == null));
    this.a.a(paramContext, str2, str3, j, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager.RedPacketRefreshReceiver
 * JD-Core Version:    0.7.0.1
 */