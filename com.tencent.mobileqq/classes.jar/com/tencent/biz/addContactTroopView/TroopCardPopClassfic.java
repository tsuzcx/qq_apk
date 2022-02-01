package com.tencent.biz.addContactTroopView;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.Adapter;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.ReportController;
import tencent.im.troop_search_popclassifc.popclassifc.PopCard;
import tencent.im.troop_search_popclassifc.popclassifc.PopItem;

public class TroopCardPopClassfic
  extends BaseTroopCardView
{
  protected int a;
  protected RecyclerView.Adapter<TroopCardPopClassfic.ViewHolder> a;
  protected popclassifc.PopCard a;
  
  private void a(int paramInt)
  {
    popclassifc.PopItem localPopItem = (popclassifc.PopItem)((popclassifc.PopCard)this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$PopCard.get()).rpt_pop_items.get(paramInt);
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("url", localPopItem.str_transfer_url.get());
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_find_new", "", "grptab", "Clk_hotcal", 0, 0, "", String.valueOf(paramInt), "", "");
  }
  
  public void setData(popclassifc.PopCard paramPopCard)
  {
    if (paramPopCard != null)
    {
      this.jdField_a_of_type_TencentImTroop_search_popclassifcPopclassifc$PopCard = paramPopCard;
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.TroopCardPopClassfic
 * JD-Core Version:    0.7.0.1
 */