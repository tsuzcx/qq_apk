package com.tencent.mobileqq.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import com.tencent.mobileqq.troop.jointroopsecuritytips.JoinTroopSecurityTipsHelper;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class AddFriendVerifyActivity$20
  extends TroopBusinessObserver
{
  AddFriendVerifyActivity$20(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void onGetAddTroopWebInfo(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QQToast.a(this.a, 2, 2131718553, 1).b(this.a.getTitleBarHeight());
      this.a.setResult(-1);
      if ((this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager != null) && (AddFriendVerifyActivity.a(this.a) != null))
      {
        this.a.getWindow().setSoftInputMode(2);
        this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(AddFriendVerifyActivity.a(this.a).getWindowToken(), 0);
        AddFriendVerifyActivity.a(this.a).clearFocus();
      }
      AddFriendVerifyActivity.a(this.a, false);
      this.a.finish();
    }
    for (;;)
    {
      AddFriendVerifyActivity.b(this.a, 1004);
      return;
      paramString = new AddFriendVerifyActivity.StartRecommendPageTask(this.a, paramString);
      this.a.jdField_a_of_type_AndroidOsHandler.post(paramString);
    }
  }
  
  public void onGetExtShowTroopStatus(boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {}
  
  public void onJoinTroopSecurityTips(boolean paramBoolean, String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddFriendVerifyActivity", 2, "onJoinTroopSecurityTips troopUin:" + paramString + ",tId = " + paramInt + ",time = " + paramLong);
    }
    if ((TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(this.a.jdField_a_of_type_JavaLangString)) || (paramBoolean)) {
      return;
    }
    JoinTroopSecurityTipsHelper.a(this.a.app, paramInt, paramLong, this.a.getActivity());
  }
  
  public void onQueryJoinTroopWhetherHighRisk(boolean paramBoolean, String paramString, int paramInt)
  {
    if (!this.a.jdField_a_of_type_JavaLangString.equals(paramString)) {
      return;
    }
    if (!paramBoolean)
    {
      this.a.f.setVisibility(8);
      this.a.e.setVisibility(8);
      return;
    }
    this.a.b = paramInt;
    if (paramInt != 0)
    {
      switch (this.a.jdField_a_of_type_Int)
      {
      case 3: 
      default: 
        return;
      case 1: 
      case 2: 
        this.a.f.setVisibility(0);
        this.a.e.setVisibility(8);
        ReportController.b(null, "dc00898", "", "", "0X800B5B2", "0X800B5B2", 0, 0, "", "", "", "");
        return;
      }
      this.a.f.setVisibility(8);
      this.a.e.setVisibility(0);
      ReportController.b(null, "dc00898", "", "", "0X800B5B2", "0X800B5B2", 0, 0, "", "", "", "");
      return;
    }
    this.a.f.setVisibility(8);
    this.a.e.setVisibility(8);
  }
  
  public void onSetTroopShowExternalStatus(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = true;
    if ((this.a.jdField_a_of_type_JavaLangString == null) || (!this.a.jdField_a_of_type_JavaLangString.equals(paramString))) {
      return;
    }
    if (!paramBoolean)
    {
      QQToast.a(this.a, this.a.getString(2131696175), 0).b(this.a.getTitleBarHeight());
      AddFriendVerifyActivity.c(this.a);
    }
    paramString = this.a;
    if (paramInt3 == 1) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramString.c = paramBoolean;
      return;
    }
  }
  
  public void onTroopManagerFailed(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      TroopUtils.a(this.a, paramInt2);
      AddFriendVerifyActivity.b(this.a, 1002);
    }
  }
  
  public void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    if (1 == paramInt1) {}
    switch (paramInt2)
    {
    case -1: 
    default: 
      AddFriendVerifyActivity.b(this.a, 1002);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      QQToast.a(this.a, 1, 2131718552, 1).b(this.a.getTitleBarHeight());
    case -2: 
      do
      {
        return;
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        AddFriendVerifyActivity.b(this.a, 1004);
      } while ((this.a.getIntent() == null) || (this.a.getIntent().getExtras() == null));
      if (this.a.getIntent().getExtras().getShort("group_option", (short)2) == 4)
      {
        if (AddFriendVerifyActivity.c(this.a) != null) {
          AddFriendVerifyActivity.c(this.a).setVisibility(0);
        }
        AddFriendVerifyActivity.b(this.a, 1002);
        return;
      }
      ((TroopHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(Long.parseLong(this.a.jdField_a_of_type_JavaLangString), Long.parseLong(this.a.app.getAccount()));
      AddFriendVerifyActivity.a(this.a, true);
      return;
    case 0: 
    case 1: 
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      Object localObject = this.a.getIntent().getStringExtra("param_return_addr");
      AddFriendVerifyActivity.b(this.a, 1003);
      if (localObject != null) {
        QQToast.a(this.a, 2, 2131718553, 1).b(this.a.getTitleBarHeight());
      }
      for (;;)
      {
        try
        {
          paramString = Class.forName((String)localObject);
          localObject = new Intent();
          ((Intent)localObject).setComponent(new ComponentName("com.tencent.mobileqq", paramString.getName()));
          ((Intent)localObject).setFlags(67108864);
          this.a.startActivity((Intent)localObject);
          if (TextUtils.isEmpty(this.a.d)) {
            break;
          }
          paramString = new ArrayList(1);
          paramString.add("admin.qun.qq.com");
          EventApiPlugin.a("closeJoinWebView", null, paramString, null);
          return;
        }
        catch (ClassNotFoundException paramString)
        {
          paramString.printStackTrace();
          this.a.setResult(-1);
          this.a.finish();
          continue;
        }
        if (this.a.getIntent().getBooleanExtra("from_newer_guide", false))
        {
          localObject = new Intent();
          ((Intent)localObject).putExtra("has_operation", true);
          ((Intent)localObject).putExtra("uin", paramString);
          this.a.setResult(-1, (Intent)localObject);
          this.a.finish();
        }
        else if (this.a.getIntent().getBooleanExtra("from_babyq", false))
        {
          this.a.app.getMessageFacade().b("babyq_add_troop");
          localObject = new Intent();
          ((Intent)localObject).putExtra("has_operation", true);
          ((Intent)localObject).putExtra("uin", paramString);
          this.a.setResult(-1, (Intent)localObject);
          this.a.finish();
        }
        else
        {
          paramInt1 = this.a.getIntent().getExtras().getShort("group_option", (short)2);
          paramString = (TroopHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
          localObject = (TroopInfoHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER);
          if ((paramInt1 == 1) || (paramInt1 == 4)) {
            ((TroopInfoHandler)localObject).a(this.a.jdField_a_of_type_JavaLangString, false);
          } else {
            paramString.a(Long.parseLong(this.a.jdField_a_of_type_JavaLangString), Long.parseLong(this.a.app.getAccount()));
          }
        }
      }
    }
    AddFriendVerifyActivity.b(this.a, 1002);
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    QQToast.a(this.a, 1, 2131720199, 1).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.20
 * JD-Core Version:    0.7.0.1
 */