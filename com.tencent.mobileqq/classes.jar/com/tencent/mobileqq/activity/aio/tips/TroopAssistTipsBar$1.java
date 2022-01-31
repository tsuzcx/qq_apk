package com.tencent.mobileqq.activity.aio.tips;

import agwa;
import agwf;
import android.widget.Toast;
import atwd;
import azmj;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class TroopAssistTipsBar$1
  implements Runnable
{
  public TroopAssistTipsBar$1(agwf paramagwf) {}
  
  public void run()
  {
    if ((agwf.a(this.this$0).b(agwf.a(this.this$0).a) != 2) && (agwf.a(this.this$0).b(agwf.a(this.this$0).a) != 3)) {}
    do
    {
      do
      {
        return;
        if (atwd.a().c(agwf.a(this.this$0), agwf.a(this.this$0).a)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopAssistTipsBar", 2, "getTroopAssistTipInRange false, return ");
      return;
      if (this.this$0.a != null) {
        this.this$0.a.cancel();
      }
    } while (!agwf.a(this.this$0).a(this.this$0, new Object[0]));
    atwd.a().c(agwf.a(this.this$0), agwf.a(this.this$0).a);
    azmj.b(agwf.a(this.this$0), "CliOper", "", "", "Grp_helper", "Aio_grp_banner", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.TroopAssistTipsBar.1
 * JD-Core Version:    0.7.0.1
 */