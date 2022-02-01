package com.tencent.av.ui;

class MultiVideoCtrlLayerUIBase$RefreshUIRunnable
  implements Runnable
{
  long a;
  int b;
  boolean c;
  int d;
  
  public MultiVideoCtrlLayerUIBase$RefreshUIRunnable(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase, long paramLong, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    this.c = paramBoolean;
    this.d = paramInt2;
    this.a = paramLong;
    this.b = paramInt1;
  }
  
  public void run()
  {
    this.this$0.a(this.a, this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase.RefreshUIRunnable
 * JD-Core Version:    0.7.0.1
 */