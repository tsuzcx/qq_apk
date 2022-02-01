package com.tencent.mobileqq.adapter;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.newfriend.msg.FriendSystemMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.app.FriendListHandler.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.QLog;
import friendlist.EAddFriendSourceID;
import java.util.ArrayList;
import java.util.Iterator;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

class NewFriendMoreSysMsgAdapter$7
  extends FriendListObserver
{
  NewFriendMoreSysMsgAdapter$7(NewFriendMoreSysMsgAdapter paramNewFriendMoreSysMsgAdapter) {}
  
  public void onAddBatchPhoneFriend(boolean paramBoolean, ArrayList<FriendListHandler.AddBatchPhoneFriendResult> paramArrayList)
  {
    if (paramBoolean) {
      NewFriendMoreSysMsgAdapter.c(this.a);
    }
  }
  
  public void onAddFriend(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = (ArrayList)NewFriendMoreSysMsgAdapter.a(this.a).clone();
    } while (localArrayList.isEmpty());
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (NewFriendMessage)localIterator.next();
      if ((localObject instanceof FriendSystemMessage))
      {
        localObject = (FriendSystemMessage)localObject;
        int i = ((FriendSystemMessage)localObject).a.structMsg.msg.sub_type.get();
        localObject = ((FriendSystemMessage)localObject).a.senderuin;
        if ((i == 13) && (paramString.equals(localObject))) {
          localIterator.remove();
        }
      }
    }
    NewFriendMoreSysMsgAdapter.a(this.a, localArrayList);
    this.a.notifyDataSetChanged();
  }
  
  public void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean) {
      this.a.notifyDataSetChanged();
    }
  }
  
  public void onSuspiciousGetUnreadNum(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendMoreSysMsgAdapter", 2, "onSuspiciousGetUnreadNum " + paramBoolean + " " + paramInt1 + " " + paramInt2);
    }
    if ((NewFriendMoreSysMsgAdapter.a(this.a) != null) && (NewFriendMoreSysMsgAdapter.a(this.a).getVisibility() == 0))
    {
      if ((paramBoolean) && (paramInt2 > 0)) {
        NewFriendMoreSysMsgAdapter.a(this.a).setText(paramInt2 + "");
      }
    }
    else {
      return;
    }
    NewFriendMoreSysMsgAdapter.a(this.a).setText("");
  }
  
  public void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if ((paramBoolean1) && (EAddFriendSourceID.a(paramBundle.getInt("source_id")))) {
      NewFriendMoreSysMsgAdapter.c(this.a);
    }
  }
  
  public void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.NewFriendMoreSysMsgAdapter.7
 * JD-Core Version:    0.7.0.1
 */