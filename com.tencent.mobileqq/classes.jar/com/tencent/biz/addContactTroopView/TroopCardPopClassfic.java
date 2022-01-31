package com.tencent.biz.addContactTroopView;

import android.support.v7.widget.RecyclerView.Adapter;
import tencent.im.troop_search_popclassifc.popclassifc.PopCard;

public class TroopCardPopClassfic
  extends BaseTroopCardView
{
  protected RecyclerView.Adapter<Object> a;
  protected popclassifc.PopCard a;
  
  public void setData(popclassifc.PopCard paramPopCard)
  {
    if (paramPopCard != null)
    {
      this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$PopCard = paramPopCard;
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.TroopCardPopClassfic
 * JD-Core Version:    0.7.0.1
 */