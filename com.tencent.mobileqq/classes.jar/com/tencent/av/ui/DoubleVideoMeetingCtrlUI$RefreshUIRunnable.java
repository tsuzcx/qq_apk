package com.tencent.av.ui;

import com.tencent.qphone.base.util.QLog;

class DoubleVideoMeetingCtrlUI$RefreshUIRunnable
  implements Runnable
{
  long a;
  int b;
  long c;
  long d = 0L;
  
  public DoubleVideoMeetingCtrlUI$RefreshUIRunnable(DoubleVideoMeetingCtrlUI paramDoubleVideoMeetingCtrlUI, long paramLong1, int paramInt, long paramLong2, long paramLong3)
  {
    this.d = paramLong1;
    this.a = paramLong2;
    this.b = paramInt;
    this.c = paramLong3;
  }
  
  private void a(int paramInt, long paramLong1, long paramLong2)
  {
    if (paramInt == 1)
    {
      this.this$0.a(this.d, true, 1, paramLong1);
      return;
    }
    if (paramInt == 2)
    {
      this.this$0.a(this.d, false, 1, paramLong1);
      return;
    }
    if (paramInt == 3)
    {
      this.this$0.a(this.d, true, 2, paramLong1);
      return;
    }
    if (paramInt == 4)
    {
      this.this$0.a(this.d, false, 2, paramLong1);
      return;
    }
    if (paramInt == 5)
    {
      this.this$0.f(this.d, false);
      this.this$0.d(this.d, null);
      DoubleVideoMeetingCtrlUI.c(this.this$0, this.d);
      return;
    }
    if (paramInt == 6)
    {
      if (paramLong1 != this.this$0.k) {
        this.this$0.a(true);
      }
    }
    else if (QLog.isColorLevel())
    {
      String str = this.this$0.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshUI, ERROR, refreshType[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], friendUin[");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(this.d);
      localStringBuilder.append("]");
      QLog.w(str, 1, localStringBuilder.toString());
    }
  }
  
  public void run()
  {
    if (this.this$0.V()) {
      return;
    }
    a(this.b, this.a, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoMeetingCtrlUI.RefreshUIRunnable
 * JD-Core Version:    0.7.0.1
 */