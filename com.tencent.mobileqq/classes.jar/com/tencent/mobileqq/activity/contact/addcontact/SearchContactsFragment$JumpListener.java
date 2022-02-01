package com.tencent.mobileqq.activity.contact.addcontact;

import addcontacts.AccountSearchPb.record;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountDetailReportUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;

class SearchContactsFragment$JumpListener
  implements View.OnClickListener
{
  SearchContactsFragment$JumpListener(SearchContactsFragment paramSearchContactsFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    if ((localObject1 != null) && ((localObject1 instanceof SearchContactsFragment.ListItemData)))
    {
      SearchContactsFragment.ListItemData localListItemData = (SearchContactsFragment.ListItemData)localObject1;
      int i = localListItemData.b;
      int j = 0;
      if ((i == 80000003) && (SearchContactsFragment.c(this.a) != null))
      {
        localObject1 = this.a;
        ((SearchContactsFragment)localObject1).a(SearchContactsFragment.c((SearchContactsFragment)localObject1), SearchContactsFragment.a(this.a), SearchContactsFragment.b(this.a));
      }
      else if (localListItemData.b == 80000004)
      {
        QzoneSearchResultView.a(this.a.getBaseActivity(), localListItemData.jdField_c_of_type_JavaLangString);
      }
      else
      {
        if (this.a.d == 1) {
          i = 3;
        } else if (this.a.d == 0) {
          i = 2;
        } else {
          i = 0;
        }
        localObject1 = this.a;
        k = localListItemData.b;
        boolean bool;
        if (localListItemData.jdField_c_of_type_Int == 2) {
          bool = true;
        } else {
          bool = false;
        }
        ((SearchContactsFragment)localObject1).a(k, bool, i);
      }
      Integer localInteger = (Integer)SearchContactsFragment.a(this.a).get(Integer.valueOf(localListItemData.b));
      Object localObject2 = null;
      localObject1 = localObject2;
      if (localListItemData.a != null)
      {
        localObject1 = localObject2;
        if (localListItemData.a.uin != null) {
          localObject1 = String.valueOf(localListItemData.a.uin.get());
        }
      }
      int k = localListItemData.b;
      if (localInteger != null) {
        i = localInteger.intValue();
      } else {
        i = 0;
      }
      SearchUtils.a(k, i, 0, true, (String)localObject1, this.a.jdField_a_of_type_JavaLangString, SearchContactsFragment.d());
      if (localListItemData.b == 80000002)
      {
        localObject2 = this.a.getBaseActivity();
        if ((localObject2 != null) && ((localObject2 instanceof SearchBaseActivity)))
        {
          i = ((SearchBaseActivity)localObject2).a();
          if (SearchContactsFragment.d() == 12) {
            ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006571", "0X8006571", 0, 1, 0, "0", SearchBaseActivity.JumpSrcConstants.a(i), (String)localObject1, this.a.jdField_a_of_type_JavaLangString);
          } else {
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D20", "0X8005D20", 0, 0, "0", SearchBaseActivity.JumpSrcConstants.a(i), this.a.jdField_a_of_type_JavaLangString, "", false);
          }
          localObject2 = (IPublicAccountDetailReportUtil)QRoute.api(IPublicAccountDetailReportUtil.class);
          i = j;
          if (localInteger != null) {
            i = localInteger.intValue();
          }
          ((IPublicAccountDetailReportUtil)localObject2).setAttrSearchClick(2, (String)localObject1, i, SearchContactsFragment.d());
        }
      }
      else if (localListItemData.b == 80000003)
      {
        if (SearchContactsFragment.d() == 12) {
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800658A", "0X800658A", 0, 0, "0", "", this.a.jdField_a_of_type_JavaLangString, "0");
        } else {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D95", "0X8005D95", 0, 0, "0", "", this.a.jdField_a_of_type_JavaLangString, "0", false);
        }
      }
      else if (localListItemData.b == 80000001)
      {
        SearchUtils.a("add_page", "all_result", "clk_more_grp", 0, SearchContactsFragment.a(this.a), new String[] { "", "", this.a.jdField_a_of_type_JavaLangString, "" });
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment.JumpListener
 * JD-Core Version:    0.7.0.1
 */