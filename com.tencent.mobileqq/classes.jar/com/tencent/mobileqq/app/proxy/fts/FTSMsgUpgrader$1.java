package com.tencent.mobileqq.app.proxy.fts;

import aktb;
import aktj;
import aktk;
import aktm;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.fts.FTSDatatbase;
import com.tencent.qphone.base.util.QLog;

public class FTSMsgUpgrader$1
  implements Runnable
{
  public FTSMsgUpgrader$1(aktk paramaktk) {}
  
  public void run()
  {
    if ((!aktk.a(this.this$0)) && (aktk.a(this.this$0).a().a())) {
      if ((aktk.a(this.this$0) != null) && (aktk.a(this.this$0).a()))
      {
        if (!this.this$0.a) {
          aktk.a(this.this$0);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.fts.FTSMsgUpgrader", 2, "upgrade history in handle hasReadNativeCursor = " + this.this$0.a + " mUpgradeCursor=" + aktk.a(this.this$0) + " mUpgradeMaxIndex=" + aktk.b(this.this$0));
        }
        if (this.this$0.a)
        {
          if (aktk.a(this.this$0) >= aktk.b(this.this$0)) {
            break label201;
          }
          if (!aktk.b(this.this$0)) {
            break label186;
          }
        }
      }
    }
    label186:
    label201:
    while (!QLog.isColorLevel())
    {
      do
      {
        aktk.a(this.this$0).postDelayed(this, 20L);
        do
        {
          return;
        } while (!QLog.isColorLevel());
        QLog.d("Q.fts.FTSMsgUpgrader", 2, "writeNativeIndex failed");
        return;
        if (QLog.isColorLevel()) {
          QLog.d("Q.fts.FTSMsgUpgrader", 2, "upgrade compeleted in handler");
        }
        aktk.b(this.this$0);
        aktk.a(this.this$0).c();
        return;
      } while (!QLog.isColorLevel());
      StringBuilder localStringBuilder = new StringBuilder().append("upgrade history in handle mDatabase = ");
      if (aktk.a(this.this$0) == null) {}
      for (String str = "null";; str = "@@@")
      {
        QLog.d("Q.fts.FTSMsgUpgrader", 2, str);
        return;
      }
    }
    QLog.d("Q.fts.FTSMsgUpgrader", 2, "upgrade history in handle isDestroy = " + aktk.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.fts.FTSMsgUpgrader.1
 * JD-Core Version:    0.7.0.1
 */