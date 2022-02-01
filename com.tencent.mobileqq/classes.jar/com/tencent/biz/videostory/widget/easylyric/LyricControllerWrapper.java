package com.tencent.biz.videostory.widget.easylyric;

import android.os.Looper;
import android.os.Message;

public class LyricControllerWrapper
  implements ILyriController
{
  protected ILyricView a;
  private LyricControllerWrapper.LyricServiceHandler b = new LyricControllerWrapper.LyricServiceHandler(this, Looper.getMainLooper());
  private int c = -1;
  
  public void a()
  {
    this.b.removeCallbacks(null);
    this.a = null;
  }
  
  protected void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(long paramLong)
  {
    Message localMessage = Message.obtain(this.b);
    localMessage.what = 7;
    localMessage.obj = new LyricControllerWrapper.CommonData(paramLong);
    localMessage.sendToTarget();
  }
  
  public void a(ILyricView paramILyricView)
  {
    this.a = paramILyricView;
  }
  
  public void b()
  {
    Message localMessage = Message.obtain(this.b);
    localMessage.what = 4;
    localMessage.sendToTarget();
  }
  
  protected void b(long paramLong)
  {
    ILyricView localILyricView = this.a;
    if (localILyricView != null) {
      localILyricView.a(paramLong);
    }
  }
  
  public void c()
  {
    Message localMessage = Message.obtain(this.b);
    localMessage.what = 2;
    localMessage.sendToTarget();
  }
  
  protected void c(long paramLong)
  {
    a(3);
    ILyricView localILyricView = this.a;
    if (localILyricView != null) {
      localILyricView.a(paramLong);
    }
  }
  
  protected void d()
  {
    a(3);
    ILyricView localILyricView = this.a;
  }
  
  protected void e()
  {
    a(4);
    ILyricView localILyricView = this.a;
  }
  
  protected void f()
  {
    a(5);
    ILyricView localILyricView = this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.easylyric.LyricControllerWrapper
 * JD-Core Version:    0.7.0.1
 */