package com.tencent.mobileqq.activity;

import bcvc;
import bdla;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class Leba$7
  implements Runnable
{
  Leba$7(Leba paramLeba, long paramLong) {}
  
  public void run()
  {
    bcvc localbcvc = (bcvc)this.this$0.a.getManager(QQManagerFactory.GAMECENTER_MANAGER);
    if ((localbcvc != null) && ((localbcvc.a(601L)) || ((this.a > 0L) && (localbcvc.a(this.a))))) {
      bdla.b(this.this$0.a, "CliOper", "", "", "app_center", "new_exposure", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.7
 * JD-Core Version:    0.7.0.1
 */