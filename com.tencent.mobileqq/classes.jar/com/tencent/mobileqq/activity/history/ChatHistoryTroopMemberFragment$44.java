package com.tencent.mobileqq.activity.history;

import android.os.Handler;
import com.tencent.mobileqq.activity.history.helper.TroopMemberAddFrdHelper;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.observer.TroopFeeObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x406.cmd0x406.GroupFeeMember;

class ChatHistoryTroopMemberFragment$44
  extends TroopFeeObserver
{
  ChatHistoryTroopMemberFragment$44(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  protected void a(boolean paramBoolean, List<cmd0x406.GroupFeeMember> paramList)
  {
    if (!paramBoolean)
    {
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("onGetTroopFeeMemberList : isSuccess=");
        paramList.append(paramBoolean);
        QLog.d("Q.history.BaseFragment.troop.troop_fee", 2, paramList.toString());
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      cmd0x406.GroupFeeMember localGroupFeeMember = (cmd0x406.GroupFeeMember)localIterator.next();
      ChatHistoryTroopMemberFragment.ATroopMember localATroopMember = new ChatHistoryTroopMemberFragment.ATroopMember();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localGroupFeeMember.uint64_uin.get());
      localStringBuilder.append("");
      localATroopMember.a = localStringBuilder.toString();
      localATroopMember.b = localGroupFeeMember.string_nick_name.get();
      if (this.a.a != null) {
        this.a.a.a(localATroopMember);
      }
      localArrayList.add(localATroopMember);
    }
    this.a.c = paramList.size();
    this.a.b.sendMessage(this.a.b.obtainMessage(1, new Object[] { localArrayList }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.44
 * JD-Core Version:    0.7.0.1
 */