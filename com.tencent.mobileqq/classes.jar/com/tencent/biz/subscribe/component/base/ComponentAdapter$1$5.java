package com.tencent.biz.subscribe.component.base;

import wbp;
import wbq;
import wbs;

public class ComponentAdapter$1$5
  implements Runnable
{
  public ComponentAdapter$1$5(wbq paramwbq, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    this.jdField_a_of_type_Wbq.a.a().notifyItemRangeRemoved(this.jdField_a_of_type_Wbq.a.c(this.jdField_a_of_type_Int), this.b);
    this.jdField_a_of_type_Wbq.a.a().notifyItemRangeChanged(this.jdField_a_of_type_Wbq.a.c(this.jdField_a_of_type_Int), this.jdField_a_of_type_Wbq.a.a().getItemCount() - this.jdField_a_of_type_Wbq.a.c(this.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.component.base.ComponentAdapter.1.5
 * JD-Core Version:    0.7.0.1
 */