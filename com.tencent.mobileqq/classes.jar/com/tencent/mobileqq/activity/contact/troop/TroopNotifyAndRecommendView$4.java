package com.tencent.mobileqq.activity.contact.troop;

import android.os.Message;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class TroopNotifyAndRecommendView$4
  extends MqqHandler
{
  TroopNotifyAndRecommendView$4(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      TroopNotifyAndRecommendView.d(this.a);
      return;
      this.a.j();
      return;
      paramMessage = paramMessage.obj;
      try
      {
        this.a.a((List)paramMessage);
        TroopNotifyAndRecommendView.e(this.a);
        return;
      }
      catch (Exception paramMessage)
      {
        for (;;)
        {
          QLog.e("TroopNotifyAndRecommendView", 1, "handleRecommendData wrong");
        }
      }
    } while (this.a.a == null);
    this.a.a.c(2131719050);
    this.a.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.4
 * JD-Core Version:    0.7.0.1
 */