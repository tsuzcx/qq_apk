package com.tencent.mobileqq.activity.aio.qim;

import com.tencent.mobileqq.troop.widget.RedDotImageView;
import java.util.ArrayList;
import java.util.Iterator;

class QIMUserManager$5$1
  implements Runnable
{
  QIMUserManager$5$1(QIMUserManager.5 param5) {}
  
  public void run()
  {
    Iterator localIterator = this.a.a.iterator();
    while (localIterator.hasNext())
    {
      QIMUserManager.QIMUserIcon localQIMUserIcon = (QIMUserManager.QIMUserIcon)localIterator.next();
      if (localQIMUserIcon.a != null) {
        localQIMUserIcon.a.setImageDrawable(localQIMUserIcon.c);
      }
      localQIMUserIcon.a = null;
      localQIMUserIcon.c = null;
    }
    this.a.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.qim.QIMUserManager.5.1
 * JD-Core Version:    0.7.0.1
 */