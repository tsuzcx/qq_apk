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
    if ((EffectsRenderController.c()) && (AEFilterSupport.a() > 3))
    {
      long l = SystemClock.elapsedRealtime();
      String str = QavVirtualMenuView.b(this.this$0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preload PTHumanSegmenter, cost[");
      localStringBuilder.append(SystemClock.elapsedRealtime() - l);
      localStringBuilder.append("]");
      QLog.i(str, 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.virtual.QavVirtualMenuView.2
 * JD-Core Version:    0.7.0.1
 */