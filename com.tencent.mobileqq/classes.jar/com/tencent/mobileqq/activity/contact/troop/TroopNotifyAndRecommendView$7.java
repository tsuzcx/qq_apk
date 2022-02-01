package com.tencent.mobileqq.activity.contact.troop;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.troop.generalgroupnotifyparser.AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.mobileim.structmsg.structmsg.StructMsg;

class TroopNotifyAndRecommendView$7
  implements View.OnClickListener
{
  TroopNotifyAndRecommendView$7(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void onClick(View paramView)
  {
    if (!(paramView.getTag() instanceof NotificationAdapter.ViewHolder)) {}
    do
    {
      do
      {
        do
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          localObject2 = (NotificationAdapter.ViewHolder)paramView.getTag();
        } while (((NotificationAdapter.ViewHolder)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get() != 2);
        this.a.a((NotificationAdapter.ViewHolder)localObject2);
        if (((NotificationAdapter.ViewHolder)localObject2).jdField_a_of_type_Int == 82) {
          ReportController.b(this.a.a, "P_CliOper", "Grp_public", "", "oper", "Clk_notice", 0, 0, "", "", "", ((NotificationAdapter.ViewHolder)localObject2).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get() + "");
        }
      } while (((NotificationAdapter.ViewHolder)localObject2).jdField_a_of_type_Int != 91);
      localObject1 = (TroopManager)this.a.a.getManager(QQManagerFactory.TROOP_MANAGER);
    } while ((localObject1 == null) || (!(((NotificationAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqActivityContactTroopGeneralgroupnotifyparserGeneralGroupNotifyParser$GeneralGroupNotifyInfo instanceof AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)));
    Object localObject2 = (AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)((NotificationAdapter.ViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqActivityContactTroopGeneralgroupnotifyparserGeneralGroupNotifyParser$GeneralGroupNotifyInfo;
    Object localObject1 = ((TroopManager)localObject1).b(String.valueOf(((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject2).e));
    if (localObject1 != null) {}
    for (long l = ((TroopInfo)localObject1).dwGroupClassExt;; l = 0L)
    {
      ReportController.b(null, "dc00898", "", String.valueOf(((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject2).e), "0X800B4B4", "0X800B4B4", 0, 0, String.valueOf(l), "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.7
 * JD-Core Version:    0.7.0.1
 */