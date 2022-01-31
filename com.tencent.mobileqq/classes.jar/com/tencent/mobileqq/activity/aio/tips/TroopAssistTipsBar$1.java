package com.tencent.mobileqq.activity.aio.tips;

import aeyv;
import aeza;
import android.widget.Toast;
import asfd;
import axqy;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class TroopAssistTipsBar$1
  implements Runnable
{
  public TroopAssistTipsBar$1(aeza paramaeza) {}
  
  public void run()
  {
    if ((aeza.a(this.this$0).b(aeza.a(this.this$0).a) != 2) && (aeza.a(this.this$0).b(aeza.a(this.this$0).a) != 3)) {}
    do
    {
      do
      {
        return;
        if (asfd.a().c(aeza.a(this.this$0), aeza.a(this.this$0).a)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopAssistTipsBar", 2, "getTroopAssistTipInRange false, return ");
      return;
      if (this.this$0.a != null) {
        this.this$0.a.cancel();
      }
    } while (!aeza.a(this.this$0).a(this.this$0, new Object[0]));
    asfd.a().c(aeza.a(this.this$0), aeza.a(this.this$0).a);
    axqy.b(aeza.a(this.this$0), "CliOper", "", "", "Grp_helper", "Aio_grp_banner", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.TroopAssistTipsBar.1
 * JD-Core Version:    0.7.0.1
 */