package com.tencent.mobileqq.activity.aio.tips;

import aimj;
import aimo;
import android.widget.Toast;
import awhv;
import bcst;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class TroopAssistTipsBar$1
  implements Runnable
{
  public TroopAssistTipsBar$1(aimo paramaimo) {}
  
  public void run()
  {
    if ((aimo.a(this.this$0).b(aimo.a(this.this$0).a) != 2) && (aimo.a(this.this$0).b(aimo.a(this.this$0).a) != 3)) {}
    do
    {
      do
      {
        return;
        if (awhv.a().c(aimo.a(this.this$0), aimo.a(this.this$0).a)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopAssistTipsBar", 2, "getTroopAssistTipInRange false, return ");
      return;
      if (this.this$0.a != null) {
        this.this$0.a.cancel();
      }
    } while (!aimo.a(this.this$0).a(this.this$0, new Object[0]));
    awhv.a().c(aimo.a(this.this$0), aimo.a(this.this$0).a);
    bcst.b(aimo.a(this.this$0), "CliOper", "", "", "Grp_helper", "Aio_grp_banner", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.TroopAssistTipsBar.1
 * JD-Core Version:    0.7.0.1
 */