package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager;
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
  
  protected void onGetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!this.a.isFinishing()))
    {
      AssistantSettingActivity localAssistantSettingActivity = this.a;
      AssistantSettingActivity.a(localAssistantSettingActivity, localAssistantSettingActivity.g.a(), paramBoolean2);
    }
  }
  
  protected void onGetCommonSwitchFromDetailInfo(boolean paramBoolean, short[] paramArrayOfShort, Map<Short, Short> paramMap)
  {
    if ((paramBoolean) && (AssistantSettingActivity.a(this.a) != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity$EntryListAdapter != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity$EntryListAdapter.a(paramArrayOfShort)))
    {
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.i("AssistantSettingActivity", 0, "onGetCommonSwitchFromDetailInfo");
      }
      AssistantSettingActivity.a(this.a).a();
    }
  }
  
  protected void onGetConnectionsSwitch(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (com.tencent.qphone.base.util.QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetConnectionsSwitch:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramInt2);
      com.tencent.qphone.base.util.QLog.i("AssistantSettingActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      localObject = this.a;
      AssistantSettingActivity.b((AssistantSettingActivity)localObject, ((AssistantSettingActivity)localObject).jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.c() ^ true);
    }
  }
  
  protected void onSetAllowActivateFriend(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.a.isFinishing())
    {
      AssistantSettingActivity localAssistantSettingActivity = this.a;
      AssistantSettingActivity.a(localAssistantSettingActivity, localAssistantSettingActivity.g.a(), paramBoolean2);
    }
  }
  
  protected void onSetCommonSwitchFromDetailInfo(boolean paramBoolean, short paramShort1, short paramShort2)
  {
    CTEntry localCTEntry;
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity$EntryListAdapter == null) {
      localCTEntry = null;
    } else {
      localCTEntry = this.a.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity$EntryListAdapter.a(paramShort1);
    }
    if (localCTEntry == null) {
      return;
    }
    boolean bool2 = com.tencent.TMG.utils.QLog.isColorLevel();
    boolean bool1 = false;
    if (bool2) {
      com.tencent.TMG.utils.QLog.i("AssistantSettingActivity", 0, String.format(Locale.getDefault(), "onSetCommonSwitchFromDetailInfo [%s, %s, %s]", new Object[] { Boolean.valueOf(paramBoolean), Short.valueOf(paramShort1), Short.valueOf(paramShort2) }));
    }
    if (paramShort2 == 1) {
      bool1 = true;
    }
    if ((!paramBoolean) && (bool1 == localCTEntry.e))
    {
      localCTEntry.e ^= true;
      this.a.jdField_a_of_type_ComTencentWidgetHeightAdaptableListView.post(new AssistantSettingActivity.1.1(this, bool1));
    }
  }
  
  protected void onSetConnectionsSwitch(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (com.tencent.qphone.base.util.QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSetConnectionsSwitch:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramInt2);
      com.tencent.qphone.base.util.QLog.i("AssistantSettingActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (!paramBoolean)
    {
      AssistantSettingActivity.a(this.a, 2131718834, 1);
      localObject = this.a;
      AssistantSettingActivity.b((AssistantSettingActivity)localObject, ((AssistantSettingActivity)localObject).jdField_a_of_type_ComTencentMobileqqActivityContactsTopentryCTEntryMng.c() ^ true);
    }
  }
  
  protected void onSetEmotionRecSwitch(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.a.isFinishing())
    {
      if (this.a.app == null) {
        return;
      }
      if (!paramBoolean1)
      {
        AssistantSettingActivity.a(this.a, 2131718834, 1);
        localObject = this.a;
        AssistantSettingActivity.a((AssistantSettingActivity)localObject, ((IStickerRecManager)((AssistantSettingActivity)localObject).app.getRuntimeService(IStickerRecManager.class, "")).isEmotionRecSettingOpen(), AssistantSettingActivity.a(this.a));
        return;
      }
      Object localObject = this.a;
      AssistantSettingActivity.a((AssistantSettingActivity)localObject, paramBoolean2, AssistantSettingActivity.a((AssistantSettingActivity)localObject));
      QQAppInterface localQQAppInterface = this.a.app;
      if (paramBoolean2) {
        localObject = "1";
      } else {
        localObject = "2";
      }
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800A223", "0X800A223", 0, 0, (String)localObject, "", "", "");
    }
  }
  
  protected void onSetPttAutoToTxtSwitch(boolean paramBoolean, Object paramObject)
  {
    if (!paramBoolean)
    {
      QQToast.a(BaseApplication.getContext(), 1, HardCodeUtil.a(2131701001), 0).b(this.a.getTitleBarHeight());
      paramBoolean = ((Boolean)paramObject).booleanValue();
      AssistantSettingActivity.a(this.a, true);
      this.a.e.setChecked(paramBoolean);
      AssistantSettingActivity.a(this.a, paramBoolean);
      AssistantSettingActivity.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssistantSettingActivity.1
 * JD-Core Version:    0.7.0.1
 */