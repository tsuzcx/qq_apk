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
      if (!this.a.a(paramProfileLabelInfo.labelId, this.a.l))
      {
        paramBoolean = this.a;
        if (!paramBoolean.a(paramBoolean.l))
        {
          ReportController.b(this.a.app, "CliOper", "", "", "card_mall", "0X80066C7", 0, 0, "1", "", "", "");
          this.a.l.add(paramProfileLabelInfo);
          break label156;
        }
      }
      paramProfileLabelInfo = this.a;
      if (paramProfileLabelInfo.a(paramProfileLabelInfo.l)) {
        this.a.b(2131890926);
      }
    }
    else
    {
      if (!this.a.a(paramProfileLabelInfo.labelId, this.a.l)) {
        return;
      }
      paramBoolean = this.a;
      paramBoolean.a(paramProfileLabelInfo, paramBoolean.l);
    }
    label156:
    this.a.k.c(paramProfileLabelInfo, paramToggleButton);
    paramProfileLabelInfo = this.a;
    paramProfileLabelInfo.a(paramProfileLabelInfo.l.size());
    if (this.a.e != null) {
      this.a.e.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ProfileLabelEditorActivity.4
 * JD-Core Version:    0.7.0.1
 */