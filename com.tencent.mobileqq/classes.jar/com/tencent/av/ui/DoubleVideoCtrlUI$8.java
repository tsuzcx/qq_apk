package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

class DoubleVideoCtrlUI$8
  extends TimerTask
{
  boolean a = this.b;
  
  DoubleVideoCtrlUI$8(DoubleVideoCtrlUI paramDoubleVideoCtrlUI, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.this$0.am != null)
    {
      if (this.this$0.al == null) {
        return;
      }
      SessionInfo localSessionInfo = this.this$0.am.k();
      if (localSessionInfo == null) {
        return;
      }
      if (localSessionInfo.bT <= 0)
      {
        if (this.this$0.l != null)
        {
          this.this$0.l.cancel();
          this.this$0.l = null;
        }
        QLog.w(this.this$0.X, 1, "StartGlassCheck, cancel cur Timer");
        return;
      }
      long l1;
      try
      {
        if (this.this$0.ak != null) {
          l1 = ((AVActivity)this.this$0.ak.get()).L.c(this.this$0.am.k().s);
        } else {
          l1 = 0L;
        }
      }
      catch (Exception localException)
      {
        QLog.w(this.this$0.X, 1, "StartGlassCheck, Exception", localException);
        l1 = 0L;
      }
      long l2 = System.currentTimeMillis();
      if (l1 == 0L) {
        return;
      }
      long l3 = l2 - l1;
      String str = this.this$0.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("StartGlassCheck, interval[");
      localStringBuilder.append(l3);
      localStringBuilder.append("], mCheck[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("], mCurrentDoubleVideoGlassSwitch[");
      localStringBuilder.append(this.this$0.am.k().bS);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      if ((l3 > this.this$0.am.k().bT * 1000) && (this.a))
      {
        this.this$0.al.runOnUiThread(new DoubleVideoCtrlUI.8.1(this, l2, l1));
        return;
      }
      if ((this.this$0.am.k().bS != 0) && (l3 < 1000L)) {
        this.this$0.al.runOnUiThread(new DoubleVideoCtrlUI.8.2(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.8
 * JD-Core Version:    0.7.0.1
 */