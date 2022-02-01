package com.tencent.biz.richframework.part.block;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup;

class BlockMerger$2
  extends GridLayoutManager.SpanSizeLookup
{
  BlockMerger$2(BlockMerger paramBlockMerger) {}
  
  public int getSpanSize(int paramInt)
  {
    paramInt = BlockMerger.a(this.a, paramInt);
    MultiViewBlock localMultiViewBlock = this.a.a(paramInt);
    if (localMultiViewBlock != null) {
      return localMultiViewBlock.getSpanCount(localMultiViewBlock.getLocalPosition(paramInt));
    }
    return ((GridLayoutManager)BlockMerger.b(this.a)).getSpanCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.block.BlockMerger.2
 * JD-Core Version:    0.7.0.1
 */