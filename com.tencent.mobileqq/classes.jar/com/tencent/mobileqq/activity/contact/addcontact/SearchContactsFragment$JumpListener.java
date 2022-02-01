package com.tencent.mobileqq.activity.contact.addcontact;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.util.PADetailReportUtil;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.pb.addcontacts.AccountSearchPb.record;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.widget.QzoneSearchResultView;
import java.util.Map;

class SearchContactsFragment$JumpListener
  implements View.OnClickListener
{
  SearchContactsFragment$JumpListener(SearchContactsFragment paramSearchContactsFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = paramView.getTag();
    SearchContactsFragment.ListItemData localListItemData;
    int j;
    int i;
    if ((localObject1 != null) && ((localObject1 instanceof SearchContactsFragment.ListItemData)))
    {
      localListItemData = (SearchContactsFragment.ListItemData)localObject1;
      if ((localListItemData.b != 80000003) || (SearchContactsFragment.c(this.a) == null)) {
        break label304;
      }
      this.a.a(SearchContactsFragment.c(this.a), SearchContactsFragment.a(this.a), SearchContactsFragment.b(this.a));
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
      j = localListItemData.b;
      if (localInteger == null) {
        break label404;
      }
      i = localInteger.intValue();
      label162:
      SearchUtils.a(j, i, 0, true, (String)localObject1, this.a.jdField_a_of_type_JavaLangString, SearchContactsFragment.d());
      if (localListItemData.b != 80000002) {
        break label465;
      }
      localObject2 = this.a.getActivity();
      if ((localObject2 != null) && ((localObject2 instanceof SearchBaseActivity)))
      {
        i = ((SearchBaseActivity)localObject2).a();
        if (SearchContactsFragment.d() != 12) {
          break label409;
        }
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006571", "0X8006571", 0, 1, 0, "0", SearchBaseActivity.JumpSrcConstants.a(i), (String)localObject1, this.a.jdField_a_of_type_JavaLangString);
        label268:
        localObject2 = PADetailReportUtil.a();
        if (localInteger == null) {
          break label460;
        }
        i = localInteger.intValue();
        label284:
        ((PADetailReportUtil)localObject2).a(2, (String)localObject1, i, SearchContactsFragment.d());
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label304:
      if (localListItemData.b == 80000004)
      {
        QzoneSearchResultView.jumpMoreFeeds(this.a.getActivity(), localListItemData.jdField_c_of_type_JavaLangString);
        break;
      }
      i = 0;
      if (this.a.d == 1)
      {
        i = 3;
        label347:
        localObject1 = this.a;
        j = localListItemData.b;
        if (localListItemData.jdField_c_of_type_Int != 2) {
          break label398;
        }
      }
      label398:
      for (boolean bool = true;; bool = false)
      {
        ((SearchContactsFragment)localObject1).a(j, bool, i);
        break;
        if (this.a.d != 0) {
          break label347;
        }
        i = 2;
        break label347;
      }
      label404:
      i = 0;
      break label162;
      label409:
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D20", "0X8005D20", 0, 0, "0", SearchBaseActivity.JumpSrcConstants.a(i), this.a.jdField_a_of_type_JavaLangString, "", false);
      break label268;
      label460:
      i = 0;
      break label284;
      label465:
      if (localListItemData.b == 80000003)
      {
        if (SearchContactsFragment.d() == 12) {
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800658A", "0X800658A", 0, 0, "0", "", this.a.jdField_a_of_type_JavaLangString, "0");
        } else {
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "0", "0X8005D95", "0X8005D95", 0, 0, "0", "", this.a.jdField_a_of_type_JavaLangString, "0", false);
        }
      }
      else if (localListItemData.b == 80000001) {
        SearchUtils.a("add_page", "all_result", "clk_more_grp", 0, SearchContactsFragment.a(this.a), new String[] { "", "", this.a.jdField_a_of_type_JavaLangString, "" });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment.JumpListener
 * JD-Core Version:    0.7.0.1
 */