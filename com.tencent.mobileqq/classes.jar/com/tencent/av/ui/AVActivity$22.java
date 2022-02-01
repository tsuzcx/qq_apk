package com.tencent.av.ui;

import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.ui.guide.GuideHelper;
import com.tencent.mobileqq.utils.AudioHelper;

class AVActivity$22
  extends GAudioUIObserver
{
  AVActivity$22(AVActivity paramAVActivity) {}
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.a.isDestroyed()) {
      return;
    }
    this.a.a.a(paramLong1, this.a, 4, 0);
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.a.isDestroyed()) {
      return;
    }
    paramLong = AudioHelper.b();
    this.a.a.a(paramLong, this.a, 3, 2);
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    if (this.a.isDestroyed()) {
      return;
    }
    this.a.a.a(paramLong1, this.a, 4, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.22
 * JD-Core Version:    0.7.0.1
 */