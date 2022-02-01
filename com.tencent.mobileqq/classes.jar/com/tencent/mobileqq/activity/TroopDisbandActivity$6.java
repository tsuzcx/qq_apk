package com.tencent.mobileqq.activity;

import android.content.Intent;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQProgressNotifier;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class TroopDisbandActivity$6
  extends TroopObserver
{
  TroopDisbandActivity$6(TroopDisbandActivity paramTroopDisbandActivity) {}
  
  protected void onGetMutilTroopInfoResult(boolean paramBoolean, ArrayList<TroopInfo> paramArrayList)
  {
    if ((paramBoolean) && (paramArrayList != null))
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      TroopInfo localTroopInfo = null;
      int i = 0;
      while ((localTroopInfo == null) && (i < paramArrayList.size()))
      {
        localTroopInfo = (TroopInfo)paramArrayList.get(i);
        if ((localTroopInfo != null) && (Utils.a(localTroopInfo.troopuin, this.a.k)))
        {
          paramArrayList = this.a;
          paramArrayList.j = localTroopInfo;
          paramArrayList.a(localTroopInfo, false);
          return;
        }
        i += 1;
      }
    }
  }
  
  protected void onGetTroopInfoResult(boolean paramBoolean, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onGetTroopInfoResult, isSuc=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", groupUin : ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("Q.troopdisband.disband", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramBoolean) && (Utils.a(paramString, this.a.k)))
    {
      paramString = (TroopManager)this.a.app.getManager(QQManagerFactory.TROOP_MANAGER);
      localObject = this.a;
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = paramString.f(((TroopDisbandActivity)localObject).k);
      }
      ((TroopDisbandActivity)localObject).j = paramString;
      paramString = this.a;
      paramString.a(paramString.j, false);
    }
  }
  
  protected void onOIDB0X899_0_Ret(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    if (!Utils.a(String.valueOf(paramLong1), this.a.k)) {
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder(150);
      ((StringBuilder)localObject).append("onOIDB0X899_0_Ret");
      ((StringBuilder)localObject).append("| isSuccess = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("| troopuin = ");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append("| nFlag = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("| strErorMsg = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("Q.troopdisband.disband", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt1 != 4)
    {
      if (paramInt1 != 5) {
        return;
      }
      if (paramBoolean)
      {
        if (paramList == null) {
          paramInt1 = 0;
        } else {
          paramInt1 = paramList.size();
        }
        if ((paramInt1 > 0) && (paramInt1 < 6))
        {
          paramString = (TroopManager)this.a.app.getManager(QQManagerFactory.TROOP_MANAGER);
          localObject = this.a;
          if (paramString == null) {
            paramString = null;
          } else {
            paramString = paramString.f(((TroopDisbandActivity)localObject).k);
          }
          ((TroopDisbandActivity)localObject).j = paramString;
          if ((this.a.j != null) && (this.a.j.wMemberNum != paramInt1)) {
            this.a.j.wMemberNum = paramList.size();
          }
          paramString = this.a;
          paramString.a(paramString.j, false);
        }
        this.a.q.b(paramList);
      }
    }
    else
    {
      if (paramBoolean)
      {
        if (paramList == null) {
          paramInt1 = 0;
        } else {
          paramInt1 = paramList.size();
        }
        paramInt2 = 0;
        while (paramInt2 < paramInt1)
        {
          localObject = (oidb_0x899.memberlist)paramList.get(paramInt2);
          if ((localObject != null) && (((oidb_0x899.memberlist)localObject).uint64_member_uin.has()))
          {
            paramString = String.valueOf(((oidb_0x899.memberlist)localObject).uint64_member_uin.get());
            if ((!this.a.u.contains(paramString)) && (paramString != null) && (!"".equals(paramString.trim())) && (!Utils.a(this.a.v, paramString)))
            {
              int i;
              if (((oidb_0x899.memberlist)localObject).uint32_uin_flag.has()) {
                i = ((oidb_0x899.memberlist)localObject).uint32_uin_flag.get();
              } else {
                i = 0;
              }
              localObject = this.a.u;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(paramString);
              localStringBuilder.append("|");
              localStringBuilder.append(String.valueOf(i));
              ((ArrayList)localObject).add(localStringBuilder.toString());
            }
          }
          paramInt2 += 1;
        }
      }
      if (this.a.u.size() > 0)
      {
        paramList = (ITroopMemberListHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER);
        if ((paramList != null) && (paramBoolean) && (paramLong2 > 0L) && (this.a.t == 0L))
        {
          paramString = this.a;
          paramString.t = paramLong2;
          paramList.a(paramLong1, paramString.t, 4, 0, 0);
          if (QLog.isColorLevel()) {
            QLog.i("Q.troopdisband.", 2, "handle_oidb_0x899_0|need get another package");
          }
        }
        else
        {
          if (this.a.w != null) {
            this.a.w.b();
          }
          paramList = this.a;
          paramList.p &= 0xFFFFFFFD;
          paramList = new Intent(this.a, TroopTransferActivity.class);
          paramList.putExtra("leftViewText", this.a.getString(2131914219));
          paramList.putExtra("TROOP_INFO_FLAG_EXT", this.a.n);
          paramList.putExtra("troop_auth_submit_time", this.a.o);
          paramList.putStringArrayListExtra("troopVipMembers", this.a.u);
          paramList.putExtra("troop_uin", this.a.k);
          paramList.putExtra("troop_code", this.a.m);
          paramList.putExtra("uinname", this.a.l);
          this.a.startActivityForResult(paramList, 0);
        }
      }
      else
      {
        if (paramBoolean)
        {
          paramList = this.a;
          paramList.p &= 0xFFFFFFFD;
          if (this.a.w == null)
          {
            paramList = this.a;
            paramList.w = new QQProgressNotifier(paramList);
          }
          this.a.w.b(2, 2131917430, 1500);
          return;
        }
        paramList = this.a;
        paramList.p &= 0xFFFFFFFD;
        if (this.a.w == null)
        {
          paramList = this.a;
          paramList.w = new QQProgressNotifier(paramList);
        }
        this.a.w.b(2, 2131917425, 1500);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopDisbandActivity.6
 * JD-Core Version:    0.7.0.1
 */