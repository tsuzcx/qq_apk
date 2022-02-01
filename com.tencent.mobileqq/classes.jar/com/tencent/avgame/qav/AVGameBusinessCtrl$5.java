package com.tencent.avgame.qav;

import com.tencent.avgame.callback.AVGameUIEventCallback;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.util.WeakReference;

class AVGameBusinessCtrl$5
  implements Runnable
{
  AVGameBusinessCtrl$5(AVGameBusinessCtrl paramAVGameBusinessCtrl, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    synchronized (AVGameBusinessCtrl.a(this.this$0))
    {
      Iterator localIterator = AVGameBusinessCtrl.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((AVGameUIEventCallback)localWeakReference.get()).a(this.a, this.b);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.qav.AVGameBusinessCtrl.5
 * JD-Core Version:    0.7.0.1
 */