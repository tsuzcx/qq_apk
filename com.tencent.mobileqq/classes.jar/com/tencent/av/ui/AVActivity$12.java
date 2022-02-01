package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.vas.vipav.VipFunCallMediaListener;

class AVActivity$12
  extends VipFunCallMediaListener
{
  AVActivity$12(AVActivity paramAVActivity) {}
  
  public void a()
  {
    if (this.a.H != null) {
      this.a.H.a().postDelayed(new AVActivity.12.1(this), 0L);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.H != null) {
      this.a.H.a().post(new AVActivity.12.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.12
 * JD-Core Version:    0.7.0.1
 */