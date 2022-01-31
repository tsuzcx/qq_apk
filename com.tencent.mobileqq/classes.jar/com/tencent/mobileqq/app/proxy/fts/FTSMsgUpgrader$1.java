package com.tencent.mobileqq.app.proxy.fts;

import akta;
import akti;
import aktj;
import aktl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.fts.FTSDatatbase;
import com.tencent.qphone.base.util.QLog;

public class FTSMsgUpgrader$1
  implements Runnable
{
  public FTSMsgUpgrader$1(aktj paramaktj) {}
  
  public void run()
  {
    if ((!aktj.a(this.this$0)) && (aktj.a(this.this$0).a().a())) {
      if ((aktj.a(this.this$0) != null) && (aktj.a(this.this$0).a()))
      {
        if (!this.this$0.a) {
          aktj.a(this.this$0);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.fts.FTSMsgUpgrader", 2, "upgrade history in handle hasReadNativeCursor = " + this.this$0.a + " mUpgradeCursor=" + aktj.a(this.this$0) + " mUpgradeMaxIndex=" + aktj.b(this.this$0));
        }
        if (this.this$0.a)
        {
          if (aktj.a(this.this$0) >= aktj.b(this.this$0)) {
            break label201;
          }
          if (!aktj.b(this.this$0)) {
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
        aktj.a(this.this$0).postDelayed(this, 20L);
        do
        {
          return;
        } while (!QLog.isColorLevel());
        QLog.d("Q.fts.FTSMsgUpgrader", 2, "writeNativeIndex failed");
        return;
        if (QLog.isColorLevel()) {
          QLog.d("Q.fts.FTSMsgUpgrader", 2, "upgrade compeleted in handler");
        }
        aktj.b(this.this$0);
        aktj.a(this.this$0).c();
        return;
      } while (!QLog.isColorLevel());
      StringBuilder localStringBuilder = new StringBuilder().append("upgrade history in handle mDatabase = ");
      if (aktj.a(this.this$0) == null) {}
      for (String str = "null";; str = "@@@")
      {
        QLog.d("Q.fts.FTSMsgUpgrader", 2, str);
        return;
      }
    }
    QLog.d("Q.fts.FTSMsgUpgrader", 2, "upgrade history in handle isDestroy = " + aktj.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.fts.FTSMsgUpgrader.1
 * JD-Core Version:    0.7.0.1
 */