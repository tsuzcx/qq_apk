package com.tencent.biz.pubaccount.subscript;

import android.view.View;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SubscriptionFeed;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.Iterator;
import java.util.List;

class SubscriptFeedsActivity$11
  implements ActionSheet.OnButtonClickListener
{
  SubscriptFeedsActivity$11(SubscriptFeedsActivity paramSubscriptFeedsActivity, String paramString, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      TroopBarAssistantManager.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity.app, this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity, null);
      paramInt = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getUinType(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity.app, this.jdField_a_of_type_JavaLangString);
      RecentUtil.b(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity.app, this.jdField_a_of_type_JavaLangString, paramInt);
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity.app.getMessageFacade().a(this.jdField_a_of_type_JavaLangString, 1008);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X8006113", "0X8006113", 0, 0, "", "", "", "");
      int i = 0;
      paramView = SubscriptFeedsActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptFeedsActivity).iterator();
      do
      {
        paramInt = i;
        if (!paramView.hasNext()) {
          break;
        }
        localObject = (SubscriptionFeed)paramView.next();
      } while ((((SubscriptionFeed)localObject).jdField_a_of_type_JavaLangString == null) || (!((SubscriptionFeed)localObject).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)));
      paramInt = ((SubscriptionFeed)localObject).b;
      paramView = this.jdField_a_of_type_JavaLangString;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramInt);
      ReportController.b(null, "dc00899", "Pb_account_lifeservice", paramView, "0X80064CF", "0X80064CF", 0, 0, ((StringBuilder)localObject).toString(), "", "", "");
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.11
 * JD-Core Version:    0.7.0.1
 */