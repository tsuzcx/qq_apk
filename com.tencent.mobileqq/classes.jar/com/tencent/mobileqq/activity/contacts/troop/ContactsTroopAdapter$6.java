package com.tencent.mobileqq.activity.contacts.troop;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.handler.ITroopCommonlyUsedHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ContactsTroopAdapter$6
  implements ActionSheet.OnButtonClickListener
{
  ContactsTroopAdapter$6(ContactsTroopAdapter paramContactsTroopAdapter, boolean paramBoolean, TroopInfo paramTroopInfo, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.jdField_a_of_type_AndroidContentContext, 1, 2131692183, 0).a();
    }
    else
    {
      paramView = (ITroopCommonlyUsedHandler)this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopCommonlyUsedHandlerName());
      if (this.jdField_a_of_type_Boolean)
      {
        paramView.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopcode, 1);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800808D", "0X800808D", 0, 0, "", "", "", "");
      }
      else
      {
        paramView.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopcode, 0);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800808C", "0X800808C", 0, 0, "", "", "", "");
      }
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.superDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.troop.ContactsTroopAdapter.6
 * JD-Core Version:    0.7.0.1
 */