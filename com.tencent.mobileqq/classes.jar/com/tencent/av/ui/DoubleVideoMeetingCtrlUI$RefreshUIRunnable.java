package com.tencent.av.ui;

import com.tencent.qphone.base.util.QLog;

class DoubleVideoMeetingCtrlUI$RefreshUIRunnable
  implements Runnable
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  long b;
  long c = 0L;
  
  public DoubleVideoMeetingCtrlUI$RefreshUIRunnable(DoubleVideoMeetingCtrlUI paramDoubleVideoMeetingCtrlUI, long paramLong1, int paramInt, long paramLong2, long paramLong3)
  {
    this.c = paramLong1;
    this.jdField_a_of_type_Long = paramLong2;
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramLong3;
  }
  
  private void a(int paramInt, long paramLong1, long paramLong2)
  {
    if (paramInt == 1) {
      this.this$0.a(this.c, true, 1, paramLong1);
    }
    do
    {
      do
      {
        return;
        if (paramInt == 2)
        {
          this.this$0.a(this.c, false, 1, paramLong1);
          return;
        }
        if (paramInt == 3)
        {
          this.this$0.a(this.c, true, 2, paramLong1);
          return;
        }
        if (paramInt == 4)
        {
          this.this$0.a(this.c, false, 2, paramLong1);
          return;
        }
        if (paramInt == 5)
        {
          this.this$0.e(this.c, false);
          this.this$0.d(this.c, null);
          DoubleVideoMeetingCtrlUI.c(this.this$0, this.c);
          return;
        }
        if (paramInt != 6) {
          break;
        }
      } while (paramLong1 == this.this$0.b);
      this.this$0.a(true);
      return;
    } while (!QLog.isColorLevel());
    QLog.w(this.this$0.d, 1, "refreshUI, ERROR, refreshType[" + paramInt + "], friendUin[" + paramLong1 + "], seq[" + this.c + "]");
  }
  
  public void run()
  {
    if (this.this$0.h()) {
      return;
    }
    a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoMeetingCtrlUI.RefreshUIRunnable
 * JD-Core Version:    0.7.0.1
 */