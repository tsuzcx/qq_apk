package com.tencent.biz.richframework.animation.recyclerview;

import java.util.ArrayList;
import java.util.Iterator;
import zvq;
import zvy;

public class EnhanceItemAnimator$1
  implements Runnable
{
  public EnhanceItemAnimator$1(zvq paramzvq, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      zvy localzvy = (zvy)localIterator.next();
      zvq.a(this.this$0, localzvy.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder, localzvy.jdField_a_of_type_Int, localzvy.b, localzvy.c, localzvy.d);
    }
    this.a.clear();
    zvq.a(this.this$0).remove(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.1
 * JD-Core Version:    0.7.0.1
 */