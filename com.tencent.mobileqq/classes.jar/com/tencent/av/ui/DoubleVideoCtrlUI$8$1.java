package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.qphone.base.util.QLog;

class DoubleVideoCtrlUI$8$1
  implements Runnable
{
  DoubleVideoCtrlUI$8$1(DoubleVideoCtrlUI.8 param8, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    if ((this.c.this$0.am != null) && (this.c.this$0.am.k() != null))
    {
      SessionInfo localSessionInfo = this.c.this$0.am.k();
      String str = this.c.this$0.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("StartGlassCheck, lCurrent[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("], lLastTickFinal[");
      localStringBuilder.append(this.b);
      localStringBuilder.append("], VideoGlassWaitTime[");
      localStringBuilder.append(localSessionInfo.bT);
      localStringBuilder.append("], DefaultTimeOutRule[");
      localStringBuilder.append(localSessionInfo.bU);
      localStringBuilder.append("], GlassSwitch[");
      localStringBuilder.append(localSessionInfo.bS);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
      if ((this.c.this$0.g(localSessionInfo.bU)) && (this.c.this$0.am.k().bS != 0)) {
        DoubleVideoCtrlUI.a(this.c.this$0, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.8.1
 * JD-Core Version:    0.7.0.1
 */