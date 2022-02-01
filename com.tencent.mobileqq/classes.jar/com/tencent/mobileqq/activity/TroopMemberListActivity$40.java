package com.tencent.mobileqq.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.util.TroopMemberUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class TroopMemberListActivity$40
  extends TroopObserver
{
  TroopMemberListActivity$40(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  protected void onDeleteTroopMember(boolean paramBoolean, int paramInt, ArrayList<String> paramArrayList)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDeleteTroopMember, isSuccess:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" errorCode:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("TroopMemberListActivityget_troop_member", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        this.a.mHasDeletedMember = true;
        localObject = paramArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          this.a.removeItem(str);
        }
        if (this.a.mFrom == 15) {
          TroopMemberListActivity.access$302(this.a, paramArrayList);
        }
        this.a.mHandler.sendMessage(this.a.mHandler.obtainMessage(6));
      }
    }
    else
    {
      if (paramInt == 2)
      {
        this.a.mHandler.sendMessage(this.a.mHandler.obtainMessage(15));
        return;
      }
      this.a.mHandler.sendMessage(this.a.mHandler.obtainMessage(7));
    }
  }
  
  protected void onOIDB0X899_0_Ret(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    if (!Utils.a(String.valueOf(paramLong1), this.a.mTroopUin)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(150);
      localStringBuilder.append("onOIDB0X899_0_Ret");
      localStringBuilder.append("| isSuccess = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("| troopuin = ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("| nFlag = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("| strErorMsg = ");
      localStringBuilder.append(paramString);
      QLog.i("TroopMemberListActivityget_troop_member", 2, localStringBuilder.toString());
    }
    if ((paramInt1 == 1) && (paramBoolean)) {
      ThreadManager.post(new TroopMemberListActivity.40.1(this, paramList), 5, null, true);
    }
    if ((paramInt1 == 2) && (paramBoolean)) {
      ThreadManager.post(new TroopMemberListActivity.40.2(this, paramList), 8, null, true);
    }
  }
  
  protected void onOIDB0X899_1_Ret(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    super.onOIDB0X899_1_Ret(paramBoolean, paramLong1, paramInt1, paramList, paramLong2, paramInt2, paramString);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("onOIDB0X899_1_Ret, isSuccess:");
      paramString.append(paramBoolean);
      paramString.append(" returnUin:");
      paramString.append(paramLong1);
      paramString.append(" mTroopUin:");
      paramString.append(this.a.mTroopUin);
      paramString.append(" time:");
      paramString.append((System.currentTimeMillis() - this.a.mTroopInfoReqStartTime) / 1000L);
      paramString.append("s");
      QLog.d("TroopMemberListActivityget_troop_member", 2, paramString.toString());
    }
    if (paramBoolean)
    {
      if (!this.a.mTroopUin.equals(Long.toString(paramLong1))) {
        return;
      }
      paramString = this.a;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("last_update_time");
      ((StringBuilder)localObject).append(this.a.app.getCurrentAccountUin());
      paramString = paramString.getSharedPreferences(((StringBuilder)localObject).toString(), 4).edit();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("key_troop_info_last_update");
      ((StringBuilder)localObject).append(this.a.mTroopUin);
      paramString.putLong(((StringBuilder)localObject).toString(), System.currentTimeMillis()).commit();
      if (this.a.mTroopInfo != null)
      {
        paramString = this.a;
        localObject = paramString.mTroopInfo;
        boolean bool = true;
        if ((localObject != null) && (this.a.mTroopInfo.isHomeworkTroop())) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        paramString.mIsHomeworkTroop = paramBoolean;
        if (this.a.mTroopInfo.troopowneruin != null)
        {
          paramString = this.a;
          paramString.mTroopOwnerUin = paramString.mTroopInfo.troopowneruin;
        }
        paramString = this.a;
        paramString.mTroopAdminUins = TroopMemberUtil.a(paramString.app, this.a.mTroopInfo, paramList, false);
        paramList = this.a;
        paramBoolean = bool;
        if (!paramList.app.getCurrentAccountUin().equals(this.a.mTroopInfo.troopowneruin)) {
          if ((this.a.mTroopAdminUins != null) && (this.a.mTroopAdminUins.contains(this.a.app.getCurrentAccountUin()))) {
            paramBoolean = bool;
          } else {
            paramBoolean = false;
          }
        }
        paramList.mIsTroopAdmin = paramBoolean;
        if ((this.a.mTroopOwnerUin != null) && (this.a.mTroopOwnerUin.equals(this.a.app.getCurrentAccountUin()))) {
          this.a.mMyTroopRole = "0";
        } else if ((this.a.mTroopAdminUins != null) && (this.a.mTroopAdminUins.contains(this.a.app.getCurrentAccountUin()))) {
          this.a.mMyTroopRole = "1";
        }
        this.a.mHandler.sendMessage(this.a.mHandler.obtainMessage(9));
      }
    }
  }
  
  protected void onUpdateTroopGetMemberList(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    if (!this.a.mTroopUin.equals(paramString))
    {
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("onUpdateTroopGetMemberList,!mTroopUin.equals(troopUin)==>mTroopUin:");
        paramList.append(this.a.mTroopUin);
        paramList.append("|troopUin:");
        paramList.append(paramString);
        QLog.e("TroopMemberListActivityget_troop_member", 2, paramList.toString());
      }
      return;
    }
    paramInt2 = TroopMemberListActivity.access$3100(this.a);
    if (paramInt2 != paramInt1)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("onUpdateTroopGetMemberList,realReqType != reqType, realReqType:");
        paramString.append(paramInt2);
        paramString.append("|reqType:");
        paramString.append(paramInt1);
        QLog.e("TroopMemberListActivityget_troop_member", 2, paramString.toString());
      }
      return;
    }
    if (this.a.mMemberListReqStartTime != paramLong)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("onUpdateTroopGetMemberList,mMemberListReqStartTime != reqTimestamp, mMemberListReqStartTime:");
        paramString.append(this.a.mMemberListReqStartTime);
        paramString.append("|reqTimestamp:");
        paramString.append(paramLong);
        QLog.e("TroopMemberListActivityget_troop_member", 2, paramString.toString());
      }
      return;
    }
    paramLong = System.currentTimeMillis();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Thread id:");
      localStringBuilder.append(Thread.currentThread().getId());
      localStringBuilder.append(",threadName:");
      localStringBuilder.append(Thread.currentThread().getName());
      localStringBuilder.append("|onUpdateTroopGetMemberList:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("|troopMemberInfoList size:");
      if (paramList == null) {
        paramString = "";
      } else {
        paramString = Integer.valueOf(paramList.size());
      }
      localStringBuilder.append(paramString);
      localStringBuilder.append("|time:");
      localStringBuilder.append((paramLong - this.a.mMemberListReqStartTime) / 1000L);
      localStringBuilder.append("s");
      QLog.d("TroopMemberListActivityget_troop_member", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      try
      {
        paramString = this.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("last_update_time");
        localStringBuilder.append(this.a.app.getCurrentAccountUin());
        paramString = paramString.getSharedPreferences(localStringBuilder.toString(), 4).edit();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("key_last_update_time");
        localStringBuilder.append(this.a.mTroopUin);
        paramString.putLong(localStringBuilder.toString(), System.currentTimeMillis()).commit();
        this.a.mHandler.removeMessages(1);
        if ((this.a.mFrom != 13) && (this.a.mFrom != 21))
        {
          this.a.getTroopMemberFromDBIfNeeded(this.a.mTroopUin, paramList);
        }
        else
        {
          paramString = this.a.getMemberListFromUins(this.a.mTroopUin, this.a.mMemberUins);
          this.a.mHandler.sendMessage(this.a.mHandler.obtainMessage(2, paramString));
        }
        this.a.mHandler.sendMessage(this.a.mHandler.obtainMessage(5, Boolean.valueOf(paramBoolean)));
        return;
      }
      catch (Exception paramString)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      paramList = new StringBuilder();
      paramList.append("onUpdateTroopGetMemberList:");
      paramList.append(paramString.toString());
      QLog.d("TroopMemberListActivityget_troop_member", 2, paramList.toString());
    }
    else
    {
      if ((this.a.mFrom != 13) && (this.a.mFrom != 21))
      {
        paramString = this.a;
        paramString.getTroopMemberFromDBIfNeeded(paramString.mTroopUin, null);
      }
      else
      {
        paramString = this.a;
        paramString = paramString.getMemberListFromUins(paramString.mTroopUin, this.a.mMemberUins);
        this.a.mHandler.sendMessage(this.a.mHandler.obtainMessage(2, paramString));
      }
      this.a.mHandler.sendMessage(this.a.mHandler.obtainMessage(5, Boolean.valueOf(paramBoolean)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.40
 * JD-Core Version:    0.7.0.1
 */