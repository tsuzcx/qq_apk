package com.tencent.av.ui;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class QavPanel$8
  implements Runnable
{
  QavPanel$8(QavPanel paramQavPanel, int paramInt1, long paramLong, boolean paramBoolean, int paramInt2) {}
  
  public void run()
  {
    if (this.this$0.U != null)
    {
      Object localObject = this.this$0.V;
      int i = this.a;
      if (localObject[i] == null) {
        return;
      }
      if (i != this.this$0.W)
      {
        localObject = this.this$0.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doShowAnimation, invalid menuType[");
        localStringBuilder.append(this.a);
        localStringBuilder.append("], curMenuType[");
        localStringBuilder.append(this.this$0.W);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(this.b);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 1, localStringBuilder.toString());
        return;
      }
      this.this$0.V[this.a].a(this.b, this.c, this.d);
      this.this$0.U.a(new Object[] { Integer.valueOf(123), Integer.valueOf(this.a), Long.valueOf(this.b) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavPanel.8
 * JD-Core Version:    0.7.0.1
 */