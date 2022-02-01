package com.tencent.mobileqq.activity.history;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
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

class ChatHistoryTroopMemberFragment$41
  extends TroopObserver
{
  ChatHistoryTroopMemberFragment$41(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
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
      QLog.d("Q.history.BaseFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        this.a.bf = true;
        localObject = paramArrayList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          this.a.d(str);
        }
        if (this.a.az == 15) {
          ChatHistoryTroopMemberFragment.a(this.a, paramArrayList);
        }
        this.a.bn.sendMessage(this.a.bn.obtainMessage(6));
      }
    }
    else
    {
      if (paramInt == 2)
      {
        this.a.bn.sendMessage(this.a.bn.obtainMessage(15));
        return;
      }
      this.a.bn.sendMessage(this.a.bn.obtainMessage(7));
    }
  }
  
  protected void onOIDB0X899_0_Ret(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString)
  {
    if (!Utils.a(String.valueOf(paramLong1), this.a.w)) {
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
      QLog.i("Q.history.BaseFragment", 2, localStringBuilder.toString());
    }
    if ((paramInt1 == 1) && (paramBoolean)) {
      ThreadManager.post(new ChatHistoryTroopMemberFragment.41.1(this, paramList), 5, null, true);
    }
    if ((paramInt1 == 2) && (paramBoolean)) {
      ThreadManager.post(new ChatHistoryTroopMemberFragment.41.2(this, paramList), 8, null, true);
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
      paramString.append(this.a.w);
      paramString.append(" time:");
      paramString.append((System.currentTimeMillis() - this.a.aJ) / 1000L);
      paramString.append("s");
      QLog.d("Q.history.BaseFragment", 2, paramString.toString());
    }
    if (paramBoolean)
    {
      if (!this.a.w.equals(Long.toString(paramLong1))) {
        return;
      }
      paramString = this.a.getActivity();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("last_update_time");
      ((StringBuilder)localObject).append(this.a.bc.getCurrentAccountUin());
      paramString = paramString.getSharedPreferences(((StringBuilder)localObject).toString(), 4).edit();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("key_troop_info_last_update");
      ((StringBuilder)localObject).append(this.a.w);
      paramString.putLong(((StringBuilder)localObject).toString(), System.currentTimeMillis()).commit();
      if (this.a.ai != null)
      {
        paramString = this.a;
        localObject = paramString.ai;
        boolean bool = true;
        if ((localObject != null) && (this.a.ai.isHomeworkTroop())) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        paramString.u = paramBoolean;
        if (this.a.ai.troopowneruin != null)
        {
          paramString = this.a;
          paramString.C = paramString.ai.troopowneruin;
        }
        paramString = this.a;
        paramString.D = TroopMemberUtil.a(paramString.bc, this.a.ai, paramList, false);
        paramList = this.a;
        paramBoolean = bool;
        if (!paramList.bc.getCurrentAccountUin().equals(this.a.ai.troopowneruin)) {
          if ((this.a.D != null) && (this.a.D.contains(this.a.bc.getCurrentAccountUin()))) {
            paramBoolean = bool;
          } else {
            paramBoolean = false;
          }
        }
        paramList.t = paramBoolean;
        if ((this.a.C != null) && (this.a.C.equals(this.a.bc.getCurrentAccountUin()))) {
          this.a.aK = "0";
        } else if ((this.a.D != null) && (this.a.D.contains(this.a.bc.getCurrentAccountUin()))) {
          this.a.aK = "1";
        }
        this.a.bn.sendMessage(this.a.bn.obtainMessage(9));
      }
    }
  }
  
  protected void onUpdateTroopGetMemberList(String paramString, boolean paramBoolean, List<TroopMemberInfo> paramList, int paramInt1, long paramLong, int paramInt2)
  {
    if (!this.a.w.equals(paramString))
    {
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("onUpdateTroopGetMemberList,!mTroopUin.equals(troopUin)==>mTroopUin:");
        paramList.append(this.a.w);
        paramList.append("|troopUin:");
        paramList.append(paramString);
        QLog.e("Q.history.BaseFragment", 2, paramList.toString());
      }
      return;
    }
    paramInt2 = ChatHistoryTroopMemberFragment.y(this.a);
    if (paramInt2 != paramInt1)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("onUpdateTroopGetMemberList,realReqType != reqType, realReqType:");
        paramString.append(paramInt2);
        paramString.append("|reqType:");
        paramString.append(paramInt1);
        QLog.e("Q.history.BaseFragment", 2, paramString.toString());
      }
      return;
    }
    if (this.a.aI != paramLong)
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("onUpdateTroopGetMemberList,mMemberListReqStartTime != reqTimestamp, mMemberListReqStartTime:");
        paramString.append(this.a.aI);
        paramString.append("|reqTimestamp:");
        paramString.append(paramLong);
        QLog.e("Q.history.BaseFragment", 2, paramString.toString());
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
      localStringBuilder.append((paramLong - this.a.aI) / 1000L);
      localStringBuilder.append("s");
      QLog.d("Q.history.BaseFragment", 2, localStringBuilder.toString());
    }
    if (paramBoolean)
    {
      try
      {
        paramString = this.a.getActivity();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("last_update_time");
        localStringBuilder.append(this.a.bc.getCurrentAccountUin());
        paramString = paramString.getSharedPreferences(localStringBuilder.toString(), 4).edit();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("key_last_update_time");
        localStringBuilder.append(this.a.w);
        paramString.putLong(localStringBuilder.toString(), System.currentTimeMillis()).commit();
        this.a.bn.removeMessages(1);
        if ((this.a.az != 13) && (this.a.az != 21))
        {
          this.a.b(this.a.w, paramList);
        }
        else
        {
          paramString = this.a.a(this.a.w, this.a.at);
          this.a.bn.sendMessage(this.a.bn.obtainMessage(2, paramString));
        }
        this.a.bn.sendMessage(this.a.bn.obtainMessage(5, Boolean.valueOf(paramBoolean)));
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
      QLog.d("Q.history.BaseFragment", 2, paramList.toString());
    }
    else
    {
      if ((this.a.az != 13) && (this.a.az != 21))
      {
        paramString = this.a;
        paramString.b(paramString.w, null);
      }
      else
      {
        paramString = this.a;
        paramString = paramString.a(paramString.w, this.a.at);
        this.a.bn.sendMessage(this.a.bn.obtainMessage(2, paramString));
      }
      this.a.bn.sendMessage(this.a.bn.obtainMessage(5, Boolean.valueOf(paramBoolean)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.41
 * JD-Core Version:    0.7.0.1
 */