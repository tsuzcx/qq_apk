package com.tencent.biz.qqstory.common.recyclerview;

import android.view.View;
import android.view.View.OnLongClickListener;

class HeaderAndFooterAdapter$2
  implements View.OnLongClickListener
{
  HeaderAndFooterAdapter$2(HeaderAndFooterAdapter paramHeaderAndFooterAdapter, BaseViewHolder paramBaseViewHolder) {}
  
  public boolean onLongClick(View paramView)
  {
    int i = this.jdField_a_of_type_ComTencentBizQqstoryCommonRecyclerviewBaseViewHolder.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_ComTencentBizQqstoryCommonRecyclerviewHeaderAndFooterAdapter.a.b(this.jdField_a_of_type_ComTencentBizQqstoryCommonRecyclerviewBaseViewHolder.itemView, i);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.common.recyclerview.HeaderAndFooterAdapter.2
 * JD-Core Version:    0.7.0.1
 */