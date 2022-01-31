package com.tencent.biz.subscribe.component.base;

import ydp;
import ydq;
import yds;

public class ComponentAdapter$1$5
  implements Runnable
{
  public ComponentAdapter$1$5(ydq paramydq, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    this.jdField_a_of_type_Ydq.a.a().notifyItemRangeRemoved(this.jdField_a_of_type_Ydq.a.c(this.jdField_a_of_type_Int), this.b);
    this.jdField_a_of_type_Ydq.a.a().notifyItemRangeChanged(this.jdField_a_of_type_Ydq.a.c(this.jdField_a_of_type_Int), this.jdField_a_of_type_Ydq.a.a().getItemCount() - this.jdField_a_of_type_Ydq.a.c(this.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.component.base.ComponentAdapter.1.5
 * JD-Core Version:    0.7.0.1
 */