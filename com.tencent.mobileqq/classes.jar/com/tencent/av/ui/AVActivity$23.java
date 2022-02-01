package com.tencent.av.ui;

import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.ui.guide.GuideHelper;
import com.tencent.av.utils.AudioHelper;

class AVActivity$23
  extends GAudioUIObserver
{
  AVActivity$23(AVActivity paramAVActivity) {}
  
  protected void a(long paramLong1, long paramLong2)
  {
    if (this.b.isDestroyed()) {
      return;
    }
    this.b.ab.a(paramLong1, this.b, 4, 0);
  }
  
  protected void b(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.b.isDestroyed()) {
      return;
    }
    paramLong = AudioHelper.c();
    this.b.ab.a(paramLong, this.b, 3, 2);
  }
  
  protected void b(long paramLong1, long paramLong2)
  {
    if (this.b.isDestroyed()) {
      return;
    }
    this.b.ab.a(paramLong1, this.b, 4, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.23
 * JD-Core Version:    0.7.0.1
 */