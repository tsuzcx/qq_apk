package com.tencent.biz.richframework.animation.recyclerview;

import java.util.ArrayList;
import java.util.Iterator;
import znz;
import zog;

public class EnhanceItemAnimator$2
  implements Runnable
{
  public EnhanceItemAnimator$2(znz paramznz, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      zog localzog = (zog)localIterator.next();
      znz.a(this.this$0, localzog);
    }
    this.a.clear();
    znz.b(this.this$0).remove(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.2
 * JD-Core Version:    0.7.0.1
 */