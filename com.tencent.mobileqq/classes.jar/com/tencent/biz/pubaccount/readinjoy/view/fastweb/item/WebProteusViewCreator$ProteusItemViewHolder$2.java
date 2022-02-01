package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.BubbleContextMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;

class WebProteusViewCreator$ProteusItemViewHolder$2
  implements View.OnLongClickListener
{
  WebProteusViewCreator$ProteusItemViewHolder$2(WebProteusViewCreator.ProteusItemViewHolder paramProteusItemViewHolder, View paramView, ProteusItemData paramProteusItemData) {}
  
  public boolean onLongClick(View paramView)
  {
    paramView = new QQCustomMenu();
    paramView.a(0, HardCodeUtil.a(2131716709));
    BubbleContextMenu.a(this.jdField_a_of_type_AndroidViewView, paramView, new WebProteusViewCreator.ProteusItemViewHolder.2.1(this), new WebProteusViewCreator.ProteusItemViewHolder.2.2(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebProteusViewCreator.ProteusItemViewHolder.2
 * JD-Core Version:    0.7.0.1
 */