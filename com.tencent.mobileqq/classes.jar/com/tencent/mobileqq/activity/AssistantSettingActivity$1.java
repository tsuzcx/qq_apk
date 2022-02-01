package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntry;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryListener;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormMultiLineSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.HeightAdaptableListView;
import java.util.Locale;
import java.util.Map;

class AssistantSettingActivity$1
  extends CardObserver
{
  AssistantSettingActivity$1(AssistantSettingActivity paramAssistantSettingActivity) {}
  
  public void onGetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!this.a.isFinishing())) {
      AssistantSettingActivity.a(this.a, this.a.g.a(), paramBoolean2);
    }
  }
  
  public void onGetCommonSwitchFromDetailInfo(boolean paramBoolean, short[] paramArrayOfShort, Map<Short, Short> paramMap)
  {
    if ((paramBoolean) && (AssistantSettingActivity.a(this.a) != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity$EntryListAdapter != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity$EntryListAdapter.a(paramArrayOfShort)))
    {
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.i("AssistantSettingActivity", 0, "onGetCommonSwitchFromDetailInfo");
      }
      AssistantSettingActivity.a(this.a).a();
    }
  }
  
  public void onGetConnectionsSwitch(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.i("AssistantSettingActivity", 2, "onGetConnectionsSwitch:" + paramBoolean + " " + paramInt1 + " " + paramInt2);
    }
    AssistantSettingActivity localAssistantSettingActivity;
    if (paramBoolean)
    {
      localAssistantSettingActivity = this.a;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.c()) {
        break label81;
      }
    }
    label81:
    for (paramBoolean = true;; paramBoolean = false)
    {
      AssistantSettingActivity.b(localAssistantSettingActivity, paramBoolean);
      return;
    }
  }
  
  public void onSetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.a.isFinishing()) {
      AssistantSettingActivity.a(this.a, this.a.g.a(), paramBoolean2);
    }
  }
  
  public void onSetCommonSwitchFromDetailInfo(boolean paramBoolean, short paramShort1, short paramShort2)
  {
    boolean bool2 = true;
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity$EntryListAdapter == null) {}
    for (CTEntry localCTEntry = null; localCTEntry == null; localCTEntry = this.a.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity$EntryListAdapter.a(paramShort1)) {
      return;
    }
    if (com.tencent.TMG.utils.QLog.isColorLevel()) {
      com.tencent.TMG.utils.QLog.i("AssistantSettingActivity", 0, String.format(Locale.getDefault(), "onSetCommonSwitchFromDetailInfo [%s, %s, %s]", new Object[] { Boolean.valueOf(paramBoolean), Short.valueOf(paramShort1), Short.valueOf(paramShort2) }));
    }
    boolean bool1;
    if (paramShort2 == 1)
    {
      bool1 = true;
      label91:
      if ((paramBoolean) || (bool1 != localCTEntry.e)) {
        break label148;
      }
      if (localCTEntry.e) {
        break label150;
      }
    }
    label148:
    label150:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      localCTEntry.e = paramBoolean;
      this.a.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.post(new AssistantSettingActivity.1.1(this, bool1));
      return;
      bool1 = false;
      break label91;
      break;
    }
  }
  
  public void onSetConnectionsSwitch(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.i("AssistantSettingActivity", 2, "onSetConnectionsSwitch:" + paramBoolean + " " + paramInt1 + " " + paramInt2);
    }
    AssistantSettingActivity localAssistantSettingActivity;
    if (!paramBoolean)
    {
      AssistantSettingActivity.a(this.a, 2131719116, 1);
      localAssistantSettingActivity = this.a;
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.c()) {
        break label95;
      }
    }
    label95:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      AssistantSettingActivity.b(localAssistantSettingActivity, paramBoolean);
      return;
    }
  }
  
  public void onSetEmotionRecSwitch(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.a.isFinishing()) || (this.a.app == null)) {
      return;
    }
    if (!paramBoolean1)
    {
      AssistantSettingActivity.a(this.a, 2131719116, 1);
      AssistantSettingActivity.a(this.a, StickerRecManager.a(this.a.app).b(), AssistantSettingActivity.a(this.a));
      return;
    }
    AssistantSettingActivity.a(this.a, paramBoolean2, AssistantSettingActivity.a(this.a));
    QQAppInterface localQQAppInterface = this.a.app;
    if (paramBoolean2) {}
    for (String str = "1";; str = "2")
    {
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800A223", "0X800A223", 0, 0, str, "", "", "");
      return;
    }
  }
  
  public void onSetPttAutoToTxtSwitch(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
    {
      QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131700858), 0).b(this.a.getTitleBarHeight());
      paramBoolean = ((Boolean)paramObject).booleanValue();
      AssistantSettingActivity.a(this.a, true);
      this.a.e.setChecked(paramBoolean);
      AssistantSettingActivity.a(this.a, paramBoolean);
      AssistantSettingActivity.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity.1
 * JD-Core Version:    0.7.0.1
 */