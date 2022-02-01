package com.tencent.biz.addContactTroopView;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import tencent.im.troop_search_searchtab.searchtab.Item3;

class TroopCardXingquBuluo$1
  implements AdapterView.OnItemClickListener
{
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    searchtab.Item3 localItem3 = (searchtab.Item3)this.a.e.get(paramInt);
    this.a.a(localItem3.str_transfer_url.get());
    ReportController.b(this.a.c, "P_CliOper", "Grp_find", "", "grptab", "Clk_tribe", 0, 0, "", "", "", "");
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.TroopCardXingquBuluo.1
 * JD-Core Version:    0.7.0.1
 */