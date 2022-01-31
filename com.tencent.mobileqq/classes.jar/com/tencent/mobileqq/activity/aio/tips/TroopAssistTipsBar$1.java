package com.tencent.mobileqq.activity.aio.tips;

import aeob;
import aeog;
import android.widget.Toast;
import ariz;
import awqx;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class TroopAssistTipsBar$1
  implements Runnable
{
  public TroopAssistTipsBar$1(aeog paramaeog) {}
  
  public void run()
  {
    if ((aeog.a(this.this$0).b(aeog.a(this.this$0).a) != 2) && (aeog.a(this.this$0).b(aeog.a(this.this$0).a) != 3)) {}
    do
    {
      do
      {
        return;
        if (ariz.a().c(aeog.a(this.this$0), aeog.a(this.this$0).a)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopAssistTipsBar", 2, "getTroopAssistTipInRange false, return ");
      return;
      if (this.this$0.a != null) {
        this.this$0.a.cancel();
      }
    } while (!aeog.a(this.this$0).a(this.this$0, new Object[0]));
    ariz.a().c(aeog.a(this.this$0), aeog.a(this.this$0).a);
    awqx.b(aeog.a(this.this$0), "CliOper", "", "", "Grp_helper", "Aio_grp_banner", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.TroopAssistTipsBar.1
 * JD-Core Version:    0.7.0.1
 */