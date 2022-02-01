package com.tencent.av.smallscreen;

class SmallScreenMultiVideoControlUI$RefreshUIRunnable
  implements Runnable
{
  long a;
  int b;
  boolean c;
  int d;
  
  public SmallScreenMultiVideoControlUI$RefreshUIRunnable(SmallScreenMultiVideoControlUI paramSmallScreenMultiVideoControlUI, int paramInt1, long paramLong, boolean paramBoolean, int paramInt2)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenMultiVideoControlUI.RefreshUIRunnable
 * JD-Core Version:    0.7.0.1
 */