package com.tencent.biz.addContactTroopView;

import android.view.View;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.List;
import tencent.im.troop_search_searchtab.searchtab.Card;
import tencent.im.troop_search_searchtab.searchtab.Item1;
import tencent.im.troop_search_searchtab.searchtab.TitleBar;

class TroopCardGroup$1
  implements AdapterView.OnItemClickListener
{
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (searchtab.Item1)this.a.e.get(paramInt);
    TroopCardGroup.a(this.a, paramAdapterView);
    ReportController.b(this.a.c, "P_CliOper", "Grp_find", "", "grptab", "Clk_grpdata", 0, 0, String.valueOf(paramAdapterView.uint64_group_code.get()), this.a.d.title_bar.str_desc.get(), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.addContactTroopView.TroopCardGroup.1
 * JD-Core Version:    0.7.0.1
 */