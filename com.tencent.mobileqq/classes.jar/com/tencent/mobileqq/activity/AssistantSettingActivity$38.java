package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntry;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HeightAdaptableListView;
import mqq.app.AppRuntime;

class AssistantSettingActivity$38
  implements CompoundButton.OnCheckedChangeListener
{
  AssistantSettingActivity$38(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = 1;
    int k = this.a.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.getChildCount();
    int i = 0;
    Object localObject;
    if (i < k)
    {
      localObject = this.a.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.getChildAt(i);
      if ((localObject instanceof FormSwitchItem))
      {
        localObject = (FormSwitchItem)localObject;
        if (paramCompoundButton != ((FormSwitchItem)localObject).a()) {}
      }
    }
    for (;;)
    {
      if ((localObject == null) || (!(((FormSwitchItem)localObject).getTag() instanceof CTEntry))) {}
      CTEntry localCTEntry;
      boolean bool;
      label109:
      do
      {
        EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
        return;
        i += 1;
        break;
        localCTEntry = (CTEntry)((FormSwitchItem)localObject).getTag();
        if (paramBoolean) {
          break label267;
        }
        bool = true;
        localCTEntry.e = bool;
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.a(localCTEntry, localCTEntry.e);
        }
        localObject = this.a.app;
        k = localCTEntry.a;
        i = j;
        if (localCTEntry.e) {
          i = 2;
        }
        ReportController.b((AppRuntime)localObject, "dc00898", "", "", "0X80097A0", "0X80097A0", k, 0, String.valueOf(i), "", "", "");
      } while (localCTEntry.a != 3);
      QQAppInterface localQQAppInterface = this.a.app;
      if (paramBoolean)
      {
        localObject = "0X8009C0A";
        label227:
        if (!paramBoolean) {
          break label280;
        }
      }
      label267:
      label280:
      for (String str = "0X8009C0A";; str = "0X8009C0B")
      {
        ReportController.b(localQQAppInterface, "dc00898", "", "", (String)localObject, str, localCTEntry.a, 0, "", "", "", "");
        break;
        bool = false;
        break label109;
        localObject = "0X8009C0B";
        break label227;
      }
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity.38
 * JD-Core Version:    0.7.0.1
 */