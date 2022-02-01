package com.tencent.biz.richframework.part.block;

import yzj;
import yzp;
import yzq;

public class MultiViewBlock$1$5
  implements Runnable
{
  public MultiViewBlock$1$5(yzq paramyzq, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    this.jdField_a_of_type_Yzq.a.a().notifyItemRangeRemoved(this.jdField_a_of_type_Yzq.a.b(this.jdField_a_of_type_Int), this.b);
    this.jdField_a_of_type_Yzq.a.a().notifyItemRangeChanged(this.jdField_a_of_type_Yzq.a.b(this.jdField_a_of_type_Int), this.jdField_a_of_type_Yzq.a.a().getItemCount() - this.jdField_a_of_type_Yzq.a.b(this.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.MultiViewBlock.1.5
 * JD-Core Version:    0.7.0.1
 */