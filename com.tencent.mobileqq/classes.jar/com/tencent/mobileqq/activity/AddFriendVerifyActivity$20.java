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
import com.tencent.mobileqq.jsp.EventApiPlugin;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.handler.ITroopInfoHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopMngHandler;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.jointroopsecuritytips.JoinTroopSecurityTipsHelper;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class AddFriendVerifyActivity$20
  extends TroopMngObserver
{
  AddFriendVerifyActivity$20(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      ((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).handleJoinTroopFailed(this.a, paramInt2);
      AddFriendVerifyActivity.b(this.a, 1002);
    }
  }
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (1 == paramInt1) {
      if (paramInt2 != -2)
      {
        if ((paramInt2 != 0) && (paramInt2 != 1))
        {
          if (paramInt2 != 2)
          {
            AddFriendVerifyActivity.b(this.a, 1002);
            this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
            QQToast.a(this.a, 1, 2131718220, 1).b(this.a.getTitleBarHeight());
            return;
          }
          AddFriendVerifyActivity.b(this.a, 1002);
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
          QQToast.a(this.a, 1, 2131719932, 1).b(this.a.getTitleBarHeight());
          return;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        Object localObject = this.a.getIntent().getStringExtra("param_return_addr");
        AddFriendVerifyActivity.b(this.a, 1003);
        if (localObject != null)
        {
          QQToast.a(this.a, 2, 2131718221, 1).b(this.a.getTitleBarHeight());
          try
          {
            paramString = Class.forName((String)localObject);
            localObject = new Intent();
            ((Intent)localObject).setComponent(new ComponentName("com.tencent.mobileqq", paramString.getName()));
            ((Intent)localObject).setFlags(67108864);
            this.a.startActivity((Intent)localObject);
          }
          catch (ClassNotFoundException paramString)
          {
            paramString.printStackTrace();
            this.a.setResult(-1);
            this.a.finish();
          }
        }
        else if (this.a.getIntent().getBooleanExtra("from_newer_guide", false))
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
          paramString = (ITroopMngHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER);
          localObject = (ITroopInfoHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER);
          if ((paramInt1 != 1) && (paramInt1 != 4)) {
            paramString.a(Long.parseLong(this.a.jdField_a_of_type_JavaLangString), Long.parseLong(this.a.app.getAccount()));
          } else {
            ((ITroopInfoHandler)localObject).a(this.a.jdField_a_of_type_JavaLangString, false);
          }
        }
        if (!TextUtils.isEmpty(this.a.d))
        {
          paramString = new ArrayList(1);
          paramString.add("admin.qun.qq.com");
          EventApiPlugin.a("closeJoinWebView", null, paramString, null);
        }
      }
      else
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        AddFriendVerifyActivity.b(this.a, 1004);
        if ((this.a.getIntent() != null) && (this.a.getIntent().getExtras() != null))
        {
          if (this.a.getIntent().getExtras().getShort("group_option", (short)2) == 4)
          {
            if (AddFriendVerifyActivity.c(this.a) != null) {
              AddFriendVerifyActivity.c(this.a).setVisibility(0);
            }
            AddFriendVerifyActivity.b(this.a, 1002);
            return;
          }
          ((ITroopMngHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER)).a(Long.parseLong(this.a.jdField_a_of_type_JavaLangString), Long.parseLong(this.a.app.getAccount()));
          AddFriendVerifyActivity.a(this.a, true);
        }
      }
    }
  }
  
  protected void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QQToast.a(this.a, 2, 2131718221, 1).b(this.a.getTitleBarHeight());
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
    else
    {
      paramString = new AddFriendVerifyActivity.StartRecommendPageTask(this.a, paramString);
      this.a.jdField_a_of_type_AndroidOsHandler.post(paramString);
    }
    AddFriendVerifyActivity.b(this.a, 1004);
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
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
    paramString = this.a;
    paramString.b = paramInt;
    if (paramInt != 0)
    {
      paramInt = paramString.jdField_a_of_type_Int;
      if ((paramInt != 1) && (paramInt != 2))
      {
        if ((paramInt != 4) && (paramInt != 5)) {
          return;
        }
        this.a.f.setVisibility(8);
        this.a.e.setVisibility(0);
        ReportController.b(null, "dc00898", "", "", "0X800B5B2", "0X800B5B2", 0, 0, "", "", "", "");
        return;
      }
      this.a.f.setVisibility(0);
      this.a.e.setVisibility(8);
      ReportController.b(null, "dc00898", "", "", "0X800B5B2", "0X800B5B2", 0, 0, "", "", "", "");
      return;
    }
    paramString.f.setVisibility(8);
    this.a.e.setVisibility(8);
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onJoinTroopSecurityTips troopUin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",tId = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",time = ");
      localStringBuilder.append(paramLong);
      QLog.d("AddFriendVerifyActivity", 2, localStringBuilder.toString());
    }
    if ((!TextUtils.isEmpty(this.a.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(this.a.jdField_a_of_type_JavaLangString)))
    {
      if (paramBoolean) {
        return;
      }
      JoinTroopSecurityTipsHelper.a(this.a.app, paramInt, paramLong, this.a.getActivity());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.20
 * JD-Core Version:    0.7.0.1
 */