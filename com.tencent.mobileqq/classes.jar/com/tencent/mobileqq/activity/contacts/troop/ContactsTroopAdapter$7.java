package com.tencent.mobileqq.activity.contacts.troop;

import android.view.View;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ContactsTroopAdapter$7
  implements ActionSheet.OnButtonClickListener
{
  ContactsTroopAdapter$7(ContactsTroopAdapter paramContactsTroopAdapter, DiscussionHandler paramDiscussionHandler, DiscussionInfo paramDiscussionInfo, boolean paramBoolean, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo;
    boolean bool;
    if (!this.jdField_a_of_type_Boolean)
    {
      bool = true;
      paramView.a((DiscussionInfo)localObject, bool);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.superDismiss();
      if (!this.jdField_a_of_type_Boolean) {
        break label155;
      }
      paramInt = 1;
      label43:
      paramView = this.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo.uin;
      ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.a.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER)).notifyUI(18, true, new Object[] { paramView, Integer.valueOf(paramInt), Integer.valueOf(0), null });
      localObject = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqActivityContactsTroopContactsTroopAdapter.a).a("dc00899").b("Grp_Dis_set").c("Grp_contactlist");
      if (!this.jdField_a_of_type_Boolean) {
        break label160;
      }
    }
    label155:
    label160:
    for (paramView = "Clk_unstick";; paramView = "Clk_stick")
    {
      ((ReportTask)localObject).d(paramView).a();
      return;
      bool = false;
      break;
      paramInt = 0;
      break label43;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.troop.ContactsTroopAdapter.7
 * JD-Core Version:    0.7.0.1
 */