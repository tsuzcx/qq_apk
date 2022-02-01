package com.tencent.biz.richframework.part.block;

import zxo;
import zxu;
import zxv;

public class MultiViewBlock$1$5
  implements Runnable
{
  public MultiViewBlock$1$5(zxv paramzxv, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    this.jdField_a_of_type_Zxv.a.getBlockMerger().notifyItemRangeRemoved(this.jdField_a_of_type_Zxv.a.getGlobalPosition(this.jdField_a_of_type_Int), this.b);
    this.jdField_a_of_type_Zxv.a.getBlockMerger().notifyItemRangeChanged(this.jdField_a_of_type_Zxv.a.getGlobalPosition(this.jdField_a_of_type_Int), this.jdField_a_of_type_Zxv.a.getBlockMerger().getItemCount() - this.jdField_a_of_type_Zxv.a.getGlobalPosition(this.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.MultiViewBlock.1.5
 * JD-Core Version:    0.7.0.1
 */