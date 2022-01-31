package com.tencent.mobileqq.activity.aio.tips;

import ahap;
import ahau;
import android.widget.Toast;
import auam;
import azqs;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class TroopAssistTipsBar$1
  implements Runnable
{
  public TroopAssistTipsBar$1(ahau paramahau) {}
  
  public void run()
  {
    if ((ahau.a(this.this$0).b(ahau.a(this.this$0).a) != 2) && (ahau.a(this.this$0).b(ahau.a(this.this$0).a) != 3)) {}
    do
    {
      do
      {
        return;
        if (auam.a().c(ahau.a(this.this$0), ahau.a(this.this$0).a)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopAssistTipsBar", 2, "getTroopAssistTipInRange false, return ");
      return;
      if (this.this$0.a != null) {
        this.this$0.a.cancel();
      }
    } while (!ahau.a(this.this$0).a(this.this$0, new Object[0]));
    auam.a().c(ahau.a(this.this$0), ahau.a(this.this$0).a);
    azqs.b(ahau.a(this.this$0), "CliOper", "", "", "Grp_helper", "Aio_grp_banner", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.TroopAssistTipsBar.1
 * JD-Core Version:    0.7.0.1
 */