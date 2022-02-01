package com.tencent.mobileqq.activity;

import android.os.Handler;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.memberlist.AddFrdHelper;
import com.tencent.mobileqq.troop.observer.TroopFeeObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x406.cmd0x406.GroupFeeMember;

class TroopMemberListActivity$43
  extends TroopFeeObserver
{
  TroopMemberListActivity$43(TroopMemberListActivity paramTroopMemberListActivity) {}
  
  protected void a(boolean paramBoolean, List<cmd0x406.GroupFeeMember> paramList)
  {
    if (!paramBoolean)
    {
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("onGetTroopFeeMemberList : isSuccess=");
        paramList.append(paramBoolean);
        QLog.d("TroopMemberListActivityget_troop_member.troop.troop_fee", 2, paramList.toString());
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      cmd0x406.GroupFeeMember localGroupFeeMember = (cmd0x406.GroupFeeMember)localIterator.next();
      TroopMemberListActivity.ATroopMember localATroopMember = new TroopMemberListActivity.ATroopMember();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localGroupFeeMember.uint64_uin.get());
      localStringBuilder.append("");
      localATroopMember.a = localStringBuilder.toString();
      localATroopMember.b = localGroupFeeMember.string_nick_name.get();
      if (this.a.mAddFrdHelper != null) {
        this.a.mAddFrdHelper.a(localATroopMember);
      }
      localArrayList.add(localATroopMember);
    }
    this.a.mTroopFeeMemberCount = paramList.size();
    this.a.mHandler.sendMessage(this.a.mHandler.obtainMessage(1, new Object[] { localArrayList }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.43
 * JD-Core Version:    0.7.0.1
 */