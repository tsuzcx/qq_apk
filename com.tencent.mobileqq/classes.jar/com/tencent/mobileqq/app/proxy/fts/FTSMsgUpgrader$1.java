package com.tencent.mobileqq.app.proxy.fts;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.FTSDBManager;
import com.tencent.mobileqq.persistence.fts.FTSDatatbase;
import com.tencent.qphone.base.util.QLog;

class FTSMsgUpgrader$1
  implements Runnable
{
  FTSMsgUpgrader$1(FTSMsgUpgrader paramFTSMsgUpgrader) {}
  
  public void run()
  {
    if ((!FTSMsgUpgrader.a(this.this$0)) && (FTSMsgUpgrader.a(this.this$0).getFTSDBManager().a()))
    {
      if ((FTSMsgUpgrader.a(this.this$0) != null) && (FTSMsgUpgrader.a(this.this$0).a()))
      {
        if (!this.this$0.a) {
          FTSMsgUpgrader.a(this.this$0);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.fts.FTSMsgUpgrader", 2, "upgrade history in handle hasReadNativeCursor = " + this.this$0.a + " mUpgradeCursor=" + FTSMsgUpgrader.a(this.this$0) + " mUpgradeMaxIndex=" + FTSMsgUpgrader.b(this.this$0));
        }
        if (this.this$0.a)
        {
          if (FTSMsgUpgrader.a(this.this$0) >= FTSMsgUpgrader.b(this.this$0)) {
            break label201;
          }
          if (!FTSMsgUpgrader.b(this.this$0)) {
            break label186;
          }
          FTSMsgUpgrader.a(this.this$0).postDelayed(this, 20L);
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
        FTSMsgUpgrader.b(this.this$0);
        FTSMsgUpgrader.a(this.this$0).c();
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder().append("upgrade history in handle mDatabase = ");
      if (FTSMsgUpgrader.a(this.this$0) == null) {}
      for (String str = "null";; str = "@@@")
      {
        QLog.d("Q.fts.FTSMsgUpgrader", 1, str);
        return;
      }
    }
    QLog.d("Q.fts.FTSMsgUpgrader", 1, "upgrade history in handle isDestroy = " + FTSMsgUpgrader.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.fts.FTSMsgUpgrader.1
 * JD-Core Version:    0.7.0.1
 */