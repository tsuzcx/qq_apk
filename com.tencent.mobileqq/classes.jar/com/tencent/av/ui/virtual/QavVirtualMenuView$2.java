package com.tencent.av.ui.virtual;

import android.os.SystemClock;
import com.tencent.aekit.api.standard.ai.AIManager;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.ttpicmodule.module_human_segment.PTHumanSegmenter;

class QavVirtualMenuView$2
  implements Runnable
{
  QavVirtualMenuView$2(QavVirtualMenuView paramQavVirtualMenuView) {}
  
  public void run()
  {
    long l;
    if (AEFilterSupport.a()) {
      l = SystemClock.elapsedRealtime();
    }
    try
    {
      AIManager.installDetector(PTHumanSegmenter.class);
      label16:
      QLog.i(QavVirtualMenuView.a(this.this$0), 1, "preload PTHumanSegmenter, cost[" + (SystemClock.elapsedRealtime() - l) + "]");
      return;
    }
    catch (Throwable localThrowable)
    {
      break label16;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.virtual.QavVirtualMenuView.2
 * JD-Core Version:    0.7.0.1
 */