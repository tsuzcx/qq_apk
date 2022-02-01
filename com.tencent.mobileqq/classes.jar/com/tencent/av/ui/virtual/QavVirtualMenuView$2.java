package com.tencent.av.ui.virtual;

import android.os.SystemClock;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.qphone.base.util.QLog;

class QavVirtualMenuView$2
  implements Runnable
{
  QavVirtualMenuView$2(QavVirtualMenuView paramQavVirtualMenuView) {}
  
  public void run()
  {
    if ((EffectsRenderController.b()) && (AEFilterSupport.a() > 3))
    {
      long l = SystemClock.elapsedRealtime();
      QLog.i(QavVirtualMenuView.a(this.this$0), 1, "preload PTHumanSegmenter, cost[" + (SystemClock.elapsedRealtime() - l) + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.virtual.QavVirtualMenuView.2
 * JD-Core Version:    0.7.0.1
 */