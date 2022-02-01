package com.tencent.mobileqq.activity.aio.tips;

import ahqs;
import ahqx;
import android.widget.Toast;
import avnu;
import bcef;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class TroopAssistTipsBar$1
  implements Runnable
{
  public TroopAssistTipsBar$1(ahqx paramahqx) {}
  
  public void run()
  {
    if ((ahqx.a(this.this$0).getTroopMask(ahqx.a(this.this$0).curFriendUin) != 2) && (ahqx.a(this.this$0).getTroopMask(ahqx.a(this.this$0).curFriendUin) != 3)) {}
    do
    {
      do
      {
        return;
        if (avnu.a().c(ahqx.a(this.this$0), ahqx.a(this.this$0).curFriendUin)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopAssistTipsBar", 2, "getTroopAssistTipInRange false, return ");
      return;
      if (this.this$0.a != null) {
        this.this$0.a.cancel();
      }
    } while (!ahqx.a(this.this$0).a(this.this$0, new Object[0]));
    avnu.a().c(ahqx.a(this.this$0), ahqx.a(this.this$0).curFriendUin);
    bcef.b(ahqx.a(this.this$0), "CliOper", "", "", "Grp_helper", "Aio_grp_banner", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.TroopAssistTipsBar.1
 * JD-Core Version:    0.7.0.1
 */