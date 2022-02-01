package com.tencent.biz.richframework.part.extendsblock;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.biz.richframework.part.utils.ArrayUtils;

public class HorizontalRvInnerView$HorizontalRvAdapter
  extends BaseListViewAdapter
{
  public HorizontalRVBlock.CommonRvVH a(ViewGroup paramViewGroup, int paramInt)
  {
    if (HorizontalRvInnerView.a(this.a) != null) {
      return HorizontalRvInnerView.a(this.a).a(paramViewGroup, paramInt);
    }
    return null;
  }
  
  public int getItemCount()
  {
    if (HorizontalRvInnerView.a(this.a) != null) {
      return HorizontalRvInnerView.a(this.a).a();
    }
    return 0;
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((!ArrayUtils.a(paramInt, this.mDataList)) && (HorizontalRvInnerView.a(this.a) != null)) {
      HorizontalRvInnerView.a(this.a).a(paramViewHolder, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.part.extendsblock.HorizontalRvInnerView.HorizontalRvAdapter
 * JD-Core Version:    0.7.0.1
 */