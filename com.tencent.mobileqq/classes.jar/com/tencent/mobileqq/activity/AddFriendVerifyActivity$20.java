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
import com.tencent.mobileqq.troop.temporaryban.TemporaryBanJoinTroopAbilityHelper;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import trpc.mizarproto.passthrough.FunctionLockMsg.FunctionLockBeatRsp;

class AddFriendVerifyActivity$20
  extends TroopMngObserver
{
  AddFriendVerifyActivity$20(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1)
    {
      this.a.a.dismiss();
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
            this.a.a.dismiss();
            QQToast.makeText(this.a, 1, 2131915702, 1).show(this.a.getTitleBarHeight());
            return;
          }
          AddFriendVerifyActivity.b(this.a, 1002);
          this.a.a.dismiss();
          QQToast.makeText(this.a, 1, 2131917537, 1).show(this.a.getTitleBarHeight());
          return;
        }
        this.a.a.dismiss();
        Object localObject = this.a.getIntent().getStringExtra("param_return_addr");
        AddFriendVerifyActivity.b(this.a, 1003);
        if (localObject != null)
        {
          QQToast.makeText(this.a, 2, 2131915703, 1).show(this.a.getTitleBarHeight());
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
          this.a.app.getMessageFacade().d("babyq_add_troop");
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
            paramString.a(Long.parseLong(this.a.o), Long.parseLong(this.a.app.getAccount()));
          } else {
            ((ITroopInfoHandler)localObject).a(this.a.o, false);
          }
        }
        if (!TextUtils.isEmpty(this.a.x))
        {
          paramString = new ArrayList(1);
          paramString.add("admin.qun.qq.com");
          EventApiPlugin.a("closeJoinWebView", null, paramString, null);
        }
      }
      else
      {
        this.a.a.dismiss();
        AddFriendVerifyActivity.b(this.a, 1004);
        if ((this.a.getIntent() != null) && (this.a.getIntent().getExtras() != null))
        {
          if (this.a.getIntent().getExtras().getShort("group_option", (short)2) == 4)
          {
            if (AddFriendVerifyActivity.r(this.a) != null) {
              AddFriendVerifyActivity.r(this.a).setVisibility(0);
            }
            AddFriendVerifyActivity.b(this.a, 1002);
            return;
          }
          ((ITroopMngHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER)).a(Long.parseLong(this.a.o), Long.parseLong(this.a.app.getAccount()));
          AddFriendVerifyActivity.b(this.a, true);
        }
      }
    }
  }
  
  protected void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QQToast.makeText(this.a, 2, 2131915703, 1).show(this.a.getTitleBarHeight());
      this.a.setResult(-1);
      if ((this.a.s != null) && (AddFriendVerifyActivity.b(this.a) != null))
      {
        this.a.getWindow().setSoftInputMode(2);
        this.a.s.hideSoftInputFromWindow(AddFriendVerifyActivity.b(this.a).getWindowToken(), 0);
        AddFriendVerifyActivity.b(this.a).clearFocus();
      }
      AddFriendVerifyActivity.b(this.a, false);
      this.a.finish();
    }
    else
    {
      paramString = new AddFriendVerifyActivity.StartRecommendPageTask(this.a, paramString);
      this.a.D.post(paramString);
    }
    AddFriendVerifyActivity.b(this.a, 1004);
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (!this.a.o.equals(paramString)) {
      return;
    }
    if (!paramBoolean)
    {
      this.a.z.setVisibility(8);
      this.a.y.setVisibility(8);
      return;
    }
    paramString = this.a;
    paramString.B = paramInt;
    if (paramInt != 0)
    {
      paramInt = paramString.A;
      if ((paramInt != 1) && (paramInt != 2))
      {
        if ((paramInt != 4) && (paramInt != 5)) {
          return;
        }
        this.a.z.setVisibility(8);
        this.a.y.setVisibility(0);
        ReportController.b(null, "dc00898", "", "", "0X800B5B2", "0X800B5B2", 0, 0, "", "", "", "");
        return;
      }
      this.a.z.setVisibility(0);
      this.a.y.setVisibility(8);
      ReportController.b(null, "dc00898", "", "", "0X800B5B2", "0X800B5B2", 0, 0, "", "", "", "");
      return;
    }
    paramString.z.setVisibility(8);
    this.a.y.setVisibility(8);
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
    if ((!TextUtils.isEmpty(this.a.o)) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(this.a.o)))
    {
      if (paramBoolean) {
        return;
      }
      JoinTroopSecurityTipsHelper.a(this.a.app, paramInt, paramLong, this.a.getActivity());
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, FunctionLockMsg.FunctionLockBeatRsp paramFunctionLockBeatRsp)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onJoinTroopTemporaryBan troopUin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" isSuccess = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("AddFriendVerifyActivity", 2, localStringBuilder.toString());
    }
    if ((!TextUtils.isEmpty(this.a.o)) && (this.a.o.equals(paramString)))
    {
      if (paramBoolean) {
        return;
      }
      this.a.a.dismiss();
      TemporaryBanJoinTroopAbilityHelper.a().a(this.a.app, this.a.getActivity(), paramFunctionLockBeatRsp, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.20
 * JD-Core Version:    0.7.0.1
 */