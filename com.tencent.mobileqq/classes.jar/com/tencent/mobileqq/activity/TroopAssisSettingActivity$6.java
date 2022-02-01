package com.tencent.mobileqq.activity;

import android.view.View;
import android.widget.ExpandableListAdapter;
import com.tencent.mobileqq.adapter.TroopMessageSettingAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.StatisticTroopAssist;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.ExpandableListView.OnChildClickListener;

class TroopAssisSettingActivity$6
  implements ExpandableListView.OnChildClickListener
{
  TroopAssisSettingActivity$6(TroopAssisSettingActivity paramTroopAssisSettingActivity) {}
  
  public boolean onChildClick(ExpandableListView paramExpandableListView, View paramView, int paramInt1, int paramInt2, long paramLong)
  {
    if (((TroopMessageSettingAdapter)paramExpandableListView.getExpandableListAdapter()).getChildType(paramInt1, paramInt2) == 1) {
      return true;
    }
    StatisticTroopAssist.b(this.a.getActivity(), this.a.app.getCurrentAccountUin());
    paramExpandableListView = (TroopInfo)paramExpandableListView.getExpandableListAdapter().getChild(paramInt1, paramInt2);
    this.a.a(paramExpandableListView);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssisSettingActivity.6
 * JD-Core Version:    0.7.0.1
 */