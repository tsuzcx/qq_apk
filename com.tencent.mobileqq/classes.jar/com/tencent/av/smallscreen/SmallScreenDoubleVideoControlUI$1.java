package com.tencent.av.smallscreen;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class SmallScreenDoubleVideoControlUI$1
  implements Runnable
{
  SmallScreenDoubleVideoControlUI$1(SmallScreenDoubleVideoControlUI paramSmallScreenDoubleVideoControlUI, long paramLong) {}
  
  public void run()
  {
    if ((this.this$0.z != null) && (this.this$0.y != null))
    {
      Object localObject = this.this$0.z.k();
      this.this$0.z.a(((SessionInfo)localObject).s, 225);
      this.this$0.z.b(225);
      this.this$0.z.b(((SessionInfo)localObject).s, 9);
      this.this$0.y.a(new Object[] { Integer.valueOf(28), ((SessionInfo)localObject).s, Boolean.valueOf(true) });
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("exit when onCreate fail, seq[");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append("]");
      QLog.w("SmallScreenDoubleVideoControlUI", 1, ((StringBuilder)localObject).toString());
      this.this$0.y.a(this.a, 1008);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenDoubleVideoControlUI.1
 * JD-Core Version:    0.7.0.1
 */