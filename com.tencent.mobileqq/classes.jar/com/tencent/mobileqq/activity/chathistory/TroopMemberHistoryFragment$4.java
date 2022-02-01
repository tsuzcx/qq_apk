package com.tencent.mobileqq.activity.chathistory;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopMemberHistoryFragment$4
  implements View.OnClickListener
{
  TroopMemberHistoryFragment$4(TroopMemberHistoryFragment paramTroopMemberHistoryFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if ((localObject1 != null) && ((localObject1 instanceof Integer)))
    {
      int i = ((Integer)localObject1).intValue();
      if ((i >= 0) && (this.a.k != null))
      {
        Object localObject2 = this.a.getBaseActivity();
        if (localObject2 != null)
        {
          ReportController.b(this.a.n, "dc00899", "Grp_chatRecord", "", "chatRecor_mber", "res_clk", 0, 0, this.a.d, "", "", "");
          localObject1 = ((TroopMemberHistoryFragment.MsgItemEntity)this.a.k.getItem(i)).f;
          ChatHistoryBubbleListForTroopFragment.a((Activity)localObject2, this.a.d, (MessageRecord)localObject1, 100, 1);
          if (QLog.isColorLevel())
          {
            localObject2 = TroopMemberHistoryFragment.a;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("onItemClick, message = ");
            localStringBuilder.append(localObject1);
            QLog.i((String)localObject2, 2, localStringBuilder.toString());
          }
          ReportController.b(this.a.n, "CliOper", "", "", "0X800A597", "0X800A597", 0, 0, "", "", "", "");
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment.4
 * JD-Core Version:    0.7.0.1
 */