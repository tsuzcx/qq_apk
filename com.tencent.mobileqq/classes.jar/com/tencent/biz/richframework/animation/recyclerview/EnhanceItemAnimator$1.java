package com.tencent.biz.richframework.animation.recyclerview;

import java.util.ArrayList;
import java.util.Iterator;
import zzl;
import zzt;

public class EnhanceItemAnimator$1
  implements Runnable
{
  public EnhanceItemAnimator$1(zzl paramzzl, ArrayList paramArrayList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      zzt localzzt = (zzt)localIterator.next();
      zzl.a(this.this$0, localzzt.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder, localzzt.jdField_a_of_type_Int, localzzt.b, localzzt.c, localzzt.d);
    }
    this.a.clear();
    zzl.a(this.this$0).remove(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.animation.recyclerview.EnhanceItemAnimator.1
 * JD-Core Version:    0.7.0.1
 */