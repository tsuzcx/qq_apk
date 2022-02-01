package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;

class MultiVideoCtrlLayerUIBase$RefreshFaceRunnable
  implements Runnable
{
  MultiVideoCtrlLayerUIBase$RefreshFaceRunnable(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  public void run()
  {
    if (this.this$0.t != null) {
      this.this$0.t.a();
    }
    this.this$0.al.a().postDelayed(this, 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase.RefreshFaceRunnable
 * JD-Core Version:    0.7.0.1
 */