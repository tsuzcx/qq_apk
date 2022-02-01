package com.tencent.biz.richframework.animation.recyclerview;

import java.util.ArrayList;
import java.util.Iterator;
import yyu;
import yzb;

public class EnhanceItemAnimator$2
  implements Runnable
{
  public EnhanceItemAnimator$2(yyu paramyyu, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      yzb localyzb = (yzb)localIterator.next();
      yyu.a(this.this$0, localyzb);
    }
    this.a.clear();
    yyu.b(this.this$0).remove(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.2
 * JD-Core Version:    0.7.0.1
 */