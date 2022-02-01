package com.tencent.biz.richframework.part.extendsblock;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.richframework.part.block.MultiViewBlock;

public abstract class HorizontalRVBlock
  extends MultiViewBlock
{
  public abstract int a();
  
  public abstract HorizontalRVBlock.CommonRvVH a(ViewGroup paramViewGroup, int paramInt);
  
  public abstract void a(RecyclerView.ViewHolder paramViewHolder, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.extendsblock.HorizontalRVBlock
 * JD-Core Version:    0.7.0.1
 */