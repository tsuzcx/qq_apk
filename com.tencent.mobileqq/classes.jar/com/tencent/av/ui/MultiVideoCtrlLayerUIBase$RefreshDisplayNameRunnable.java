package com.tencent.av.ui;

import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class MultiVideoCtrlLayerUIBase$RefreshDisplayNameRunnable
  implements Runnable
{
  MultiVideoCtrlLayerUIBase$RefreshDisplayNameRunnable(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  public void run()
  {
    Object localObject = this.this$0.al.a(this.this$0.g, String.valueOf(this.this$0.i), null);
    MultiVideoCtrlLayerUIBase localMultiVideoCtrlLayerUIBase = this.this$0;
    localMultiVideoCtrlLayerUIBase.J = localMultiVideoCtrlLayerUIBase.al.getApp().getString(2131893110);
    if (this.this$0.h == 2)
    {
      localMultiVideoCtrlLayerUIBase = this.this$0;
      localMultiVideoCtrlLayerUIBase.J = localMultiVideoCtrlLayerUIBase.a((String)localObject, localMultiVideoCtrlLayerUIBase.al.d(this.this$0.h, String.valueOf(this.this$0.i)), this.this$0.o);
    }
    else if (this.this$0.h == 1)
    {
      this.this$0.J = ((String)localObject);
    }
    this.this$0.o.setText(this.this$0.J);
    int i = this.this$0.L;
    this.this$0.p.setText(this.this$0.J);
    this.this$0.p.setText(null);
    localObject = this.this$0;
    ((MultiVideoCtrlLayerUIBase)localObject).B += 1;
    if (this.this$0.A != null)
    {
      if (this.this$0.B < 3)
      {
        this.this$0.al.a().postDelayed(this.this$0.A, 1000L);
        return;
      }
      this.this$0.al.a().removeCallbacks(this.this$0.A);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase.RefreshDisplayNameRunnable
 * JD-Core Version:    0.7.0.1
 */