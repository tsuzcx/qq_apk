package com.tencent.mobileqq.activity;

import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import java.util.ArrayList;

class TroopGagActivity$2$1
  implements Runnable
{
  TroopGagActivity$2$1(TroopGagActivity.2 param2, Handler paramHandler) {}
  
  public void run()
  {
    ArrayList localArrayList = ((TroopGagMgr)this.b.a.app.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).b(this.b.a.c, false);
    this.a.post(new TroopGagActivity.2.1.1(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopGagActivity.2.1
 * JD-Core Version:    0.7.0.1
 */