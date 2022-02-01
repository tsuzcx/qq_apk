package com.tencent.av.ui;

class GAudioMembersCtrlActivity$RefreshUIRunnable
  implements Runnable
{
  long a;
  int b;
  boolean c;
  int d;
  
  public GAudioMembersCtrlActivity$RefreshUIRunnable(GAudioMembersCtrlActivity paramGAudioMembersCtrlActivity, int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
  {
    this.a = paramLong;
    this.b = paramInt1;
    this.c = paramBoolean;
    this.d = paramInt2;
  }
  
  public void run()
  {
    this.this$0.a(this.b, this.a, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.GAudioMembersCtrlActivity.RefreshUIRunnable
 * JD-Core Version:    0.7.0.1
 */