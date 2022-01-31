package com.tencent.mobileqq.app.proxy.fts;

import amnu;
import amoc;
import amod;
import amof;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.fts.FTSDatatbase;
import com.tencent.qphone.base.util.QLog;

public class FTSMsgUpgrader$1
  implements Runnable
{
  public FTSMsgUpgrader$1(amod paramamod) {}
  
  public void run()
  {
    if ((!amod.a(this.this$0)) && (amod.a(this.this$0).a().a())) {
      if ((amod.a(this.this$0) != null) && (amod.a(this.this$0).a()))
      {
        if (!this.this$0.a) {
          amod.a(this.this$0);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.fts.FTSMsgUpgrader", 2, "upgrade history in handle hasReadNativeCursor = " + this.this$0.a + " mUpgradeCursor=" + amod.a(this.this$0) + " mUpgradeMaxIndex=" + amod.b(this.this$0));
        }
        if (this.this$0.a)
        {
          if (amod.a(this.this$0) >= amod.b(this.this$0)) {
            break label201;
          }
          if (!amod.b(this.this$0)) {
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
        amod.a(this.this$0).postDelayed(this, 20L);
        do
        {
          return;
        } while (!QLog.isColorLevel());
        QLog.d("Q.fts.FTSMsgUpgrader", 2, "writeNativeIndex failed");
        return;
        if (QLog.isColorLevel()) {
          QLog.d("Q.fts.FTSMsgUpgrader", 2, "upgrade compeleted in handler");
        }
        amod.b(this.this$0);
        amod.a(this.this$0).c();
        return;
      } while (!QLog.isColorLevel());
      StringBuilder localStringBuilder = new StringBuilder().append("upgrade history in handle mDatabase = ");
      if (amod.a(this.this$0) == null) {}
      for (String str = "null";; str = "@@@")
      {
        QLog.d("Q.fts.FTSMsgUpgrader", 2, str);
        return;
      }
    }
    QLog.d("Q.fts.FTSMsgUpgrader", 2, "upgrade history in handle isDestroy = " + amod.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.fts.FTSMsgUpgrader.1
 * JD-Core Version:    0.7.0.1
 */