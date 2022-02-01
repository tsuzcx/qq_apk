package com.tencent.mobileqq.activity.contact.troop;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.List;

class NotifyAndRecAdapter$4
  implements View.OnClickListener
{
  NotifyAndRecAdapter$4(NotifyAndRecAdapter paramNotifyAndRecAdapter) {}
  
  public void onClick(View paramView)
  {
    RecommendTroopItem localRecommendTroopItem = (RecommendTroopItem)paramView.getTag(-1);
    if ((localRecommendTroopItem == null) || (TextUtils.isEmpty(localRecommendTroopItem.uin))) {
      QLog.d("NotifyAndRecAdapter", 2, "del troop but troop is empty");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      RecommendTroopManagerImp.a(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface, 2, localRecommendTroopItem.uin, new NotifyAndRecAdapter.4.1(this));
      this.a.b.remove(localRecommendTroopItem);
      this.a.notifyDataSetChanged();
      if ((this.a.b != null) && (this.a.b.size() == 0)) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a().sendEmptyMessage(100);
      }
      if (NotifyAndRecAdapter.a(this.a) != null)
      {
        RecommendTroopManagerImp localRecommendTroopManagerImp = (RecommendTroopManagerImp)NotifyAndRecAdapter.a(this.a).getManager(QQManagerFactory.RECOMMEND_TROOP_MANAGER);
        if ((this.a.b != null) && (this.a.b.size() == 0)) {
          localRecommendTroopManagerImp.a(1);
        }
        localRecommendTroopManagerImp.a(localRecommendTroopItem.uin);
      }
      ReportController.b(null, "P_CliOper", "Grp_recom", "", "msg_page", "Clk_unlike", 0, 0, localRecommendTroopItem.uin, "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.NotifyAndRecAdapter.4
 * JD-Core Version:    0.7.0.1
 */