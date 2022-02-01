package com.tencent.mobileqq.activity;

import QQService.SvcDevLoginInfo;
import QQService.SvcRspGetDevLoginInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class RecentLoginDevActivity$4
  extends FriendListObserver
{
  RecentLoginDevActivity$4(RecentLoginDevActivity paramRecentLoginDevActivity) {}
  
  protected void onDelHistoryDevResult(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDelHistoryDevResult isSuccess=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" errorMsg=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" index=");
      localStringBuilder.append(paramInt);
      QLog.d("Q.devlock.RecentLoginDevActivity", 2, localStringBuilder.toString());
    }
    RecentLoginDevActivity.b(this.a);
    if (paramBoolean)
    {
      ReportController.b(this.a.app, "CliOper", "", "", "My_eq", "Delete_eq", 0, 0, "", "", "", "");
      if ((paramInt > -1) && (RecentLoginDevActivity.a(this.a) != null) && (paramInt < RecentLoginDevActivity.a(this.a).size()))
      {
        RecentLoginDevActivity.a(this.a).remove(paramInt);
        paramString = this.a;
        RecentLoginDevActivity.a(paramString, RecentLoginDevActivity.a(paramString));
      }
      QQToast.a(this.a.getApplicationContext(), 2, this.a.getString(2131692006), 0).b(this.a.getTitleBarHeight());
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QQToast.a(this.a.getApplicationContext(), 1, this.a.getString(2131694373), 0).b(this.a.getTitleBarHeight());
      return;
    }
    QQToast.a(this.a.getApplicationContext(), 1, paramString, 0).b(this.a.getTitleBarHeight());
  }
  
  protected void onGetHistoryDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    RecentLoginDevActivity.b(this.a);
    Object localObject;
    if ((paramBoolean) && (paramSvcRspGetDevLoginInfo != null) && (paramSvcRspGetDevLoginInfo.iResult == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.devlock.RecentLoginDevActivity", 2, "onGetHistoryDevResult success");
      }
      RecentLoginDevActivity.a(this.a, paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo);
      if (QLog.isColorLevel())
      {
        QLog.d("Q.devlock.RecentLoginDevActivity", 2, "------------------------------------------------------------------------------");
        paramSvcRspGetDevLoginInfo = RecentLoginDevActivity.a(this.a).iterator();
        while (paramSvcRspGetDevLoginInfo.hasNext())
        {
          localObject = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.next();
          if (localObject != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("SvcDevLoginInfo.iAppId=");
            localStringBuilder.append(((SvcDevLoginInfo)localObject).iAppId);
            localStringBuilder.append(" iLoginTime=");
            localStringBuilder.append(((SvcDevLoginInfo)localObject).iLoginTime);
            localStringBuilder.append(" strLoginLocation=");
            localStringBuilder.append(((SvcDevLoginInfo)localObject).strLoginLocation);
            localStringBuilder.append(" iLoginPlatform=");
            localStringBuilder.append(((SvcDevLoginInfo)localObject).iLoginPlatform);
            localStringBuilder.append(" strDeviceName=");
            localStringBuilder.append(((SvcDevLoginInfo)localObject).strDeviceName);
            localStringBuilder.append(" strDeviceTypeInfo");
            localStringBuilder.append(((SvcDevLoginInfo)localObject).strDeviceTypeInfo);
            QLog.d("Q.devlock.RecentLoginDevActivity", 2, localStringBuilder.toString());
          }
        }
        QLog.d("Q.devlock.RecentLoginDevActivity", 2, "------------------------------------------------------------------------------");
      }
      paramSvcRspGetDevLoginInfo = this.a;
      RecentLoginDevActivity.a(paramSvcRspGetDevLoginInfo, RecentLoginDevActivity.a(paramSvcRspGetDevLoginInfo));
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetHistoryDevResult failed isSuccess=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("Q.devlock.RecentLoginDevActivity", 2, ((StringBuilder)localObject).toString());
      if (paramSvcRspGetDevLoginInfo == null)
      {
        QLog.d("Q.devlock.RecentLoginDevActivity", 2, "onGetHistoryDevResult failed data is null");
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onGetHistoryDevResult failed data.iResult=");
        ((StringBuilder)localObject).append(paramSvcRspGetDevLoginInfo.iResult);
        QLog.d("Q.devlock.RecentLoginDevActivity", 2, ((StringBuilder)localObject).toString());
      }
    }
    QQToast.a(this.a.getActivity(), 1, this.a.getString(2131692017), 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RecentLoginDevActivity.4
 * JD-Core Version:    0.7.0.1
 */