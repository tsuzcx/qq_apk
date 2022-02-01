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
  protected popclassifc.PopCard d;
  protected int e;
  protected RecyclerView.Adapter<TroopCardPopClassfic.ViewHolder> f;
  
  private void a(int paramInt)
  {
    popclassifc.PopItem localPopItem = (popclassifc.PopItem)((popclassifc.PopCard)this.d.get()).rpt_pop_items.get(paramInt);
    Intent localIntent = new Intent(this.b, QQBrowserActivity.class);
    localIntent.putExtra("url", localPopItem.str_transfer_url.get());
    this.b.startActivity(localIntent);
    ReportController.b(this.c, "dc00899", "Grp_find_new", "", "grptab", "Clk_hotcal", 0, 0, "", String.valueOf(paramInt), "", "");
  }
  
  public void setData(popclassifc.PopCard paramPopCard)
  {
    if (paramPopCard != null)
    {
      this.d = paramPopCard;
      this.f.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.TroopCardPopClassfic
 * JD-Core Version:    0.7.0.1
 */