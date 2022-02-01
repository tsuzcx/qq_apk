package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.vas.vipav.VipFunCallMediaListener;

class AVActivity$11
  extends VipFunCallMediaListener
{
  AVActivity$11(AVActivity paramAVActivity) {}
  
  public void a()
  {
    if (this.a.a != null) {
      this.a.a.a().postDelayed(new AVActivity.11.1(this), 0L);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.a != null) {
      this.a.a.a().post(new AVActivity.11.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.11
 * JD-Core Version:    0.7.0.1
 */