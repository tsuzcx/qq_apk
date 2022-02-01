package com.tencent.mobileqq.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotHandler;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class RobotAdapter$2
  implements View.OnClickListener
{
  RobotAdapter$2(RobotAdapter paramRobotAdapter) {}
  
  public void onClick(View paramView)
  {
    if (!RobotAdapter.d(this.a))
    {
      DialogUtil.a(RobotAdapter.a(this.a), 230, "", HardCodeUtil.a(2131910957), new RobotAdapter.2.1(this), null).show();
    }
    else
    {
      Object localObject1 = paramView.getTag();
      if ((localObject1 != null) && ((localObject1 instanceof String)))
      {
        if ((paramView instanceof Button))
        {
          localObject2 = (Button)paramView;
          if (localObject2 != null) {
            ((Button)localObject2).setEnabled(false);
          }
        }
        Object localObject2 = (String)localObject1;
        long l4 = 0L;
        long l1;
        long l2;
        try
        {
          l1 = Long.parseLong(RobotAdapter.b(this.a));
          try
          {
            l2 = Long.parseLong((String)localObject2);
            l3 = l1;
          }
          catch (Exception localException1) {}
          l2 = l4;
        }
        catch (Exception localException2)
        {
          l1 = 0L;
        }
        long l3 = l1;
        if (QLog.isColorLevel())
        {
          QLog.d("RobotAdapter", 2, "parseLong err", localException2);
          l3 = l1;
          l2 = l4;
        }
        RobotAdapter.e(this.a).add(localObject2);
        ((ITroopRobotHandler)RobotAdapter.c(this.a).getBusinessHandler(BusinessHandlerFactory.TROOP_ROBOT_HANDLER)).a(l3, l2);
        if (RobotAdapter.a(this.a) != null) {
          ReportController.b(RobotAdapter.a(this.a).app, "dc00898", "", "", "", "0X8009FA0", 0, 0, (String)localObject2, "", "", "");
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.RobotAdapter.2
 * JD-Core Version:    0.7.0.1
 */