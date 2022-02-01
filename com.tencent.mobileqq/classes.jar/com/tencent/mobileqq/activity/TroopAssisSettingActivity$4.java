package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.adapter.TroopMessageSettingAdapter;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.roamsetting.api.IRoamSettingService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.concurrent.ConcurrentHashMap;

class TroopAssisSettingActivity$4
  implements ActionSheet.OnButtonClickListener
{
  TroopAssisSettingActivity$4(TroopAssisSettingActivity paramTroopAssisSettingActivity, int paramInt, TroopInfo paramTroopInfo, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    int i = 3;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            i = -1;
          }
        }
        else {
          i = 2;
        }
      }
      else {
        i = 4;
      }
    }
    else {
      i = 1;
    }
    if (this.a != i) {
      if (NetworkUtil.isNetSupport(this.d.getActivity()))
      {
        this.d.f.getMapUploading().clear();
        TroopAssistantManager.a().a(this.d.app, this.b.troopuin, i);
        this.d.f.getMapRequest().put(this.b.troopuin, Boolean.valueOf(true));
        this.d.b.notifyDataSetChanged();
        this.d.b();
        TroopAssistantManager.a().f(this.d.app, this.b.troopuin);
        ReportController.b(this.d.app, "P_CliOper", "Grp_msg", "", "set_page", "Clk_setmsg", 0, 0, this.b.troopuin, String.valueOf(i - 1), "", "");
      }
      else
      {
        QQToast.makeText(this.d.getActivity(), 2131892104, 0).show(this.d.getTitleBarHeight());
      }
    }
    this.c.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssisSettingActivity.4
 * JD-Core Version:    0.7.0.1
 */