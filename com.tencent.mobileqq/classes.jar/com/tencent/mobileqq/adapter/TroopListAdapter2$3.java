package com.tencent.mobileqq.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopListAdapter2$3
  implements View.OnClickListener
{
  TroopListAdapter2$3(TroopListAdapter2 paramTroopListAdapter2) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a();
    Object localObject = (View)paramView.getParent();
    if ((localObject instanceof ShaderAnimLayout)) {
      ((ShaderAnimLayout)localObject).d();
    }
    localObject = paramView.getTag();
    if (!(localObject instanceof TroopInfo))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    TroopInfo localTroopInfo = (TroopInfo)localObject;
    boolean bool = ((TroopManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(localTroopInfo.troopuin);
    localObject = (BizTroopHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER);
    int i;
    label113:
    ReportTask localReportTask;
    label135:
    label207:
    String str;
    if (bool)
    {
      i = 1;
      if (!((BizTroopHandler)localObject).a(localTroopInfo.troopcode, i)) {
        break label263;
      }
      if (!bool) {
        break label265;
      }
      localObject = "Clk_uncommgrp";
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_set", "", "Grp_contactlist", (String)localObject, 0, 0, localTroopInfo.troopuin, "", "", "");
      localReportTask = new ReportTask(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("Grp_set").c("Grp_contactlist");
      if (!bool) {
        break label272;
      }
      localObject = "Clk_unstick";
      localReportTask = localReportTask.d((String)localObject);
      str = localTroopInfo.troopuin;
      if (!localTroopInfo.hasSetTroopHead()) {
        break label279;
      }
    }
    label263:
    label265:
    label272:
    label279:
    for (localObject = "1";; localObject = "0")
    {
      localReportTask.a(new String[] { str, localObject }).a();
      break;
      i = 0;
      break label113;
      break;
      localObject = "Clk_setcommgrp";
      break label135;
      localObject = "Clk_stick";
      break label207;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.TroopListAdapter2.3
 * JD-Core Version:    0.7.0.1
 */