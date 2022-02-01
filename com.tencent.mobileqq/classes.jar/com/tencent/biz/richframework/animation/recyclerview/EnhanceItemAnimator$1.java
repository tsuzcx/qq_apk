package com.tencent.biz.richframework.animation.recyclerview;

import java.util.ArrayList;
import java.util.Iterator;
import yyu;
import yzc;

public class EnhanceItemAnimator$1
  implements Runnable
{
  public EnhanceItemAnimator$1(yyu paramyyu, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      yzc localyzc = (yzc)localIterator.next();
      yyu.a(this.this$0, localyzc.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder, localyzc.jdField_a_of_type_Int, localyzc.b, localyzc.c, localyzc.d);
    }
    this.a.clear();
    yyu.a(this.this$0).remove(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.1
 * JD-Core Version:    0.7.0.1
 */