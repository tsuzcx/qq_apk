package com.tencent.mobileqq.activity;

import android.widget.ToggleButton;
import com.tencent.mobileqq.profile.view.ProfileLabelCallBack;
import com.tencent.mobileqq.profile.view.ProfileLabelPanel.LabelStatusManager;
import com.tencent.mobileqq.profilecard.entity.ProfileLabelInfo;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.List;

class ProfileLabelEditorActivity$4
  implements ProfileLabelCallBack
{
  ProfileLabelEditorActivity$4(ProfileLabelEditorActivity paramProfileLabelEditorActivity) {}
  
  public void a(ProfileLabelInfo paramProfileLabelInfo, ToggleButton paramToggleButton, Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      if (!this.a.a(paramProfileLabelInfo.labelId, this.a.jdField_a_of_type_JavaUtilList))
      {
        paramBoolean = this.a;
        if (!paramBoolean.a(paramBoolean.jdField_a_of_type_JavaUtilList))
        {
          ReportController.b(this.a.app, "CliOper", "", "", "card_mall", "0X80066C7", 0, 0, "1", "", "", "");
          this.a.jdField_a_of_type_JavaUtilList.add(paramProfileLabelInfo);
          break label156;
        }
      }
      paramProfileLabelInfo = this.a;
      if (paramProfileLabelInfo.a(paramProfileLabelInfo.jdField_a_of_type_JavaUtilList)) {
        this.a.b(2131693377);
      }
    }
    else
    {
      if (!this.a.a(paramProfileLabelInfo.labelId, this.a.jdField_a_of_type_JavaUtilList)) {
        return;
      }
      paramBoolean = this.a;
      paramBoolean.a(paramProfileLabelInfo, paramBoolean.jdField_a_of_type_JavaUtilList);
    }
    label156:
    this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileLabelPanel$LabelStatusManager.c(paramProfileLabelInfo, paramToggleButton);
    paramProfileLabelInfo = this.a;
    paramProfileLabelInfo.a(paramProfileLabelInfo.jdField_a_of_type_JavaUtilList.size());
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileLabelEditorActivity$MyLabelGridViewAdapter != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityProfileLabelEditorActivity$MyLabelGridViewAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ProfileLabelEditorActivity.4
 * JD-Core Version:    0.7.0.1
 */