package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class DoubleVideoCtrlUI$10
  implements Runnable
{
  DoubleVideoCtrlUI$10(DoubleVideoCtrlUI paramDoubleVideoCtrlUI, long paramLong) {}
  
  public void run()
  {
    if (!this.this$0.V())
    {
      Object localObject = this.this$0.am.k();
      this.this$0.am.a(((SessionInfo)localObject).s, 239);
      this.this$0.am.b(239);
      this.this$0.am.b(((SessionInfo)localObject).s, 9);
      this.this$0.al.a(new Object[] { Integer.valueOf(28), ((SessionInfo)localObject).s, Boolean.valueOf(true) });
      localObject = this.this$0.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreate, exit when OnCreate, seq[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
      this.this$0.al.a(this.a, 1008);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.10
 * JD-Core Version:    0.7.0.1
 */