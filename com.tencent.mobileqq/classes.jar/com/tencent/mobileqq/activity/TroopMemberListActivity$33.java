package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.proxy.QProxyManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class TroopMemberListActivity$33
  extends Handler
{
  TroopMemberListActivity$33(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a.isFinishing()) {
      return;
    }
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("handleMessage,msg.what:");
      ((StringBuilder)???).append(paramMessage.what);
      QLog.d("TroopMemberListActivityget_troop_member", 2, ((StringBuilder)???).toString());
    }
    int i = paramMessage.what;
    boolean bool2 = true;
    double d1;
    double d2;
    int j;
    Object localObject2;
    boolean bool1;
    switch (i)
    {
    case 3: 
    case 4: 
    case 10: 
    default: 
    case 16: 
      if (this.a.mAdapter != null)
      {
        if (this.a.mAdapter.e != null) {
          this.a.mAdapter.e.clear();
        }
        this.a.mAdapter.c();
        return;
      }
      break;
    case 15: 
      if ((this.a.mProgressDialog != null) && (this.a.mProgressDialog.isShowing()))
      {
        this.a.mProgressDialog.dismiss();
        return;
      }
      break;
    case 14: 
      this.a.mLoadingLayout.setVisibility(0);
      return;
    case 13: 
      paramMessage = this.a;
      paramMessage.mFakeProgess += TroopMemberListActivity.FAKE_PROGRESS_DELTA;
      if ((this.a.mFakeProgess > this.a.mProgressBar.getProgress()) && (this.a.mFakeProgess < 90.0D) && (TroopMemberListActivity.access$2000(this.a) > 0))
      {
        i = (int)this.a.mFakeProgess;
        d1 = TroopMemberListActivity.access$2000(this.a);
        d2 = this.a.mFakeProgess;
        Double.isNaN(d1);
        j = (int)(d1 * d2 / 100.0D);
        paramMessage = this.a;
        TroopMemberListActivity.access$2100(paramMessage, j, TroopMemberListActivity.access$2000(paramMessage), i);
        this.a.mHandler.sendMessageDelayed(this.a.mHandler.obtainMessage(13), 800L);
        return;
      }
      break;
    case 12: 
      synchronized (this.a)
      {
        TroopMemberListActivity.access$2210(this.a);
        localObject2 = (List)paramMessage.obj;
        if ((localObject2 == null) && (this.a.mFrom != 14)) {
          return;
        }
        if (this.a.mLoadingLayout.getVisibility() == 0)
        {
          this.a.mHandler.removeMessages(13);
          i = paramMessage.arg1;
          d1 = i;
          Double.isNaN(d1);
          i = TroopMemberListActivity.access$2000(this.a);
          d2 = i;
          Double.isNaN(d2);
          d1 = d1 * 1.0D / d2;
          d1 = Math.min(d1 + 0.9D, 1.0D);
          i = (int)(100.0D * d1);
          if (i > this.a.mProgressBar.getProgress())
          {
            j = TroopMemberListActivity.access$2000(this.a);
            d2 = j;
            Double.isNaN(d2);
            j = (int)(d2 * d1);
            TroopMemberListActivity.access$2100(this.a, j, TroopMemberListActivity.access$2000(this.a), i);
          }
        }
        if (localObject2 != null) {
          this.a.mListData.addAll((Collection)localObject2);
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("handleMessage, mJobCount left:");
          ((StringBuilder)localObject2).append(TroopMemberListActivity.access$2200(this.a));
          ((StringBuilder)localObject2).append("mATroopMemberList.size():");
          ((StringBuilder)localObject2).append(this.a.mListData.size());
          QLog.d("TroopMemberListActivityget_troop_member", 2, ((StringBuilder)localObject2).toString());
        }
        if (TroopMemberListActivity.access$2200(this.a) <= 0) {
          TroopMemberListActivity.access$1602(this.a, true);
        }
        if ((TroopMemberListActivity.access$1600(this.a)) && (TroopMemberListActivity.access$1500(this.a)))
        {
          if (this.a.mListData.isEmpty()) {
            return;
          }
          this.a.stopTitleProgress();
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("handleMessage real totalTime:");
            ((StringBuilder)localObject2).append(System.currentTimeMillis() - TroopMemberListActivity.access$2300(this.a));
            ((StringBuilder)localObject2).append("start refreshUI");
            QLog.d("TroopMemberListActivityget_troop_member", 2, ((StringBuilder)localObject2).toString());
          }
          localObject2 = (QProxyManager)this.a.app.getProxyManagerInner();
          if (localObject2 != null) {
            ((QProxyManager)localObject2).notifyRefreshTroopMember();
          }
          paramMessage.obj = this.a.mAdapter.b();
          TroopMemberListActivity.access$1900(this.a, paramMessage);
        }
        return;
      }
    case 11: 
      paramMessage = (TroopInfo)paramMessage.obj;
      if (paramMessage.troopowneruin != null) {
        this.a.mTroopOwnerUin = paramMessage.troopowneruin;
      }
      if (paramMessage.Administrator != null) {
        this.a.mTroopAdminUins = paramMessage.Administrator;
      }
      ??? = this.a;
      bool1 = bool2;
      if (!((TroopMemberListActivity)???).app.getCurrentAccountUin().equals(paramMessage.troopowneruin)) {
        if ((this.a.mTroopAdminUins != null) && (this.a.mTroopAdminUins.contains(this.a.app.getCurrentAccountUin()))) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      ((TroopMemberListActivity)???).mIsTroopAdmin = bool1;
      if ((this.a.mTroopOwnerUin != null) && (this.a.mTroopOwnerUin.equals(this.a.app.getCurrentAccountUin()))) {
        this.a.mMyTroopRole = "0";
      } else if ((this.a.mTroopAdminUins != null) && (this.a.mTroopAdminUins.contains(this.a.app.getCurrentAccountUin()))) {
        this.a.mMyTroopRole = "1";
      }
      if (this.a.mAdapter != null)
      {
        this.a.mAdapter.c();
        return;
      }
      break;
    case 9: 
      if (this.a.mAdapter != null)
      {
        this.a.mAdapter.c();
        return;
      }
      break;
    case 8: 
      paramMessage = (Object[])paramMessage.obj;
      bool1 = ((Boolean)paramMessage[0]).booleanValue();
      paramMessage = (ArrayList)paramMessage[1];
      ??? = (IChatSettingForTroopApi)QRoute.api(IChatSettingForTroopApi.class);
      localObject2 = this.a;
      ((IChatSettingForTroopApi)???).inviteMember((Activity)localObject2, ((TroopMemberListActivity)localObject2).mTroopUin, bool1, paramMessage, 1);
      return;
    case 7: 
      if ((this.a.mProgressDialog != null) && (this.a.mProgressDialog.isShowing())) {
        this.a.mProgressDialog.dismiss();
      }
      paramMessage = this.a;
      QQToast.makeText(paramMessage, paramMessage.getString(2131888431), 0).show(this.a.mTitleBar.getHeight());
      return;
    case 6: 
      if (this.a.mAdapter != null)
      {
        if (this.a.mAdapter.e != null) {
          this.a.mAdapter.e.clear();
        }
        this.a.mAdapter.c();
      }
      if ((this.a.mProgressDialog != null) && (this.a.mProgressDialog.isShowing())) {
        this.a.mProgressDialog.dismiss();
      }
      paramMessage = this.a;
      QQToast.makeText(paramMessage, paramMessage.getString(2131888432), 0).show(this.a.mTitleBar.getHeight());
      TroopMemberListActivity.access$200(this.a);
      return;
    case 5: 
      this.a.stopTitleProgress();
      return;
    case 2: 
      this.a.stopTitleProgress();
    case 1: 
      TroopMemberListActivity.access$1900(this.a, paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.33
 * JD-Core Version:    0.7.0.1
 */