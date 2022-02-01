package com.tencent.mobileqq.activity;

import QQService.SvcDevLoginInfo;
import QQService.SvcRspGetDevLoginInfo;
import android.text.TextUtils;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.QQSettingUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.manager.WtloginManager;

class AuthDevActivity$7
  extends FriendListObserver
{
  AuthDevActivity$7(AuthDevActivity paramAuthDevActivity) {}
  
  public void onDelAuthDevResult(boolean paramBoolean, String paramString, int paramInt)
  {
    boolean bool = false;
    QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "onDelAuthDevResult.isSuccess=", Boolean.valueOf(paramBoolean), " errorMsg=", paramString, " index=", Integer.valueOf(paramInt) });
    AuthDevActivity.access$1800(this.a);
    Object localObject;
    if (AuthDevActivity.access$900(this.a)) {
      localObject = AuthDevActivity.access$800(this.a);
    }
    while (paramBoolean)
    {
      if ((paramInt > -1) && (paramInt < ((List)localObject).size()))
      {
        paramString = (SvcDevLoginInfo)((List)localObject).get(paramInt);
        if (Arrays.equals(NetConnInfoCenter.GUID, paramString.vecGuid))
        {
          this.a.app.updateSubAccountLogin(this.a.app.getAccount(), false);
          this.a.app.getApplication().refreAccountList();
          QQSettingUtil.a(this.a, this.a.app, true);
          paramString = this.a.app.getManager(1);
          paramBoolean = bool;
          if (paramString == null) {
            paramBoolean = true;
          }
          QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "clear login sig, manage is null : [", Boolean.valueOf(paramBoolean), "]" });
          if (paramString != null)
          {
            paramString = (WtloginManager)paramString;
            localObject = this.a.app.getAccount();
            paramString.clearUserFastLoginData((String)localObject, 16L);
            paramString.clearUserFastLoginData((String)localObject, 1600001540L);
            paramString.refreshMemorySig();
          }
          return;
          localObject = AuthDevActivity.access$500(this.a);
          continue;
        }
        if (paramInt < ((List)localObject).size())
        {
          ((List)localObject).remove(paramInt);
          AuthDevActivity.access$1600(this.a, (List)localObject);
        }
      }
      QQToast.a(this.a.getApplicationContext(), 2, this.a.getString(2131692087), 0).b(this.a.getTitleBarHeight());
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QQToast.a(this.a.getApplicationContext(), 1, this.a.getString(2131692086), 0).b(this.a.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a.getApplicationContext(), 1, paramString, 0).b(this.a.getTitleBarHeight());
  }
  
  public void onDelHistoryDevResult(boolean paramBoolean, String paramString, int paramInt)
  {
    QLog.d("Q.devlock.AuthDevActivity", 1, "onDelHistoryDevResult isSuccess=" + paramBoolean + " errorMsg=" + paramString + " index=" + paramInt);
    AuthDevActivity.access$1800(this.a);
    if (paramBoolean)
    {
      ReportController.b(this.a.app, "CliOper", "", "", "My_eq", "Delete_eq", 0, 0, "", "", "", "");
      if ((paramInt > -1) && (AuthDevActivity.access$500(this.a) != null) && (paramInt < AuthDevActivity.access$500(this.a).size()))
      {
        AuthDevActivity.access$500(this.a).remove(paramInt);
        AuthDevActivity.access$1600(this.a, AuthDevActivity.access$500(this.a));
      }
      QQToast.a(this.a.getApplicationContext(), 2, this.a.getString(2131692087), 0).b(this.a.getTitleBarHeight());
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QQToast.a(this.a.getApplicationContext(), 1, this.a.getString(2131694408), 0).b(this.a.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a.getApplicationContext(), 1, paramString, 0).b(this.a.getTitleBarHeight());
  }
  
  public void onGetAuthDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    AuthDevActivity.access$1400(this.a).setVisibility(8);
    if (!AuthDevActivity.access$900(this.a)) {
      return;
    }
    if ((paramBoolean) && (paramSvcRspGetDevLoginInfo != null) && (paramSvcRspGetDevLoginInfo.iResult == 0))
    {
      QLog.d("Q.devlock.AuthDevActivity", 1, "onGetAuthDevResult.success");
      AuthDevActivity.access$802(this.a, paramSvcRspGetDevLoginInfo.vecAuthLoginDevInfo);
      if (QLog.isColorLevel())
      {
        QLog.d("Q.devlock.AuthDevActivity", 2, "------------------------------------------------------------------------------");
        paramSvcRspGetDevLoginInfo = AuthDevActivity.access$800(this.a).iterator();
        while (paramSvcRspGetDevLoginInfo.hasNext())
        {
          SvcDevLoginInfo localSvcDevLoginInfo = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.next();
          if (localSvcDevLoginInfo != null) {
            QLog.d("Q.devlock.AuthDevActivity", 2, "SvcDevLoginInfo.iAppId=" + localSvcDevLoginInfo.iAppId + " iLoginTime=" + localSvcDevLoginInfo.iLoginTime + " strLoginLocation=" + localSvcDevLoginInfo.strLoginLocation + " iLoginPlatform=" + localSvcDevLoginInfo.iLoginPlatform + " strDeviceName=" + localSvcDevLoginInfo.strDeviceName + " strDeviceTypeInfo" + localSvcDevLoginInfo.strDeviceTypeInfo);
          }
        }
        QLog.d("Q.devlock.AuthDevActivity", 2, "------------------------------------------------------------------------------");
      }
      AuthDevActivity.access$1600(this.a, AuthDevActivity.access$800(this.a));
      return;
    }
    QLog.d("Q.devlock.AuthDevActivity", 1, "onGetAuthDevResult.isSuccess=" + paramBoolean);
    if (paramSvcRspGetDevLoginInfo == null) {
      QLog.d("Q.devlock.AuthDevActivity", 1, "onGetAuthDevResult.data is null");
    }
    for (;;)
    {
      AuthDevActivity.access$1700(this.a).setVisibility(4);
      QQToast.a(this.a, 1, this.a.getString(2131692098), 0).b(this.a.getTitleBarHeight());
      return;
      QLog.d("Q.devlock.AuthDevActivity", 1, "onGetAuthDevResult.data.iResult=" + paramSvcRspGetDevLoginInfo.iResult);
    }
  }
  
  public void onGetHistoryDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    AuthDevActivity.access$1400(this.a).setVisibility(8);
    if ((paramBoolean) && (paramSvcRspGetDevLoginInfo != null) && (paramSvcRspGetDevLoginInfo.iResult == 0))
    {
      QLog.d("Q.devlock.AuthDevActivity", 1, "onGetHistoryDevResult success");
      AuthDevActivity.access$500(this.a).addAll(paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo);
      AuthDevActivity.access$1600(this.a, AuthDevActivity.access$500(this.a));
      return;
    }
    String str;
    if (paramSvcRspGetDevLoginInfo == null)
    {
      str = "";
      if (paramSvcRspGetDevLoginInfo != null) {
        break label176;
      }
    }
    label176:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "onGetHistoryDevResult fail isSuccess=", Boolean.valueOf(paramBoolean), " data==null ? ", Boolean.valueOf(bool), "errorResult : ", str });
      QQToast.a(this.a.getActivity(), 1, this.a.getString(2131692098), 0).b(this.a.getTitleBarHeight());
      return;
      str = String.valueOf(paramSvcRspGetDevLoginInfo.iResult);
      break;
    }
  }
  
  public void onGetLoginDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    AuthDevActivity.access$1400(this.a).setVisibility(8);
    if ((paramBoolean) && (paramSvcRspGetDevLoginInfo != null) && (paramSvcRspGetDevLoginInfo.iResult == 0))
    {
      QLog.d("Q.devlock.AuthDevActivity", 1, "onGetLoginDevResult success");
      AuthDevActivity.access$1502(this.a, paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo);
      AuthDevActivity.access$500(this.a).addAll(0, AuthDevActivity.access$1500(this.a));
      AuthDevActivity.access$1600(this.a, AuthDevActivity.access$500(this.a));
      return;
    }
    String str;
    if (paramSvcRspGetDevLoginInfo == null)
    {
      str = "";
      if (paramSvcRspGetDevLoginInfo != null) {
        break label192;
      }
    }
    label192:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("Q.devlock.AuthDevActivity", 1, new Object[] { "onGetLoginDevResult fail isSuccess=", Boolean.valueOf(paramBoolean), " data==null ? ", Boolean.valueOf(bool), "errorResult : ", str });
      QQToast.a(this.a.getActivity(), 1, this.a.getString(2131692098), 0).b(this.a.getTitleBarHeight());
      return;
      str = String.valueOf(paramSvcRspGetDevLoginInfo.iResult);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevActivity.7
 * JD-Core Version:    0.7.0.1
 */