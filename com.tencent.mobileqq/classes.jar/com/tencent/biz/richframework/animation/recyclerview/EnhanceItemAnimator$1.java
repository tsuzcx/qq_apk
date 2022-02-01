package com.tencent.biz.richframework.animation.recyclerview;

import java.util.ArrayList;
import java.util.Iterator;
import znz;
import zoh;

public class EnhanceItemAnimator$1
  implements Runnable
{
  public EnhanceItemAnimator$1(znz paramznz, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      zoh localzoh = (zoh)localIterator.next();
      znz.a(this.this$0, localzoh.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder, localzoh.jdField_a_of_type_Int, localzoh.b, localzoh.c, localzoh.d);
    }
    this.a.clear();
    znz.a(this.this$0).remove(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.1
 * JD-Core Version:    0.7.0.1
 */