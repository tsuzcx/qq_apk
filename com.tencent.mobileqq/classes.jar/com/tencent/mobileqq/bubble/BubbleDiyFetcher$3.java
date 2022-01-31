package com.tencent.mobileqq.bubble;

import almr;
import alok;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class BubbleDiyFetcher$3
  implements Runnable
{
  public BubbleDiyFetcher$3(almr paramalmr, Set paramSet) {}
  
  public void run()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.this$0.a.iterator();
    while (localIterator.hasNext())
    {
      alok localalok = (alok)localIterator.next();
      if ((localalok != null) && (localalok.getCallback() != null))
      {
        String str = localalok.a;
        if ((this.a.contains(str)) && (!localHashSet.contains(localalok)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("BubbleDiyFetcher", 2, "refresh uinAndDiyId drawables: " + str + ", vipBubbleDrawable:" + localalok.toString());
          }
          localHashSet.add(localalok);
          localalok.invalidateSelf();
          this.this$0.a.remove(localalok);
        }
      }
      else
      {
        this.this$0.a.remove(localalok);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("BubbleDiyFetcher", 2, "wait for refresh size: " + this.this$0.a.size());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleDiyFetcher.3
 * JD-Core Version:    0.7.0.1
 */