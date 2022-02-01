package com.tencent.mobileqq.app.proxy.fts;

import aone;
import aonj;
import aonk;
import aonm;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.fts.FTSDatatbase;
import com.tencent.qphone.base.util.QLog;

public class FTSMsgUpgrader$1
  implements Runnable
{
  public FTSMsgUpgrader$1(aonk paramaonk) {}
  
  public void run()
  {
    if ((!aonk.a(this.this$0)) && (aonk.a(this.this$0).a().a()))
    {
      if ((aonk.a(this.this$0) != null) && (aonk.a(this.this$0).a()))
      {
        if (!this.this$0.a) {
          aonk.a(this.this$0);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.fts.FTSMsgUpgrader", 2, "upgrade history in handle hasReadNativeCursor = " + this.this$0.a + " mUpgradeCursor=" + aonk.a(this.this$0) + " mUpgradeMaxIndex=" + aonk.b(this.this$0));
        }
        if (this.this$0.a)
        {
          if (aonk.a(this.this$0) >= aonk.b(this.this$0)) {
            break label201;
          }
          if (!aonk.b(this.this$0)) {
            break label186;
          }
          aonk.a(this.this$0).postDelayed(this, 20L);
        }
        label186:
        while (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("Q.fts.FTSMsgUpgrader", 2, "writeNativeIndex failed");
        return;
        label201:
        if (QLog.isColorLevel()) {
          QLog.d("Q.fts.FTSMsgUpgrader", 2, "upgrade compeleted in handler");
        }
        aonk.b(this.this$0);
        aonk.a(this.this$0).c();
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder().append("upgrade history in handle mDatabase = ");
      if (aonk.a(this.this$0) == null) {}
      for (String str = "null";; str = "@@@")
      {
        QLog.d("Q.fts.FTSMsgUpgrader", 1, str);
        return;
      }
    }
    QLog.d("Q.fts.FTSMsgUpgrader", 1, "upgrade history in handle isDestroy = " + aonk.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.fts.FTSMsgUpgrader.1
 * JD-Core Version:    0.7.0.1
 */