package com.tencent.avgame.qav;

import java.util.ArrayList;
import java.util.Iterator;
import mqq.util.WeakReference;
import myh;
import ngu;

public class AVGameBusinessCtrl$5
  implements Runnable
{
  public AVGameBusinessCtrl$5(ngu paramngu, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    synchronized (ngu.a(this.this$0))
    {
      Iterator localIterator = ngu.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (localWeakReference.get() != null)) {
          ((myh)localWeakReference.get()).a(this.a, this.b);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.qav.AVGameBusinessCtrl.5
 * JD-Core Version:    0.7.0.1
 */